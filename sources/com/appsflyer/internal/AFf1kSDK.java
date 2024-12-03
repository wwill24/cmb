package com.appsflyer.internal;

public final class AFf1kSDK {
    static final int[] AFInAppEventParameterName = new int[256];
    static final int[] AFInAppEventType = new int[256];
    static final int[] AFKeystoreWrapper = new int[256];
    private static byte[] afDebugLog = new byte[256];
    private static int[] afInfoLog = new int[10];
    static final int[] valueOf = new int[256];
    static final byte[] values = new byte[256];

    static {
        byte b10;
        byte b11;
        byte[] bArr;
        byte b12;
        byte b13 = 1;
        byte b14 = 1;
        do {
            byte b15 = (b13 << 1) ^ b13;
            if ((b13 & 128) != 0) {
                b10 = 27;
            } else {
                b10 = 0;
            }
            b13 = (byte) (b10 ^ b15);
            byte b16 = (byte) (b14 ^ (b14 << 1));
            byte b17 = (byte) (b16 ^ (b16 << 2));
            byte b18 = (byte) (b17 ^ (b17 << 4));
            if ((b18 & 128) != 0) {
                b11 = 9;
            } else {
                b11 = 0;
            }
            b14 = (byte) (b18 ^ b11);
            bArr = afDebugLog;
            b12 = b13 & 255;
            byte b19 = b14 & 255;
            bArr[b12] = (byte) (((((b14 ^ 99) ^ ((b19 << 1) | (b19 >> 7))) ^ ((b19 << 2) | (b19 >> 6))) ^ ((b19 << 3) | (b19 >> 5))) ^ ((b19 >> 4) | (b19 << 4)));
        } while (b12 != 1);
        bArr[0] = 99;
        for (int i10 = 0; i10 < 256; i10++) {
            byte b20 = afDebugLog[i10] & 255;
            values[b20] = (byte) i10;
            int i11 = i10 << 1;
            if (i11 >= 256) {
                i11 ^= 283;
            }
            int i12 = i11 << 1;
            if (i12 >= 256) {
                i12 ^= 283;
            }
            int i13 = i12 << 1;
            if (i13 >= 256) {
                i13 ^= 283;
            }
            int i14 = i13 ^ i10;
            int i15 = ((i11 ^ (i12 ^ i13)) << 24) | (i14 << 16) | ((i14 ^ i12) << 8) | (i14 ^ i11);
            AFInAppEventType[b20] = i15;
            AFInAppEventParameterName[b20] = (i15 >>> 8) | (i15 << 24);
            AFKeystoreWrapper[b20] = (i15 >>> 16) | (i15 << 16);
            valueOf[b20] = (i15 << 8) | (i15 >>> 24);
        }
        afInfoLog[0] = 16777216;
        int i16 = 1;
        for (int i17 = 1; i17 < 10; i17++) {
            i16 <<= 1;
            if (i16 >= 256) {
                i16 ^= 283;
            }
            afInfoLog[i17] = i16 << 24;
        }
    }

    public static byte[][] values(int i10) {
        byte[][] bArr = new byte[4][];
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = i10 >>> (i11 << 3);
            bArr[i11] = new byte[]{(byte) (i12 & 3), (byte) ((i12 >> 2) & 3), (byte) ((i12 >> 4) & 3), (byte) ((i12 >> 6) & 3)};
        }
        return bArr;
    }

    static int[] values(byte[] bArr, int i10) throws IllegalArgumentException {
        if (bArr.length == 16) {
            int i11 = 4;
            int i12 = (i10 + 1) * 4;
            int[] iArr = new int[i12];
            int i13 = 0;
            int i14 = 0;
            while (i13 < 4) {
                int i15 = i14 + 1;
                int i16 = i15 + 1;
                byte b10 = (bArr[i14] << 24) | ((bArr[i15] & 255) << Tnaf.POW_2_WIDTH);
                int i17 = i16 + 1;
                iArr[i13] = b10 | ((bArr[i16] & 255) << 8) | (bArr[i17] & 255);
                i13++;
                i14 = i17 + 1;
            }
            int i18 = 4;
            int i19 = 0;
            int i20 = 0;
            while (i18 < i12) {
                int i21 = iArr[i18 - 1];
                if (i19 == 0) {
                    byte[] bArr2 = afDebugLog;
                    i21 = ((bArr2[i21 >>> 24] & 255) | (((bArr2[(i21 >>> 16) & 255] << 24) | ((bArr2[(i21 >>> 8) & 255] & 255) << Tnaf.POW_2_WIDTH)) | ((bArr2[i21 & 255] & 255) << 8))) ^ afInfoLog[i20];
                    i19 = 4;
                    i20++;
                }
                iArr[i18] = i21 ^ iArr[i18 - 4];
                i18++;
                i19--;
            }
            if (bArr.length == 16) {
                int[] iArr2 = new int[i12];
                int i22 = i10 * 4;
                int i23 = i22 + 1;
                iArr2[0] = iArr[i22];
                int i24 = i23 + 1;
                iArr2[1] = iArr[i23];
                int i25 = i24 + 1;
                iArr2[2] = iArr[i24];
                iArr2[3] = iArr[i25];
                int i26 = i25 - 7;
                for (int i27 = 1; i27 < i10; i27++) {
                    int i28 = i26 + 1;
                    int i29 = iArr[i26];
                    int i30 = i11 + 1;
                    int[] iArr3 = AFInAppEventType;
                    byte[] bArr3 = afDebugLog;
                    int i31 = iArr3[bArr3[i29 >>> 24] & 255];
                    int[] iArr4 = AFInAppEventParameterName;
                    int i32 = i31 ^ iArr4[bArr3[(i29 >>> 16) & 255] & 255];
                    int[] iArr5 = AFKeystoreWrapper;
                    int i33 = i32 ^ iArr5[bArr3[(i29 >>> 8) & 255] & 255];
                    int[] iArr6 = valueOf;
                    iArr2[i11] = iArr6[bArr3[i29 & 255] & 255] ^ i33;
                    int i34 = i28 + 1;
                    int i35 = iArr[i28];
                    int i36 = i30 + 1;
                    iArr2[i30] = iArr6[bArr3[i35 & 255] & 255] ^ ((iArr3[bArr3[i35 >>> 24] & 255] ^ iArr4[bArr3[(i35 >>> 16) & 255] & 255]) ^ iArr5[bArr3[(i35 >>> 8) & 255] & 255]);
                    int i37 = i34 + 1;
                    int i38 = iArr[i34];
                    int i39 = i36 + 1;
                    iArr2[i36] = iArr6[bArr3[i38 & 255] & 255] ^ ((iArr3[bArr3[i38 >>> 24] & 255] ^ iArr4[bArr3[(i38 >>> 16) & 255] & 255]) ^ iArr5[bArr3[(i38 >>> 8) & 255] & 255]);
                    int i40 = iArr[i37];
                    i11 = i39 + 1;
                    iArr2[i39] = iArr6[bArr3[i40 & 255] & 255] ^ ((iArr3[bArr3[i40 >>> 24] & 255] ^ iArr4[bArr3[(i40 >>> 16) & 255] & 255]) ^ iArr5[bArr3[(i40 >>> 8) & 255] & 255]);
                    i26 = i37 - 7;
                }
                int i41 = i11 + 1;
                int i42 = i26 + 1;
                iArr2[i11] = iArr[i26];
                int i43 = i41 + 1;
                int i44 = i42 + 1;
                iArr2[i41] = iArr[i42];
                iArr2[i43] = iArr[i44];
                iArr2[i43 + 1] = iArr[i44 + 1];
                return iArr2;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }
}
