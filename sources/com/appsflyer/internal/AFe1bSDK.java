package com.appsflyer.internal;

public final class AFe1bSDK extends AFa1sSDK {
    public final boolean afInfoLog() {
        return true;
    }

    public final AFd1wSDK values() {
        if (this.afDebugLog == 1) {
            return AFd1wSDK.CONVERSION;
        }
        return AFd1wSDK.LAUNCH;
    }
}
