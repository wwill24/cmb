package org.bouncycastle.crypto.fpe;

import java.math.BigInteger;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Pack;

class SP80038G {
    protected static final int BLOCK_SIZE = 16;
    static final String FF1_DISABLED = "org.bouncycastle.fpe.disable_ff1";
    static final String FPE_DISABLED = "org.bouncycastle.fpe.disable";
    protected static final double LOG2 = Math.log(2.0d);
    protected static final double TWO_TO_96 = Math.pow(2.0d, 96.0d);

    SP80038G() {
    }

    protected static BigInteger[] calculateModUV(BigInteger bigInteger, int i10, int i11) {
        BigInteger pow = bigInteger.pow(i10);
        BigInteger[] bigIntegerArr = {pow, pow};
        if (i11 != i10) {
            bigIntegerArr[1] = pow.multiply(bigInteger);
        }
        return bigIntegerArr;
    }

    protected static byte[] calculateP_FF1(int i10, byte b10, int i11, int i12) {
        byte[] bArr = new byte[16];
        bArr[0] = 1;
        bArr[1] = 2;
        bArr[2] = 1;
        bArr[3] = 0;
        bArr[4] = (byte) (i10 >> 8);
        bArr[5] = (byte) i10;
        bArr[6] = 10;
        bArr[7] = b10;
        Pack.intToBigEndian(i11, bArr, 8);
        Pack.intToBigEndian(i12, bArr, 12);
        return bArr;
    }

    protected static byte[] calculateTweak64_FF3_1(byte[] bArr) {
        return new byte[]{bArr[0], bArr[1], bArr[2], (byte) (bArr[3] & 240), bArr[4], bArr[5], bArr[6], (byte) (bArr[3] << 4)};
    }

    protected static BigInteger calculateY_FF1(BlockCipher blockCipher, BigInteger bigInteger, byte[] bArr, int i10, int i11, int i12, byte[] bArr2, short[] sArr) {
        int length = bArr.length;
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(num(bigInteger, sArr));
        int i13 = ((-(length + i10 + 1)) & 15) + length;
        int i14 = i13 + 1 + i10;
        byte[] bArr3 = new byte[i14];
        System.arraycopy(bArr, 0, bArr3, 0, length);
        bArr3[i13] = (byte) i12;
        System.arraycopy(asUnsignedByteArray, 0, bArr3, i14 - asUnsignedByteArray.length, asUnsignedByteArray.length);
        byte[] prf = prf(blockCipher, Arrays.concatenate(bArr2, bArr3));
        if (i11 > 16) {
            int i15 = ((i11 + 16) - 1) / 16;
            byte[] bArr4 = new byte[(i15 * 16)];
            System.arraycopy(prf, 0, bArr4, 0, 16);
            byte[] bArr5 = new byte[4];
            for (int i16 = 1; i16 < i15; i16++) {
                int i17 = i16 * 16;
                System.arraycopy(prf, 0, bArr4, i17, 16);
                Pack.intToBigEndian(i16, bArr5, 0);
                xor(bArr5, 0, bArr4, (i17 + 16) - 4, 4);
                blockCipher.processBlock(bArr4, i17, bArr4, i17);
            }
            prf = bArr4;
        }
        return num(prf, 0, i11);
    }

    protected static BigInteger calculateY_FF3(BlockCipher blockCipher, BigInteger bigInteger, byte[] bArr, int i10, int i11, short[] sArr) {
        byte[] bArr2 = new byte[16];
        Pack.intToBigEndian(i11, bArr2, 0);
        xor(bArr, i10, bArr2, 0, 4);
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(num(bigInteger, sArr));
        if (16 - asUnsignedByteArray.length >= 4) {
            System.arraycopy(asUnsignedByteArray, 0, bArr2, 16 - asUnsignedByteArray.length, asUnsignedByteArray.length);
            rev(bArr2);
            blockCipher.processBlock(bArr2, 0, bArr2, 0);
            rev(bArr2);
            return num(bArr2, 0, 16);
        }
        throw new IllegalStateException("input out of range");
    }

    protected static void checkArgs(BlockCipher blockCipher, boolean z10, int i10, byte[] bArr, int i11, int i12) {
        checkCipher(blockCipher);
        if (i10 < 2 || i10 > 256) {
            throw new IllegalArgumentException();
        }
        checkData(z10, i10, bArr, i11, i12);
    }

