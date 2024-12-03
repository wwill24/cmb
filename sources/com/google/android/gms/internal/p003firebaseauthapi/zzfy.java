package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfy  reason: invalid package */
public final class zzfy extends zzng {
    zzfy() {
        super(zzty.class, new zzfw(zzbd.class));
    }

    public final zznf zza() {
        return new zzfx(this, zzub.class);
    }

    public final zzwh zzb() {
        return zzwh.SYMMETRIC;
    }

    public final /* synthetic */ zzalp zzc(zzajf zzajf) throws zzaks {
        return zzty.zzd(zzajf, zzajx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public final /* bridge */ /* synthetic */ void zze(zzalp zzalp) throws GeneralSecurityException {
        zzty zzty = (zzty) zzalp;
        zzzl.zzc(zzty.zza(), 0);
        if (zzty.zze().zzd() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }
}
