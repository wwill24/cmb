package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjl  reason: invalid package */
public final class zzjl extends zzon {
    zzjl() {
        super(zzup.class, zzus.class, new zzjj(zzbk.class));
    }

    public final zznf zza() {
        return new zzjk(this, zzuj.class);
    }

    public final zzwh zzb() {
        return zzwh.ASYMMETRIC_PRIVATE;
    }

    public final /* synthetic */ zzalp zzc(zzajf zzajf) throws zzaks {
        return zzup.zzd(zzajf, zzajx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzalp zzalp) throws GeneralSecurityException {
        zzup zzup = (zzup) zzalp;
        if (!zzup.zzf().zzp()) {
            zzzl.zzc(zzup.zza(), 0);
            zzlj.zzb(zzup.zze().zzb());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }

    public final /* synthetic */ zzalp zzg(zzalp zzalp) throws GeneralSecurityException {
        return ((zzup) zzalp).zze();
    }
}
