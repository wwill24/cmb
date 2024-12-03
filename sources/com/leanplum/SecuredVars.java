package com.leanplum;

import androidx.annotation.NonNull;

public class SecuredVars {
    private String json;
    private String signature;

    public SecuredVars(@NonNull String str, @NonNull String str2) {
        this.json = str;
        this.signature = str2;
    }

    @NonNull
    public String getJson() {
        return this.json;
    }

    @NonNull
    public String getSignature() {
        return this.signature;
    }
}
