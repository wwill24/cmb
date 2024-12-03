package com.mparticle;

import android.content.Context;
import androidx.annotation.NonNull;
import com.mparticle.MParticle;
import com.mparticle.identity.BaseIdentityTask;
import com.mparticle.identity.IdentityApiRequest;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import com.mparticle.internal.PushRegistrationHelper;
import com.mparticle.internal.SideloadedKit;
import com.mparticle.networking.NetworkOptions;
import com.mparticle.networking.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.b;

public class MParticleOptions {
    private BatchCreationListener batchCreationListener;
    private Boolean mAndroidIdEnabled;
    private String mApiKey;
    private String mApiSecret;
    private AttributionListener mAttributionListener;
    private Integer mConfigMaxAge;
    private Map<Class, List<Configuration>> mConfigurations;
    private Context mContext;
    private String mDataplanId;
    private DataplanOptions mDataplanOptions;
    private Integer mDataplanVersion;
    private Boolean mDevicePerformanceMetricsDisabled;
    private MParticle.Environment mEnvironment;
    private IdentityApiRequest mIdentifyRequest;
    private Integer mIdentityConnectionTimeout;
    private BaseIdentityTask mIdentityTask;
    private MParticle.InstallType mInstallType;
    private LocationTracking mLocationTracking;
    private MParticle.LogLevel mLogLevel;
    private NetworkOptions mNetworkOptions;
    private MParticle.OperatingSystem mOperatingSystem;
    private PushRegistrationHelper.PushRegistration mPushRegistration;
    private Integer mSessionTimeout;
    private Boolean mUnCaughtExceptionLogging;
    private Integer mUploadInterval;
    private List<SideloadedKit> sideloadedKits;

    public interface BatchCreationListener {
        b onBatchCreated(@NonNull b bVar);
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public Boolean androidIdEnabled;
        String apiKey;
        String apiSecret;
        /* access modifiers changed from: private */
        public AttributionListener attributionListener;
        /* access modifiers changed from: private */
        public BatchCreationListener batchCreationListener;
        private com.mparticle.internal.b configManager;
        /* access modifiers changed from: private */
        public Integer configMaxAge;
        /* access modifiers changed from: private */
        public Map<Class, List<Configuration>> configurations;
        /* access modifiers changed from: private */
        public Context context;
        /* access modifiers changed from: private */
        public String dataplanId;
        /* access modifiers changed from: private */
        public DataplanOptions dataplanOptions;
        /* access modifiers changed from: private */
        public Integer dataplanVersion;
        /* access modifiers changed from: private */
        public Boolean devicePerformanceMetricsDisabled;
        /* access modifiers changed from: private */
        public MParticle.Environment environment;
        /* access modifiers changed from: private */
        public IdentityApiRequest identifyRequest;
        /* access modifiers changed from: private */
        public Integer identityConnectionTimeout;
        BaseIdentityTask identityTask;
        /* access modifiers changed from: private */
        public MParticle.InstallType installType;
        /* access modifiers changed from: private */
        public boolean isAppDebuggable;
        /* access modifiers changed from: private */
        public LocationTracking locationTracking;
        MParticle.LogLevel logLevel;
        /* access modifiers changed from: private */
        public NetworkOptions networkOptions;
        /* access modifiers changed from: private */
        public MParticle.OperatingSystem operatingSystem;
        /* access modifiers changed from: private */
        public PushRegistrationHelper.PushRegistration pushRegistration;
        /* access modifiers changed from: private */
        public Integer sessionTimeout;
        /* access modifiers changed from: private */
        public List<SideloadedKit> sideloadedKits;
        /* access modifiers changed from: private */
        public Boolean unCaughtExceptionLogging;
        /* access modifiers changed from: private */
        public Integer uploadInterval;

        @NonNull
        @Deprecated
        public Builder androidIdDisabled(boolean z10) {
            this.androidIdEnabled = Boolean.valueOf(!z10);
            return this;
        }

        @NonNull
        public Builder androidIdEnabled(boolean z10) {
            this.androidIdEnabled = Boolean.valueOf(z10);
            return this;
        }

        @NonNull
        public Builder attributionListener(AttributionListener attributionListener2) {
            this.attributionListener = attributionListener2;
            return this;
        }

        @NonNull
        public Builder batchCreationListener(BatchCreationListener batchCreationListener2) {
            this.batchCreationListener = batchCreationListener2;
            return this;
        }

