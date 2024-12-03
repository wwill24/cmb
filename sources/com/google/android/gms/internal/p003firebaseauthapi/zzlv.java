package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlv  reason: invalid package */
public final class zzlv {
    public static zzlo zza(zzvx zzvx) throws GeneralSecurityException {
        if (zzvx.zza() == zzvn.AES_128_GCM) {
            return new zzll(16);
        }
        if (zzvx.zza() == zzvn.AES_256_GCM) {
            return new zzll(32);
        }
        if (zzvx.zza() == zzvn.CHACHA20_POLY1305) {
            return new zzlm();
        }
        throw new IllegalArgumentException("Unrecognized HPKE AEAD identifier");
    }

    public static zzls zzb(zzvx zzvx) {
        if (zzvx.zzb() == zzvp.HKDF_SHA256) {
            return new zzln("HmacSha256");
        }
        if (zzvx.zzb() == zzvp.HKDF_SHA384) {
            return new zzln("HmacSha384");
        }
        if (zzvx.zzb() == zzvp.HKDF_SHA512) {
            return new zzln("HmacSha512");
        }
        throw new IllegalArgumentException("Unrecognized HPKE KDF identifier");
    }

    public static zzlt zzc(zzvx zzvx) throws GeneralSecurityException {
        if (zzvx.zzc() == zzvr.DHKEM_X25519_HKDF_SHA256) {
            return new zzme(new zzln("HmacSha256"));
        }
        if (zzvx.zzc() == zzvr.DHKEM_P256_HKDF_SHA256) {
            return zzmc.zzc(1);
        }
        if (zzvx.zzc() == zzvr.DHKEM_P384_HKDF_SHA384) {
            return zzmc.zzc(2);
        }
        if (zzvx.zzc() == zzvr.DHKEM_P521_HKDF_SHA512) {
            return zzmc.zzc(3);
        }
        throw new IllegalArgumentException("Unrecognized HPKE KEM identifier");
    }
}
