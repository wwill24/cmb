package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzob  reason: invalid package */
public abstract class zzob {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzob(Class cls, Class cls2, zzoa zzoa) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzob zzb(zznz zznz, Class cls, Class cls2) {
        return new zzny(cls, cls2, zznz);
    }

    public abstract zzot zza(zzce zzce) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