    protected static void checkArgs(BlockCipher blockCipher, boolean z10, int i10, short[] sArr, int i11, int i12) {
        checkCipher(blockCipher);
        if (i10 < 2 || i10 > 65536) {
            throw new IllegalArgumentException();
        }
        checkData(z10, i10, sArr, i11, i12);
    }

    protected static void checkCipher(BlockCipher blockCipher) {
        if (16 != blockCipher.getBlockSize()) {
            throw new IllegalArgumentException();
        }
    }

    protected static void checkData(boolean z10, int i10, byte[] bArr, int i11, int i12) {
        checkLength(z10, i10, i12);
        int i13 = 0;
        while (i13 < i12) {
            if ((bArr[i11 + i13] & 255) < i10) {
                i13++;
            } else {
                throw new IllegalArgumentException("input data outside of radix");
            }
        }
    }

    protected static void checkData(boolean z10, int i10, short[] sArr, int i11, int i12) {
        checkLength(z10, i10, i12);
        int i13 = 0;
        while (i13 < i12) {
            if ((sArr[i11 + i13] & 65535) < i10) {
                i13++;
            } else {
                throw new IllegalArgumentException("input data outside of radix");
            }
        }
    }

    private static void checkLength(boolean z10, int i10, int i11) {
        int floor;
        if (i11 >= 2) {
            double d10 = (double) i10;
            if (Math.pow(d10, (double) i11) >= 1000000.0d) {
                if (!z10 && i11 > (floor = ((int) Math.floor(Math.log(TWO_TO_96) / Math.log(d10))) * 2)) {
                    throw new IllegalArgumentException("maximum input length is " + floor);
                }
                return;
            }
        }
        throw new IllegalArgumentException("input too short");
    }

    static short[] decFF1(BlockCipher blockCipher, int i10, byte[] bArr, int i11, int i12, int i13, short[] sArr, short[] sArr2) {
        int i14 = i10;
        int i15 = i11;
        int i16 = i12;
        int i17 = i13;
        int length = bArr.length;
        int ceil = (((int) Math.ceil((Math.log((double) i14) * ((double) i17)) / LOG2)) + 7) / 8;
        int i18 = (((ceil + 3) / 4) * 4) + 4;
        byte[] calculateP_FF1 = calculateP_FF1(i14, (byte) i16, i15, length);
        BigInteger valueOf = BigInteger.valueOf((long) i14);
        BigInteger[] calculateModUV = calculateModUV(valueOf, i16, i17);
        short[] sArr3 = sArr;
        short[] sArr4 = sArr2;
        int i19 = i16;
        int i20 = 9;
        while (i20 >= 0) {
            short[] sArr5 = sArr4;
            sArr4 = sArr3;
            i19 = i15 - i19;
            str(valueOf, num(valueOf, sArr5).subtract(calculateY_FF1(blockCipher, valueOf, bArr, ceil, i18, i20, calculateP_FF1, sArr4)).mod(calculateModUV[i20 & 1]), i19, sArr5, 0);
            i20--;
            sArr3 = sArr5;
            byte[] bArr2 = bArr;
        }
        return Arrays.concatenate(sArr3, sArr4);
    }

    private static short[] decFF3_1(BlockCipher blockCipher, int i10, byte[] bArr, int i11, int i12, int i13, short[] sArr, short[] sArr2) {
        BigInteger valueOf = BigInteger.valueOf((long) i10);
        int i14 = i13;
        BigInteger[] calculateModUV = calculateModUV(valueOf, i12, i14);
        rev(sArr);
        rev(sArr2);
        short[] sArr3 = sArr;
        short[] sArr4 = sArr2;
        int i15 = 7;
        while (i15 >= 0) {
            int i16 = i11 - i14;
            int i17 = i15 & 1;
            str(valueOf, num(valueOf, sArr4).subtract(calculateY_FF3(blockCipher, valueOf, bArr, 4 - (i17 * 4), i15, sArr3)).mod(calculateModUV[1 - i17]), i16, sArr4, 0);
            i15--;
            i14 = i16;
            short[] sArr5 = sArr4;
            sArr4 = sArr3;
            sArr3 = sArr5;
        }
        rev(sArr3);
        rev(sArr4);
        return Arrays.concatenate(sArr3, sArr4);
    }

