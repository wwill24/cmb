package org.bouncycastle.pqc.math.linearalgebra;

import java.math.BigInteger;

public final class BigIntUtils {
    private BigIntUtils() {
    }

    public static boolean equals(BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2) {
        if (bigIntegerArr.length != bigIntegerArr2.length) {
            return false;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < bigIntegerArr.length; i11++) {
            i10 |= bigIntegerArr[i11].compareTo(bigIntegerArr2[i11]);
        }
        return i10 == 0;
    }

    public static void fill(BigInteger[] bigIntegerArr, BigInteger bigInteger) {
        for (int length = bigIntegerArr.length - 1; length >= 0; length--) {
            bigIntegerArr[length] = bigInteger;
        }
    }

    public static BigInteger[] subArray(BigInteger[] bigIntegerArr, int i10, int i11) {
        int i12 = i11 - i10;
        BigInteger[] bigIntegerArr2 = new BigInteger[i12];
        System.arraycopy(bigIntegerArr, i10, bigIntegerArr2, 0, i12);
        return bigIntegerArr2;
    }

    public static int[] toIntArray(BigInteger[] bigIntegerArr) {
        int[] iArr = new int[bigIntegerArr.length];
        for (int i10 = 0; i10 < bigIntegerArr.length; i10++) {
            iArr[i10] = bigIntegerArr[i10].intValue();
        }
        return iArr;
    }

    public static int[] toIntArrayModQ(int i10, BigInteger[] bigIntegerArr) {
        BigInteger valueOf = BigInteger.valueOf((long) i10);
        int[] iArr = new int[bigIntegerArr.length];
        for (int i11 = 0; i11 < bigIntegerArr.length; i11++) {
            iArr[i11] = bigIntegerArr[i11].mod(valueOf).intValue();
        }
        return iArr;
    }

    public static byte[] toMinimalByteArray(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == 1 || (bigInteger.bitLength() & 7) != 0) {
            return byteArray;
        }
        int bitLength = bigInteger.bitLength() >> 3;
        byte[] bArr = new byte[bitLength];
        System.arraycopy(byteArray, 1, bArr, 0, bitLength);
        return bArr;
    }
}
