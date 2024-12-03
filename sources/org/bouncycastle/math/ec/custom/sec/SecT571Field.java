package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import net.bytebuddy.jar.asm.Opcodes;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat576;
import org.jivesoftware.smack.datatypes.UInt32;

public class SecT571Field {
    private static final long M59 = 576460752303423487L;
    private static final long[] ROOT_Z = {3161836309350906777L, -7642453882179322845L, -3821226941089661423L, 7312758566309945096L, -556661012383879292L, 8945041530681231562L, -4750851271514160027L, 6847946401097695794L, 541669439031730457L};

    private static void add(long[] jArr, int i10, long[] jArr2, int i11, long[] jArr3, int i12) {
        for (int i13 = 0; i13 < 9; i13++) {
            jArr3[i12 + i13] = jArr[i10 + i13] ^ jArr2[i11 + i13];
        }
    }

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i10 = 0; i10 < 9; i10++) {
            jArr3[i10] = jArr[i10] ^ jArr2[i10];
        }
    }

    private static void addBothTo(long[] jArr, int i10, long[] jArr2, int i11, long[] jArr3, int i12) {
        for (int i13 = 0; i13 < 9; i13++) {
            int i14 = i12 + i13;
            jArr3[i14] = jArr3[i14] ^ (jArr[i10 + i13] ^ jArr2[i11 + i13]);
        }
    }

    public static void addBothTo(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i10 = 0; i10 < 9; i10++) {
            jArr3[i10] = jArr3[i10] ^ (jArr[i10] ^ jArr2[i10]);
        }
    }

    public static void addExt(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i10 = 0; i10 < 18; i10++) {
            jArr3[i10] = jArr[i10] ^ jArr2[i10];
        }
    }

    public static void addOne(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        for (int i10 = 1; i10 < 9; i10++) {
            jArr2[i10] = jArr[i10];
        }
    }

    private static void addTo(long[] jArr, long[] jArr2) {
        for (int i10 = 0; i10 < 9; i10++) {
            jArr2[i10] = jArr2[i10] ^ jArr[i10];
        }
    }

    public static long[] fromBigInteger(BigInteger bigInteger) {
        return Nat.fromBigInteger64(571, bigInteger);
    }

    public static void halfTrace(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat576.createExt64();
        Nat576.copy64(jArr, jArr2);
        for (int i10 = 1; i10 < 571; i10 += 2) {
            implSquare(jArr2, createExt64);
            reduce(createExt64, jArr2);
            implSquare(jArr2, createExt64);
            reduce(createExt64, jArr2);
            addTo(jArr, jArr2);
        }
    }

    protected static void implMultiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[16];
        for (int i10 = 0; i10 < 9; i10++) {
            implMulwAcc(jArr4, jArr[i10], jArr2[i10], jArr3, i10 << 1);
        }
        long j10 = jArr3[0];
        long j11 = jArr3[1];
        long j12 = jArr3[2] ^ j10;
        long j13 = j12 ^ j11;
        jArr3[1] = j13;
        long j14 = j11 ^ jArr3[3];
        long j15 = j12 ^ jArr3[4];
        long j16 = j15 ^ j14;
        jArr3[2] = j16;
        long j17 = j14 ^ jArr3[5];
        long j18 = j15 ^ jArr3[6];
        long j19 = j18 ^ j17;
        jArr3[3] = j19;
        long j20 = j17 ^ jArr3[7];
        long j21 = j18 ^ jArr3[8];
        long j22 = j21 ^ j20;
        jArr3[4] = j22;
        long j23 = j20 ^ jArr3[9];
        long j24 = j21 ^ jArr3[10];
        long j25 = j24 ^ j23;
        jArr3[5] = j25;
        long j26 = j23 ^ jArr3[11];
        long j27 = j24 ^ jArr3[12];
        long j28 = j27 ^ j26;
        jArr3[6] = j28;
        long j29 = j26 ^ jArr3[13];
        long j30 = j27 ^ jArr3[14];
        long j31 = j30 ^ j29;
        jArr3[7] = j31;
        long j32 = j29 ^ jArr3[15];
        long j33 = j30 ^ jArr3[16];
        long j34 = j33 ^ j32;
        jArr3[8] = j34;
        long j35 = (j32 ^ jArr3[17]) ^ j33;
        jArr3[9] = j10 ^ j35;
        jArr3[10] = j13 ^ j35;
        jArr3[11] = j16 ^ j35;
        jArr3[12] = j19 ^ j35;
        jArr3[13] = j22 ^ j35;
        jArr3[14] = j25 ^ j35;
        jArr3[15] = j28 ^ j35;
        jArr3[16] = j31 ^ j35;
        jArr3[17] = j34 ^ j35;
        implMulwAcc(jArr4, jArr[0] ^ jArr[1], jArr2[0] ^ jArr2[1], jArr3, 1);
        implMulwAcc(jArr4, jArr[0] ^ jArr[2], jArr2[0] ^ jArr2[2], jArr3, 2);
        implMulwAcc(jArr4, jArr[0] ^ jArr[3], jArr2[0] ^ jArr2[3], jArr3, 3);
        implMulwAcc(jArr4, jArr[1] ^ jArr[2], jArr2[1] ^ jArr2[2], jArr3, 3);
        implMulwAcc(jArr4, jArr[0] ^ jArr[4], jArr2[0] ^ jArr2[4], jArr3, 4);
        implMulwAcc(jArr4, jArr[1] ^ jArr[3], jArr2[1] ^ jArr2[3], jArr3, 4);
        implMulwAcc(jArr4, jArr[0] ^ jArr[5], jArr2[0] ^ jArr2[5], jArr3, 5);
        implMulwAcc(jArr4, jArr[1] ^ jArr[4], jArr2[1] ^ jArr2[4], jArr3, 5);
        implMulwAcc(jArr4, jArr[2] ^ jArr[3], jArr2[2] ^ jArr2[3], jArr3, 5);
        implMulwAcc(jArr4, jArr[0] ^ jArr[6], jArr2[0] ^ jArr2[6], jArr3, 6);
        implMulwAcc(jArr4, jArr[1] ^ jArr[5], jArr2[1] ^ jArr2[5], jArr3, 6);
        implMulwAcc(jArr4, jArr[2] ^ jArr[4], jArr2[2] ^ jArr2[4], jArr3, 6);
        implMulwAcc(jArr4, jArr[0] ^ jArr[7], jArr2[0] ^ jArr2[7], jArr3, 7);
        implMulwAcc(jArr4, jArr[1] ^ jArr[6], jArr2[1] ^ jArr2[6], jArr3, 7);
        implMulwAcc(jArr4, jArr[2] ^ jArr[5], jArr2[2] ^ jArr2[5], jArr3, 7);
        implMulwAcc(jArr4, jArr[3] ^ jArr[4], jArr2[3] ^ jArr2[4], jArr3, 7);
        implMulwAcc(jArr4, jArr[0] ^ jArr[8], jArr2[0] ^ jArr2[8], jArr3, 8);
        implMulwAcc(jArr4, jArr[1] ^ jArr[7], jArr2[1] ^ jArr2[7], jArr3, 8);
        implMulwAcc(jArr4, jArr[2] ^ jArr[6], jArr2[2] ^ jArr2[6], jArr3, 8);
        implMulwAcc(jArr4, jArr[3] ^ jArr[5], jArr2[3] ^ jArr2[5], jArr3, 8);
        implMulwAcc(jArr4, jArr[1] ^ jArr[8], jArr2[1] ^ jArr2[8], jArr3, 9);
        implMulwAcc(jArr4, jArr[2] ^ jArr[7], jArr2[2] ^ jArr2[7], jArr3, 9);
        implMulwAcc(jArr4, jArr[3] ^ jArr[6], jArr2[3] ^ jArr2[6], jArr3, 9);
        implMulwAcc(jArr4, jArr[4] ^ jArr[5], jArr2[4] ^ jArr2[5], jArr3, 9);
        implMulwAcc(jArr4, jArr[2] ^ jArr[8], jArr2[2] ^ jArr2[8], jArr3, 10);
        implMulwAcc(jArr4, jArr[3] ^ jArr[7], jArr2[3] ^ jArr2[7], jArr3, 10);
        implMulwAcc(jArr4, jArr[4] ^ jArr[6], jArr2[4] ^ jArr2[6], jArr3, 10);
        implMulwAcc(jArr4, jArr[3] ^ jArr[8], jArr2[3] ^ jArr2[8], jArr3, 11);
        implMulwAcc(jArr4, jArr[4] ^ jArr[7], jArr2[4] ^ jArr2[7], jArr3, 11);
        implMulwAcc(jArr4, jArr[5] ^ jArr[6], jArr2[5] ^ jArr2[6], jArr3, 11);
        implMulwAcc(jArr4, jArr[4] ^ jArr[8], jArr2[4] ^ jArr2[8], jArr3, 12);
        implMulwAcc(jArr4, jArr[5] ^ jArr[7], jArr2[5] ^ jArr2[7], jArr3, 12);
        implMulwAcc(jArr4, jArr[5] ^ jArr[8], jArr2[5] ^ jArr2[8], jArr3, 13);
        implMulwAcc(jArr4, jArr[6] ^ jArr[7], jArr2[6] ^ jArr2[7], jArr3, 13);
        implMulwAcc(jArr4, jArr[6] ^ jArr[8], jArr2[6] ^ jArr2[8], jArr3, 14);
        implMulwAcc(jArr4, jArr[7] ^ jArr[8], jArr2[7] ^ jArr2[8], jArr3, 15);
    }

    protected static void implMultiplyPrecomp(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i10 = 56; i10 >= 0; i10 -= 8) {
            for (int i11 = 1; i11 < 9; i11 += 2) {
                int i12 = (int) (jArr[i11] >>> i10);
                addBothTo(jArr2, (i12 & 15) * 9, jArr2, (((i12 >>> 4) & 15) + 16) * 9, jArr3, i11 - 1);
            }
            Nat.shiftUpBits64(16, jArr3, 0, 8, 0);
        }
        for (int i13 = 56; i13 >= 0; i13 -= 8) {
            for (int i14 = 0; i14 < 9; i14 += 2) {
                int i15 = (int) (jArr[i14] >>> i13);
                int i16 = (((i15 >>> 4) & 15) + 16) * 9;
                addBothTo(jArr2, (i15 & 15) * 9, jArr2, i16, jArr3, i14);
            }
            if (i13 > 0) {
                Nat.shiftUpBits64(18, jArr3, 0, 8, 0);
            }
        }
    }

    protected static void implMulwAcc(long[] jArr, long j10, long j11, long[] jArr2, int i10) {
        long j12 = j10;
        jArr[1] = j11;
        for (int i11 = 2; i11 < 16; i11 += 2) {
            long j13 = jArr[i11 >>> 1] << 1;
            jArr[i11] = j13;
            jArr[i11 + 1] = j13 ^ j11;
        }
        int i12 = (int) j12;
        long j14 = 0;
        long j15 = jArr[i12 & 15] ^ (jArr[(i12 >>> 4) & 15] << 4);
        int i13 = 56;
        do {
            int i14 = (int) (j12 >>> i13);
            long j16 = jArr[i14 & 15] ^ (jArr[(i14 >>> 4) & 15] << 4);
            j15 ^= j16 << i13;
            j14 ^= j16 >>> (-i13);
            i13 -= 8;
        } while (i13 > 0);
        for (int i15 = 0; i15 < 7; i15++) {
            j12 = (j12 & -72340172838076674L) >>> 1;
            j14 ^= ((j11 << i15) >> 63) & j12;
        }
        jArr2[i10] = jArr2[i10] ^ j15;
        int i16 = i10 + 1;
        jArr2[i16] = jArr2[i16] ^ j14;
    }

    protected static void implSquare(long[] jArr, long[] jArr2) {
        Interleave.expand64To128(jArr, 0, 9, jArr2, 0);
    }

    public static void invert(long[] jArr, long[] jArr2) {
        if (!Nat576.isZero64(jArr)) {
            long[] create64 = Nat576.create64();
            long[] create642 = Nat576.create64();
            long[] create643 = Nat576.create64();
            square(jArr, create643);
            square(create643, create64);
            square(create64, create642);
            multiply(create64, create642, create64);
            squareN(create64, 2, create642);
            multiply(create64, create642, create64);
            multiply(create64, create643, create64);
            squareN(create64, 5, create642);
            multiply(create64, create642, create64);
            squareN(create642, 5, create642);
            multiply(create64, create642, create64);
            squareN(create64, 15, create642);
            multiply(create64, create642, create643);
            squareN(create643, 30, create64);
            squareN(create64, 30, create642);
            multiply(create64, create642, create64);
            squareN(create64, 60, create642);
            multiply(create64, create642, create64);
            squareN(create642, 60, create642);
            multiply(create64, create642, create64);
            squareN(create64, Opcodes.GETFIELD, create642);
            multiply(create64, create642, create64);
            squareN(create642, Opcodes.GETFIELD, create642);
            multiply(create64, create642, create64);
            multiply(create64, create643, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat576.createExt64();
        implMultiply(jArr, jArr2, createExt64);
        reduce(createExt64, jArr3);
    }

    public static void multiplyAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat576.createExt64();
        implMultiply(jArr, jArr2, createExt64);
        addExt(jArr3, createExt64, jArr3);
    }

    public static void multiplyPrecomp(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat576.createExt64();
        implMultiplyPrecomp(jArr, jArr2, createExt64);
        reduce(createExt64, jArr3);
    }

    public static void multiplyPrecompAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat576.createExt64();
        implMultiplyPrecomp(jArr, jArr2, createExt64);
        addExt(jArr3, createExt64, jArr3);
    }

    public static long[] precompMultiplicand(long[] jArr) {
        long[] jArr2 = new long[288];
        int i10 = 0;
        System.arraycopy(jArr, 0, jArr2, 9, 9);
        int i11 = 7;
        while (i11 > 0) {
            int i12 = i10 + 18;
            Nat.shiftUpBit64(9, jArr2, i12 >>> 1, 0, jArr2, i12);
            reduce5(jArr2, i12);
            add(jArr2, 9, jArr2, i12, jArr2, i12 + 9);
            i11--;
            i10 = i12;
        }
        Nat.shiftUpBits64(Opcodes.D2F, jArr2, 0, 4, 0, jArr2, Opcodes.D2F);
        return jArr2;
    }

    public static void reduce(long[] jArr, long[] jArr2) {
        long j10 = jArr[9];
        long j11 = jArr[17];
        long j12 = (((j10 ^ (j11 >>> 59)) ^ (j11 >>> 57)) ^ (j11 >>> 54)) ^ (j11 >>> 49);
        long j13 = (j11 << 15) ^ (((jArr[8] ^ (j11 << 5)) ^ (j11 << 7)) ^ (j11 << 10));
        for (int i10 = 16; i10 >= 10; i10--) {
            long j14 = jArr[i10];
            jArr2[i10 - 8] = (((j13 ^ (j14 >>> 59)) ^ (j14 >>> 57)) ^ (j14 >>> 54)) ^ (j14 >>> 49);
            j13 = (((jArr[i10 - 9] ^ (j14 << 5)) ^ (j14 << 7)) ^ (j14 << 10)) ^ (j14 << 15);
        }
        jArr2[1] = (((j13 ^ (j12 >>> 59)) ^ (j12 >>> 57)) ^ (j12 >>> 54)) ^ (j12 >>> 49);
        long j15 = (j12 << 15) ^ (((jArr[0] ^ (j12 << 5)) ^ (j12 << 7)) ^ (j12 << 10));
        long j16 = jArr2[8];
        long j17 = j16 >>> 59;
        jArr2[0] = (((j15 ^ j17) ^ (j17 << 2)) ^ (j17 << 5)) ^ (j17 << 10);
        jArr2[8] = M59 & j16;
    }

    public static void reduce5(long[] jArr, int i10) {
        int i11 = i10 + 8;
        long j10 = jArr[i11];
        long j11 = j10 >>> 59;
        jArr[i10] = ((j11 << 10) ^ (((j11 << 2) ^ j11) ^ (j11 << 5))) ^ jArr[i10];
        jArr[i11] = j10 & M59;
    }

    public static void sqrt(long[] jArr, long[] jArr2) {
        long[] create64 = Nat576.create64();
        long[] create642 = Nat576.create64();
        int i10 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = i10 + 1;
            long unshuffle = Interleave.unshuffle(jArr[i10]);
            i10 = i12 + 1;
            long unshuffle2 = Interleave.unshuffle(jArr[i12]);
            create64[i11] = (UInt32.MAX_VALUE_LONG & unshuffle) | (unshuffle2 << 32);
            create642[i11] = (unshuffle >>> 32) | (-4294967296L & unshuffle2);
        }
        long unshuffle3 = Interleave.unshuffle(jArr[i10]);
        create64[4] = UInt32.MAX_VALUE_LONG & unshuffle3;
        create642[4] = unshuffle3 >>> 32;
        multiply(create642, ROOT_Z, jArr2);
        add(jArr2, create64, jArr2);
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat576.createExt64();
        implSquare(jArr, createExt64);
        reduce(createExt64, jArr2);
    }

    public static void squareAddToExt(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat576.createExt64();
        implSquare(jArr, createExt64);
        addExt(jArr2, createExt64, jArr2);
    }

    public static void squareN(long[] jArr, int i10, long[] jArr2) {
        long[] createExt64 = Nat576.createExt64();
        implSquare(jArr, createExt64);
        while (true) {
            reduce(createExt64, jArr2);
            i10--;
            if (i10 > 0) {
                implSquare(jArr2, createExt64);
            } else {
                return;
            }
        }
    }

    public static int trace(long[] jArr) {
        long j10 = jArr[0];
        long j11 = jArr[8];
        return ((int) ((j10 ^ (j11 >>> 49)) ^ (j11 >>> 57))) & 1;
    }
}
