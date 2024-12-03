package org.bouncycastle.crypto.modes;

import org.bouncycastle.util.Arrays;

class GOST3413CipherUtil {
    GOST3413CipherUtil() {
    }

    public static byte[] LSB(byte[] bArr, int i10) {
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, bArr.length - i10, bArr2, 0, i10);
        return bArr2;
    }

    public static byte[] MSB(byte[] bArr, int i10) {
        return Arrays.copyOf(bArr, i10);
    }

    public static byte[] copyFromInput(byte[] bArr, int i10, int i11) {
        if (bArr.length < i10 + i11) {
            i10 = bArr.length - i11;
        }
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, i11, bArr2, 0, i10);
        return bArr2;
    }

    public static byte[] sum(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr3[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
        }
        return bArr3;
    }
}
