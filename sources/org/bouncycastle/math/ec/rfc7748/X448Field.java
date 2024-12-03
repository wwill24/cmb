package org.bouncycastle.math.ec.rfc7748;

import org.bouncycastle.math.raw.Mod;

public abstract class X448Field {
    private static final int M28 = 268435455;
    private static final int[] P32 = {-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};
    public static final int SIZE = 16;
    private static final long U32 = 4294967295L;

    protected X448Field() {
    }

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i10 = 0; i10 < 16; i10++) {
            iArr3[i10] = iArr[i10] + iArr2[i10];
        }
    }

    public static void addOne(int[] iArr) {
        iArr[0] = iArr[0] + 1;
    }

    public static void addOne(int[] iArr, int i10) {
        iArr[i10] = iArr[i10] + 1;
    }

    public static int areEqual(int[] iArr, int[] iArr2) {
        int i10 = 0;
        for (int i11 = 0; i11 < 16; i11++) {
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
        int i20 = iArr[10];
        int i21 = iArr[11];
        int i22 = iArr[12];
        int i23 = iArr[13];
        int i24 = iArr[14];
        int i25 = iArr[15];
        int i26 = i11 + (i10 >>> 28);
        int i27 = i10 & M28;
        int i28 = i15 + (i14 >>> 28);
        int i29 = i14 & M28;
        int i30 = i19 + (i18 >>> 28);
        int i31 = i18 & M28;
        int i32 = i23 + (i22 >>> 28);
        int i33 = i22 & M28;
        int i34 = i12 + (i26 >>> 28);
        int i35 = i26 & M28;
        int i36 = i16 + (i28 >>> 28);
        int i37 = i28 & M28;
        int i38 = i20 + (i30 >>> 28);
        int i39 = i30 & M28;
        int i40 = i24 + (i32 >>> 28);
        int i41 = i32 & M28;
        int i42 = i13 + (i34 >>> 28);
        int i43 = i34 & M28;
        int i44 = i17 + (i36 >>> 28);
        int i45 = i36 & M28;
        int i46 = i21 + (i38 >>> 28);
        int i47 = i38 & M28;
        int i48 = i25 + (i40 >>> 28);
        int i49 = i40 & M28;
        int i50 = i48 >>> 28;
        int i51 = i48 & M28;
        int i52 = i27 + i50;
        int i53 = i29 + (i42 >>> 28);
        int i54 = i42 & M28;
        int i55 = i31 + i50 + (i44 >>> 28);
        int i56 = i44 & M28;
        int i57 = i33 + (i46 >>> 28);
        int i58 = i46 & M28;
        int i59 = i35 + (i52 >>> 28);
        int i60 = i52 & M28;
        int i61 = i37 + (i53 >>> 28);
        int i62 = i53 & M28;
        int i63 = i39 + (i55 >>> 28);
        int i64 = i55 & M28;
        int i65 = i57 & M28;
        iArr[0] = i60;
        iArr[1] = i59;
        iArr[2] = i43;
        iArr[3] = i54;
        iArr[4] = i62;
        iArr[5] = i61;
        iArr[6] = i45;
        iArr[7] = i56;
        iArr[8] = i64;
        iArr[9] = i63;
        iArr[10] = i47;
        iArr[11] = i58;
        iArr[12] = i65;
        iArr[13] = i41 + (i57 >>> 28);
        iArr[14] = i49;
        iArr[15] = i51;
    }

    public static void cmov(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        for (int i13 = 0; i13 < 16; i13++) {
            int i14 = i12 + i13;
            int i15 = iArr2[i14];
            iArr2[i14] = i15 ^ ((iArr[i11 + i13] ^ i15) & i10);
        }
    }

    public static void cnegate(int i10, int[] iArr) {
        int[] create = create();
        sub(create, iArr, create);
        cmov(-i10, create, 0, iArr, 0);
    }

    public static void copy(int[] iArr, int i10, int[] iArr2, int i11) {
        for (int i12 = 0; i12 < 16; i12++) {
            iArr2[i11 + i12] = iArr[i10 + i12];
        }
    }

    public static int[] create() {
        return new int[16];
    }

    public static int[] createTable(int i10) {
        return new int[(i10 * 16)];
    }

    public static void cswap(int i10, int[] iArr, int[] iArr2) {
        int i11 = 0 - i10;
        for (int i12 = 0; i12 < 16; i12++) {
            int i13 = iArr[i12];
            int i14 = iArr2[i12];
            int i15 = (i13 ^ i14) & i11;
            iArr[i12] = i13 ^ i15;
            iArr2[i12] = i14 ^ i15;
        }
    }

    public static void decode(byte[] bArr, int i10, int[] iArr) {
        decode56(bArr, i10, iArr, 0);
        decode56(bArr, i10 + 7, iArr, 2);
        decode56(bArr, i10 + 14, iArr, 4);
        decode56(bArr, i10 + 21, iArr, 6);
        decode56(bArr, i10 + 28, iArr, 8);
        decode56(bArr, i10 + 35, iArr, 10);
        decode56(bArr, i10 + 42, iArr, 12);
        decode56(bArr, i10 + 49, iArr, 14);
    }

    public static void decode(int[] iArr, int i10, int[] iArr2) {
        decode224(iArr, i10, iArr2, 0);
        decode224(iArr, i10 + 7, iArr2, 8);
    }

    private static void decode224(int[] iArr, int i10, int[] iArr2, int i11) {
        int i12 = iArr[i10 + 0];
        int i13 = iArr[i10 + 1];
        int i14 = iArr[i10 + 2];
        int i15 = iArr[i10 + 3];
        int i16 = iArr[i10 + 4];
        int i17 = iArr[i10 + 5];
        int i18 = iArr[i10 + 6];
        iArr2[i11 + 0] = i12 & M28;
        iArr2[i11 + 1] = ((i12 >>> 28) | (i13 << 4)) & M28;
        iArr2[i11 + 2] = ((i13 >>> 24) | (i14 << 8)) & M28;
        iArr2[i11 + 3] = ((i14 >>> 20) | (i15 << 12)) & M28;
        iArr2[i11 + 4] = ((i15 >>> 16) | (i16 << 16)) & M28;
        iArr2[i11 + 5] = ((i16 >>> 12) | (i17 << 20)) & M28;
        iArr2[i11 + 6] = ((i17 >>> 8) | (i18 << 24)) & M28;
        iArr2[i11 + 7] = i18 >>> 4;
    }

    private static int decode24(byte[] bArr, int i10) {
        int i11 = i10 + 1;
        return ((bArr[i11 + 1] & 255) << Tnaf.POW_2_WIDTH) | (bArr[i10] & 255) | ((bArr[i11] & 255) << 8);
    }

    private static int decode32(byte[] bArr, int i10) {
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        return (bArr[i12 + 1] << 24) | (bArr[i10] & 255) | ((bArr[i11] & 255) << 8) | ((bArr[i12] & 255) << Tnaf.POW_2_WIDTH);
    }

    private static void decode56(byte[] bArr, int i10, int[] iArr, int i11) {
        int decode32 = decode32(bArr, i10);
        int decode24 = decode24(bArr, i10 + 4);
        iArr[i11] = M28 & decode32;
        iArr[i11 + 1] = (decode24 << 4) | (decode32 >>> 28);
    }

    public static void encode(int[] iArr, byte[] bArr, int i10) {
        encode56(iArr, 0, bArr, i10);
        encode56(iArr, 2, bArr, i10 + 7);
        encode56(iArr, 4, bArr, i10 + 14);
        encode56(iArr, 6, bArr, i10 + 21);
        encode56(iArr, 8, bArr, i10 + 28);
        encode56(iArr, 10, bArr, i10 + 35);
        encode56(iArr, 12, bArr, i10 + 42);
        encode56(iArr, 14, bArr, i10 + 49);
    }

    public static void encode(int[] iArr, int[] iArr2, int i10) {
        encode224(iArr, 0, iArr2, i10);
        encode224(iArr, 8, iArr2, i10 + 7);
    }

    private static void encode224(int[] iArr, int i10, int[] iArr2, int i11) {
        int i12 = iArr[i10 + 0];
        int i13 = iArr[i10 + 1];
        int i14 = iArr[i10 + 2];
        int i15 = iArr[i10 + 3];
        int i16 = iArr[i10 + 4];
        int i17 = iArr[i10 + 5];
        int i18 = iArr[i10 + 6];
        int i19 = iArr[i10 + 7];
        iArr2[i11 + 0] = i12 | (i13 << 28);
        iArr2[i11 + 1] = (i13 >>> 4) | (i14 << 24);
        iArr2[i11 + 2] = (i14 >>> 8) | (i15 << 20);
        iArr2[i11 + 3] = (i15 >>> 12) | (i16 << 16);
        iArr2[i11 + 4] = (i16 >>> 16) | (i17 << 12);
        iArr2[i11 + 5] = (i17 >>> 20) | (i18 << 8);
        iArr2[i11 + 6] = (i19 << 4) | (i18 >>> 24);
    }

    private static void encode24(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        int i12 = i11 + 1;
        bArr[i12] = (byte) (i10 >>> 8);
        bArr[i12 + 1] = (byte) (i10 >>> 16);
    }

    private static void encode32(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        int i12 = i11 + 1;
        bArr[i12] = (byte) (i10 >>> 8);
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i10 >>> 16);
        bArr[i13 + 1] = (byte) (i10 >>> 24);
    }

    private static void encode56(int[] iArr, int i10, byte[] bArr, int i11) {
        int i12 = iArr[i10];
        int i13 = iArr[i10 + 1];
        encode32((i13 << 28) | i12, bArr, i11);
        encode24(i13 >>> 4, bArr, i11 + 4);
    }

    public static void inv(int[] iArr, int[] iArr2) {
        int[] create = create();
        int[] iArr3 = new int[14];
        copy(iArr, 0, create, 0);
        normalize(create);
        encode(create, iArr3, 0);
        Mod.modOddInverse(P32, iArr3, iArr3);
        decode(iArr3, 0, iArr2);
    }

    public static void invVar(int[] iArr, int[] iArr2) {
        int[] create = create();
        int[] iArr3 = new int[14];
        copy(iArr, 0, create, 0);
        normalize(create);
        encode(create, iArr3, 0);
        Mod.modOddInverseVar(P32, iArr3, iArr3);
        decode(iArr3, 0, iArr2);
    }

    public static int isOne(int[] iArr) {
        int i10 = iArr[0] ^ 1;
        for (int i11 = 1; i11 < 16; i11++) {
            i10 |= iArr[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static boolean isOneVar(int[] iArr) {
        return isOne(iArr) != 0;
    }

    public static int isZero(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 16; i11++) {
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
        int i21 = iArr[10];
        int i22 = iArr[11];
        int i23 = iArr[12];
        int i24 = iArr[13];
        int i25 = iArr[14];
        int i26 = i15;
        long j10 = (long) i12;
        long j11 = (long) i10;
        long j12 = j10 * j11;
        int i27 = i11;
        int i28 = i23;
        long j13 = ((long) i16) * j11;
        int i29 = ((int) j12) & M28;
        long j14 = ((long) i20) * j11;
        int i30 = ((int) j13) & M28;
        long j15 = ((long) i24) * j11;
        int i31 = ((int) j14) & M28;
        int i32 = ((int) j15) & M28;
        long j16 = (j12 >>> 28) + (((long) i13) * j11);
        iArr2[2] = ((int) j16) & M28;
        long j17 = j16 >>> 28;
        long j18 = (j13 >>> 28) + (((long) i17) * j11);
        iArr2[6] = ((int) j18) & M28;
        long j19 = (j14 >>> 28) + (((long) i21) * j11);
        iArr2[10] = ((int) j19) & M28;
        long j20 = (j15 >>> 28) + (((long) i25) * j11);
        iArr2[14] = ((int) j20) & M28;
        long j21 = j17 + (((long) i14) * j11);
        iArr2[3] = ((int) j21) & M28;
        long j22 = (j18 >>> 28) + (((long) i18) * j11);
        iArr2[7] = ((int) j22) & M28;
        long j23 = (j19 >>> 28) + (((long) i22) * j11);
        iArr2[11] = ((int) j23) & M28;
        long j24 = (j20 >>> 28) + (((long) iArr[15]) * j11);
        iArr2[15] = ((int) j24) & M28;
        long j25 = j24 >>> 28;
        long j26 = (j21 >>> 28) + (((long) i26) * j11);
        iArr2[4] = ((int) j26) & M28;
        long j27 = (j22 >>> 28) + j25 + (((long) i19) * j11);
        iArr2[8] = ((int) j27) & M28;
        long j28 = (j23 >>> 28) + (((long) i28) * j11);
        iArr2[12] = ((int) j28) & M28;
        long j29 = j25 + (((long) i27) * j11);
        iArr2[0] = ((int) j29) & M28;
        iArr2[1] = i29 + ((int) (j29 >>> 28));
        iArr2[5] = i30 + ((int) (j26 >>> 28));
        iArr2[9] = i31 + ((int) (j27 >>> 28));
        iArr2[13] = i32 + ((int) (j28 >>> 28));
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
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
        int i20 = iArr[10];
        int i21 = iArr[11];
        int i22 = iArr[12];
        int i23 = iArr[13];
        int i24 = iArr[14];
        int i25 = i17;
        int i26 = iArr[15];
        int i27 = iArr2[0];
        int i28 = iArr2[1];
        int i29 = iArr2[2];
        int i30 = iArr2[3];
        int i31 = iArr2[4];
        int i32 = iArr2[5];
        int i33 = iArr2[6];
        int i34 = iArr2[7];
        int i35 = iArr2[8];
        int i36 = iArr2[9];
        int i37 = iArr2[10];
        int i38 = iArr2[11];
        int i39 = iArr2[12];
        int i40 = iArr2[13];
        int i41 = iArr2[14];
        int i42 = iArr2[15];
        int i43 = i10 + i18;
        int i44 = i11 + i19;
        int i45 = i12 + i20;
        int i46 = i13 + i21;
        int i47 = i14 + i22;
        int i48 = i15 + i23;
        int i49 = i16 + i24;
        int i50 = i25 + i26;
        int i51 = i28 + i36;
        int i52 = i30 + i38;
        int i53 = i32 + i40;
        int i54 = i34 + i42;
        long j10 = (long) i10;
        int i55 = i18;
        long j11 = (long) i27;
        long j12 = j10 * j11;
        long j13 = j10;
        long j14 = (long) i25;
        long j15 = j11;
        long j16 = (long) i28;
        long j17 = j14 * j16;
        long j18 = j14;
        long j19 = (long) i16;
        long j20 = j16;
        long j21 = (long) i29;
        long j22 = j17 + (j19 * j21);
        long j23 = j19;
        long j24 = (long) i15;
        long j25 = j21;
        long j26 = (long) i30;
        long j27 = j22 + (j24 * j26);
        long j28 = j24;
        long j29 = (long) i14;
        long j30 = j26;
        long j31 = (long) i31;
        long j32 = j27 + (j29 * j31);
        long j33 = j29;
        long j34 = (long) i13;
        long j35 = j31;
        long j36 = (long) i32;
        long j37 = j32 + (j34 * j36);
        long j38 = j34;
        long j39 = (long) i12;
        long j40 = j36;
        long j41 = (long) i33;
        long j42 = j37 + (j39 * j41);
        long j43 = j39;
        long j44 = (long) i11;
        long j45 = j41;
        long j46 = (long) i34;
        long j47 = j42 + (j44 * j46);
        long j48 = j46;
        long j49 = (long) i55;
        long j50 = j44;
        long j51 = (long) i35;
        long j52 = j49 * j51;
        long j53 = j49;
        long j54 = (long) i26;
        long j55 = j51;
        long j56 = (long) i36;
        long j57 = j54 * j56;
        long j58 = (long) i24;
        long j59 = j54;
        long j60 = (long) i37;
        long j61 = j57 + (j58 * j60);
        long j62 = (long) i23;
        long j63 = j58;
        long j64 = (long) i38;
        long j65 = (long) i22;
        long j66 = j62;
        long j67 = (long) i39;
        long j68 = j61 + (j62 * j64) + (j65 * j67);
        long j69 = (long) i21;
        long j70 = j65;
        long j71 = (long) i40;
        long j72 = (long) i20;
        long j73 = j69;
        long j74 = (long) i41;
        long j75 = j68 + (j69 * j71) + (j72 * j74);
        long j76 = j72;
        long j77 = (long) i19;
        long j78 = j74;
        long j79 = (long) i42;
        long j80 = j75 + (j77 * j79);
        long j81 = j79;
        long j82 = (long) i43;
        long j83 = j71;
        long j84 = (long) (i27 + i35);
        long j85 = j82 * j84;
        int i56 = i50;
        long j86 = j82;
        long j87 = (long) i56;
        long j88 = j84;
        long j89 = (long) i51;
        long j90 = j87 * j89;
        long j91 = j87;
        long j92 = (long) i49;
        long j93 = j89;
        long j94 = (long) (i29 + i37);
        long j95 = j90 + (j92 * j94);
        int i57 = i48;
        long j96 = j92;
        long j97 = (long) i57;
        long j98 = j94;
        long j99 = (long) i52;
        long j100 = j95 + (j97 * j99);
        long j101 = j97;
        long j102 = (long) i47;
        long j103 = j99;
        long j104 = (long) (i31 + i39);
        long j105 = j100 + (j102 * j104);
        int i58 = i46;
        long j106 = j102;
        long j107 = (long) i58;
        long j108 = j104;
        long j109 = (long) i53;
        long j110 = j105 + (j107 * j109);
        long j111 = j107;
        long j112 = (long) i45;
        long j113 = j109;
        long j114 = (long) (i33 + i41);
        long j115 = j112;
        long j116 = (long) i44;
        int i59 = i54;
        long j117 = j114;
        long j118 = (long) i59;
        long j119 = j110 + (j112 * j114) + (j116 * j118);
        long j120 = j118;
        long j121 = ((j12 + j52) + j119) - j47;
        long j122 = (j80 + j85) - j12;
        long j123 = j121 >>> 28;
        long j124 = j122 + j119;
        int i60 = ((int) j121) & M28;
        long j125 = (j50 * j15) + (j13 * j20);
        long j126 = j78;
        long j127 = (j116 * j88) + (j86 * j93);
        long j128 = (j91 * j98) + (j96 * j103) + (j101 * j108) + (j106 * j113) + (j111 * j117) + (j115 * j120);
        long j129 = ((j125 + ((j77 * j55) + (j53 * j56))) + j128) - ((((((j18 * j25) + (j23 * j30)) + (j28 * j35)) + (j33 * j40)) + (j38 * j45)) + (j43 * j48));
        long j130 = j116;
        long j131 = j123 + j129;
        int i61 = ((int) j124) & M28;
        long j132 = (j124 >>> 28) + ((((((((j59 * j60) + (j63 * j64)) + (j66 * j67)) + (j70 * j83)) + (j73 * j126)) + (j76 * j81)) + j127) - j125) + j128;
        int i62 = ((int) j131) & M28;
        long j133 = (j43 * j15) + (j50 * j20) + (j13 * j25);
        long j134 = (j91 * j103) + (j96 * j108) + (j101 * j113) + (j106 * j117) + (j111 * j120);
        long j135 = (j131 >>> 28) + (((j133 + (((j76 * j55) + (j77 * j56)) + (j53 * j60))) + j134) - (((((j18 * j30) + (j23 * j35)) + (j28 * j40)) + (j33 * j45)) + (j38 * j48)));
        int i63 = ((int) j132) & M28;
        long j136 = (j132 >>> 28) + (((((((j59 * j64) + (j63 * j67)) + (j66 * j83)) + (j70 * j126)) + (j73 * j81)) + (((j115 * j88) + (j130 * j93)) + (j86 * j98))) - j133) + j134;
        int i64 = ((int) j135) & M28;
        long j137 = (j38 * j15) + (j43 * j20) + (j50 * j25) + (j13 * j30);
        long j138 = (j91 * j108) + (j96 * j113) + (j101 * j117) + (j106 * j120);
        long j139 = (j135 >>> 28) + (((j137 + ((((j73 * j55) + (j76 * j56)) + (j77 * j60)) + (j53 * j64))) + j138) - ((((j18 * j35) + (j23 * j40)) + (j28 * j45)) + (j33 * j48)));
        int i65 = ((int) j136) & M28;
        long j140 = (j136 >>> 28) + ((((((j59 * j67) + (j63 * j83)) + (j66 * j126)) + (j70 * j81)) + ((((j111 * j88) + (j115 * j93)) + (j130 * j98)) + (j86 * j103))) - j137) + j138;
        int i66 = ((int) j139) & M28;
        long j141 = (j33 * j15) + (j38 * j20) + (j43 * j25) + (j50 * j30) + (j13 * j35);
        long j142 = (j91 * j113) + (j96 * j117) + (j101 * j120);
        long j143 = (j139 >>> 28) + (((j141 + (((((j70 * j55) + (j73 * j56)) + (j76 * j60)) + (j77 * j64)) + (j53 * j67))) + j142) - (((j18 * j40) + (j23 * j45)) + (j28 * j48)));
        int i67 = ((int) j140) & M28;
        long j144 = (j140 >>> 28) + (((((j59 * j83) + (j63 * j126)) + (j66 * j81)) + (((((j106 * j88) + (j111 * j93)) + (j115 * j98)) + (j130 * j103)) + (j86 * j108))) - j141) + j142;
        int i68 = ((int) j143) & M28;
        long j145 = (j28 * j15) + (j33 * j20) + (j38 * j25) + (j43 * j30) + (j50 * j35) + (j13 * j40);
        long j146 = (j91 * j117) + (j96 * j120);
        long j147 = (j143 >>> 28) + (((j145 + ((((((j66 * j55) + (j70 * j56)) + (j73 * j60)) + (j76 * j64)) + (j77 * j67)) + (j53 * j83))) + j146) - ((j18 * j45) + (j23 * j48)));
        int i69 = ((int) j144) & M28;
        long j148 = (j144 >>> 28) + ((((j59 * j126) + (j63 * j81)) + ((((((j101 * j88) + (j106 * j93)) + (j111 * j98)) + (j115 * j103)) + (j130 * j108)) + (j86 * j113))) - j145) + j146;
        int i70 = ((int) j147) & M28;
        long j149 = (j23 * j15) + (j28 * j20) + (j33 * j25) + (j38 * j30) + (j43 * j35) + (j50 * j40) + (j13 * j45);
        long j150 = j91 * j120;
        long j151 = (j147 >>> 28) + (((j149 + (((((((j63 * j55) + (j66 * j56)) + (j70 * j60)) + (j73 * j64)) + (j76 * j67)) + (j77 * j83)) + (j53 * j126))) + j150) - (j18 * j48));
        int i71 = ((int) j148) & M28;
        long j152 = (j148 >>> 28) + (((j59 * j81) + (((((((j96 * j88) + (j101 * j93)) + (j106 * j98)) + (j111 * j103)) + (j115 * j108)) + (j130 * j113)) + (j86 * j117))) - j149) + j150;
        int i72 = ((int) j151) & M28;
        int i73 = ((int) j152) & M28;
        long j153 = (j15 * j18) + (j20 * j23) + (j28 * j25) + (j33 * j30) + (j38 * j35) + (j43 * j40) + (j50 * j45) + (j13 * j48);
        long j154 = (j151 >>> 28) + j153 + (j59 * j55) + (j56 * j63) + (j66 * j60) + (j70 * j64) + (j73 * j67) + (j76 * j83) + (j77 * j126) + (j53 * j81);
        int i74 = ((int) j154) & M28;
        long j155 = (j152 >>> 28) + (((((((((j91 * j88) + (j96 * j93)) + (j101 * j98)) + (j106 * j103)) + (j111 * j108)) + (j115 * j113)) + (j130 * j117)) + (j86 * j120)) - j153);
        int i75 = ((int) j155) & M28;
        long j156 = j155 >>> 28;
        long j157 = (j154 >>> 28) + j156 + ((long) i61);
        int i76 = ((int) j157) & M28;
        long j158 = j156 + ((long) i60);
        iArr3[0] = ((int) j158) & M28;
        iArr3[1] = i62 + ((int) (j158 >>> 28));
        iArr3[2] = i64;
        iArr3[3] = i66;
        iArr3[4] = i68;
        iArr3[5] = i70;
        iArr3[6] = i72;
        iArr3[7] = i74;
        iArr3[8] = i76;
        iArr3[9] = i63 + ((int) (j157 >>> 28));
        iArr3[10] = i65;
        iArr3[11] = i67;
        iArr3[12] = i69;
        iArr3[13] = i71;
        iArr3[14] = i73;
        iArr3[15] = i75;
    }

    public static void negate(int[] iArr, int[] iArr2) {
        sub(create(), iArr, iArr2);
    }

    public static void normalize(int[] iArr) {
        reduce(iArr, 1);
        reduce(iArr, -1);
    }

    public static void one(int[] iArr) {
        iArr[0] = 1;
        for (int i10 = 1; i10 < 16; i10++) {
            iArr[i10] = 0;
        }
    }

    private static void powPm3d4(int[] iArr, int[] iArr2) {
        int[] create = create();
        sqr(iArr, create);
        mul(iArr, create, create);
        int[] create2 = create();
        sqr(create, create2);
        mul(iArr, create2, create2);
        int[] create3 = create();
        sqr(create2, 3, create3);
        mul(create2, create3, create3);
        int[] create4 = create();
        sqr(create3, 3, create4);
        mul(create2, create4, create4);
        int[] create5 = create();
        sqr(create4, 9, create5);
        mul(create4, create5, create5);
        int[] create6 = create();
        sqr(create5, create6);
        mul(iArr, create6, create6);
        int[] create7 = create();
        sqr(create6, 18, create7);
        mul(create5, create7, create7);
        int[] create8 = create();
        sqr(create7, 37, create8);
        mul(create7, create8, create8);
        int[] create9 = create();
        sqr(create8, 37, create9);
        mul(create7, create9, create9);
        int[] create10 = create();
        sqr(create9, 111, create10);
        mul(create9, create10, create10);
        int[] create11 = create();
        sqr(create10, create11);
        mul(iArr, create11, create11);
        int[] create12 = create();
        sqr(create11, 223, create12);
        mul(create12, create10, iArr2);
    }

    private static void reduce(int[] iArr, int i10) {
        int i11;
        int i12 = iArr[15];
        int i13 = i12 & M28;
        long j10 = (long) ((i12 >>> 28) + i10);
        int i14 = 0;
        long j11 = j10;
        while (true) {
            if (i14 >= 8) {
                break;
            }
            long j12 = j11 + (4294967295L & ((long) iArr[i14]));
            iArr[i14] = ((int) j12) & M28;
            j11 = j12 >> 28;
            i14++;
        }
        long j13 = j11 + j10;
        for (i11 = 8; i11 < 15; i11++) {
            long j14 = j13 + (((long) iArr[i11]) & 4294967295L);
            iArr[i11] = ((int) j14) & M28;
            j13 = j14 >> 28;
        }
        iArr[15] = i13 + ((int) j13);
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
        int i18 = iArr[8];
        int i19 = iArr[9];
        int i20 = iArr[10];
        int i21 = iArr[11];
        int i22 = iArr[12];
        int i23 = iArr[13];
        int i24 = iArr[14];
        int i25 = iArr[15];
        int i26 = i10 * 2;
        int i27 = i11 * 2;
        int i28 = i12 * 2;
        int i29 = i13 * 2;
        int i30 = i14 * 2;
        int i31 = i15 * 2;
        int i32 = i16 * 2;
        int i33 = i18 * 2;
        int i34 = i19 * 2;
        int i35 = i20 * 2;
        int i36 = i21 * 2;
        int i37 = i22 * 2;
        int i38 = i23 * 2;
        int i39 = i24 * 2;
        int i40 = i10 + i18;
        int i41 = i18;
        int i42 = i11 + i19;
        int i43 = i19;
        int i44 = i12 + i20;
        int i45 = i20;
        int i46 = i13 + i21;
        int i47 = i21;
        int i48 = i14 + i22;
        int i49 = i13;
        int i50 = i15 + i23;
        int i51 = i12;
        int i52 = i16 + i24;
        int i53 = i11;
        int i54 = i40 * 2;
        int i55 = i42 * 2;
        int i56 = i42;
        int i57 = i44 * 2;
        int i58 = i44;
        int i59 = i46 * 2;
        int i60 = i46;
        int i61 = i48 * 2;
        int i62 = i50 * 2;
        int i63 = i50;
        int i64 = i48;
        long j10 = (long) i10;
        long j11 = j10 * j10;
        long j12 = (long) i17;
        int i65 = i27;
        int i66 = i57;
        long j13 = (long) i65;
        long j14 = j12 * j13;
        long j15 = j13;
        long j16 = (long) i16;
        long j17 = j12;
        long j18 = (long) i28;
        long j19 = (long) i15;
        long j20 = j16;
        long j21 = (long) i29;
        long j22 = j19;
        long j23 = (long) i14;
        long j24 = j14 + (j16 * j18) + (j19 * j21) + (j23 * j23);
        long j25 = j23;
        long j26 = (long) i41;
        long j27 = j21;
        long j28 = (long) i25;
        long j29 = j18;
        long j30 = (long) i34;
        long j31 = j28 * j30;
        int i67 = i52 * 2;
        long j32 = (long) i24;
        long j33 = j30;
        long j34 = (long) i35;
        long j35 = j31 + (j32 * j34);
        long j36 = j32;
        long j37 = (long) i23;
        long j38 = j34;
        long j39 = (long) i36;
        long j40 = j35 + (j37 * j39);
        long j41 = j37;
        long j42 = (long) i22;
        long j43 = j42;
        long j44 = (long) i40;
        long j45 = j39;
        long j46 = (long) (i17 + i25);
        long j47 = ((long) i55) & 4294967295L;
        long j48 = j46 * j47;
        long j49 = (long) i52;
        long j50 = j47;
        long j51 = ((long) i66) & 4294967295L;
        long j52 = j48 + (j49 * j51);
        long j53 = j49;
        long j54 = (long) i63;
        int i68 = i67;
        long j55 = ((long) i59) & 4294967295L;
        int i69 = i64;
        long j56 = j54;
        long j57 = (long) i69;
        long j58 = j52 + (j54 * j55) + (j57 * j57);
        long j59 = ((j11 + (j26 * j26)) + j58) - j24;
        long j60 = (((j40 + (j42 * j42)) + (j44 * j44)) - j11) + j58;
        int i70 = ((int) j59) & M28;
        int i71 = ((int) j60) & M28;
        int i72 = i53;
        long j61 = j57;
        long j62 = (long) i72;
        long j63 = j60 >>> 28;
        long j64 = (long) i26;
        long j65 = j62 * j64;
        long j66 = j62;
        long j67 = (long) i30;
        long j68 = (j17 * j29) + (j20 * j27) + (j22 * j67);
        long j69 = j67;
        long j70 = (long) i43;
        long j71 = j64;
        long j72 = (long) i33;
        long j73 = j70 * j72;
        long j74 = (j28 * j38) + (j36 * j45);
        long j75 = j28;
        long j76 = (long) i37;
        long j77 = j74 + (j41 * j76);
        long j78 = j76;
        long j79 = (long) i56;
        int i73 = i54;
        long j80 = j70;
        long j81 = ((long) i73) & 4294967295L;
        long j82 = (j46 * j51) + (j53 * j55);
        long j83 = j51;
        long j84 = ((long) i61) & 4294967295L;
        long j85 = j82 + (j56 * j84);
        long j86 = (j59 >>> 28) + (((j65 + j73) + j85) - j68);
        int i74 = i68;
        long j87 = j63 + ((j77 + (j79 * j81)) - j65) + j85;
        long j88 = j87 >>> 28;
        int i75 = ((int) j86) & M28;
        long j89 = (long) i51;
        long j90 = (j89 * j71) + (j66 * j66);
        long j91 = j89;
        long j92 = (long) i45;
        long j93 = (j92 * j72) + (j80 * j80);
        long j94 = j92;
        long j95 = (long) i58;
        long j96 = (j95 * j81) + (j79 * j79);
        long j97 = (j46 * j55) + (j53 * j84) + (j56 * j56);
        long j98 = ((j90 + j93) + j97) - (((j17 * j27) + (j20 * j69)) + (j22 * j22));
        long j99 = j55;
        int i76 = ((int) j87) & M28;
        long j100 = (j86 >>> 28) + j98;
        long j101 = j88 + (((((j75 * j45) + (j36 * j78)) + (j41 * j41)) + j96) - j90) + j97;
        int i77 = ((int) j100) & M28;
        int i78 = ((int) j101) & M28;
        int i79 = i49;
        int i80 = i76;
        long j102 = (long) i79;
        long j103 = (j102 * j71) + (j91 * j15);
        long j104 = j102;
        long j105 = (long) i31;
        long j106 = (j17 * j69) + (j20 * j105);
        long j107 = j105;
        long j108 = (long) i47;
        long j109 = (j108 * j72) + (j94 * j33);
        long j110 = j75 * j78;
        long j111 = j108;
        long j112 = (long) i38;
        long j113 = j110 + (j36 * j112);
        long j114 = j112;
        long j115 = (long) i60;
        long j116 = j84 * j46;
        long j117 = j46;
        long j118 = ((long) i62) & 4294967295L;
        long j119 = j116 + (j53 * j118);
        long j120 = (j100 >>> 28) + (((j103 + j109) + j119) - j106);
        long j121 = j118;
        int i81 = ((int) j120) & M28;
        long j122 = (j101 >>> 28) + ((j113 + ((j115 * j81) + (j95 * j50))) - j103) + j119;
        long j123 = (j25 * j71) + (j104 * j15) + (j91 * j91);
        long j124 = (j61 * j81) + (j115 * j50) + (j95 * j95);
        long j125 = (j117 * j121) + (j53 * j53);
        long j126 = (j120 >>> 28) + (((j123 + (((j43 * j72) + (j111 * j33)) + (j94 * j94))) + j125) - ((j17 * j107) + (j20 * j20)));
        int i82 = ((int) j122) & M28;
        int i83 = ((int) j126) & M28;
        long j127 = (j122 >>> 28) + ((((j75 * j114) + (j36 * j36)) + j124) - j123) + j125;
        long j128 = (j22 * j71) + (j25 * j15) + (j104 * j29);
        int i84 = i32;
        int i85 = ((int) j127) & M28;
        int i86 = i83;
        int i87 = i39;
        int i88 = i81;
        long j129 = (j56 * j81) + (j61 * j50) + (j115 * j83);
        long j130 = j115;
        long j131 = (((long) i74) & 4294967295L) * j117;
        long j132 = (j126 >>> 28) + (((j128 + (((j41 * j72) + (j43 * j33)) + (j111 * j38))) + j131) - (((long) i84) * j17));
        int i89 = ((int) j132) & M28;
        long j133 = (j127 >>> 28) + (((((long) i87) * j75) + j129) - j128) + j131;
        int i90 = ((int) j133) & M28;
        long j134 = (j20 * j71) + (j22 * j15) + (j25 * j29) + (j104 * j104);
        long j135 = (j53 * j81) + (j56 * j50) + (j61 * j83) + (j130 * j130);
        long j136 = j117 * j117;
        long j137 = (j132 >>> 28) + (((j134 + ((((j36 * j72) + (j41 * j33)) + (j43 * j38)) + (j111 * j111))) + j136) - (j17 * j17));
        int i91 = ((int) j137) & M28;
        long j138 = (j133 >>> 28) + (((j75 * j75) + j135) - j134) + j136;
        int i92 = ((int) j138) & M28;
        long j139 = (j17 * j71) + (j20 * j15) + (j22 * j29) + (j25 * j27);
        long j140 = (j137 >>> 28) + (j72 * j75) + (j36 * j33) + (j41 * j38) + (j43 * j45) + j139;
        int i93 = ((int) j140) & M28;
        long j141 = (j138 >>> 28) + (((((j81 * j117) + (j53 * j50)) + (j56 * j83)) + (j61 * j99)) - j139);
        int i94 = ((int) j141) & M28;
        long j142 = j141 >>> 28;
        long j143 = (j140 >>> 28) + j142 + ((long) i71);
        int i95 = ((int) j143) & M28;
        long j144 = j142 + ((long) i70);
        iArr2[0] = ((int) j144) & M28;
        iArr2[1] = i75 + ((int) (j144 >>> 28));
        iArr2[2] = i77;
        iArr2[3] = i88;
        iArr2[4] = i86;
        iArr2[5] = i89;
        iArr2[6] = i91;
        iArr2[7] = i93;
        iArr2[8] = i95;
        iArr2[9] = i80 + ((int) (j143 >>> 28));
        iArr2[10] = i78;
        iArr2[11] = i82;
        iArr2[12] = i85;
        iArr2[13] = i90;
        iArr2[14] = i92;
        iArr2[15] = i94;
    }

    public static boolean sqrtRatioVar(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = create();
        int[] create2 = create();
        sqr(iArr, create);
        mul(create, iArr2, create);
        sqr(create, create2);
        mul(create, iArr, create);
        mul(create2, iArr, create2);
        mul(create2, iArr2, create2);
        int[] create3 = create();
        powPm3d4(create2, create3);
        mul(create3, create, create3);
        int[] create4 = create();
        sqr(create3, create4);
        mul(create4, iArr2, create4);
        sub(iArr, create4, create4);
        normalize(create4);
        if (!isZeroVar(create4)) {
            return false;
        }
        copy(create3, 0, iArr3, 0);
        return true;
    }

    public static void sub(int[] iArr, int[] iArr2, int[] iArr3) {
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
        int i20 = iArr[10];
        int i21 = iArr[11];
        int i22 = iArr[12];
        int i23 = iArr[13];
        int i24 = iArr[14];
        int i25 = iArr[15];
        int i26 = iArr2[0];
        int i27 = iArr2[1];
        int i28 = iArr2[2];
        int i29 = iArr2[3];
        int i30 = iArr2[4];
        int i31 = iArr2[5];
        int i32 = iArr2[6];
        int i33 = iArr2[7];
        int i34 = iArr2[8];
        int i35 = iArr2[9];
        int i36 = iArr2[10];
        int i37 = iArr2[11];
        int i38 = iArr2[12];
        int i39 = iArr2[13];
        int i40 = iArr2[14];
        int i41 = (i11 + 536870910) - i27;
        int i42 = (i15 + 536870910) - i31;
        int i43 = (i19 + 536870910) - i35;
        int i44 = (i23 + 536870910) - i39;
        int i45 = ((i12 + 536870910) - i28) + (i41 >>> 28);
        int i46 = i41 & M28;
        int i47 = ((i16 + 536870910) - i32) + (i42 >>> 28);
        int i48 = i42 & M28;
        int i49 = ((i20 + 536870910) - i36) + (i43 >>> 28);
        int i50 = i43 & M28;
        int i51 = ((i24 + 536870910) - i40) + (i44 >>> 28);
        int i52 = i44 & M28;
        int i53 = ((i13 + 536870910) - i29) + (i45 >>> 28);
        int i54 = i45 & M28;
        int i55 = ((i17 + 536870910) - i33) + (i47 >>> 28);
        int i56 = i47 & M28;
        int i57 = ((i21 + 536870910) - i37) + (i49 >>> 28);
        int i58 = i49 & M28;
        int i59 = ((i25 + 536870910) - iArr2[15]) + (i51 >>> 28);
        int i60 = i51 & M28;
        int i61 = i59 >>> 28;
        int i62 = i59 & M28;
        int i63 = ((i10 + 536870910) - i26) + i61;
        int i64 = ((i14 + 536870910) - i30) + (i53 >>> 28);
        int i65 = i53 & M28;
        int i66 = ((i18 + 536870908) - i34) + i61 + (i55 >>> 28);
        int i67 = i55 & M28;
        int i68 = ((i22 + 536870910) - i38) + (i57 >>> 28);
        int i69 = i57 & M28;
        int i70 = i46 + (i63 >>> 28);
        int i71 = i63 & M28;
        int i72 = i48 + (i64 >>> 28);
        int i73 = i64 & M28;
        int i74 = i50 + (i66 >>> 28);
        int i75 = i66 & M28;
        int i76 = i68 & M28;
        iArr3[0] = i71;
        iArr3[1] = i70;
        iArr3[2] = i54;
        iArr3[3] = i65;
        iArr3[4] = i73;
        iArr3[5] = i72;
        iArr3[6] = i56;
        iArr3[7] = i67;
        iArr3[8] = i75;
        iArr3[9] = i74;
        iArr3[10] = i58;
        iArr3[11] = i69;
        iArr3[12] = i76;
        iArr3[13] = i52 + (i68 >>> 28);
        iArr3[14] = i60;
        iArr3[15] = i62;
    }

    public static void subOne(int[] iArr) {
        int[] create = create();
        create[0] = 1;
        sub(iArr, create, iArr);
    }

    public static void zero(int[] iArr) {
        for (int i10 = 0; i10 < 16; i10++) {
            iArr[i10] = 0;
        }
    }
}