    static byte[] decryptFF1(BlockCipher blockCipher, int i10, byte[] bArr, byte[] bArr2, int i11, int i12) {
        int i13 = i12;
        checkArgs(blockCipher, true, i10, bArr2, i11, i13);
        int i14 = i12 / 2;
        int i15 = i12 - i14;
        return toByte(decFF1(blockCipher, i10, bArr, i13, i14, i15, toShort(bArr2, i11, i14), toShort(bArr2, i11 + i14, i15)));
    }

    static short[] decryptFF1w(BlockCipher blockCipher, int i10, byte[] bArr, short[] sArr, int i11, int i12) {
        int i13 = i12;
        checkArgs(blockCipher, true, i10, sArr, i11, i13);
        int i14 = i12 / 2;
        int i15 = i12 - i14;
        short[] sArr2 = new short[i14];
        short[] sArr3 = new short[i15];
        System.arraycopy(sArr, i11, sArr2, 0, i14);
        System.arraycopy(sArr, i11 + i14, sArr3, 0, i15);
        return decFF1(blockCipher, i10, bArr, i13, i14, i15, sArr2, sArr3);
    }

    static byte[] decryptFF3(BlockCipher blockCipher, int i10, byte[] bArr, byte[] bArr2, int i11, int i12) {
        checkArgs(blockCipher, false, i10, bArr2, i11, i12);
        if (bArr.length == 8) {
            return implDecryptFF3(blockCipher, i10, bArr, bArr2, i11, i12);
        }
        throw new IllegalArgumentException();
    }

    static byte[] decryptFF3_1(BlockCipher blockCipher, int i10, byte[] bArr, byte[] bArr2, int i11, int i12) {
        checkArgs(blockCipher, false, i10, bArr2, i11, i12);
        if (bArr.length == 7) {
            return implDecryptFF3(blockCipher, i10, calculateTweak64_FF3_1(bArr), bArr2, i11, i12);
        }
        throw new IllegalArgumentException("tweak should be 56 bits");
    }

    static short[] decryptFF3_1w(BlockCipher blockCipher, int i10, byte[] bArr, short[] sArr, int i11, int i12) {
        checkArgs(blockCipher, false, i10, sArr, i11, i12);
        if (bArr.length == 7) {
            return implDecryptFF3w(blockCipher, i10, calculateTweak64_FF3_1(bArr), sArr, i11, i12);
        }
        throw new IllegalArgumentException("tweak should be 56 bits");
    }

    private static short[] encFF1(BlockCipher blockCipher, int i10, byte[] bArr, int i11, int i12, int i13, short[] sArr, short[] sArr2) {
        int i14 = i10;
        int i15 = i11;
        int i16 = i12;
        int i17 = i13;
        int length = bArr.length;
        int ceil = (((int) Math.ceil((Math.log((double) i14) * ((double) i17)) / LOG2)) + 7) / 8;
        int i18 = (((ceil + 3) / 4) * 4) + 4;
        byte[] calculateP_FF1 = calculateP_FF1(i14, (byte) i16, i15, length);
        BigInteger valueOf = BigInteger.valueOf((long) i14);
        BigInteger[] calculateModUV = calculateModUV(valueOf, i16, i17);
        short[] sArr3 = sArr;
        short[] sArr4 = sArr2;
        int i19 = i17;
        int i20 = 0;
        while (i20 < 10) {
            int i21 = i20;
            short[] sArr5 = sArr3;
            sArr3 = sArr4;
            BigInteger calculateY_FF1 = calculateY_FF1(blockCipher, valueOf, bArr, ceil, i18, i20, calculateP_FF1, sArr3);
            int i22 = i15 - i19;
            str(valueOf, num(valueOf, sArr5).add(calculateY_FF1).mod(calculateModUV[i21 & 1]), i22, sArr5, 0);
            i20 = i21 + 1;
            i19 = i22;
            sArr4 = sArr5;
        }
        return Arrays.concatenate(sArr3, sArr4);
    }

