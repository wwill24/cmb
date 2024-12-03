package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlj  reason: invalid package */
final class zzlj {
    public static String zza(zzvc zzvc) throws NoSuchAlgorithmException {
        zzud zzud = zzud.UNKNOWN_FORMAT;
        zzux zzux = zzux.UNKNOWN_CURVE;
        zzvc zzvc2 = zzvc.UNKNOWN_HASH;
        int ordinal = zzvc.ordinal();
        if (ordinal == 1) {
            return "HmacSha1";
        }
        if (ordinal == 2) {
            return "HmacSha384";
        }
        if (ordinal == 3) {
            return "HmacSha256";
        }
        if (ordinal == 4) {
            return "HmacSha512";
        }
        if (ordinal == 5) {
            return "HmacSha224";
        }
        throw new NoSuchAlgorithmException("hash unsupported for HMAC: ".concat(String.valueOf(zzvc)));
    }

    public static void zzb(zzum zzum) throws GeneralSecurityException {
        zzym.zzi(zzc(zzum.zzf().zzd()));
        zza(zzum.zzf().zze());
        if (zzum.zza() != zzud.UNKNOWN_FORMAT) {
            zzcq.zzb(zzum.zzb().zzd());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    public static int zzc(zzux zzux) throws GeneralSecurityException {
        zzud zzud = zzud.UNKNOWN_FORMAT;
        zzux zzux2 = zzux.UNKNOWN_CURVE;
        zzvc zzvc = zzvc.UNKNOWN_HASH;
        int ordinal = zzux.ordinal();
        int i10 = 1;
        if (ordinal != 1) {
            i10 = 2;
            if (ordinal != 2) {
                if (ordinal == 3) {
                    return 3;
                }
                throw new GeneralSecurityException("unknown curve type: ".concat(String.valueOf(zzux)));
            }
        }
        return i10;
    }

    public static int zzd(zzud zzud) throws GeneralSecurityException {
        zzud zzud2 = zzud.UNKNOWN_FORMAT;
        zzux zzux = zzux.UNKNOWN_CURVE;
        zzvc zzvc = zzvc.UNKNOWN_HASH;
        int ordinal = zzud.ordinal();
        int i10 = 1;
        if (ordinal != 1) {
            i10 = 2;
            if (ordinal != 2) {
                if (ordinal == 3) {
                    return 3;
                }
                throw new GeneralSecurityException("unknown point format: ".concat(String.valueOf(zzud)));
            }
        }
        return i10;
    }
}
