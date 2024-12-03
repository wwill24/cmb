package com.appsflyer.internal;

public final class AFb1sSDK {
    final String AFInAppEventParameterName;
    private final boolean AFKeystoreWrapper;
    final long values;

    public AFb1sSDK() {
    }

    public AFb1sSDK(String str, long j10, boolean z10) {
        this.AFInAppEventParameterName = str;
        this.values = j10;
        this.AFKeystoreWrapper = z10;
    }

    public final boolean AFInAppEventType() {
        return this.AFKeystoreWrapper;
    }
}
