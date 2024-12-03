package org.bouncycastle.math.raw;

import java.util.Random;
import org.bouncycastle.util.Integers;

public abstract class Mod {
    private static final int M30 = 1073741823;
    private static final long M32L = 4294967295L;

    public static void add(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int length = iArr.length;
        if (Nat.add(length, iArr2, iArr3, iArr4) != 0) {
            Nat.subFrom(length, iArr, iArr4);
        }
    }

    private static int add30(int i10, int[] iArr, int[] iArr2) {
        int i11 = i10 - 1;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = i12 + iArr[i13] + iArr2[i13];
            iArr[i13] = M30 & i14;
            i12 = i14 >> 30;
        }
        int i15 = i12 + iArr[i11] + iArr2[i11];
        iArr[i11] = i15;
        return i15 >> 30;
    }

    public static void checkedModOddInverse(int[] iArr, int[] iArr2, int[] iArr3) {
        if (modOddInverse(iArr, iArr2, iArr3) == 0) {
            throw new ArithmeticException("Inverse does not exist.");
        }
    }

    public static void checkedModOddInverseVar(int[] iArr, int[] iArr2, int[] iArr3) {
        if (!modOddInverseVar(iArr, iArr2, iArr3)) {
            throw new ArithmeticException("Inverse does not exist.");
        }
    }

    private static void cnegate30(int i10, int i11, int[] iArr) {
        int i12 = i10 - 1;
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            int i15 = i13 + ((iArr[i14] ^ i11) - i11);
            iArr[i14] = M30 & i15;
            i13 = i15 >> 30;
        }
        iArr[i12] = i13 + ((iArr[i12] ^ i11) - i11);
    }

    private static void cnormalize30(int i10, int i11, int[] iArr, int[] iArr2) {
        int i12 = i10 - 1;
        int i13 = iArr[i12] >> 31;
        int i14 = 0;
        for (int i15 = 0; i15 < i12; i15++) {
            int i16 = i14 + (((iArr[i15] + (iArr2[i15] & i13)) ^ i11) - i11);
            iArr[i15] = M30 & i16;
            i14 = i16 >> 30;
        }
        int i17 = i14 + (((iArr[i12] + (i13 & iArr2[i12])) ^ i11) - i11);
        iArr[i12] = i17;
        int i18 = i17 >> 31;
        int i19 = 0;
        for (int i20 = 0; i20 < i12; i20++) {
            int i21 = i19 + iArr[i20] + (iArr2[i20] & i18);
            iArr[i20] = i21 & M30;
            i19 = i21 >> 30;
        }
        iArr[i12] = i19 + iArr[i12] + (i18 & iArr2[i12]);
    }

    private static void decode30(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        int i13 = 0;
        long j10 = 0;
        while (i10 > 0) {
            while (i13 < Math.min(32, i10)) {
                j10 |= ((long) iArr[i11]) << i13;
                i13 += 30;
                i11++;
            }
            iArr2[i12] = (int) j10;
            j10 >>>= 32;
            i13 -= 32;
            i10 -= 32;
            i12++;
        }
    }

    private static int divsteps30(int i10, int i11, int i12, int[] iArr) {
        int i13 = 0;
        int i14 = 0;
        int i15 = 1;
        int i16 = 1;
        for (int i17 = 0; i17 < 30; i17++) {
            int i18 = i10 >> 31;
            int i19 = -(i12 & 1);
            int i20 = i12 + (((i11 ^ i18) - i18) & i19);
            i14 += ((i15 ^ i18) - i18) & i19;
            i16 += ((i13 ^ i18) - i18) & i19;
            int i21 = i18 & i19;
            i10 = (i10 ^ i21) - (i21 + 1);
            i11 += i20 & i21;
            i12 = i20 >> 1;
            i15 = (i15 + (i14 & i21)) << 1;
            i13 = (i13 + (i21 & i16)) << 1;
        }
        iArr[0] = i15;
        iArr[1] = i13;
        iArr[2] = i14;
        iArr[3] = i16;
        return i10;
    }

    private static int divsteps30Var(int i10, int i11, int i12, int[] iArr) {
        int i13;
        int i14 = i11;
        int i15 = i12;
        int i16 = 0;
        int i17 = 0;
        int i18 = 1;
        int i19 = 1;
        int i20 = 30;
        int i21 = i10;
        while (true) {
            int numberOfTrailingZeros = Integers.numberOfTrailingZeros((-1 << i20) | i15);
            int i22 = i15 >> numberOfTrailingZeros;
            i18 <<= numberOfTrailingZeros;
            i16 <<= numberOfTrailingZeros;
            i21 -= numberOfTrailingZeros;
            i20 -= numberOfTrailingZeros;
            if (i20 <= 0) {
                iArr[0] = i18;
                iArr[1] = i16;
                iArr[2] = i17;
                iArr[3] = i19;
                return i21;
            }
            if (i21 < 0) {
                i21 = -i21;
                int i23 = -i14;
                int i24 = -i18;
                int i25 = -i16;
                int i26 = i21 + 1;
                if (i26 > i20) {
                    i26 = i20;
                }
                i13 = (-1 >>> (32 - i26)) & 63 & (i22 * i23 * ((i22 * i22) - 2));
                int i27 = i22;
                i22 = i23;
                i14 = i27;
                int i28 = i17;
                i17 = i24;
                i18 = i28;
                int i29 = i19;
                i19 = i25;
                i16 = i29;
            } else {
                int i30 = i21 + 1;
                if (i30 > i20) {
                    i30 = i20;
                }
                i13 = (-1 >>> (32 - i30)) & 15 & ((-((((i14 + 1) & 4) << 1) + i14)) * i22);
            }
            i15 = i22 + (i14 * i13);
            i17 += i18 * i13;
            i19 += i13 * i16;
        }
    }

    private static void encode30(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        int i13 = 0;
        long j10 = 0;
        while (i10 > 0) {
            if (i13 < Math.min(30, i10)) {
                j10 |= (((long) iArr[i11]) & 4294967295L) << i13;
                i13 += 32;
                i11++;
            }
            iArr2[i12] = ((int) j10) & M30;
            j10 >>>= 30;
            i13 -= 30;
            i10 -= 30;
            i12++;
        }
    }

    private static int getMaximumDivsteps(int i10) {
        return ((i10 * 49) + (i10 < 46 ? 80 : 47)) / 17;
    }

    public static int inverse32(int i10) {
        int i11 = (2 - (i10 * i10)) * i10;
        int i12 = i11 * (2 - (i10 * i11));
        int i13 = i12 * (2 - (i10 * i12));
        return i13 * (2 - (i10 * i13));
    }

    public static void invert(int[] iArr, int[] iArr2, int[] iArr3) {
        checkedModOddInverseVar(iArr, iArr2, iArr3);
    }

    public static int modOddInverse(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = iArr;
        int length = iArr4.length;
        int numberOfLeadingZeros = (length << 5) - Integers.numberOfLeadingZeros(iArr4[length - 1]);
        int i10 = (numberOfLeadingZeros + 29) / 30;
        int[] iArr5 = new int[4];
        int[] iArr6 = new int[i10];
        int[] iArr7 = new int[i10];
        int[] iArr8 = new int[i10];
        int[] iArr9 = new int[i10];
        int[] iArr10 = new int[i10];
        int i11 = 0;
        iArr7[0] = 1;
        encode30(numberOfLeadingZeros, iArr2, 0, iArr9, 0);
        encode30(numberOfLeadingZeros, iArr4, 0, iArr10, 0);
        System.arraycopy(iArr10, 0, iArr8, 0, i10);
        int inverse32 = inverse32(iArr10[0]);
        int i12 = -1;
        int i13 = 0;
        for (int maximumDivsteps = getMaximumDivsteps(numberOfLeadingZeros); i13 < maximumDivsteps; maximumDivsteps = maximumDivsteps) {
            int divsteps30 = divsteps30(i12, iArr8[i11], iArr9[i11], iArr5);
            updateDE30(i10, iArr6, iArr7, iArr5, inverse32, iArr10);
            updateFG30(i10, iArr8, iArr9, iArr5);
            i13 += 30;
            i11 = i11;
            i12 = divsteps30;
        }
        int i14 = i11;
        int i15 = iArr8[i10 - 1] >> 31;
        cnegate30(i10, i15, iArr8);
        cnormalize30(i10, i15, iArr6, iArr10);
        decode30(numberOfLeadingZeros, iArr6, i14, iArr3, i14);
        return Nat.equalTo(i10, iArr8, 1) & Nat.equalToZero(i10, iArr9);
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r9v3 */
    public static boolean modOddInverseVar(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = iArr;
        int length = iArr4.length;
        int numberOfLeadingZeros = (length << 5) - Integers.numberOfLeadingZeros(iArr4[length - 1]);
        int i10 = (numberOfLeadingZeros + 29) / 30;
        int[] iArr5 = new int[4];
        int[] iArr6 = new int[i10];
        int[] iArr7 = new int[i10];
        int[] iArr8 = new int[i10];
        int[] iArr9 = new int[i10];
        int[] iArr10 = new int[i10];
        ? r92 = 0;
        iArr7[0] = 1;
        encode30(numberOfLeadingZeros, iArr2, 0, iArr9, 0);
        encode30(numberOfLeadingZeros, iArr4, 0, iArr10, 0);
        System.arraycopy(iArr10, 0, iArr8, 0, i10);
        int i11 = i10 - 1;
        int numberOfLeadingZeros2 = -1 - (Integers.numberOfLeadingZeros(iArr9[i11] | 1) - (((i10 * 30) + 2) - numberOfLeadingZeros));
        int inverse32 = inverse32(iArr10[0]);
        int maximumDivsteps = getMaximumDivsteps(numberOfLeadingZeros);
        int i12 = i10;
        int i13 = 0;
        while (!Nat.isZero(i12, iArr9)) {
            if (i13 >= maximumDivsteps) {
                return r92;
            }
            int i14 = i13 + 30;
            int divsteps30Var = divsteps30Var(numberOfLeadingZeros2, iArr8[r92], iArr9[r92], iArr5);
            int i15 = i12;
            int i16 = maximumDivsteps;
            int[] iArr11 = iArr7;
            boolean z10 = r92;
            updateDE30(i10, iArr6, iArr7, iArr5, inverse32, iArr10);
            updateFG30(i15, iArr8, iArr9, iArr5);
            int i17 = i15 - 1;
            int i18 = iArr8[i17];
            int i19 = iArr9[i17];
            int i20 = i15 - 2;
            if (((i20 >> 31) | ((i18 >> 31) ^ i18) | ((i19 >> 31) ^ i19)) == 0) {
                iArr8[i20] = (i18 << 30) | iArr8[i20];
                iArr9[i20] = iArr9[i20] | (i19 << 30);
                i12 = i15 - 1;
            } else {
                i12 = i15;
            }
            r92 = z10;
            i13 = i14;
            numberOfLeadingZeros2 = divsteps30Var;
            maximumDivsteps = i16;
            iArr7 = iArr11;
        }
        int i21 = i12;
        boolean z11 = r92;
        int i22 = iArr8[i21 - 1] >> 31;
        int i23 = iArr6[i11] >> 31;
        if (i23 < 0) {
            i23 = add30(i10, iArr6, iArr10);
        }
        if (i22 < 0) {
            i23 = negate30(i10, iArr6);
            negate30(i21, iArr8);
        }
        if (!Nat.isOne(i21, iArr8)) {
            return z11;
        }
        if (i23 < 0) {
            add30(i10, iArr6, iArr10);
        }
        decode30(numberOfLeadingZeros, iArr6, z11 ? 1 : 0, iArr3, z11);
        return true;
    }

    private static int negate30(int i10, int[] iArr) {
        int i11 = i10 - 1;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = i12 - iArr[i13];
            iArr[i13] = M30 & i14;
            i12 = i14 >> 30;
        }
        int i15 = i12 - iArr[i11];
        iArr[i11] = i15;
        return i15 >> 30;
    }

    public static int[] random(int[] iArr) {
        int length = iArr.length;
        Random random = new Random();
        int[] create = Nat.create(length);
        int i10 = length - 1;
        int i11 = iArr[i10];
        int i12 = i11 | (i11 >>> 1);
        int i13 = i12 | (i12 >>> 2);
        int i14 = i13 | (i13 >>> 4);
        int i15 = i14 | (i14 >>> 8);
        int i16 = i15 | (i15 >>> 16);
        do {
            for (int i17 = 0; i17 != length; i17++) {
                create[i17] = random.nextInt();
            }
            create[i10] = create[i10] & i16;
        } while (Nat.gte(length, create, iArr));
        return create;
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int length = iArr.length;
        if (Nat.sub(length, iArr2, iArr3, iArr4) != 0) {
            Nat.addTo(length, iArr, iArr4);
        }
    }

    private static void updateDE30(int i10, int[] iArr, int[] iArr2, int[] iArr3, int i11, int[] iArr4) {
        int i12 = i10;
        int i13 = iArr3[0];
        int i14 = iArr3[1];
        int i15 = iArr3[2];
        int i16 = iArr3[3];
        int i17 = i12 - 1;
        int i18 = iArr[i17] >> 31;
        int i19 = iArr2[i17] >> 31;
        int i20 = (i13 & i18) + (i14 & i19);
        int i21 = (i18 & i15) + (i19 & i16);
        int i22 = iArr4[0];
        long j10 = (long) i13;
        long j11 = (long) iArr[0];
        long j12 = (long) i14;
        long j13 = (long) iArr2[0];
        long j14 = j12;
        long j15 = (j10 * j11) + (j12 * j13);
        long j16 = j10;
        long j17 = (long) i15;
        long j18 = (long) i16;
        long j19 = (j11 * j17) + (j13 * j18);
        long j20 = (long) i22;
        long j21 = (long) (i20 - (((((int) j15) * i11) + i20) & M30));
        int i23 = i17;
        long j22 = (long) (i21 - (((((int) j19) * i11) + i21) & M30));
        long j23 = (j19 + (j20 * j22)) >> 30;
        long j24 = (j15 + (j20 * j21)) >> 30;
        int i24 = 1;
        while (i24 < i12) {
            int i25 = iArr4[i24];
            long j25 = j23;
            long j26 = (long) iArr[i24];
            int i26 = i24;
            long j27 = (long) iArr2[i24];
            long j28 = j22;
            long j29 = (long) i25;
            long j30 = j24 + (j16 * j26) + (j14 * j27) + (j29 * j21);
            long j31 = j25 + (j26 * j17) + (j27 * j18) + (j29 * j28);
            int i27 = i26 - 1;
            iArr[i27] = ((int) j30) & M30;
            j24 = j30 >> 30;
            iArr2[i27] = ((int) j31) & M30;
            j23 = j31 >> 30;
            i24 = i26 + 1;
            i12 = i10;
            i23 = i23;
            j22 = j28;
        }
        int i28 = i23;
        long j32 = j23;
        iArr[i28] = (int) j24;
        iArr2[i28] = (int) j23;
    }

    private static void updateFG30(int i10, int[] iArr, int[] iArr2, int[] iArr3) {
        int i11 = i10;
        int i12 = iArr3[0];
        int i13 = 1;
        int i14 = iArr3[1];
        int i15 = iArr3[2];
        int i16 = iArr3[3];
        long j10 = (long) i12;
        long j11 = (long) iArr[0];
        long j12 = (long) i14;
        long j13 = (long) iArr2[0];
        long j14 = (long) i15;
        long j15 = (long) i16;
        long j16 = ((j10 * j11) + (j12 * j13)) >> 30;
        long j17 = ((j11 * j14) + (j13 * j15)) >> 30;
        int i17 = 1;
        while (i17 < i11) {
            int i18 = iArr[i17];
            int i19 = iArr2[i17];
            int i20 = i17;
            long j18 = (long) i18;
            long j19 = j10 * j18;
            long j20 = j10;
            long j21 = (long) i19;
            long j22 = j16 + j19 + (j12 * j21);
            long j23 = j17 + (j18 * j14) + (j21 * j15);
            int i21 = i20 - 1;
            iArr[i21] = ((int) j22) & M30;
            j16 = j22 >> 30;
            iArr2[i21] = M30 & ((int) j23);
            j17 = j23 >> 30;
            i17 = i20 + 1;
            j10 = j20;
            i13 = 1;
        }
        int i22 = i11 - i13;
        iArr[i22] = (int) j16;
        iArr2[i22] = (int) j17;
    }
}
