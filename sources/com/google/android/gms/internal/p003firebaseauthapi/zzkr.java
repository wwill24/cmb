package com.google.android.gms.internal.p003firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkr  reason: invalid package */
public final class zzkr extends zzlh {
    private final zzkz zza;
    private final zzzq zzb;

    private zzkr(zzkz zzkz, zzzq zzzq) {
        this.zza = zzkz;
        this.zzb = zzzq;
    }

    public static zzkr zza(zzkz zzkz, zzzq zzzq) throws GeneralSecurityException {
        ECParameterSpec eCParameterSpec;
        zzkn zze = zzkz.zza().zze();
        int zza2 = zzzq.zza();
        String str = "Encoded private key byte length for " + zze.toString() + " must be %d, not " + zza2;
        zzkn zzkn = zzkn.zza;
        if (zze == zzkn) {
            if (zza2 != 32) {
                throw new GeneralSecurityException(String.format(str, new Object[]{32}));
            }
        } else if (zze == zzkn.zzb) {
            if (zza2 != 48) {
                throw new GeneralSecurityException(String.format(str, new Object[]{48}));
            }
        } else if (zze == zzkn.zzc) {
            if (zza2 != 66) {
                throw new GeneralSecurityException(String.format(str, new Object[]{66}));
            }
        } else if (zze != zzkn.zzf) {
            throw new GeneralSecurityException("Unable to validate private key length for ".concat(zze.toString()));
        } else if (zza2 != 32) {
            throw new GeneralSecurityException(String.format(str, new Object[]{32}));
        }
        zzkn zze2 = zzkz.zza().zze();
        byte[] zzc = zzkz.zzc().zzc();
        byte[] zzc2 = zzzq.zzc(zzbm.zza());
        if (zze2 == zzkn || zze2 == zzkn.zzb || zze2 == zzkn.zzc) {
            if (zze2 == zzkn) {
                eCParameterSpec = zzmq.zza;
            } else if (zze2 == zzkn.zzb) {
                eCParameterSpec = zzmq.zzb;
            } else if (zze2 == zzkn.zzc) {
                eCParameterSpec = zzmq.zzc;
            } else {
                throw new IllegalArgumentException("Unable to determine NIST curve params for ".concat(zze2.toString()));
            }
            BigInteger order = eCParameterSpec.getOrder();
            BigInteger zza3 = zzmn.zza(zzc2);
            if (zza3.signum() <= 0 || zza3.compareTo(order) >= 0) {
                throw new GeneralSecurityException("Invalid private key.");
            } else if (!zzmq.zze(zza3, eCParameterSpec).equals(zzym.zzj(eCParameterSpec.getCurve(), 1, zzc))) {
                throw new GeneralSecurityException("Invalid private key for public key.");
            }
        } else if (zze2 != zzkn.zzf) {
            throw new IllegalArgumentException("Unable to validate key pair for ".concat(zze2.toString()));
        } else if (!Arrays.equals(zzzm.zzb(zzc2), zzc)) {
            throw new GeneralSecurityException("Invalid private key for public key.");
        }
        return new zzkr(zzkz, zzzq);
    }
}
