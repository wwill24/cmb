package org.bouncycastle.crypto.digests;

import java.lang.reflect.Array;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Arrays;

public class Haraka512Digest extends HarakaBase {
    private static byte[][] RC = {new byte[]{6, -124, 112, 76, -26, 32, -64, 10, -78, -59, -2, -16, 117, -127, 123, -99}, new byte[]{-117, 102, -76, -31, -120, -13, -96, 107, 100, 15, 107, -92, 47, 8, -9, 23}, new byte[]{52, 2, -34, Framer.STDIN_FRAME_PREFIX, 83, -14, -124, -104, -49, 2, -99, 96, -97, 2, -111, 20}, new byte[]{14, -42, -22, -26, 46, 123, 79, 8, -69, -13, PSSSigner.TRAILER_IMPLICIT, -81, -3, 91, 79, 121}, new byte[]{-53, -49, -80, -53, 72, 114, 68, -117, 121, -18, -51, 28, -66, 57, 112, 68}, new byte[]{126, -22, -51, -18, 110, -112, Framer.STDERR_FRAME_PREFIX, -73, -115, 83, 53, -19, 43, -118, 5, 123}, new byte[]{103, -62, -113, 67, 94, 46, 124, -48, -30, 65, 39, 97, -38, 79, -17, 27}, new byte[]{41, 36, -39, -80, -81, -54, -52, 7, 103, Framer.STDIN_REQUEST_FRAME_PREFIX, -3, -30, 31, -57, 11, 59}, new byte[]{-85, 77, 99, -15, -26, -122, Byte.MAX_VALUE, -23, -20, -37, -113, -54, -71, -44, 101, -18}, new byte[]{28, 48, -65, -124, -44, -73, -51, 100, 91, 42, 64, 79, -83, 3, 126, 51}, new byte[]{-78, -52, 11, -71, -108, 23, 35, -65, 105, 2, -117, 46, -115, -10, -104, 0}, new byte[]{-6, 4, Framer.EXIT_FRAME_PREFIX, -90, -34, 111, 85, 114, 74, -86, -98, -56, 92, -99, Framer.STDIN_FRAME_PREFIX, -118}, new byte[]{-33, -76, -97, 43, 107, 119, 42, 18, 14, -6, 79, 46, 41, 18, -97, -44}, new byte[]{30, -95, 3, 68, -12, 73, -94, 54, Framer.STDERR_FRAME_PREFIX, -42, 17, -82, -69, 106, 18, -18}, new byte[]{-81, 4, 73, -120, 75, 5, 0, -124, Framer.STDIN_REQUEST_FRAME_PREFIX, -106, 0, -55, -100, -88, -20, -90}, new byte[]{Framer.ENTER_FRAME_PREFIX, 2, 94, -40, -99, 25, -100, 79, Framer.EXIT_FRAME_PREFIX, -94, -57, -29, 39, -27, -109, -20}, new byte[]{-65, 58, -86, -8, -89, 89, -55, -73, -71, 40, 46, -51, -126, -44, 1, 115}, new byte[]{98, 96, 112, 13, 97, -122, -80, 23, 55, -14, -17, -39, Tnaf.POW_2_WIDTH, 48, 125, 107}, new byte[]{90, -54, 69, -62, Framer.ENTER_FRAME_PREFIX, 48, 4, 67, -127, -62, -111, 83, -10, -4, -102, -58}, new byte[]{-110, 35, -105, 60, 34, 107, 104, -69, 44, -81, -110, -24, 54, -47, -108, 58}, new byte[]{-45, -65, -110, 56, 34, 88, -122, -21, 108, -70, -71, 88, -27, Tnaf.POW_2_WIDTH, 113, -76}, new byte[]{-37, -122, 60, -27, -82, -16, -58, 119, -109, 61, -3, -35, 36, -31, 18, -115}, new byte[]{-69, 96, 98, 104, -1, -21, -96, -100, -125, -28, -115, -29, -53, 34, 18, -79}, new byte[]{115, 75, -45, -36, -30, -28, -47, -100, Framer.STDIN_FRAME_PREFIX, -71, 26, 78, -57, 43, -9, 125}, new byte[]{67, -69, 71, -61, 97, 48, 27, 67, 75, 20, 21, -60, 44, -77, -110, 78}, new byte[]{-37, -89, 117, -88, -25, 7, -17, -10, 3, -78, Framer.STDOUT_FRAME_PREFIX, -35, 22, -21, 104, -103}, new byte[]{109, -13, 97, 75, 60, 117, 89, 119, -114, 94, 35, 2, 126, -54, 71, 44}, new byte[]{-51, -89, 90, 23, -42, -34, 125, 119, 109, 27, -27, -71, -72, -122, 23, -7}, new byte[]{-20, 107, 67, -16, 107, -88, -23, -86, -99, 108, 6, -99, -87, 70, -18, 93}, new byte[]{-53, 30, 105, 80, -7, 87, 51, 43, -94, 83, 17, 89, 59, -13, 39, -63}, new byte[]{44, -18, 12, 117, 0, -38, 97, -100, -28, -19, 3, 83, 96, 14, -48, -39}, new byte[]{-16, -79, -91, -95, -106, -23, 12, -85, Byte.MIN_VALUE, -69, -70, PSSSigner.TRAILER_IMPLICIT, 99, -92, -93, 80}, new byte[]{-82, 61, -79, 2, 94, -106, 41, -120, -85, 13, -34, 48, -109, -115, -54, 57}, new byte[]{23, -69, -113, 56, -43, 84, -92, 11, -120, 20, -13, -88, 46, 117, -76, 66}, new byte[]{52, -69, -118, 91, Framer.STDIN_REQUEST_FRAME_PREFIX, 66, Byte.MAX_VALUE, -41, -82, -74, -73, 121, 54, 10, 22, -10}, new byte[]{38, -10, 82, 65, -53, -27, 84, 56, 67, -50, 89, 24, -1, -70, -81, -34}, new byte[]{76, -23, -102, 84, -71, -13, 2, 106, -94, -54, -100, -9, -125, -98, -55, Framer.EXIT_FRAME_PREFIX}, new byte[]{-82, 81, -91, 26, 27, -33, -9, -66, 64, -64, 110, 40, 34, -112, 18, 53}, new byte[]{-96, -63, 97, 60, -70, 126, -46, 43, -63, 115, PSSSigner.TRAILER_IMPLICIT, 15, 72, -90, 89, -49}, new byte[]{117, 106, -52, 3, 2, 40, -126, -120, 74, -42, -67, -3, -23, -59, -99, -95}};
    private final byte[] buffer;
    private int off;

