package org.bouncycastle.crypto.engines;

import net.bytebuddy.jar.asm.Opcodes;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;

public final class TwofishEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final int GF256_FDBK = 361;
    private static final int GF256_FDBK_2 = 180;
    private static final int GF256_FDBK_4 = 90;
    private static final int INPUT_WHITEN = 0;
    private static final int MAX_KEY_BITS = 256;
    private static final int MAX_ROUNDS = 16;
    private static final int OUTPUT_WHITEN = 4;
    private static final byte[][] P = {new byte[]{-87, 103, -77, -24, 4, -3, -93, 118, -102, -110, Byte.MIN_VALUE, Framer.EXIT_FRAME_PREFIX, -28, -35, -47, 56, 13, -58, 53, -104, 24, -9, -20, 108, 67, 117, 55, 38, -6, 19, -108, 72, -14, -48, -117, 48, -124, 84, -33, 35, 25, 91, 61, 89, -13, -82, -94, -126, 99, 1, -125, 46, -39, 81, -101, 124, -90, -21, -91, -66, 22, 12, -29, 97, -64, -116, 58, -11, 115, 44, 37, 11, -69, 78, -119, 107, 83, 106, -76, -15, -31, -26, -67, 69, -30, -12, -74, 102, -52, -107, 3, 86, -44, 28, 30, -41, -5, -61, -114, -75, -23, -49, -65, -70, -22, 119, 57, -81, 51, -55, 98, 113, -127, 121, 9, -83, 36, -51, -7, -40, -27, -59, -71, 77, 68, 8, -122, -25, -95, 29, -86, -19, 6, 112, -78, -46, 65, 123, -96, 17, Framer.STDOUT_FRAME_PREFIX, -62, 39, -112, 32, -10, 96, -1, -106, 92, -79, -85, -98, -100, 82, 27, Framer.STDIN_REQUEST_FRAME_PREFIX, -109, 10, -17, -111, -123, 73, -18, Framer.STDIN_FRAME_PREFIX, 79, -113, 59, 71, -121, 109, 70, -42, 62, 105, 100, 42, -50, -53, 47, -4, -105, 5, 122, -84, Byte.MAX_VALUE, -43, 26, 75, 14, -89, 90, 40, 20, 63, 41, -120, 60, 76, 2, -72, -38, -80, 23, 85, 31, -118, 125, 87, -57, -115, 116, -73, -60, -97, 114, 126, 21, 34, 18, 88, 7, -103, 52, 110, 80, -34, 104, 101, PSSSigner.TRAILER_IMPLICIT, -37, -8, -56, -88, 43, 64, -36, -2, Framer.STDERR_FRAME_PREFIX, -92, -54, Tnaf.POW_2_WIDTH, Framer.ENTER_FRAME_PREFIX, -16, -45, 93, 15, 0, 111, -99, 54, 66, 74, 94, -63, -32}, new byte[]{117, -13, -58, -12, -37, 123, -5, -56, 74, -45, -26, 107, 69, 125, -24, 75, -42, Framer.STDERR_FRAME_PREFIX, -40, -3, 55, 113, -15, -31, 48, 15, -8, 27, -121, -6, 6, 63, 94, -70, -82, 91, -118, 0, PSSSigner.TRAILER_IMPLICIT, -99, 109, -63, -79, 14, Byte.MIN_VALUE, 93, -46, -43, -96, -124, 7, 20, -75, -112, 44, -93, -78, 115, 76, 84, -110, 116, 54, 81, 56, -80, -67, 90, -4, 96, 98, -106, 108, 66, -9, Tnaf.POW_2_WIDTH, 124, 40, 39, -116, 19, -107, -100, -57, 36, 70, 59, 112, -54, -29, -123, -53, 17, -48, -109, -72, -90, -125, 32, -1, -97, 119, -61, -52, 3, 111, 8, -65, 64, -25, 43, -30, 121, 12, -86, -126, 65, 58, -22, -71, -28, -102, -92, -105, 126, -38, 122, 23, 102, -108, -95, 29, 61, -16, -34, -77, 11, 114, -89, 28, -17, -47, 83, 62, -113, 51, 38, Framer.STDIN_REQUEST_FRAME_PREFIX, -20, 118, 42, 73, -127, -120, -18, Framer.ENTER_FRAME_PREFIX, -60, 26, -21, -39, -59, 57, -103, -51, -83, Framer.STDOUT_FRAME_PREFIX, -117, 1, 24, 35, -35, 31, 78, Framer.STDIN_FRAME_PREFIX, -7, 72, 79, -14, 101, -114, Framer.EXIT_FRAME_PREFIX, 92, 88, 25, -115, -27, -104, 87, 103, Byte.MAX_VALUE, 5, 100, -81, 99, -74, -2, -11, -73, 60, -91, -50, -23, 104, 68, -32, 77, 67, 105, 41, 46, -84, 21, 89, -88, 10, -98, 110, 71, -33, 52, 53, 106, -49, -36, 34, -55, -64, -101, -119, -44, -19, -85, 18, -94, 13, 82, -69, 2, 47, -87, -41, 97, 30, -76, 80, 4, -10, -62, 22, 37, -122, 86, 85, 9, -66, -111}};
    private static final int P_00 = 1;
    private static final int P_01 = 0;
    private static final int P_02 = 0;
    private static final int P_03 = 1;
    private static final int P_04 = 1;
    private static final int P_10 = 0;
    private static final int P_11 = 0;
    private static final int P_12 = 1;
    private static final int P_13 = 1;
    private static final int P_14 = 0;
    private static final int P_20 = 1;
    private static final int P_21 = 1;
    private static final int P_22 = 0;
    private static final int P_23 = 0;
    private static final int P_24 = 0;
    private static final int P_30 = 0;
    private static final int P_31 = 1;
    private static final int P_32 = 1;
    private static final int P_33 = 0;
    private static final int P_34 = 1;
    private static final int ROUNDS = 16;
    private static final int ROUND_SUBKEYS = 8;
    private static final int RS_GF_FDBK = 333;
    private static final int SK_BUMP = 16843009;
    private static final int SK_ROTL = 9;
    private static final int SK_STEP = 33686018;
    private static final int TOTAL_SUBKEYS = 40;
    private boolean encrypting = false;
    private int[] gMDS0 = new int[256];
    private int[] gMDS1 = new int[256];
    private int[] gMDS2 = new int[256];
    private int[] gMDS3 = new int[256];
    private int[] gSBox;
    private int[] gSubKeys;
    private int k64Cnt = 0;
    private byte[] workingKey = null;

    public TwofishEngine() {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        for (int i10 = 0; i10 < 256; i10++) {
            byte[][] bArr = P;
            int i11 = bArr[0][i10] & 255;
            iArr[0] = i11;
            iArr2[0] = Mx_X(i11) & 255;
            iArr3[0] = Mx_Y(i11) & 255;
            int i12 = bArr[1][i10] & 255;
            iArr[1] = i12;
            iArr2[1] = Mx_X(i12) & 255;
            int Mx_Y = Mx_Y(i12) & 255;
            iArr3[1] = Mx_Y;
            this.gMDS0[i10] = (Mx_Y << 24) | iArr[1] | (iArr2[1] << 8) | (Mx_Y << 16);
            int[] iArr4 = this.gMDS1;
            int i13 = iArr3[0];
            iArr4[i10] = i13 | (i13 << 8) | (iArr2[0] << 16) | (iArr[0] << 24);
            int[] iArr5 = this.gMDS2;
            int i14 = iArr2[1];
            int i15 = iArr3[1];
            iArr5[i10] = (iArr[1] << 16) | i14 | (i15 << 8) | (i15 << 24);
            int[] iArr6 = this.gMDS3;
            int i16 = iArr2[0];
            iArr6[i10] = (i16 << 24) | (iArr[0] << 8) | i16 | (iArr3[0] << 16);
        }
    }

    private void Bits32ToBytes(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        bArr[i11 + 1] = (byte) (i10 >> 8);
        bArr[i11 + 2] = (byte) (i10 >> 16);
        bArr[i11 + 3] = (byte) (i10 >> 24);
    }

    private int BytesTo32Bits(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << Tnaf.POW_2_WIDTH);
    }

    private int F32(int i10, int[] iArr) {
        int i11;
        int i12;
        int b02 = b0(i10);
        int b12 = b1(i10);
        int b22 = b2(i10);
        int b32 = b3(i10);
        int i13 = iArr[0];
        int i14 = iArr[1];
        int i15 = iArr[2];
        int i16 = iArr[3];
        int i17 = this.k64Cnt & 3;
        if (i17 == 0) {
            byte[][] bArr = P;
            b02 = (bArr[1][b02] & 255) ^ b0(i16);
            b12 = (bArr[0][b12] & 255) ^ b1(i16);
            b22 = (bArr[0][b22] & 255) ^ b2(i16);
            b32 = (bArr[1][b32] & 255) ^ b3(i16);
        } else if (i17 != 1) {
            if (i17 != 2) {
                if (i17 != 3) {
                    return 0;
                }
            }
            int[] iArr2 = this.gMDS0;
            byte[][] bArr2 = P;
            byte[] bArr3 = bArr2[0];
            i11 = (iArr2[(bArr3[(bArr3[b02] & 255) ^ b0(i14)] & 255) ^ b0(i13)] ^ this.gMDS1[(bArr2[0][(bArr2[1][b12] & 255) ^ b1(i14)] & 255) ^ b1(i13)]) ^ this.gMDS2[(bArr2[1][(bArr2[0][b22] & 255) ^ b2(i14)] & 255) ^ b2(i13)];
            int[] iArr3 = this.gMDS3;
            byte[] bArr4 = bArr2[1];
            i12 = iArr3[(bArr4[(bArr4[b32] & 255) ^ b3(i14)] & 255) ^ b3(i13)];
            return i11 ^ i12;
        } else {
            int[] iArr4 = this.gMDS0;
            byte[][] bArr5 = P;
            i11 = (iArr4[(bArr5[0][b02] & 255) ^ b0(i13)] ^ this.gMDS1[(bArr5[0][b12] & 255) ^ b1(i13)]) ^ this.gMDS2[(bArr5[1][b22] & 255) ^ b2(i13)];
            i12 = this.gMDS3[(bArr5[1][b32] & 255) ^ b3(i13)];
            return i11 ^ i12;
        }
        byte[][] bArr6 = P;
        b02 = (bArr6[1][b02] & 255) ^ b0(i15);
        b12 = (bArr6[1][b12] & 255) ^ b1(i15);
        b22 = (bArr6[0][b22] & 255) ^ b2(i15);
        b32 = (bArr6[0][b32] & 255) ^ b3(i15);
        int[] iArr22 = this.gMDS0;
        byte[][] bArr22 = P;
        byte[] bArr32 = bArr22[0];
        i11 = (iArr22[(bArr32[(bArr32[b02] & 255) ^ b0(i14)] & 255) ^ b0(i13)] ^ this.gMDS1[(bArr22[0][(bArr22[1][b12] & 255) ^ b1(i14)] & 255) ^ b1(i13)]) ^ this.gMDS2[(bArr22[1][(bArr22[0][b22] & 255) ^ b2(i14)] & 255) ^ b2(i13)];
        int[] iArr32 = this.gMDS3;
        byte[] bArr42 = bArr22[1];
        i12 = iArr32[(bArr42[(bArr42[b32] & 255) ^ b3(i14)] & 255) ^ b3(i13)];
        return i11 ^ i12;
    }

    private int Fe32_0(int i10) {
        int[] iArr = this.gSBox;
        return iArr[(((i10 >>> 24) & 255) * 2) + 513] ^ ((iArr[((i10 & 255) * 2) + 0] ^ iArr[(((i10 >>> 8) & 255) * 2) + 1]) ^ iArr[(((i10 >>> 16) & 255) * 2) + 512]);
    }

    private int Fe32_3(int i10) {
        int[] iArr = this.gSBox;
        return iArr[(((i10 >>> 16) & 255) * 2) + 513] ^ ((iArr[(((i10 >>> 24) & 255) * 2) + 0] ^ iArr[((i10 & 255) * 2) + 1]) ^ iArr[(((i10 >>> 8) & 255) * 2) + 512]);
    }

    private int LFSR1(int i10) {
        return ((i10 & 1) != 0 ? 180 : 0) ^ (i10 >> 1);
    }

    private int LFSR2(int i10) {
        int i11 = 0;
        int i12 = (i10 >> 2) ^ ((i10 & 2) != 0 ? 180 : 0);
        if ((i10 & 1) != 0) {
            i11 = 90;
        }
        return i12 ^ i11;
    }

    private int Mx_X(int i10) {
        return i10 ^ LFSR2(i10);
    }

    private int Mx_Y(int i10) {
        return LFSR2(i10) ^ (LFSR1(i10) ^ i10);
    }

    private int RS_MDS_Encode(int i10, int i11) {
        for (int i12 = 0; i12 < 4; i12++) {
            i11 = RS_rem(i11);
        }
        int i13 = i10 ^ i11;
        for (int i14 = 0; i14 < 4; i14++) {
            i13 = RS_rem(i13);
        }
        return i13;
    }

    private int RS_rem(int i10) {
        int i11 = (i10 >>> 24) & 255;
        int i12 = 0;
        int i13 = ((i11 << 1) ^ ((i11 & 128) != 0 ? RS_GF_FDBK : 0)) & 255;
        int i14 = i11 >>> 1;
        if ((i11 & 1) != 0) {
            i12 = Opcodes.IF_ACMPNE;
        }
        int i15 = (i14 ^ i12) ^ i13;
        return ((((i10 << 8) ^ (i15 << 24)) ^ (i13 << 16)) ^ (i15 << 8)) ^ i11;
    }

    private int b0(int i10) {
        return i10 & 255;
    }

    private int b1(int i10) {
        return (i10 >>> 8) & 255;
    }

    private int b2(int i10) {
        return (i10 >>> 16) & 255;
    }

    private int b3(int i10) {
        return (i10 >>> 24) & 255;
    }

    private void decryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int BytesTo32Bits = BytesTo32Bits(bArr, i10) ^ this.gSubKeys[4];
        int BytesTo32Bits2 = BytesTo32Bits(bArr, i10 + 4) ^ this.gSubKeys[5];
        int BytesTo32Bits3 = BytesTo32Bits(bArr, i10 + 8) ^ this.gSubKeys[6];
        int BytesTo32Bits4 = BytesTo32Bits(bArr, i10 + 12) ^ this.gSubKeys[7];
        int i12 = 39;
        for (int i13 = 0; i13 < 16; i13 += 2) {
            int Fe32_0 = Fe32_0(BytesTo32Bits);
            int Fe32_3 = Fe32_3(BytesTo32Bits2);
            int[] iArr = this.gSubKeys;
            int i14 = i12 - 1;
            int i15 = BytesTo32Bits4 ^ (((Fe32_3 * 2) + Fe32_0) + iArr[i12]);
            int i16 = i14 - 1;
            BytesTo32Bits3 = ((BytesTo32Bits3 >>> 31) | (BytesTo32Bits3 << 1)) ^ ((Fe32_0 + Fe32_3) + iArr[i14]);
            BytesTo32Bits4 = (i15 << 31) | (i15 >>> 1);
            int Fe32_02 = Fe32_0(BytesTo32Bits3);
            int Fe32_32 = Fe32_3(BytesTo32Bits4);
            int[] iArr2 = this.gSubKeys;
            int i17 = i16 - 1;
            int i18 = BytesTo32Bits2 ^ (((Fe32_32 * 2) + Fe32_02) + iArr2[i16]);
            i12 = i17 - 1;
            BytesTo32Bits = ((BytesTo32Bits >>> 31) | (BytesTo32Bits << 1)) ^ ((Fe32_02 + Fe32_32) + iArr2[i17]);
            BytesTo32Bits2 = (i18 << 31) | (i18 >>> 1);
        }
        Bits32ToBytes(this.gSubKeys[0] ^ BytesTo32Bits3, bArr2, i11);
        Bits32ToBytes(BytesTo32Bits4 ^ this.gSubKeys[1], bArr2, i11 + 4);
        Bits32ToBytes(this.gSubKeys[2] ^ BytesTo32Bits, bArr2, i11 + 8);
        Bits32ToBytes(this.gSubKeys[3] ^ BytesTo32Bits2, bArr2, i11 + 12);
    }

    private void encryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int i12 = 0;
        int BytesTo32Bits = BytesTo32Bits(bArr, i10) ^ this.gSubKeys[0];
        int BytesTo32Bits2 = BytesTo32Bits(bArr, i10 + 4) ^ this.gSubKeys[1];
        int BytesTo32Bits3 = BytesTo32Bits(bArr, i10 + 8) ^ this.gSubKeys[2];
        int BytesTo32Bits4 = BytesTo32Bits(bArr, i10 + 12) ^ this.gSubKeys[3];
        int i13 = 8;
        while (i12 < 16) {
            int Fe32_0 = Fe32_0(BytesTo32Bits);
            int Fe32_3 = Fe32_3(BytesTo32Bits2);
            int[] iArr = this.gSubKeys;
            int i14 = i13 + 1;
            int i15 = BytesTo32Bits3 ^ ((Fe32_0 + Fe32_3) + iArr[i13]);
            BytesTo32Bits3 = (i15 >>> 1) | (i15 << 31);
            int i16 = (BytesTo32Bits4 >>> 31) | (BytesTo32Bits4 << 1);
            int i17 = i14 + 1;
            BytesTo32Bits4 = i16 ^ ((Fe32_0 + (Fe32_3 * 2)) + iArr[i14]);
            int Fe32_02 = Fe32_0(BytesTo32Bits3);
            int Fe32_32 = Fe32_3(BytesTo32Bits4);
            int[] iArr2 = this.gSubKeys;
            int i18 = i17 + 1;
            int i19 = BytesTo32Bits ^ ((Fe32_02 + Fe32_32) + iArr2[i17]);
            BytesTo32Bits = (i19 >>> 1) | (i19 << 31);
            i12 += 2;
            BytesTo32Bits2 = ((BytesTo32Bits2 << 1) | (BytesTo32Bits2 >>> 31)) ^ ((Fe32_02 + (Fe32_32 * 2)) + iArr2[i18]);
            i13 = i18 + 1;
        }
        Bits32ToBytes(this.gSubKeys[4] ^ BytesTo32Bits3, bArr2, i11);
        Bits32ToBytes(BytesTo32Bits4 ^ this.gSubKeys[5], bArr2, i11 + 4);
        Bits32ToBytes(this.gSubKeys[6] ^ BytesTo32Bits, bArr2, i11 + 8);
        Bits32ToBytes(this.gSubKeys[7] ^ BytesTo32Bits2, bArr2, i11 + 12);
    }

    private void setKey(byte[] bArr) {
        byte b10;
        byte b11;
        byte b12;
        byte b13;
        byte b14;
        byte b15;
        byte b16;
        byte b17;
        byte[] bArr2 = bArr;
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        this.gSubKeys = new int[40];
        int i10 = this.k64Cnt;
        if (i10 < 1) {
            throw new IllegalArgumentException("Key size less than 64 bits");
        } else if (i10 <= 4) {
            for (int i11 = 0; i11 < this.k64Cnt; i11++) {
                int i12 = i11 * 8;
                iArr[i11] = BytesTo32Bits(bArr2, i12);
                int BytesTo32Bits = BytesTo32Bits(bArr2, i12 + 4);
                iArr2[i11] = BytesTo32Bits;
                iArr3[(this.k64Cnt - 1) - i11] = RS_MDS_Encode(iArr[i11], BytesTo32Bits);
            }
            for (int i13 = 0; i13 < 20; i13++) {
                int i14 = SK_STEP * i13;
                int F32 = F32(i14, iArr);
                int F322 = F32(i14 + SK_BUMP, iArr2);
                int i15 = (F322 >>> 24) | (F322 << 8);
                int i16 = F32 + i15;
                int[] iArr4 = this.gSubKeys;
                int i17 = i13 * 2;
                iArr4[i17] = i16;
                int i18 = i16 + i15;
                iArr4[i17 + 1] = (i18 << 9) | (i18 >>> 23);
            }
            int i19 = iArr3[0];
            int i20 = iArr3[1];
            int i21 = 2;
            int i22 = iArr3[2];
            int i23 = iArr3[3];
            this.gSBox = new int[1024];
            int i24 = 0;
            while (i24 < 256) {
                int i25 = this.k64Cnt & 3;
                if (i25 != 0) {
                    if (i25 == 1) {
                        int[] iArr5 = this.gSBox;
                        int i26 = i24 * 2;
                        int[] iArr6 = this.gMDS0;
                        byte[][] bArr3 = P;
                        iArr5[i26] = iArr6[(bArr3[0][i24] & 255) ^ b0(i19)];
                        this.gSBox[i26 + 1] = this.gMDS1[(bArr3[0][i24] & 255) ^ b1(i19)];
                        this.gSBox[i26 + 512] = this.gMDS2[(bArr3[1][i24] & 255) ^ b2(i19)];
                        this.gSBox[i26 + 513] = this.gMDS3[(bArr3[1][i24] & 255) ^ b3(i19)];
                    } else if (i25 == i21) {
                        b13 = i24;
                        b12 = b13;
                        b11 = b12;
                        b10 = b11;
                        int[] iArr7 = this.gSBox;
                        int i27 = i24 * 2;
                        int[] iArr8 = this.gMDS0;
                        byte[][] bArr4 = P;
                        byte[] bArr5 = bArr4[0];
                        iArr7[i27] = iArr8[(bArr5[(bArr5[b12] & 255) ^ b0(i20)] & 255) ^ b0(i19)];
                        this.gSBox[i27 + 1] = this.gMDS1[(bArr4[0][(bArr4[1][b11] & 255) ^ b1(i20)] & 255) ^ b1(i19)];
                        this.gSBox[i27 + 512] = this.gMDS2[(bArr4[1][(bArr4[0][b10] & 255) ^ b2(i20)] & 255) ^ b2(i19)];
                        int[] iArr9 = this.gMDS3;
                        byte[] bArr6 = bArr4[1];
                        this.gSBox[i27 + 513] = iArr9[(bArr6[(bArr6[b13] & 255) ^ b3(i20)] & 255) ^ b3(i19)];
                    } else if (i25 == 3) {
                        b17 = i24;
                        b16 = b17;
                        b15 = b16;
                        b14 = b15;
                    }
                    i24++;
                    i21 = 2;
                } else {
                    byte[][] bArr7 = P;
                    b16 = (bArr7[1][i24] & 255) ^ b0(i23);
                    b15 = (bArr7[0][i24] & 255) ^ b1(i23);
                    b14 = (bArr7[0][i24] & 255) ^ b2(i23);
                    b17 = (bArr7[1][i24] & 255) ^ b3(i23);
                }
                byte[][] bArr8 = P;
                b12 = (bArr8[1][b16] & 255) ^ b0(i22);
                b11 = (bArr8[1][b15] & 255) ^ b1(i22);
                b10 = (bArr8[0][b14] & 255) ^ b2(i22);
                b13 = (bArr8[0][b17] & 255) ^ b3(i22);
                int[] iArr72 = this.gSBox;
                int i272 = i24 * 2;
                int[] iArr82 = this.gMDS0;
                byte[][] bArr42 = P;
                byte[] bArr52 = bArr42[0];
                iArr72[i272] = iArr82[(bArr52[(bArr52[b12] & 255) ^ b0(i20)] & 255) ^ b0(i19)];
                this.gSBox[i272 + 1] = this.gMDS1[(bArr42[0][(bArr42[1][b11] & 255) ^ b1(i20)] & 255) ^ b1(i19)];
                this.gSBox[i272 + 512] = this.gMDS2[(bArr42[1][(bArr42[0][b10] & 255) ^ b2(i20)] & 255) ^ b2(i19)];
                int[] iArr92 = this.gMDS3;
                byte[] bArr62 = bArr42[1];
                this.gSBox[i272 + 513] = iArr92[(bArr62[(bArr62[b13] & 255) ^ b3(i20)] & 255) ^ b3(i19)];
                i24++;
                i21 = 2;
            }
        } else {
            throw new IllegalArgumentException("Key size larger than 256 bits");
        }
    }

    public String getAlgorithmName() {
        return "Twofish";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.encrypting = z10;
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            this.workingKey = key;
            this.k64Cnt = key.length / 8;
            setKey(key);
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to Twofish init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        if (this.workingKey == null) {
            throw new IllegalStateException("Twofish not initialised");
        } else if (i10 + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i11 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        } else if (this.encrypting) {
            encryptBlock(bArr, i10, bArr2, i11);
            return 16;
        } else {
            decryptBlock(bArr, i10, bArr2, i11);
            return 16;
        }
    }

    public void reset() {
        byte[] bArr = this.workingKey;
        if (bArr != null) {
            setKey(bArr);
        }
    }
}
