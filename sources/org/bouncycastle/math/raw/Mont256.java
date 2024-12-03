package org.bouncycastle.math.raw;

public abstract class Mont256 {
    private static final long M = 4294967295L;

    public static int inverse32(int i10) {
        int i11 = (2 - (i10 * i10)) * i10;
        int i12 = i11 * (2 - (i10 * i11));
        int i13 = i12 * (2 - (i10 * i12));
        return i13 * (2 - (i10 * i13));
    }

    public static void multAdd(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i10) {
        int[] iArr5 = iArr3;
        int[] iArr6 = iArr4;
        char c10 = 0;
        long j10 = ((long) iArr2[0]) & 4294967295L;
        int i11 = 0;
        int i12 = 0;
        while (i11 < 8) {
            long j11 = ((long) iArr[i11]) & 4294967295L;
            long j12 = j11 * j10;
            long j13 = (j12 & 4294967295L) + (((long) iArr5[c10]) & 4294967295L);
            long j14 = j10;
            long j15 = ((long) (((int) j13) * i10)) & 4294967295L;
            int i13 = i11;
            int i14 = i12;
            long j16 = (((long) iArr6[c10]) & 4294967295L) * j15;
            char c11 = ' ';
            long j17 = ((j13 + (j16 & 4294967295L)) >>> 32) + (j12 >>> 32) + (j16 >>> 32);
            int i15 = 1;
            while (i15 < 8) {
                long j18 = (((long) iArr2[i15]) & 4294967295L) * j11;
                long j19 = (((long) iArr6[i15]) & 4294967295L) * j15;
                long j20 = j17 + (j18 & 4294967295L) + (j19 & 4294967295L) + (((long) iArr5[i15]) & 4294967295L);
                iArr5[i15 - 1] = (int) j20;
                j17 = (j20 >>> 32) + (j18 >>> 32) + (j19 >>> 32);
                i15++;
                c11 = ' ';
                j15 = j15;
            }
            long j21 = j17 + (((long) i14) & 4294967295L);
            iArr5[7] = (int) j21;
            i12 = (int) (j21 >>> c11);
            i11 = i13 + 1;
            j10 = j14;
            c10 = 0;
        }
        if (i12 != 0 || Nat256.gte(iArr3, iArr4)) {
            Nat256.sub(iArr5, iArr6, iArr5);
        }
    }

    public static void multAddXF(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int[] iArr5 = iArr3;
        int[] iArr6 = iArr4;
        char c10 = 0;
        long j10 = ((long) iArr2[0]) & 4294967295L;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= 8) {
                break;
            }
            long j11 = ((long) iArr[i10]) & 4294967295L;
            long j12 = (j11 * j10) + (((long) iArr5[c10]) & 4294967295L);
            long j13 = j12 & 4294967295L;
            long j14 = (j12 >>> 32) + j13;
            int i12 = 1;
            for (int i13 = 8; i12 < i13; i13 = 8) {
                long j15 = j10;
                long j16 = (((long) iArr2[i12]) & 4294967295L) * j11;
                long j17 = (((long) iArr6[i12]) & 4294967295L) * j13;
                long j18 = j14 + (j16 & 4294967295L) + (j17 & 4294967295L) + (((long) iArr5[i12]) & 4294967295L);
                iArr5[i12 - 1] = (int) j18;
                j14 = (j18 >>> 32) + (j16 >>> 32) + (j17 >>> 32);
                i12++;
                j10 = j15;
                j11 = j11;
                j13 = j13;
            }
            long j19 = j14 + (((long) i11) & 4294967295L);
            iArr5[7] = (int) j19;
            i11 = (int) (j19 >>> 32);
            i10++;
            j10 = j10;
            c10 = 0;
        }
        if (i11 != 0 || Nat256.gte(iArr3, iArr4)) {
            Nat256.sub(iArr5, iArr6, iArr5);
        }
    }

    public static void reduce(int[] iArr, int[] iArr2, int i10) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        char c10 = 0;
        int i11 = 0;
        while (i11 < 8) {
            int i12 = iArr3[c10];
            long j10 = ((long) (i12 * i10)) & 4294967295L;
            long j11 = (((((long) iArr4[c10]) & 4294967295L) * j10) + (((long) i12) & 4294967295L)) >>> 32;
            int i13 = 1;
            while (i13 < 8) {
                long j12 = j11 + ((((long) iArr4[i13]) & 4294967295L) * j10) + (((long) iArr3[i13]) & 4294967295L);
                iArr3[i13 - 1] = (int) j12;
                j11 = j12 >>> 32;
                i13++;
                i11 = i11;
            }
            iArr3[7] = (int) j11;
            i11++;
            c10 = 0;
        }
        if (Nat256.gte(iArr, iArr2)) {
            Nat256.sub(iArr3, iArr4, iArr3);
        }
    }

    public static void reduceXF(int[] iArr, int[] iArr2) {
        for (int i10 = 0; i10 < 8; i10++) {
            long j10 = ((long) iArr[0]) & 4294967295L;
            long j11 = j10;
            for (int i11 = 1; i11 < 8; i11++) {
                long j12 = j11 + ((((long) iArr2[i11]) & 4294967295L) * j10) + (((long) iArr[i11]) & 4294967295L);
                iArr[i11 - 1] = (int) j12;
                j11 = j12 >>> 32;
            }
            iArr[7] = (int) j11;
        }
        if (Nat256.gte(iArr, iArr2)) {
            Nat256.sub(iArr, iArr2, iArr);
        }
    }
}
