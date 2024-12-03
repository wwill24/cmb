package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import net.bytebuddy.jar.asm.Opcodes;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat320;
import org.jivesoftware.smack.datatypes.UInt32;

public class SecT283Field {
    private static final long M27 = 134217727;
    private static final long M57 = 144115188075855871L;
    private static final long[] ROOT_Z = {878416384462358536L, 3513665537849438403L, -9076969306111048948L, 585610922974906400L, 34087042};

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr2[4] ^ jArr[4];
    }

    public static void addExt(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr[7] ^ jArr2[7];
        jArr3[8] = jArr2[8] ^ jArr[8];
    }

    public static void addOne(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
    }

    private static void addTo(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr2[0] ^ jArr[0];
        jArr2[1] = jArr2[1] ^ jArr[1];
        jArr2[2] = jArr2[2] ^ jArr[2];
        jArr2[3] = jArr2[3] ^ jArr[3];
        jArr2[4] = jArr2[4] ^ jArr[4];
    }

    public static long[] fromBigInteger(BigInteger bigInteger) {
        return Nat.fromBigInteger64(283, bigInteger);
    }

    public static void halfTrace(long[] jArr, long[] jArr2) {
        long[] create64 = Nat.create64(9);
        Nat320.copy64(jArr, jArr2);
        for (int i10 = 1; i10 < 283; i10 += 2) {
            implSquare(jArr2, create64);
            reduce(create64, jArr2);
            implSquare(jArr2, create64);
            reduce(create64, jArr2);
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
        long j18 = jArr[8];
        long j19 = jArr[9];
        jArr[0] = j10 ^ (j11 << 57);
        jArr[1] = (j11 >>> 7) ^ (j12 << 50);
        jArr[2] = (j12 >>> 14) ^ (j13 << 43);
        jArr[3] = (j13 >>> 21) ^ (j14 << 36);
        jArr[4] = (j14 >>> 28) ^ (j15 << 29);
        jArr[5] = (j15 >>> 35) ^ (j16 << 22);
        jArr[6] = (j16 >>> 42) ^ (j17 << 15);
        jArr[7] = (j17 >>> 49) ^ (j18 << 8);
        jArr[8] = (j18 >>> 56) ^ (j19 << 1);
        jArr[9] = j19 >>> 63;
    }

    protected static void implExpand(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        long j14 = jArr[4];
        jArr2[0] = j10 & M57;
        jArr2[1] = ((j10 >>> 57) ^ (j11 << 7)) & M57;
        jArr2[2] = ((j11 >>> 50) ^ (j12 << 14)) & M57;
        jArr2[3] = ((j12 >>> 43) ^ (j13 << 21)) & M57;
        jArr2[4] = (j13 >>> 36) ^ (j14 << 28);
    }

    protected static void implMultiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[5];
        long[] jArr5 = new long[5];
        implExpand(jArr, jArr4);
        implExpand(jArr2, jArr5);
        long[] jArr6 = new long[26];
        long[] jArr7 = jArr3;
        long[] jArr8 = jArr6;
        implMulw(jArr7, jArr4[0], jArr5[0], jArr8, 0);
        implMulw(jArr7, jArr4[1], jArr5[1], jArr8, 2);
        implMulw(jArr7, jArr4[2], jArr5[2], jArr8, 4);
        implMulw(jArr7, jArr4[3], jArr5[3], jArr8, 6);
        implMulw(jArr7, jArr4[4], jArr5[4], jArr8, 8);
        long j10 = jArr4[0];
        long j11 = j10 ^ jArr4[1];
        long j12 = jArr5[0];
        long j13 = j12 ^ jArr5[1];
        long j14 = jArr4[2];
        long j15 = j10 ^ j14;
        long j16 = jArr5[2];
        long j17 = j12 ^ j16;
        long j18 = jArr4[4];
        long j19 = j14 ^ j18;
        long j20 = jArr5[4];
        long j21 = j16 ^ j20;
        long j22 = jArr4[3];
        long j23 = j22 ^ j18;
        long j24 = jArr5[3];
        long j25 = j24 ^ j20;
        long[] jArr9 = jArr6;
        implMulw(jArr3, j15 ^ j22, j17 ^ j24, jArr9, 18);
        long[] jArr10 = jArr3;
        implMulw(jArr10, j19 ^ jArr4[1], j21 ^ jArr5[1], jArr9, 20);
        long j26 = j11 ^ j23;
        long j27 = j13 ^ j25;
        long j28 = j26 ^ jArr4[2];
        long j29 = j27 ^ jArr5[2];
        long[] jArr11 = jArr6;
        implMulw(jArr10, j26, j27, jArr11, 22);
        implMulw(jArr10, j28, j29, jArr11, 24);
        implMulw(jArr10, j11, j13, jArr11, 10);
        implMulw(jArr10, j15, j17, jArr11, 12);
        implMulw(jArr10, j19, j21, jArr11, 14);
        implMulw(jArr10, j23, j25, jArr11, 16);
        jArr3[0] = jArr6[0];
        jArr3[9] = jArr6[9];
        long j30 = jArr6[0];
        long j31 = jArr6[1] ^ j30;
        long j32 = jArr6[2] ^ j31;
        long j33 = jArr6[10] ^ j32;
        jArr3[1] = j33;
        long j34 = jArr6[3] ^ jArr6[4];
        long j35 = j32 ^ (j34 ^ (jArr6[11] ^ jArr6[12]));
        jArr3[2] = j35;
        long j36 = j31 ^ j34;
        long j37 = jArr6[5] ^ jArr6[6];
        long j38 = jArr6[8];
        long j39 = (j36 ^ j37) ^ j38;
        long j40 = jArr6[13] ^ jArr6[14];
        long j41 = jArr6[18];
        long j42 = jArr6[22];
        long j43 = jArr6[24];
        jArr3[3] = (j39 ^ j40) ^ ((j41 ^ j42) ^ j43);
        long j44 = jArr6[7] ^ j38;
        long j45 = jArr6[9];
        long j46 = j44 ^ j45;
        long j47 = j46 ^ jArr6[17];
        jArr3[8] = j47;
        long j48 = (j46 ^ j37) ^ (jArr6[15] ^ jArr6[16]);
        jArr3[7] = j48;
        long j49 = j33 ^ j48;
        long j50 = jArr6[19] ^ jArr6[20];
        long j51 = jArr6[25];
        long j52 = jArr6[23];
        long j53 = j50 ^ (j51 ^ j43);
        jArr3[4] = (j53 ^ (j41 ^ j52)) ^ j49;
        long j54 = jArr6[21];
        jArr3[5] = ((j35 ^ j47) ^ j53) ^ (j54 ^ j42);
        jArr3[6] = (((((j39 ^ j30) ^ j45) ^ j40) ^ j54) ^ j52) ^ j51;
        implCompactExt(jArr3);
    }

    protected static void implMulw(long[] jArr, long j10, long j11, long[] jArr2, int i10) {
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
        long j17 = jArr[((int) j12) & 7];
        long j18 = 0;
        int i11 = 48;
        do {
            int i12 = (int) (j12 >>> i11);
            long j19 = (jArr[i12 & 7] ^ (jArr[(i12 >>> 3) & 7] << 3)) ^ (jArr[(i12 >>> 6) & 7] << 6);
            j17 ^= j19 << i11;
            j18 ^= j19 >>> (-i11);
            i11 -= 9;
        } while (i11 > 0);
        jArr2[i10] = M57 & j17;
        jArr2[i10 + 1] = (((((j12 & 72198606942111744L) & ((j11 << 7) >> 63)) >>> 8) ^ j18) << 7) ^ (j17 >>> 57);
    }

    protected static void implSquare(long[] jArr, long[] jArr2) {
        Interleave.expand64To128(jArr, 0, 4, jArr2, 0);
        jArr2[8] = Interleave.expand32to64((int) jArr[4]);
    }

    public static void invert(long[] jArr, long[] jArr2) {
        if (!Nat320.isZero64(jArr)) {
            long[] create64 = Nat320.create64();
            long[] create642 = Nat320.create64();
            square(jArr, create64);
            multiply(create64, jArr, create64);
            squareN(create64, 2, create642);
            multiply(create642, create64, create642);
            squareN(create642, 4, create64);
            multiply(create64, create642, create64);
            squareN(create64, 8, create642);
            multiply(create642, create64, create642);
            square(create642, create642);
            multiply(create642, jArr, create642);
            squareN(create642, 17, create64);
            multiply(create64, create642, create64);
            square(create64, create64);
            multiply(create64, jArr, create64);
            squareN(create64, 35, create642);
            multiply(create642, create64, create642);
            squareN(create642, 70, create64);
            multiply(create64, create642, create64);
            square(create64, create64);
            multiply(create64, jArr, create64);
            squareN(create64, Opcodes.F2D, create642);
            multiply(create642, create64, create642);
            square(create642, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat320.createExt64();
        implMultiply(jArr, jArr2, createExt64);
        reduce(createExt64, jArr3);
    }

    public static void multiplyAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat320.createExt64();
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
        long j17 = jArr[7];
        long j18 = jArr[8];
        long j19 = j14 ^ ((((j18 >>> 27) ^ (j18 >>> 22)) ^ (j18 >>> 20)) ^ (j18 >>> 15));
        long j20 = j10 ^ ((((j15 << 37) ^ (j15 << 42)) ^ (j15 << 44)) ^ (j15 << 49));
        long j21 = (j11 ^ ((((j16 << 37) ^ (j16 << 42)) ^ (j16 << 44)) ^ (j16 << 49))) ^ ((((j15 >>> 27) ^ (j15 >>> 22)) ^ (j15 >>> 20)) ^ (j15 >>> 15));
        long j22 = j19 >>> 27;
        jArr2[0] = (((j20 ^ j22) ^ (j22 << 5)) ^ (j22 << 7)) ^ (j22 << 12);
        jArr2[1] = j21;
        jArr2[2] = (j12 ^ ((((j17 << 37) ^ (j17 << 42)) ^ (j17 << 44)) ^ (j17 << 49))) ^ ((((j16 >>> 27) ^ (j16 >>> 22)) ^ (j16 >>> 20)) ^ (j16 >>> 15));
        jArr2[3] = (j13 ^ ((((j18 << 37) ^ (j18 << 42)) ^ (j18 << 44)) ^ (j18 << 49))) ^ ((((j17 >>> 27) ^ (j17 >>> 22)) ^ (j17 >>> 20)) ^ (j17 >>> 15));
        jArr2[4] = M27 & j19;
    }

    public static void reduce37(long[] jArr, int i10) {
        int i11 = i10 + 4;
        long j10 = jArr[i11];
        long j11 = j10 >>> 27;
        jArr[i10] = ((j11 << 12) ^ (((j11 << 5) ^ j11) ^ (j11 << 7))) ^ jArr[i10];
        jArr[i11] = j10 & M27;
    }

    public static void sqrt(long[] jArr, long[] jArr2) {
        long[] jArr3 = jArr2;
        long[] create64 = Nat320.create64();
        long unshuffle = Interleave.unshuffle(jArr[0]);
        long unshuffle2 = Interleave.unshuffle(jArr[1]);
        long j10 = (unshuffle & UInt32.MAX_VALUE_LONG) | (unshuffle2 << 32);
        create64[0] = (unshuffle >>> 32) | (unshuffle2 & -4294967296L);
        long unshuffle3 = Interleave.unshuffle(jArr[2]);
        long unshuffle4 = Interleave.unshuffle(jArr[3]);
        create64[1] = (unshuffle3 >>> 32) | (-4294967296L & unshuffle4);
        long unshuffle5 = Interleave.unshuffle(jArr[4]);
        long j11 = UInt32.MAX_VALUE_LONG & unshuffle5;
        create64[2] = unshuffle5 >>> 32;
        multiply(create64, ROOT_Z, jArr3);
        jArr3[0] = jArr3[0] ^ j10;
        jArr3[1] = jArr3[1] ^ ((unshuffle3 & UInt32.MAX_VALUE_LONG) | (unshuffle4 << 32));
        jArr3[2] = jArr3[2] ^ j11;
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] create64 = Nat.create64(9);
        implSquare(jArr, create64);
        reduce(create64, jArr2);
    }

    public static void squareAddToExt(long[] jArr, long[] jArr2) {
        long[] create64 = Nat.create64(9);
        implSquare(jArr, create64);
        addExt(jArr2, create64, jArr2);
    }

    public static void squareN(long[] jArr, int i10, long[] jArr2) {
        long[] create64 = Nat.create64(9);
        implSquare(jArr, create64);
        while (true) {
            reduce(create64, jArr2);
            i10--;
            if (i10 > 0) {
                implSquare(jArr2, create64);
            } else {
                return;
            }
        }
    }

    public static int trace(long[] jArr) {
        return ((int) (jArr[0] ^ (jArr[4] >>> 15))) & 1;
    }
}
