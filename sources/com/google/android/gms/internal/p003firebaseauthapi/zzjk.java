package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjk  reason: invalid package */
final class zzjk extends zznf {
    final /* synthetic */ zzjl zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjk(zzjl zzjl, Class cls) {
        super(cls);
        this.zza = zzjl;
    }

    public final /* bridge */ /* synthetic */ zzalp zza(zzalp zzalp) throws GeneralSecurityException {
        zzuj zzuj = (zzuj) zzalp;
        KeyPair zzc = zzym.zzc(zzym.zzi(zzlj.zzc(zzuj.zzd().zzf().zzd())));
        ECPoint w10 = ((ECPublicKey) zzc.getPublic()).getW();
        zzur zzc2 = zzus.zzc();
        zzc2.zzb(0);
        zzc2.zza(zzuj.zzd());
        byte[] byteArray = w10.getAffineX().toByteArray();
        zzajf zzajf = zzajf.zzb;
        zzc2.zzc(zzajf.zzn(byteArray, 0, byteArray.length));
        byte[] byteArray2 = w10.getAffineY().toByteArray();
        zzc2.zzd(zzajf.zzn(byteArray2, 0, byteArray2.length));
        zzuo zzb = zzup.zzb();
        zzb.zzc(0);
        zzb.zzb((zzus) zzc2.zzi());
        byte[] byteArray3 = ((ECPrivateKey) zzc.getPrivate()).getS().toByteArray();
        zzb.zza(zzajf.zzn(byteArray3, 0, byteArray3.length));
        return (zzup) zzb.zzi();
    }

    public final /* synthetic */ zzalp zzb(zzajf zzajf) throws zzaks {
        return zzuj.zzc(zzajf, zzajx.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        zzjr zzjr = new zzjr((zzjq) null);
        zzjs zzjs = zzjs.zza;
        zzjr.zza(zzjs);
        zzjt zzjt = zzjt.zzc;
        zzjr.zzc(zzjt);
        zzju zzju = zzju.zzb;
        zzjr.zzd(zzju);
        zzjv zzjv = zzjv.zza;
        zzjr.zzf(zzjv);
        zzev zzc = zzey.zzc();
        zzc.zza(12);
        zzc.zzb(16);
        zzc.zzc(16);
        zzew zzew = zzew.zzc;
        zzc.zzd(zzew);
        zzjr.zzb(zzc.zze());
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", zzjr.zzg());
        zzjr zzjr2 = new zzjr((zzjq) null);
        zzjr2.zza(zzjs);
        zzjr2.zzc(zzjt);
        zzjr2.zzd(zzju);
        zzjv zzjv2 = zzjv.zzc;
        zzjr2.zzf(zzjv2);
        zzev zzc2 = zzey.zzc();
        zzc2.zza(12);
        zzc2.zzb(16);
        zzc2.zzc(16);
        zzc2.zzd(zzew);
        zzjr2.zzb(zzc2.zze());
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzjr2.zzg());
        zzjr zzjr3 = new zzjr((zzjq) null);
        zzjr3.zza(zzjs);
        zzjr3.zzc(zzjt);
        zzju zzju2 = zzju.zza;
        zzjr3.zzd(zzju2);
        zzjr3.zzf(zzjv);
        zzev zzc3 = zzey.zzc();
        zzc3.zza(12);
        zzc3.zzb(16);
        zzc3.zzc(16);
        zzc3.zzd(zzew);
        zzjr3.zzb(zzc3.zze());
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", zzjr3.zzg());
        zzjr zzjr4 = new zzjr((zzjq) null);
        zzjr4.zza(zzjs);
        zzjr4.zzc(zzjt);
        zzjr4.zzd(zzju2);
        zzjr4.zzf(zzjv2);
        zzev zzc4 = zzey.zzc();
        zzc4.zza(12);
        zzc4.zzb(16);
        zzc4.zzc(16);
        zzc4.zzd(zzew);
        zzjr4.zzb(zzc4.zze());
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzjr4.zzg());
        zzjr zzjr5 = new zzjr((zzjq) null);
        zzjr5.zza(zzjs);
        zzjr5.zzc(zzjt);
        zzjr5.zzd(zzju2);
        zzjr5.zzf(zzjv2);
        zzev zzc5 = zzey.zzc();
        zzc5.zza(12);
        zzc5.zzb(16);
        zzc5.zzc(16);
        zzc5.zzd(zzew);
        zzjr5.zzb(zzc5.zze());
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", zzjr5.zzg());
        zzjr zzjr6 = new zzjr((zzjq) null);
        zzjr6.zza(zzjs);
        zzjr6.zzc(zzjt);
        zzjr6.zzd(zzju);
        zzjr6.zzf(zzjv);
        zzdj zzf = zzdn.zzf();
        zzf.zza(16);
        zzf.zzc(32);
        zzf.zze(16);
        zzf.zzd(16);
        zzdk zzdk = zzdk.zzc;
        zzf.zzb(zzdk);
        zzdl zzdl = zzdl.zzc;
        zzf.zzf(zzdl);
        zzjr6.zzb(zzf.zzg());
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzjr6.zzg());
        zzjr zzjr7 = new zzjr((zzjq) null);
        zzjr7.zza(zzjs);
        zzjr7.zzc(zzjt);
        zzjr7.zzd(zzju);
        zzjr7.zzf(zzjv2);
        zzdj zzf2 = zzdn.zzf();
        zzf2.zza(16);
        zzf2.zzc(32);
        zzf2.zze(16);
        zzf2.zzd(16);
        zzf2.zzb(zzdk);
        zzf2.zzf(zzdl);
        zzjr7.zzb(zzf2.zzg());
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzjr7.zzg());
        zzjr zzjr8 = new zzjr((zzjq) null);
        zzjr8.zza(zzjs);
        zzjr8.zzc(zzjt);
        zzjr8.zzd(zzju2);
        zzjr8.zzf(zzjv);
        zzdj zzf3 = zzdn.zzf();
        zzf3.zza(16);
        zzf3.zzc(32);
        zzf3.zze(16);
        zzf3.zzd(16);
        zzf3.zzb(zzdk);
        zzf3.zzf(zzdl);
        zzjr8.zzb(zzf3.zzg());
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzjr8.zzg());
        zzjr zzjr9 = new zzjr((zzjq) null);
        zzjr9.zza(zzjs);
        zzjr9.zzc(zzjt);
        zzjr9.zzd(zzju2);
        zzjr9.zzf(zzjv2);
        zzdj zzf4 = zzdn.zzf();
        zzf4.zza(16);
        zzf4.zzc(32);
        zzf4.zze(16);
        zzf4.zzd(16);
        zzf4.zzb(zzdk);
        zzf4.zzf(zzdl);
        zzjr9.zzb(zzf4.zzg());
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzjr9.zzg());
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* synthetic */ void zzd(zzalp zzalp) throws GeneralSecurityException {
        zzlj.zzb(((zzuj) zzalp).zzd());
    }
}
