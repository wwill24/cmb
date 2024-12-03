package com.google.firebase.perf.config;

import android.content.Context;
import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.config.ConfigurationConstants;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.ImmutableBundle;
import com.google.firebase.perf.util.Optional;
import com.google.firebase.perf.util.Utils;

public class ConfigResolver {
    private static volatile ConfigResolver instance;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private DeviceCacheManager deviceCacheManager;
    private ImmutableBundle metadataBundle;
    private final RemoteConfigManager remoteConfigManager;

    public ConfigResolver(RemoteConfigManager remoteConfigManager2, ImmutableBundle immutableBundle, DeviceCacheManager deviceCacheManager2) {
        this.remoteConfigManager = remoteConfigManager2 == null ? RemoteConfigManager.getInstance() : remoteConfigManager2;
        this.metadataBundle = immutableBundle == null ? new ImmutableBundle() : immutableBundle;
        this.deviceCacheManager = deviceCacheManager2 == null ? DeviceCacheManager.getInstance() : deviceCacheManager2;
    }

    public static void clearInstance() {
        instance = null;
    }

    private Optional<Boolean> getDeviceCacheBoolean(ConfigurationFlag<Boolean> configurationFlag) {
        return this.deviceCacheManager.getBoolean(configurationFlag.getDeviceCacheFlag());
    }

    private Optional<Double> getDeviceCacheDouble(ConfigurationFlag<Double> configurationFlag) {
        return this.deviceCacheManager.getDouble(configurationFlag.getDeviceCacheFlag());
    }

    private Optional<Long> getDeviceCacheLong(ConfigurationFlag<Long> configurationFlag) {
        return this.deviceCacheManager.getLong(configurationFlag.getDeviceCacheFlag());
    }

    private Optional<String> getDeviceCacheString(ConfigurationFlag<String> configurationFlag) {
        return this.deviceCacheManager.getString(configurationFlag.getDeviceCacheFlag());
    }

    public static synchronized ConfigResolver getInstance() {
        ConfigResolver configResolver;
        synchronized (ConfigResolver.class) {
            if (instance == null) {
                instance = new ConfigResolver((RemoteConfigManager) null, (ImmutableBundle) null, (DeviceCacheManager) null);
            }
            configResolver = instance;
        }
        return configResolver;
    }

    private boolean getIsSdkEnabled() {
        ConfigurationConstants.SdkEnabled instance2 = ConfigurationConstants.SdkEnabled.getInstance();
        Optional<Boolean> remoteConfigBoolean = getRemoteConfigBoolean(instance2);
        if (!remoteConfigBoolean.isAvailable()) {
            Optional<Boolean> deviceCacheBoolean = getDeviceCacheBoolean(instance2);
            if (deviceCacheBoolean.isAvailable()) {
                return deviceCacheBoolean.get().booleanValue();
            }
            return instance2.getDefault().booleanValue();
        } else if (this.remoteConfigManager.isLastFetchFailed()) {
            return false;
        } else {
            this.deviceCacheManager.setValue(instance2.getDeviceCacheFlag(), remoteConfigBoolean.get().booleanValue());
            return remoteConfigBoolean.get().booleanValue();
        }
    }

    private boolean getIsSdkVersionDisabled() {
        ConfigurationConstants.SdkDisabledVersions instance2 = ConfigurationConstants.SdkDisabledVersions.getInstance();
        Optional<String> remoteConfigString = getRemoteConfigString(instance2);
        if (remoteConfigString.isAvailable()) {
            this.deviceCacheManager.setValue(instance2.getDeviceCacheFlag(), remoteConfigString.get());
            return isFireperfSdkVersionInList(remoteConfigString.get());
        }
        Optional<String> deviceCacheString = getDeviceCacheString(instance2);
        if (deviceCacheString.isAvailable()) {
            return isFireperfSdkVersionInList(deviceCacheString.get());
        }
        return isFireperfSdkVersionInList(instance2.getDefault());
    }

    private Optional<Boolean> getMetadataBoolean(ConfigurationFlag<Boolean> configurationFlag) {
        return this.metadataBundle.getBoolean(configurationFlag.getMetadataFlag());
    }

    private Optional<Double> getMetadataDouble(ConfigurationFlag<Double> configurationFlag) {
        return this.metadataBundle.getDouble(configurationFlag.getMetadataFlag());
    }

    private Optional<Long> getMetadataLong(ConfigurationFlag<Long> configurationFlag) {
        return this.metadataBundle.getLong(configurationFlag.getMetadataFlag());
    }

