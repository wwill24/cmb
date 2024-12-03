package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;

public class CamelliaLightEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final int MASK8 = 255;
    private static final byte[] SBOX1 = {112, -126, 44, -20, -77, 39, -64, -27, -28, -123, 87, 53, -22, 12, -82, 65, 35, -17, 107, -109, 69, 25, -91, Framer.ENTER_FRAME_PREFIX, -19, 14, 79, 78, 29, 101, -110, -67, -122, -72, -81, -113, 124, -21, 31, -50, 62, 48, -36, Framer.STDIN_REQUEST_FRAME_PREFIX, 94, -59, 11, 26, -90, -31, 57, -54, -43, 71, 93, 61, -39, 1, 90, -42, 81, 86, 108, 77, -117, 13, -102, 102, -5, -52, -80, Framer.STDIN_FRAME_PREFIX, 116, 18, 43, 32, -16, -79, -124, -103, -33, 76, -53, -62, 52, 126, 118, 5, 109, -73, -87, Framer.STDOUT_FRAME_PREFIX, -47, 23, 4, -41, 20, 88, 58, 97, -34, 27, 17, 28, Framer.STDERR_FRAME_PREFIX, 15, -100, 22, 83, 24, -14, 34, -2, 68, -49, -78, -61, -75, 122, -111, 36, 8, -24, -88, 96, -4, 105, 80, -86, -48, -96, 125, -95, -119, 98, -105, 84, 91, 30, -107, -32, -1, 100, -46, Tnaf.POW_2_WIDTH, -60, 0, 72, -93, -9, 117, -37, -118, 3, -26, -38, 9, 63, -35, -108, -121, 92, -125, 2, -51, 74, -112, 51, 115, 103, -10, -13, -99, Byte.MAX_VALUE, -65, -30, 82, -101, -40, 38, -56, 55, -58, 59, -127, -106, 111, 75, 19, -66, 99, 46, -23, 121, -89, -116, -97, 110, PSSSigner.TRAILER_IMPLICIT, -114, 41, -11, -7, -74, 47, -3, -76, 89, Framer.EXIT_FRAME_PREFIX, -104, 6, 106, -25, 70, 113, -70, -44, 37, -85, 66, -120, -94, -115, -6, 114, 7, -71, 85, -8, -18, -84, 10, 54, 73, 42, 104, 60, 56, -15, -92, 64, 40, -45, 123, -69, -55, 67, -63, 21, -29, -83, -12, 119, -57, Byte.MIN_VALUE, -98};
    private static final int[] SIGMA = {-1600231809, 1003262091, -1233459112, 1286239154, -957401297, -380665154, 1426019237, -237801700, 283453434, -563598051, -1336506174, -1276722691};
    private boolean _keyis128;
    private boolean initialized;

    /* renamed from: ke  reason: collision with root package name */
    private int[] f41419ke = new int[12];
    private int[] kw = new int[8];
    private int[] state = new int[4];
    private int[] subkey = new int[96];

    private int bytes2int(byte[] bArr, int i10) {
        int i11 = 0;
        for (int i12 = 0; i12 < 4; i12++) {
            i11 = (i11 << 8) + (bArr[i12 + i10] & 255);
        }
        return i11;
    }

    private void camelliaF2(int[] iArr, int[] iArr2, int i10) {
        int i11 = iArr[0] ^ iArr2[i10 + 0];
        int sbox4 = sbox4(i11 & 255) | (sbox3((i11 >>> 8) & 255) << 8) | (sbox2((i11 >>> 16) & 255) << 16);
        byte[] bArr = SBOX1;
        int i12 = iArr[1] ^ iArr2[i10 + 1];
        int leftRotate = leftRotate((sbox2((i12 >>> 24) & 255) << 24) | (bArr[i12 & 255] & 255) | (sbox4((i12 >>> 8) & 255) << 8) | (sbox3((i12 >>> 16) & 255) << 16), 8);
        int i13 = (((bArr[(i11 >>> 24) & 255] & 255) << 24) | sbox4) ^ leftRotate;
        int leftRotate2 = leftRotate(leftRotate, 8) ^ i13;
        int rightRotate = rightRotate(i13, 8) ^ leftRotate2;
        iArr[2] = (leftRotate(leftRotate2, 16) ^ rightRotate) ^ iArr[2];
        iArr[3] = leftRotate(rightRotate, 8) ^ iArr[3];
        int i14 = iArr[2] ^ iArr2[i10 + 2];
        int sbox42 = ((bArr[(i14 >>> 24) & 255] & 255) << 24) | sbox4(i14 & 255) | (sbox3((i14 >>> 8) & 255) << 8) | (sbox2((i14 >>> 16) & 255) << 16);
        int i15 = iArr2[i10 + 3] ^ iArr[3];
        int leftRotate3 = leftRotate((sbox2((i15 >>> 24) & 255) << 24) | (bArr[i15 & 255] & 255) | (sbox4((i15 >>> 8) & 255) << 8) | (sbox3((i15 >>> 16) & 255) << 16), 8);
        int i16 = sbox42 ^ leftRotate3;
        int leftRotate4 = leftRotate(leftRotate3, 8) ^ i16;
        int rightRotate2 = rightRotate(i16, 8) ^ leftRotate4;
        iArr[0] = (leftRotate(leftRotate4, 16) ^ rightRotate2) ^ iArr[0];
        iArr[1] = iArr[1] ^ leftRotate(rightRotate2, 8);
    }

    private void camelliaFLs(int[] iArr, int[] iArr2, int i10) {
        int leftRotate = iArr[1] ^ leftRotate(iArr[0] & iArr2[i10 + 0], 1);
        iArr[1] = leftRotate;
        iArr[0] = (leftRotate | iArr2[i10 + 1]) ^ iArr[0];
        int i11 = iArr[2];
        int i12 = iArr2[i10 + 3];
        int i13 = iArr[3];
        int i14 = i11 ^ (i12 | i13);
        iArr[2] = i14;
        iArr[3] = leftRotate(iArr2[i10 + 2] & i14, 1) ^ i13;
    }

    private static void decroldq(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        int i13 = i12 + 2;
        int i14 = i11 + 0;
        int i15 = i11 + 1;
        int i16 = 32 - i10;
        iArr2[i13] = (iArr[i14] << i10) | (iArr[i15] >>> i16);
        int i17 = i12 + 3;
        int i18 = i11 + 2;
        iArr2[i17] = (iArr[i15] << i10) | (iArr[i18] >>> i16);
        int i19 = i12 + 0;
        int i20 = i11 + 3;
        iArr2[i19] = (iArr[i18] << i10) | (iArr[i20] >>> i16);
        int i21 = i12 + 1;
        iArr2[i21] = (iArr[i20] << i10) | (iArr[i14] >>> i16);
        iArr[i14] = iArr2[i13];
        iArr[i15] = iArr2[i17];
        iArr[i18] = iArr2[i19];
        iArr[i20] = iArr2[i21];
    }

    private static void decroldqo32(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        int i13 = i12 + 2;
        int i14 = i11 + 1;
        int i15 = i10 - 32;
        int i16 = i11 + 2;
        int i17 = 64 - i10;
        iArr2[i13] = (iArr[i14] << i15) | (iArr[i16] >>> i17);
        int i18 = i12 + 3;
        int i19 = i11 + 3;
        iArr2[i18] = (iArr[i16] << i15) | (iArr[i19] >>> i17);
        int i20 = i12 + 0;
        int i21 = i11 + 0;
        iArr2[i20] = (iArr[i19] << i15) | (iArr[i21] >>> i17);
        int i22 = i12 + 1;
        iArr2[i22] = (iArr[i14] >>> i17) | (iArr[i21] << i15);
        iArr[i21] = iArr2[i13];
        iArr[i14] = iArr2[i18];
        iArr[i16] = iArr2[i20];
        iArr[i19] = iArr2[i22];
    }

    private void int2bytes(int i10, byte[] bArr, int i11) {
        for (int i12 = 0; i12 < 4; i12++) {
            bArr[(3 - i12) + i11] = (byte) i10;
            i10 >>>= 8;
        }
    }

    private byte lRot8(byte b10, int i10) {
        return (byte) (((b10 & 255) >>> (8 - i10)) | (b10 << i10));
    }

    private static int leftRotate(int i10, int i11) {
        return (i10 << i11) + (i10 >>> (32 - i11));
    }

    private int processBlock128(byte[] bArr, int i10, byte[] bArr2, int i11) {
        for (int i12 = 0; i12 < 4; i12++) {
            this.state[i12] = bytes2int(bArr, (i12 * 4) + i10);
            int[] iArr = this.state;
            iArr[i12] = iArr[i12] ^ this.kw[i12];
        }
        camelliaF2(this.state, this.subkey, 0);
        camelliaF2(this.state, this.subkey, 4);
        camelliaF2(this.state, this.subkey, 8);
        camelliaFLs(this.state, this.f41419ke, 0);
        camelliaF2(this.state, this.subkey, 12);
        camelliaF2(this.state, this.subkey, 16);
        camelliaF2(this.state, this.subkey, 20);
        camelliaFLs(this.state, this.f41419ke, 4);
        camelliaF2(this.state, this.subkey, 24);
        camelliaF2(this.state, this.subkey, 28);
        camelliaF2(this.state, this.subkey, 32);
        int[] iArr2 = this.state;
        int i13 = iArr2[2];
        int[] iArr3 = this.kw;
        int i14 = iArr3[4] ^ i13;
        iArr2[2] = i14;
        iArr2[3] = iArr2[3] ^ iArr3[5];
        iArr2[0] = iArr2[0] ^ iArr3[6];
        iArr2[1] = iArr3[7] ^ iArr2[1];
        int2bytes(i14, bArr2, i11);
        int2bytes(this.state[3], bArr2, i11 + 4);
        int2bytes(this.state[0], bArr2, i11 + 8);
        int2bytes(this.state[1], bArr2, i11 + 12);
        return 16;
    }

    private int processBlock192or256(byte[] bArr, int i10, byte[] bArr2, int i11) {
        for (int i12 = 0; i12 < 4; i12++) {
            this.state[i12] = bytes2int(bArr, (i12 * 4) + i10);
            int[] iArr = this.state;
            iArr[i12] = iArr[i12] ^ this.kw[i12];
        }
        camelliaF2(this.state, this.subkey, 0);
        camelliaF2(this.state, this.subkey, 4);
        camelliaF2(this.state, this.subkey, 8);
        camelliaFLs(this.state, this.f41419ke, 0);
        camelliaF2(this.state, this.subkey, 12);
        camelliaF2(this.state, this.subkey, 16);
        camelliaF2(this.state, this.subkey, 20);
        camelliaFLs(this.state, this.f41419ke, 4);
        camelliaF2(this.state, this.subkey, 24);
        camelliaF2(this.state, this.subkey, 28);
        camelliaF2(this.state, this.subkey, 32);
        camelliaFLs(this.state, this.f41419ke, 8);
        camelliaF2(this.state, this.subkey, 36);
        camelliaF2(this.state, this.subkey, 40);
        camelliaF2(this.state, this.subkey, 44);
        int[] iArr2 = this.state;
        int i13 = iArr2[2];
        int[] iArr3 = this.kw;
        int i14 = i13 ^ iArr3[4];
        iArr2[2] = i14;
        iArr2[3] = iArr2[3] ^ iArr3[5];
        iArr2[0] = iArr2[0] ^ iArr3[6];
        iArr2[1] = iArr3[7] ^ iArr2[1];
        int2bytes(i14, bArr2, i11);
        int2bytes(this.state[3], bArr2, i11 + 4);
        int2bytes(this.state[0], bArr2, i11 + 8);
        int2bytes(this.state[1], bArr2, i11 + 12);
        return 16;
    }

    private static int rightRotate(int i10, int i11) {
        return (i10 >>> i11) + (i10 << (32 - i11));
    }

    private static void roldq(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        int i13 = i12 + 0;
        int i14 = i11 + 0;
        int i15 = i11 + 1;
        int i16 = 32 - i10;
        iArr2[i13] = (iArr[i14] << i10) | (iArr[i15] >>> i16);
        int i17 = i12 + 1;
        int i18 = i11 + 2;
        iArr2[i17] = (iArr[i15] << i10) | (iArr[i18] >>> i16);
        int i19 = i12 + 2;
        int i20 = i11 + 3;
        iArr2[i19] = (iArr[i18] << i10) | (iArr[i20] >>> i16);
        int i21 = i12 + 3;
        iArr2[i21] = (iArr[i20] << i10) | (iArr[i14] >>> i16);
        iArr[i14] = iArr2[i13];
        iArr[i15] = iArr2[i17];
        iArr[i18] = iArr2[i19];
        iArr[i20] = iArr2[i21];
    }

    private static void roldqo32(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        int i13 = i12 + 0;
        int i14 = i11 + 1;
        int i15 = i10 - 32;
        int i16 = i11 + 2;
        int i17 = 64 - i10;
        iArr2[i13] = (iArr[i14] << i15) | (iArr[i16] >>> i17);
        int i18 = i12 + 1;
        int i19 = i11 + 3;
        iArr2[i18] = (iArr[i16] << i15) | (iArr[i19] >>> i17);
        int i20 = i12 + 2;
        int i21 = i11 + 0;
        iArr2[i20] = (iArr[i19] << i15) | (iArr[i21] >>> i17);
        int i22 = i12 + 3;
        iArr2[i22] = (iArr[i14] >>> i17) | (iArr[i21] << i15);
        iArr[i21] = iArr2[i13];
        iArr[i14] = iArr2[i18];
        iArr[i16] = iArr2[i20];
        iArr[i19] = iArr2[i22];
    }

    private int sbox2(int i10) {
        return lRot8(SBOX1[i10], 1) & 255;
    }

    private int sbox3(int i10) {
        return lRot8(SBOX1[i10], 7) & 255;
    }

    private int sbox4(int i10) {
        return SBOX1[lRot8((byte) i10, 1) & 255] & 255;
    }

    private void setKey(boolean z10, byte[] bArr) {
        byte[] bArr2 = bArr;
        int[] iArr = new int[8];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        int[] iArr4 = new int[4];
        int length = bArr2.length;
        if (length != 16) {
            if (length == 24) {
                iArr[0] = bytes2int(bArr2, 0);
                iArr[1] = bytes2int(bArr2, 4);
                iArr[2] = bytes2int(bArr2, 8);
                iArr[3] = bytes2int(bArr2, 12);
                iArr[4] = bytes2int(bArr2, 16);
                int bytes2int = bytes2int(bArr2, 20);
                iArr[5] = bytes2int;
                iArr[6] = ~iArr[4];
                iArr[7] = ~bytes2int;
            } else if (length == 32) {
                iArr[0] = bytes2int(bArr2, 0);
                iArr[1] = bytes2int(bArr2, 4);
                iArr[2] = bytes2int(bArr2, 8);
                iArr[3] = bytes2int(bArr2, 12);
                iArr[4] = bytes2int(bArr2, 16);
                iArr[5] = bytes2int(bArr2, 20);
                iArr[6] = bytes2int(bArr2, 24);
                iArr[7] = bytes2int(bArr2, 28);
            } else {
                throw new IllegalArgumentException("key sizes are only 16/24/32 bytes.");
            }
            this._keyis128 = false;
        } else {
            this._keyis128 = true;
            iArr[0] = bytes2int(bArr2, 0);
            iArr[1] = bytes2int(bArr2, 4);
            iArr[2] = bytes2int(bArr2, 8);
            iArr[3] = bytes2int(bArr2, 12);
            iArr[7] = 0;
            iArr[6] = 0;
            iArr[5] = 0;
            iArr[4] = 0;
        }
        for (int i10 = 0; i10 < 4; i10++) {
            iArr2[i10] = iArr[i10] ^ iArr[i10 + 4];
        }
        camelliaF2(iArr2, SIGMA, 0);
        for (int i11 = 0; i11 < 4; i11++) {
            iArr2[i11] = iArr2[i11] ^ iArr[i11];
        }
        camelliaF2(iArr2, SIGMA, 4);
        if (this._keyis128) {
            int[] iArr5 = this.kw;
            if (z10) {
                iArr5[0] = iArr[0];
                iArr5[1] = iArr[1];
                iArr5[2] = iArr[2];
                iArr5[3] = iArr[3];
                roldq(15, iArr, 0, this.subkey, 4);
                roldq(30, iArr, 0, this.subkey, 12);
                roldq(15, iArr, 0, iArr4, 0);
                int[] iArr6 = this.subkey;
                iArr6[18] = iArr4[2];
                iArr6[19] = iArr4[3];
                roldq(17, iArr, 0, this.f41419ke, 4);
                roldq(17, iArr, 0, this.subkey, 24);
                roldq(17, iArr, 0, this.subkey, 32);
                int[] iArr7 = this.subkey;
                iArr7[0] = iArr2[0];
                iArr7[1] = iArr2[1];
                iArr7[2] = iArr2[2];
                iArr7[3] = iArr2[3];
                roldq(15, iArr2, 0, iArr7, 8);
                roldq(15, iArr2, 0, this.f41419ke, 0);
                roldq(15, iArr2, 0, iArr4, 0);
                int[] iArr8 = this.subkey;
                iArr8[16] = iArr4[0];
                iArr8[17] = iArr4[1];
                roldq(15, iArr2, 0, iArr8, 20);
                roldqo32(34, iArr2, 0, this.subkey, 28);
                roldq(17, iArr2, 0, this.kw, 4);
                return;
            }
            iArr5[4] = iArr[0];
            iArr5[5] = iArr[1];
            iArr5[6] = iArr[2];
            iArr5[7] = iArr[3];
            decroldq(15, iArr, 0, this.subkey, 28);
            decroldq(30, iArr, 0, this.subkey, 20);
            decroldq(15, iArr, 0, iArr4, 0);
            int[] iArr9 = this.subkey;
            iArr9[16] = iArr4[0];
            iArr9[17] = iArr4[1];
            decroldq(17, iArr, 0, this.f41419ke, 0);
            decroldq(17, iArr, 0, this.subkey, 8);
            decroldq(17, iArr, 0, this.subkey, 0);
            int[] iArr10 = this.subkey;
            iArr10[34] = iArr2[0];
            iArr10[35] = iArr2[1];
            iArr10[32] = iArr2[2];
            iArr10[33] = iArr2[3];
            decroldq(15, iArr2, 0, iArr10, 24);
            decroldq(15, iArr2, 0, this.f41419ke, 4);
            decroldq(15, iArr2, 0, iArr4, 0);
            int[] iArr11 = this.subkey;
            iArr11[18] = iArr4[2];
            iArr11[19] = iArr4[3];
            decroldq(15, iArr2, 0, iArr11, 12);
            decroldqo32(34, iArr2, 0, this.subkey, 4);
            roldq(17, iArr2, 0, this.kw, 0);
            return;
        }
        for (int i12 = 0; i12 < 4; i12++) {
            iArr3[i12] = iArr2[i12] ^ iArr[i12 + 4];
        }
        camelliaF2(iArr3, SIGMA, 8);
        int[] iArr12 = this.kw;
        if (z10) {
            iArr12[0] = iArr[0];
            iArr12[1] = iArr[1];
            iArr12[2] = iArr[2];
            iArr12[3] = iArr[3];
            roldqo32(45, iArr, 0, this.subkey, 16);
            roldq(15, iArr, 0, this.f41419ke, 4);
            roldq(17, iArr, 0, this.subkey, 32);
            roldqo32(34, iArr, 0, this.subkey, 44);
            roldq(15, iArr, 4, this.subkey, 4);
            roldq(15, iArr, 4, this.f41419ke, 0);
            roldq(30, iArr, 4, this.subkey, 24);
            roldqo32(34, iArr, 4, this.subkey, 36);
            roldq(15, iArr2, 0, this.subkey, 8);
            roldq(30, iArr2, 0, this.subkey, 20);
            int[] iArr13 = this.f41419ke;
            iArr13[8] = iArr2[1];
            iArr13[9] = iArr2[2];
            iArr13[10] = iArr2[3];
            iArr13[11] = iArr2[0];
            roldqo32(49, iArr2, 0, this.subkey, 40);
            int[] iArr14 = this.subkey;
            iArr14[0] = iArr3[0];
            iArr14[1] = iArr3[1];
            iArr14[2] = iArr3[2];
            iArr14[3] = iArr3[3];
            roldq(30, iArr3, 0, iArr14, 12);
            roldq(30, iArr3, 0, this.subkey, 28);
            roldqo32(51, iArr3, 0, this.kw, 4);
            return;
        }
        iArr12[4] = iArr[0];
        iArr12[5] = iArr[1];
        iArr12[6] = iArr[2];
        iArr12[7] = iArr[3];
        decroldqo32(45, iArr, 0, this.subkey, 28);
        decroldq(15, iArr, 0, this.f41419ke, 4);
        decroldq(17, iArr, 0, this.subkey, 12);
        decroldqo32(34, iArr, 0, this.subkey, 0);
        decroldq(15, iArr, 4, this.subkey, 40);
        decroldq(15, iArr, 4, this.f41419ke, 8);
        decroldq(30, iArr, 4, this.subkey, 20);
        decroldqo32(34, iArr, 4, this.subkey, 8);
        decroldq(15, iArr2, 0, this.subkey, 36);
        decroldq(30, iArr2, 0, this.subkey, 24);
        int[] iArr15 = this.f41419ke;
        iArr15[2] = iArr2[1];
        iArr15[3] = iArr2[2];
        iArr15[0] = iArr2[3];
        iArr15[1] = iArr2[0];
        decroldqo32(49, iArr2, 0, this.subkey, 4);
        int[] iArr16 = this.subkey;
        iArr16[46] = iArr3[0];
        iArr16[47] = iArr3[1];
        iArr16[44] = iArr3[2];
        iArr16[45] = iArr3[3];
        decroldq(30, iArr3, 0, iArr16, 32);
        decroldq(30, iArr3, 0, this.subkey, 16);
        roldqo32(51, iArr3, 0, this.kw, 0);
    }

    public String getAlgorithmName() {
        return "Camellia";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            setKey(z10, ((KeyParameter) cipherParameters).getKey());
            this.initialized = true;
            return;
        }
        throw new IllegalArgumentException("only simple KeyParameter expected.");
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException {
        if (!this.initialized) {
            throw new IllegalStateException("Camellia is not initialized");
        } else if (i10 + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i11 + 16 <= bArr2.length) {
            return this._keyis128 ? processBlock128(bArr, i10, bArr2, i11) : processBlock192or256(bArr, i10, bArr2, i11);
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
