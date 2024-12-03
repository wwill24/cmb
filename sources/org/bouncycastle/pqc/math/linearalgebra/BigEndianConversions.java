package org.bouncycastle.pqc.math.linearalgebra;

public final class BigEndianConversions {
    private BigEndianConversions() {
    }

    public static void I2OSP(int i10, byte[] bArr, int i11) {
        int i12 = i11 + 1;
        bArr[i11] = (byte) (i10 >>> 24);
        int i13 = i12 + 1;
        bArr[i12] = (byte) (i10 >>> 16);
        bArr[i13] = (byte) (i10 >>> 8);
        bArr[i13 + 1] = (byte) i10;
    }

    public static void I2OSP(int i10, byte[] bArr, int i11, int i12) {
        int i13 = i12 - 1;
        for (int i14 = i13; i14 >= 0; i14--) {
            bArr[i11 + i14] = (byte) (i10 >>> ((i13 - i14) * 8));
        }
    }

    public static void I2OSP(long j10, byte[] bArr, int i10) {
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((int) (j10 >>> 56));
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((int) (j10 >>> 48));
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((int) (j10 >>> 40));
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((int) (j10 >>> 32));
        int i15 = i14 + 1;
        bArr[i14] = (byte) ((int) (j10 >>> 24));
        int i16 = i15 + 1;
        bArr[i15] = (byte) ((int) (j10 >>> 16));
        bArr[i16] = (byte) ((int) (j10 >>> 8));
        bArr[i16 + 1] = (byte) ((int) j10);
    }

    public static byte[] I2OSP(int i10) {
        return new byte[]{(byte) (i10 >>> 24), (byte) (i10 >>> 16), (byte) (i10 >>> 8), (byte) i10};
    }

    public static byte[] I2OSP(int i10, int i11) throws ArithmeticException {
        if (i10 < 0) {
            return null;
        }
        int ceilLog256 = IntegerFunctions.ceilLog256(i10);
        if (ceilLog256 <= i11) {
            byte[] bArr = new byte[i11];
            int i12 = i11 - 1;
            for (int i13 = i12; i13 >= i11 - ceilLog256; i13--) {
                bArr[i13] = (byte) (i10 >>> ((i12 - i13) * 8));
            }
            return bArr;
        }
        throw new ArithmeticException("Cannot encode given integer into specified number of octets.");
    }

    public static byte[] I2OSP(long j10) {
        return new byte[]{(byte) ((int) (j10 >>> 56)), (byte) ((int) (j10 >>> 48)), (byte) ((int) (j10 >>> 40)), (byte) ((int) (j10 >>> 32)), (byte) ((int) (j10 >>> 24)), (byte) ((int) (j10 >>> 16)), (byte) ((int) (j10 >>> 8)), (byte) ((int) j10)};
    }

    public static int OS2IP(byte[] bArr) {
        if (bArr.length <= 4) {
            if (bArr.length == 0) {
                return 0;
            }
            int i10 = 0;
            for (int i11 = 0; i11 < bArr.length; i11++) {
                i10 |= (bArr[i11] & 255) << (((bArr.length - 1) - i11) * 8);
            }
            return i10;
        }
        throw new ArithmeticException("invalid input length");
    }

    public static int OS2IP(byte[] bArr, int i10) {
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        byte b10 = ((bArr[i10] & 255) << 24) | ((bArr[i11] & 255) << Tnaf.POW_2_WIDTH);
        return (bArr[i12 + 1] & 255) | b10 | ((bArr[i12] & 255) << 8);
    }

    public static int OS2IP(byte[] bArr, int i10, int i11) {
        if (bArr.length == 0 || bArr.length < (i10 + i11) - 1) {
            return 0;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 |= (bArr[i10 + i13] & 255) << (((i11 - i13) - 1) * 8);
        }
        return i12;
    }

    public static long OS2LIP(byte[] bArr, int i10) {
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        int i14 = i13 + 1;
        int i15 = i14 + 1;
        int i16 = i15 + 1;
        long j10 = ((((long) bArr[i10]) & 255) << 56) | ((((long) bArr[i11]) & 255) << 48) | ((((long) bArr[i12]) & 255) << 40) | ((((long) bArr[i13]) & 255) << 32) | ((255 & ((long) bArr[i14])) << 24) | ((long) ((bArr[i15] & 255) << Tnaf.POW_2_WIDTH));
        return ((long) (bArr[i16 + 1] & 255)) | j10 | ((long) ((bArr[i16] & 255) << 8));
    }

    public static byte[] toByteArray(int[] iArr) {
        byte[] bArr = new byte[(iArr.length << 2)];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            I2OSP(iArr[i10], bArr, i10 << 2);
        }
        return bArr;
    }

    public static byte[] toByteArray(int[] iArr, int i10) {
        int length = iArr.length;
        byte[] bArr = new byte[i10];
        int i11 = 0;
        int i12 = 0;
        while (i11 <= length - 2) {
            I2OSP(iArr[i11], bArr, i12);
            i11++;
            i12 += 4;
        }
        I2OSP(iArr[length - 1], bArr, i12, i10 - i12);
        return bArr;
    }

    public static int[] toIntArray(byte[] bArr) {
        int length = (bArr.length + 3) / 4;
        int length2 = bArr.length & 3;
        int[] iArr = new int[length];
        int i10 = 0;
        int i11 = 0;
        while (i10 <= length - 2) {
            iArr[i10] = OS2IP(bArr, i11);
            i10++;
            i11 += 4;
        }
        int i12 = length - 1;
        if (length2 != 0) {
            iArr[i12] = OS2IP(bArr, i11, length2);
        } else {
            iArr[i12] = OS2IP(bArr, i11);
        }
        return iArr;
    }
}