    private Optional<Boolean> getRemoteConfigBoolean(ConfigurationFlag<Boolean> configurationFlag) {
        return this.remoteConfigManager.getBoolean(configurationFlag.getRemoteConfigFlag());
    }

    private Optional<Double> getRemoteConfigDouble(ConfigurationFlag<Double> configurationFlag) {
        return this.remoteConfigManager.getDouble(configurationFlag.getRemoteConfigFlag());
    }

    private Optional<Long> getRemoteConfigLong(ConfigurationFlag<Long> configurationFlag) {
        return this.remoteConfigManager.getLong(configurationFlag.getRemoteConfigFlag());
    }

    private Optional<String> getRemoteConfigString(ConfigurationFlag<String> configurationFlag) {
        return this.remoteConfigManager.getString(configurationFlag.getRemoteConfigFlag());
    }

    private Long getRemoteConfigValue(ConfigurationFlag<Long> configurationFlag) {
        String remoteConfigFlag = configurationFlag.getRemoteConfigFlag();
        if (remoteConfigFlag == null) {
            return configurationFlag.getDefault();
        }
        return (Long) this.remoteConfigManager.getRemoteConfigValueOrDefault(remoteConfigFlag, configurationFlag.getDefault());
    }

    private boolean isEventCountValid(long j10) {
        return j10 >= 0;
    }

    private boolean isFireperfSdkVersionInList(String str) {
        if (str.trim().isEmpty()) {
            return false;
        }
        for (String trim : str.split(";")) {
            if (trim.trim().equals(BuildConfig.FIREPERF_VERSION_NAME)) {
                return true;
            }
        }
        return false;
    }

    private boolean isGaugeCaptureFrequencyMsValid(long j10) {
        return j10 >= 0;
    }

    private boolean isSamplingRateValid(double d10) {
        return 0.0d <= d10 && d10 <= 1.0d;
    }

    private boolean isSessionsMaxDurationMinutesValid(long j10) {
        return j10 > 0;
    }

    private boolean isTimeRangeSecValid(long j10) {
        return j10 > 0;
    }

    public String getAndCacheLogSourceName() {
        String logSourceName;
        ConfigurationConstants.LogSourceName instance2 = ConfigurationConstants.LogSourceName.getInstance();
        if (BuildConfig.ENFORCE_DEFAULT_LOG_SRC.booleanValue()) {
            return instance2.getDefault();
        }
        String remoteConfigFlag = instance2.getRemoteConfigFlag();
        long j10 = -1;
        if (remoteConfigFlag != null) {
            j10 = ((Long) this.remoteConfigManager.getRemoteConfigValueOrDefault(remoteConfigFlag, -1L)).longValue();
        }
        String deviceCacheFlag = instance2.getDeviceCacheFlag();
        if (!ConfigurationConstants.LogSourceName.isLogSourceKnown(j10) || (logSourceName = ConfigurationConstants.LogSourceName.getLogSourceName(j10)) == null) {
            Optional<String> deviceCacheString = getDeviceCacheString(instance2);
            if (deviceCacheString.isAvailable()) {
                return deviceCacheString.get();
            }
            return instance2.getDefault();
        }
        this.deviceCacheManager.setValue(deviceCacheFlag, logSourceName);
        return logSourceName;
    }

    public double getFragmentSamplingRate() {
        ConfigurationConstants.FragmentSamplingRate instance2 = ConfigurationConstants.FragmentSamplingRate.getInstance();
        Optional<Double> metadataDouble = getMetadataDouble(instance2);
        if (metadataDouble.isAvailable()) {
            double doubleValue = metadataDouble.get().doubleValue() / 100.0d;
            if (isSamplingRateValid(doubleValue)) {
                return doubleValue;
            }
        }
        Optional<Double> remoteConfigDouble = getRemoteConfigDouble(instance2);
        if (!remoteConfigDouble.isAvailable() || !isSamplingRateValid(remoteConfigDouble.get().doubleValue())) {
            Optional<Double> deviceCacheDouble = getDeviceCacheDouble(instance2);
            if (!deviceCacheDouble.isAvailable() || !isSamplingRateValid(deviceCacheDouble.get().doubleValue())) {
                return instance2.getDefault().doubleValue();
            }
            return deviceCacheDouble.get().doubleValue();
        }
        this.deviceCacheManager.setValue(instance2.getDeviceCacheFlag(), remoteConfigDouble.get().doubleValue());
        return remoteConfigDouble.get().doubleValue();
    }

