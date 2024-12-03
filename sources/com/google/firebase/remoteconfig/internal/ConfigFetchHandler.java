package com.google.firebase.remoteconfig.internal;

import android.text.format.DateUtils;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchThrottledException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.withpersona.sdk2.inquiry.network.HttpStatusCode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import me.f;

public class ConfigFetchHandler {
    static final int[] BACKOFF_TIME_DURATIONS_IN_MINUTES = {2, 4, 8, 16, 32, 64, 128, 256};
    public static final long DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS = TimeUnit.HOURS.toSeconds(12);
    static final String FIRST_OPEN_TIME_KEY = "_fot";
    static final int HTTP_TOO_MANY_REQUESTS = 429;
    private static final String X_FIREBASE_RC_FETCH_TYPE = "X-Firebase-RC-Fetch-Type";
    private final Provider<AnalyticsConnector> analyticsConnector;
    private final f clock;
    private final Map<String, String> customHttpHeaders;
    private final Executor executor;
    private final ConfigCacheClient fetchedConfigsCache;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final ConfigFetchHttpClient frcBackendApiClient;
    private final ConfigMetadataClient frcMetadata;
    private final Random randomGenerator;

    public static class FetchResponse {
        private final Date fetchTime;
        private final ConfigContainer fetchedConfigs;
        private final String lastFetchETag;
        private final int status;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Status {
            public static final int BACKEND_HAS_NO_UPDATES = 1;
            public static final int BACKEND_UPDATES_FETCHED = 0;
            public static final int LOCAL_STORAGE_USED = 2;
        }

        private FetchResponse(Date date, int i10, ConfigContainer configContainer, String str) {
            this.fetchTime = date;
            this.status = i10;
            this.fetchedConfigs = configContainer;
            this.lastFetchETag = str;
        }

        public static FetchResponse forBackendHasNoUpdates(Date date, ConfigContainer configContainer) {
            return new FetchResponse(date, 1, configContainer, (String) null);
        }

        public static FetchResponse forBackendUpdatesFetched(ConfigContainer configContainer, String str) {
            return new FetchResponse(configContainer.getFetchTime(), 0, configContainer, str);
        }

        public static FetchResponse forLocalStorageUsed(Date date) {
            return new FetchResponse(date, 2, (ConfigContainer) null, (String) null);
        }

        /* access modifiers changed from: package-private */
        public Date getFetchTime() {
            return this.fetchTime;
        }

        public ConfigContainer getFetchedConfigs() {
            return this.fetchedConfigs;
        }

        /* access modifiers changed from: package-private */
        public String getLastFetchETag() {
            return this.lastFetchETag;
        }

        /* access modifiers changed from: package-private */
        public int getStatus() {
            return this.status;
        }
    }

    public enum FetchType {
        BASE("BASE"),
        REALTIME("REALTIME");
        
        private final String value;

        private FetchType(String str) {
            this.value = str;
        }

        /* access modifiers changed from: package-private */
        public String getValue() {
            return this.value;
        }
    }

    public ConfigFetchHandler(FirebaseInstallationsApi firebaseInstallationsApi, Provider<AnalyticsConnector> provider, Executor executor2, f fVar, Random random, ConfigCacheClient configCacheClient, ConfigFetchHttpClient configFetchHttpClient, ConfigMetadataClient configMetadataClient, Map<String, String> map) {
        this.firebaseInstallations = firebaseInstallationsApi;
        this.analyticsConnector = provider;
        this.executor = executor2;
        this.clock = fVar;
        this.randomGenerator = random;
        this.fetchedConfigsCache = configCacheClient;
        this.frcBackendApiClient = configFetchHttpClient;
        this.frcMetadata = configMetadataClient;
        this.customHttpHeaders = map;
    }

    private boolean areCachedFetchConfigsValid(long j10, Date date) {
        Date lastSuccessfulFetchTime = this.frcMetadata.getLastSuccessfulFetchTime();
        if (lastSuccessfulFetchTime.equals(ConfigMetadataClient.LAST_FETCH_TIME_NO_FETCH_YET)) {
            return false;
        }
        return date.before(new Date(lastSuccessfulFetchTime.getTime() + TimeUnit.SECONDS.toMillis(j10)));
    }

