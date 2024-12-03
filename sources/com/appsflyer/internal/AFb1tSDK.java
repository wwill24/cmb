package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import org.json.JSONException;
import org.json.b;

public final class AFb1tSDK {
    public final String AFInAppEventType;
    public final int valueOf;
    public final int values;

    public AFb1tSDK() {
    }

    public AFb1tSDK(String str, int i10, int i11) {
        this.AFInAppEventType = str;
        this.values = i10;
        this.valueOf = i11;
    }

    static b AFKeystoreWrapper(String str) {
        b bVar = null;
        try {
            b bVar2 = new b(str);
            try {
                boolean z10 = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
                if (!bVar2.optBoolean("monitor", false) || z10) {
                    AFb1uSDK.AFInAppEventType().values();
                    AFb1uSDK.AFInAppEventType().AFInAppEventParameterName();
                } else {
                    AFb1uSDK.AFInAppEventType().valueOf();
                }
                if (!bVar2.has("ol_id")) {
                    return bVar2;
                }
                String optString = bVar2.optString("ol_scheme", (String) null);
                String optString2 = bVar2.optString("ol_domain", (String) null);
                String optString3 = bVar2.optString("ol_ver", (String) null);
                if (optString != null) {
                    AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_SCHEME, optString);
                }
                if (optString2 != null) {
                    AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_DOMAIN, optString2);
                }
                if (optString3 == null) {
                    return bVar2;
                }
                AppsFlyerProperties.getInstance().set("onelinkVersion", optString3);
                return bVar2;
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                AFLogger.afErrorLog(th.getMessage(), th);
                AFb1uSDK.AFInAppEventType().values();
                AFb1uSDK.AFInAppEventType().AFInAppEventParameterName();
                return bVar;
            }
        } catch (Throwable th3) {
            th = th3;
            AFLogger.afErrorLog(th.getMessage(), th);
            AFb1uSDK.AFInAppEventType().values();
            AFb1uSDK.AFInAppEventType().AFInAppEventParameterName();
            return bVar;
        }
    }

    public final String AFInAppEventType() {
        b bVar = new b();
        try {
            bVar.put("sdk_ver", (Object) this.AFInAppEventType);
            bVar.put("min", this.values);
            bVar.put("expire", this.valueOf);
        } catch (JSONException unused) {
        }
        return bVar.toString();
    }

    public final int hashCode() {
        int i10;
        String str = this.AFInAppEventType;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        return (((i10 * 31) + this.values) * 31) + this.valueOf;
    }
}
