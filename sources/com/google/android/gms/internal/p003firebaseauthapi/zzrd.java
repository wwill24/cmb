package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrd  reason: invalid package */
public final class zzrd {
    public static byte[] zza(byte[] bArr) {
        int length = bArr.length;
        if (length < 16) {
            byte[] copyOf = Arrays.copyOf(bArr, 16);
            copyOf[length] = Byte.MIN_VALUE;
            return copyOf;
        }
        throw new IllegalArgumentException("x must be smaller than a block.");
    }

    public static byte[] zzb(byte[] bArr) {
        if (bArr.length == 16) {
            byte[] bArr2 = new byte[16];
            int i10 = 0;
            while (i10 < 16) {
                int i11 = i10 + 1;
                byte b10 = bArr[i10];
                byte b11 = (byte) ((b10 + b10) & 254);
                bArr2[i10] = b11;
                if (i10 < 15) {
                    bArr2[i10] = (byte) (((bArr[i11] >> 7) & 1) | b11);
                }
                i10 = i11;
            }
            bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & 135)) ^ bArr2[15]);
            return bArr2;
        }
        throw new IllegalArgumentException("value must be a block.");
    }
}
