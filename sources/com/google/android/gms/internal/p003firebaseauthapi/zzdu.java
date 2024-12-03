package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdu  reason: invalid package */
final class zzdu extends zznf {
    final /* synthetic */ zzdv zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdu(zzdv zzdv, Class cls) {
        super(cls);
        this.zza = zzdv;
    }

    public static final zzso zzf(zzsr zzsr) throws GeneralSecurityException {
        zzsn zzb = zzso.zzb();
        zzb.zzb(zzsr.zzf());
        byte[] zzb2 = zzor.zzb(zzsr.zza());
        zzb.zza(zzajf.zzn(zzb2, 0, zzb2.length));
        zzb.zzc(0);
        return (zzso) zzb.zzi();
    }

    public final /* bridge */ /* synthetic */ zzalp zza(zzalp zzalp) throws GeneralSecurityException {
        return zzf((zzsr) zzalp);
    }

    public final /* synthetic */ zzalp zzb(zzajf zzajf) throws zzaks {
        return zzsr.zze(zzajf, zzajx.zza());
    }

    /* renamed from: zze */
    public final void zzd(zzsr zzsr) throws GeneralSecurityException {
        zzzl.zzb(zzsr.zza());
        zzdv.zzm(zzsr.zzf());
    }
}
