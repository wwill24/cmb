package com.google.android.gms.internal.p003firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmn  reason: invalid package */
public final class zzmn {
    public static BigInteger zza(byte[] bArr) {
        return new BigInteger(1, bArr);
    }

    public static byte[] zzb(BigInteger bigInteger) {
        if (bigInteger.signum() != -1) {
            return bigInteger.toByteArray();
        }
        throw new IllegalArgumentException("n must not be negative");
    }

    public static byte[] zzc(BigInteger bigInteger, int i10) throws GeneralSecurityException {
        if (bigInteger.signum() != -1) {
            byte[] byteArray = bigInteger.toByteArray();
            int length = byteArray.length;
            if (length == i10) {
                return byteArray;
            }
            int i11 = i10 + 1;
            if (length > i11) {
                throw new GeneralSecurityException("integer too large");
            } else if (length != i11) {
                byte[] bArr = new byte[i10];
                System.arraycopy(byteArray, 0, bArr, i10 - length, length);
                return bArr;
            } else if (byteArray[0] == 0) {
                return Arrays.copyOfRange(byteArray, 1, length);
            } else {
                throw new GeneralSecurityException("integer too large");
            }
        } else {
            throw new IllegalArgumentException("integer must be nonnegative");
        }
    }
}
