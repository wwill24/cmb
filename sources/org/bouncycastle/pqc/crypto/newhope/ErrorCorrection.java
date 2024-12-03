package org.bouncycastle.pqc.crypto.newhope;

import com.google.firebase.database.core.ValidationPath;
import org.bouncycastle.util.Arrays;

class ErrorCorrection {
    ErrorCorrection() {
    }

    static short LDDecode(int i10, int i11, int i12, int i13) {
        return (short) (((((g(i10) + g(i11)) + g(i12)) + g(i13)) - 98312) >>> 31);
    }

    static int abs(int i10) {
        int i11 = i10 >> 31;
        return (i10 ^ i11) - i11;
    }

    static int f(int[] iArr, int i10, int i11, int i12) {
        int i13 = (i12 * 2730) >> 25;
        int i14 = i13 - ((12288 - (i12 - (i13 * 12289))) >> 31);
        iArr[i10] = (i14 >> 1) + (i14 & 1);
        int i15 = i14 - 1;
        iArr[i11] = (i15 >> 1) + (i15 & 1);
        return abs(i12 - ((iArr[i10] * 2) * 12289));
    }

    static int g(int i10) {
        int i11 = (i10 * 2730) >> 27;
        int i12 = i11 - ((49155 - (i10 - (49156 * i11))) >> 31);
        return abs((((i12 >> 1) + (i12 & 1)) * 98312) - i10);
    }

    static void helpRec(short[] sArr, short[] sArr2, byte[] bArr, byte b10) {
        short s10 = 8;
        byte[] bArr2 = new byte[8];
        bArr2[0] = b10;
        byte[] bArr3 = new byte[32];
        ChaCha20.process(bArr, bArr2, bArr3, 0, 32);
        int[] iArr = new int[8];
        int i10 = 0;
        while (i10 < 256) {
            int i11 = i10 + 0;
            int i12 = ((bArr3[i10 >>> 3] >>> (i10 & 7)) & 1) * 4;
            int i13 = i10 + 256;
            int i14 = i10 + 512;
            int f10 = f(iArr, 0, 4, (sArr2[i11] * s10) + i12) + f(iArr, 1, 5, (sArr2[i13] * s10) + i12) + f(iArr, 2, 6, (sArr2[i14] * s10) + i12);
            int i15 = i10 + ValidationPath.MAX_PATH_LENGTH_BYTES;
            int f11 = (24577 - (f10 + f(iArr, 3, 7, (sArr2[i15] * 8) + i12))) >> 31;
            int i16 = ~f11;
            int i17 = (i16 & iArr[0]) ^ (iArr[4] & f11);
            int i18 = (iArr[1] & i16) ^ (iArr[5] & f11);
            int i19 = (iArr[2] & i16) ^ (f11 & iArr[6]);
            int i20 = (i16 & iArr[3]) ^ (iArr[7] & f11);
            sArr[i11] = (short) ((i17 - i20) & 3);
            sArr[i13] = (short) ((i18 - i20) & 3);
            sArr[i14] = (short) ((i19 - i20) & 3);
            sArr[i15] = (short) (3 & ((-f11) + (i20 * 2)));
            i10++;
            s10 = 8;
        }
    }

    static void rec(byte[] bArr, short[] sArr, short[] sArr2) {
        Arrays.fill(bArr, (byte) 0);
        for (int i10 = 0; i10 < 256; i10++) {
            int i11 = i10 + 0;
            int i12 = i10 + ValidationPath.MAX_PATH_LENGTH_BYTES;
            short s10 = sArr2[i12];
            int i13 = ((sArr[i11] * 8) + 196624) - (((sArr2[i11] * 2) + s10) * 12289);
            int i14 = i10 + 256;
            int i15 = ((sArr[i14] * 8) + 196624) - (((sArr2[i14] * 2) + s10) * 12289);
            int i16 = i10 + 512;
            int i17 = i10 >>> 3;
            bArr[i17] = (byte) ((LDDecode(i13, i15, ((sArr[i16] * 8) + 196624) - (((sArr2[i16] * 2) + s10) * 12289), ((sArr[i12] * 8) + 196624) - (s10 * 12289)) << (i10 & 7)) | bArr[i17]);
        }
    }
}