        @NonNull
        public MParticleOptions build() {
            boolean z10;
            Context context2 = this.context;
            if (context2 != null) {
                this.isAppDebuggable = MPUtility.isAppDebuggable(context2);
                if (MParticle.Environment.Development.equals(this.environment) || this.isAppDebuggable) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (MPUtility.isEmpty((CharSequence) this.apiKey)) {
                    if (!z10) {
                        Logger.error("Configuration issue: No API key passed to start()!");
                    } else {
                        throw new IllegalArgumentException("Configuration issue: No API key passed to start()!");
                    }
                }
                if (MPUtility.isEmpty((CharSequence) this.apiSecret)) {
                    if (!z10) {
                        Logger.error("Configuration issue: No API secret passed to start()!");
                    } else {
                        throw new IllegalArgumentException("Configuration issue: No API secret passed to start()!");
                    }
                }
                return new MParticleOptions(this);
            }
            throw new IllegalArgumentException("mParticle failed to start: context is required.");
        }

        /* access modifiers changed from: package-private */
        public MParticleOptions buildForInternalRestart() {
            return new MParticleOptions(this);
        }

        @NonNull
        public Builder configMaxAgeSeconds(int i10) {
            this.configMaxAge = Integer.valueOf(i10);
            return this;
        }

        public Builder configuration(Configuration configuration) {
            List list = this.configurations.get(configuration.configures());
            if (list == null) {
                list = new ArrayList();
            }
            list.add(configuration);
            this.configurations.put(configuration.configures(), list);
            return this;
        }

        @NonNull
        public Builder credentials(@NonNull String str, @NonNull String str2) {
            this.apiKey = str;
            this.apiSecret = str2;
            return this;
        }

        @NonNull
        public Builder dataplan(String str, Integer num) {
            this.dataplanId = str;
            this.dataplanVersion = num;
            return this;
        }

        @NonNull
        public Builder dataplanOptions(DataplanOptions dataplanOptions2) {
            this.dataplanOptions = dataplanOptions2;
            return this;
        }

        @NonNull
        public Builder devicePerformanceMetricsDisabled(boolean z10) {
            this.devicePerformanceMetricsDisabled = Boolean.valueOf(z10);
            return this;
        }

        @NonNull
        public Builder enableUncaughtExceptionLogging(boolean z10) {
            this.unCaughtExceptionLogging = Boolean.valueOf(z10);
            return this;
        }

        @NonNull
        public Builder environment(@NonNull MParticle.Environment environment2) {
            this.environment = environment2;
            return this;
        }

        @NonNull
        public Builder identify(@NonNull IdentityApiRequest identityApiRequest) {
            this.identifyRequest = identityApiRequest;
            return this;
        }

        @NonNull
        public Builder identifyTask(@NonNull BaseIdentityTask baseIdentityTask) {
            this.identityTask = baseIdentityTask;
            return this;
        }

        @NonNull
        public Builder identityConnectionTimeout(int i10) {
            this.identityConnectionTimeout = Integer.valueOf(i10);
            return this;
        }

        @NonNull
        public Builder installType(@NonNull MParticle.InstallType installType2) {
            this.installType = installType2;
            return this;
        }

        @NonNull
        public Builder locationTrackingDisabled() {
            this.locationTracking = new LocationTracking(false);
            return this;
        }

        @NonNull
        public Builder locationTrackingEnabled(@NonNull String str, long j10, long j11) {
            this.locationTracking = new LocationTracking(str, j10, j11);
            return this;
        }

        @NonNull
        public Builder logLevel(@NonNull MParticle.LogLevel logLevel2) {
            this.logLevel = logLevel2;
            return this;
        }

        @NonNull
        public Builder networkOptions(NetworkOptions networkOptions2) {
            this.networkOptions = networkOptions2;
            return this;
        }

        @NonNull
        public Builder operatingSystem(MParticle.OperatingSystem operatingSystem2) {
            this.operatingSystem = operatingSystem2;
            return this;
        }

        @NonNull
        public Builder pushRegistration(@NonNull String str, @NonNull String str2) {
            this.pushRegistration = new PushRegistrationHelper.PushRegistration(str, str2);
            return this;
        }

        @NonNull
        public Builder sessionTimeout(int i10) {
            this.sessionTimeout = Integer.valueOf(i10);
            return this;
        }

        @NonNull
        public Builder sideloadedKits(@NonNull List<SideloadedKit> list) {
            ArrayList arrayList = new ArrayList();
            for (SideloadedKit next : list) {
                if (next.kitId() < 1000000) {
                    Logger.error("Sideloaded kit " + next.getName() + " must have a kitId greater or equal than 1000000, current one is " + next.kitId() + " and will not be included.");
                } else {
                    arrayList.add(next);
                }
            }
            this.sideloadedKits = arrayList;
            return this;
        }

