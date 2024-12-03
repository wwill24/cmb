package com.appsflyer.internal;

import android.content.Context;

public abstract class AFe1jSDK extends AFa1sSDK {
    private final boolean AFLogger$LogLevel;
    public boolean AFVersionDeclaration;
    private final boolean getLevel;

    AFe1jSDK() {
        this((String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (Context) null);
    }

    public final boolean AFVersionDeclaration() {
        return this.AFVersionDeclaration;
    }

    public final boolean afErrorLogForExcManagerOnly() {
        return this.AFLogger$LogLevel;
    }

    public final boolean afWarnLog() {
        return this.getLevel;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFe1jSDK(String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, Context context) {
        super(str, str2, Boolean.valueOf(bool3 != null ? bool3.booleanValue() : false), context);
        boolean z10 = true;
        this.AFLogger$LogLevel = bool != null ? bool.booleanValue() : true;
        this.getLevel = bool2 != null ? bool2.booleanValue() : z10;
    }
}
