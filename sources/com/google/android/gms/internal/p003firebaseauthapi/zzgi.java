package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgi  reason: invalid package */
public final class zzgi extends zzng {
    zzgi() {
        super(zzxd.class, new zzgg(zzbd.class));
    }

    public final zznf zza() {
        return new zzgh(this, zzxg.class);
    }

    public final zzwh zzb() {
        return zzwh.REMOTE;
    }

    public final /* synthetic */ zzalp zzc(zzajf zzajf) throws zzaks {
        return zzxd.zzd(zzajf, zzajx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzalp zzalp) throws GeneralSecurityException {
        zzzl.zzc(((zzxd) zzalp).zza(), 0);
    }
}
