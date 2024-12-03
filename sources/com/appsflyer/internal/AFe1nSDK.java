package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLinkResult;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.b;

public final class AFe1nSDK {
    public final AFb1gSDK AFInAppEventParameterName;
    public long AFInAppEventType = 0;
    public final Map<String, Object> AFKeystoreWrapper;
    public final long[] AFLogger = new long[2];
    public long AFLogger$LogLevel;
    public long afDebugLog = 0;
    public final long[] afErrorLog = new long[2];
    public final long[] afInfoLog = new long[2];
    public long afRDLog = 0;
    public long afWarnLog = 0;
    public final Map<String, Object> valueOf;
    public final Map<String, Object> values;

    public AFe1nSDK(AFb1gSDK aFb1gSDK) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.values = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        this.AFKeystoreWrapper = concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
        this.valueOf = concurrentHashMap3;
        this.AFInAppEventParameterName = aFb1gSDK;
        concurrentHashMap.putAll(AFInAppEventParameterName("first_launch"));
        concurrentHashMap2.putAll(AFInAppEventParameterName("ddl"));
        concurrentHashMap3.putAll(AFInAppEventParameterName("gcd"));
        this.AFLogger$LogLevel = aFb1gSDK.valueOf("prev_session_dur", 0);
    }

    public final void AFInAppEventParameterName(AFe1oSDK aFe1oSDK) {
        if (AFInAppEventParameterName()) {
            this.values.put("start_with", aFe1oSDK.toString());
            this.AFInAppEventParameterName.AFInAppEventParameterName("first_launch", new b((Map<?, ?>) this.values).toString());
        }
    }

    public final void AFKeystoreWrapper() {
        this.afDebugLog = System.currentTimeMillis();
        if (AFInAppEventParameterName()) {
            long j10 = this.AFInAppEventType;
            if (j10 != 0) {
                this.values.put("init_to_fg", Long.valueOf(this.afDebugLog - j10));
                this.AFInAppEventParameterName.AFInAppEventParameterName("first_launch", new b((Map<?, ?>) this.values).toString());
                return;
            }
            AFLogger.afInfoLog("Metrics: init ts is missing");
        }
    }

    public final void AFInAppEventParameterName(int i10) {
        long currentTimeMillis = System.currentTimeMillis();
        this.afRDLog = currentTimeMillis;
        if (i10 == 1) {
            long j10 = this.afDebugLog;
            if (j10 != 0) {
                this.values.put("from_fg", Long.valueOf(currentTimeMillis - j10));
                this.AFInAppEventParameterName.AFInAppEventParameterName("first_launch", new b((Map<?, ?>) this.values).toString());
                return;
            }
            AFLogger.afInfoLog("Metrics: fg ts is missing");
        }
    }

    public final void AFKeystoreWrapper(DeepLinkResult deepLinkResult, long j10) {
        this.AFKeystoreWrapper.put("status", deepLinkResult.getStatus().toString());
        this.AFKeystoreWrapper.put("timeout_value", Long.valueOf(j10));
        this.AFInAppEventParameterName.AFInAppEventParameterName("ddl", new b((Map<?, ?>) this.AFKeystoreWrapper).toString());
    }

    private Map<String, Object> AFInAppEventParameterName(String str) {
        Map<String, Object> emptyMap = Collections.emptyMap();
        String valueOf2 = this.AFInAppEventParameterName.valueOf(str, (String) null);
        if (valueOf2 == null) {
            return emptyMap;
        }
        try {
            return AFa1lSDK.AFInAppEventType(new b(valueOf2));
        } catch (Exception e10) {
            AFLogger.afErrorLog("Error while parsing cached json data", e10, true);
            return emptyMap;
        }
    }

    public final void AFKeystoreWrapper(int i10) {
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = this.afWarnLog;
        if (j10 != 0) {
            this.valueOf.put("net", Long.valueOf(currentTimeMillis - j10));
        } else {
            AFLogger.afInfoLog("Metrics: gcdStart ts is missing");
        }
        this.valueOf.put("retries", Integer.valueOf(i10));
        this.AFInAppEventParameterName.AFInAppEventParameterName("gcd", new b((Map<?, ?>) this.valueOf).toString());
    }

    public final boolean AFInAppEventParameterName() {
        return this.AFInAppEventParameterName.AFInAppEventType("appsFlyerCount", 0) == 0;
    }
}
