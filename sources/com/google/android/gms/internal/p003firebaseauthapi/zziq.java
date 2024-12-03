package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziq  reason: invalid package */
final class zziq extends zznf {
    final /* synthetic */ zzir zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zziq(zzir zzir, Class cls) {
        super(cls);
        this.zza = zzir;
    }

    public final /* bridge */ /* synthetic */ zzalp zza(zzalp zzalp) throws GeneralSecurityException {
        zztr zzb = zzts.zzb();
        byte[] zzb2 = zzor.zzb(((zztv) zzalp).zza());
        zzb.zza(zzajf.zzn(zzb2, 0, zzb2.length));
        zzb.zzb(0);
        return (zzts) zzb.zzi();
    }

    public final /* synthetic */ zzalp zzb(zzajf zzajf) throws zzaks {
        return zztv.zze(zzajf, zzajx.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES256_SIV", zzji.zza);
        zzit zzit = new zzit((zzis) null);
        zzit.zza(64);
        zzit.zzb(zziu.zzc);
        hashMap.put("AES256_SIV_RAW", zzit.zzc());
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzalp zzalp) throws GeneralSecurityException {
        zztv zztv = (zztv) zzalp;
        if (zztv.zza() != 64) {
            int zza2 = zztv.zza();
            throw new InvalidAlgorithmParameterException("invalid key size: " + zza2 + ". Valid keys must have 64 bytes.");
        }
    }
}