        @NonNull
        public Builder uploadInterval(int i10) {
            this.uploadInterval = Integer.valueOf(i10);
            return this;
        }

        private Builder(Context context2) {
            this.devicePerformanceMetricsDisabled = null;
            this.androidIdEnabled = null;
            this.uploadInterval = null;
            this.sessionTimeout = null;
            this.configMaxAge = null;
            this.unCaughtExceptionLogging = null;
            this.logLevel = null;
            this.identityConnectionTimeout = null;
            this.configurations = new HashMap();
            this.sideloadedKits = new ArrayList();
            this.context = context2;
        }
    }

    public static class DataplanOptions {
        private boolean blockEventAttributes;
        private boolean blockEvents;
        private boolean blockUserAttributes;
        private boolean blockUserIdentities;
        private b dataplan;

        public static class Builder {
            /* access modifiers changed from: private */
            public boolean blockEventAttributes;
            /* access modifiers changed from: private */
            public boolean blockEvents;
            /* access modifiers changed from: private */
            public boolean blockUserAttributes;
            /* access modifiers changed from: private */
            public boolean blockUserIdentities;
            /* access modifiers changed from: private */
            public b dataplanVersion;

            public Builder blockEventAttributes(boolean z10) {
                this.blockEventAttributes = z10;
                return this;
            }

            public Builder blockEvents(boolean z10) {
                this.blockEvents = z10;
                return this;
            }

            public Builder blockUserAttributes(boolean z10) {
                this.blockUserAttributes = z10;
                return this;
            }

            public Builder blockUserIdentities(boolean z10) {
                this.blockUserIdentities = z10;
                return this;
            }

            public DataplanOptions build() {
                if (!MPUtility.isEmpty(this.dataplanVersion)) {
                    return new DataplanOptions(this);
                }
                if (!MPUtility.isDevEnv()) {
                    Logger.error("Configuration issue: dataplan is not required, but it may not be empty. Ignoring Dataplan");
                    return null;
                }
                throw new IllegalArgumentException("Configuration issue: dataplan is not required, but it may not be empty. Ignoring Dataplan");
            }

            public Builder dataplanVersion(String str) {
                try {
                    this.dataplanVersion = new b(str);
                } catch (JSONException unused) {
                    Logger.error("Unable to parse dataplan json. Dataplan will not be applied");
                }
                return this;
            }

            private Builder() {
            }

            public Builder dataplanVersion(b bVar) {
                this.dataplanVersion = bVar;
                return this;
            }

            public Builder dataplanVersion(Map<String, Object> map) {
                try {
                    this.dataplanVersion = new b((Map<?, ?>) map);
                } catch (Exception unused) {
                    Logger.error("Unable to parse dataplan json. Dataplan will not be applied");
                }
                return this;
            }
        }

        public static Builder builder() {
            return new Builder();
        }

        @NonNull
        public b getDataplan() {
            return this.dataplan;
        }

        public boolean isBlockEventAttributes() {
            return this.blockEventAttributes;
        }

        public boolean isBlockEvents() {
            return this.blockEvents;
        }

        public boolean isBlockUserAttributes() {
            return this.blockUserAttributes;
        }

        public boolean isBlockUserIdentities() {
            return this.blockUserIdentities;
        }

        public String toString() {
            String str;
            try {
                str = this.dataplan.toString(4);
            } catch (JSONException unused) {
                str = "Unable to print Dataplan";
            }
            return "DataplanOptions {\n\tblockUserAttributes=" + this.blockUserAttributes + ", \n\tblockUserIdentities=" + this.blockUserIdentities + ", \n\tblockEventAttributes=" + this.blockEventAttributes + ", \n\tblockEvents=" + this.blockEvents + ",\n\tdataplan=" + str + "\n}";
        }

        private DataplanOptions(@NonNull Builder builder) {
            this.dataplan = builder.dataplanVersion;
            this.blockUserAttributes = builder.blockUserAttributes;
            this.blockUserIdentities = builder.blockUserIdentities;
            this.blockEventAttributes = builder.blockEventAttributes;
            this.blockEvents = builder.blockEvents;
        }
    }

    private MParticleOptions() {
        this.mInstallType = MParticle.InstallType.AutoDetect;
        this.mEnvironment = MParticle.Environment.AutoDetect;
        Boolean bool = Boolean.FALSE;
        this.mDevicePerformanceMetricsDisabled = bool;
        this.mAndroidIdEnabled = bool;
        this.mUploadInterval = 600;
        this.mSessionTimeout = 60;
        this.mConfigMaxAge = null;
        this.mUnCaughtExceptionLogging = bool;
        this.mLogLevel = MParticle.LogLevel.DEBUG;
        this.batchCreationListener = null;
        this.mIdentityConnectionTimeout = 30;
        this.mOperatingSystem = MParticle.OperatingSystem.ANDROID;
        this.mConfigurations = new HashMap();
        this.sideloadedKits = new ArrayList();
    }

