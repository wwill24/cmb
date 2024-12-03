package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzago  reason: invalid package */
public enum zzago {
    REFRESH_TOKEN("refresh_token"),
    AUTHORIZATION_CODE("authorization_code");
    
    private final String zzd;

    private zzago(String str) {
        this.zzd = str;
    }

    public final String toString() {
        return this.zzd;
    }
}
