package com.google.firebase.remoteconfig.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.facebook.internal.ServerProtocol;
import com.facebook.stetho.server.http.HttpHeaders;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.remoteconfig.BuildConfig;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.a;
import me.f;
import me.i;
import me.k;
import org.json.b;

public class ConfigRealtimeHttpClient {
    private static final String API_KEY_HEADER = "X-Goog-Api-Key";
    static final int[] BACKOFF_TIME_DURATIONS_IN_MINUTES = {2, 4, 8, 16, 32, 64, 128, 256};
    private static final Pattern GMP_APP_ID_PATTERN = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");
    private static final String INSTALLATIONS_AUTH_TOKEN_HEADER = "X-Goog-Firebase-Installations-Auth";
    private static final String X_ACCEPT_RESPONSE_STREAMING = "X-Accept-Response-Streaming";
    private static final String X_ANDROID_CERT_HEADER = "X-Android-Cert";
    private static final String X_ANDROID_PACKAGE_HEADER = "X-Android-Package";
    private static final String X_GOOGLE_GFE_CAN_RETRY = "X-Google-GFE-Can-Retry";
    private final int ORIGINAL_RETRIES = 8;
    ConfigCacheClient activatedCache;
    private final f clock;
    private final ConfigFetchHandler configFetchHandler;
    private final Context context;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private int httpRetriesRemaining;
    private boolean isHttpConnectionRunning;
    private boolean isInBackground;
    private boolean isRealtimeDisabled;
    private final Set<ConfigUpdateListener> listeners;
    private final ConfigMetadataClient metadataClient;
    private final String namespace;
    private final Random random;
    private final ScheduledExecutorService scheduledExecutorService;

    public ConfigRealtimeHttpClient(FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi, ConfigFetchHandler configFetchHandler2, ConfigCacheClient configCacheClient, Context context2, String str, Set<ConfigUpdateListener> set, ConfigMetadataClient configMetadataClient, ScheduledExecutorService scheduledExecutorService2) {
        this.listeners = set;
        this.isHttpConnectionRunning = false;
        this.scheduledExecutorService = scheduledExecutorService2;
        this.random = new Random();
        this.httpRetriesRemaining = Math.max(8 - configMetadataClient.getRealtimeBackoffMetadata().getNumFailedStreams(), 1);
        this.clock = i.c();
        this.firebaseApp = firebaseApp2;
        this.configFetchHandler = configFetchHandler2;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.activatedCache = configCacheClient;
        this.context = context2;
        this.namespace = str;
        this.metadataClient = configMetadataClient;
        this.isRealtimeDisabled = false;
        this.isInBackground = false;
    }

    private synchronized boolean canMakeHttpStreamConnection() {
        return !this.listeners.isEmpty() && !this.isHttpConnectionRunning && !this.isRealtimeDisabled && !this.isInBackground;
    }

    private b createRequestBody(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("project", extractProjectNumberFromAppId(this.firebaseApp.getOptions().getApplicationId()));
        hashMap.put("namespace", this.namespace);
        hashMap.put("lastKnownVersionNumber", Long.toString(this.configFetchHandler.getTemplateVersionNumber()));
        hashMap.put("appId", this.firebaseApp.getOptions().getApplicationId());
        hashMap.put("sdkVersion", BuildConfig.VERSION_NAME);
        hashMap.put(RemoteConfigConstants.RequestFieldKey.INSTANCE_ID, str);
        return new b((Map<?, ?>) hashMap);
    }

    /* access modifiers changed from: private */
    public synchronized void enableBackoff() {
        this.isRealtimeDisabled = true;
    }

