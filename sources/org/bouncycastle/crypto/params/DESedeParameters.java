package org.bouncycastle.crypto.params;

public class DESedeParameters extends DESParameters {
    public static final int DES_EDE_KEY_LENGTH = 24;

    public DESedeParameters(byte[] bArr) {
        super(bArr);
        if (isWeakKey(bArr, 0, bArr.length)) {
            throw new IllegalArgumentException("attempt to create weak DESede key");
        }
    }

    public static boolean isReal2Key(byte[] bArr, int i10) {
        boolean z10 = false;
        for (int i11 = i10; i11 != i10 + 8; i11++) {
            if (bArr[i11] != bArr[i11 + 8]) {
                z10 = true;
            }
        }
        return z10;
    }

    public static boolean isReal3Key(byte[] bArr, int i10) {
        int i11 = i10;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        while (true) {
            boolean z13 = true;
            if (i11 == i10 + 8) {
                break;
            }
            byte b10 = bArr[i11];
            byte b11 = bArr[i11 + 8];
            z10 |= b10 != b11;
            byte b12 = bArr[i11 + 16];
            z11 |= b10 != b12;
            if (b11 == b12) {
                z13 = false;
            }
            z12 |= z13;
            i11++;
        }
        return z10 && z11 && z12;
    }

    public static boolean isRealEDEKey(byte[] bArr, int i10) {
        return bArr.length == 16 ? isReal2Key(bArr, i10) : isReal3Key(bArr, i10);
    }

    public static boolean isWeakKey(byte[] bArr, int i10) {
        return isWeakKey(bArr, i10, bArr.length - i10);
    }

    public static boolean isWeakKey(byte[] bArr, int i10, int i11) {
        while (i10 < i11) {
            if (DESParameters.isWeakKey(bArr, i10)) {
                return true;
            }
            i10 += 8;
        }
        return false;
    }
}
