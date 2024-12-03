package com.appsflyer.internal;

import android.content.Context;

public abstract class AFe1aSDK extends AFe1jSDK {
    AFe1aSDK() {
        this((String) null, (Boolean) null, (Context) null);
    }

    public final boolean afDebugLog() {
        return false;
    }

    public final boolean afErrorLog() {
        return false;
    }

    public final boolean afRDLog() {
        return false;
    }

    AFe1aSDK(String str, Boolean bool, Context context) {
        super(str, (String) null, Boolean.FALSE, (Boolean) null, bool, context);
    }
}
