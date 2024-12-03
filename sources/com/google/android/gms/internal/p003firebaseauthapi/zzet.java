package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzet  reason: invalid package */
public final class zzet extends zzng {
    zzet() {
        super(zztg.class, new zzer(zzbd.class));
    }

    public final zznf zza() {
        return new zzes(this, zztj.class);
    }

    public final zzwh zzb() {
        return zzwh.SYMMETRIC;
    }

    public final /* synthetic */ zzalp zzc(zzajf zzajf) throws zzaks {
        return zztg.zzd(zzajf, zzajx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzalp zzalp) throws GeneralSecurityException {
        zztg zztg = (zztg) zzalp;
        zzzl.zzc(zztg.zza(), 0);
        zzzl.zzb(zztg.zze().zzd());
    }

    public final int zzf() {
        return 2;
    }
}
