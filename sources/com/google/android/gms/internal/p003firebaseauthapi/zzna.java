package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzna  reason: invalid package */
public abstract class zzna {
    private final zzzo zza;
    private final Class zzb;

    /* synthetic */ zzna(zzzo zzzo, Class cls, zzmz zzmz) {
        this.zza = zzzo;
        this.zzb = cls;
    }

    public static zzna zzb(zzmy zzmy, zzzo zzzo, Class cls) {
        return new zzmx(zzzo, cls, zzmy);
    }

    public abstract zzbn zza(zzot zzot, zzcr zzcr) throws GeneralSecurityException;

    public final zzzo zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