    private static short[] encFF3_1(BlockCipher blockCipher, int i10, byte[] bArr, int i11, int i12, int i13, short[] sArr, short[] sArr2) {
        BigInteger valueOf = BigInteger.valueOf((long) i10);
        int i14 = i12;
        BigInteger[] calculateModUV = calculateModUV(valueOf, i14, i13);
        rev(sArr);
        rev(sArr2);
        short[] sArr3 = sArr;
        short[] sArr4 = sArr2;
        int i15 = 0;
        while (i15 < 8) {
            i14 = i11 - i14;
            int i16 = i15 & 1;
            str(valueOf, num(valueOf, sArr3).add(calculateY_FF3(blockCipher, valueOf, bArr, 4 - (i16 * 4), i15, sArr4)).mod(calculateModUV[1 - i16]), i14, sArr3, 0);
            i15++;
            short[] sArr5 = sArr4;
            sArr4 = sArr3;
            sArr3 = sArr5;
        }
        rev(sArr3);
        rev(sArr4);
        return Arrays.concatenate(sArr3, sArr4);
    }

    static byte[] encryptFF1(BlockCipher blockCipher, int i10, byte[] bArr, byte[] bArr2, int i11, int i12) {
        int i13 = i12;
        checkArgs(blockCipher, true, i10, bArr2, i11, i13);
        int i14 = i12 / 2;
        int i15 = i12 - i14;
        return toByte(encFF1(blockCipher, i10, bArr, i13, i14, i15, toShort(bArr2, i11, i14), toShort(bArr2, i11 + i14, i15)));
    }

    static short[] encryptFF1w(BlockCipher blockCipher, int i10, byte[] bArr, short[] sArr, int i11, int i12) {
        int i13 = i12;
        checkArgs(blockCipher, true, i10, sArr, i11, i13);
        int i14 = i12 / 2;
        int i15 = i12 - i14;
        short[] sArr2 = new short[i14];
        short[] sArr3 = new short[i15];
        System.arraycopy(sArr, i11, sArr2, 0, i14);
        System.arraycopy(sArr, i11 + i14, sArr3, 0, i15);
        return encFF1(blockCipher, i10, bArr, i13, i14, i15, sArr2, sArr3);
    }

    static byte[] encryptFF3(BlockCipher blockCipher, int i10, byte[] bArr, byte[] bArr2, int i11, int i12) {
        checkArgs(blockCipher, false, i10, bArr2, i11, i12);
        if (bArr.length == 8) {
            return implEncryptFF3(blockCipher, i10, bArr, bArr2, i11, i12);
        }
        throw new IllegalArgumentException();
    }

    static byte[] encryptFF3_1(BlockCipher blockCipher, int i10, byte[] bArr, byte[] bArr2, int i11, int i12) {
        checkArgs(blockCipher, false, i10, bArr2, i11, i12);
        if (bArr.length == 7) {
            return encryptFF3(blockCipher, i10, calculateTweak64_FF3_1(bArr), bArr2, i11, i12);
        }
        throw new IllegalArgumentException("tweak should be 56 bits");
    }

    static short[] encryptFF3_1w(BlockCipher blockCipher, int i10, byte[] bArr, short[] sArr, int i11, int i12) {
        checkArgs(blockCipher, false, i10, sArr, i11, i12);
        if (bArr.length == 7) {
            return encryptFF3w(blockCipher, i10, calculateTweak64_FF3_1(bArr), sArr, i11, i12);
        }
        throw new IllegalArgumentException("tweak should be 56 bits");
    }

    static short[] encryptFF3w(BlockCipher blockCipher, int i10, byte[] bArr, short[] sArr, int i11, int i12) {
        checkArgs(blockCipher, false, i10, sArr, i11, i12);
        if (bArr.length == 8) {
            return implEncryptFF3w(blockCipher, i10, bArr, sArr, i11, i12);
        }
        throw new IllegalArgumentException();
    }

    protected static byte[] implDecryptFF3(BlockCipher blockCipher, int i10, byte[] bArr, byte[] bArr2, int i11, int i12) {
        int i13 = i12 / 2;
        int i14 = i12 - i13;
        return toByte(decFF3_1(blockCipher, i10, bArr, i12, i13, i14, toShort(bArr2, i11, i14), toShort(bArr2, i11 + i14, i13)));
    }

