package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvx  reason: invalid package */
public final class zzvx extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzvx zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzvx zzvx = new zzvx();
        zzb = zzvx;
        zzakk.zzH(zzvx.class, zzvx);
    }

    private zzvx() {
    }

    public static zzvw zzd() {
        return (zzvw) zzb.zzt();
    }

    public static zzvx zzf() {
        return zzb;
    }

    public final zzvn zza() {
        int i10 = this.zzf;
        zzvn zzvn = zzvn.AEAD_UNKNOWN;
        zzvn zzvn2 = i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? null : zzvn.CHACHA20_POLY1305 : zzvn.AES_256_GCM : zzvn.AES_128_GCM : zzvn.AEAD_UNKNOWN;
        return zzvn2 == null ? zzvn.UNRECOGNIZED : zzvn2;
    }

    public final zzvp zzb() {
        int i10 = this.zze;
        zzvp zzvp = zzvp.KDF_UNKNOWN;
        zzvp zzvp2 = i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? null : zzvp.HKDF_SHA512 : zzvp.HKDF_SHA384 : zzvp.HKDF_SHA256 : zzvp.KDF_UNKNOWN;
        return zzvp2 == null ? zzvp.UNRECOGNIZED : zzvp2;
    }

    public final zzvr zzc() {
        int i10 = this.zzd;
        zzvr zzvr = zzvr.KEM_UNKNOWN;
        zzvr zzvr2 = i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? null : zzvr.DHKEM_P521_HKDF_SHA512 : zzvr.DHKEM_P384_HKDF_SHA384 : zzvr.DHKEM_P256_HKDF_SHA256 : zzvr.DHKEM_X25519_HKDF_SHA256 : zzvr.KEM_UNKNOWN;
        return zzvr2 == null ? zzvr.UNRECOGNIZED : zzvr2;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        } else if (i11 == 3) {
            return new zzvx();
        } else {
            if (i11 == 4) {
                return new zzvw((zzvv) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
