package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.InvalidKeyException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzia  reason: invalid package */
public final class zzia extends zzib {
    public zzia(byte[] bArr, int i10) throws InvalidKeyException {
        super(bArr, i10);
    }

    public final int zza() {
        return 12;
    }

    public final int[] zzb(int[] iArr, int i10) {
        int length = iArr.length;
        if (length == 3) {
            int[] iArr2 = new int[16];
            zzhx.zzb(iArr2, this.zza);
            iArr2[12] = i10;
            System.arraycopy(iArr, 0, iArr2, 13, 3);
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", new Object[]{Integer.valueOf(length * 32)}));
    }
}
