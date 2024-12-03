package com.appsflyer.internal;

import android.os.Bundle;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;

public final class AFb1fSDK {
    private static String AFInAppEventType = "228";
    private Bundle AFKeystoreWrapper = null;
    public final AFc1ySDK valueOf;
    public final AFb1gSDK values;

    public AFb1fSDK(AFc1ySDK aFc1ySDK, AFb1gSDK aFb1gSDK) {
        this.valueOf = aFc1ySDK;
        this.values = aFb1gSDK;
    }

    public static String AFInAppEventParameterName() {
        return AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
    }

    public static String valueOf() {
        StringBuilder sb2 = new StringBuilder("version: 6.10.0 (build ");
        sb2.append(AFInAppEventType);
        sb2.append(")");
        return sb2.toString();
    }

    public final String AFKeystoreWrapper(String str) {
        Object obj;
        try {
            if (this.AFKeystoreWrapper == null) {
                this.AFKeystoreWrapper = this.valueOf.values.getPackageManager().getApplicationInfo(this.valueOf.values.getPackageName(), 128).metaData;
            }
            Bundle bundle = this.AFKeystoreWrapper;
            if (bundle == null || (obj = bundle.get(str)) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable th2) {
            StringBuilder sb2 = new StringBuilder("Could not load manifest metadata!");
            sb2.append(th2.getMessage());
            AFLogger.afErrorLog(sb2.toString(), th2);
            return null;
        }
    }

    public final String values() {
        String string = AppsFlyerProperties.getInstance().getString("channel");
        if (string == null) {
            string = AFKeystoreWrapper("CHANNEL");
        }
        if (string == null || !string.equals("")) {
            return string;
        }
        return null;
    }
}
