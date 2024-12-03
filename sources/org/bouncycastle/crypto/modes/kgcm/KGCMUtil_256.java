package org.bouncycastle.crypto.modes.kgcm;

import org.bouncycastle.math.raw.Interleave;

public class KGCMUtil_256 {
    public static final int SIZE = 4;

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr2[3] ^ jArr[3];
    }

    public static void copy(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
    }

    public static boolean equal(long[] jArr, long[] jArr2) {
        return ((jArr2[3] ^ jArr[3]) | ((((jArr[0] ^ jArr2[0]) | 0) | (jArr[1] ^ jArr2[1])) | (jArr[2] ^ jArr2[2]))) == 0;
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        int i10;
        long j10;
        long j11 = jArr[0];
        long j12 = jArr[1];
        long j13 = jArr[2];
        long j14 = jArr[3];
        long j15 = jArr2[0];
        long j16 = jArr2[1];
        long j17 = jArr2[2];
        long j18 = jArr2[3];
        long j19 = 0;
        int i11 = 0;
        long j20 = 0;
        long j21 = 0;
        long j22 = 0;
        long j23 = 0;
        while (true) {
            j10 = j13;
            if (i11 >= 64) {
                break;
            }
            long j24 = -(j11 & 1);
            j19 ^= j15 & j24;
            long j25 = -(j12 & 1);
            j12 >>>= 1;
            j20 = (j20 ^ (j16 & j24)) ^ (j15 & j25);
            j21 = (j21 ^ (j17 & j24)) ^ (j16 & j25);
            j22 = (j22 ^ (j18 & j24)) ^ (j17 & j25);
            j23 ^= j18 & j25;
            long j26 = j18 >> 63;
            j18 = (j18 << 1) | (j17 >>> 63);
            j17 = (j17 << 1) | (j16 >>> 63);
            j16 = (j15 >>> 63) | (j16 << 1);
            j15 = (j15 << 1) ^ (j26 & 1061);
            i11++;
            j11 >>>= 1;
            j13 = j10;
        }
        long j27 = (((j18 >>> 62) ^ j15) ^ (j18 >>> 59)) ^ (j18 >>> 54);
        long j28 = j17;
        int i12 = 0;
        long j29 = j16;
        long j30 = j14;
        long j31 = ((j18 ^ (j18 << 2)) ^ (j18 << 5)) ^ (j18 << 10);
        long j32 = j10;
        for (i10 = 64; i12 < i10; i10 = 64) {
            long j33 = -(j32 & 1);
            j32 >>>= 1;
            j19 ^= j31 & j33;
            long j34 = j31;
            long j35 = -(j30 & 1);
            j30 >>>= 1;
            j20 = (j20 ^ (j27 & j33)) ^ (j34 & j35);
            j21 = (j21 ^ (j29 & j33)) ^ (j27 & j35);
            j22 = (j22 ^ (j28 & j33)) ^ (j29 & j35);
            j23 ^= j28 & j35;
            long j36 = j28 >> 63;
            j28 = (j28 << 1) | (j29 >>> 63);
            j29 = (j27 >>> 63) | (j29 << 1);
            j27 = (j27 << 1) | (j34 >>> 63);
            j31 = (j34 << 1) ^ (j36 & 1061);
            i12++;
        }
        jArr3[0] = j19 ^ (((j23 ^ (j23 << 2)) ^ (j23 << 5)) ^ (j23 << 10));
        jArr3[1] = j20 ^ (((j23 >>> 62) ^ (j23 >>> 59)) ^ (j23 >>> 54));
        jArr3[2] = j21;
        jArr3[3] = j22;
    }

    public static void multiplyX(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        jArr2[0] = ((j13 >> 63) & 1061) ^ (j10 << 1);
        jArr2[1] = (j10 >>> 63) | (j11 << 1);
        jArr2[2] = (j12 << 1) | (j11 >>> 63);
        jArr2[3] = (j13 << 1) | (j12 >>> 63);
    }

    public static void multiplyX8(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        long j14 = j13 >>> 56;
        jArr2[0] = ((((j10 << 8) ^ j14) ^ (j14 << 2)) ^ (j14 << 5)) ^ (j14 << 10);
        jArr2[1] = (j10 >>> 56) | (j11 << 8);
        jArr2[2] = (j12 << 8) | (j11 >>> 56);
        jArr2[3] = (j13 << 8) | (j12 >>> 56);
    }

    public static void one(long[] jArr) {
        jArr[0] = 1;
        jArr[1] = 0;
        jArr[2] = 0;
        jArr[3] = 0;
    }

    public static void square(long[] jArr, long[] jArr2) {
        int i10 = 8;
        long[] jArr3 = new long[8];
        for (int i11 = 0; i11 < 4; i11++) {
            Interleave.expand64To128(jArr[i11], jArr3, i11 << 1);
        }
        while (true) {
            i10--;
            if (i10 >= 4) {
                long j10 = jArr3[i10];
                int i12 = i10 - 4;
                jArr3[i12] = jArr3[i12] ^ ((((j10 << 2) ^ j10) ^ (j10 << 5)) ^ (j10 << 10));
                int i13 = i12 + 1;
                jArr3[i13] = ((j10 >>> 54) ^ ((j10 >>> 62) ^ (j10 >>> 59))) ^ jArr3[i13];
            } else {
                copy(jArr3, jArr2);
                return;
            }
        }
    }

    public static void x(long[] jArr) {
        jArr[0] = 2;
        jArr[1] = 0;
        jArr[2] = 0;
        jArr[3] = 0;
    }

    public static void zero(long[] jArr) {
        jArr[0] = 0;
        jArr[1] = 0;
        jArr[2] = 0;
        jArr[3] = 0;
    }
}
