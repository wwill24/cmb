package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.PurchaseHandler;
import java.util.Map;
import org.json.b;

public final class AFd1jSDK extends AFd1qSDK {
    private final AFb1fSDK AFLogger;

    public AFd1jSDK(@NonNull Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback, @NonNull AFc1xSDK aFc1xSDK) {
        super(AFd1wSDK.PURCHASE_VALIDATE, new AFd1wSDK[]{AFd1wSDK.RC_CDN}, aFc1xSDK, (String) null, map, purchaseValidationCallback);
        this.AFLogger = aFc1xSDK.values();
        this.AFInAppEventParameterName.add(AFd1wSDK.CONVERSION);
    }

    /* access modifiers changed from: protected */
    public final AFc1oSDK<String> AFInAppEventParameterName(@NonNull String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format("https://%sviap.%s/api/v1/android/validate_purchase?app_id=", new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1zSDK.AFInAppEventType().getHostName()}));
        sb2.append(this.AFLogger.valueOf.values.getPackageName());
        String obj = sb2.toString();
        String bVar = new b((Map<?, ?>) afErrorLogForExcManagerOnly()).toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this);
        sb3.append(": preparing data: ");
        sb3.append(bVar);
        AFc1sSDK.valueOf(sb3.toString());
        this.afInfoLog.valueOf(obj, bVar);
        return this.afErrorLog.valueOf(afErrorLogForExcManagerOnly(), str);
    }

    public final boolean valueOf() {
        AFc1dSDK<Result> aFc1dSDK = this.afDebugLog;
        if (aFc1dSDK == null || aFc1dSDK.getStatusCode() != 503) {
            return super.valueOf();
        }
        return true;
    }
}
