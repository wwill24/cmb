package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzma  reason: invalid package */
public final class zzma extends zzng {
    public zzma() {
        super(zzwd.class, new zzlz(zzbl.class));
    }

    public final zzwh zzb() {
        return zzwh.ASYMMETRIC_PUBLIC;
    }

    public final /* synthetic */ zzalp zzc(zzajf zzajf) throws zzaks {
        return zzwd.zzf(zzajf, zzajx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HpkePublicKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzalp zzalp) throws GeneralSecurityException {
        zzwd zzwd = (zzwd) zzalp;
        zzzl.zzc(zzwd.zza(), 0);
        if (zzwd.zzl()) {
            zzmb.zzb(zzwd.zzb());
            return;
        }
        throw new GeneralSecurityException("Missing HPKE key params.");
    }
}
