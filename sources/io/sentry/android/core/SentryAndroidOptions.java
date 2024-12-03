package io.sentry.android.core;

import io.sentry.SentryOptions;
import io.sentry.protocol.m;
import org.jetbrains.annotations.ApiStatus;

public final class SentryAndroidOptions extends SentryOptions {
    private boolean anrEnabled = true;
    private boolean anrReportInDebug = false;
    private long anrTimeoutIntervalMillis = 5000;
    private boolean attachScreenshot;
    private boolean attachViewHierarchy;
    private boolean collectAdditionalContext = true;
    private q0 debugImagesLoader = x0.a();
    private boolean enableActivityLifecycleBreadcrumbs = true;
    private boolean enableActivityLifecycleTracingAutoFinish = true;
    private boolean enableAppComponentBreadcrumbs = true;
    private boolean enableAppLifecycleBreadcrumbs = true;
    private boolean enableAutoActivityLifecycleTracing = true;
    private boolean enableFramesTracking = true;
    private boolean enableNetworkEventBreadcrumbs = true;
    private boolean enableSystemEventBreadcrumbs = true;
    private int profilingTracesHz = 101;
    private final long startupCrashDurationThresholdMillis = 2000;
    private long startupCrashFlushTimeoutMillis = 5000;

    public SentryAndroidOptions() {
        setSentryClientName("sentry.java.android/6.17.0");
        setSdkVersion(createSdkVersion());
        setAttachServerName(false);
        setEnableScopeSync(true);
    }

    private m createSdkVersion() {
        m k10 = m.k(getSdkVersion(), "sentry.java.android", "6.17.0");
        k10.c("maven:io.sentry:sentry-android-core", "6.17.0");
        return k10;
    }

    public void enableAllAutoBreadcrumbs(boolean z10) {
        this.enableActivityLifecycleBreadcrumbs = z10;
        this.enableAppComponentBreadcrumbs = z10;
        this.enableSystemEventBreadcrumbs = z10;
        this.enableAppLifecycleBreadcrumbs = z10;
        this.enableNetworkEventBreadcrumbs = z10;
        setEnableUserInteractionBreadcrumbs(z10);
    }

    public long getAnrTimeoutIntervalMillis() {
        return this.anrTimeoutIntervalMillis;
    }

    public q0 getDebugImagesLoader() {
        return this.debugImagesLoader;
    }

    @ApiStatus.Internal
    public int getProfilingTracesHz() {
        return this.profilingTracesHz;
    }

    @Deprecated
    public int getProfilingTracesIntervalMillis() {
        return 0;
    }

    @ApiStatus.Internal
    public long getStartupCrashDurationThresholdMillis() {
        return 2000;
    }

    /* access modifiers changed from: package-private */
    @ApiStatus.Internal
    public long getStartupCrashFlushTimeoutMillis() {
        return this.startupCrashFlushTimeoutMillis;
    }

    public boolean isAnrEnabled() {
        return this.anrEnabled;
    }

    public boolean isAnrReportInDebug() {
        return this.anrReportInDebug;
    }

    public boolean isAttachScreenshot() {
        return this.attachScreenshot;
    }

    public boolean isAttachViewHierarchy() {
        return this.attachViewHierarchy;
    }

    public boolean isCollectAdditionalContext() {
        return this.collectAdditionalContext;
    }

    public boolean isEnableActivityLifecycleBreadcrumbs() {
        return this.enableActivityLifecycleBreadcrumbs;
    }

    public boolean isEnableActivityLifecycleTracingAutoFinish() {
        return this.enableActivityLifecycleTracingAutoFinish;
    }

    public boolean isEnableAppComponentBreadcrumbs() {
        return this.enableAppComponentBreadcrumbs;
    }

    public boolean isEnableAppLifecycleBreadcrumbs() {
        return this.enableAppLifecycleBreadcrumbs;
    }

    public boolean isEnableAutoActivityLifecycleTracing() {
        return this.enableAutoActivityLifecycleTracing;
    }

    public boolean isEnableFramesTracking() {
        return this.enableFramesTracking;
    }

    public boolean isEnableNetworkEventBreadcrumbs() {
        return this.enableNetworkEventBreadcrumbs;
    }

    public boolean isEnableSystemEventBreadcrumbs() {
        return this.enableSystemEventBreadcrumbs;
    }

    public void setAnrEnabled(boolean z10) {
        this.anrEnabled = z10;
    }

    public void setAnrReportInDebug(boolean z10) {
        this.anrReportInDebug = z10;
    }

    public void setAnrTimeoutIntervalMillis(long j10) {
        this.anrTimeoutIntervalMillis = j10;
    }

    public void setAttachScreenshot(boolean z10) {
        this.attachScreenshot = z10;
    }

    public void setAttachViewHierarchy(boolean z10) {
        this.attachViewHierarchy = z10;
    }

    public void setCollectAdditionalContext(boolean z10) {
        this.collectAdditionalContext = z10;
    }

    public void setDebugImagesLoader(q0 q0Var) {
        if (q0Var == null) {
            q0Var = x0.a();
        }
        this.debugImagesLoader = q0Var;
    }

    public void setEnableActivityLifecycleBreadcrumbs(boolean z10) {
        this.enableActivityLifecycleBreadcrumbs = z10;
    }

    public void setEnableActivityLifecycleTracingAutoFinish(boolean z10) {
        this.enableActivityLifecycleTracingAutoFinish = z10;
    }

    public void setEnableAppComponentBreadcrumbs(boolean z10) {
        this.enableAppComponentBreadcrumbs = z10;
    }

    public void setEnableAppLifecycleBreadcrumbs(boolean z10) {
        this.enableAppLifecycleBreadcrumbs = z10;
    }

    public void setEnableAutoActivityLifecycleTracing(boolean z10) {
        this.enableAutoActivityLifecycleTracing = z10;
    }

    public void setEnableFramesTracking(boolean z10) {
        this.enableFramesTracking = z10;
    }

    public void setEnableNetworkEventBreadcrumbs(boolean z10) {
        this.enableNetworkEventBreadcrumbs = z10;
    }

    public void setEnableSystemEventBreadcrumbs(boolean z10) {
        this.enableSystemEventBreadcrumbs = z10;
    }

    @ApiStatus.Internal
    public void setProfilingTracesHz(int i10) {
        this.profilingTracesHz = i10;
    }

    @Deprecated
    public void setProfilingTracesIntervalMillis(int i10) {
    }

    /* access modifiers changed from: package-private */
    public void setStartupCrashFlushTimeoutMillis(long j10) {
        this.startupCrashFlushTimeoutMillis = j10;
    }
}
