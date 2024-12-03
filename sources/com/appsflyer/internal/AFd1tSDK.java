package com.appsflyer.internal;

import android.net.TrafficStats;
import androidx.annotation.NonNull;
import com.mparticle.kits.AppsFlyerKit;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.cli.HelpFormatter;

public abstract class AFd1tSDK<Result> implements Comparable<AFd1tSDK<?>>, Callable<AFc1aSDK> {
    private static final AtomicInteger afErrorLog = new AtomicInteger();
    @NonNull
    public final Set<AFd1wSDK> AFInAppEventParameterName = new HashSet();
    public AFc1aSDK AFInAppEventType;
    @NonNull
    public final AFd1wSDK AFKeystoreWrapper;
    private final int AFLogger;
    private long afDebugLog;
    private Throwable afInfoLog;
    private final String afRDLog;
    private boolean getLevel;
    public volatile int valueOf;
    @NonNull
    public final Set<AFd1wSDK> values;

    public AFd1tSDK(@NonNull AFd1wSDK aFd1wSDK, @NonNull AFd1wSDK[] aFd1wSDKArr, String str) {
        HashSet hashSet = new HashSet();
        this.values = hashSet;
        int incrementAndGet = afErrorLog.incrementAndGet();
        this.AFLogger = incrementAndGet;
        this.getLevel = false;
        this.valueOf = 0;
        this.AFKeystoreWrapper = aFd1wSDK;
        Collections.addAll(hashSet, aFd1wSDKArr);
        if (str != null) {
            this.afRDLog = str;
        } else {
            this.afRDLog = String.valueOf(incrementAndGet);
        }
    }

    /* renamed from: AFInAppEventParameterName */
    public final int compareTo(AFd1tSDK<?> aFd1tSDK) {
        int i10 = this.AFKeystoreWrapper.onInstallConversionDataLoadedNative - aFd1tSDK.AFKeystoreWrapper.onInstallConversionDataLoadedNative;
        if (i10 != 0) {
            return i10;
        }
        if (this.afRDLog.equals(aFd1tSDK.afRDLog)) {
            return 0;
        }
        return this.AFLogger - aFd1tSDK.AFLogger;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract AFc1aSDK AFInAppEventParameterName() throws Exception;

    /* access modifiers changed from: protected */
    public abstract long AFInAppEventType();

    /* access modifiers changed from: protected */
    public void AFInAppEventType(Throwable th2) {
    }

    /* access modifiers changed from: protected */
    public void AFKeystoreWrapper() {
    }

    public final Throwable afDebugLog() {
        return this.afInfoLog;
    }

    /* renamed from: afInfoLog */
    public final AFc1aSDK call() throws Exception {
        TrafficStats.setThreadStatsTag(AppsFlyerKit.NAME.hashCode());
        this.AFInAppEventType = null;
        this.afInfoLog = null;
        long currentTimeMillis = System.currentTimeMillis();
        this.valueOf++;
        try {
            AFc1aSDK AFInAppEventParameterName2 = AFInAppEventParameterName();
            this.AFInAppEventType = AFInAppEventParameterName2;
            this.afDebugLog = System.currentTimeMillis() - currentTimeMillis;
            AFKeystoreWrapper();
            return AFInAppEventParameterName2;
        } catch (Throwable th2) {
            this.afDebugLog = System.currentTimeMillis() - currentTimeMillis;
            AFKeystoreWrapper();
            throw th2;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean afRDLog() {
        return this.getLevel;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AFd1tSDK aFd1tSDK = (AFd1tSDK) obj;
        if (this.AFKeystoreWrapper != aFd1tSDK.AFKeystoreWrapper) {
            return false;
        }
        return this.afRDLog.equals(aFd1tSDK.afRDLog);
    }

    public final int hashCode() {
        return (this.AFKeystoreWrapper.hashCode() * 31) + this.afRDLog.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.AFKeystoreWrapper);
        sb2.append(HelpFormatter.DEFAULT_OPT_PREFIX);
        sb2.append(this.afRDLog);
        String obj = sb2.toString();
        if (String.valueOf(this.AFLogger).equals(this.afRDLog)) {
            return obj;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj);
        sb3.append(HelpFormatter.DEFAULT_OPT_PREFIX);
        sb3.append(this.AFLogger);
        return sb3.toString();
    }

    /* access modifiers changed from: protected */
    public abstract boolean valueOf();

    public void values() {
        this.getLevel = true;
    }
}
