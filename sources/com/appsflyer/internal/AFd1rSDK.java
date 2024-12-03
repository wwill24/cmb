package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.PurchaseHandler;
import java.util.Map;

public final class AFd1rSDK extends AFd1qSDK {
    public AFd1rSDK(@NonNull Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback, @NonNull AFc1xSDK aFc1xSDK) {
        super(AFd1wSDK.ARS_VALIDATE, new AFd1wSDK[]{AFd1wSDK.RC_CDN}, aFc1xSDK, (String) null, map, purchaseValidationCallback);
        this.AFInAppEventParameterName.add(AFd1wSDK.CONVERSION);
    }

    /* access modifiers changed from: protected */
    public final AFc1oSDK<String> AFInAppEventParameterName(@NonNull String str) {
        return this.afErrorLog.AFInAppEventType(afErrorLogForExcManagerOnly(), str);
    }
}
