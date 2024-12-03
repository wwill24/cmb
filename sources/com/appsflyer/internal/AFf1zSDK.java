package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;

public abstract class AFf1zSDK extends AFf1uSDK {
    public AFf1zSDK(String str, String str2, Runnable runnable) {
        super(str, str2, runnable);
    }

    protected static boolean valueOf(@NonNull Context context) {
        AFb1zSDK.AFInAppEventType();
        if (AFb1zSDK.AFInAppEventParameterName(AFb1zSDK.AFInAppEventType(context), false) <= 0) {
            return true;
        }
        AFLogger.afRDLog("Install referrer will not load, the counter > 1, ");
        return false;
    }
}
