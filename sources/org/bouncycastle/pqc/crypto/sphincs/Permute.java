package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.util.Pack;

class Permute {
    private static final int CHACHA_ROUNDS = 12;

    Permute() {
    }

    public static void permute(int i10, int[] iArr) {
        int[] iArr2 = iArr;
        int i11 = 16;
        if (iArr2.length != 16) {
            throw new IllegalArgumentException();
        } else if (i10 % 2 == 0) {
            char c10 = 0;
            int i12 = iArr2[0];
            int i13 = iArr2[1];
            int i14 = iArr2[2];
            int i15 = iArr2[3];
            int i16 = iArr2[4];
            int i17 = iArr2[5];
            int i18 = iArr2[6];
            int i19 = 7;
            int i20 = iArr2[7];
            int i21 = 8;
            int i22 = iArr2[8];
            int i23 = iArr2[9];
            int i24 = iArr2[10];
            int i25 = iArr2[11];
            int i26 = iArr2[12];
            int i27 = iArr2[13];
            int i28 = iArr2[14];
            int i29 = iArr2[15];
            int i30 = i28;
            int i31 = i27;
            int i32 = i26;
            int i33 = i25;
            int i34 = i24;
            int i35 = i23;
            int i36 = i22;
            int i37 = i20;
            int i38 = i18;
            int i39 = i17;
            int i40 = i16;
            int i41 = i15;
            int i42 = i14;
            int i43 = i13;
            int i44 = i12;
            int i45 = i10;
            while (i45 > 0) {
                int i46 = i44 + i40;
                int rotl = rotl(i32 ^ i46, i11);
                int i47 = i36 + rotl;
                int rotl2 = rotl(i40 ^ i47, 12);
                int i48 = i46 + rotl2;
                int rotl3 = rotl(rotl ^ i48, i21);
                int i49 = i47 + rotl3;
                int rotl4 = rotl(rotl2 ^ i49, i19);
                int i50 = i43 + i39;
                int rotl5 = rotl(i31 ^ i50, i11);
                int i51 = i35 + rotl5;
                int rotl6 = rotl(i39 ^ i51, 12);
                int i52 = i50 + rotl6;
                int rotl7 = rotl(rotl5 ^ i52, i21);
                int i53 = i51 + rotl7;
                int rotl8 = rotl(rotl6 ^ i53, i19);
                int i54 = i42 + i38;
                int rotl9 = rotl(i30 ^ i54, i11);
                int i55 = i34 + rotl9;
                int rotl10 = rotl(i38 ^ i55, 12);
                int i56 = i54 + rotl10;
                int rotl11 = rotl(rotl9 ^ i56, i21);
                int i57 = i55 + rotl11;
                int rotl12 = rotl(rotl10 ^ i57, i19);
                int i58 = i41 + i37;
                int rotl13 = rotl(i29 ^ i58, i11);
                int i59 = i33 + rotl13;
                int rotl14 = rotl(i37 ^ i59, 12);
                int i60 = i58 + rotl14;
                int rotl15 = rotl(rotl13 ^ i60, i21);
                int i61 = i59 + rotl15;
                int rotl16 = rotl(rotl14 ^ i61, 7);
                int i62 = i48 + rotl8;
                int rotl17 = rotl(rotl15 ^ i62, 16);
                int i63 = i57 + rotl17;
                int rotl18 = rotl(rotl8 ^ i63, 12);
                i44 = i62 + rotl18;
                i29 = rotl(rotl17 ^ i44, 8);
                i34 = i63 + i29;
                i39 = rotl(rotl18 ^ i34, 7);
                int i64 = i52 + rotl12;
                int rotl19 = rotl(rotl3 ^ i64, 16);
                int i65 = i61 + rotl19;
                int rotl20 = rotl(rotl12 ^ i65, 12);
                i43 = i64 + rotl20;
                i32 = rotl(rotl19 ^ i43, 8);
                i33 = i65 + i32;
                i38 = rotl(rotl20 ^ i33, 7);
                int i66 = i56 + rotl16;
                int rotl21 = rotl(rotl7 ^ i66, 16);
                int i67 = i49 + rotl21;
                int rotl22 = rotl(rotl16 ^ i67, 12);
                i42 = i66 + rotl22;
                i31 = rotl(rotl21 ^ i42, 8);
                i36 = i67 + i31;
                i37 = rotl(rotl22 ^ i36, 7);
                int i68 = i60 + rotl4;
                i11 = 16;
                int rotl23 = rotl(rotl11 ^ i68, 16);
                int i69 = i53 + rotl23;
                int rotl24 = rotl(rotl4 ^ i69, 12);
                i41 = i68 + rotl24;
                i30 = rotl(rotl23 ^ i41, 8);
                i35 = i69 + i30;
                i40 = rotl(rotl24 ^ i35, 7);
                i45 -= 2;
                i19 = 7;
                c10 = 0;
                i21 = 8;
            }
            iArr2[c10] = i44;
            iArr2[1] = i43;
            iArr2[2] = i42;
            iArr2[3] = i41;
            iArr2[4] = i40;
            iArr2[5] = i39;
            iArr2[6] = i38;
            iArr2[i19] = i37;
            iArr2[8] = i36;
            iArr2[9] = i35;
            iArr2[10] = i34;
            iArr2[11] = i33;
            iArr2[12] = i32;
            iArr2[13] = i31;
            iArr2[14] = i30;
            iArr2[15] = i29;
        } else {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
    }

    protected static int rotl(int i10, int i11) {
        return (i10 >>> (-i11)) | (i10 << i11);
    }

    /* access modifiers changed from: package-private */
    public void chacha_permute(byte[] bArr, byte[] bArr2) {
        int[] iArr = new int[16];
        for (int i10 = 0; i10 < 16; i10++) {
            iArr[i10] = Pack.littleEndianToInt(bArr2, i10 * 4);
        }
        permute(12, iArr);
        for (int i11 = 0; i11 < 16; i11++) {
            Pack.intToLittleEndian(iArr[i11], bArr, i11 * 4);
        }
    }
}