    public boolean getIsExperimentTTIDEnabled() {
        ConfigurationConstants.ExperimentTTID instance2 = ConfigurationConstants.ExperimentTTID.getInstance();
        Optional<Boolean> metadataBoolean = getMetadataBoolean(instance2);
        if (metadataBoolean.isAvailable()) {
            return metadataBoolean.get().booleanValue();
        }
        Optional<Boolean> remoteConfigBoolean = getRemoteConfigBoolean(instance2);
        if (remoteConfigBoolean.isAvailable()) {
            this.deviceCacheManager.setValue(instance2.getDeviceCacheFlag(), remoteConfigBoolean.get().booleanValue());
            return remoteConfigBoolean.get().booleanValue();
        }
        Optional<Boolean> deviceCacheBoolean = getDeviceCacheBoolean(instance2);
        if (deviceCacheBoolean.isAvailable()) {
            return deviceCacheBoolean.get().booleanValue();
        }
        return instance2.getDefault().booleanValue();
    }

    public Boolean getIsPerformanceCollectionDeactivated() {
        ConfigurationConstants.CollectionDeactivated instance2 = ConfigurationConstants.CollectionDeactivated.getInstance();
        Optional<Boolean> metadataBoolean = getMetadataBoolean(instance2);
        if (metadataBoolean.isAvailable()) {
            return metadataBoolean.get();
        }
        return instance2.getDefault();
    }

    public Boolean getIsPerformanceCollectionEnabled() {
        if (getIsPerformanceCollectionDeactivated().booleanValue()) {
            return Boolean.FALSE;
        }
        ConfigurationConstants.CollectionEnabled instance2 = ConfigurationConstants.CollectionEnabled.getInstance();
        Optional<Boolean> deviceCacheBoolean = getDeviceCacheBoolean(instance2);
        if (deviceCacheBoolean.isAvailable()) {
            return deviceCacheBoolean.get();
        }
        Optional<Boolean> metadataBoolean = getMetadataBoolean(instance2);
        if (metadataBoolean.isAvailable()) {
            return metadataBoolean.get();
        }
        return null;
    }

    public boolean getIsServiceCollectionEnabled() {
        return getIsSdkEnabled() && !getIsSdkVersionDisabled();
    }

