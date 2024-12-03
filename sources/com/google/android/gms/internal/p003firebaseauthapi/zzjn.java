package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjn  reason: invalid package */
final class zzjn extends zzng {
    public zzjn() {
        super(zzus.class, new zzjm(zzbl.class));
    }

    public final zzwh zzb() {
        return zzwh.ASYMMETRIC_PUBLIC;
    }

    public final /* synthetic */ zzalp zzc(zzajf zzajf) throws zzaks {
        return zzus.zzf(zzajf, zzajx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzalp zzalp) throws GeneralSecurityException {
        zzus zzus = (zzus) zzalp;
        zzzl.zzc(zzus.zza(), 0);
        zzlj.zzb(zzus.zzb());
    }
}
