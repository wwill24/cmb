package com.appsflyer.internal;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public abstract class AFf1uSDK extends Observable {
    final Runnable AFInAppEventType;
    public final String AFKeystoreWrapper;
    public AFa1ySDK afDebugLog = AFa1ySDK.NOT_STARTED;
    public final String afInfoLog;
    long afRDLog;
    public final Map<String, Object> values = new HashMap();

    public enum AFa1ySDK {
        NOT_STARTED,
        STARTED,
        FINISHED
    }

    public AFf1uSDK(String str, String str2, Runnable runnable) {
        this.AFInAppEventType = runnable;
        this.AFKeystoreWrapper = str2;
        this.afInfoLog = str;
    }

    public abstract void AFInAppEventType(Context context);

    public final void valueOf() {
        this.values.put("source", this.AFKeystoreWrapper);
        this.values.put("type", this.afInfoLog);
        this.values.put("latency", Long.valueOf(System.currentTimeMillis() - this.afRDLog));
        this.afDebugLog = AFa1ySDK.FINISHED;
        setChanged();
        notifyObservers();
    }
}