    public long getNetworkEventCountBackground() {
        ConfigurationConstants.NetworkEventCountBackground instance2 = ConfigurationConstants.NetworkEventCountBackground.getInstance();
        Optional<Long> remoteConfigLong = getRemoteConfigLong(instance2);
        if (!remoteConfigLong.isAvailable() || !isEventCountValid(remoteConfigLong.get().longValue())) {
            Optional<Long> deviceCacheLong = getDeviceCacheLong(instance2);
            if (!deviceCacheLong.isAvailable() || !isEventCountValid(deviceCacheLong.get().longValue())) {
                return instance2.getDefault().longValue();
            }
            return deviceCacheLong.get().longValue();
        }
        this.deviceCacheManager.setValue(instance2.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
        return remoteConfigLong.get().longValue();
    }

    public long getNetworkEventCountForeground() {
        ConfigurationConstants.NetworkEventCountForeground instance2 = ConfigurationConstants.NetworkEventCountForeground.getInstance();
        Optional<Long> remoteConfigLong = getRemoteConfigLong(instance2);
        if (!remoteConfigLong.isAvailable() || !isEventCountValid(remoteConfigLong.get().longValue())) {
            Optional<Long> deviceCacheLong = getDeviceCacheLong(instance2);
            if (!deviceCacheLong.isAvailable() || !isEventCountValid(deviceCacheLong.get().longValue())) {
                return instance2.getDefault().longValue();
            }
            return deviceCacheLong.get().longValue();
        }
        this.deviceCacheManager.setValue(instance2.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
        return remoteConfigLong.get().longValue();
    }

    public double getNetworkRequestSamplingRate() {
        ConfigurationConstants.NetworkRequestSamplingRate instance2 = ConfigurationConstants.NetworkRequestSamplingRate.getInstance();
        Optional<Double> remoteConfigDouble = getRemoteConfigDouble(instance2);
        if (!remoteConfigDouble.isAvailable() || !isSamplingRateValid(remoteConfigDouble.get().doubleValue())) {
            Optional<Double> deviceCacheDouble = getDeviceCacheDouble(instance2);
            if (deviceCacheDouble.isAvailable() && isSamplingRateValid(deviceCacheDouble.get().doubleValue())) {
                return deviceCacheDouble.get().doubleValue();
            }
            if (this.remoteConfigManager.isLastFetchFailed()) {
                return instance2.getDefaultOnRcFetchFail().doubleValue();
            }
            return instance2.getDefault().doubleValue();
        }
        this.deviceCacheManager.setValue(instance2.getDeviceCacheFlag(), remoteConfigDouble.get().doubleValue());
        return remoteConfigDouble.get().doubleValue();
    }

    public long getRateLimitSec() {
        ConfigurationConstants.RateLimitSec instance2 = ConfigurationConstants.RateLimitSec.getInstance();
        Optional<Long> remoteConfigLong = getRemoteConfigLong(instance2);
        if (!remoteConfigLong.isAvailable() || !isTimeRangeSecValid(remoteConfigLong.get().longValue())) {
            Optional<Long> deviceCacheLong = getDeviceCacheLong(instance2);
            if (!deviceCacheLong.isAvailable() || !isTimeRangeSecValid(deviceCacheLong.get().longValue())) {
                return instance2.getDefault().longValue();
            }
            return deviceCacheLong.get().longValue();
        }
        this.deviceCacheManager.setValue(instance2.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
        return remoteConfigLong.get().longValue();
    }

    public long getSessionsCpuCaptureFrequencyBackgroundMs() {
        ConfigurationConstants.SessionsCpuCaptureFrequencyBackgroundMs instance2 = ConfigurationConstants.SessionsCpuCaptureFrequencyBackgroundMs.getInstance();
        Optional<Long> metadataLong = getMetadataLong(instance2);
        if (metadataLong.isAvailable() && isGaugeCaptureFrequencyMsValid(metadataLong.get().longValue())) {
            return metadataLong.get().longValue();
        }
        Optional<Long> remoteConfigLong = getRemoteConfigLong(instance2);
        if (!remoteConfigLong.isAvailable() || !isGaugeCaptureFrequencyMsValid(remoteConfigLong.get().longValue())) {
            Optional<Long> deviceCacheLong = getDeviceCacheLong(instance2);
            if (!deviceCacheLong.isAvailable() || !isGaugeCaptureFrequencyMsValid(deviceCacheLong.get().longValue())) {
                return instance2.getDefault().longValue();
            }
            return deviceCacheLong.get().longValue();
        }
        this.deviceCacheManager.setValue(instance2.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
        return remoteConfigLong.get().longValue();
    }

    public long getSessionsCpuCaptureFrequencyForegroundMs() {
        ConfigurationConstants.SessionsCpuCaptureFrequencyForegroundMs instance2 = ConfigurationConstants.SessionsCpuCaptureFrequencyForegroundMs.getInstance();
        Optional<Long> metadataLong = getMetadataLong(instance2);
        if (metadataLong.isAvailable() && isGaugeCaptureFrequencyMsValid(metadataLong.get().longValue())) {
            return metadataLong.get().longValue();
        }
        Optional<Long> remoteConfigLong = getRemoteConfigLong(instance2);
        if (!remoteConfigLong.isAvailable() || !isGaugeCaptureFrequencyMsValid(remoteConfigLong.get().longValue())) {
            Optional<Long> deviceCacheLong = getDeviceCacheLong(instance2);
            if (deviceCacheLong.isAvailable() && isGaugeCaptureFrequencyMsValid(deviceCacheLong.get().longValue())) {
                return deviceCacheLong.get().longValue();
            }
            if (this.remoteConfigManager.isLastFetchFailed()) {
                return instance2.getDefaultOnRcFetchFail().longValue();
            }
            return instance2.getDefault().longValue();
        }
        this.deviceCacheManager.setValue(instance2.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
        return remoteConfigLong.get().longValue();
    }

    public long getSessionsMaxDurationMinutes() {
        ConfigurationConstants.SessionsMaxDurationMinutes instance2 = ConfigurationConstants.SessionsMaxDurationMinutes.getInstance();
        Optional<Long> metadataLong = getMetadataLong(instance2);
        if (metadataLong.isAvailable() && isSessionsMaxDurationMinutesValid(metadataLong.get().longValue())) {
            return metadataLong.get().longValue();
        }
        Optional<Long> remoteConfigLong = getRemoteConfigLong(instance2);
        if (!remoteConfigLong.isAvailable() || !isSessionsMaxDurationMinutesValid(remoteConfigLong.get().longValue())) {
            Optional<Long> deviceCacheLong = getDeviceCacheLong(instance2);
            if (!deviceCacheLong.isAvailable() || !isSessionsMaxDurationMinutesValid(deviceCacheLong.get().longValue())) {
                return instance2.getDefault().longValue();
            }
            return deviceCacheLong.get().longValue();
        }
        this.deviceCacheManager.setValue(instance2.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
        return remoteConfigLong.get().longValue();
    }

    public long getSessionsMemoryCaptureFrequencyBackgroundMs() {
        ConfigurationConstants.SessionsMemoryCaptureFrequencyBackgroundMs instance2 = ConfigurationConstants.SessionsMemoryCaptureFrequencyBackgroundMs.getInstance();
        Optional<Long> metadataLong = getMetadataLong(instance2);
        if (metadataLong.isAvailable() && isGaugeCaptureFrequencyMsValid(metadataLong.get().longValue())) {
            return metadataLong.get().longValue();
        }
        Optional<Long> remoteConfigLong = getRemoteConfigLong(instance2);
        if (!remoteConfigLong.isAvailable() || !isGaugeCaptureFrequencyMsValid(remoteConfigLong.get().longValue())) {
            Optional<Long> deviceCacheLong = getDeviceCacheLong(instance2);
            if (!deviceCacheLong.isAvailable() || !isGaugeCaptureFrequencyMsValid(deviceCacheLong.get().longValue())) {
                return instance2.getDefault().longValue();
            }
            return deviceCacheLong.get().longValue();
        }
        this.deviceCacheManager.setValue(instance2.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
        return remoteConfigLong.get().longValue();
    }

    public long getSessionsMemoryCaptureFrequencyForegroundMs() {
        ConfigurationConstants.SessionsMemoryCaptureFrequencyForegroundMs instance2 = ConfigurationConstants.SessionsMemoryCaptureFrequencyForegroundMs.getInstance();
        Optional<Long> metadataLong = getMetadataLong(instance2);
        if (metadataLong.isAvailable() && isGaugeCaptureFrequencyMsValid(metadataLong.get().longValue())) {
            return metadataLong.get().longValue();
        }
        Optional<Long> remoteConfigLong = getRemoteConfigLong(instance2);
        if (!remoteConfigLong.isAvailable() || !isGaugeCaptureFrequencyMsValid(remoteConfigLong.get().longValue())) {
            Optional<Long> deviceCacheLong = getDeviceCacheLong(instance2);
            if (deviceCacheLong.isAvailable() && isGaugeCaptureFrequencyMsValid(deviceCacheLong.get().longValue())) {
                return deviceCacheLong.get().longValue();
            }
            if (this.remoteConfigManager.isLastFetchFailed()) {
                return instance2.getDefaultOnRcFetchFail().longValue();
            }
            return instance2.getDefault().longValue();
        }
        this.deviceCacheManager.setValue(instance2.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
        return remoteConfigLong.get().longValue();
    }

    public double getSessionsSamplingRate() {
        ConfigurationConstants.SessionsSamplingRate instance2 = ConfigurationConstants.SessionsSamplingRate.getInstance();
        Optional<Double> metadataDouble = getMetadataDouble(instance2);
        if (metadataDouble.isAvailable()) {
            double doubleValue = metadataDouble.get().doubleValue() / 100.0d;
            if (isSamplingRateValid(doubleValue)) {
                return doubleValue;
            }
        }
        Optional<Double> remoteConfigDouble = getRemoteConfigDouble(instance2);
        if (!remoteConfigDouble.isAvailable() || !isSamplingRateValid(remoteConfigDouble.get().doubleValue())) {
            Optional<Double> deviceCacheDouble = getDeviceCacheDouble(instance2);
            if (deviceCacheDouble.isAvailable() && isSamplingRateValid(deviceCacheDouble.get().doubleValue())) {
                return deviceCacheDouble.get().doubleValue();
            }
            if (this.remoteConfigManager.isLastFetchFailed()) {
                return instance2.getDefaultOnRcFetchFail().doubleValue();
            }
            return instance2.getDefault().doubleValue();
        }
        this.deviceCacheManager.setValue(instance2.getDeviceCacheFlag(), remoteConfigDouble.get().doubleValue());
        return remoteConfigDouble.get().doubleValue();
    }

    public long getTraceEventCountBackground() {
        ConfigurationConstants.TraceEventCountBackground instance2 = ConfigurationConstants.TraceEventCountBackground.getInstance();
        Optional<Long> remoteConfigLong = getRemoteConfigLong(instance2);
        if (!remoteConfigLong.isAvailable() || !isEventCountValid(remoteConfigLong.get().longValue())) {
            Optional<Long> deviceCacheLong = getDeviceCacheLong(instance2);
            if (!deviceCacheLong.isAvailable() || !isEventCountValid(deviceCacheLong.get().longValue())) {
                return instance2.getDefault().longValue();
            }
            return deviceCacheLong.get().longValue();
        }
        this.deviceCacheManager.setValue(instance2.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
        return remoteConfigLong.get().longValue();
    }

    public long getTraceEventCountForeground() {
        ConfigurationConstants.TraceEventCountForeground instance2 = ConfigurationConstants.TraceEventCountForeground.getInstance();
        Optional<Long> remoteConfigLong = getRemoteConfigLong(instance2);
        if (!remoteConfigLong.isAvailable() || !isEventCountValid(remoteConfigLong.get().longValue())) {
            Optional<Long> deviceCacheLong = getDeviceCacheLong(instance2);
            if (!deviceCacheLong.isAvailable() || !isEventCountValid(deviceCacheLong.get().longValue())) {
                return instance2.getDefault().longValue();
            }
            return deviceCacheLong.get().longValue();
        }
        this.deviceCacheManager.setValue(instance2.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
        return remoteConfigLong.get().longValue();
    }

    public double getTraceSamplingRate() {
        ConfigurationConstants.TraceSamplingRate instance2 = ConfigurationConstants.TraceSamplingRate.getInstance();
        Optional<Double> remoteConfigDouble = getRemoteConfigDouble(instance2);
        if (!remoteConfigDouble.isAvailable() || !isSamplingRateValid(remoteConfigDouble.get().doubleValue())) {
            Optional<Double> deviceCacheDouble = getDeviceCacheDouble(instance2);
            if (deviceCacheDouble.isAvailable() && isSamplingRateValid(deviceCacheDouble.get().doubleValue())) {
                return deviceCacheDouble.get().doubleValue();
            }
            if (this.remoteConfigManager.isLastFetchFailed()) {
                return instance2.getDefaultOnRcFetchFail().doubleValue();
            }
            return instance2.getDefault().doubleValue();
        }
        this.deviceCacheManager.setValue(instance2.getDeviceCacheFlag(), remoteConfigDouble.get().doubleValue());
        return remoteConfigDouble.get().doubleValue();
    }

    public boolean isCollectionEnabledConfigValueAvailable() {
        Optional<Boolean> remoteConfigBoolean = getRemoteConfigBoolean(ConfigurationConstants.SdkEnabled.getInstance());
        if (getDeviceCacheBoolean(ConfigurationConstants.CollectionEnabled.getInstance()).isAvailable() || remoteConfigBoolean.isAvailable()) {
            return true;
        }
        return false;
    }

    public boolean isPerformanceMonitoringEnabled() {
        Boolean isPerformanceCollectionEnabled = getIsPerformanceCollectionEnabled();
        if ((isPerformanceCollectionEnabled == null || isPerformanceCollectionEnabled.booleanValue()) && getIsServiceCollectionEnabled()) {
            return true;
        }
        return false;
    }

    public void setApplicationContext(Context context) {
        logger.setLogcatEnabled(Utils.isDebugLoggingEnabled(context));
        this.deviceCacheManager.setContext(context);
    }

    public void setContentProviderContext(Context context) {
        setApplicationContext(context.getApplicationContext());
    }

    public void setDeviceCacheManager(DeviceCacheManager deviceCacheManager2) {
        this.deviceCacheManager = deviceCacheManager2;
    }

    public void setIsPerformanceCollectionEnabled(Boolean bool) {
        String deviceCacheFlag;
        if (getIsPerformanceCollectionDeactivated().booleanValue() || (deviceCacheFlag = ConfigurationConstants.CollectionEnabled.getInstance().getDeviceCacheFlag()) == null) {
            return;
        }
        if (bool != null) {
            this.deviceCacheManager.setValue(deviceCacheFlag, Boolean.TRUE.equals(bool));
        } else {
            this.deviceCacheManager.clear(deviceCacheFlag);
        }
    }

    public void setMetadataBundle(ImmutableBundle immutableBundle) {
        this.metadataBundle = immutableBundle;
    }
}
