package org.bouncycastle.crypto.engines;

import com.leanplum.messagetemplates.MessageTemplateConstants;
import java.lang.reflect.Array;
import net.bytebuddy.jar.asm.Opcodes;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Pack;

public class AESLightEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final byte[] S = {99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, Framer.STDOUT_FRAME_PREFIX, 21, 4, -57, 35, -61, 24, -106, 5, -102, 7, 18, Byte.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, 26, 27, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, Byte.MAX_VALUE, 80, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, -38, Framer.ENTER_FRAME_PREFIX, Tnaf.POW_2_WIDTH, -1, -13, -46, -51, 12, 19, -20, Framer.STDIN_REQUEST_FRAME_PREFIX, -105, 68, 23, -60, -89, 126, 61, 100, 93, 25, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, Framer.STDERR_FRAME_PREFIX, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, Framer.EXIT_FRAME_PREFIX, 37, 46, 28, -90, -76, -58, -24, -35, 116, 31, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, 30, -121, -23, -50, 85, 40, -33, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, Framer.STDIN_FRAME_PREFIX, 15, -80, 84, -69, 22};
    private static final byte[] Si = {82, 9, 106, -43, 48, 54, -91, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, Framer.STDERR_FRAME_PREFIX, -90, -62, 35, 61, -18, 76, -107, 11, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, 21, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, 30, -113, -54, 63, 15, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, 110, 71, -15, 26, 113, 29, 41, -59, -119, 111, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, Framer.EXIT_FRAME_PREFIX, -51, 90, -12, 31, -35, -88, 51, -120, 7, -57, Framer.STDOUT_FRAME_PREFIX, -79, 18, Tnaf.POW_2_WIDTH, 89, 39, Byte.MIN_VALUE, -20, Framer.STDIN_REQUEST_FRAME_PREFIX, 96, 81, Byte.MAX_VALUE, -87, 25, -75, 74, 13, Framer.STDIN_FRAME_PREFIX, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, 23, 43, 4, 126, -70, 119, -42, 38, -31, 105, 20, 99, 85, Framer.ENTER_FRAME_PREFIX, 12, 125};

    /* renamed from: m1  reason: collision with root package name */
    private static final int f41413m1 = -2139062144;

    /* renamed from: m2  reason: collision with root package name */
    private static final int f41414m2 = 2139062143;

    /* renamed from: m3  reason: collision with root package name */
    private static final int f41415m3 = 27;

    /* renamed from: m4  reason: collision with root package name */
    private static final int f41416m4 = -1061109568;

    /* renamed from: m5  reason: collision with root package name */
    private static final int f41417m5 = 1061109567;
    private static final int[] rcon = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, Opcodes.LOOKUPSWITCH, 77, Opcodes.IFNE, 47, 94, 188, 99, Opcodes.IFNULL, Opcodes.DCMPL, 53, 106, 212, Opcodes.PUTSTATIC, 125, MessageTemplateConstants.Values.CENTER_POPUP_HEIGHT, 239, Opcodes.MULTIANEWARRAY, Opcodes.I2B};
    private int ROUNDS;
    private int[][] WorkingKey = null;
    private boolean forEncryption;

    private static int FFmulX(int i10) {
        return (((i10 & f41413m1) >>> 7) * 27) ^ ((f41414m2 & i10) << 1);
    }

    private static int FFmulX2(int i10) {
        int i11 = i10 & f41416m4;
        int i12 = i11 ^ (i11 >>> 1);
        return (i12 >>> 5) ^ (((f41417m5 & i10) << 2) ^ (i12 >>> 2));
    }

    private void decryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11, int[][] iArr) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int littleEndianToInt = Pack.littleEndianToInt(bArr3, i10 + 0);
        int littleEndianToInt2 = Pack.littleEndianToInt(bArr3, i10 + 4);
        int littleEndianToInt3 = Pack.littleEndianToInt(bArr3, i10 + 8);
        int littleEndianToInt4 = Pack.littleEndianToInt(bArr3, i10 + 12);
        int i12 = this.ROUNDS;
        int[] iArr2 = iArr[i12];
        int i13 = littleEndianToInt ^ iArr2[0];
        int i14 = littleEndianToInt2 ^ iArr2[1];
        int i15 = littleEndianToInt3 ^ iArr2[2];
        int i16 = i12 - 1;
        int i17 = littleEndianToInt4 ^ iArr2[3];
        while (true) {
            byte[] bArr5 = Si;
            int i18 = i13 & 255;
            if (i16 > 1) {
                int inv_mcol = inv_mcol((((bArr5[i18] & 255) ^ ((bArr5[(i17 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i15 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i14 >> 24) & 255] << 24)) ^ iArr[i16][0];
                int inv_mcol2 = inv_mcol((((bArr5[i14 & 255] & 255) ^ ((bArr5[(i13 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i17 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i15 >> 24) & 255] << 24)) ^ iArr[i16][1];
                int inv_mcol3 = inv_mcol((((bArr5[i15 & 255] & 255) ^ ((bArr5[(i14 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i13 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i17 >> 24) & 255] << 24)) ^ iArr[i16][2];
                int i19 = i16 - 1;
                int inv_mcol4 = inv_mcol((((bArr5[i17 & 255] & 255) ^ ((bArr5[(i15 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i14 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i13 >> 24) & 255] << 24)) ^ iArr[i16][3];
                int inv_mcol5 = inv_mcol((((bArr5[inv_mcol & 255] & 255) ^ ((bArr5[(inv_mcol4 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(inv_mcol3 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(inv_mcol2 >> 24) & 255] << 24)) ^ iArr[i19][0];
                int inv_mcol6 = inv_mcol((((bArr5[inv_mcol2 & 255] & 255) ^ ((bArr5[(inv_mcol >> 8) & 255] & 255) << 8)) ^ ((bArr5[(inv_mcol4 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(inv_mcol3 >> 24) & 255] << 24)) ^ iArr[i19][1];
                int i20 = i19 - 1;
                i17 = inv_mcol((((bArr5[inv_mcol4 & 255] & 255) ^ ((bArr5[(inv_mcol3 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(inv_mcol2 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(inv_mcol >> 24) & 255] << 24)) ^ iArr[i19][3];
                i13 = inv_mcol5;
                i14 = inv_mcol6;
                i15 = inv_mcol((((bArr5[inv_mcol3 & 255] & 255) ^ ((bArr5[(inv_mcol2 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(inv_mcol >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(inv_mcol4 >> 24) & 255] << 24)) ^ iArr[i19][2];
                i16 = i20;
            } else {
                int inv_mcol7 = inv_mcol((((bArr5[i18] & 255) ^ ((bArr5[(i17 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i15 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i14 >> 24) & 255] << 24)) ^ iArr[i16][0];
                int inv_mcol8 = inv_mcol((((bArr5[i14 & 255] & 255) ^ ((bArr5[(i13 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i17 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i15 >> 24) & 255] << 24)) ^ iArr[i16][1];
                int inv_mcol9 = inv_mcol((((bArr5[i15 & 255] & 255) ^ ((bArr5[(i14 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i13 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i17 >> 24) & 255] << 24)) ^ iArr[i16][2];
                int inv_mcol10 = inv_mcol((((bArr5[i17 & 255] & 255) ^ ((bArr5[(i15 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i14 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i13 >> 24) & 255] << 24)) ^ iArr[i16][3];
                byte b10 = (((bArr5[inv_mcol7 & 255] & 255) ^ ((bArr5[(inv_mcol10 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(inv_mcol9 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(inv_mcol8 >> 24) & 255] << 24);
                int[] iArr3 = iArr[0];
                byte b11 = b10 ^ iArr3[0];
                byte b12 = ((((bArr5[inv_mcol8 & 255] & 255) ^ ((bArr5[(inv_mcol7 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(inv_mcol10 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(inv_mcol9 >> 24) & 255] << 24)) ^ iArr3[1];
                byte b13 = ((((bArr5[inv_mcol9 & 255] & 255) ^ ((bArr5[(inv_mcol8 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(inv_mcol7 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(inv_mcol10 >> 24) & 255] << 24)) ^ iArr3[2];
                byte b14 = ((((bArr5[inv_mcol10 & 255] & 255) ^ ((bArr5[(inv_mcol9 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(inv_mcol8 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(inv_mcol7 >> 24) & 255] << 24)) ^ iArr3[3];
                Pack.intToLittleEndian((int) b11, bArr4, i11 + 0);
                Pack.intToLittleEndian((int) b12, bArr4, i11 + 4);
                Pack.intToLittleEndian((int) b13, bArr4, i11 + 8);
                Pack.intToLittleEndian((int) b14, bArr4, i11 + 12);
                return;
            }
        }
    }

    private void encryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11, int[][] iArr) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int littleEndianToInt = Pack.littleEndianToInt(bArr3, i10 + 0);
        int littleEndianToInt2 = Pack.littleEndianToInt(bArr3, i10 + 4);
        int littleEndianToInt3 = Pack.littleEndianToInt(bArr3, i10 + 8);
        int littleEndianToInt4 = Pack.littleEndianToInt(bArr3, i10 + 12);
        int[] iArr2 = iArr[0];
        int i12 = littleEndianToInt ^ iArr2[0];
        int i13 = littleEndianToInt2 ^ iArr2[1];
        int i14 = littleEndianToInt3 ^ iArr2[2];
        int i15 = littleEndianToInt4 ^ iArr2[3];
        int i16 = 1;
        while (i16 < this.ROUNDS - 1) {
            byte[] bArr5 = S;
            int mcol = mcol((((bArr5[i12 & 255] & 255) ^ ((bArr5[(i13 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i14 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i15 >> 24) & 255] << 24)) ^ iArr[i16][0];
            int mcol2 = mcol((((bArr5[i13 & 255] & 255) ^ ((bArr5[(i14 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i15 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i12 >> 24) & 255] << 24)) ^ iArr[i16][1];
            int mcol3 = mcol((((bArr5[i14 & 255] & 255) ^ ((bArr5[(i15 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i12 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i13 >> 24) & 255] << 24)) ^ iArr[i16][2];
            int i17 = i16 + 1;
            int mcol4 = mcol((((bArr5[i15 & 255] & 255) ^ ((bArr5[(i12 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i13 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(i14 >> 24) & 255] << 24)) ^ iArr[i16][3];
            int mcol5 = mcol((((bArr5[mcol & 255] & 255) ^ ((bArr5[(mcol2 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(mcol3 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(mcol4 >> 24) & 255] << 24)) ^ iArr[i17][0];
            int mcol6 = mcol((((bArr5[mcol2 & 255] & 255) ^ ((bArr5[(mcol3 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(mcol4 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(mcol >> 24) & 255] << 24)) ^ iArr[i17][1];
            int i18 = i17 + 1;
            i15 = mcol((((bArr5[mcol4 & 255] & 255) ^ ((bArr5[(mcol >> 8) & 255] & 255) << 8)) ^ ((bArr5[(mcol2 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(mcol3 >> 24) & 255] << 24)) ^ iArr[i17][3];
            i12 = mcol5;
            i13 = mcol6;
            i14 = mcol((((bArr5[mcol3 & 255] & 255) ^ ((bArr5[(mcol4 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(mcol >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(mcol2 >> 24) & 255] << 24)) ^ iArr[i17][2];
            i16 = i18;
        }
        byte[] bArr6 = S;
        int mcol7 = mcol((((bArr6[i12 & 255] & 255) ^ ((bArr6[(i13 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(i14 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(i15 >> 24) & 255] << 24)) ^ iArr[i16][0];
        int mcol8 = mcol((((bArr6[i13 & 255] & 255) ^ ((bArr6[(i14 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(i15 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(i12 >> 24) & 255] << 24)) ^ iArr[i16][1];
        int mcol9 = mcol((((bArr6[i14 & 255] & 255) ^ ((bArr6[(i15 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(i12 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(i13 >> 24) & 255] << 24)) ^ iArr[i16][2];
        int mcol10 = mcol((((bArr6[i15 & 255] & 255) ^ ((bArr6[(i12 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(i13 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(i14 >> 24) & 255] << 24)) ^ iArr[i16][3];
        int[] iArr3 = iArr[i16 + 1];
        byte b10 = ((((bArr6[mcol7 & 255] & 255) ^ ((bArr6[(mcol8 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(mcol9 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(mcol10 >> 24) & 255] << 24)) ^ iArr3[0];
        byte b11 = ((((bArr6[mcol8 & 255] & 255) ^ ((bArr6[(mcol9 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(mcol10 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(mcol7 >> 24) & 255] << 24)) ^ iArr3[1];
        byte b12 = ((((bArr6[mcol9 & 255] & 255) ^ ((bArr6[(mcol10 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(mcol7 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(mcol8 >> 24) & 255] << 24)) ^ iArr3[2];
        byte b13 = ((((bArr6[mcol10 & 255] & 255) ^ ((bArr6[(mcol7 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(mcol8 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(mcol9 >> 24) & 255] << 24)) ^ iArr3[3];
        Pack.intToLittleEndian((int) b10, bArr4, i11 + 0);
        Pack.intToLittleEndian((int) b11, bArr4, i11 + 4);
        Pack.intToLittleEndian((int) b12, bArr4, i11 + 8);
        Pack.intToLittleEndian((int) b13, bArr4, i11 + 12);
    }

    private int[][] generateWorkingKey(byte[] bArr, boolean z10) {
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        if (length < 16 || length > 32 || (length & 7) != 0) {
            throw new IllegalArgumentException("Key length not 128/192/256 bits.");
        }
        int i10 = length >>> 2;
        int i11 = i10 + 6;
        this.ROUNDS = i11;
        int[] iArr = new int[2];
        iArr[1] = 4;
        iArr[0] = i11 + 1;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        int i12 = 8;
        char c10 = 3;
        if (i10 == 4) {
            int littleEndianToInt = Pack.littleEndianToInt(bArr2, 0);
            iArr2[0][0] = littleEndianToInt;
            int littleEndianToInt2 = Pack.littleEndianToInt(bArr2, 4);
            iArr2[0][1] = littleEndianToInt2;
            int littleEndianToInt3 = Pack.littleEndianToInt(bArr2, 8);
            iArr2[0][2] = littleEndianToInt3;
            int littleEndianToInt4 = Pack.littleEndianToInt(bArr2, 12);
            iArr2[0][3] = littleEndianToInt4;
            for (int i13 = 1; i13 <= 10; i13++) {
                littleEndianToInt ^= subWord(shift(littleEndianToInt4, 8)) ^ rcon[i13 - 1];
                int[] iArr3 = iArr2[i13];
                iArr3[0] = littleEndianToInt;
                littleEndianToInt2 ^= littleEndianToInt;
                iArr3[1] = littleEndianToInt2;
                littleEndianToInt3 ^= littleEndianToInt2;
                iArr3[2] = littleEndianToInt3;
                littleEndianToInt4 ^= littleEndianToInt3;
                iArr3[3] = littleEndianToInt4;
            }
        } else if (i10 == 6) {
            int littleEndianToInt5 = Pack.littleEndianToInt(bArr2, 0);
            iArr2[0][0] = littleEndianToInt5;
            int littleEndianToInt6 = Pack.littleEndianToInt(bArr2, 4);
            iArr2[0][1] = littleEndianToInt6;
            int littleEndianToInt7 = Pack.littleEndianToInt(bArr2, 8);
            iArr2[0][2] = littleEndianToInt7;
            int littleEndianToInt8 = Pack.littleEndianToInt(bArr2, 12);
            iArr2[0][3] = littleEndianToInt8;
            int littleEndianToInt9 = Pack.littleEndianToInt(bArr2, 16);
            int littleEndianToInt10 = Pack.littleEndianToInt(bArr2, 20);
            int i14 = 1;
            int i15 = 1;
            while (true) {
                int[] iArr4 = iArr2[i14];
                iArr4[0] = littleEndianToInt9;
                iArr4[1] = littleEndianToInt10;
                int subWord = subWord(shift(littleEndianToInt10, 8)) ^ i15;
                int i16 = i15 << 1;
                int i17 = littleEndianToInt5 ^ subWord;
                int[] iArr5 = iArr2[i14];
                iArr5[2] = i17;
                int i18 = littleEndianToInt6 ^ i17;
                iArr5[3] = i18;
                int i19 = littleEndianToInt7 ^ i18;
                int[] iArr6 = iArr2[i14 + 1];
                iArr6[0] = i19;
                int i20 = littleEndianToInt8 ^ i19;
                iArr6[1] = i20;
                int i21 = littleEndianToInt9 ^ i20;
                iArr6[2] = i21;
                int i22 = littleEndianToInt10 ^ i21;
                iArr6[3] = i22;
                int subWord2 = subWord(shift(i22, 8)) ^ i16;
                i15 = i16 << 1;
                littleEndianToInt5 = i17 ^ subWord2;
                int[] iArr7 = iArr2[i14 + 2];
                iArr7[0] = littleEndianToInt5;
                littleEndianToInt6 = i18 ^ littleEndianToInt5;
                iArr7[1] = littleEndianToInt6;
                littleEndianToInt7 = i19 ^ littleEndianToInt6;
                iArr7[2] = littleEndianToInt7;
                littleEndianToInt8 = i20 ^ littleEndianToInt7;
                iArr7[3] = littleEndianToInt8;
                i14 += 3;
                if (i14 >= 13) {
                    break;
                }
                littleEndianToInt9 = i21 ^ littleEndianToInt8;
                littleEndianToInt10 = i22 ^ littleEndianToInt9;
            }
        } else if (i10 == 8) {
            int littleEndianToInt11 = Pack.littleEndianToInt(bArr2, 0);
            iArr2[0][0] = littleEndianToInt11;
            int littleEndianToInt12 = Pack.littleEndianToInt(bArr2, 4);
            iArr2[0][1] = littleEndianToInt12;
            int littleEndianToInt13 = Pack.littleEndianToInt(bArr2, 8);
            iArr2[0][2] = littleEndianToInt13;
            int littleEndianToInt14 = Pack.littleEndianToInt(bArr2, 12);
            iArr2[0][3] = littleEndianToInt14;
            int littleEndianToInt15 = Pack.littleEndianToInt(bArr2, 16);
            iArr2[1][0] = littleEndianToInt15;
            int littleEndianToInt16 = Pack.littleEndianToInt(bArr2, 20);
            iArr2[1][1] = littleEndianToInt16;
            int littleEndianToInt17 = Pack.littleEndianToInt(bArr2, 24);
            iArr2[1][2] = littleEndianToInt17;
            int littleEndianToInt18 = Pack.littleEndianToInt(bArr2, 28);
            iArr2[1][3] = littleEndianToInt18;
            int i23 = 2;
            int i24 = 1;
            while (true) {
                int subWord3 = subWord(shift(littleEndianToInt18, i12)) ^ i24;
                i24 <<= 1;
                littleEndianToInt11 ^= subWord3;
                int[] iArr8 = iArr2[i23];
                iArr8[0] = littleEndianToInt11;
                littleEndianToInt12 ^= littleEndianToInt11;
                iArr8[1] = littleEndianToInt12;
                littleEndianToInt13 ^= littleEndianToInt12;
                iArr8[2] = littleEndianToInt13;
                littleEndianToInt14 ^= littleEndianToInt13;
                iArr8[c10] = littleEndianToInt14;
                int i25 = i23 + 1;
                if (i25 >= 15) {
                    break;
                }
                littleEndianToInt15 ^= subWord(littleEndianToInt14);
                int[] iArr9 = iArr2[i25];
                iArr9[0] = littleEndianToInt15;
                littleEndianToInt16 ^= littleEndianToInt15;
                iArr9[1] = littleEndianToInt16;
                littleEndianToInt17 ^= littleEndianToInt16;
                iArr9[2] = littleEndianToInt17;
                littleEndianToInt18 ^= littleEndianToInt17;
                iArr9[3] = littleEndianToInt18;
                i23 = i25 + 1;
                i12 = 8;
                c10 = 3;
            }
        } else {
            throw new IllegalStateException("Should never get here");
        }
        if (!z10) {
            for (int i26 = 1; i26 < this.ROUNDS; i26++) {
                for (int i27 = 0; i27 < 4; i27++) {
                    int[] iArr10 = iArr2[i26];
                    iArr10[i27] = inv_mcol(iArr10[i27]);
                }
            }
        }
        return iArr2;
    }

    private static int inv_mcol(int i10) {
        int shift = shift(i10, 8) ^ i10;
        int FFmulX = i10 ^ FFmulX(shift);
        int FFmulX2 = shift ^ FFmulX2(FFmulX);
        return FFmulX ^ (FFmulX2 ^ shift(FFmulX2, 16));
    }

    private static int mcol(int i10) {
        int shift = shift(i10, 8);
        int i11 = i10 ^ shift;
        return FFmulX(i11) ^ (shift ^ shift(i11, 16));
    }

    private static int shift(int i10, int i11) {
        return (i10 << (-i11)) | (i10 >>> i11);
    }

    private static int subWord(int i10) {
        byte[] bArr = S;
        return (bArr[(i10 >> 24) & 255] << 24) | (bArr[i10 & 255] & 255) | ((bArr[(i10 >> 8) & 255] & 255) << 8) | ((bArr[(i10 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH);
    }

    public String getAlgorithmName() {
        return "AES";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.WorkingKey = generateWorkingKey(((KeyParameter) cipherParameters).getKey(), z10);
            this.forEncryption = z10;
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to AES init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int[][] iArr = this.WorkingKey;
        if (iArr == null) {
            throw new IllegalStateException("AES engine not initialised");
        } else if (i10 > bArr.length - 16) {
            throw new DataLengthException("input buffer too short");
        } else if (i11 <= bArr2.length - 16) {
            if (this.forEncryption) {
                encryptBlock(bArr, i10, bArr2, i11, iArr);
            } else {
                decryptBlock(bArr, i10, bArr2, i11, iArr);
            }
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
