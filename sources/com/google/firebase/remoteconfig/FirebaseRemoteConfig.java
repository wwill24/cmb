package com.google.firebase.remoteconfig;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.AbtException;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.concurrent.FirebaseExecutors;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.ConfigRealtimeHandler;
import com.google.firebase.remoteconfig.internal.DefaultsXmlParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class FirebaseRemoteConfig {
    public static final boolean DEFAULT_VALUE_FOR_BOOLEAN = false;
    public static final byte[] DEFAULT_VALUE_FOR_BYTE_ARRAY = new byte[0];
    public static final double DEFAULT_VALUE_FOR_DOUBLE = 0.0d;
    public static final long DEFAULT_VALUE_FOR_LONG = 0;
    public static final String DEFAULT_VALUE_FOR_STRING = "";
    public static final int LAST_FETCH_STATUS_FAILURE = 1;
    public static final int LAST_FETCH_STATUS_NO_FETCH_YET = 0;
    public static final int LAST_FETCH_STATUS_SUCCESS = -1;
    public static final int LAST_FETCH_STATUS_THROTTLED = 2;
    public static final String TAG = "FirebaseRemoteConfig";
    public static final int VALUE_SOURCE_DEFAULT = 1;
    public static final int VALUE_SOURCE_REMOTE = 2;
    public static final int VALUE_SOURCE_STATIC = 0;
    private final ConfigCacheClient activatedConfigsCache;
    private final ConfigRealtimeHandler configRealtimeHandler;
    private final Context context;
    private final ConfigCacheClient defaultConfigsCache;
    private final Executor executor;
    private final ConfigFetchHandler fetchHandler;
    private final ConfigCacheClient fetchedConfigsCache;
    private final FirebaseABTesting firebaseAbt;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final ConfigMetadataClient frcMetadata;
    private final ConfigGetParameterHandler getHandler;

    FirebaseRemoteConfig(Context context2, FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Executor executor2, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient, ConfigRealtimeHandler configRealtimeHandler2) {
        this.context = context2;
        this.firebaseApp = firebaseApp2;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.firebaseAbt = firebaseABTesting;
        this.executor = executor2;
        this.fetchedConfigsCache = configCacheClient;
        this.activatedConfigsCache = configCacheClient2;
        this.defaultConfigsCache = configCacheClient3;
        this.fetchHandler = configFetchHandler;
        this.getHandler = configGetParameterHandler;
        this.frcMetadata = configMetadataClient;
        this.configRealtimeHandler = configRealtimeHandler2;
    }

    @NonNull
    public static FirebaseRemoteConfig getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    private static boolean isFetchedFresh(ConfigContainer configContainer, ConfigContainer configContainer2) {
        return configContainer2 == null || !configContainer.getFetchTime().equals(configContainer2.getFetchTime());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$activate$2(Task task, Task task2, Task task3) throws Exception {
        if (!task.isSuccessful() || task.getResult() == null) {
            return Tasks.forResult(Boolean.FALSE);
        }
        ConfigContainer configContainer = (ConfigContainer) task.getResult();
        if (!task2.isSuccessful() || isFetchedFresh(configContainer, (ConfigContainer) task2.getResult())) {
            return this.activatedConfigsCache.put(configContainer).continueWith(this.executor, new i(this));
        }
        return Tasks.forResult(Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ FirebaseRemoteConfigInfo lambda$ensureInitialized$0(Task task, Task task2) throws Exception {
        return (FirebaseRemoteConfigInfo) task.getResult();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$fetchAndActivate$1(Void voidR) throws Exception {
        return activate();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Void lambda$reset$6() throws Exception {
        this.activatedConfigsCache.clear();
        this.fetchedConfigsCache.clear();
        this.defaultConfigsCache.clear();
        this.frcMetadata.clear();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Void lambda$setConfigSettingsAsync$5(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) throws Exception {
        this.frcMetadata.setConfigSettings(firebaseRemoteConfigSettings);
        return null;
    }

    /* access modifiers changed from: private */
    public boolean processActivatePutTask(Task<ConfigContainer> task) {
        if (!task.isSuccessful()) {
            return false;
        }
        this.fetchedConfigsCache.clear();
        if (task.getResult() == null) {
            return true;
        }
        updateAbtWithActivatedExperiments(task.getResult().getAbtExperiments());
        return true;
    }

    private Task<Void> setDefaultsWithStringsMapAsync(Map<String, String> map) {
        try {
            return this.defaultConfigsCache.put(ConfigContainer.newBuilder().replaceConfigsWith(map).build()).onSuccessTask(FirebaseExecutors.directExecutor(), new a());
        } catch (JSONException unused) {
            return Tasks.forResult(null);
        }
    }

    static List<Map<String, String>> toExperimentInfoMaps(a aVar) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < aVar.o(); i10++) {
            HashMap hashMap = new HashMap();
            b j10 = aVar.j(i10);
            Iterator<String> keys = j10.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, j10.getString(next));
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    @NonNull
    public Task<Boolean> activate() {
        Task<ConfigContainer> task = this.fetchedConfigsCache.get();
        Task<ConfigContainer> task2 = this.activatedConfigsCache.get();
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{task, task2}).continueWithTask(this.executor, new j(this, task, task2));
    }

    @NonNull
    public ConfigUpdateListenerRegistration addOnConfigUpdateListener(@NonNull ConfigUpdateListener configUpdateListener) {
        return this.configRealtimeHandler.addRealtimeConfigUpdateListener(configUpdateListener);
    }

    @NonNull
    public Task<FirebaseRemoteConfigInfo> ensureInitialized() {
        Task<ConfigContainer> task = this.activatedConfigsCache.get();
        Task<ConfigContainer> task2 = this.defaultConfigsCache.get();
        Task<ConfigContainer> task3 = this.fetchedConfigsCache.get();
        Task call = Tasks.call(this.executor, new e(this));
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{task, task2, task3, call, this.firebaseInstallations.getId(), this.firebaseInstallations.getToken(false)}).continueWith(this.executor, new f(call));
    }

    @NonNull
    public Task<Void> fetch() {
        return this.fetchHandler.fetch().onSuccessTask(FirebaseExecutors.directExecutor(), new d());
    }

    @NonNull
    public Task<Boolean> fetchAndActivate() {
        return fetch().onSuccessTask(this.executor, new h(this));
    }

    @NonNull
    public Map<String, FirebaseRemoteConfigValue> getAll() {
        return this.getHandler.getAll();
    }

    public boolean getBoolean(@NonNull String str) {
        return this.getHandler.getBoolean(str);
    }

    public double getDouble(@NonNull String str) {
        return this.getHandler.getDouble(str);
    }

    @NonNull
    public FirebaseRemoteConfigInfo getInfo() {
        return this.frcMetadata.getInfo();
    }

    @NonNull
    public Set<String> getKeysByPrefix(@NonNull String str) {
        return this.getHandler.getKeysByPrefix(str);
    }

    public long getLong(@NonNull String str) {
        return this.getHandler.getLong(str);
    }

    @NonNull
    public String getString(@NonNull String str) {
        return this.getHandler.getString(str);
    }

    @NonNull
    public FirebaseRemoteConfigValue getValue(@NonNull String str) {
        return this.getHandler.getValue(str);
    }

    @NonNull
    public Task<Void> reset() {
        return Tasks.call(this.executor, new c(this));
    }

    public void schedule(Runnable runnable) {
        this.executor.execute(runnable);
    }

    @NonNull
    public Task<Void> setConfigSettingsAsync(@NonNull FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        return Tasks.call(this.executor, new g(this, firebaseRemoteConfigSettings));
    }

    /* access modifiers changed from: package-private */
    public void setConfigUpdateBackgroundState(boolean z10) {
        this.configRealtimeHandler.setBackgroundState(z10);
    }

    @NonNull
    public Task<Void> setDefaultsAsync(@NonNull Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            if (value instanceof byte[]) {
                hashMap.put((String) next.getKey(), new String((byte[]) value));
            } else {
                hashMap.put((String) next.getKey(), value.toString());
            }
        }
        return setDefaultsWithStringsMapAsync(hashMap);
    }

    /* access modifiers changed from: package-private */
    public void startLoadingConfigsFromDisk() {
        this.activatedConfigsCache.get();
        this.defaultConfigsCache.get();
        this.fetchedConfigsCache.get();
    }

    /* access modifiers changed from: package-private */
    public void updateAbtWithActivatedExperiments(@NonNull a aVar) {
        if (this.firebaseAbt != null) {
            try {
                this.firebaseAbt.replaceAllExperiments(toExperimentInfoMaps(aVar));
            } catch (AbtException | JSONException unused) {
            }
        }
    }

    @NonNull
    public static FirebaseRemoteConfig getInstance(@NonNull FirebaseApp firebaseApp2) {
        return ((RemoteConfigComponent) firebaseApp2.get(RemoteConfigComponent.class)).getDefault();
    }

    @NonNull
    public Task<Void> fetch(long j10) {
        return this.fetchHandler.fetch(j10).onSuccessTask(FirebaseExecutors.directExecutor(), new b());
    }

    @NonNull
    public Task<Void> setDefaultsAsync(int i10) {
        return setDefaultsWithStringsMapAsync(DefaultsXmlParser.getDefaultsFromXml(this.context, i10));
    }
}
