package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlx  reason: invalid package */
final class zzlx extends zznf {
    final /* synthetic */ zzly zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzlx(zzly zzly, Class cls) {
        super(cls);
        this.zza = zzly;
    }

    public final /* bridge */ /* synthetic */ zzalp zza(zzalp zzalp) throws GeneralSecurityException {
        byte[] bArr;
        byte[] bArr2;
        zzvu zzvu = (zzvu) zzalp;
        zzvr zzc = zzvu.zzd().zzc();
        zzvr zzvr = zzvr.KEM_UNKNOWN;
        int ordinal = zzc.ordinal();
        if (ordinal == 1) {
            bArr2 = zzor.zzb(32);
            bArr2[0] = (byte) (bArr2[0] | 7);
            byte b10 = bArr2[31] & 63;
            bArr2[31] = (byte) b10;
            bArr2[31] = (byte) (b10 | 128);
            bArr = zzzm.zzb(bArr2);
        } else if (ordinal == 2 || ordinal == 3 || ordinal == 4) {
            int zzh = zzmb.zzh(zzvu.zzd().zzc());
            KeyPair zzc2 = zzym.zzc(zzym.zzi(zzh));
            ECPoint w10 = ((ECPublicKey) zzc2.getPublic()).getW();
            EllipticCurve curve = zzym.zzi(zzh).getCurve();
            zzmq.zzf(w10, curve);
            int zza2 = zzym.zza(curve);
            int i10 = zza2 + zza2 + 1;
            bArr = new byte[i10];
            byte[] zzb = zzmn.zzb(w10.getAffineX());
            byte[] zzb2 = zzmn.zzb(w10.getAffineY());
            int length = zzb2.length;
            System.arraycopy(zzb2, 0, bArr, i10 - length, length);
            int length2 = zzb.length;
            System.arraycopy(zzb, 0, bArr, (zza2 + 1) - length2, length2);
            bArr[0] = 4;
            bArr2 = zzmn.zzc(((ECPrivateKey) zzc2.getPrivate()).getS(), zzmb.zza(zzc));
        } else {
            throw new GeneralSecurityException("Invalid KEM");
        }
        zzwc zzc3 = zzwd.zzc();
        zzc3.zzc(0);
        zzc3.zza(zzvu.zzd());
        zzc3.zzb(zzajf.zzn(bArr, 0, bArr.length));
        zzvz zzb3 = zzwa.zzb();
        zzb3.zzc(0);
        zzb3.zzb((zzwd) zzc3.zzi());
        zzb3.zza(zzajf.zzn(bArr2, 0, bArr2.length));
        return (zzwa) zzb3.zzi();
    }

