package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdh  reason: invalid package */
public final class zzdh extends zzng {
    zzdh() {
        super(zzsi.class, new zzdf(zzbd.class));
    }

    public final zznf zza() {
        return new zzdg(this, zzsl.class);
    }

    public final zzwh zzb() {
        return zzwh.SYMMETRIC;
    }

    public final /* synthetic */ zzalp zzc(zzajf zzajf) throws zzaks {
        return zzsi.zzd(zzajf, zzajx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzalp zzalp) throws GeneralSecurityException {
        zzsi zzsi = (zzsi) zzalp;
        zzzl.zzc(zzsi.zza(), 0);
        new zzdv();
        zzdv.zzh(zzsi.zze());
        new zzqj();
        zzqj.zzm(zzsi.zzf());
    }

    public final int zzf() {
        return 2;
    }
}
