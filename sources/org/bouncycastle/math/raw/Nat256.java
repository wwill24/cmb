package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

public abstract class Nat256 {
    private static final long M = 4294967295L;

    public static int add(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        long j10 = (((long) iArr[i10 + 0]) & 4294967295L) + (((long) iArr2[i11 + 0]) & 4294967295L) + 0;
        iArr3[i12 + 0] = (int) j10;
        long j11 = (j10 >>> 32) + (((long) iArr[i10 + 1]) & 4294967295L) + (((long) iArr2[i11 + 1]) & 4294967295L);
        iArr3[i12 + 1] = (int) j11;
        long j12 = (j11 >>> 32) + (((long) iArr[i10 + 2]) & 4294967295L) + (((long) iArr2[i11 + 2]) & 4294967295L);
        iArr3[i12 + 2] = (int) j12;
        long j13 = (j12 >>> 32) + (((long) iArr[i10 + 3]) & 4294967295L) + (((long) iArr2[i11 + 3]) & 4294967295L);
        iArr3[i12 + 3] = (int) j13;
        long j14 = (j13 >>> 32) + (((long) iArr[i10 + 4]) & 4294967295L) + (((long) iArr2[i11 + 4]) & 4294967295L);
        iArr3[i12 + 4] = (int) j14;
        long j15 = (j14 >>> 32) + (((long) iArr[i10 + 5]) & 4294967295L) + (((long) iArr2[i11 + 5]) & 4294967295L);
        iArr3[i12 + 5] = (int) j15;
        long j16 = (j15 >>> 32) + (((long) iArr[i10 + 6]) & 4294967295L) + (((long) iArr2[i11 + 6]) & 4294967295L);
        iArr3[i12 + 6] = (int) j16;
        long j17 = (j16 >>> 32) + (((long) iArr[i10 + 7]) & 4294967295L) + (((long) iArr2[i11 + 7]) & 4294967295L);
        iArr3[i12 + 7] = (int) j17;
        return (int) (j17 >>> 32);
    }

    public static int add(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + 0;
        iArr3[0] = (int) j10;
        long j11 = (j10 >>> 32) + (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L);
        iArr3[1] = (int) j11;
        long j12 = (j11 >>> 32) + (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L);
        iArr3[2] = (int) j12;
        long j13 = (j12 >>> 32) + (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L);
        iArr3[3] = (int) j13;
        long j14 = (j13 >>> 32) + (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L);
        iArr3[4] = (int) j14;
        long j15 = (j14 >>> 32) + (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L);
        iArr3[5] = (int) j15;
        long j16 = (j15 >>> 32) + (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L);
        iArr3[6] = (int) j16;
        long j17 = (j16 >>> 32) + (((long) iArr[7]) & 4294967295L) + (((long) iArr2[7]) & 4294967295L);
        iArr3[7] = (int) j17;
        return (int) (j17 >>> 32);
    }

    public static int addBothTo(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        int i13 = i12 + 0;
        long j10 = (((long) iArr[i10 + 0]) & 4294967295L) + (((long) iArr2[i11 + 0]) & 4294967295L) + (((long) iArr3[i13]) & 4294967295L) + 0;
        iArr3[i13] = (int) j10;
        int i14 = i12 + 1;
        long j11 = (j10 >>> 32) + (((long) iArr[i10 + 1]) & 4294967295L) + (((long) iArr2[i11 + 1]) & 4294967295L) + (((long) iArr3[i14]) & 4294967295L);
        iArr3[i14] = (int) j11;
        int i15 = i12 + 2;
        long j12 = (j11 >>> 32) + (((long) iArr[i10 + 2]) & 4294967295L) + (((long) iArr2[i11 + 2]) & 4294967295L) + (((long) iArr3[i15]) & 4294967295L);
        iArr3[i15] = (int) j12;
        int i16 = i12 + 3;
        long j13 = (j12 >>> 32) + (((long) iArr[i10 + 3]) & 4294967295L) + (((long) iArr2[i11 + 3]) & 4294967295L) + (((long) iArr3[i16]) & 4294967295L);
        iArr3[i16] = (int) j13;
        int i17 = i12 + 4;
        long j14 = (j13 >>> 32) + (((long) iArr[i10 + 4]) & 4294967295L) + (((long) iArr2[i11 + 4]) & 4294967295L) + (((long) iArr3[i17]) & 4294967295L);
        iArr3[i17] = (int) j14;
        int i18 = i12 + 5;
        long j15 = (j14 >>> 32) + (((long) iArr[i10 + 5]) & 4294967295L) + (((long) iArr2[i11 + 5]) & 4294967295L) + (((long) iArr3[i18]) & 4294967295L);
        iArr3[i18] = (int) j15;
        int i19 = i12 + 6;
        long j16 = (j15 >>> 32) + (((long) iArr[i10 + 6]) & 4294967295L) + (((long) iArr2[i11 + 6]) & 4294967295L) + (((long) iArr3[i19]) & 4294967295L);
        iArr3[i19] = (int) j16;
        int i20 = i12 + 7;
        long j17 = (j16 >>> 32) + (((long) iArr[i10 + 7]) & 4294967295L) + (((long) iArr2[i11 + 7]) & 4294967295L) + (((long) iArr3[i20]) & 4294967295L);
        iArr3[i20] = (int) j17;
        return (int) (j17 >>> 32);
    }

