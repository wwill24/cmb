package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.HashMap;
import java.util.Map;

public abstract class AFa1sSDK {
    String AFInAppEventParameterName;
    public AppsFlyerRequestListener AFInAppEventType;
    public Application AFKeystoreWrapper;
    public String AFLogger;
    public int afDebugLog;
    public String afErrorLog;
    private byte[] afErrorLogForExcManagerOnly;
    String afInfoLog;
    String afRDLog;
    private final boolean afWarnLog;
    public final Map<String, Object> valueOf;
    Map<String, Object> values;

    public AFa1sSDK() {
        this((String) null, (String) null, (Boolean) null, (Context) null);
    }

    public final AFa1sSDK AFInAppEventParameterName(int i10) {
        this.afDebugLog = i10;
        synchronized (this.valueOf) {
            if (this.valueOf.containsKey("counter")) {
                this.valueOf.put("counter", Integer.toString(i10));
            }
            if (this.valueOf.containsKey("launch_counter")) {
                this.valueOf.put("launch_counter", Integer.toString(i10));
            }
        }
        return this;
    }

    public AFa1sSDK AFInAppEventType(String str) {
        this.AFLogger = str;
        return this;
    }

    public final boolean AFKeystoreWrapper() {
        return this.afRDLog == null && this.afErrorLog == null;
    }

    public boolean afDebugLog() {
        return true;
    }

    public boolean afErrorLog() {
        return true;
    }

    public boolean afInfoLog() {
        return false;
    }

    public boolean afRDLog() {
        return true;
    }

    public final AFa1sSDK valueOf(String str, Object obj) {
        synchronized (this.valueOf) {
            this.valueOf.put(str, obj);
        }
        return this;
    }

    public abstract AFd1wSDK values();

    public AFa1sSDK(String str, String str2, Boolean bool, Context context) {
        this.valueOf = new HashMap();
        this.afRDLog = str;
        this.AFLogger = str2;
        this.afWarnLog = bool != null ? bool.booleanValue() : true;
        if (context != null) {
            this.AFKeystoreWrapper = (Application) context.getApplicationContext();
        }
    }

    public final AFa1sSDK AFInAppEventType(Map<String, ?> map) {
        synchronized (map) {
            this.valueOf.putAll(map);
        }
        return this;
    }

    public final byte[] valueOf() {
        return this.afErrorLogForExcManagerOnly;
    }

    public final Map<String, Object> AFInAppEventType() {
        return this.valueOf;
    }

    public final AFa1sSDK AFInAppEventParameterName(byte[] bArr) {
        this.afErrorLogForExcManagerOnly = bArr;
        return this;
    }

    public final boolean AFInAppEventParameterName() {
        return this.afWarnLog;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final String AFInAppEventParameterName(String str) {
        String valueOf2 = AFb1zSDK.AFInAppEventType().valueOf((Context) this.AFKeystoreWrapper);
        return valueOf2 != null ? Uri.parse(str).buildUpon().appendQueryParameter("channel", valueOf2).build().toString() : str;
    }
}
