package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzir  reason: invalid package */
public final class zzir extends zzng {
    zzir() {
        super(zzts.class, new zzip(zzbj.class));
    }

    public final zznf zza() {
        return new zziq(this, zztv.class);
    }

    public final zzwh zzb() {
        return zzwh.SYMMETRIC;
    }

    public final /* synthetic */ zzalp zzc(zzajf zzajf) throws zzaks {
        return zzts.zzd(zzajf, zzajx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzalp zzalp) throws GeneralSecurityException {
        zzts zzts = (zzts) zzalp;
        zzzl.zzc(zzts.zza(), 0);
        if (zzts.zze().zzd() != 64) {
            int zzd = zzts.zze().zzd();
            throw new InvalidKeyException("invalid key size: " + zzd + ". Valid keys must have 64 bytes.");
        }
    }
}
