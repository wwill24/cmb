package com.google.android.gms.internal.p003firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjy  reason: invalid package */
public final class zzjy extends zzlh {
    private final zzkg zza;
    private final zzzp zzb;
    private final zzzq zzc;

    private zzjy(zzkg zzkg, zzzp zzzp, zzzq zzzq) {
        this.zza = zzkg;
        this.zzb = zzzp;
        this.zzc = zzzq;
    }

    public static zzjy zza(zzkg zzkg, zzzq zzzq) throws GeneralSecurityException {
        if (zzkg.zzd() != null) {
            byte[] zzc2 = zzzq.zzc(zzbm.zza());
            byte[] zzc3 = zzkg.zzd().zzc();
            if (zzc2.length != 32) {
                throw new GeneralSecurityException("Private key bytes length for X25519 curve must be 32");
            } else if (Arrays.equals(zzzm.zzb(zzc2), zzc3)) {
                return new zzjy(zzkg, (zzzp) null, zzzq);
            } else {
                throw new GeneralSecurityException("Invalid private key for public key.");
            }
        } else {
            throw new GeneralSecurityException("ECIES private key for X25519 curve cannot be constructed with NIST-curve public key");
        }
    }

    public static zzjy zzb(zzkg zzkg, zzzp zzzp) throws GeneralSecurityException {
        if (zzkg.zze() != null) {
            BigInteger zzb2 = zzzp.zzb(zzbm.zza());
            ECPoint zze = zzkg.zze();
            zzjs zzc2 = zzkg.zza().zzc();
            BigInteger order = zzc(zzc2).getOrder();
            if (zzb2.signum() <= 0 || zzb2.compareTo(order) >= 0) {
                throw new GeneralSecurityException("Invalid private value");
            } else if (zzmq.zze(zzb2, zzc(zzc2)).equals(zze)) {
                return new zzjy(zzkg, zzzp, (zzzq) null);
            } else {
                throw new GeneralSecurityException("Invalid private value");
            }
        } else {
            throw new GeneralSecurityException("ECIES private key for NIST curve cannot be constructed with X25519-curve public key");
        }
    }

    private static ECParameterSpec zzc(zzjs zzjs) {
        if (zzjs == zzjs.zza) {
            return zzmq.zza;
        }
        if (zzjs == zzjs.zzb) {
            return zzmq.zzb;
        }
        if (zzjs == zzjs.zzc) {
            return zzmq.zzc;
        }
        throw new IllegalArgumentException("Unable to determine NIST curve type for ".concat(String.valueOf(zzjs)));
    }
}
