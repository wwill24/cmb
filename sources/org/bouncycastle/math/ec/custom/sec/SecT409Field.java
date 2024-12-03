package org.bouncycastle.math.ec.custom.sec;

import com.withpersona.sdk2.inquiry.network.HttpStatusCode;
import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat448;
import org.jivesoftware.smack.datatypes.UInt32;

public class SecT409Field {
    private static final long M25 = 33554431;
    private static final long M59 = 576460752303423487L;

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr2[6] ^ jArr[6];
    }

    public static void addExt(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i10 = 0; i10 < 13; i10++) {
            jArr3[i10] = jArr[i10] ^ jArr2[i10];
        }
    }

    public static void addOne(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
        jArr2[5] = jArr[5];
        jArr2[6] = jArr[6];
    }

    private static void addTo(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr2[0] ^ jArr[0];
        jArr2[1] = jArr2[1] ^ jArr[1];
        jArr2[2] = jArr2[2] ^ jArr[2];
        jArr2[3] = jArr2[3] ^ jArr[3];
        jArr2[4] = jArr2[4] ^ jArr[4];
        jArr2[5] = jArr2[5] ^ jArr[5];
        jArr2[6] = jArr2[6] ^ jArr[6];
    }

    public static long[] fromBigInteger(BigInteger bigInteger) {
        return Nat.fromBigInteger64(HttpStatusCode.CONFLICT_409, bigInteger);
    }

    public static void halfTrace(long[] jArr, long[] jArr2) {
        long[] create64 = Nat.create64(13);
        Nat448.copy64(jArr, jArr2);
        for (int i10 = 1; i10 < 409; i10 += 2) {
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
        long j20 = jArr[10];
        long j21 = jArr[11];
        long j22 = jArr[12];
        long j23 = jArr[13];
        jArr[0] = j10 ^ (j11 << 59);
        jArr[1] = (j11 >>> 5) ^ (j12 << 54);
        jArr[2] = (j12 >>> 10) ^ (j13 << 49);
        jArr[3] = (j13 >>> 15) ^ (j14 << 44);
        jArr[4] = (j14 >>> 20) ^ (j15 << 39);
        jArr[5] = (j15 >>> 25) ^ (j16 << 34);
        jArr[6] = (j16 >>> 30) ^ (j17 << 29);
        jArr[7] = (j17 >>> 35) ^ (j18 << 24);
        jArr[8] = (j18 >>> 40) ^ (j19 << 19);
        jArr[9] = (j19 >>> 45) ^ (j20 << 14);
        jArr[10] = (j20 >>> 50) ^ (j21 << 9);
        jArr[11] = ((j21 >>> 55) ^ (j22 << 4)) ^ (j23 << 63);
        jArr[12] = j23 >>> 1;
    }

    protected static void implExpand(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        long j14 = jArr[4];
        long j15 = jArr[5];
        long j16 = jArr[6];
        jArr2[0] = j10 & M59;
        jArr2[1] = ((j10 >>> 59) ^ (j11 << 5)) & M59;
        jArr2[2] = ((j11 >>> 54) ^ (j12 << 10)) & M59;
        jArr2[3] = ((j12 >>> 49) ^ (j13 << 15)) & M59;
        jArr2[4] = ((j13 >>> 44) ^ (j14 << 20)) & M59;
        jArr2[5] = ((j14 >>> 39) ^ (j15 << 25)) & M59;
        jArr2[6] = (j15 >>> 34) ^ (j16 << 30);
    }

    protected static void implMultiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[7];
        long[] jArr5 = new long[7];
        implExpand(jArr, jArr4);
        implExpand(jArr2, jArr5);
        long[] jArr6 = new long[8];
        for (int i10 = 0; i10 < 7; i10++) {
            implMulwAcc(jArr6, jArr4[i10], jArr5[i10], jArr3, i10 << 1);
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
        long j29 = (j26 ^ jArr3[13]) ^ j27;
        jArr3[7] = j10 ^ j29;
        jArr3[8] = j13 ^ j29;
        jArr3[9] = j16 ^ j29;
        jArr3[10] = j19 ^ j29;
        jArr3[11] = j22 ^ j29;
        jArr3[12] = j25 ^ j29;
        jArr3[13] = j28 ^ j29;
        implMulwAcc(jArr6, jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        implMulwAcc(jArr6, jArr4[0] ^ jArr4[2], jArr5[0] ^ jArr5[2], jArr3, 2);
        implMulwAcc(jArr6, jArr4[0] ^ jArr4[3], jArr5[0] ^ jArr5[3], jArr3, 3);
        implMulwAcc(jArr6, jArr4[1] ^ jArr4[2], jArr5[1] ^ jArr5[2], jArr3, 3);
        implMulwAcc(jArr6, jArr4[0] ^ jArr4[4], jArr5[0] ^ jArr5[4], jArr3, 4);
        implMulwAcc(jArr6, jArr4[1] ^ jArr4[3], jArr5[1] ^ jArr5[3], jArr3, 4);
        implMulwAcc(jArr6, jArr4[0] ^ jArr4[5], jArr5[0] ^ jArr5[5], jArr3, 5);
        implMulwAcc(jArr6, jArr4[1] ^ jArr4[4], jArr5[1] ^ jArr5[4], jArr3, 5);
        implMulwAcc(jArr6, jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 5);
        implMulwAcc(jArr6, jArr4[0] ^ jArr4[6], jArr5[0] ^ jArr5[6], jArr3, 6);
        implMulwAcc(jArr6, jArr4[1] ^ jArr4[5], jArr5[1] ^ jArr5[5], jArr3, 6);
        implMulwAcc(jArr6, jArr4[2] ^ jArr4[4], jArr5[2] ^ jArr5[4], jArr3, 6);
        implMulwAcc(jArr6, jArr4[1] ^ jArr4[6], jArr5[1] ^ jArr5[6], jArr3, 7);
        implMulwAcc(jArr6, jArr4[2] ^ jArr4[5], jArr5[2] ^ jArr5[5], jArr3, 7);
        implMulwAcc(jArr6, jArr4[3] ^ jArr4[4], jArr5[3] ^ jArr5[4], jArr3, 7);
        implMulwAcc(jArr6, jArr4[2] ^ jArr4[6], jArr5[2] ^ jArr5[6], jArr3, 8);
        implMulwAcc(jArr6, jArr4[3] ^ jArr4[5], jArr5[3] ^ jArr5[5], jArr3, 8);
        implMulwAcc(jArr6, jArr4[3] ^ jArr4[6], jArr5[3] ^ jArr5[6], jArr3, 9);
        implMulwAcc(jArr6, jArr4[4] ^ jArr4[5], jArr5[4] ^ jArr5[5], jArr3, 9);
        implMulwAcc(jArr6, jArr4[4] ^ jArr4[6], jArr5[4] ^ jArr5[6], jArr3, 10);
        implMulwAcc(jArr6, jArr4[5] ^ jArr4[6], jArr5[5] ^ jArr5[6], jArr3, 11);
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
        int i12 = 54;
        do {
            int i13 = (int) (j12 >>> i12);
            long j19 = jArr[i13 & 7] ^ (jArr[(i13 >>> 3) & 7] << 3);
            j17 ^= j19 << i12;
            j18 ^= j19 >>> (-i12);
            i12 -= 6;
        } while (i12 > 0);
        jArr2[i10] = jArr2[i10] ^ (M59 & j17);
        int i14 = i10 + 1;
        jArr2[i14] = jArr2[i14] ^ ((j17 >>> 59) ^ (j18 << 5));
    }

    protected static void implSquare(long[] jArr, long[] jArr2) {
        Interleave.expand64To128(jArr, 0, 6, jArr2, 0);
        jArr2[12] = Interleave.expand32to64((int) jArr[6]);
    }

    public static void invert(long[] jArr, long[] jArr2) {
        if (!Nat448.isZero64(jArr)) {
            long[] create64 = Nat448.create64();
            long[] create642 = Nat448.create64();
            long[] create643 = Nat448.create64();
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
            multiply(create64, create642, create643);
            squareN(create643, 24, create64);
            squareN(create64, 24, create642);
            multiply(create64, create642, create64);
            squareN(create64, 48, create642);
            multiply(create64, create642, create64);
            squareN(create64, 96, create642);
            multiply(create64, create642, create64);
            squareN(create64, 192, create642);
            multiply(create64, create642, create64);
            multiply(create64, create643, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat448.createExt64();
        implMultiply(jArr, jArr2, createExt64);
        reduce(createExt64, jArr3);
    }

    public static void multiplyAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat448.createExt64();
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
        long j18 = jArr[12];
        long j19 = j16 ^ ((j18 >>> 25) ^ (j18 << 62));
        long j20 = j17 ^ (j18 >>> 2);
        long j21 = jArr[11];
        long j22 = j14 ^ (j21 << 39);
        long j23 = (j15 ^ (j18 << 39)) ^ ((j21 >>> 25) ^ (j21 << 62));
        long j24 = j19 ^ (j21 >>> 2);
        long j25 = jArr[10];
        long j26 = j13 ^ (j25 << 39);
        long j27 = j22 ^ ((j25 >>> 25) ^ (j25 << 62));
        long j28 = j23 ^ (j25 >>> 2);
        long j29 = jArr[9];
        long j30 = j12 ^ (j29 << 39);
        long j31 = j26 ^ ((j29 >>> 25) ^ (j29 << 62));
        long j32 = j27 ^ (j29 >>> 2);
        long j33 = jArr[8];
        long j34 = j10 ^ (j20 << 39);
        long j35 = (j30 ^ ((j33 >>> 25) ^ (j33 << 62))) ^ (j20 >>> 2);
        long j36 = j24 >>> 25;
        jArr2[0] = j34 ^ j36;
        long j37 = j36 << 23;
        jArr2[1] = j37 ^ ((j11 ^ (j33 << 39)) ^ ((j20 >>> 25) ^ (j20 << 62)));
        jArr2[2] = j35;
        jArr2[3] = j31 ^ (j33 >>> 2);
        jArr2[4] = j32;
        jArr2[5] = j28;
        jArr2[6] = j24 & M25;
    }

    public static void reduce39(long[] jArr, int i10) {
        int i11 = i10 + 6;
        long j10 = jArr[i11];
        long j11 = j10 >>> 25;
        jArr[i10] = jArr[i10] ^ j11;
        int i12 = i10 + 1;
        jArr[i12] = (j11 << 23) ^ jArr[i12];
        jArr[i11] = j10 & M25;
    }

    public static void sqrt(long[] jArr, long[] jArr2) {
        long unshuffle = Interleave.unshuffle(jArr[0]);
        long unshuffle2 = Interleave.unshuffle(jArr[1]);
        long j10 = (unshuffle & UInt32.MAX_VALUE_LONG) | (unshuffle2 << 32);
        long j11 = (unshuffle >>> 32) | (unshuffle2 & -4294967296L);
        long unshuffle3 = Interleave.unshuffle(jArr[2]);
        long unshuffle4 = Interleave.unshuffle(jArr[3]);
        long j12 = (unshuffle3 & UInt32.MAX_VALUE_LONG) | (unshuffle4 << 32);
        long j13 = (unshuffle3 >>> 32) | (unshuffle4 & -4294967296L);
        long unshuffle5 = Interleave.unshuffle(jArr[4]);
        long unshuffle6 = Interleave.unshuffle(jArr[5]);
        long j14 = (unshuffle5 & UInt32.MAX_VALUE_LONG) | (unshuffle6 << 32);
        long j15 = (unshuffle5 >>> 32) | (unshuffle6 & -4294967296L);
        long unshuffle7 = Interleave.unshuffle(jArr[6]);
        long j16 = unshuffle7 & UInt32.MAX_VALUE_LONG;
        long j17 = unshuffle7 >>> 32;
        jArr2[0] = j10 ^ (j11 << 44);
        jArr2[1] = (j12 ^ (j13 << 44)) ^ (j11 >>> 20);
        jArr2[2] = (j14 ^ (j15 << 44)) ^ (j13 >>> 20);
        jArr2[3] = (((j17 << 44) ^ j16) ^ (j15 >>> 20)) ^ (j11 << 13);
        jArr2[4] = (j11 >>> 51) ^ ((j17 >>> 20) ^ (j13 << 13));
        jArr2[5] = (j15 << 13) ^ (j13 >>> 51);
        jArr2[6] = (j17 << 13) ^ (j15 >>> 51);
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] create64 = Nat.create64(13);
        implSquare(jArr, create64);
        reduce(create64, jArr2);
    }

    public static void squareAddToExt(long[] jArr, long[] jArr2) {
        long[] create64 = Nat.create64(13);
        implSquare(jArr, create64);
        addExt(jArr2, create64, jArr2);
    }

    public static void squareN(long[] jArr, int i10, long[] jArr2) {
        long[] create64 = Nat.create64(13);
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
        return ((int) jArr[0]) & 1;
    }
}