    private static String extractProjectNumberFromAppId(String str) {
        Matcher matcher = GMP_APP_ID_PATTERN.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    private String getFingerprintHashForPackage() {
        try {
            Context context2 = this.context;
            byte[] a10 = a.a(context2, context2.getPackageName());
            if (a10 != null) {
                return k.c(a10, false);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not get fingerprint hash for package: ");
            sb2.append(this.context.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("No such package: ");
            sb3.append(this.context.getPackageName());
            return null;
        }
    }

    private long getRandomizedBackoffDurationInMillis(int i10) {
        int[] iArr = BACKOFF_TIME_DURATIONS_IN_MINUTES;
        int length = iArr.length;
        if (i10 >= length) {
            i10 = length;
        }
        long millis = TimeUnit.MINUTES.toMillis((long) iArr[i10 - 1]);
        return (millis / 2) + ((long) this.random.nextInt((int) millis));
    }

    private String getRealtimeURL(String str) {
        return String.format(RemoteConfigConstants.REALTIME_REGEX_URL, new Object[]{extractProjectNumberFromAppId(this.firebaseApp.getOptions().getApplicationId()), str});
    }

    private URL getUrl() {
        try {
            return new URL(getRealtimeURL(this.namespace));
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    private boolean isStatusCodeRetryable(int i10) {
        return i10 == 408 || i10 == 429 || i10 == 502 || i10 == 503 || i10 == 504;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x013b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ com.google.android.gms.tasks.Task lambda$beginRealtimeHttpStream$1(com.google.android.gms.tasks.Task r12, com.google.android.gms.tasks.Task r13) throws java.lang.Exception {
        /*
            r11 = this;
            java.lang.String r13 = "Unable to connect to the server. Try again in a few minutes. HTTP status code: %d"
            r0 = 403(0x193, float:5.65E-43)
            r1 = 0
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 1
            r4 = 0
            boolean r5 = r12.isSuccessful()     // Catch:{ IOException -> 0x00fb, all -> 0x00a0 }
            if (r5 == 0) goto L_0x0096
            r11.setIsHttpConnectionRunning(r3)     // Catch:{ IOException -> 0x00fb, all -> 0x00a0 }
            java.lang.Object r12 = r12.getResult()     // Catch:{ IOException -> 0x00fb, all -> 0x00a0 }
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ IOException -> 0x00fb, all -> 0x00a0 }
            int r5 = r12.getResponseCode()     // Catch:{ IOException -> 0x0093, all -> 0x008e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IOException -> 0x0093, all -> 0x008e }
            int r6 = r5.intValue()     // Catch:{ IOException -> 0x00fd, all -> 0x008c }
            if (r6 != r2) goto L_0x0035
            r11.resetRetryCount()     // Catch:{ IOException -> 0x00fd, all -> 0x008c }
            com.google.firebase.remoteconfig.internal.ConfigMetadataClient r6 = r11.metadataClient     // Catch:{ IOException -> 0x00fd, all -> 0x008c }
            r6.resetRealtimeBackoff()     // Catch:{ IOException -> 0x00fd, all -> 0x008c }
            com.google.firebase.remoteconfig.internal.ConfigAutoFetch r6 = r11.startAutoFetch(r12)     // Catch:{ IOException -> 0x00fd, all -> 0x008c }
            r6.listenForNotifications()     // Catch:{ IOException -> 0x00fd, all -> 0x008c }
        L_0x0035:
            r11.closeRealtimeHttpStream(r12)
            r11.setIsHttpConnectionRunning(r4)
            int r6 = r5.intValue()
            boolean r6 = r11.isStatusCodeRetryable(r6)
            if (r6 == 0) goto L_0x0047
            r6 = r3
            goto L_0x0048
        L_0x0047:
            r6 = r4
        L_0x0048:
            if (r6 == 0) goto L_0x0058
            java.util.Date r7 = new java.util.Date
            me.f r8 = r11.clock
            long r8 = r8.currentTimeMillis()
            r7.<init>(r8)
            r11.updateBackoffMetadataWithLastFailedStreamConnectionTime(r7)
        L_0x0058:
            if (r6 != 0) goto L_0x0087
            int r6 = r5.intValue()
            if (r6 != r2) goto L_0x0061
            goto L_0x0087
        L_0x0061:
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r5
            java.lang.String r13 = java.lang.String.format(r13, r2)
            int r2 = r5.intValue()
            if (r2 != r0) goto L_0x0077
            java.io.InputStream r12 = r12.getErrorStream()
            java.lang.String r13 = r11.parseForbiddenErrorResponseMessage(r12)
        L_0x0077:
            com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException r12 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException
            int r0 = r5.intValue()
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r2 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR
            r12.<init>((int) r0, (java.lang.String) r13, (com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code) r2)
        L_0x0082:
            r11.propagateErrors(r12)
            goto L_0x0150
        L_0x0087:
            r11.retryHttpConnectionWhenBackoffEnds()
            goto L_0x0150
        L_0x008c:
            r1 = move-exception
            goto L_0x00a4
        L_0x008e:
            r5 = move-exception
            r10 = r5
            r5 = r1
            r1 = r10
            goto L_0x00a4
        L_0x0093:
            r5 = r1
            goto L_0x00fd
        L_0x0096:
            java.io.IOException r5 = new java.io.IOException     // Catch:{ IOException -> 0x00fb, all -> 0x00a0 }
            java.lang.Exception r12 = r12.getException()     // Catch:{ IOException -> 0x00fb, all -> 0x00a0 }
            r5.<init>(r12)     // Catch:{ IOException -> 0x00fb, all -> 0x00a0 }
            throw r5     // Catch:{ IOException -> 0x00fb, all -> 0x00a0 }
        L_0x00a0:
            r12 = move-exception
            r5 = r1
            r1 = r12
            r12 = r5
        L_0x00a4:
            r11.closeRealtimeHttpStream(r12)
            r11.setIsHttpConnectionRunning(r4)
            if (r5 == 0) goto L_0x00b9
            int r6 = r5.intValue()
            boolean r6 = r11.isStatusCodeRetryable(r6)
            if (r6 == 0) goto L_0x00b7
            goto L_0x00b9
        L_0x00b7:
            r6 = r4
            goto L_0x00ba
        L_0x00b9:
            r6 = r3
        L_0x00ba:
            if (r6 == 0) goto L_0x00ca
            java.util.Date r7 = new java.util.Date
            me.f r8 = r11.clock
            long r8 = r8.currentTimeMillis()
            r7.<init>(r8)
            r11.updateBackoffMetadataWithLastFailedStreamConnectionTime(r7)
        L_0x00ca:
            if (r6 != 0) goto L_0x00f7
            int r6 = r5.intValue()
            if (r6 == r2) goto L_0x00f7
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r5
            java.lang.String r13 = java.lang.String.format(r13, r2)
            int r2 = r5.intValue()
            if (r2 != r0) goto L_0x00e8
            java.io.InputStream r12 = r12.getErrorStream()
            java.lang.String r13 = r11.parseForbiddenErrorResponseMessage(r12)
        L_0x00e8:
            com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException r12 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException
            int r0 = r5.intValue()
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r2 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR
            r12.<init>((int) r0, (java.lang.String) r13, (com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code) r2)
            r11.propagateErrors(r12)
            goto L_0x00fa
        L_0x00f7:
            r11.retryHttpConnectionWhenBackoffEnds()
        L_0x00fa:
            throw r1
        L_0x00fb:
            r12 = r1
            r5 = r12
        L_0x00fd:
            r11.closeRealtimeHttpStream(r12)
            r11.setIsHttpConnectionRunning(r4)
            if (r5 == 0) goto L_0x0112
            int r6 = r5.intValue()
            boolean r6 = r11.isStatusCodeRetryable(r6)
            if (r6 == 0) goto L_0x0110
            goto L_0x0112
        L_0x0110:
            r6 = r4
            goto L_0x0113
        L_0x0112:
            r6 = r3
        L_0x0113:
            if (r6 == 0) goto L_0x0123
            java.util.Date r7 = new java.util.Date
            me.f r8 = r11.clock
            long r8 = r8.currentTimeMillis()
            r7.<init>(r8)
            r11.updateBackoffMetadataWithLastFailedStreamConnectionTime(r7)
        L_0x0123:
            if (r6 != 0) goto L_0x0087
            int r6 = r5.intValue()
            if (r6 != r2) goto L_0x012d
            goto L_0x0087
        L_0x012d:
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r5
            java.lang.String r13 = java.lang.String.format(r13, r2)
            int r2 = r5.intValue()
            if (r2 != r0) goto L_0x0143
            java.io.InputStream r12 = r12.getErrorStream()
            java.lang.String r13 = r11.parseForbiddenErrorResponseMessage(r12)
        L_0x0143:
            com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException r12 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException
            int r0 = r5.intValue()
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r2 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR
            r12.<init>((int) r0, (java.lang.String) r13, (com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code) r2)
            goto L_0x0082
        L_0x0150:
            com.google.android.gms.tasks.Task r12 = com.google.android.gms.tasks.Tasks.forResult(r1)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient.lambda$beginRealtimeHttpStream$1(com.google.android.gms.tasks.Task, com.google.android.gms.tasks.Task):com.google.android.gms.tasks.Task");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$createRealtimeConnection$0(Task task, Task task2, Task task3) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for config update listener connection.", (Throwable) task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for config update listener connection.", (Throwable) task2.getException()));
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) getUrl().openConnection();
            setRequestParams(httpURLConnection, (String) task2.getResult(), ((InstallationTokenResult) task.getResult()).getToken());
            return Tasks.forResult(httpURLConnection);
        } catch (IOException e10) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to open HTTP stream connection", (Throwable) e10));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void makeRealtimeHttpConnection(long r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.canMakeHttpStreamConnection()     // Catch:{ all -> 0x0030 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r3)
            return
        L_0x0009:
            int r0 = r3.httpRetriesRemaining     // Catch:{ all -> 0x0030 }
            if (r0 <= 0) goto L_0x001e
            int r0 = r0 + -1
            r3.httpRetriesRemaining = r0     // Catch:{ all -> 0x0030 }
            java.util.concurrent.ScheduledExecutorService r0 = r3.scheduledExecutorService     // Catch:{ all -> 0x0030 }
            com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient$1 r1 = new com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient$1     // Catch:{ all -> 0x0030 }
            r1.<init>()     // Catch:{ all -> 0x0030 }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0030 }
            r0.schedule(r1, r4, r2)     // Catch:{ all -> 0x0030 }
            goto L_0x002e
        L_0x001e:
            boolean r4 = r3.isInBackground     // Catch:{ all -> 0x0030 }
            if (r4 != 0) goto L_0x002e
            com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException r4 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException     // Catch:{ all -> 0x0030 }
            java.lang.String r5 = "Unable to connect to the server. Check your connection and try again."
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r0 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR     // Catch:{ all -> 0x0030 }
            r4.<init>((java.lang.String) r5, (com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code) r0)     // Catch:{ all -> 0x0030 }
            r3.propagateErrors(r4)     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r3)
            return
        L_0x0030:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient.makeRealtimeHttpConnection(long):void");
    }

    private String parseForbiddenErrorResponseMessage(InputStream inputStream) {
        StringBuilder sb2 = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb2.append(readLine);
            }
        } catch (IOException unused) {
            if (sb2.length() == 0) {
                return "Unable to connect to the server, access is forbidden. HTTP status code: 403";
            }
        }
        return sb2.toString();
    }

    /* access modifiers changed from: private */
    public synchronized void propagateErrors(FirebaseRemoteConfigException firebaseRemoteConfigException) {
        for (ConfigUpdateListener onError : this.listeners) {
            onError.onError(firebaseRemoteConfigException);
        }
    }

    private synchronized void resetRetryCount() {
        this.httpRetriesRemaining = 8;
    }

    private void setCommonRequestHeaders(HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setRequestProperty(INSTALLATIONS_AUTH_TOKEN_HEADER, str);
        httpURLConnection.setRequestProperty(API_KEY_HEADER, this.firebaseApp.getOptions().getApiKey());
        httpURLConnection.setRequestProperty(X_ANDROID_PACKAGE_HEADER, this.context.getPackageName());
        httpURLConnection.setRequestProperty(X_ANDROID_CERT_HEADER, getFingerprintHashForPackage());
        httpURLConnection.setRequestProperty(X_GOOGLE_GFE_CAN_RETRY, "yes");
        httpURLConnection.setRequestProperty(X_ACCEPT_RESPONSE_STREAMING, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
        httpURLConnection.setRequestProperty("Accept", "application/json");
    }

    private synchronized void setIsHttpConnectionRunning(boolean z10) {
        this.isHttpConnectionRunning = z10;
    }

    private void updateBackoffMetadataWithLastFailedStreamConnectionTime(Date date) {
        int numFailedStreams = this.metadataClient.getRealtimeBackoffMetadata().getNumFailedStreams() + 1;
        this.metadataClient.setRealtimeBackoffMetadata(numFailedStreams, new Date(date.getTime() + getRandomizedBackoffDurationInMillis(numFailedStreams)));
    }

    @SuppressLint({"VisibleForTests", "DefaultLocale"})
    public void beginRealtimeHttpStream() {
        if (canMakeHttpStreamConnection()) {
            if (new Date(this.clock.currentTimeMillis()).before(this.metadataClient.getRealtimeBackoffMetadata().getBackoffEndTime())) {
                retryHttpConnectionWhenBackoffEnds();
                return;
            }
            Task<HttpURLConnection> createRealtimeConnection = createRealtimeConnection();
            Tasks.whenAllComplete((Task<?>[]) new Task[]{createRealtimeConnection}).continueWith(this.scheduledExecutorService, new k(this, createRealtimeConnection));
        }
    }

    public void closeRealtimeHttpStream(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            try {
                httpURLConnection.getInputStream().close();
                if (httpURLConnection.getErrorStream() != null) {
                    httpURLConnection.getErrorStream().close();
                }
            } catch (IOException unused) {
            }
        }
    }

    @SuppressLint({"VisibleForTests"})
    public Task<HttpURLConnection> createRealtimeConnection() {
        Task<InstallationTokenResult> token = this.firebaseInstallations.getToken(false);
        Task<String> id2 = this.firebaseInstallations.getId();
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{token, id2}).continueWithTask(this.scheduledExecutorService, new l(this, token, id2));
    }

    @SuppressLint({"VisibleForTests"})
    public Date getBackoffEndTime() {
        return this.metadataClient.getRealtimeBackoffMetadata().getBackoffEndTime();
    }

    @SuppressLint({"VisibleForTests"})
    public int getNumberOfFailedStreams() {
        return this.metadataClient.getRealtimeBackoffMetadata().getNumFailedStreams();
    }

    @SuppressLint({"VisibleForTests"})
    public synchronized void retryHttpConnectionWhenBackoffEnds() {
        makeRealtimeHttpConnection(Math.max(0, this.metadataClient.getRealtimeBackoffMetadata().getBackoffEndTime().getTime() - new Date(this.clock.currentTimeMillis()).getTime()));
    }

    /* access modifiers changed from: package-private */
    public void setRealtimeBackgroundState(boolean z10) {
        this.isInBackground = z10;
    }

    @SuppressLint({"VisibleForTests"})
    public void setRequestParams(HttpURLConnection httpURLConnection, String str, String str2) throws IOException {
        httpURLConnection.setRequestMethod("POST");
        setCommonRequestHeaders(httpURLConnection, str2);
        byte[] bytes = createRequestBody(str).toString().getBytes("utf-8");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    @SuppressLint({"VisibleForTests"})
    public synchronized ConfigAutoFetch startAutoFetch(HttpURLConnection httpURLConnection) {
        HttpURLConnection httpURLConnection2;
        httpURLConnection2 = httpURLConnection;
        return new ConfigAutoFetch(httpURLConnection2, this.configFetchHandler, this.activatedCache, this.listeners, new ConfigUpdateListener() {
            public void onError(@NonNull FirebaseRemoteConfigException firebaseRemoteConfigException) {
                ConfigRealtimeHttpClient.this.enableBackoff();
                ConfigRealtimeHttpClient.this.propagateErrors(firebaseRemoteConfigException);
            }

            public void onUpdate(@NonNull ConfigUpdate configUpdate) {
            }
        }, this.scheduledExecutorService);
    }

    public void startHttpConnection() {
        makeRealtimeHttpConnection(0);
    }
}