    @NonNull
    public static Builder builder(@NonNull Context context) {
        return new Builder(context);
    }

    @NonNull
    public String getApiKey() {
        return this.mApiKey;
    }

    @NonNull
    public String getApiSecret() {
        return this.mApiSecret;
    }

    public AttributionListener getAttributionListener() {
        return this.mAttributionListener;
    }

    public BatchCreationListener getBatchCreationListener() {
        return this.batchCreationListener;
    }

    @NonNull
    public Integer getConfigMaxAge() {
        return this.mConfigMaxAge;
    }

    public <T extends Configuration> T getConfiguration(Class<T> cls) {
        for (List<Configuration> it : this.mConfigurations.values()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    T t10 = (Configuration) it2.next();
                    if (t10.getClass() == cls) {
                        return t10;
                    }
                }
            }
        }
        return null;
    }

    @NonNull
    public List<Configuration> getConfigurations() {
        return new ArrayList(this.mConfigurations.values());
    }

    @NonNull
    public <T> List<Configuration<T>> getConfigurationsForTarget(Class<T> cls) {
        List list = this.mConfigurations.get(cls);
        if (list == null) {
            return new ArrayList();
        }
        return new ArrayList(list);
    }

    public int getConnectionTimeout() {
        return this.mIdentityConnectionTimeout.intValue();
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    public String getDataplanId() {
        return this.mDataplanId;
    }

    public DataplanOptions getDataplanOptions() {
        return this.mDataplanOptions;
    }

    public Integer getDataplanVersion() {
        return this.mDataplanVersion;
    }

    @NonNull
    public MParticle.Environment getEnvironment() {
        return this.mEnvironment;
    }

    public IdentityApiRequest getIdentifyRequest() {
        return this.mIdentifyRequest;
    }

    public BaseIdentityTask getIdentityTask() {
        return this.mIdentityTask;
    }

    @NonNull
    public MParticle.InstallType getInstallType() {
        return this.mInstallType;
    }

    public LocationTracking getLocationTracking() {
        return this.mLocationTracking;
    }

    @NonNull
    public MParticle.LogLevel getLogLevel() {
        return this.mLogLevel;
    }

    @NonNull
    public NetworkOptions getNetworkOptions() {
        return this.mNetworkOptions;
    }

    @NonNull
    public MParticle.OperatingSystem getOperatingSystem() {
        return this.mOperatingSystem;
    }

    public PushRegistrationHelper.PushRegistration getPushRegistration() {
        return this.mPushRegistration;
    }

    @NonNull
    public Integer getSessionTimeout() {
        return this.mSessionTimeout;
    }

    @NonNull
    public List<SideloadedKit> getSideloadedKits() {
        return this.sideloadedKits;
    }

    @NonNull
    public Integer getUploadInterval() {
        return this.mUploadInterval;
    }

    public boolean hasLocationTracking() {
        return this.mLocationTracking != null;
    }

    @NonNull
    @Deprecated
    public Boolean isAndroidIdDisabled() {
        return Boolean.valueOf(!this.mAndroidIdEnabled.booleanValue());
    }

    @NonNull
    public Boolean isAndroidIdEnabled() {
        return this.mAndroidIdEnabled;
    }

    @NonNull
    public Boolean isDevicePerformanceMetricsDisabled() {
        return this.mDevicePerformanceMetricsDisabled;
    }

    @NonNull
    public Boolean isUncaughtExceptionLoggingEnabled() {
        return this.mUnCaughtExceptionLogging;
    }

    static class LocationTracking {
        boolean enabled;
        long minDistance;
        long minTime;
        String provider;

        protected LocationTracking(boolean z10) {
            this.enabled = z10;
        }

        protected LocationTracking(String str, long j10, long j11) {
            this.enabled = true;
            this.provider = str;
            this.minTime = j10;
            this.minDistance = j11;
        }
    }

    public MParticleOptions(@NonNull Builder builder) {
        this.mInstallType = MParticle.InstallType.AutoDetect;
        MParticle.Environment environment = MParticle.Environment.AutoDetect;
        this.mEnvironment = environment;
        Boolean bool = Boolean.FALSE;
        this.mDevicePerformanceMetricsDisabled = bool;
        this.mAndroidIdEnabled = bool;
        this.mUploadInterval = 600;
        this.mSessionTimeout = 60;
        this.mConfigMaxAge = null;
        this.mUnCaughtExceptionLogging = bool;
        this.mLogLevel = MParticle.LogLevel.DEBUG;
        this.batchCreationListener = null;
        this.mIdentityConnectionTimeout = 30;
        this.mOperatingSystem = MParticle.OperatingSystem.ANDROID;
        this.mConfigurations = new HashMap();
        this.sideloadedKits = new ArrayList();
        this.mContext = builder.context;
        String str = builder.apiKey;
        if (str != null) {
            this.mApiKey = str;
        }
        String str2 = builder.apiSecret;
        if (str2 != null) {
            this.mApiSecret = str2;
        }
        if (builder.installType != null) {
            this.mInstallType = builder.installType;
        }
        if (builder.environment != null) {
            this.mEnvironment = builder.environment;
        }
        MParticle.Environment environment2 = this.mEnvironment;
        if (environment2 == null || environment2 == environment) {
            if (builder.isAppDebuggable) {
                this.mEnvironment = MParticle.Environment.Development;
            } else {
                this.mEnvironment = MParticle.Environment.Production;
            }
        }
        if (builder.identifyRequest != null) {
            this.mIdentifyRequest = builder.identifyRequest;
        }
        BaseIdentityTask baseIdentityTask = builder.identityTask;
        if (baseIdentityTask != null) {
            this.mIdentityTask = baseIdentityTask;
        }
        if (builder.devicePerformanceMetricsDisabled != null) {
            this.mDevicePerformanceMetricsDisabled = builder.devicePerformanceMetricsDisabled;
        }
        if (builder.androidIdEnabled != null) {
            this.mAndroidIdEnabled = builder.androidIdEnabled;
        }
        String[] strArr = new String[1];
        Object[] objArr = new Object[2];
        objArr[0] = this.mAndroidIdEnabled.booleanValue() ? "" : " not";
        objArr[1] = builder.androidIdEnabled != null ? "MParticleOptions" : "default";
        strArr[0] = String.format("ANDROID_ID will%s be collected based on %s settings", objArr);
        Logger.info(strArr);
        if (builder.uploadInterval != null) {
            if (builder.uploadInterval.intValue() <= 0) {
                Logger.warning("Upload Interval must be a positive number, disregarding value.");
            } else {
                this.mUploadInterval = builder.uploadInterval;
            }
        }
        if (builder.sessionTimeout != null) {
            if (builder.sessionTimeout.intValue() <= 0) {
                Logger.warning("Session Timeout must be a positive number, disregarding value.");
            } else {
                this.mSessionTimeout = builder.sessionTimeout;
            }
        }
        if (builder.configMaxAge != null) {
            if (builder.configMaxAge.intValue() < 0) {
                Logger.warning("Config Max Age must be a positive number, disregarding value.");
            } else {
                this.mConfigMaxAge = builder.configMaxAge;
            }
        }
        if (builder.unCaughtExceptionLogging != null) {
            this.mUnCaughtExceptionLogging = builder.unCaughtExceptionLogging;
        }
        MParticle.LogLevel logLevel = builder.logLevel;
        if (logLevel != null) {
            this.mLogLevel = logLevel;
        }
        if (builder.attributionListener != null) {
            this.mAttributionListener = builder.attributionListener;
        }
        if (builder.batchCreationListener != null) {
            this.batchCreationListener = builder.batchCreationListener;
        }
        if (builder.locationTracking != null) {
            this.mLocationTracking = builder.locationTracking;
        }
        if (builder.pushRegistration != null) {
            this.mPushRegistration = builder.pushRegistration;
        }
        if (builder.identityConnectionTimeout != null && builder.identityConnectionTimeout.intValue() >= 1) {
            this.mIdentityConnectionTimeout = builder.identityConnectionTimeout;
        } else if (builder.identityConnectionTimeout != null) {
            Logger.warning(String.format("Connection Timeout milliseconds must be a positive number, greater than %s second. Defaulting to %s seconds", new Object[]{String.valueOf(1), String.valueOf(30)}));
        }
        if (builder.operatingSystem != null) {
            this.mOperatingSystem = builder.operatingSystem;
        }
        this.mNetworkOptions = d.a(builder.networkOptions);
        this.mDataplanId = builder.dataplanId;
        this.mDataplanVersion = builder.dataplanVersion;
        this.mDataplanOptions = builder.dataplanOptions;
        this.mConfigurations = builder.configurations;
        this.sideloadedKits = builder.sideloadedKits;
    }
}
