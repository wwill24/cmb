package com.appsflyer.internal;

import android.app.Activity;
import android.net.Uri;
import androidx.annotation.NonNull;

public final class AFb1kSDK {
    public int AFInAppEventParameterName;
    public String AFInAppEventType;
    public long AFKeystoreWrapper;
    public String afErrorLog;
    public Throwable afInfoLog;
    public AFf1xSDK afRDLog;
    @NonNull
    public String valueOf;
    public long values;

    public AFb1kSDK() {
    }

    public AFb1kSDK(String str, String str2, long j10, long j11, int i10, AFf1xSDK aFf1xSDK, String str3, Throwable th2) {
        this.AFInAppEventType = str;
        this.valueOf = str2;
        this.values = j10;
        this.AFKeystoreWrapper = j11;
        this.AFInAppEventParameterName = i10;
        this.afRDLog = aFf1xSDK;
        this.afErrorLog = str3;
        this.afInfoLog = th2;
    }

    public static Uri values(Activity activity) {
        return activity.getReferrer();
    }
}
