package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import java.util.Map;
import org.json.JSONException;

public final class AFe1qSDK extends AFd1tSDK<Void> {
    private final AFb1gSDK AFLogger;
    private final Throwable afErrorLog;
    private final AFc1dSDK<String> afRDLog;

    public AFe1qSDK(AFd1iSDK aFd1iSDK, AFb1gSDK aFb1gSDK) {
        super(AFd1wSDK.GCDSDK, new AFd1wSDK[]{AFd1wSDK.RC_CDN}, "GCD-CHECK");
        this.afErrorLog = aFd1iSDK.afDebugLog();
        this.afRDLog = aFd1iSDK.afDebugLog;
        this.AFLogger = aFb1gSDK;
    }

    private Map<String, Object> afErrorLog() {
        String valueOf = this.AFLogger.valueOf("attributionId", (String) null);
        if (valueOf == null) {
            return null;
        }
        try {
            new AFc1kSDK();
            return AFc1kSDK.AFInAppEventType(valueOf);
        } catch (JSONException e10) {
            StringBuilder sb2 = new StringBuilder("[GCD] Failed to parse GCD response: ");
            sb2.append(e10.getMessage());
            AFLogger.afErrorLog(sb2.toString(), e10);
            return null;
        }
    }

    @NonNull
    public final AFc1aSDK AFInAppEventParameterName() throws Exception {
        AFLogger.afDebugLog("[GCD-A01] Loading conversion data. Counter: ".concat(String.valueOf(this.AFLogger.AFInAppEventType("appsFlyerCount", 0))));
        long valueOf = this.AFLogger.valueOf("appsflyerConversionDataCacheExpiration", 0);
        if (valueOf != 0 && System.currentTimeMillis() - valueOf > 5184000000L) {
            AFLogger.afDebugLog("[GCD-E02] Cached conversion data expired");
            this.AFLogger.valueOf("sixtyDayConversionData", true);
            this.AFLogger.AFInAppEventParameterName("attributionId", (String) null);
            this.AFLogger.AFInAppEventType("appsflyerConversionDataCacheExpiration", 0);
        }
        Map<String, Object> afErrorLog2 = afErrorLog();
        if (afErrorLog2 != null) {
            try {
                if (!afErrorLog2.containsKey("is_first_launch")) {
                    afErrorLog2.put("is_first_launch", Boolean.FALSE);
                }
                AFe1tSDK.AFInAppEventParameterName(afErrorLog2);
            } catch (Exception e10) {
                StringBuilder sb2 = new StringBuilder("[GCD] Error executing conversion data callback: ");
                sb2.append(e10.getLocalizedMessage());
                AFLogger.afErrorLog(sb2.toString(), e10);
            }
            return AFc1aSDK.SUCCESS;
        }
        try {
            if (this.afErrorLog != null) {
                StringBuilder sb3 = new StringBuilder("Launch exception: ");
                sb3.append(this.afErrorLog.getMessage());
                AFe1tSDK.AFInAppEventType(sb3.toString());
                return AFc1aSDK.SUCCESS;
            }
            AFc1dSDK<String> aFc1dSDK = this.afRDLog;
            if (aFc1dSDK != null && !aFc1dSDK.isSuccessful()) {
                StringBuilder sb4 = new StringBuilder("Launch status code: ");
                sb4.append(this.afRDLog.getStatusCode());
                AFe1tSDK.AFInAppEventType(sb4.toString());
                return AFc1aSDK.SUCCESS;
            }
            return AFc1aSDK.FAILURE;
        } catch (Exception e11) {
            StringBuilder sb5 = new StringBuilder("[GCD] Error executing conversion data callback: ");
            sb5.append(e11.getLocalizedMessage());
            AFLogger.afErrorLog(sb5.toString(), e11);
        }
    }

    public final long AFInAppEventType() {
        return 1000;
    }

    public final boolean valueOf() {
        return false;
    }
}
