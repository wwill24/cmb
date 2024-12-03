package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class AFe1tSDK {
    public String AFInAppEventParameterName;
    public final WeakReference<Context> AFInAppEventType;

    public AFe1tSDK() {
    }

    public AFe1tSDK(Context context) {
        this.AFInAppEventType = new WeakReference<>(context);
    }

    static void AFInAppEventParameterName(Map<String, Object> map) {
        if (AFb1zSDK.valueOf != null) {
            StringBuilder sb2 = new StringBuilder("[GCD-A02] Calling onConversionDataSuccess with:\n");
            sb2.append(map.toString());
            AFLogger.afDebugLog(sb2.toString());
            AFb1zSDK.valueOf.onConversionDataSuccess(map);
        }
    }

    static void AFInAppEventType(String str) {
        if (AFb1zSDK.valueOf != null) {
            AFLogger.afDebugLog("[GCD-A02] Calling onConversionFailure with:\n".concat(String.valueOf(str)));
            AFb1zSDK.valueOf.onConversionDataFail(str);
        }
    }
}