    private FirebaseRemoteConfigServerException createExceptionWithGenericMessage(FirebaseRemoteConfigServerException firebaseRemoteConfigServerException) throws FirebaseRemoteConfigClientException {
        String str;
        int httpStatusCode = firebaseRemoteConfigServerException.getHttpStatusCode();
        if (httpStatusCode == 401) {
            str = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
        } else if (httpStatusCode == 403) {
            str = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
        } else if (httpStatusCode == HTTP_TOO_MANY_REQUESTS) {
            throw new FirebaseRemoteConfigClientException("The throttled response from the server was not handled correctly by the FRC SDK.");
        } else if (httpStatusCode != 500) {
            switch (httpStatusCode) {
                case HttpStatusCode.BAD_GATEWAY_502 /*502*/:
                case 503:
                case 504:
                    str = "The server is unavailable. Please try again later.";
                    break;
                default:
                    str = "The server returned an unexpected error.";
                    break;
            }
        } else {
            str = "There was an internal server error.";
        }
        int httpStatusCode2 = firebaseRemoteConfigServerException.getHttpStatusCode();
        return new FirebaseRemoteConfigServerException(httpStatusCode2, "Fetch failed: " + str, (Throwable) firebaseRemoteConfigServerException);
    }

    private String createThrottledMessage(long j10) {
        return String.format("Fetch is throttled. Please wait before calling fetch again: %s", new Object[]{DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(j10))});
    }

    private FetchResponse fetchFromBackend(String str, String str2, Date date, Map<String, String> map) throws FirebaseRemoteConfigException {
        try {
            FetchResponse fetch = this.frcBackendApiClient.fetch(this.frcBackendApiClient.createHttpURLConnection(), str, str2, getUserProperties(), this.frcMetadata.getLastFetchETag(), map, getFirstOpenTime(), date);
            if (fetch.getFetchedConfigs() != null) {
                this.frcMetadata.setLastTemplateVersion(fetch.getFetchedConfigs().getTemplateVersionNumber());
            }
            if (fetch.getLastFetchETag() != null) {
                this.frcMetadata.setLastFetchETag(fetch.getLastFetchETag());
            }
            this.frcMetadata.resetBackoff();
            return fetch;
        } catch (FirebaseRemoteConfigServerException e10) {
            ConfigMetadataClient.BackoffMetadata updateAndReturnBackoffMetadata = updateAndReturnBackoffMetadata(e10.getHttpStatusCode(), date);
            if (shouldThrottle(updateAndReturnBackoffMetadata, e10.getHttpStatusCode())) {
                throw new FirebaseRemoteConfigFetchThrottledException(updateAndReturnBackoffMetadata.getBackoffEndTime().getTime());
            }
            throw createExceptionWithGenericMessage(e10);
        }
    }

    private Task<FetchResponse> fetchFromBackendAndCacheResponse(String str, String str2, Date date, Map<String, String> map) {
        try {
            FetchResponse fetchFromBackend = fetchFromBackend(str, str2, date, map);
            if (fetchFromBackend.getStatus() != 0) {
                return Tasks.forResult(fetchFromBackend);
            }
            return this.fetchedConfigsCache.put(fetchFromBackend.getFetchedConfigs()).onSuccessTask(this.executor, new e(fetchFromBackend));
        } catch (FirebaseRemoteConfigException e10) {
            return Tasks.forException(e10);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: fetchIfCacheExpiredAndNotThrottled */
    public Task<FetchResponse> lambda$fetch$0(Task<ConfigContainer> task, long j10, Map<String, String> map) {
        Task<TContinuationResult> task2;
        Date date = new Date(this.clock.currentTimeMillis());
        if (task.isSuccessful() && areCachedFetchConfigsValid(j10, date)) {
            return Tasks.forResult(FetchResponse.forLocalStorageUsed(date));
        }
        Date backoffEndTimeInMillis = getBackoffEndTimeInMillis(date);
        if (backoffEndTimeInMillis != null) {
            task2 = Tasks.forException(new FirebaseRemoteConfigFetchThrottledException(createThrottledMessage(backoffEndTimeInMillis.getTime() - date.getTime()), backoffEndTimeInMillis.getTime()));
        } else {
            Task<String> id2 = this.firebaseInstallations.getId();
            Task<InstallationTokenResult> token = this.firebaseInstallations.getToken(false);
            task2 = Tasks.whenAllComplete((Task<?>[]) new Task[]{id2, token}).continueWithTask(this.executor, new g(this, id2, token, date, map));
        }
        return task2.continueWithTask(this.executor, new h(this, date));
    }

    private Date getBackoffEndTimeInMillis(Date date) {
        Date backoffEndTime = this.frcMetadata.getBackoffMetadata().getBackoffEndTime();
        if (date.before(backoffEndTime)) {
            return backoffEndTime;
        }
        return null;
    }

    private Long getFirstOpenTime() {
        AnalyticsConnector analyticsConnector2 = this.analyticsConnector.get();
        if (analyticsConnector2 == null) {
            return null;
        }
        return (Long) analyticsConnector2.getUserProperties(true).get(FIRST_OPEN_TIME_KEY);
    }

    private long getRandomizedBackoffDurationInMillis(int i10) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        int[] iArr = BACKOFF_TIME_DURATIONS_IN_MINUTES;
        long millis = timeUnit.toMillis((long) iArr[Math.min(i10, iArr.length) - 1]);
        return (millis / 2) + ((long) this.randomGenerator.nextInt((int) millis));
    }

    private Map<String, String> getUserProperties() {
        HashMap hashMap = new HashMap();
        AnalyticsConnector analyticsConnector2 = this.analyticsConnector.get();
        if (analyticsConnector2 == null) {
            return hashMap;
        }
        for (Map.Entry next : analyticsConnector2.getUserProperties(false).entrySet()) {
            hashMap.put((String) next.getKey(), next.getValue().toString());
        }
        return hashMap;
    }

    private boolean isThrottleableServerError(int i10) {
        return i10 == HTTP_TOO_MANY_REQUESTS || i10 == 502 || i10 == 503 || i10 == 504;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$fetchIfCacheExpiredAndNotThrottled$2(Task task, Task task2, Date date, Map map, Task task3) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for fetch.", (Throwable) task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for fetch.", (Throwable) task2.getException()));
        }
        return fetchFromBackendAndCacheResponse((String) task.getResult(), ((InstallationTokenResult) task2.getResult()).getToken(), date, map);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$fetchIfCacheExpiredAndNotThrottled$3(Date date, Task task) throws Exception {
        updateLastFetchStatusAndTime(task, date);
        return task;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$fetchNowWithTypeAndAttemptNumber$1(Map map, Task task) throws Exception {
        return lambda$fetch$0(task, 0, map);
    }

    private boolean shouldThrottle(ConfigMetadataClient.BackoffMetadata backoffMetadata, int i10) {
        return backoffMetadata.getNumFailedFetches() > 1 || i10 == HTTP_TOO_MANY_REQUESTS;
    }

    private ConfigMetadataClient.BackoffMetadata updateAndReturnBackoffMetadata(int i10, Date date) {
        if (isThrottleableServerError(i10)) {
            updateBackoffMetadataWithLastFailedFetchTime(date);
        }
        return this.frcMetadata.getBackoffMetadata();
    }

    private void updateBackoffMetadataWithLastFailedFetchTime(Date date) {
        int numFailedFetches = this.frcMetadata.getBackoffMetadata().getNumFailedFetches() + 1;
        this.frcMetadata.setBackoffMetadata(numFailedFetches, new Date(date.getTime() + getRandomizedBackoffDurationInMillis(numFailedFetches)));
    }

    private void updateLastFetchStatusAndTime(Task<FetchResponse> task, Date date) {
        if (task.isSuccessful()) {
            this.frcMetadata.updateLastFetchAsSuccessfulAt(date);
            return;
        }
        Exception exception = task.getException();
        if (exception != null) {
            if (exception instanceof FirebaseRemoteConfigFetchThrottledException) {
                this.frcMetadata.updateLastFetchAsThrottled();
            } else {
                this.frcMetadata.updateLastFetchAsFailed();
            }
        }
    }

    public Task<FetchResponse> fetch() {
        return fetch(this.frcMetadata.getMinimumFetchIntervalInSeconds());
    }

    public Task<FetchResponse> fetchNowWithTypeAndAttemptNumber(FetchType fetchType, int i10) {
        HashMap hashMap = new HashMap(this.customHttpHeaders);
        hashMap.put(X_FIREBASE_RC_FETCH_TYPE, fetchType.getValue() + RemoteSettings.FORWARD_SLASH_STRING + i10);
        return this.fetchedConfigsCache.get().continueWithTask(this.executor, new i(this, hashMap));
    }

    public Provider<AnalyticsConnector> getAnalyticsConnector() {
        return this.analyticsConnector;
    }

    public long getTemplateVersionNumber() {
        return this.frcMetadata.getLastTemplateVersion();
    }

    public Task<FetchResponse> fetch(long j10) {
        HashMap hashMap = new HashMap(this.customHttpHeaders);
        hashMap.put(X_FIREBASE_RC_FETCH_TYPE, FetchType.BASE.getValue() + RemoteSettings.FORWARD_SLASH_STRING + 1);
        return this.fetchedConfigsCache.get().continueWithTask(this.executor, new f(this, j10, hashMap));
    }
}
