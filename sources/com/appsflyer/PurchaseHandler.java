package com.appsflyer;

import androidx.annotation.NonNull;
import com.appsflyer.internal.AFa1aSDK;
import com.appsflyer.internal.AFb1fSDK;
import com.appsflyer.internal.AFc1xSDK;
import com.appsflyer.internal.AFd1xSDK;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.util.Map;

public final class PurchaseHandler {
    @NonNull
    public final AFc1xSDK AFInAppEventType;
    @NonNull
    private final AFb1fSDK valueOf;
    @NonNull
    public final AFd1xSDK values;

    public interface PurchaseValidationCallback {
        void onFailure(@NonNull Throwable th2);

        void onResponse(@NonNull ResponseNetwork<String> responseNetwork);
    }

    public PurchaseHandler(@NonNull AFc1xSDK aFc1xSDK) {
        this.AFInAppEventType = aFc1xSDK;
        this.valueOf = aFc1xSDK.values();
        this.values = aFc1xSDK.afDebugLog();
    }

    public final boolean valueOf(Map<String, Object> map, PurchaseValidationCallback purchaseValidationCallback, String... strArr) {
        boolean AFKeystoreWrapper = AFa1aSDK.AFKeystoreWrapper(map, strArr, this.valueOf);
        if (!AFKeystoreWrapper && purchaseValidationCallback != null) {
            purchaseValidationCallback.onFailure(new IllegalArgumentException("Invalid Request Data"));
        }
        return AFKeystoreWrapper;
    }
}
