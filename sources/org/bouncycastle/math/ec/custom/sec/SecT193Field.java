package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import net.bytebuddy.jar.asm.Opcodes;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;
import org.jivesoftware.smack.datatypes.UInt32;

public class SecT193Field {
    private static final long M01 = 1;
    private static final long M49 = 562949953421311L;

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr2[3] ^ jArr[3];
    }

    public static void addExt(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr2[6] ^ jArr[6];
    }

    public static void addOne(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
    }

    private static void addTo(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr2[0] ^ jArr[0];
        jArr2[1] = jArr2[1] ^ jArr[1];
        jArr2[2] = jArr2[2] ^ jArr[2];
        jArr2[3] = jArr2[3] ^ jArr[3];
    }

    public static long[] fromBigInteger(BigInteger bigInteger) {
        return Nat.fromBigInteger64(Opcodes.INSTANCEOF, bigInteger);
    }

    public static void halfTrace(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat256.createExt64();
        Nat256.copy64(jArr, jArr2);
        for (int i10 = 1; i10 < 193; i10 += 2) {
            implSquare(jArr2, createExt64);
            reduce(createExt64, jArr2);
            implSquare(jArr2, createExt64);
            reduce(createExt64, jArr2);
            addTo(jArr, jArr2);
        }
    }

    protected static void implCompactExt(long[] jArr) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        long j14 = jArr[4];
        long j15 = jArr[5];
        long j16 = jArr[6];
        long j17 = jArr[7];
        jArr[0] = j10 ^ (j11 << 49);
        jArr[1] = (j11 >>> 15) ^ (j12 << 34);
        jArr[2] = (j12 >>> 30) ^ (j13 << 19);
        jArr[3] = ((j13 >>> 45) ^ (j14 << 4)) ^ (j15 << 53);
        jArr[4] = ((j14 >>> 60) ^ (j16 << 38)) ^ (j15 >>> 11);
        jArr[5] = (j16 >>> 26) ^ (j17 << 23);
        jArr[6] = j17 >>> 41;
        jArr[7] = 0;
    }

    protected static void implExpand(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        jArr2[0] = j10 & M49;
        jArr2[1] = ((j10 >>> 49) ^ (j11 << 15)) & M49;
        jArr2[2] = ((j11 >>> 34) ^ (j12 << 30)) & M49;
        jArr2[3] = (j12 >>> 19) ^ (j13 << 45);
    }

    protected static void implMultiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[4];
        implExpand(jArr, jArr4);
        implExpand(jArr2, jArr5);
        long[] jArr6 = new long[8];
        long[] jArr7 = jArr6;
        long[] jArr8 = jArr3;
        implMulwAcc(jArr7, jArr4[0], jArr5[0], jArr8, 0);
        implMulwAcc(jArr7, jArr4[1], jArr5[1], jArr8, 1);
        implMulwAcc(jArr7, jArr4[2], jArr5[2], jArr8, 2);
        implMulwAcc(jArr7, jArr4[3], jArr5[3], jArr8, 3);
        for (int i10 = 5; i10 > 0; i10--) {
            jArr3[i10] = jArr3[i10] ^ jArr3[i10 - 1];
        }
        implMulwAcc(jArr6, jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        implMulwAcc(jArr6, jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 3);
        for (int i11 = 7; i11 > 1; i11--) {
            jArr3[i11] = jArr3[i11] ^ jArr3[i11 - 2];
        }
        long j10 = jArr4[0] ^ jArr4[2];
        long j11 = jArr4[1] ^ jArr4[3];
        long j12 = jArr5[0] ^ jArr5[2];
        long j13 = jArr5[1] ^ jArr5[3];
        implMulwAcc(jArr6, j10 ^ j11, j12 ^ j13, jArr3, 3);
        long[] jArr9 = new long[3];
        long[] jArr10 = jArr6;
        long[] jArr11 = jArr9;
        implMulwAcc(jArr6, j10, j12, jArr11, 0);
        implMulwAcc(jArr10, j11, j13, jArr11, 1);
        long j14 = jArr9[0];
        long j15 = jArr9[1];
        long j16 = jArr9[2];
        jArr3[2] = jArr3[2] ^ j14;
        jArr3[3] = (j14 ^ j15) ^ jArr3[3];
        jArr3[4] = jArr3[4] ^ (j16 ^ j15);
        jArr3[5] = jArr3[5] ^ j16;
        implCompactExt(jArr3);
    }

    protected static void implMulwAcc(long[] jArr, long j10, long j11, long[] jArr2, int i10) {
        long j12 = j10;
        jArr[1] = j11;
        long j13 = j11 << 1;
        jArr[2] = j13;
        long j14 = j13 ^ j11;
        jArr[3] = j14;
        long j15 = j13 << 1;
        jArr[4] = j15;
        jArr[5] = j15 ^ j11;
        long j16 = j14 << 1;
        jArr[6] = j16;
        jArr[7] = j16 ^ j11;
        int i11 = (int) j12;
        long j17 = (jArr[(i11 >>> 3) & 7] << 3) ^ jArr[i11 & 7];
        long j18 = 0;
        int i12 = 36;
        do {
            int i13 = (int) (j12 >>> i12);
            long j19 = (((jArr[i13 & 7] ^ (jArr[(i13 >>> 3) & 7] << 3)) ^ (jArr[(i13 >>> 6) & 7] << 6)) ^ (jArr[(i13 >>> 9) & 7] << 9)) ^ (jArr[(i13 >>> 12) & 7] << 12);
            j17 ^= j19 << i12;
            j18 ^= j19 >>> (-i12);
            i12 -= 15;
        } while (i12 > 0);
        jArr2[i10] = jArr2[i10] ^ (M49 & j17);
        int i14 = i10 + 1;
        jArr2[i14] = jArr2[i14] ^ ((j17 >>> 49) ^ (j18 << 15));
    }

    protected static void implSquare(long[] jArr, long[] jArr2) {
        Interleave.expand64To128(jArr, 0, 3, jArr2, 0);
        jArr2[6] = jArr[3] & 1;
    }

    public static void invert(long[] jArr, long[] jArr2) {
        if (!Nat256.isZero64(jArr)) {
            long[] create64 = Nat256.create64();
            long[] create642 = Nat256.create64();
            square(jArr, create64);
            squareN(create64, 1, create642);
            multiply(create64, create642, create64);
            squareN(create642, 1, create642);
            multiply(create64, create642, create64);
            squareN(create64, 3, create642);
            multiply(create64, create642, create64);
            squareN(create64, 6, create642);
            multiply(create64, create642, create64);
            squareN(create64, 12, create642);
            multiply(create64, create642, create64);
            squareN(create64, 24, create642);
            multiply(create64, create642, create64);
            squareN(create64, 48, create642);
            multiply(create64, create642, create64);
            squareN(create64, 96, create642);
            multiply(create64, create642, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat256.createExt64();
        implMultiply(jArr, jArr2, createExt64);
        reduce(createExt64, jArr3);
    }

    public static void multiplyAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat256.createExt64();
        implMultiply(jArr, jArr2, createExt64);
        addExt(jArr3, createExt64, jArr3);
    }

    public static void reduce(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        long j14 = jArr[4];
        long j15 = jArr[5];
        long j16 = jArr[6];
        long j17 = j14 ^ (j16 >>> 50);
        long j18 = (j13 ^ ((j16 >>> 1) ^ (j16 << 14))) ^ (j15 >>> 50);
        long j19 = j10 ^ (j17 << 63);
        long j20 = (j11 ^ (j15 << 63)) ^ ((j17 >>> 1) ^ (j17 << 14));
        long j21 = ((j12 ^ (j16 << 63)) ^ ((j15 >>> 1) ^ (j15 << 14))) ^ (j17 >>> 50);
        long j22 = j18 >>> 1;
        jArr2[0] = (j19 ^ j22) ^ (j22 << 15);
        jArr2[1] = (j22 >>> 49) ^ j20;
        jArr2[2] = j21;
        jArr2[3] = 1 & j18;
    }

    public static void reduce63(long[] jArr, int i10) {
        int i11 = i10 + 3;
        long j10 = jArr[i11];
        long j11 = j10 >>> 1;
        jArr[i10] = jArr[i10] ^ ((j11 << 15) ^ j11);
        int i12 = i10 + 1;
        jArr[i12] = (j11 >>> 49) ^ jArr[i12];
        jArr[i11] = j10 & 1;
    }

    public static void sqrt(long[] jArr, long[] jArr2) {
        long unshuffle = Interleave.unshuffle(jArr[0]);
        long unshuffle2 = Interleave.unshuffle(jArr[1]);
        long j10 = (unshuffle & UInt32.MAX_VALUE_LONG) | (unshuffle2 << 32);
        long j11 = (unshuffle >>> 32) | (unshuffle2 & -4294967296L);
        long unshuffle3 = Interleave.unshuffle(jArr[2]);
        long j12 = (unshuffle3 & UInt32.MAX_VALUE_LONG) ^ (jArr[3] << 32);
        long j13 = unshuffle3 >>> 32;
        jArr2[0] = j10 ^ (j11 << 8);
        jArr2[1] = ((j12 ^ (j13 << 8)) ^ (j11 >>> 56)) ^ (j11 << 33);
        jArr2[2] = (j11 >>> 31) ^ ((j13 >>> 56) ^ (j13 << 33));
        jArr2[3] = j13 >>> 31;
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat256.createExt64();
        implSquare(jArr, createExt64);
        reduce(createExt64, jArr2);
    }

    public static void squareAddToExt(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat256.createExt64();
        implSquare(jArr, createExt64);
        addExt(jArr2, createExt64, jArr2);
    }

    public static void squareN(long[] jArr, int i10, long[] jArr2) {
        long[] createExt64 = Nat256.createExt64();
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
        return ((int) jArr[0]) & 1;
    }
}
