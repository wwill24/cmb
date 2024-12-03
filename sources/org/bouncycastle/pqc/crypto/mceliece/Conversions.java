package org.bouncycastle.pqc.crypto.mceliece;

import java.math.BigInteger;
import org.bouncycastle.pqc.math.linearalgebra.BigIntUtils;
import org.bouncycastle.pqc.math.linearalgebra.GF2Vector;
import org.bouncycastle.pqc.math.linearalgebra.IntegerFunctions;

final class Conversions {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger ZERO = BigInteger.valueOf(0);

    private Conversions() {
    }

    public static byte[] decode(int i10, int i11, GF2Vector gF2Vector) {
        if (gF2Vector.getLength() == i10 && gF2Vector.getHammingWeight() == i11) {
            int[] vecArray = gF2Vector.getVecArray();
            BigInteger binomial = IntegerFunctions.binomial(i10, i11);
            BigInteger bigInteger = ZERO;
            int i12 = i10;
            for (int i13 = 0; i13 < i10; i13++) {
                binomial = binomial.multiply(BigInteger.valueOf((long) (i12 - i11))).divide(BigInteger.valueOf((long) i12));
                i12--;
                if ((vecArray[i13 >> 5] & (1 << (i13 & 31))) != 0) {
                    bigInteger = bigInteger.add(binomial);
                    i11--;
                    binomial = i12 == i11 ? ONE : binomial.multiply(BigInteger.valueOf((long) (i11 + 1))).divide(BigInteger.valueOf((long) (i12 - i11)));
                }
            }
            return BigIntUtils.toMinimalByteArray(bigInteger);
        }
        throw new IllegalArgumentException("vector has wrong length or hamming weight");
    }

    public static GF2Vector encode(int i10, int i11, byte[] bArr) {
        if (i10 >= i11) {
            BigInteger binomial = IntegerFunctions.binomial(i10, i11);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.compareTo(binomial) < 0) {
                GF2Vector gF2Vector = new GF2Vector(i10);
                int i12 = i10;
                for (int i13 = 0; i13 < i10; i13++) {
                    binomial = binomial.multiply(BigInteger.valueOf((long) (i12 - i11))).divide(BigInteger.valueOf((long) i12));
                    i12--;
                    if (binomial.compareTo(bigInteger) <= 0) {
                        gF2Vector.setBit(i13);
                        bigInteger = bigInteger.subtract(binomial);
                        i11--;
                        binomial = i12 == i11 ? ONE : binomial.multiply(BigInteger.valueOf((long) (i11 + 1))).divide(BigInteger.valueOf((long) (i12 - i11)));
                    }
                }
                return gF2Vector;
            }
            throw new IllegalArgumentException("Encoded number too large.");
        }
        throw new IllegalArgumentException("n < t");
    }

    public static byte[] signConversion(int i10, int i11, byte[] bArr) {
        if (i10 >= i11) {
            BigInteger binomial = IntegerFunctions.binomial(i10, i11);
            int bitLength = binomial.bitLength() - 1;
            int i12 = bitLength >> 3;
            int i13 = bitLength & 7;
            int i14 = 8;
            if (i13 == 0) {
                i12--;
                i13 = 8;
            }
            int i15 = i10 >> 3;
            int i16 = i10 & 7;
            if (i16 == 0) {
                i15--;
            } else {
                i14 = i16;
            }
            int i17 = i15 + 1;
            byte[] bArr2 = new byte[i17];
            if (bArr.length < i17) {
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                for (int length = bArr.length; length < i17; length++) {
                    bArr2[length] = 0;
                }
            } else {
                System.arraycopy(bArr, 0, bArr2, 0, i15);
                bArr2[i15] = (byte) (bArr[i15] & ((1 << i14) - 1));
            }
            BigInteger bigInteger = ZERO;
            int i18 = i10;
            for (int i19 = 0; i19 < i10; i19++) {
                binomial = binomial.multiply(new BigInteger(Integer.toString(i18 - i11))).divide(new BigInteger(Integer.toString(i18)));
                i18--;
                if (((byte) (bArr2[i19 >>> 3] & (1 << (i19 & 7)))) != 0) {
                    bigInteger = bigInteger.add(binomial);
                    i11--;
                    binomial = i18 == i11 ? ONE : binomial.multiply(new BigInteger(Integer.toString(i11 + 1))).divide(new BigInteger(Integer.toString(i18 - i11)));
                }
            }
            int i20 = i12 + 1;
            byte[] bArr3 = new byte[i20];
            byte[] byteArray = bigInteger.toByteArray();
            if (byteArray.length < i20) {
                System.arraycopy(byteArray, 0, bArr3, 0, byteArray.length);
                for (int length2 = byteArray.length; length2 < i20; length2++) {
                    bArr3[length2] = 0;
                }
            } else {
                System.arraycopy(byteArray, 0, bArr3, 0, i12);
                bArr3[i12] = (byte) (((1 << i13) - 1) & byteArray[i12]);
            }
            return bArr3;
        }
        throw new IllegalArgumentException("n < t");
    }
}
