package org.bouncycastle.crypto.modes.kgcm;

import org.bouncycastle.math.raw.Interleave;

public class KGCMUtil_512 {
    public static final int SIZE = 8;

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr2[7] ^ jArr[7];
    }

    public static void copy(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
        jArr2[5] = jArr[5];
        jArr2[6] = jArr[6];
        jArr2[7] = jArr[7];
    }

    public static boolean equal(long[] jArr, long[] jArr2) {
        return ((jArr2[7] ^ jArr[7]) | ((((((((jArr[0] ^ jArr2[0]) | 0) | (jArr[1] ^ jArr2[1])) | (jArr[2] ^ jArr2[2])) | (jArr[3] ^ jArr2[3])) | (jArr[4] ^ jArr2[4])) | (jArr[5] ^ jArr2[5])) | (jArr[6] ^ jArr2[6]))) == 0;
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        int i10 = 0;
        long j10 = jArr2[0];
        long j11 = jArr2[1];
        char c10 = 2;
        long j12 = jArr2[2];
        long j13 = jArr2[3];
        long j14 = jArr2[4];
        long j15 = jArr2[5];
        long j16 = jArr2[6];
        long j17 = jArr2[7];
        long j18 = 0;
        int i11 = 0;
        long j19 = 0;
        long j20 = 0;
        long j21 = 0;
        long j22 = 0;
        long j23 = 0;
        long j24 = 0;
        long j25 = 0;
        long j26 = 0;
        while (i11 < 8) {
            long j27 = jArr[i11];
            long j28 = jArr[i11 + 1];
            long j29 = j11;
            long j30 = j16;
            j16 = j15;
            j15 = j14;
            j14 = j13;
            j13 = j12;
            long j31 = j29;
            while (i10 < 64) {
                long j32 = j31;
                long j33 = -(j27 & 1);
                j27 >>>= 1;
                j18 ^= j10 & j33;
                long j34 = j13;
                long j35 = -(j28 & 1);
                j28 >>>= 1;
                j20 = (j20 ^ (j32 & j33)) ^ (j10 & j35);
                j21 = (j21 ^ (j13 & j33)) ^ (j32 & j35);
                j22 = (j22 ^ (j14 & j33)) ^ (j34 & j35);
                j23 = (j23 ^ (j15 & j33)) ^ (j14 & j35);
                j24 = (j24 ^ (j16 & j33)) ^ (j15 & j35);
                j25 = (j25 ^ (j30 & j33)) ^ (j16 & j35);
                j26 = (j26 ^ (j17 & j33)) ^ (j30 & j35);
                j19 ^= j17 & j35;
                long j36 = j17 >> 63;
                j17 = (j17 << 1) | (j30 >>> 63);
                j30 = (j30 << 1) | (j16 >>> 63);
                j16 = (j16 << 1) | (j15 >>> 63);
                j15 = (j15 << 1) | (j14 >>> 63);
                j14 = (j14 << 1) | (j34 >>> 63);
                j10 = (j10 << 1) ^ (j36 & 293);
                i10++;
                j31 = (j32 << 1) | (j10 >>> 63);
                j13 = (j34 << 1) | (j32 >>> 63);
            }
            long j37 = j13;
            long j38 = ((j10 ^ (j17 >>> 62)) ^ (j17 >>> 59)) ^ (j17 >>> 56);
            i11 += 2;
            j17 = j30;
            j11 = j38;
            i10 = 0;
            c10 = 2;
            j10 = ((j17 ^ (j17 << 2)) ^ (j17 << 5)) ^ (j17 << 8);
            j12 = j31;
        }
        jArr3[0] = j18 ^ (((j19 ^ (j19 << c10)) ^ (j19 << 5)) ^ (j19 << 8));
        jArr3[1] = j20 ^ (((j19 >>> 62) ^ (j19 >>> 59)) ^ (j19 >>> 56));
        jArr3[2] = j21;
        jArr3[3] = j22;
        jArr3[4] = j23;
        jArr3[5] = j24;
        jArr3[6] = j25;
        jArr3[7] = j26;
    }

    public static void multiplyX(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        long j14 = jArr[4];
        long j15 = jArr[5];
        long j16 = jArr[6];
        long j17 = jArr[7];
        jArr2[0] = (j10 << 1) ^ ((j17 >> 63) & 293);
        jArr2[1] = (j11 << 1) | (j10 >>> 63);
        jArr2[2] = (j12 << 1) | (j11 >>> 63);
        jArr2[3] = (j13 << 1) | (j12 >>> 63);
        jArr2[4] = (j14 << 1) | (j13 >>> 63);
        jArr2[5] = (j15 << 1) | (j14 >>> 63);
        jArr2[6] = (j16 << 1) | (j15 >>> 63);
        jArr2[7] = (j17 << 1) | (j16 >>> 63);
    }

    public static void multiplyX8(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        long j14 = jArr[4];
        long j15 = jArr[5];
        long j16 = jArr[6];
        long j17 = jArr[7];
        long j18 = j17 >>> 56;
        jArr2[0] = ((((j10 << 8) ^ j18) ^ (j18 << 2)) ^ (j18 << 5)) ^ (j18 << 8);
        jArr2[1] = (j11 << 8) | (j10 >>> 56);
        jArr2[2] = (j12 << 8) | (j11 >>> 56);
        jArr2[3] = (j13 << 8) | (j12 >>> 56);
        jArr2[4] = (j14 << 8) | (j13 >>> 56);
        jArr2[5] = (j15 << 8) | (j14 >>> 56);
        jArr2[6] = (j16 << 8) | (j15 >>> 56);
        jArr2[7] = (j17 << 8) | (j16 >>> 56);
    }

    public static void one(long[] jArr) {
        jArr[0] = 1;
        jArr[1] = 0;
        jArr[2] = 0;
        jArr[3] = 0;
        jArr[4] = 0;
        jArr[5] = 0;
        jArr[6] = 0;
        jArr[7] = 0;
    }

    public static void square(long[] jArr, long[] jArr2) {
        int i10 = 16;
        long[] jArr3 = new long[16];
        for (int i11 = 0; i11 < 8; i11++) {
            Interleave.expand64To128(jArr[i11], jArr3, i11 << 1);
        }
        while (true) {
            i10--;
            if (i10 >= 8) {
                long j10 = jArr3[i10];
                int i12 = i10 - 8;
                jArr3[i12] = jArr3[i12] ^ ((((j10 << 2) ^ j10) ^ (j10 << 5)) ^ (j10 << 8));
                int i13 = i12 + 1;
                jArr3[i13] = ((j10 >>> 56) ^ ((j10 >>> 62) ^ (j10 >>> 59))) ^ jArr3[i13];
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
        jArr[4] = 0;
        jArr[5] = 0;
        jArr[6] = 0;
        jArr[7] = 0;
    }

    public static void zero(long[] jArr) {
        jArr[0] = 0;
        jArr[1] = 0;
        jArr[2] = 0;
        jArr[3] = 0;
        jArr[4] = 0;
        jArr[5] = 0;
        jArr[6] = 0;
        jArr[7] = 0;
    }
}
