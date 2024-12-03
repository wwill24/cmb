package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzof  reason: invalid package */
public abstract class zzof {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzof(Class cls, Class cls2, zzoe zzoe) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzof zzb(zzod zzod, Class cls, Class cls2) {
        return new zzoc(cls, cls2, zzod);
    }

    public abstract Object zza(zzbn zzbn) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
