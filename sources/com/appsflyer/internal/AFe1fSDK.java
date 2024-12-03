package com.appsflyer.internal;

import android.content.Context;

public final class AFe1fSDK extends AFa1sSDK {
    public final AFd1wSDK afWarnLog;

    @Deprecated
    public AFe1fSDK() {
        this.afWarnLog = null;
    }

    public final AFd1wSDK values() {
        AFd1wSDK aFd1wSDK = this.afWarnLog;
        if (aFd1wSDK != null) {
            return aFd1wSDK;
        }
        return AFd1wSDK.CACHED_EVENT;
    }

    public AFe1fSDK(String str, byte[] bArr, String str2, AFd1wSDK aFd1wSDK) {
        super((String) null, str, Boolean.FALSE, (Context) null);
        this.afErrorLog = str2;
        AFInAppEventParameterName(bArr);
        this.afWarnLog = aFd1wSDK;
    }
}
