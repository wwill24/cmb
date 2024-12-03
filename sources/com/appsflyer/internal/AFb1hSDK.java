package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;

public final class AFb1hSDK {
    public final Application AFKeystoreWrapper;

    public AFb1hSDK(Context context) {
        this.AFKeystoreWrapper = (Application) context.getApplicationContext();
    }
}
