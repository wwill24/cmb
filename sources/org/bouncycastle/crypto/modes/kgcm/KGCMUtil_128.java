package org.bouncycastle.crypto.modes.kgcm;

import org.bouncycastle.math.raw.Interleave;

public class KGCMUtil_128 {
    public static final int SIZE = 2;

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr2[1] ^ jArr[1];
    }

    public static void copy(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
    }

    public static boolean equal(long[] jArr, long[] jArr2) {
        return ((jArr2[1] ^ jArr[1]) | ((jArr[0] ^ jArr2[0]) | 0)) == 0;
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        int i10 = 0;
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr2[0];
        long j13 = jArr2[1];
        long j14 = 0;
        long j15 = 0;
        long j16 = 0;
        while (i10 < 64) {
            long j17 = j15;
            long j18 = -(j10 & 1);
            j10 >>>= 1;
            j14 ^= j12 & j18;
            long j19 = (j18 & j13) ^ j16;
            long j20 = -(j11 & 1);
            j11 >>>= 1;
            long j21 = j19 ^ (j12 & j20);
            long j22 = j17 ^ (j20 & j13);
            long j23 = j13 >> 63;
            j13 = (j13 << 1) | (j12 >>> 63);
            j12 = (j12 << 1) ^ (j23 & 135);
            i10++;
            long j24 = j21;
            j15 = j22;
            j16 = j24;
        }
        long j25 = j15;
        jArr3[0] = (((j25 ^ (j25 << 1)) ^ (j25 << 2)) ^ (j25 << 7)) ^ j14;
        jArr3[1] = (((j25 >>> 63) ^ (j25 >>> 62)) ^ (j25 >>> 57)) ^ j16;
    }

    public static void multiplyX(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        jArr2[0] = ((j11 >> 63) & 135) ^ (j10 << 1);
        jArr2[1] = (j10 >>> 63) | (j11 << 1);
    }

    public static void multiplyX8(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = j11 >>> 56;
        jArr2[0] = (j12 << 7) ^ ((((j10 << 8) ^ j12) ^ (j12 << 1)) ^ (j12 << 2));
        jArr2[1] = (j10 >>> 56) | (j11 << 8);
    }

    public static void one(long[] jArr) {
        jArr[0] = 1;
        jArr[1] = 0;
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[4];
        Interleave.expand64To128(jArr[0], jArr3, 0);
        Interleave.expand64To128(jArr[1], jArr3, 2);
        long j10 = jArr3[0];
        long j11 = jArr3[1];
        long j12 = jArr3[2];
        long j13 = jArr3[3];
        long j14 = j12 ^ ((j13 >>> 57) ^ ((j13 >>> 63) ^ (j13 >>> 62)));
        long j15 = j10 ^ ((((j14 << 1) ^ j14) ^ (j14 << 2)) ^ (j14 << 7));
        jArr2[0] = j15;
        jArr2[1] = (j11 ^ ((((j13 << 1) ^ j13) ^ (j13 << 2)) ^ (j13 << 7))) ^ ((j14 >>> 57) ^ ((j14 >>> 63) ^ (j14 >>> 62)));
    }

    public static void x(long[] jArr) {
        jArr[0] = 2;
        jArr[1] = 0;
    }

    public static void zero(long[] jArr) {
        jArr[0] = 0;
        jArr[1] = 0;
    }
}
