package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgl  reason: invalid package */
final class zzgl extends zznf {
    final /* synthetic */ zzgm zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgl(zzgm zzgm, Class cls) {
        super(cls);
        this.zza = zzgm;
    }

    public final /* bridge */ /* synthetic */ zzalp zza(zzalp zzalp) throws GeneralSecurityException {
        zzxi zzb = zzxj.zzb();
        zzb.zza((zzxm) zzalp);
        zzb.zzb(0);
        return (zzxj) zzb.zzi();
    }

    public final /* synthetic */ zzalp zzb(zzajf zzajf) throws zzaks {
        return zzxm.zze(zzajf, zzajx.zza());
    }

    public final /* bridge */ /* synthetic */ void zzd(zzalp zzalp) throws GeneralSecurityException {
        zzxm zzxm = (zzxm) zzalp;
        if (!zzgj.zzc(zzxm.zza().zzg())) {
            String zzg = zzxm.zza().zzg();
            throw new GeneralSecurityException("Unsupported DEK key type: " + zzg + ". Only Tink AEAD key types are supported.");
        } else if (zzxm.zzf().isEmpty() || !zzxm.zzi()) {
            throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
        }
    }
}
