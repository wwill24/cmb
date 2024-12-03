package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgm  reason: invalid package */
public final class zzgm extends zzng {
    zzgm() {
        super(zzxj.class, new zzgk(zzbd.class));
    }

    public final zznf zza() {
        return new zzgl(this, zzxm.class);
    }

    public final zzwh zzb() {
        return zzwh.REMOTE;
    }

    public final /* synthetic */ zzalp zzc(zzajf zzajf) throws zzaks {
        return zzxj.zzd(zzajf, zzajx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzalp zzalp) throws GeneralSecurityException {
        zzxj zzxj = (zzxj) zzalp;
        zzzl.zzc(zzxj.zza(), 0);
        if (!zzgj.zzc(zzxj.zze().zza().zzg())) {
            String zzg = zzxj.zze().zza().zzg();
            throw new GeneralSecurityException("Unsupported DEK key type: " + zzg + ". Only Tink AEAD key types are supported.");
        }
    }
}
