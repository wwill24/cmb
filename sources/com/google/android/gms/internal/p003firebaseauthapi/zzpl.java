package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpl  reason: invalid package */
final class zzpl extends zznf {
    zzpl(zzpm zzpm, Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ zzalp zza(zzalp zzalp) throws GeneralSecurityException {
        zzsc zzsc = (zzsc) zzalp;
        zzry zzb = zzrz.zzb();
        zzb.zzc(0);
        byte[] zzb2 = zzor.zzb(zzsc.zza());
        zzb.zza(zzajf.zzn(zzb2, 0, zzb2.length));
        zzb.zzb(zzsc.zze());
        return (zzrz) zzb.zzi();
    }

    public final /* synthetic */ zzalp zzb(zzajf zzajf) throws zzaks {
        return zzsc.zzd(zzajf, zzajx.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        zzpr zzpr = zzrc.zze;
        hashMap.put("AES_CMAC", zzpr);
        hashMap.put("AES256_CMAC", zzpr);
        zzpo zzpo = new zzpo((zzpn) null);
        zzpo.zza(32);
        zzpo.zzb(16);
        zzpo.zzc(zzpp.zzd);
        hashMap.put("AES256_CMAC_RAW", zzpo.zzd());
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzalp zzalp) throws GeneralSecurityException {
        zzsc zzsc = (zzsc) zzalp;
        zzpm.zzn(zzsc.zze());
        zzpm.zzo(zzsc.zza());
    }
}
