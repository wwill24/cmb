package org.bouncycastle.math.ec.rfc7748;

import com.google.android.gms.common.api.a;
import org.bouncycastle.math.raw.Mod;

public abstract class X25519Field {
    private static final int M24 = 16777215;
    private static final int M25 = 33554431;
    private static final int M26 = 67108863;
    private static final int[] P32 = {-19, -1, -1, -1, -1, -1, -1, a.e.API_PRIORITY_OTHER};
    private static final int[] ROOT_NEG_ONE = {34513072, 59165138, 4688974, 3500415, 6194736, 33281959, 54535759, 32551604, 163342, 5703241};
    public static final int SIZE = 10;

    protected X25519Field() {
    }

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i10 = 0; i10 < 10; i10++) {
            iArr3[i10] = iArr[i10] + iArr2[i10];
        }
    }

    public static void addOne(int[] iArr) {
        iArr[0] = iArr[0] + 1;
    }

    public static void addOne(int[] iArr, int i10) {
        iArr[i10] = iArr[i10] + 1;
    }

    public static void apm(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        for (int i10 = 0; i10 < 10; i10++) {
            int i11 = iArr[i10];
            int i12 = iArr2[i10];
            iArr3[i10] = i11 + i12;
            iArr4[i10] = i11 - i12;
        }
    }

    public static int areEqual(int[] iArr, int[] iArr2) {
        int i10 = 0;
        for (int i11 = 0; i11 < 10; i11++) {
            i10 |= iArr[i11] ^ iArr2[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static boolean areEqualVar(int[] iArr, int[] iArr2) {
        return areEqual(iArr, iArr2) != 0;
    }

    public static void carry(int[] iArr) {
        int i10 = iArr[0];
        int i11 = iArr[1];
        int i12 = iArr[2];
        int i13 = iArr[3];
        int i14 = iArr[4];
        int i15 = iArr[5];
        int i16 = iArr[6];
        int i17 = iArr[7];
        int i18 = iArr[8];
        int i19 = iArr[9];
        int i20 = i12 + (i11 >> 26);
        int i21 = i11 & M26;
        int i22 = i14 + (i13 >> 26);
        int i23 = i13 & M26;
        int i24 = i17 + (i16 >> 26);
        int i25 = i16 & M26;
        int i26 = i19 + (i18 >> 26);
        int i27 = i18 & M26;
        int i28 = i23 + (i20 >> 25);
        int i29 = i20 & M25;
        int i30 = i15 + (i22 >> 25);
        int i31 = i22 & M25;
        int i32 = i27 + (i24 >> 25);
        int i33 = i24 & M25;
        int i34 = i10 + ((i26 >> 25) * 38);
        int i35 = i26 & M25;
        int i36 = i21 + (i34 >> 26);
        int i37 = i34 & M26;
        int i38 = i25 + (i30 >> 26);
        int i39 = i30 & M26;
        int i40 = i29 + (i36 >> 26);
        int i41 = i36 & M26;
        int i42 = i31 + (i28 >> 26);
        int i43 = i28 & M26;
        int i44 = i33 + (i38 >> 26);
        int i45 = i38 & M26;
        int i46 = i32 & M26;
        iArr[0] = i37;
        iArr[1] = i41;
        iArr[2] = i40;
        iArr[3] = i43;
        iArr[4] = i42;
        iArr[5] = i39;
        iArr[6] = i45;
        iArr[7] = i44;
        iArr[8] = i46;
        iArr[9] = i35 + (i32 >> 26);
    }

    public static void cmov(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        for (int i13 = 0; i13 < 10; i13++) {
            int i14 = i12 + i13;
            int i15 = iArr2[i14];
            iArr2[i14] = i15 ^ ((iArr[i11 + i13] ^ i15) & i10);
        }
    }

    public static void cnegate(int i10, int[] iArr) {
        int i11 = 0 - i10;
        for (int i12 = 0; i12 < 10; i12++) {
            iArr[i12] = (iArr[i12] ^ i11) - i11;
        }
    }

    public static void copy(int[] iArr, int i10, int[] iArr2, int i11) {
        for (int i12 = 0; i12 < 10; i12++) {
            iArr2[i11 + i12] = iArr[i10 + i12];
        }
    }

    public static int[] create() {
        return new int[10];
    }

    public static int[] createTable(int i10) {
        return new int[(i10 * 10)];
    }

    public static void cswap(int i10, int[] iArr, int[] iArr2) {
        int i11 = 0 - i10;
        for (int i12 = 0; i12 < 10; i12++) {
            int i13 = iArr[i12];
            int i14 = iArr2[i12];
            int i15 = (i13 ^ i14) & i11;
            iArr[i12] = i13 ^ i15;
            iArr2[i12] = i14 ^ i15;
        }
    }

    public static void decode(byte[] bArr, int i10, int[] iArr) {
        decode128(bArr, i10, iArr, 0);
        decode128(bArr, i10 + 16, iArr, 5);
        iArr[9] = iArr[9] & M24;
    }

    public static void decode(int[] iArr, int i10, int[] iArr2) {
        decode128(iArr, i10, iArr2, 0);
        decode128(iArr, i10 + 4, iArr2, 5);
        iArr2[9] = iArr2[9] & M24;
    }

    private static void decode128(byte[] bArr, int i10, int[] iArr, int i11) {
        int decode32 = decode32(bArr, i10 + 0);
        int decode322 = decode32(bArr, i10 + 4);
        int decode323 = decode32(bArr, i10 + 8);
        int decode324 = decode32(bArr, i10 + 12);
        iArr[i11 + 0] = decode32 & M26;
        iArr[i11 + 1] = ((decode32 >>> 26) | (decode322 << 6)) & M26;
        iArr[i11 + 2] = ((decode323 << 12) | (decode322 >>> 20)) & M25;
        iArr[i11 + 3] = ((decode324 << 19) | (decode323 >>> 13)) & M26;
        iArr[i11 + 4] = decode324 >>> 7;
    }

    private static void decode128(int[] iArr, int i10, int[] iArr2, int i11) {
        int i12 = iArr[i10 + 0];
        int i13 = iArr[i10 + 1];
        int i14 = iArr[i10 + 2];
        int i15 = iArr[i10 + 3];
        iArr2[i11 + 0] = i12 & M26;
        iArr2[i11 + 1] = ((i12 >>> 26) | (i13 << 6)) & M26;
        iArr2[i11 + 2] = ((i14 << 12) | (i13 >>> 20)) & M25;
        iArr2[i11 + 3] = ((i15 << 19) | (i14 >>> 13)) & M26;
        iArr2[i11 + 4] = i15 >>> 7;
    }

    private static int decode32(byte[] bArr, int i10) {
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        return (bArr[i12 + 1] << 24) | (bArr[i10] & 255) | ((bArr[i11] & 255) << 8) | ((bArr[i12] & 255) << Tnaf.POW_2_WIDTH);
    }

    public static void encode(int[] iArr, byte[] bArr, int i10) {
        encode128(iArr, 0, bArr, i10);
        encode128(iArr, 5, bArr, i10 + 16);
    }

    public static void encode(int[] iArr, int[] iArr2, int i10) {
        encode128(iArr, 0, iArr2, i10);
        encode128(iArr, 5, iArr2, i10 + 4);
    }

    private static void encode128(int[] iArr, int i10, byte[] bArr, int i11) {
        int i12 = iArr[i10 + 0];
        int i13 = iArr[i10 + 1];
        int i14 = iArr[i10 + 2];
        int i15 = iArr[i10 + 3];
        int i16 = iArr[i10 + 4];
        encode32((i13 << 26) | i12, bArr, i11 + 0);
        encode32((i13 >>> 6) | (i14 << 20), bArr, i11 + 4);
        encode32((i14 >>> 12) | (i15 << 13), bArr, i11 + 8);
        encode32((i16 << 7) | (i15 >>> 19), bArr, i11 + 12);
    }

    private static void encode128(int[] iArr, int i10, int[] iArr2, int i11) {
        int i12 = iArr[i10 + 0];
        int i13 = iArr[i10 + 1];
        int i14 = iArr[i10 + 2];
        int i15 = iArr[i10 + 3];
        int i16 = iArr[i10 + 4];
        iArr2[i11 + 0] = i12 | (i13 << 26);
        iArr2[i11 + 1] = (i13 >>> 6) | (i14 << 20);
        iArr2[i11 + 2] = (i14 >>> 12) | (i15 << 13);
        iArr2[i11 + 3] = (i16 << 7) | (i15 >>> 19);
    }

    private static void encode32(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        int i12 = i11 + 1;
        bArr[i12] = (byte) (i10 >>> 8);
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i10 >>> 16);
        bArr[i13 + 1] = (byte) (i10 >>> 24);
    }

    public static void inv(int[] iArr, int[] iArr2) {
        int[] create = create();
        int[] iArr3 = new int[8];
        copy(iArr, 0, create, 0);
        normalize(create);
        encode(create, iArr3, 0);
        Mod.modOddInverse(P32, iArr3, iArr3);
        decode(iArr3, 0, iArr2);
    }

    public static void invVar(int[] iArr, int[] iArr2) {
        int[] create = create();
        int[] iArr3 = new int[8];
        copy(iArr, 0, create, 0);
        normalize(create);
        encode(create, iArr3, 0);
        Mod.modOddInverseVar(P32, iArr3, iArr3);
        decode(iArr3, 0, iArr2);
    }

    public static int isOne(int[] iArr) {
        int i10 = iArr[0] ^ 1;
        for (int i11 = 1; i11 < 10; i11++) {
            i10 |= iArr[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static boolean isOneVar(int[] iArr) {
        return isOne(iArr) != 0;
    }

    public static int isZero(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 10; i11++) {
            i10 |= iArr[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static boolean isZeroVar(int[] iArr) {
        return isZero(iArr) != 0;
    }

    public static void mul(int[] iArr, int i10, int[] iArr2) {
        int i11 = iArr[0];
        int i12 = iArr[1];
        int i13 = iArr[2];
        int i14 = iArr[3];
        int i15 = iArr[4];
        int i16 = iArr[5];
        int i17 = iArr[6];
        int i18 = iArr[7];
        int i19 = iArr[8];
        int i20 = iArr[9];
        long j10 = (long) i10;
        long j11 = ((long) i13) * j10;
        int i21 = ((int) j11) & M25;
        long j12 = ((long) i15) * j10;
        int i22 = ((int) j12) & M25;
        long j13 = ((long) i18) * j10;
        int i23 = ((int) j13) & M25;
        long j14 = ((long) i20) * j10;
        int i24 = ((int) j14) & M25;
        long j15 = ((j14 >> 25) * 38) + (((long) i11) * j10);
        iArr2[0] = ((int) j15) & M26;
        long j16 = (j12 >> 25) + (((long) i16) * j10);
        iArr2[5] = ((int) j16) & M26;
        long j17 = (j15 >> 26) + (((long) i12) * j10);
        iArr2[1] = ((int) j17) & M26;
        long j18 = (j11 >> 25) + (((long) i14) * j10);
        iArr2[3] = ((int) j18) & M26;
        long j19 = (j16 >> 26) + (((long) i17) * j10);
        iArr2[6] = ((int) j19) & M26;
        long j20 = (j13 >> 25) + (((long) i19) * j10);
        iArr2[8] = ((int) j20) & M26;
        iArr2[2] = i21 + ((int) (j17 >> 26));
        iArr2[4] = i22 + ((int) (j18 >> 26));
        iArr2[7] = i23 + ((int) (j19 >> 26));
        iArr2[9] = i24 + ((int) (j20 >> 26));
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        int i10 = iArr[0];
        int i11 = iArr2[0];
        int i12 = iArr[1];
        int i13 = iArr2[1];
        int i14 = iArr[2];
        int i15 = iArr2[2];
        int i16 = iArr[3];
        int i17 = iArr2[3];
        int i18 = iArr[4];
        int i19 = iArr2[4];
        int i20 = iArr[5];
        int i21 = iArr2[5];
        int i22 = iArr[6];
        int i23 = iArr2[6];
        int i24 = iArr[7];
        int i25 = iArr2[7];
        int i26 = i24;
        int i27 = iArr[8];
        int i28 = iArr2[8];
        int i29 = iArr[9];
        int i30 = i20;
        long j10 = (long) i10;
        int i31 = iArr2[9];
        long j11 = (long) i11;
        long j12 = j10 * j11;
        int i32 = i11;
        int i33 = i25;
        long j13 = (long) i13;
        int i34 = i13;
        long j14 = (long) i12;
        long j15 = (j10 * j13) + (j14 * j11);
        int i35 = i19;
        int i36 = i22;
        long j16 = (long) i15;
        int i37 = i15;
        long j17 = (long) i14;
        long j18 = (j10 * j16) + (j14 * j13) + (j17 * j11);
        long j19 = j13;
        long j20 = (long) i17;
        long j21 = j10 * j20;
        long j22 = j20;
        long j23 = (long) i16;
        long j24 = (((j14 * j16) + (j17 * j13)) << 1) + j21 + (j23 * j11);
        int i38 = i17;
        long j25 = j16;
        long j26 = (long) i35;
        long j27 = (j10 * j26) + (j14 * j22) + (j23 * j19);
        long j28 = j23;
        int i39 = i18;
        long j29 = (long) i39;
        long j30 = ((j17 * j16) << 1) + j27 + (j11 * j29);
        long j31 = (((j17 * j26) + (j29 * j25)) << 1) + (j28 * j22);
        long j32 = (j28 * j26) + (j29 * j22);
        int i40 = i30;
        long j33 = (long) i40;
        int i41 = i16;
        int i42 = i21;
        long j34 = (long) i42;
        long j35 = j33 * j34;
        int i43 = i42;
        int i44 = i14;
        int i45 = i23;
        int i46 = i12;
        long j36 = (long) i45;
        int i47 = i45;
        int i48 = i40;
        long j37 = (long) i36;
        long j38 = (j33 * j36) + (j37 * j34);
        long j39 = j32;
        long j40 = (long) i33;
        long j41 = j31;
        long j42 = (long) i26;
        long j43 = (j33 * j40) + (j37 * j36) + (j42 * j34);
        long j44 = ((((j14 * j26) + (j17 * j22)) + (j28 * j25)) + (j29 * j19)) << 1;
        long j45 = (long) i28;
        long j46 = j36;
        int i49 = i48;
        long j47 = (long) i27;
        long j48 = (((j37 * j40) + (j42 * j36)) << 1) + (j33 * j45) + (j47 * j34);
        long j49 = j40;
        long j50 = (long) i31;
        long j51 = (j33 * j50) + (j37 * j45) + (j47 * j46);
        long j52 = j47;
        int i50 = i29;
        long j53 = (long) i50;
        long j54 = ((j42 * j40) << 1) + j51 + (j34 * j53);
        long j55 = (j37 * j50) + (j42 * j45) + (j52 * j49) + (j53 * j46);
        long j56 = j12 - (j55 * 76);
        long j57 = j15 - (((((j42 * j50) + (j53 * j49)) << 1) + (j52 * j45)) * 38);
        long j58 = j18 - (((j52 * j50) + (j45 * j53)) * 38);
        long j59 = j24 - ((j53 * j50) * 76);
        int i51 = i44 + i26;
        long j60 = j39 - j43;
        int i52 = i38 + i28;
        int i53 = i39 + i50;
        int i54 = i35 + i31;
        long j61 = (long) (i10 + i49);
        long j62 = j44 - j35;
        long j63 = (long) (i32 + i43);
        long j64 = j61 * j63;
        long j65 = ((j29 * j26) << 1) - j48;
        long j66 = (long) (i34 + i47);
        long j67 = (long) (i46 + i36);
        long j68 = (j61 * j66) + (j67 * j63);
        int i55 = i53;
        long j69 = (long) (i37 + i33);
        int i56 = i55;
        long j70 = (long) i51;
        long j71 = j66;
        long j72 = (long) i52;
        long j73 = j72;
        long j74 = (long) (i41 + i27);
        long j75 = (((j67 * j69) + (j70 * j66)) << 1) + (j61 * j72) + (j74 * j63);
        long j76 = j69;
        long j77 = (long) i54;
        long j78 = (long) i56;
        long j79 = (((j70 * j77) + (j78 * j76)) << 1) + (j74 * j73);
        long j80 = j65 + (j75 - j59);
        int i57 = ((int) j80) & M26;
        long j81 = (j80 >> 26) + (((((j70 * j69) << 1) + ((((j61 * j77) + (j67 * j73)) + (j74 * j71)) + (j63 * j78))) - j30) - j54);
        int i58 = ((int) j81) & M25;
        long j82 = j56 + ((((j81 >> 25) + (((((j67 * j77) + (j70 * j73)) + (j74 * j76)) + (j78 * j71)) << 1)) - j62) * 38);
        iArr3[0] = ((int) j82) & M26;
        long j83 = j41 - j38;
        long j84 = (j82 >> 26) + j57 + ((j79 - j83) * 38);
        iArr3[1] = ((int) j84) & M26;
        long j85 = (j84 >> 26) + j58 + ((((j74 * j77) + (j78 * j73)) - j60) * 38);
        iArr3[2] = ((int) j85) & M25;
        long j86 = (j85 >> 25) + j59 + ((((j78 * j77) << 1) - j65) * 38);
        iArr3[3] = ((int) j86) & M26;
        long j87 = (j86 >> 26) + j30 + (j54 * 38);
        iArr3[4] = ((int) j87) & M25;
        long j88 = (j87 >> 25) + j62 + (j64 - j56);
        iArr3[5] = ((int) j88) & M26;
        long j89 = (j88 >> 26) + j83 + (j68 - j57);
        iArr3[6] = ((int) j89) & M26;
        long j90 = (j89 >> 26) + j60 + ((((j61 * j69) + (j67 * j66)) + (j70 * j63)) - j58);
        iArr3[7] = ((int) j90) & M25;
        long j91 = (j90 >> 25) + ((long) i57);
        iArr3[8] = ((int) j91) & M26;
        iArr3[9] = i58 + ((int) (j91 >> 26));
    }

    public static void negate(int[] iArr, int[] iArr2) {
        for (int i10 = 0; i10 < 10; i10++) {
            iArr2[i10] = -iArr[i10];
        }
    }

    public static void normalize(int[] iArr) {
        int i10 = (iArr[9] >>> 23) & 1;
        reduce(iArr, i10);
        reduce(iArr, -i10);
    }

    public static void one(int[] iArr) {
        iArr[0] = 1;
        for (int i10 = 1; i10 < 10; i10++) {
            iArr[i10] = 0;
        }
    }

    private static void powPm5d8(int[] iArr, int[] iArr2, int[] iArr3) {
        sqr(iArr, iArr2);
        mul(iArr, iArr2, iArr2);
        int[] create = create();
        sqr(iArr2, create);
        mul(iArr, create, create);
        sqr(create, 2, create);
        mul(iArr2, create, create);
        int[] create2 = create();
        sqr(create, 5, create2);
        mul(create, create2, create2);
        int[] create3 = create();
        sqr(create2, 5, create3);
        mul(create, create3, create3);
        sqr(create3, 10, create);
        mul(create2, create, create);
        sqr(create, 25, create2);
        mul(create, create2, create2);
        sqr(create2, 25, create3);
        mul(create, create3, create3);
        sqr(create3, 50, create);
        mul(create2, create, create);
        sqr(create, 125, create2);
        mul(create, create2, create2);
        sqr(create2, 2, create);
        mul(create, iArr, iArr3);
    }

    private static void reduce(int[] iArr, int i10) {
        int i11 = iArr[9];
        int i12 = M24 & i11;
        long j10 = ((long) (((i11 >> 24) + i10) * 19)) + ((long) iArr[0]);
        iArr[0] = ((int) j10) & M26;
        long j11 = (j10 >> 26) + ((long) iArr[1]);
        iArr[1] = ((int) j11) & M26;
        long j12 = (j11 >> 26) + ((long) iArr[2]);
        iArr[2] = ((int) j12) & M25;
        long j13 = (j12 >> 25) + ((long) iArr[3]);
        iArr[3] = ((int) j13) & M26;
        long j14 = (j13 >> 26) + ((long) iArr[4]);
        iArr[4] = ((int) j14) & M25;
        long j15 = (j14 >> 25) + ((long) iArr[5]);
        iArr[5] = ((int) j15) & M26;
        long j16 = (j15 >> 26) + ((long) iArr[6]);
        iArr[6] = ((int) j16) & M26;
        long j17 = (j16 >> 26) + ((long) iArr[7]);
        iArr[7] = M25 & ((int) j17);
        long j18 = (j17 >> 25) + ((long) iArr[8]);
        iArr[8] = M26 & ((int) j18);
        iArr[9] = i12 + ((int) (j18 >> 26));
    }

    public static void sqr(int[] iArr, int i10, int[] iArr2) {
        sqr(iArr, iArr2);
        while (true) {
            i10--;
            if (i10 > 0) {
                sqr(iArr2, iArr2);
            } else {
                return;
            }
        }
    }

    public static void sqr(int[] iArr, int[] iArr2) {
        int i10 = iArr[0];
        int i11 = iArr[1];
        int i12 = iArr[2];
        int i13 = iArr[3];
        int i14 = iArr[4];
        int i15 = iArr[5];
        int i16 = iArr[6];
        int i17 = iArr[7];
        long j10 = (long) i10;
        long j11 = j10 * j10;
        long j12 = (long) (i11 * 2);
        long j13 = j10 * j12;
        long j14 = (long) (i12 * 2);
        int i18 = iArr[8];
        int i19 = i11;
        int i20 = i17;
        long j15 = (long) i19;
        long j16 = (j10 * j14) + (j15 * j15);
        int i21 = iArr[9];
        int i22 = i16;
        long j17 = (long) (i13 * 2);
        long j18 = (j12 * j14) + (j10 * j17);
        int i23 = i19;
        int i24 = i14;
        long j19 = (long) (i14 * 2);
        long j20 = (((long) i12) * j14) + (j10 * j19) + (j15 * j17);
        long j21 = (j12 * j19) + (j17 * j14);
        long j22 = (long) i13;
        long j23 = (j14 * j19) + (j22 * j22);
        long j24 = ((long) i24) * j19;
        long j25 = j20;
        int i25 = i15;
        int i26 = i24;
        long j26 = (long) i25;
        long j27 = j26 * j26;
        int i27 = i25;
        long j28 = (long) (i22 * 2);
        long j29 = j26 * j28;
        long j30 = j24;
        long j31 = (long) (i20 * 2);
        long j32 = j22 * j19;
        long j33 = (long) i22;
        long j34 = (j26 * j31) + (j33 * j33);
        long j35 = (long) (i18 * 2);
        long j36 = (j28 * j31) + (j26 * j35);
        long j37 = j23;
        long j38 = (long) (i21 * 2);
        long j39 = (((long) i20) * j31) + (j26 * j38) + (j33 * j35);
        long j40 = (j28 * j38) + (j35 * j31);
        int i28 = i18;
        long j41 = (long) i28;
        int i29 = i21;
        long j42 = j11 - (j40 * 38);
        long j43 = j13 - (((j31 * j38) + (j41 * j41)) * 38);
        long j44 = j16 - ((j41 * j38) * 38);
        long j45 = j18 - ((((long) i29) * j38) * 38);
        long j46 = j21 - j27;
        long j47 = j30 - j36;
        int i30 = i10 + i27;
        int i31 = i23 + i22;
        int i32 = i12 + i20;
        int i33 = i13 + i28;
        int i34 = i26 + i29;
        long j48 = j32 - j34;
        long j49 = j37 - j29;
        long j50 = j46;
        long j51 = (long) i30;
        long j52 = j51 * j51;
        long j53 = j39;
        long j54 = (long) (i31 * 2);
        long j55 = j51 * j54;
        long j56 = (long) (i32 * 2);
        long j57 = (long) i31;
        long j58 = (j51 * j56) + (j57 * j57);
        long j59 = j47;
        long j60 = (long) (i33 * 2);
        int i35 = i33;
        long j61 = (long) (i34 * 2);
        long j62 = (j54 * j61) + (j60 * j56);
        long j63 = (long) i35;
        long j64 = (j56 * j61) + (j63 * j63);
        long j65 = j63 * j61;
        long j66 = ((long) i34) * j61;
        long j67 = j59 + (((j54 * j56) + (j51 * j60)) - j45);
        int i36 = ((int) j67) & M26;
        long j68 = (j67 >> 26) + (((((((long) i32) * j56) + (j51 * j61)) + (j57 * j60)) - j25) - j53);
        int i37 = ((int) j68) & M25;
        long j69 = j42 + ((((j68 >> 25) + j62) - j50) * 38);
        iArr2[0] = ((int) j69) & M26;
        long j70 = (j69 >> 26) + j43 + ((j64 - j49) * 38);
        iArr2[1] = ((int) j70) & M26;
        long j71 = (j70 >> 26) + j44 + ((j65 - j48) * 38);
        iArr2[2] = ((int) j71) & M25;
        long j72 = (j71 >> 25) + j45 + ((j66 - j59) * 38);
        iArr2[3] = ((int) j72) & M26;
        long j73 = (j72 >> 26) + j25 + (38 * j53);
        iArr2[4] = ((int) j73) & M25;
        long j74 = (j73 >> 25) + j50 + (j52 - j42);
        iArr2[5] = ((int) j74) & M26;
        long j75 = (j74 >> 26) + j49 + (j55 - j43);
        iArr2[6] = ((int) j75) & M26;
        long j76 = (j75 >> 26) + j48 + (j58 - j44);
        iArr2[7] = ((int) j76) & M25;
        long j77 = (j76 >> 25) + ((long) i36);
        iArr2[8] = ((int) j77) & M26;
        iArr2[9] = i37 + ((int) (j77 >> 26));
    }

    public static boolean sqrtRatioVar(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = create();
        int[] create2 = create();
        mul(iArr, iArr2, create);
        sqr(iArr2, create2);
        mul(create, create2, create);
        sqr(create2, create2);
        mul(create2, create, create2);
        int[] create3 = create();
        int[] create4 = create();
        powPm5d8(create2, create3, create4);
        mul(create4, create, create4);
        int[] create5 = create();
        sqr(create4, create5);
        mul(create5, iArr2, create5);
        sub(create5, iArr, create3);
        normalize(create3);
        if (isZeroVar(create3)) {
            copy(create4, 0, iArr3, 0);
            return true;
        }
        add(create5, iArr, create3);
        normalize(create3);
        if (!isZeroVar(create3)) {
            return false;
        }
        mul(create4, ROOT_NEG_ONE, iArr3);
        return true;
    }

    public static void sub(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i10 = 0; i10 < 10; i10++) {
            iArr3[i10] = iArr[i10] - iArr2[i10];
        }
    }

    public static void subOne(int[] iArr) {
        iArr[0] = iArr[0] - 1;
    }

    public static void zero(int[] iArr) {
        for (int i10 = 0; i10 < 10; i10++) {
            iArr[i10] = 0;
        }
    }
}
