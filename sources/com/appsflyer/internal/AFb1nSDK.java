package com.appsflyer.internal;

import java.util.Objects;
import org.json.JSONException;
import org.json.b;

public final class AFb1nSDK {
    public final AFb1tSDK valueOf;

    public AFb1nSDK() {
    }

    public AFb1nSDK(b bVar) {
        AFb1tSDK aFb1tSDK;
        if (bVar.has("exc_mngr")) {
            try {
                b optJSONObject = bVar.getJSONArray("exc_mngr").s(0).optJSONObject("data");
                Objects.requireNonNull(optJSONObject);
                b optJSONObject2 = optJSONObject.optJSONObject("v1");
                aFb1tSDK = new AFb1tSDK(optJSONObject2.getString("sdk_ver"), optJSONObject2.optInt("min", -1), optJSONObject2.optInt("expire", -1));
            } catch (NullPointerException | JSONException unused) {
            }
            this.valueOf = aFb1tSDK;
        }
        aFb1tSDK = null;
        this.valueOf = aFb1tSDK;
    }

    public static boolean AFInAppEventParameterName(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean valueOf(String str) {
        return str == null || str.trim().length() == 0;
    }

    public final int hashCode() {
        AFb1tSDK aFb1tSDK = this.valueOf;
        if (aFb1tSDK != null) {
            return aFb1tSDK.hashCode();
        }
        return 0;
    }
}