    protected static short[] implDecryptFF3w(BlockCipher blockCipher, int i10, byte[] bArr, short[] sArr, int i11, int i12) {
        int i13 = i12 / 2;
        int i14 = i12 - i13;
        short[] sArr2 = new short[i14];
        short[] sArr3 = new short[i13];
        System.arraycopy(sArr, i11, sArr2, 0, i14);
        System.arraycopy(sArr, i11 + i14, sArr3, 0, i13);
        return decFF3_1(blockCipher, i10, bArr, i12, i13, i14, sArr2, sArr3);
    }

    protected static byte[] implEncryptFF3(BlockCipher blockCipher, int i10, byte[] bArr, byte[] bArr2, int i11, int i12) {
        int i13 = i12 / 2;
        int i14 = i12 - i13;
        return toByte(encFF3_1(blockCipher, i10, bArr, i12, i13, i14, toShort(bArr2, i11, i14), toShort(bArr2, i11 + i14, i13)));
    }

    protected static short[] implEncryptFF3w(BlockCipher blockCipher, int i10, byte[] bArr, short[] sArr, int i11, int i12) {
        int i13 = i12 / 2;
        int i14 = i12 - i13;
        short[] sArr2 = new short[i14];
        short[] sArr3 = new short[i13];
        System.arraycopy(sArr, i11, sArr2, 0, i14);
        System.arraycopy(sArr, i11 + i14, sArr3, 0, i13);
        return encFF3_1(blockCipher, i10, bArr, i12, i13, i14, sArr2, sArr3);
    }

    protected static BigInteger num(BigInteger bigInteger, short[] sArr) {
        BigInteger bigInteger2 = BigIntegers.ZERO;
        for (short s10 : sArr) {
            bigInteger2 = bigInteger2.multiply(bigInteger).add(BigInteger.valueOf((long) (s10 & 65535)));
        }
        return bigInteger2;
    }

    protected static BigInteger num(byte[] bArr, int i10, int i11) {
        return new BigInteger(1, Arrays.copyOfRange(bArr, i10, i11 + i10));
    }

    protected static byte[] prf(BlockCipher blockCipher, byte[] bArr) {
        if (bArr.length % 16 == 0) {
            int length = bArr.length / 16;
            byte[] bArr2 = new byte[16];
            for (int i10 = 0; i10 < length; i10++) {
                xor(bArr, i10 * 16, bArr2, 0, 16);
                blockCipher.processBlock(bArr2, 0, bArr2, 0);
            }
            return bArr2;
        }
        throw new IllegalArgumentException();
    }

    protected static void rev(byte[] bArr) {
        int length = bArr.length / 2;
        int length2 = bArr.length - 1;
        for (int i10 = 0; i10 < length; i10++) {
            byte b10 = bArr[i10];
            int i11 = length2 - i10;
            bArr[i10] = bArr[i11];
            bArr[i11] = b10;
        }
    }

    protected static void rev(short[] sArr) {
        int length = sArr.length / 2;
        int length2 = sArr.length - 1;
        for (int i10 = 0; i10 < length; i10++) {
            short s10 = sArr[i10];
            int i11 = length2 - i10;
            sArr[i10] = sArr[i11];
            sArr[i11] = s10;
        }
    }

    protected static void str(BigInteger bigInteger, BigInteger bigInteger2, int i10, short[] sArr, int i11) {
        if (bigInteger2.signum() >= 0) {
            for (int i12 = 1; i12 <= i10; i12++) {
                BigInteger[] divideAndRemainder = bigInteger2.divideAndRemainder(bigInteger);
                sArr[(i11 + i10) - i12] = (short) divideAndRemainder[1].intValue();
                bigInteger2 = divideAndRemainder[0];
            }
            if (bigInteger2.signum() != 0) {
                throw new IllegalArgumentException();
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    private static byte[] toByte(short[] sArr) {
        int length = sArr.length;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 != length; i10++) {
            bArr[i10] = (byte) sArr[i10];
        }
        return bArr;
    }

    private static short[] toShort(byte[] bArr, int i10, int i11) {
        short[] sArr = new short[i11];
        for (int i12 = 0; i12 != i11; i12++) {
            sArr[i12] = (short) (bArr[i10 + i12] & 255);
        }
        return sArr;
    }

    protected static void xor(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i11 + i13;
            bArr2[i14] = (byte) (bArr2[i14] ^ bArr[i10 + i13]);
        }
    }
}
