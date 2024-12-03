package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.appsflyer.AFInAppEventType;

public final class AFe1dSDK extends AFe1aSDK {
    public AFe1dSDK(@NonNull Context context) {
        super(AFInAppEventType.PURCHASE, Boolean.TRUE, context);
    }

    public final AFa1sSDK AFInAppEventType(String str) {
        return super.AFInAppEventType(AFInAppEventParameterName(str));
    }

    public final AFd1wSDK values() {
        return AFd1wSDK.PURCHASE_VALIDATE;
    }
}
