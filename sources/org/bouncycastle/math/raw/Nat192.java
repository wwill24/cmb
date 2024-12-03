package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

public abstract class Nat192 {
    private static final long M = 4294967295L;

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
        return (int) (j15 >>> 32);
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
        return (int) (j15 >>> 32);
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
        long j15 = (j14 >>> 32) + (((long) iArr[i10 + 5]) & 4294967295L) + (4294967295L & ((long) iArr2[i18]));
        iArr2[i18] = (int) j15;
        return (int) (j15 >>> 32);
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
        long j15 = (j14 >>> 32) + (((long) iArr[5]) & 4294967295L) + (4294967295L & ((long) iArr2[5]));
        iArr2[5] = (int) j15;
        return (int) (j15 >>> 32);
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
        long j15 = (j14 >>> 32) + (((long) iArr[i27]) & 4294967295L) + (4294967295L & ((long) iArr2[i28]));
        int i29 = (int) j15;
        iArr[i27] = i29;
        iArr2[i28] = i29;
        return (int) (j15 >>> 32);
    }

    public static void copy(int[] iArr, int i10, int[] iArr2, int i11) {
        iArr2[i11 + 0] = iArr[i10 + 0];
        iArr2[i11 + 1] = iArr[i10 + 1];
        iArr2[i11 + 2] = iArr[i10 + 2];
        iArr2[i11 + 3] = iArr[i10 + 3];
        iArr2[i11 + 4] = iArr[i10 + 4];
        iArr2[i11 + 5] = iArr[i10 + 5];
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
        iArr2[5] = iArr[5];
    }

    public static void copy64(long[] jArr, int i10, long[] jArr2, int i11) {
        jArr2[i11 + 0] = jArr[i10 + 0];
        jArr2[i11 + 1] = jArr[i10 + 1];
        jArr2[i11 + 2] = jArr[i10 + 2];
    }

    public static void copy64(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
    }

    public static int[] create() {
        return new int[6];
    }

    public static long[] create64() {
        return new long[3];
    }

    public static int[] createExt() {
        return new int[12];
    }

    public static long[] createExt64() {
        return new long[6];
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
        for (int i10 = 5; i10 >= 0; i10--) {
            if (iArr[i10] != iArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static boolean eq64(long[] jArr, long[] jArr2) {
        for (int i10 = 2; i10 >= 0; i10--) {
            if (jArr[i10] != jArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 192) {
            throw new IllegalArgumentException();
        }
        int[] create = create();
        for (int i10 = 0; i10 < 6; i10++) {
            create[i10] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return create;
    }

    public static long[] fromBigInteger64(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 192) {
            throw new IllegalArgumentException();
        }
        long[] create64 = create64();
        for (int i10 = 0; i10 < 3; i10++) {
            create64[i10] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
        }
        return create64;
    }

    public static int getBit(int[] iArr, int i10) {
        int i11;
        if (i10 == 0) {
            i11 = iArr[0];
        } else {
            int i12 = i10 >> 5;
            if (i12 < 0 || i12 >= 6) {
                return 0;
            }
            i11 = iArr[i12] >>> (i10 & 31);
        }
        return i11 & 1;
    }

    public static boolean gte(int[] iArr, int i10, int[] iArr2, int i11) {
        for (int i12 = 5; i12 >= 0; i12--) {
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
        for (int i10 = 5; i10 >= 0; i10--) {
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
        for (int i10 = 1; i10 < 6; i10++) {
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
        for (int i10 = 1; i10 < 3; i10++) {
            if (jArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] iArr) {
        for (int i10 = 0; i10 < 6; i10++) {
            if (iArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero64(long[] jArr) {
        for (int i10 = 0; i10 < 3; i10++) {
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
        long j16 = ((long) iArr[i10 + 0]) & 4294967295L;
        long j17 = (j16 * j10) + 0;
        long j18 = j10;
        iArr3[i12 + 0] = (int) j17;
        long j19 = (j17 >>> 32) + (j16 * j11);
        long j20 = j11;
        iArr3[i12 + 1] = (int) j19;
        long j21 = (j19 >>> 32) + (j16 * j12);
        iArr3[i12 + 2] = (int) j21;
        long j22 = (j21 >>> 32) + (j16 * j13);
        iArr3[i12 + 3] = (int) j22;
        long j23 = (j22 >>> 32) + (j16 * j14);
        iArr3[i12 + 4] = (int) j23;
        long j24 = (j23 >>> 32) + (j16 * j15);
        iArr3[i12 + 5] = (int) j24;
        iArr3[i12 + 6] = (int) (j24 >>> 32);
        int i13 = 1;
        int i14 = i12;
        int i15 = 1;
        while (i15 < 6) {
            i14 += i13;
            long j25 = ((long) iArr[i10 + i15]) & 4294967295L;
            int i16 = i14 + 0;
            long j26 = (j25 * j18) + (((long) iArr3[i16]) & 4294967295L) + 0;
            iArr3[i16] = (int) j26;
            int i17 = i14 + 1;
            long j27 = j15;
            long j28 = (j26 >>> 32) + (j25 * j20) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j28;
            int i18 = i14 + 2;
            long j29 = (j28 >>> 32) + (j25 * j12) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j29;
            int i19 = i14 + 3;
            long j30 = (j29 >>> 32) + (j25 * j13) + (((long) iArr3[i19]) & 4294967295L);
            iArr3[i19] = (int) j30;
            int i20 = i14 + 4;
            long j31 = (j30 >>> 32) + (j25 * j14) + (((long) iArr3[i20]) & 4294967295L);
            iArr3[i20] = (int) j31;
            int i21 = i14 + 5;
            long j32 = (j31 >>> 32) + (j25 * j27) + (((long) iArr3[i21]) & 4294967295L);
            iArr3[i21] = (int) j32;
            iArr3[i14 + 6] = (int) (j32 >>> 32);
            i15++;
            j12 = j12;
            j15 = j27;
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
        long j16 = ((long) iArr[0]) & 4294967295L;
        long j17 = (j16 * j10) + 0;
        iArr3[0] = (int) j17;
        long j18 = (j17 >>> 32) + (j16 * j11);
        iArr3[1] = (int) j18;
        long j19 = (j18 >>> 32) + (j16 * j14);
        iArr3[2] = (int) j19;
        long j20 = (j19 >>> 32) + (j16 * j12);
        iArr3[3] = (int) j20;
        long j21 = (j20 >>> 32) + (j16 * j13);
        iArr3[4] = (int) j21;
        long j22 = (j21 >>> 32) + (j16 * j15);
        iArr3[5] = (int) j22;
        iArr3[6] = (int) (j22 >>> 32);
        int i10 = 1;
        for (int i11 = 6; i10 < i11; i11 = 6) {
            long j23 = ((long) iArr[i10]) & 4294967295L;
            int i12 = i10 + 0;
            long j24 = (j23 * j10) + (((long) iArr3[i12]) & 4294967295L) + 0;
            iArr3[i12] = (int) j24;
            int i13 = i10 + 1;
            long j25 = j11;
            long j26 = (j24 >>> 32) + (j23 * j11) + (((long) iArr3[i13]) & 4294967295L);
            iArr3[i13] = (int) j26;
            int i14 = i10 + 2;
            long j27 = j15;
            long j28 = (j26 >>> 32) + (j23 * j14) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j28;
            int i15 = i10 + 3;
            long j29 = (j28 >>> 32) + (j23 * j12) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j29;
            int i16 = i10 + 4;
            long j30 = (j29 >>> 32) + (j23 * j13) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) j30;
            int i17 = i10 + 5;
            long j31 = (j30 >>> 32) + (j23 * j27) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j31;
            iArr3[i10 + 6] = (int) (j31 >>> 32);
            i10 = i13;
            j10 = j10;
            j11 = j25;
            j15 = j27;
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
        long j23 = (j21 >>> 32) + (j10 * j22) + j20 + (4294967295L & ((long) iArr2[i12 + 5]));
        iArr3[i13 + 5] = (int) j23;
        return (j23 >>> 32) + j22;
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
        return Nat.incAt(6, iArr2, i12, 4);
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
        return Nat.incAt(6, iArr, i12, 3);
    }

    public static int mulAddTo(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        long j10 = 4294967295L;
        long j11 = ((long) iArr2[i11 + 0]) & 4294967295L;
        long j12 = ((long) iArr2[i11 + 1]) & 4294967295L;
        long j13 = ((long) iArr2[i11 + 2]) & 4294967295L;
        long j14 = ((long) iArr2[i11 + 3]) & 4294967295L;
        long j15 = ((long) iArr2[i11 + 4]) & 4294967295L;
        long j16 = ((long) iArr2[i11 + 5]) & 4294967295L;
        int i13 = 0;
        long j17 = 0;
        int i14 = i12;
        while (i13 < 6) {
            int i15 = i13;
            long j18 = ((long) iArr[i10 + i13]) & j10;
            int i16 = i14 + 0;
            long j19 = (j18 * j11) + (((long) iArr3[i16]) & j10) + 0;
            iArr3[i16] = (int) j19;
            int i17 = i14 + 1;
            long j20 = j12;
            long j21 = (j19 >>> 32) + (j18 * j12) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j21;
            int i18 = i14 + 2;
            long j22 = j13;
            long j23 = (j21 >>> 32) + (j18 * j13) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j23;
            int i19 = i14 + 3;
            long j24 = (j23 >>> 32) + (j18 * j14) + (((long) iArr3[i19]) & 4294967295L);
            iArr3[i19] = (int) j24;
            int i20 = i14 + 4;
            long j25 = (j24 >>> 32) + (j18 * j15) + (((long) iArr3[i20]) & 4294967295L);
            iArr3[i20] = (int) j25;
            int i21 = i14 + 5;
            long j26 = (j25 >>> 32) + (j18 * j16) + (((long) iArr3[i21]) & 4294967295L);
            iArr3[i21] = (int) j26;
            int i22 = i14 + 6;
            long j27 = (j26 >>> 32) + (((long) iArr3[i22]) & 4294967295L) + j17;
            iArr3[i22] = (int) j27;
            j17 = j27 >>> 32;
            i13 = i15 + 1;
            i14 = i17;
            j11 = j11;
            j10 = 4294967295L;
            j12 = j20;
            j13 = j22;
        }
        return (int) j17;
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        int i10 = 0;
        long j10 = 4294967295L;
        long j11 = ((long) iArr2[0]) & 4294967295L;
        long j12 = ((long) iArr2[1]) & 4294967295L;
        long j13 = ((long) iArr2[2]) & 4294967295L;
        long j14 = ((long) iArr2[3]) & 4294967295L;
        long j15 = ((long) iArr2[4]) & 4294967295L;
        long j16 = ((long) iArr2[5]) & 4294967295L;
        long j17 = 0;
        while (i10 < 6) {
            long j18 = j16;
            long j19 = ((long) iArr[i10]) & j10;
            int i11 = i10 + 0;
            long j20 = j11;
            long j21 = (j19 * j11) + (((long) iArr3[i11]) & j10) + 0;
            iArr3[i11] = (int) j21;
            int i12 = i10 + 1;
            long j22 = (j21 >>> 32) + (j19 * j12) + (((long) iArr3[i12]) & 4294967295L);
            iArr3[i12] = (int) j22;
            int i13 = i10 + 2;
            long j23 = (j22 >>> 32) + (j19 * j13) + (((long) iArr3[i13]) & 4294967295L);
            iArr3[i13] = (int) j23;
            int i14 = i10 + 3;
            long j24 = (j23 >>> 32) + (j19 * j14) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j24;
            int i15 = i10 + 4;
            long j25 = (j24 >>> 32) + (j19 * j15) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j25;
            int i16 = i10 + 5;
            long j26 = (j25 >>> 32) + (j19 * j18) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) j26;
            int i17 = i10 + 6;
            long j27 = (j26 >>> 32) + (((long) iArr3[i17]) & 4294967295L) + j17;
            iArr3[i17] = (int) j27;
            j17 = j27 >>> 32;
            i10 = i12;
            j10 = 4294967295L;
            j16 = j18;
            j11 = j20;
            j12 = j12;
            j13 = j13;
        }
        return (int) j17;
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
        } while (i12 < 6);
        return (int) j11;
    }

    public static int mulWordAddExt(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
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
        long j16 = (j15 >>> 32) + (j10 * (((long) iArr[i11 + 5]) & 4294967295L)) + (((long) iArr2[i18]) & 4294967295L);
        iArr2[i18] = (int) j16;
        return (int) (j16 >>> 32);
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
        return Nat.incAt(6, iArr, i11, 3);
    }

    public static void square(int[] iArr, int i10, int[] iArr2, int i11) {
        long j10 = ((long) iArr[i10 + 0]) & 4294967295L;
        int i12 = 0;
        int i13 = 12;
        int i14 = 5;
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
                long j46 = (j38 & 4294967295L) + (j10 * j43);
                int i36 = (int) j46;
                iArr2[i26] = (i36 << 1) | i32;
                long j47 = (j39 & 4294967295L) + (j46 >>> 32) + (j43 * j18);
                long j48 = j44 + (j47 >>> 32) + (j43 * j23);
                long j49 = (j41 & 4294967295L) + (j48 >>> 32) + (j43 * j33);
                long j50 = (j45 & 4294967295L) + (j49 >>> 32) + (j43 * j42);
                long j51 = (((long) iArr2[i34]) & 4294967295L) + (j45 >>> 32) + (j50 >>> 32);
                int i37 = (int) j47;
                iArr2[i25] = (i36 >>> 31) | (i37 << 1);
                int i38 = (int) j48;
                iArr2[i30] = (i37 >>> 31) | (i38 << 1);
                int i39 = i38 >>> 31;
                int i40 = (int) j49;
                iArr2[i29] = i39 | (i40 << 1);
                int i41 = i40 >>> 31;
                int i42 = (int) j50;
                iArr2[i35] = i41 | (i42 << 1);
                int i43 = i42 >>> 31;
                int i44 = (int) j51;
                iArr2[i34] = i43 | (i44 << 1);
                int i45 = i44 >>> 31;
                int i46 = i11 + 11;
                iArr2[i46] = i45 | ((iArr2[i46] + ((int) (j51 >>> 32))) << 1);
                return;
            }
            i14 = i15;
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j10 = ((long) iArr[0]) & 4294967295L;
        int i10 = 12;
        int i11 = 0;
        int i12 = 5;
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
                long j36 = j33 + (j35 >>> 32) + (j32 * j15);
                long j37 = (j30 & 4294967295L) + (j36 >>> 32) + (j32 * j23);
                long j38 = (j34 & 4294967295L) + (j37 >>> 32) + (j32 * j31);
                long j39 = (((long) iArr2[8]) & 4294967295L) + (j34 >>> 32) + (j38 >>> 32);
                long j40 = j32;
                long j41 = ((long) iArr[5]) & 4294967295L;
                long j42 = (((long) iArr2[9]) & 4294967295L) + (j39 >>> 32);
                long j43 = (j36 & 4294967295L) + (j10 * j41);
                int i20 = (int) j43;
                iArr2[5] = (i19 >>> 31) | (i20 << 1);
                int i21 = i20 >>> 31;
                long j44 = (j37 & 4294967295L) + (j43 >>> 32) + (j15 * j41);
                long j45 = (j38 & 4294967295L) + (j44 >>> 32) + (j41 * j23);
                long j46 = (j39 & 4294967295L) + (j45 >>> 32) + (j41 * j31);
                long j47 = (j42 & 4294967295L) + (j46 >>> 32) + (j41 * j40);
                long j48 = (((long) iArr2[10]) & 4294967295L) + (j42 >>> 32) + (j47 >>> 32);
                int i22 = (int) j44;
                iArr2[6] = i21 | (i22 << 1);
                int i23 = (int) j45;
                iArr2[7] = (i22 >>> 31) | (i23 << 1);
                int i24 = i23 >>> 31;
                int i25 = (int) j46;
                iArr2[8] = i24 | (i25 << 1);
                int i26 = i25 >>> 31;
                int i27 = (int) j47;
                iArr2[9] = i26 | (i27 << 1);
                int i28 = i27 >>> 31;
                int i29 = (int) j48;
                iArr2[10] = i28 | (i29 << 1);
                iArr2[11] = (i29 >>> 31) | ((iArr2[11] + ((int) (j48 >>> 32))) << 1);
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
        return (int) (j15 >> 32);
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
        return (int) (j15 >> 32);
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
        return (int) (j15 >> 32);
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
        return (int) (j15 >> 32);
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
        long j15 = (j14 >> 32) + ((((long) iArr2[5]) & 4294967295L) - (4294967295L & ((long) iArr[5])));
        iArr2[5] = (int) j15;
        return (int) (j15 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[24];
        for (int i10 = 0; i10 < 6; i10++) {
            int i11 = iArr[i10];
            if (i11 != 0) {
                Pack.intToBigEndian(i11, bArr, (5 - i10) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static BigInteger toBigInteger64(long[] jArr) {
        byte[] bArr = new byte[24];
        for (int i10 = 0; i10 < 3; i10++) {
            long j10 = jArr[i10];
            if (j10 != 0) {
                Pack.longToBigEndian(j10, bArr, (2 - i10) << 3);
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
    }
}