    public static int addBothTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + (((long) iArr3[0]) & 4294967295L) + 0;
        iArr3[0] = (int) j10;
        long j11 = (j10 >>> 32) + (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L) + (((long) iArr3[1]) & 4294967295L);
        iArr3[1] = (int) j11;
        long j12 = (j11 >>> 32) + (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L) + (((long) iArr3[2]) & 4294967295L);
        iArr3[2] = (int) j12;
        long j13 = (j12 >>> 32) + (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L) + (((long) iArr3[3]) & 4294967295L);
        iArr3[3] = (int) j13;
        long j14 = (j13 >>> 32) + (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L) + (((long) iArr3[4]) & 4294967295L);
        iArr3[4] = (int) j14;
        long j15 = (j14 >>> 32) + (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L) + (((long) iArr3[5]) & 4294967295L);
        iArr3[5] = (int) j15;
        long j16 = (j15 >>> 32) + (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L) + (((long) iArr3[6]) & 4294967295L);
        iArr3[6] = (int) j16;
        long j17 = (j16 >>> 32) + (((long) iArr[7]) & 4294967295L) + (((long) iArr2[7]) & 4294967295L) + (((long) iArr3[7]) & 4294967295L);
        iArr3[7] = (int) j17;
        return (int) (j17 >>> 32);
    }

    public static int addTo(int[] iArr, int i10, int[] iArr2, int i11, int i12) {
        int i13 = i11 + 0;
        long j10 = (((long) i12) & 4294967295L) + (((long) iArr[i10 + 0]) & 4294967295L) + (((long) iArr2[i13]) & 4294967295L);
        iArr2[i13] = (int) j10;
        int i14 = i11 + 1;
        long j11 = (j10 >>> 32) + (((long) iArr[i10 + 1]) & 4294967295L) + (((long) iArr2[i14]) & 4294967295L);
        iArr2[i14] = (int) j11;
        int i15 = i11 + 2;
        long j12 = (j11 >>> 32) + (((long) iArr[i10 + 2]) & 4294967295L) + (((long) iArr2[i15]) & 4294967295L);
        iArr2[i15] = (int) j12;
        int i16 = i11 + 3;
        long j13 = (j12 >>> 32) + (((long) iArr[i10 + 3]) & 4294967295L) + (((long) iArr2[i16]) & 4294967295L);
        iArr2[i16] = (int) j13;
        int i17 = i11 + 4;
        long j14 = (j13 >>> 32) + (((long) iArr[i10 + 4]) & 4294967295L) + (((long) iArr2[i17]) & 4294967295L);
        iArr2[i17] = (int) j14;
        int i18 = i11 + 5;
        long j15 = (j14 >>> 32) + (((long) iArr[i10 + 5]) & 4294967295L) + (((long) iArr2[i18]) & 4294967295L);
        iArr2[i18] = (int) j15;
        int i19 = i11 + 6;
        long j16 = (j15 >>> 32) + (((long) iArr[i10 + 6]) & 4294967295L) + (((long) iArr2[i19]) & 4294967295L);
        iArr2[i19] = (int) j16;
        int i20 = i11 + 7;
        long j17 = (j16 >>> 32) + (((long) iArr[i10 + 7]) & 4294967295L) + (4294967295L & ((long) iArr2[i20]));
        iArr2[i20] = (int) j17;
        return (int) (j17 >>> 32);
    }

    public static int addTo(int[] iArr, int[] iArr2) {
        long j10 = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + 0;
        iArr2[0] = (int) j10;
        long j11 = (j10 >>> 32) + (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L);
        iArr2[1] = (int) j11;
        long j12 = (j11 >>> 32) + (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L);
        iArr2[2] = (int) j12;
        long j13 = (j12 >>> 32) + (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L);
        iArr2[3] = (int) j13;
        long j14 = (j13 >>> 32) + (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L);
        iArr2[4] = (int) j14;
        long j15 = (j14 >>> 32) + (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L);
        iArr2[5] = (int) j15;
        long j16 = (j15 >>> 32) + (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L);
        iArr2[6] = (int) j16;
        long j17 = (j16 >>> 32) + (((long) iArr[7]) & 4294967295L) + (4294967295L & ((long) iArr2[7]));
        iArr2[7] = (int) j17;
        return (int) (j17 >>> 32);
    }

    public static int addToEachOther(int[] iArr, int i10, int[] iArr2, int i11) {
        int i12 = i10 + 0;
        int i13 = i11 + 0;
        long j10 = (((long) iArr[i12]) & 4294967295L) + (((long) iArr2[i13]) & 4294967295L) + 0;
        int i14 = (int) j10;
        iArr[i12] = i14;
        iArr2[i13] = i14;
        int i15 = i10 + 1;
        int i16 = i11 + 1;
        long j11 = (j10 >>> 32) + (((long) iArr[i15]) & 4294967295L) + (((long) iArr2[i16]) & 4294967295L);
        int i17 = (int) j11;
        iArr[i15] = i17;
        iArr2[i16] = i17;
        int i18 = i10 + 2;
        int i19 = i11 + 2;
        long j12 = (j11 >>> 32) + (((long) iArr[i18]) & 4294967295L) + (((long) iArr2[i19]) & 4294967295L);
        int i20 = (int) j12;
        iArr[i18] = i20;
        iArr2[i19] = i20;
        int i21 = i10 + 3;
        int i22 = i11 + 3;
        long j13 = (j12 >>> 32) + (((long) iArr[i21]) & 4294967295L) + (((long) iArr2[i22]) & 4294967295L);
        int i23 = (int) j13;
        iArr[i21] = i23;
        iArr2[i22] = i23;
        int i24 = i10 + 4;
        int i25 = i11 + 4;
        long j14 = (j13 >>> 32) + (((long) iArr[i24]) & 4294967295L) + (((long) iArr2[i25]) & 4294967295L);
        int i26 = (int) j14;
        iArr[i24] = i26;
        iArr2[i25] = i26;
        int i27 = i10 + 5;
        int i28 = i11 + 5;
        long j15 = (j14 >>> 32) + (((long) iArr[i27]) & 4294967295L) + (((long) iArr2[i28]) & 4294967295L);
        int i29 = (int) j15;
        iArr[i27] = i29;
        iArr2[i28] = i29;
        int i30 = i10 + 6;
        int i31 = i11 + 6;
        long j16 = (j15 >>> 32) + (((long) iArr[i30]) & 4294967295L) + (((long) iArr2[i31]) & 4294967295L);
        int i32 = (int) j16;
        iArr[i30] = i32;
        iArr2[i31] = i32;
        int i33 = i10 + 7;
        int i34 = i11 + 7;
        long j17 = (j16 >>> 32) + (((long) iArr[i33]) & 4294967295L) + (4294967295L & ((long) iArr2[i34]));
        int i35 = (int) j17;
        iArr[i33] = i35;
        iArr2[i34] = i35;
        return (int) (j17 >>> 32);
    }

    public static void copy(int[] iArr, int i10, int[] iArr2, int i11) {
        iArr2[i11 + 0] = iArr[i10 + 0];
        iArr2[i11 + 1] = iArr[i10 + 1];
        iArr2[i11 + 2] = iArr[i10 + 2];
        iArr2[i11 + 3] = iArr[i10 + 3];
        iArr2[i11 + 4] = iArr[i10 + 4];
        iArr2[i11 + 5] = iArr[i10 + 5];
        iArr2[i11 + 6] = iArr[i10 + 6];
        iArr2[i11 + 7] = iArr[i10 + 7];
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
        iArr2[5] = iArr[5];
        iArr2[6] = iArr[6];
        iArr2[7] = iArr[7];
    }

    public static void copy64(long[] jArr, int i10, long[] jArr2, int i11) {
        jArr2[i11 + 0] = jArr[i10 + 0];
        jArr2[i11 + 1] = jArr[i10 + 1];
        jArr2[i11 + 2] = jArr[i10 + 2];
        jArr2[i11 + 3] = jArr[i10 + 3];
    }

    public static void copy64(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
    }

    public static int[] create() {
        return new int[8];
    }

    public static long[] create64() {
        return new long[4];
    }

    public static int[] createExt() {
        return new int[16];
    }

    public static long[] createExt64() {
        return new long[8];
    }

    public static boolean diff(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        boolean gte = gte(iArr, i10, iArr2, i11);
        if (gte) {
            sub(iArr, i10, iArr2, i11, iArr3, i12);
        } else {
            sub(iArr2, i11, iArr, i10, iArr3, i12);
        }
        return gte;
    }

    public static boolean eq(int[] iArr, int[] iArr2) {
        for (int i10 = 7; i10 >= 0; i10--) {
            if (iArr[i10] != iArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static boolean eq64(long[] jArr, long[] jArr2) {
        for (int i10 = 3; i10 >= 0; i10--) {
            if (jArr[i10] != jArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 256) {
            throw new IllegalArgumentException();
        }
        int[] create = create();
        for (int i10 = 0; i10 < 8; i10++) {
            create[i10] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return create;
    }

    public static long[] fromBigInteger64(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 256) {
            throw new IllegalArgumentException();
        }
        long[] create64 = create64();
        for (int i10 = 0; i10 < 4; i10++) {
            create64[i10] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
        }
        return create64;
    }

    public static int getBit(int[] iArr, int i10) {
        int i11;
        if (i10 == 0) {
            i11 = iArr[0];
        } else if ((i10 & 255) != i10) {
            return 0;
        } else {
            i11 = iArr[i10 >>> 5] >>> (i10 & 31);
        }
        return i11 & 1;
    }

    public static boolean gte(int[] iArr, int i10, int[] iArr2, int i11) {
        for (int i12 = 7; i12 >= 0; i12--) {
            int i13 = iArr[i10 + i12] ^ Integer.MIN_VALUE;
            int i14 = Integer.MIN_VALUE ^ iArr2[i11 + i12];
            if (i13 < i14) {
                return false;
            }
            if (i13 > i14) {
                return true;
            }
        }
        return true;
    }

    public static boolean gte(int[] iArr, int[] iArr2) {
        for (int i10 = 7; i10 >= 0; i10--) {
            int i11 = iArr[i10] ^ Integer.MIN_VALUE;
            int i12 = Integer.MIN_VALUE ^ iArr2[i10];
            if (i11 < i12) {
                return false;
            }
            if (i11 > i12) {
                return true;
            }
        }
        return true;
    }

    public static boolean isOne(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i10 = 1; i10 < 8; i10++) {
            if (iArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOne64(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i10 = 1; i10 < 4; i10++) {
            if (jArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] iArr) {
        for (int i10 = 0; i10 < 8; i10++) {
            if (iArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero64(long[] jArr) {
        for (int i10 = 0; i10 < 4; i10++) {
            if (jArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void mul(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        long j10 = ((long) iArr2[i11 + 0]) & 4294967295L;
        long j11 = ((long) iArr2[i11 + 1]) & 4294967295L;
        long j12 = ((long) iArr2[i11 + 2]) & 4294967295L;
        long j13 = ((long) iArr2[i11 + 3]) & 4294967295L;
        long j14 = ((long) iArr2[i11 + 4]) & 4294967295L;
        long j15 = ((long) iArr2[i11 + 5]) & 4294967295L;
        long j16 = ((long) iArr2[i11 + 6]) & 4294967295L;
        long j17 = ((long) iArr2[i11 + 7]) & 4294967295L;
        long j18 = ((long) iArr[i10 + 0]) & 4294967295L;
        long j19 = (j18 * j10) + 0;
        long j20 = j10;
        iArr3[i12 + 0] = (int) j19;
        long j21 = (j19 >>> 32) + (j18 * j11);
        long j22 = j11;
        iArr3[i12 + 1] = (int) j21;
        long j23 = (j21 >>> 32) + (j18 * j12);
        iArr3[i12 + 2] = (int) j23;
        long j24 = (j23 >>> 32) + (j18 * j13);
        iArr3[i12 + 3] = (int) j24;
        long j25 = (j24 >>> 32) + (j18 * j14);
        iArr3[i12 + 4] = (int) j25;
        long j26 = (j25 >>> 32) + (j18 * j15);
        iArr3[i12 + 5] = (int) j26;
        long j27 = (j26 >>> 32) + (j18 * j16);
        iArr3[i12 + 6] = (int) j27;
        long j28 = j17;
        long j29 = (j27 >>> 32) + (j18 * j28);
        iArr3[i12 + 7] = (int) j29;
        iArr3[i12 + 8] = (int) (j29 >>> 32);
        int i13 = 1;
        int i14 = i12;
        int i15 = 1;
        while (i15 < 8) {
            i14 += i13;
            long j30 = ((long) iArr[i10 + i15]) & 4294967295L;
            int i16 = i14 + 0;
            long j31 = (j30 * j20) + (((long) iArr3[i16]) & 4294967295L) + 0;
            iArr3[i16] = (int) j31;
            int i17 = i14 + 1;
            long j32 = j28;
            long j33 = (j31 >>> 32) + (j30 * j22) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j33;
            int i18 = i14 + 2;
            long j34 = j12;
            long j35 = (j33 >>> 32) + (j30 * j12) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j35;
            int i19 = i14 + 3;
            long j36 = (j35 >>> 32) + (j30 * j13) + (((long) iArr3[i19]) & 4294967295L);
            iArr3[i19] = (int) j36;
            int i20 = i14 + 4;
            long j37 = (j36 >>> 32) + (j30 * j14) + (((long) iArr3[i20]) & 4294967295L);
            iArr3[i20] = (int) j37;
            int i21 = i14 + 5;
            long j38 = (j37 >>> 32) + (j30 * j15) + (((long) iArr3[i21]) & 4294967295L);
            iArr3[i21] = (int) j38;
            int i22 = i14 + 6;
            long j39 = (j38 >>> 32) + (j30 * j16) + (((long) iArr3[i22]) & 4294967295L);
            iArr3[i22] = (int) j39;
            int i23 = i14 + 7;
            long j40 = (j39 >>> 32) + (j30 * j32) + (((long) iArr3[i23]) & 4294967295L);
            iArr3[i23] = (int) j40;
            iArr3[i14 + 8] = (int) (j40 >>> 32);
            i15++;
            j12 = j34;
            j28 = j32;
            j13 = j13;
            i13 = 1;
        }
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = ((long) iArr2[0]) & 4294967295L;
        long j11 = ((long) iArr2[1]) & 4294967295L;
        long j12 = ((long) iArr2[3]) & 4294967295L;
        long j13 = ((long) iArr2[4]) & 4294967295L;
        long j14 = ((long) iArr2[2]) & 4294967295L;
        long j15 = ((long) iArr2[5]) & 4294967295L;
        long j16 = ((long) iArr2[6]) & 4294967295L;
        long j17 = ((long) iArr2[7]) & 4294967295L;
        long j18 = ((long) iArr[0]) & 4294967295L;
        long j19 = (j18 * j10) + 0;
        iArr3[0] = (int) j19;
        long j20 = (j19 >>> 32) + (j18 * j11);
        iArr3[1] = (int) j20;
        long j21 = (j20 >>> 32) + (j18 * j14);
        iArr3[2] = (int) j21;
        long j22 = (j21 >>> 32) + (j18 * j12);
        iArr3[3] = (int) j22;
        long j23 = (j22 >>> 32) + (j18 * j13);
        iArr3[4] = (int) j23;
        long j24 = (j23 >>> 32) + (j18 * j15);
        iArr3[5] = (int) j24;
        long j25 = (j24 >>> 32) + (j18 * j16);
        iArr3[6] = (int) j25;
        long j26 = (j25 >>> 32) + (j18 * j17);
        iArr3[7] = (int) j26;
        iArr3[8] = (int) (j26 >>> 32);
        int i10 = 1;
        for (int i11 = 8; i10 < i11; i11 = 8) {
            long j27 = ((long) iArr[i10]) & 4294967295L;
            int i12 = i10 + 0;
            long j28 = (j27 * j10) + (((long) iArr3[i12]) & 4294967295L) + 0;
            iArr3[i12] = (int) j28;
            int i13 = i10 + 1;
            long j29 = j11;
            long j30 = (j28 >>> 32) + (j27 * j11) + (((long) iArr3[i13]) & 4294967295L);
            iArr3[i13] = (int) j30;
            int i14 = i10 + 2;
            long j31 = j15;
            long j32 = (j30 >>> 32) + (j27 * j14) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j32;
            int i15 = i10 + 3;
            long j33 = (j32 >>> 32) + (j27 * j12) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j33;
            int i16 = i10 + 4;
            long j34 = (j33 >>> 32) + (j27 * j13) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) j34;
            int i17 = i10 + 5;
            long j35 = (j34 >>> 32) + (j27 * j31) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j35;
            int i18 = i10 + 6;
            long j36 = (j35 >>> 32) + (j27 * j16) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j36;
            int i19 = i10 + 7;
            long j37 = (j36 >>> 32) + (j27 * j17) + (((long) iArr3[i19]) & 4294967295L);
            iArr3[i19] = (int) j37;
            iArr3[i10 + 8] = (int) (j37 >>> 32);
            i10 = i13;
            j10 = j10;
            j11 = j29;
            j15 = j31;
        }
    }

    public static long mul33Add(int i10, int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
        long j10 = ((long) i10) & 4294967295L;
        long j11 = ((long) iArr[i11 + 0]) & 4294967295L;
        long j12 = (j10 * j11) + (((long) iArr2[i12 + 0]) & 4294967295L) + 0;
        iArr3[i13 + 0] = (int) j12;
        long j13 = ((long) iArr[i11 + 1]) & 4294967295L;
        long j14 = (j12 >>> 32) + (j10 * j13) + j11 + (((long) iArr2[i12 + 1]) & 4294967295L);
        iArr3[i13 + 1] = (int) j14;
        long j15 = j14 >>> 32;
        long j16 = ((long) iArr[i11 + 2]) & 4294967295L;
        long j17 = j15 + (j10 * j16) + j13 + (((long) iArr2[i12 + 2]) & 4294967295L);
        iArr3[i13 + 2] = (int) j17;
        long j18 = ((long) iArr[i11 + 3]) & 4294967295L;
        long j19 = (j17 >>> 32) + (j10 * j18) + j16 + (((long) iArr2[i12 + 3]) & 4294967295L);
        iArr3[i13 + 3] = (int) j19;
        long j20 = ((long) iArr[i11 + 4]) & 4294967295L;
        long j21 = (j19 >>> 32) + (j10 * j20) + j18 + (((long) iArr2[i12 + 4]) & 4294967295L);
        iArr3[i13 + 4] = (int) j21;
        long j22 = ((long) iArr[i11 + 5]) & 4294967295L;
        long j23 = (j21 >>> 32) + (j10 * j22) + j20 + (((long) iArr2[i12 + 5]) & 4294967295L);
        iArr3[i13 + 5] = (int) j23;
        long j24 = ((long) iArr[i11 + 6]) & 4294967295L;
        long j25 = (j23 >>> 32) + (j10 * j24) + j22 + (((long) iArr2[i12 + 6]) & 4294967295L);
        iArr3[i13 + 6] = (int) j25;
        long j26 = ((long) iArr[i11 + 7]) & 4294967295L;
        long j27 = (j25 >>> 32) + (j10 * j26) + j24 + (4294967295L & ((long) iArr2[i12 + 7]));
        iArr3[i13 + 7] = (int) j27;
        return (j27 >>> 32) + j26;
    }

    public static int mul33DWordAdd(int i10, long j10, int[] iArr, int i11) {
        int[] iArr2 = iArr;
        int i12 = i11;
        long j11 = ((long) i10) & 4294967295L;
        long j12 = j10 & 4294967295L;
        int i13 = i12 + 0;
        long j13 = (j11 * j12) + (((long) iArr2[i13]) & 4294967295L) + 0;
        iArr2[i13] = (int) j13;
        long j14 = j10 >>> 32;
        long j15 = (j11 * j14) + j12;
        int i14 = i12 + 1;
        long j16 = (j13 >>> 32) + j15 + (((long) iArr2[i14]) & 4294967295L);
        iArr2[i14] = (int) j16;
        int i15 = i12 + 2;
        long j17 = (j16 >>> 32) + j14 + (((long) iArr2[i15]) & 4294967295L);
        iArr2[i15] = (int) j17;
        int i16 = i12 + 3;
        long j18 = (j17 >>> 32) + (4294967295L & ((long) iArr2[i16]));
        iArr2[i16] = (int) j18;
        if ((j18 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(8, iArr2, i12, 4);
    }

    public static int mul33WordAdd(int i10, int i11, int[] iArr, int i12) {
        long j10 = ((long) i11) & 4294967295L;
        int i13 = i12 + 0;
        long j11 = ((((long) i10) & 4294967295L) * j10) + (((long) iArr[i13]) & 4294967295L) + 0;
        iArr[i13] = (int) j11;
        int i14 = i12 + 1;
        long j12 = (j11 >>> 32) + j10 + (((long) iArr[i14]) & 4294967295L);
        iArr[i14] = (int) j12;
        long j13 = j12 >>> 32;
        int i15 = i12 + 2;
        long j14 = j13 + (((long) iArr[i15]) & 4294967295L);
        iArr[i15] = (int) j14;
        if ((j14 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(8, iArr, i12, 3);
    }

    public static int mulAddTo(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        long j10 = ((long) iArr2[i11 + 0]) & 4294967295L;
        long j11 = ((long) iArr2[i11 + 1]) & 4294967295L;
        long j12 = ((long) iArr2[i11 + 2]) & 4294967295L;
        long j13 = ((long) iArr2[i11 + 3]) & 4294967295L;
        long j14 = ((long) iArr2[i11 + 4]) & 4294967295L;
        long j15 = ((long) iArr2[i11 + 5]) & 4294967295L;
        long j16 = ((long) iArr2[i11 + 6]) & 4294967295L;
        long j17 = ((long) iArr2[i11 + 7]) & 4294967295L;
        int i13 = 0;
        long j18 = 0;
        int i14 = i12;
        while (i13 < 8) {
            int i15 = i13;
            long j19 = ((long) iArr[i10 + i13]) & 4294967295L;
            int i16 = i14 + 0;
            long j20 = j10;
            long j21 = (j19 * j10) + (((long) iArr3[i16]) & 4294967295L) + 0;
            long j22 = j17;
            iArr3[i16] = (int) j21;
            int i17 = i14 + 1;
            long j23 = (j21 >>> 32) + (j19 * j11) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j23;
            int i18 = i14 + 2;
            long j24 = (j23 >>> 32) + (j19 * j12) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j24;
            int i19 = i14 + 3;
            long j25 = (j24 >>> 32) + (j19 * j13) + (((long) iArr3[i19]) & 4294967295L);
            iArr3[i19] = (int) j25;
            int i20 = i14 + 4;
            long j26 = (j25 >>> 32) + (j19 * j14) + (((long) iArr3[i20]) & 4294967295L);
            iArr3[i20] = (int) j26;
            int i21 = i14 + 5;
            long j27 = (j26 >>> 32) + (j19 * j15) + (((long) iArr3[i21]) & 4294967295L);
            iArr3[i21] = (int) j27;
            int i22 = i14 + 6;
            long j28 = (j27 >>> 32) + (j19 * j16) + (((long) iArr3[i22]) & 4294967295L);
            iArr3[i22] = (int) j28;
            int i23 = i14 + 7;
            long j29 = (j28 >>> 32) + (j19 * j22) + (((long) iArr3[i23]) & 4294967295L);
            iArr3[i23] = (int) j29;
            int i24 = i14 + 8;
            long j30 = (j29 >>> 32) + (((long) iArr3[i24]) & 4294967295L) + j18;
            iArr3[i24] = (int) j30;
            j18 = j30 >>> 32;
            i13 = i15 + 1;
            i14 = i17;
            j17 = j22;
            j10 = j20;
            j11 = j11;
        }
        return (int) j18;
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = ((long) iArr2[1]) & 4294967295L;
        long j11 = ((long) iArr2[2]) & 4294967295L;
        long j12 = ((long) iArr2[3]) & 4294967295L;
        long j13 = ((long) iArr2[4]) & 4294967295L;
        long j14 = ((long) iArr2[5]) & 4294967295L;
        long j15 = ((long) iArr2[0]) & 4294967295L;
        long j16 = ((long) iArr2[6]) & 4294967295L;
        long j17 = ((long) iArr2[7]) & 4294967295L;
        long j18 = 0;
        int i10 = 0;
        while (i10 < 8) {
            long j19 = j17;
            long j20 = ((long) iArr[i10]) & 4294967295L;
            int i11 = i10 + 0;
            long j21 = j14;
            long j22 = (j20 * j15) + (((long) iArr3[i11]) & 4294967295L) + 0;
            iArr3[i11] = (int) j22;
            int i12 = i10 + 1;
            long j23 = j10;
            long j24 = (j22 >>> 32) + (j20 * j10) + (((long) iArr3[i12]) & 4294967295L);
            iArr3[i12] = (int) j24;
            int i13 = i10 + 2;
            long j25 = (j24 >>> 32) + (j20 * j11) + (((long) iArr3[i13]) & 4294967295L);
            iArr3[i13] = (int) j25;
            int i14 = i10 + 3;
            long j26 = (j25 >>> 32) + (j20 * j12) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j26;
            int i15 = i10 + 4;
            long j27 = (j26 >>> 32) + (j20 * j13) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j27;
            int i16 = i10 + 5;
            long j28 = (j27 >>> 32) + (j20 * j21) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) j28;
            int i17 = i10 + 6;
            long j29 = (j28 >>> 32) + (j20 * j16) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j29;
            int i18 = i10 + 7;
            long j30 = (j29 >>> 32) + (j20 * j19) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j30;
            int i19 = i10 + 8;
            long j31 = (j30 >>> 32) + (((long) iArr3[i19]) & 4294967295L) + j18;
            iArr3[i19] = (int) j31;
            j18 = j31 >>> 32;
            i10 = i12;
            j17 = j19;
            j14 = j21;
            j10 = j23;
        }
        return (int) j18;
    }

    public static int mulByWord(int i10, int[] iArr) {
        long j10 = ((long) i10) & 4294967295L;
        long j11 = ((((long) iArr[0]) & 4294967295L) * j10) + 0;
        iArr[0] = (int) j11;
        long j12 = (j11 >>> 32) + ((((long) iArr[1]) & 4294967295L) * j10);
        iArr[1] = (int) j12;
        long j13 = (j12 >>> 32) + ((((long) iArr[2]) & 4294967295L) * j10);
        iArr[2] = (int) j13;
        long j14 = (j13 >>> 32) + ((((long) iArr[3]) & 4294967295L) * j10);
        iArr[3] = (int) j14;
        long j15 = (j14 >>> 32) + ((((long) iArr[4]) & 4294967295L) * j10);
        iArr[4] = (int) j15;
        long j16 = (j15 >>> 32) + ((((long) iArr[5]) & 4294967295L) * j10);
        iArr[5] = (int) j16;
        long j17 = (j16 >>> 32) + ((((long) iArr[6]) & 4294967295L) * j10);
        iArr[6] = (int) j17;
        long j18 = (j17 >>> 32) + (j10 * (4294967295L & ((long) iArr[7])));
        iArr[7] = (int) j18;
        return (int) (j18 >>> 32);
    }

    public static int mulByWordAddTo(int i10, int[] iArr, int[] iArr2) {
        long j10 = ((long) i10) & 4294967295L;
        long j11 = ((((long) iArr2[0]) & 4294967295L) * j10) + (((long) iArr[0]) & 4294967295L) + 0;
        iArr2[0] = (int) j11;
        long j12 = (j11 >>> 32) + ((((long) iArr2[1]) & 4294967295L) * j10) + (((long) iArr[1]) & 4294967295L);
        iArr2[1] = (int) j12;
        long j13 = (j12 >>> 32) + ((((long) iArr2[2]) & 4294967295L) * j10) + (((long) iArr[2]) & 4294967295L);
        iArr2[2] = (int) j13;
        long j14 = (j13 >>> 32) + ((((long) iArr2[3]) & 4294967295L) * j10) + (((long) iArr[3]) & 4294967295L);
        iArr2[3] = (int) j14;
        long j15 = (j14 >>> 32) + ((((long) iArr2[4]) & 4294967295L) * j10) + (((long) iArr[4]) & 4294967295L);
        iArr2[4] = (int) j15;
        long j16 = (j15 >>> 32) + ((((long) iArr2[5]) & 4294967295L) * j10) + (((long) iArr[5]) & 4294967295L);
        iArr2[5] = (int) j16;
        long j17 = (j16 >>> 32) + ((((long) iArr2[6]) & 4294967295L) * j10) + (((long) iArr[6]) & 4294967295L);
        iArr2[6] = (int) j17;
        long j18 = (j17 >>> 32) + (j10 * (((long) iArr2[7]) & 4294967295L)) + (4294967295L & ((long) iArr[7]));
        iArr2[7] = (int) j18;
        return (int) (j18 >>> 32);
    }

    public static int mulWord(int i10, int[] iArr, int[] iArr2, int i11) {
        long j10 = ((long) i10) & 4294967295L;
        long j11 = 0;
        int i12 = 0;
        do {
            long j12 = j11 + ((((long) iArr[i12]) & 4294967295L) * j10);
            iArr2[i11 + i12] = (int) j12;
            j11 = j12 >>> 32;
            i12++;
        } while (i12 < 8);
        return (int) j11;
    }

    public static int mulWordAddTo(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        long j10 = ((long) i10) & 4294967295L;
        int i13 = i12 + 0;
        long j11 = ((((long) iArr[i11 + 0]) & 4294967295L) * j10) + (((long) iArr2[i13]) & 4294967295L) + 0;
        iArr2[i13] = (int) j11;
        int i14 = i12 + 1;
        long j12 = (j11 >>> 32) + ((((long) iArr[i11 + 1]) & 4294967295L) * j10) + (((long) iArr2[i14]) & 4294967295L);
        iArr2[i14] = (int) j12;
        int i15 = i12 + 2;
        long j13 = (j12 >>> 32) + ((((long) iArr[i11 + 2]) & 4294967295L) * j10) + (((long) iArr2[i15]) & 4294967295L);
        iArr2[i15] = (int) j13;
        int i16 = i12 + 3;
        long j14 = (j13 >>> 32) + ((((long) iArr[i11 + 3]) & 4294967295L) * j10) + (((long) iArr2[i16]) & 4294967295L);
        iArr2[i16] = (int) j14;
        int i17 = i12 + 4;
        long j15 = (j14 >>> 32) + ((((long) iArr[i11 + 4]) & 4294967295L) * j10) + (((long) iArr2[i17]) & 4294967295L);
        iArr2[i17] = (int) j15;
        int i18 = i12 + 5;
        long j16 = (j15 >>> 32) + ((((long) iArr[i11 + 5]) & 4294967295L) * j10) + (((long) iArr2[i18]) & 4294967295L);
        iArr2[i18] = (int) j16;
        int i19 = i12 + 6;
        long j17 = (j16 >>> 32) + ((((long) iArr[i11 + 6]) & 4294967295L) * j10) + (((long) iArr2[i19]) & 4294967295L);
        iArr2[i19] = (int) j17;
        int i20 = i12 + 7;
        long j18 = (j17 >>> 32) + (j10 * (((long) iArr[i11 + 7]) & 4294967295L)) + (((long) iArr2[i20]) & 4294967295L);
        iArr2[i20] = (int) j18;
        return (int) (j18 >>> 32);
    }

    public static int mulWordDwordAdd(int i10, long j10, int[] iArr, int i11) {
        long j11 = ((long) i10) & 4294967295L;
        int i12 = i11 + 0;
        long j12 = ((j10 & 4294967295L) * j11) + (((long) iArr[i12]) & 4294967295L) + 0;
        iArr[i12] = (int) j12;
        long j13 = j11 * (j10 >>> 32);
        int i13 = i11 + 1;
        long j14 = (j12 >>> 32) + j13 + (((long) iArr[i13]) & 4294967295L);
        iArr[i13] = (int) j14;
        int i14 = i11 + 2;
        long j15 = (j14 >>> 32) + (((long) iArr[i14]) & 4294967295L);
        iArr[i14] = (int) j15;
        if ((j15 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(8, iArr, i11, 3);
    }

    public static void square(int[] iArr, int i10, int[] iArr2, int i11) {
        long j10 = ((long) iArr[i10 + 0]) & 4294967295L;
        int i12 = 0;
        int i13 = 16;
        int i14 = 7;
        while (true) {
            int i15 = i14 - 1;
            long j11 = ((long) iArr[i10 + i14]) & 4294967295L;
            long j12 = j11 * j11;
            int i16 = i13 - 1;
            iArr2[i11 + i16] = (i12 << 31) | ((int) (j12 >>> 33));
            i13 = i16 - 1;
            iArr2[i11 + i13] = (int) (j12 >>> 1);
            i12 = (int) j12;
            if (i15 <= 0) {
                long j13 = j10 * j10;
                iArr2[i11 + 0] = (int) j13;
                long j14 = ((long) iArr[i10 + 1]) & 4294967295L;
                int i17 = i11 + 2;
                long j15 = ((((long) (i12 << 31)) & 4294967295L) | (j13 >>> 33)) + (j14 * j10);
                int i18 = (int) j15;
                iArr2[i11 + 1] = (i18 << 1) | (((int) (j13 >>> 32)) & 1);
                int i19 = i18 >>> 31;
                long j16 = (((long) iArr2[i17]) & 4294967295L) + (j15 >>> 32);
                long j17 = ((long) iArr[i10 + 2]) & 4294967295L;
                int i20 = i11 + 3;
                long j18 = j14;
                int i21 = i11 + 4;
                long j19 = ((long) iArr2[i20]) & 4294967295L;
                long j20 = j16 + (j17 * j10);
                int i22 = (int) j20;
                iArr2[i17] = (i22 << 1) | i19;
                int i23 = i22 >>> 31;
                long j21 = j19 + (j20 >>> 32) + (j17 * j18);
                long j22 = (((long) iArr2[i21]) & 4294967295L) + (j21 >>> 32);
                long j23 = j17;
                long j24 = ((long) iArr[i10 + 3]) & 4294967295L;
                int i24 = i11 + 5;
                long j25 = (((long) iArr2[i24]) & 4294967295L) + (j22 >>> 32);
                int i25 = i11 + 6;
                int i26 = i24;
                long j26 = (((long) iArr2[i25]) & 4294967295L) + (j25 >>> 32);
                long j27 = (j21 & 4294967295L) + (j24 * j10);
                int i27 = (int) j27;
                iArr2[i20] = (i27 << 1) | i23;
                long j28 = (j22 & 4294967295L) + (j27 >>> 32) + (j24 * j18);
                long j29 = (j25 & 4294967295L) + (j28 >>> 32) + (j24 * j23);
                long j30 = j26 + (j29 >>> 32);
                long j31 = j29 & 4294967295L;
                long j32 = ((long) iArr[i10 + 4]) & 4294967295L;
                int i28 = i11 + 7;
                long j33 = j24;
                long j34 = (((long) iArr2[i28]) & 4294967295L) + (j30 >>> 32);
                int i29 = i11 + 8;
                int i30 = i28;
                long j35 = j30 & 4294967295L;
                long j36 = (((long) iArr2[i29]) & 4294967295L) + (j34 >>> 32);
                long j37 = (j28 & 4294967295L) + (j32 * j10);
                int i31 = (int) j37;
                iArr2[i21] = (i27 >>> 31) | (i31 << 1);
                int i32 = i31 >>> 31;
                long j38 = j31 + (j37 >>> 32) + (j32 * j18);
                long j39 = j35 + (j38 >>> 32) + (j32 * j23);
                long j40 = (j34 & 4294967295L) + (j39 >>> 32) + (j32 * j33);
                long j41 = j36 + (j40 >>> 32);
                long j42 = j32;
                long j43 = ((long) iArr[i10 + 5]) & 4294967295L;
                int i33 = i11 + 9;
                long j44 = j40 & 4294967295L;
                long j45 = (((long) iArr2[i33]) & 4294967295L) + (j41 >>> 32);
                int i34 = i11 + 10;
                int i35 = i33;
                long j46 = (j38 & 4294967295L) + (j43 * j10);
                int i36 = (int) j46;
                iArr2[i26] = i32 | (i36 << 1);
                int i37 = i36 >>> 31;
                long j47 = (j39 & 4294967295L) + (j46 >>> 32) + (j43 * j18);
                long j48 = j44 + (j47 >>> 32) + (j43 * j23);
                long j49 = (j41 & 4294967295L) + (j48 >>> 32) + (j43 * j33);
                long j50 = (j45 & 4294967295L) + (j49 >>> 32) + (j43 * j42);
                long j51 = j49 & 4294967295L;
                long j52 = (((long) iArr2[i34]) & 4294967295L) + (j45 >>> 32) + (j50 >>> 32);
                long j53 = j43;
                long j54 = ((long) iArr[i10 + 6]) & 4294967295L;
                int i38 = i11 + 11;
                long j55 = j50 & 4294967295L;
                long j56 = (((long) iArr2[i38]) & 4294967295L) + (j52 >>> 32);
                int i39 = i11 + 12;
                int i40 = i38;
                long j57 = j52 & 4294967295L;
                long j58 = (((long) iArr2[i39]) & 4294967295L) + (j56 >>> 32);
                long j59 = (j47 & 4294967295L) + (j54 * j10);
                int i41 = (int) j59;
                iArr2[i25] = i37 | (i41 << 1);
                int i42 = i41 >>> 31;
                long j60 = (j48 & 4294967295L) + (j59 >>> 32) + (j54 * j18);
                long j61 = j51 + (j60 >>> 32) + (j54 * j23);
                long j62 = j55 + (j61 >>> 32) + (j54 * j33);
                long j63 = j61 & 4294967295L;
                long j64 = j57 + (j62 >>> 32) + (j54 * j42);
                long j65 = (j56 & 4294967295L) + (j64 >>> 32) + (j54 * j53);
                long j66 = j58 + (j65 >>> 32);
                long j67 = ((long) iArr[i10 + 7]) & 4294967295L;
                int i43 = i11 + 13;
                long j68 = j65 & 4294967295L;
                long j69 = (((long) iArr2[i43]) & 4294967295L) + (j66 >>> 32);
                int i44 = i11 + 14;
                long j70 = (j60 & 4294967295L) + (j10 * j67);
                int i45 = (int) j70;
                iArr2[i30] = (i45 << 1) | i42;
                long j71 = j63 + (j70 >>> 32) + (j67 * j18);
                long j72 = (j62 & 4294967295L) + (j71 >>> 32) + (j67 * j23);
                long j73 = (j64 & 4294967295L) + (j72 >>> 32) + (j67 * j33);
                long j74 = j68 + (j73 >>> 32) + (j67 * j42);
                long j75 = j74;
                long j76 = (j66 & 4294967295L) + (j74 >>> 32) + (j67 * j53);
                long j77 = (j69 & 4294967295L) + (j76 >>> 32) + (j67 * j54);
                long j78 = (((long) iArr2[i44]) & 4294967295L) + (j69 >>> 32) + (j77 >>> 32);
                int i46 = (int) j71;
                iArr2[i29] = (i45 >>> 31) | (i46 << 1);
                int i47 = i46 >>> 31;
                int i48 = (int) j72;
                iArr2[i35] = i47 | (i48 << 1);
                int i49 = i48 >>> 31;
                int i50 = (int) j73;
                iArr2[i34] = i49 | (i50 << 1);
                int i51 = i50 >>> 31;
                int i52 = (int) j75;
                iArr2[i40] = i51 | (i52 << 1);
                int i53 = i52 >>> 31;
                int i54 = (int) j76;
                iArr2[i39] = i53 | (i54 << 1);
                int i55 = i54 >>> 31;
                int i56 = (int) j77;
                iArr2[i43] = i55 | (i56 << 1);
                int i57 = i56 >>> 31;
                int i58 = (int) j78;
                iArr2[i44] = i57 | (i58 << 1);
                int i59 = i58 >>> 31;
                int i60 = i11 + 15;
                iArr2[i60] = i59 | ((iArr2[i60] + ((int) (j78 >>> 32))) << 1);
                return;
            }
            i14 = i15;
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j10 = ((long) iArr[0]) & 4294967295L;
        int i10 = 16;
        int i11 = 0;
        int i12 = 7;
        while (true) {
            int i13 = i12 - 1;
            long j11 = ((long) iArr[i12]) & 4294967295L;
            long j12 = j11 * j11;
            int i14 = i10 - 1;
            iArr2[i14] = (i11 << 31) | ((int) (j12 >>> 33));
            i10 = i14 - 1;
            iArr2[i10] = (int) (j12 >>> 1);
            int i15 = (int) j12;
            if (i13 <= 0) {
                long j13 = j10 * j10;
                long j14 = (((long) (i15 << 31)) & 4294967295L) | (j13 >>> 33);
                iArr2[0] = (int) j13;
                long j15 = ((long) iArr[1]) & 4294967295L;
                long j16 = j14 + (j15 * j10);
                int i16 = (int) j16;
                iArr2[1] = (i16 << 1) | (((int) (j13 >>> 32)) & 1);
                long j17 = (((long) iArr2[2]) & 4294967295L) + (j16 >>> 32);
                long j18 = ((long) iArr[2]) & 4294967295L;
                long j19 = j17 + (j18 * j10);
                int i17 = (int) j19;
                iArr2[2] = (i17 << 1) | (i16 >>> 31);
                long j20 = (((long) iArr2[3]) & 4294967295L) + (j19 >>> 32) + (j18 * j15);
                long j21 = (((long) iArr2[4]) & 4294967295L) + (j20 >>> 32);
                long j22 = ((long) iArr[3]) & 4294967295L;
                long j23 = j18;
                long j24 = (((long) iArr2[5]) & 4294967295L) + (j21 >>> 32);
                long j25 = j21 & 4294967295L;
                long j26 = (((long) iArr2[6]) & 4294967295L) + (j24 >>> 32);
                long j27 = (j20 & 4294967295L) + (j22 * j10);
                int i18 = (int) j27;
                iArr2[3] = (i18 << 1) | (i17 >>> 31);
                long j28 = j25 + (j27 >>> 32) + (j22 * j15);
                long j29 = (j24 & 4294967295L) + (j28 >>> 32) + (j22 * j23);
                long j30 = j26 + (j29 >>> 32);
                long j31 = j22;
                long j32 = ((long) iArr[4]) & 4294967295L;
                long j33 = j29 & 4294967295L;
                long j34 = (((long) iArr2[7]) & 4294967295L) + (j30 >>> 32);
                long j35 = (j28 & 4294967295L) + (j32 * j10);
                int i19 = (int) j35;
                iArr2[4] = (i18 >>> 31) | (i19 << 1);
                int i20 = i19 >>> 31;
                long j36 = j33 + (j35 >>> 32) + (j32 * j15);
                long j37 = (j30 & 4294967295L) + (j36 >>> 32) + (j32 * j23);
                long j38 = (j34 & 4294967295L) + (j37 >>> 32) + (j32 * j31);
                long j39 = (((long) iArr2[8]) & 4294967295L) + (j34 >>> 32) + (j38 >>> 32);
                long j40 = j32;
                long j41 = ((long) iArr[5]) & 4294967295L;
                long j42 = j38 & 4294967295L;
                long j43 = (((long) iArr2[9]) & 4294967295L) + (j39 >>> 32);
                long j44 = j39 & 4294967295L;
                long j45 = (((long) iArr2[10]) & 4294967295L) + (j43 >>> 32);
                long j46 = (j36 & 4294967295L) + (j41 * j10);
                int i21 = (int) j46;
                iArr2[5] = (i21 << 1) | i20;
                long j47 = (j37 & 4294967295L) + (j46 >>> 32) + (j41 * j15);
                long j48 = j42 + (j47 >>> 32) + (j41 * j23);
                long j49 = j44 + (j48 >>> 32) + (j41 * j31);
                long j50 = (j43 & 4294967295L) + (j49 >>> 32) + (j41 * j40);
                long j51 = j45 + (j50 >>> 32);
                long j52 = j41;
                long j53 = ((long) iArr[6]) & 4294967295L;
                long j54 = (((long) iArr2[11]) & 4294967295L) + (j51 >>> 32);
                long j55 = j51 & 4294967295L;
                long j56 = (((long) iArr2[12]) & 4294967295L) + (j54 >>> 32);
                long j57 = (j47 & 4294967295L) + (j53 * j10);
                int i22 = (int) j57;
                iArr2[6] = (i22 << 1) | (i21 >>> 31);
                long j58 = (j48 & 4294967295L) + (j57 >>> 32) + (j53 * j15);
                long j59 = (j49 & 4294967295L) + (j58 >>> 32) + (j53 * j23);
                long j60 = (j50 & 4294967295L) + (j59 >>> 32) + (j53 * j31);
                long j61 = j55 + (j60 >>> 32) + (j53 * j40);
                long j62 = (j54 & 4294967295L) + (j61 >>> 32) + (j53 * j52);
                long j63 = j56 + (j62 >>> 32);
                long j64 = j53;
                long j65 = ((long) iArr[7]) & 4294967295L;
                long j66 = j62 & 4294967295L;
                long j67 = (((long) iArr2[13]) & 4294967295L) + (j63 >>> 32);
                long j68 = (j58 & 4294967295L) + (j10 * j65);
                int i23 = (int) j68;
                iArr2[7] = (i22 >>> 31) | (i23 << 1);
                int i24 = i23 >>> 31;
                long j69 = (j59 & 4294967295L) + (j68 >>> 32) + (j15 * j65);
                long j70 = (j60 & 4294967295L) + (j69 >>> 32) + (j65 * j23);
                long j71 = (j61 & 4294967295L) + (j70 >>> 32) + (j65 * j31);
                long j72 = j66 + (j71 >>> 32) + (j65 * j40);
                long j73 = j72;
                long j74 = (j63 & 4294967295L) + (j72 >>> 32) + (j65 * j52);
                long j75 = (j67 & 4294967295L) + (j74 >>> 32) + (j65 * j64);
                long j76 = (((long) iArr2[14]) & 4294967295L) + (j67 >>> 32) + (j75 >>> 32);
                int i25 = (int) j69;
                iArr2[8] = i24 | (i25 << 1);
                int i26 = i25 >>> 31;
                int i27 = (int) j70;
                iArr2[9] = i26 | (i27 << 1);
                int i28 = i27 >>> 31;
                int i29 = (int) j71;
                iArr2[10] = i28 | (i29 << 1);
                int i30 = i29 >>> 31;
                int i31 = (int) j73;
                iArr2[11] = i30 | (i31 << 1);
                int i32 = i31 >>> 31;
                int i33 = (int) j74;
                iArr2[12] = i32 | (i33 << 1);
                int i34 = i33 >>> 31;
                int i35 = (int) j75;
                iArr2[13] = i34 | (i35 << 1);
                int i36 = i35 >>> 31;
                int i37 = (int) j76;
                iArr2[14] = i36 | (i37 << 1);
                iArr2[15] = (i37 >>> 31) | ((iArr2[15] + ((int) (j76 >>> 32))) << 1);
                return;
            }
            i12 = i13;
            i11 = i15;
        }
    }

    public static int sub(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        long j10 = ((((long) iArr[i10 + 0]) & 4294967295L) - (((long) iArr2[i11 + 0]) & 4294967295L)) + 0;
        iArr3[i12 + 0] = (int) j10;
        long j11 = (j10 >> 32) + ((((long) iArr[i10 + 1]) & 4294967295L) - (((long) iArr2[i11 + 1]) & 4294967295L));
        iArr3[i12 + 1] = (int) j11;
        long j12 = (j11 >> 32) + ((((long) iArr[i10 + 2]) & 4294967295L) - (((long) iArr2[i11 + 2]) & 4294967295L));
        iArr3[i12 + 2] = (int) j12;
        long j13 = (j12 >> 32) + ((((long) iArr[i10 + 3]) & 4294967295L) - (((long) iArr2[i11 + 3]) & 4294967295L));
        iArr3[i12 + 3] = (int) j13;
        long j14 = (j13 >> 32) + ((((long) iArr[i10 + 4]) & 4294967295L) - (((long) iArr2[i11 + 4]) & 4294967295L));
        iArr3[i12 + 4] = (int) j14;
        long j15 = (j14 >> 32) + ((((long) iArr[i10 + 5]) & 4294967295L) - (((long) iArr2[i11 + 5]) & 4294967295L));
        iArr3[i12 + 5] = (int) j15;
        long j16 = (j15 >> 32) + ((((long) iArr[i10 + 6]) & 4294967295L) - (((long) iArr2[i11 + 6]) & 4294967295L));
        iArr3[i12 + 6] = (int) j16;
        long j17 = (j16 >> 32) + ((((long) iArr[i10 + 7]) & 4294967295L) - (((long) iArr2[i11 + 7]) & 4294967295L));
        iArr3[i12 + 7] = (int) j17;
        return (int) (j17 >> 32);
    }

    public static int sub(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = ((((long) iArr[0]) & 4294967295L) - (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j10;
        long j11 = (j10 >> 32) + ((((long) iArr[1]) & 4294967295L) - (((long) iArr2[1]) & 4294967295L));
        iArr3[1] = (int) j11;
        long j12 = (j11 >> 32) + ((((long) iArr[2]) & 4294967295L) - (((long) iArr2[2]) & 4294967295L));
        iArr3[2] = (int) j12;
        long j13 = (j12 >> 32) + ((((long) iArr[3]) & 4294967295L) - (((long) iArr2[3]) & 4294967295L));
        iArr3[3] = (int) j13;
        long j14 = (j13 >> 32) + ((((long) iArr[4]) & 4294967295L) - (((long) iArr2[4]) & 4294967295L));
        iArr3[4] = (int) j14;
        long j15 = (j14 >> 32) + ((((long) iArr[5]) & 4294967295L) - (((long) iArr2[5]) & 4294967295L));
        iArr3[5] = (int) j15;
        long j16 = (j15 >> 32) + ((((long) iArr[6]) & 4294967295L) - (((long) iArr2[6]) & 4294967295L));
        iArr3[6] = (int) j16;
        long j17 = (j16 >> 32) + ((((long) iArr[7]) & 4294967295L) - (((long) iArr2[7]) & 4294967295L));
        iArr3[7] = (int) j17;
        return (int) (j17 >> 32);
    }

    public static int subBothFrom(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = (((((long) iArr3[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L)) - (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j10;
        long j11 = (j10 >> 32) + (((((long) iArr3[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L)) - (((long) iArr2[1]) & 4294967295L));
        iArr3[1] = (int) j11;
        long j12 = (j11 >> 32) + (((((long) iArr3[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L)) - (((long) iArr2[2]) & 4294967295L));
        iArr3[2] = (int) j12;
        long j13 = (j12 >> 32) + (((((long) iArr3[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L)) - (((long) iArr2[3]) & 4294967295L));
        iArr3[3] = (int) j13;
        long j14 = (j13 >> 32) + (((((long) iArr3[4]) & 4294967295L) - (((long) iArr[4]) & 4294967295L)) - (((long) iArr2[4]) & 4294967295L));
        iArr3[4] = (int) j14;
        long j15 = (j14 >> 32) + (((((long) iArr3[5]) & 4294967295L) - (((long) iArr[5]) & 4294967295L)) - (((long) iArr2[5]) & 4294967295L));
        iArr3[5] = (int) j15;
        long j16 = (j15 >> 32) + (((((long) iArr3[6]) & 4294967295L) - (((long) iArr[6]) & 4294967295L)) - (((long) iArr2[6]) & 4294967295L));
        iArr3[6] = (int) j16;
        long j17 = (j16 >> 32) + (((((long) iArr3[7]) & 4294967295L) - (((long) iArr[7]) & 4294967295L)) - (((long) iArr2[7]) & 4294967295L));
        iArr3[7] = (int) j17;
        return (int) (j17 >> 32);
    }

    public static int subFrom(int[] iArr, int i10, int[] iArr2, int i11) {
        int i12 = i11 + 0;
        long j10 = ((((long) iArr2[i12]) & 4294967295L) - (((long) iArr[i10 + 0]) & 4294967295L)) + 0;
        iArr2[i12] = (int) j10;
        int i13 = i11 + 1;
        long j11 = (j10 >> 32) + ((((long) iArr2[i13]) & 4294967295L) - (((long) iArr[i10 + 1]) & 4294967295L));
        iArr2[i13] = (int) j11;
        int i14 = i11 + 2;
        long j12 = (j11 >> 32) + ((((long) iArr2[i14]) & 4294967295L) - (((long) iArr[i10 + 2]) & 4294967295L));
        iArr2[i14] = (int) j12;
        int i15 = i11 + 3;
        long j13 = (j12 >> 32) + ((((long) iArr2[i15]) & 4294967295L) - (((long) iArr[i10 + 3]) & 4294967295L));
        iArr2[i15] = (int) j13;
        int i16 = i11 + 4;
        long j14 = (j13 >> 32) + ((((long) iArr2[i16]) & 4294967295L) - (((long) iArr[i10 + 4]) & 4294967295L));
        iArr2[i16] = (int) j14;
        int i17 = i11 + 5;
        long j15 = (j14 >> 32) + ((((long) iArr2[i17]) & 4294967295L) - (((long) iArr[i10 + 5]) & 4294967295L));
        iArr2[i17] = (int) j15;
        int i18 = i11 + 6;
        long j16 = (j15 >> 32) + ((((long) iArr2[i18]) & 4294967295L) - (((long) iArr[i10 + 6]) & 4294967295L));
        iArr2[i18] = (int) j16;
        int i19 = i11 + 7;
        long j17 = (j16 >> 32) + ((((long) iArr2[i19]) & 4294967295L) - (((long) iArr[i10 + 7]) & 4294967295L));
        iArr2[i19] = (int) j17;
        return (int) (j17 >> 32);
    }

    public static int subFrom(int[] iArr, int[] iArr2) {
        long j10 = ((((long) iArr2[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L)) + 0;
        iArr2[0] = (int) j10;
        long j11 = (j10 >> 32) + ((((long) iArr2[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L));
        iArr2[1] = (int) j11;
        long j12 = (j11 >> 32) + ((((long) iArr2[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L));
        iArr2[2] = (int) j12;
        long j13 = (j12 >> 32) + ((((long) iArr2[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L));
        iArr2[3] = (int) j13;
        long j14 = (j13 >> 32) + ((((long) iArr2[4]) & 4294967295L) - (((long) iArr[4]) & 4294967295L));
        iArr2[4] = (int) j14;
        long j15 = (j14 >> 32) + ((((long) iArr2[5]) & 4294967295L) - (((long) iArr[5]) & 4294967295L));
        iArr2[5] = (int) j15;
        long j16 = (j15 >> 32) + ((((long) iArr2[6]) & 4294967295L) - (((long) iArr[6]) & 4294967295L));
        iArr2[6] = (int) j16;
        long j17 = (j16 >> 32) + ((((long) iArr2[7]) & 4294967295L) - (4294967295L & ((long) iArr[7])));
        iArr2[7] = (int) j17;
        return (int) (j17 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[32];
        for (int i10 = 0; i10 < 8; i10++) {
            int i11 = iArr[i10];
            if (i11 != 0) {
                Pack.intToBigEndian(i11, bArr, (7 - i10) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static BigInteger toBigInteger64(long[] jArr) {
        byte[] bArr = new byte[32];
        for (int i10 = 0; i10 < 4; i10++) {
            long j10 = jArr[i10];
            if (j10 != 0) {
                Pack.longToBigEndian(j10, bArr, (3 - i10) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void zero(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
        iArr[6] = 0;
        iArr[7] = 0;
    }
}
