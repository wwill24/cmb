package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat384;
import org.bouncycastle.util.Pack;

public class SecP384R1Field {
    private static final long M = 4294967295L;
    static final int[] P = {-1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1};
    private static final int P11 = -1;
    private static final int[] PExt = {1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 0, 0, -2, 1, 0, -2, -3, -1, -1, -1, -1, -1, -1, -1};
    private static final int PExt23 = -1;
    private static final int[] PExtInv = {-1, 1, -1, -3, -1, 1, -1, -3, -2, -1, -1, -1, 1, -2, -1, 1, 2};

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.add(12, iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && Nat.gte(12, iArr3, P))) {
            addPInvTo(iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.add(24, iArr, iArr2, iArr3) != 0 || (iArr3[23] == -1 && Nat.gte(24, iArr3, PExt))) {
            int[] iArr4 = PExtInv;
            if (Nat.addTo(iArr4.length, iArr4, iArr3) != 0) {
                Nat.incAt(24, iArr3, iArr4.length);
            }
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (Nat.inc(12, iArr, iArr2) != 0 || (iArr2[11] == -1 && Nat.gte(12, iArr2, P))) {
            addPInvTo(iArr2);
        }
    }

    private static void addPInvTo(int[] iArr) {
        long j10 = (((long) iArr[0]) & 4294967295L) + 1;
        iArr[0] = (int) j10;
        long j11 = (j10 >> 32) + ((((long) iArr[1]) & 4294967295L) - 1);
        iArr[1] = (int) j11;
        long j12 = j11 >> 32;
        if (j12 != 0) {
            long j13 = j12 + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j13;
            j12 = j13 >> 32;
        }
        long j14 = j12 + (((long) iArr[3]) & 4294967295L) + 1;
        iArr[3] = (int) j14;
        long j15 = (j14 >> 32) + (4294967295L & ((long) iArr[4])) + 1;
        iArr[4] = (int) j15;
        if ((j15 >> 32) != 0) {
            Nat.incAt(12, iArr, 5);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] fromBigInteger = Nat.fromBigInteger(384, bigInteger);
        if (fromBigInteger[11] == -1) {
            int[] iArr = P;
            if (Nat.gte(12, fromBigInteger, iArr)) {
                Nat.subFrom(12, iArr, fromBigInteger);
            }
        }
        return fromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            Nat.shiftDownBit(12, iArr, 0, iArr2);
        } else {
            Nat.shiftDownBit(12, iArr2, Nat.add(12, iArr, P, iArr2));
        }
    }

    public static void inv(int[] iArr, int[] iArr2) {
        Mod.checkedModOddInverse(P, iArr, iArr2);
    }

    public static int isZero(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 12; i11++) {
            i10 |= iArr[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = Nat.create(24);
        Nat384.mul(iArr, iArr2, create);
        reduce(create, iArr3);
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (isZero(iArr) != 0) {
            int[] iArr3 = P;
            Nat.sub(12, iArr3, iArr3, iArr2);
            return;
        }
        Nat.sub(12, P, iArr, iArr2);
    }

    public static void random(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[48];
        do {
            secureRandom.nextBytes(bArr);
            Pack.littleEndianToInt(bArr, 0, iArr, 0, 12);
        } while (Nat.lessThan(12, iArr, P) == 0);
    }

    public static void randomMult(SecureRandom secureRandom, int[] iArr) {
        do {
            random(secureRandom, iArr);
        } while (isZero(iArr) != 0);
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j10 = ((long) iArr[17]) & 4294967295L;
        long j11 = ((long) iArr[20]) & 4294967295L;
        long j12 = ((long) iArr[21]) & 4294967295L;
        long j13 = ((long) iArr[19]) & 4294967295L;
        long j14 = ((long) iArr[22]) & 4294967295L;
        long j15 = ((long) iArr[18]) & 4294967295L;
        long j16 = ((long) iArr[23]) & 4294967295L;
        long j17 = ((long) iArr[16]) & 4294967295L;
        long j18 = ((((long) iArr[12]) & 4294967295L) + j11) - 1;
        long j19 = j11;
        long j20 = (((long) iArr[13]) & 4294967295L) + j14;
        long j21 = (((long) iArr[14]) & 4294967295L) + j14 + j16;
        long j22 = (((long) iArr[15]) & 4294967295L) + j16;
        long j23 = j10 + j12;
        long j24 = j12 - j16;
        long j25 = j18 + j24;
        long j26 = j14 - j16;
        long j27 = (((long) iArr[0]) & 4294967295L) + j25 + 0;
        iArr3[0] = (int) j27;
        long j28 = (j27 >> 32) + (((((long) iArr[1]) & 4294967295L) + j16) - j18) + j20;
        iArr3[1] = (int) j28;
        long j29 = (j28 >> 32) + (((((long) iArr[2]) & 4294967295L) - j12) - j20) + j21;
        iArr3[2] = (int) j29;
        long j30 = (j29 >> 32) + ((((long) iArr[3]) & 4294967295L) - j21) + j22 + j25;
        iArr3[3] = (int) j30;
        long j31 = (j30 >> 32) + (((((((long) iArr[4]) & 4294967295L) + j17) + j12) + j20) - j22) + j25;
        iArr3[4] = (int) j31;
        long j32 = (j31 >> 32) + ((((long) iArr[5]) & 4294967295L) - j17) + j20 + j21 + j23;
        iArr3[5] = (int) j32;
        long j33 = (j32 >> 32) + (((((long) iArr[6]) & 4294967295L) + j15) - j10) + j21 + j22;
        iArr3[6] = (int) j33;
        long j34 = (j33 >> 32) + ((((((long) iArr[7]) & 4294967295L) + j17) + j13) - j15) + j22;
        iArr3[7] = (int) j34;
        long j35 = (j34 >> 32) + (((((((long) iArr[8]) & 4294967295L) + j17) + j10) + j19) - j13);
        iArr3[8] = (int) j35;
        long j36 = (j35 >> 32) + (((((long) iArr[9]) & 4294967295L) + j15) - j19) + j23;
        iArr3[9] = (int) j36;
        long j37 = (j36 >> 32) + ((((((long) iArr[10]) & 4294967295L) + j15) + j13) - j24) + j26;
        iArr3[10] = (int) j37;
        long j38 = (j37 >> 32) + ((((((long) iArr[11]) & 4294967295L) + j13) + j19) - j26);
        iArr3[11] = (int) j38;
        reduce32((int) ((j38 >> 32) + 1), iArr3);
    }

    public static void reduce32(int i10, int[] iArr) {
        long j10;
        if (i10 != 0) {
            long j11 = ((long) i10) & 4294967295L;
            long j12 = (((long) iArr[0]) & 4294967295L) + j11 + 0;
            iArr[0] = (int) j12;
            long j13 = (j12 >> 32) + ((((long) iArr[1]) & 4294967295L) - j11);
            iArr[1] = (int) j13;
            long j14 = j13 >> 32;
            if (j14 != 0) {
                long j15 = j14 + (((long) iArr[2]) & 4294967295L);
                iArr[2] = (int) j15;
                j14 = j15 >> 32;
            }
            long j16 = j14 + (((long) iArr[3]) & 4294967295L) + j11;
            iArr[3] = (int) j16;
            long j17 = (j16 >> 32) + (4294967295L & ((long) iArr[4])) + j11;
            iArr[4] = (int) j17;
            j10 = j17 >> 32;
        } else {
            j10 = 0;
        }
        if ((j10 != 0 && Nat.incAt(12, iArr, 5) != 0) || (iArr[11] == -1 && Nat.gte(12, iArr, P))) {
            addPInvTo(iArr);
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] create = Nat.create(24);
        Nat384.square(iArr, create);
        reduce(create, iArr2);
    }

    public static void squareN(int[] iArr, int i10, int[] iArr2) {
        int[] create = Nat.create(24);
        Nat384.square(iArr, create);
        while (true) {
            reduce(create, iArr2);
            i10--;
            if (i10 > 0) {
                Nat384.square(iArr2, create);
            } else {
                return;
            }
        }
    }

    private static void subPInvFrom(int[] iArr) {
        long j10 = (((long) iArr[0]) & 4294967295L) - 1;
        iArr[0] = (int) j10;
        long j11 = (j10 >> 32) + (((long) iArr[1]) & 4294967295L) + 1;
        iArr[1] = (int) j11;
        long j12 = j11 >> 32;
        if (j12 != 0) {
            long j13 = j12 + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j13;
            j12 = j13 >> 32;
        }
        long j14 = j12 + ((((long) iArr[3]) & 4294967295L) - 1);
        iArr[3] = (int) j14;
        long j15 = (j14 >> 32) + ((4294967295L & ((long) iArr[4])) - 1);
        iArr[4] = (int) j15;
        if ((j15 >> 32) != 0) {
            Nat.decAt(12, iArr, 5);
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.sub(12, iArr, iArr2, iArr3) != 0) {
            subPInvFrom(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.sub(24, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = PExtInv;
            if (Nat.subFrom(iArr4.length, iArr4, iArr3) != 0) {
                Nat.decAt(24, iArr3, iArr4.length);
            }
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (Nat.shiftUpBit(12, iArr, 0, iArr2) != 0 || (iArr2[11] == -1 && Nat.gte(12, iArr2, P))) {
            addPInvTo(iArr2);
        }
    }
}
