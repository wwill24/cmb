package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import java.nio.charset.Charset;

public final class AFe1wSDK {
    public static final Charset AFInAppEventType = Charset.forName("UTF-8");
    public AFb1oSDK AFInAppEventParameterName = AFInAppEventParameterName();
    public long AFKeystoreWrapper;
    public final AFb1gSDK valueOf;
    public long values;

    public AFe1wSDK(AFb1gSDK aFb1gSDK) {
        this.valueOf = aFb1gSDK;
        this.AFKeystoreWrapper = aFb1gSDK.valueOf("af_rc_timestamp", 0);
        this.values = aFb1gSDK.valueOf("af_rc_max_age", 0);
    }

    private AFb1oSDK AFInAppEventParameterName() {
        String valueOf2 = this.valueOf.valueOf("af_remote_config", (String) null);
        if (valueOf2 == null) {
            AFLogger.afDebugLog("CFG: No configuration found in cache");
            return null;
        }
        try {
            return new AFb1oSDK(new String(Base64.decode(valueOf2, 2), AFInAppEventType));
        } catch (Exception e10) {
            AFLogger.afErrorLog("CFG: Error reading malformed configuration from cache, requires fetching from remote again", e10, true);
            return null;
        }
    }
}