    public Haraka512Digest() {
        this.buffer = new byte[64];
    }

    public Haraka512Digest(Haraka512Digest haraka512Digest) {
        this.buffer = Arrays.clone(haraka512Digest.buffer);
        this.off = haraka512Digest.off;
    }

    private int haraka512256(byte[] bArr, byte[] bArr2, int i10) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int i11 = i10;
        byte[][] bArr5 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{4, 16});
        byte[][] bArr6 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{4, 16});
        System.arraycopy(bArr3, 0, bArr5[0], 0, 16);
        System.arraycopy(bArr3, 16, bArr5[1], 0, 16);
        System.arraycopy(bArr3, 32, bArr5[2], 0, 16);
        System.arraycopy(bArr3, 48, bArr5[3], 0, 16);
        bArr5[0] = HarakaBase.aesEnc(bArr5[0], RC[0]);
        bArr5[1] = HarakaBase.aesEnc(bArr5[1], RC[1]);
        bArr5[2] = HarakaBase.aesEnc(bArr5[2], RC[2]);
        bArr5[3] = HarakaBase.aesEnc(bArr5[3], RC[3]);
        bArr5[0] = HarakaBase.aesEnc(bArr5[0], RC[4]);
        bArr5[1] = HarakaBase.aesEnc(bArr5[1], RC[5]);
        bArr5[2] = HarakaBase.aesEnc(bArr5[2], RC[6]);
        bArr5[3] = HarakaBase.aesEnc(bArr5[3], RC[7]);
        mix512(bArr5, bArr6);
        bArr5[0] = HarakaBase.aesEnc(bArr6[0], RC[8]);
        bArr5[1] = HarakaBase.aesEnc(bArr6[1], RC[9]);
        bArr5[2] = HarakaBase.aesEnc(bArr6[2], RC[10]);
        bArr5[3] = HarakaBase.aesEnc(bArr6[3], RC[11]);
        bArr5[0] = HarakaBase.aesEnc(bArr5[0], RC[12]);
        bArr5[1] = HarakaBase.aesEnc(bArr5[1], RC[13]);
        bArr5[2] = HarakaBase.aesEnc(bArr5[2], RC[14]);
        bArr5[3] = HarakaBase.aesEnc(bArr5[3], RC[15]);
        mix512(bArr5, bArr6);
        bArr5[0] = HarakaBase.aesEnc(bArr6[0], RC[16]);
        bArr5[1] = HarakaBase.aesEnc(bArr6[1], RC[17]);
        bArr5[2] = HarakaBase.aesEnc(bArr6[2], RC[18]);
        bArr5[3] = HarakaBase.aesEnc(bArr6[3], RC[19]);
        bArr5[0] = HarakaBase.aesEnc(bArr5[0], RC[20]);
        bArr5[1] = HarakaBase.aesEnc(bArr5[1], RC[21]);
        bArr5[2] = HarakaBase.aesEnc(bArr5[2], RC[22]);
        bArr5[3] = HarakaBase.aesEnc(bArr5[3], RC[23]);
        mix512(bArr5, bArr6);
        bArr5[0] = HarakaBase.aesEnc(bArr6[0], RC[24]);
        bArr5[1] = HarakaBase.aesEnc(bArr6[1], RC[25]);
        bArr5[2] = HarakaBase.aesEnc(bArr6[2], RC[26]);
        bArr5[3] = HarakaBase.aesEnc(bArr6[3], RC[27]);
        bArr5[0] = HarakaBase.aesEnc(bArr5[0], RC[28]);
        bArr5[1] = HarakaBase.aesEnc(bArr5[1], RC[29]);
        bArr5[2] = HarakaBase.aesEnc(bArr5[2], RC[30]);
        bArr5[3] = HarakaBase.aesEnc(bArr5[3], RC[31]);
        mix512(bArr5, bArr6);
        bArr5[0] = HarakaBase.aesEnc(bArr6[0], RC[32]);
        bArr5[1] = HarakaBase.aesEnc(bArr6[1], RC[33]);
        bArr5[2] = HarakaBase.aesEnc(bArr6[2], RC[34]);
        bArr5[3] = HarakaBase.aesEnc(bArr6[3], RC[35]);
        bArr5[0] = HarakaBase.aesEnc(bArr5[0], RC[36]);
        bArr5[1] = HarakaBase.aesEnc(bArr5[1], RC[37]);
        bArr5[2] = HarakaBase.aesEnc(bArr5[2], RC[38]);
        bArr5[3] = HarakaBase.aesEnc(bArr5[3], RC[39]);
        mix512(bArr5, bArr6);
        bArr5[0] = HarakaBase.xor(bArr6[0], bArr3, 0);
        bArr5[1] = HarakaBase.xor(bArr6[1], bArr3, 16);
        bArr5[2] = HarakaBase.xor(bArr6[2], bArr3, 32);
        bArr5[3] = HarakaBase.xor(bArr6[3], bArr3, 48);
        System.arraycopy(bArr5[0], 8, bArr4, i11, 8);
        System.arraycopy(bArr5[1], 8, bArr4, i11 + 8, 8);
        System.arraycopy(bArr5[2], 0, bArr4, i11 + 16, 8);
        System.arraycopy(bArr5[3], 0, bArr4, i11 + 24, 8);
        return 32;
    }

    private void mix512(byte[][] bArr, byte[][] bArr2) {
        System.arraycopy(bArr[0], 12, bArr2[0], 0, 4);
        System.arraycopy(bArr[2], 12, bArr2[0], 4, 4);
        System.arraycopy(bArr[1], 12, bArr2[0], 8, 4);
        System.arraycopy(bArr[3], 12, bArr2[0], 12, 4);
        System.arraycopy(bArr[2], 0, bArr2[1], 0, 4);
        System.arraycopy(bArr[0], 0, bArr2[1], 4, 4);
        System.arraycopy(bArr[3], 0, bArr2[1], 8, 4);
        System.arraycopy(bArr[1], 0, bArr2[1], 12, 4);
        System.arraycopy(bArr[2], 4, bArr2[2], 0, 4);
        System.arraycopy(bArr[0], 4, bArr2[2], 4, 4);
        System.arraycopy(bArr[3], 4, bArr2[2], 8, 4);
        System.arraycopy(bArr[1], 4, bArr2[2], 12, 4);
        System.arraycopy(bArr[0], 8, bArr2[3], 0, 4);
        System.arraycopy(bArr[2], 8, bArr2[3], 4, 4);
        System.arraycopy(bArr[1], 8, bArr2[3], 8, 4);
        System.arraycopy(bArr[3], 8, bArr2[3], 12, 4);
    }

    public int doFinal(byte[] bArr, int i10) {
        if (this.off != 64) {
            throw new IllegalStateException("input must be exactly 64 bytes");
        } else if (bArr.length - i10 >= 32) {
            int haraka512256 = haraka512256(this.buffer, bArr, i10);
            reset();
            return haraka512256;
        } else {
            throw new IllegalArgumentException("output too short to receive digest");
        }
    }

    public String getAlgorithmName() {
        return "Haraka-512";
    }

    public void reset() {
        this.off = 0;
        Arrays.clear(this.buffer);
    }

    public void update(byte b10) {
        int i10 = this.off;
        if (i10 + 1 <= 64) {
            byte[] bArr = this.buffer;
            this.off = i10 + 1;
            bArr[i10] = b10;
            return;
        }
        throw new IllegalArgumentException("total input cannot be more than 64 bytes");
    }

    public void update(byte[] bArr, int i10, int i11) {
        int i12 = this.off;
        if (i12 + i11 <= 64) {
            System.arraycopy(bArr, i10, this.buffer, i12, i11);
            this.off += i11;
            return;
        }
        throw new IllegalArgumentException("total input cannot be more than 64 bytes");
    }
}
