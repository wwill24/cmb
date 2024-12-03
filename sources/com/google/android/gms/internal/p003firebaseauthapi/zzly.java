package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzly  reason: invalid package */
public final class zzly extends zzon {
    public zzly() {
        super(zzwa.class, zzwd.class, new zzlw(zzbk.class));
    }

    public final zznf zza() {
        return new zzlx(this, zzvu.class);
    }

    public final zzwh zzb() {
        return zzwh.ASYMMETRIC_PRIVATE;
    }

    public final /* synthetic */ zzalp zzc(zzajf zzajf) throws zzaks {
        return zzwa.zzd(zzajf, zzajx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HpkePrivateKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzalp zzalp) throws GeneralSecurityException {
        zzwa zzwa = (zzwa) zzalp;
        if (zzwa.zzf().zzp()) {
            throw new GeneralSecurityException("Private key is empty.");
        } else if (zzwa.zzk()) {
            zzzl.zzc(zzwa.zza(), 0);
            zzmb.zzb(zzwa.zze().zzb());
        } else {
            throw new GeneralSecurityException("Missing public key.");
        }
    }

    public final /* synthetic */ zzalp zzg(zzalp zzalp) throws GeneralSecurityException {
        return ((zzwa) zzalp).zze();
    }
}
