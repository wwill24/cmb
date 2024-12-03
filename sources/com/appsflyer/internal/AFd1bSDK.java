package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.HashMap;
import java.util.Map;

public final class AFd1bSDK extends AFd1kSDK<String> {
    private final Map<String, Object> AFLogger;

    public AFd1bSDK(@NonNull Map<String, Object> map, @NonNull AFc1xSDK aFc1xSDK) {
        super(AFd1wSDK.MONITORSDK, new AFd1wSDK[]{AFd1wSDK.RC_CDN}, aFc1xSDK, String.valueOf(map.hashCode()));
        this.AFLogger = new HashMap(map);
    }

    /* access modifiers changed from: protected */
    public final AFc1oSDK<String> AFInAppEventParameterName(@NonNull String str) {
        return this.afErrorLog.valueOf(this.AFLogger);
    }

    /* access modifiers changed from: protected */
    public final boolean AFLogger() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final AppsFlyerRequestListener afErrorLog() {
        return null;
    }
}
