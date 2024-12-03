package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqi  reason: invalid package */
final class zzqi extends zznf {
    final /* synthetic */ zzqj zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzqi(zzqj zzqj, Class cls) {
        super(cls);
        this.zza = zzqj;
    }

    public final /* bridge */ /* synthetic */ zzalp zza(zzalp zzalp) throws GeneralSecurityException {
        zzvi zzvi = (zzvi) zzalp;
        zzve zzb = zzvf.zzb();
        zzb.zzc(0);
        zzb.zzb(zzvi.zzg());
        byte[] zzb2 = zzor.zzb(zzvi.zza());
        zzb.zza(zzajf.zzn(zzb2, 0, zzb2.length));
        return (zzvf) zzb.zzi();
    }

    public final /* synthetic */ zzalp zzb(zzajf zzajf) throws zzaks {
        return zzvi.zzf(zzajf, zzajx.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("HMAC_SHA256_128BITTAG", zzrc.zza);
        zzql zzql = new zzql((zzqk) null);
        zzql.zzb(32);
        zzql.zzc(16);
        zzqn zzqn = zzqn.zzd;
        zzql.zzd(zzqn);
        zzqm zzqm = zzqm.zzc;
        zzql.zza(zzqm);
        hashMap.put("HMAC_SHA256_128BITTAG_RAW", zzql.zze());
        zzql zzql2 = new zzql((zzqk) null);
        zzql2.zzb(32);
        zzql2.zzc(32);
        zzqn zzqn2 = zzqn.zza;
        zzql2.zzd(zzqn2);
        zzql2.zza(zzqm);
        hashMap.put("HMAC_SHA256_256BITTAG", zzql2.zze());
        zzql zzql3 = new zzql((zzqk) null);
        zzql3.zzb(32);
        zzql3.zzc(32);
        zzql3.zzd(zzqn);
        zzql3.zza(zzqm);
        hashMap.put("HMAC_SHA256_256BITTAG_RAW", zzql3.zze());
        zzql zzql4 = new zzql((zzqk) null);
        zzql4.zzb(64);
        zzql4.zzc(16);
        zzql4.zzd(zzqn2);
        zzqm zzqm2 = zzqm.zze;
        zzql4.zza(zzqm2);
        hashMap.put("HMAC_SHA512_128BITTAG", zzql4.zze());
        zzql zzql5 = new zzql((zzqk) null);
        zzql5.zzb(64);
        zzql5.zzc(16);
        zzql5.zzd(zzqn);
        zzql5.zza(zzqm2);
        hashMap.put("HMAC_SHA512_128BITTAG_RAW", zzql5.zze());
        zzql zzql6 = new zzql((zzqk) null);
        zzql6.zzb(64);
        zzql6.zzc(32);
        zzql6.zzd(zzqn2);
        zzql6.zza(zzqm2);
        hashMap.put("HMAC_SHA512_256BITTAG", zzql6.zze());
        zzql zzql7 = new zzql((zzqk) null);
        zzql7.zzb(64);
        zzql7.zzc(32);
        zzql7.zzd(zzqn);
        zzql7.zza(zzqm2);
        hashMap.put("HMAC_SHA512_256BITTAG_RAW", zzql7.zze());
        hashMap.put("HMAC_SHA512_512BITTAG", zzrc.zzd);
        zzql zzql8 = new zzql((zzqk) null);
        zzql8.zzb(64);
        zzql8.zzc(64);
        zzql8.zzd(zzqn);
        zzql8.zza(zzqm2);
        hashMap.put("HMAC_SHA512_512BITTAG_RAW", zzql8.zze());
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzalp zzalp) throws GeneralSecurityException {
        zzvi zzvi = (zzvi) zzalp;
        if (zzvi.zza() >= 16) {
            zzqj.zzn(zzvi.zzg());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}