    public final /* synthetic */ zzalp zzb(zzajf zzajf) throws zzaks {
        return zzvu.zzc(zzajf, zzajx.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        zzkl zzc = zzkq.zzc();
        zzko zzko = zzko.zza;
        zzc.zzd(zzko);
        zzkn zzkn = zzkn.zzf;
        zzc.zzc(zzkn);
        zzkm zzkm = zzkm.zza;
        zzc.zzb(zzkm);
        zzkh zzkh = zzkh.zza;
        zzc.zza(zzkh);
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzc.zze());
        zzkl zzc2 = zzkq.zzc();
        zzko zzko2 = zzko.zzc;
        zzc2.zzd(zzko2);
        zzc2.zzc(zzkn);
        zzc2.zzb(zzkm);
        zzc2.zza(zzkh);
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzc2.zze());
        zzkl zzc3 = zzkq.zzc();
        zzc3.zzd(zzko);
        zzc3.zzc(zzkn);
        zzc3.zzb(zzkm);
        zzkh zzkh2 = zzkh.zzb;
        zzc3.zza(zzkh2);
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzc3.zze());
        zzkl zzc4 = zzkq.zzc();
        zzc4.zzd(zzko2);
        zzc4.zzc(zzkn);
        zzc4.zzb(zzkm);
        zzc4.zza(zzkh2);
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzc4.zze());
        zzkl zzc5 = zzkq.zzc();
        zzc5.zzd(zzko);
        zzc5.zzc(zzkn);
        zzc5.zzb(zzkm);
        zzkh zzkh3 = zzkh.zzc;
        zzc5.zza(zzkh3);
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", zzc5.zze());
        zzkl zzc6 = zzkq.zzc();
        zzc6.zzd(zzko2);
        zzc6.zzc(zzkn);
        zzc6.zzb(zzkm);
        zzc6.zza(zzkh3);
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", zzc6.zze());
        zzkl zzc7 = zzkq.zzc();
        zzc7.zzd(zzko);
        zzkn zzkn2 = zzkn.zza;
        zzc7.zzc(zzkn2);
        zzc7.zzb(zzkm);
        zzc7.zza(zzkh);
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzc7.zze());
        zzkl zzc8 = zzkq.zzc();
        zzc8.zzd(zzko2);
        zzc8.zzc(zzkn2);
        zzc8.zzb(zzkm);
        zzc8.zza(zzkh);
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzc8.zze());
        zzkl zzc9 = zzkq.zzc();
        zzc9.zzd(zzko);
        zzc9.zzc(zzkn2);
        zzc9.zzb(zzkm);
        zzc9.zza(zzkh2);
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzc9.zze());
        zzkl zzc10 = zzkq.zzc();
        zzc10.zzd(zzko2);
        zzc10.zzc(zzkn2);
        zzc10.zzb(zzkm);
        zzc10.zza(zzkh2);
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzc10.zze());
        zzkl zzc11 = zzkq.zzc();
        zzc11.zzd(zzko);
        zzkn zzkn3 = zzkn.zzb;
        zzc11.zzc(zzkn3);
        zzkm zzkm2 = zzkm.zzb;
        zzc11.zzb(zzkm2);
        zzc11.zza(zzkh);
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", zzc11.zze());
        zzkl zzc12 = zzkq.zzc();
        zzc12.zzd(zzko2);
        zzc12.zzc(zzkn3);
        zzc12.zzb(zzkm2);
        zzc12.zza(zzkh);
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", zzc12.zze());
        zzkl zzc13 = zzkq.zzc();
        zzc13.zzd(zzko);
        zzc13.zzc(zzkn3);
        zzc13.zzb(zzkm2);
        zzc13.zza(zzkh2);
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", zzc13.zze());
        zzkl zzc14 = zzkq.zzc();
        zzc14.zzd(zzko2);
        zzc14.zzc(zzkn3);
        zzc14.zzb(zzkm2);
        zzc14.zza(zzkh2);
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", zzc14.zze());
        zzkl zzc15 = zzkq.zzc();
        zzc15.zzd(zzko);
        zzkn zzkn4 = zzkn.zzc;
        zzc15.zzc(zzkn4);
        zzkm zzkm3 = zzkm.zzc;
        zzc15.zzb(zzkm3);
        zzc15.zza(zzkh);
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", zzc15.zze());
        zzkl zzc16 = zzkq.zzc();
        zzc16.zzd(zzko2);
        zzc16.zzc(zzkn4);
        zzc16.zzb(zzkm3);
        zzc16.zza(zzkh);
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", zzc16.zze());
        zzkl zzc17 = zzkq.zzc();
        zzc17.zzd(zzko);
        zzc17.zzc(zzkn4);
        zzc17.zzb(zzkm3);
        zzc17.zza(zzkh2);
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", zzc17.zze());
        zzkl zzc18 = zzkq.zzc();
        zzc18.zzd(zzko2);
        zzc18.zzc(zzkn4);
        zzc18.zzb(zzkm3);
        zzc18.zza(zzkh2);
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", zzc18.zze());
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* synthetic */ void zzd(zzalp zzalp) throws GeneralSecurityException {
        zzmb.zzb(((zzvu) zzalp).zzd());
    }
}
