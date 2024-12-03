package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzon  reason: invalid package */
public abstract class zzon extends zzng {
    private final Class zza;

    @SafeVarargs
    protected zzon(Class cls, Class cls2, zzog... zzogArr) {
        super(cls, zzogArr);
        this.zza = cls2;
    }

    public abstract zzalp zzg(zzalp zzalp) throws GeneralSecurityException;
}
