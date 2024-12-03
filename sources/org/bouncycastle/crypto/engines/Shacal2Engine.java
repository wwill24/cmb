package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public class Shacal2Engine implements BlockCipher {
    private static final int BLOCK_SIZE = 32;
    private static final int[] K = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    private static final int ROUNDS = 64;
    private boolean forEncryption = false;
    private int[] workingKey = null;

    private void byteBlockToInts(byte[] bArr, int[] iArr, int i10, int i11) {
        while (i11 < 8) {
            int i12 = i10 + 1;
            int i13 = i12 + 1;
            byte b10 = ((bArr[i10] & 255) << 24) | ((bArr[i12] & 255) << Tnaf.POW_2_WIDTH);
            int i14 = i13 + 1;
            iArr[i11] = b10 | ((bArr[i13] & 255) << 8) | (bArr[i14] & 255);
            i11++;
            i10 = i14 + 1;
        }
    }

    private void bytes2ints(byte[] bArr, int[] iArr, int i10, int i11) {
        while (i11 < bArr.length / 4) {
            int i12 = i10 + 1;
            int i13 = i12 + 1;
            byte b10 = ((bArr[i10] & 255) << 24) | ((bArr[i12] & 255) << Tnaf.POW_2_WIDTH);
            int i14 = i13 + 1;
            byte b11 = b10 | ((bArr[i13] & 255) << 8);
            iArr[i11] = b11 | (bArr[i14] & 255);
            i11++;
            i10 = i14 + 1;
        }
    }

    private void decryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int[] iArr = new int[8];
        byteBlockToInts(bArr, iArr, i10, 0);
        for (int i12 = 63; i12 > -1; i12--) {
            int i13 = iArr[0];
            int i14 = iArr[1];
            int i15 = iArr[2];
            int i16 = iArr[3];
            int i17 = (i13 - ((((i14 >>> 2) | (i14 << -2)) ^ ((i14 >>> 13) | (i14 << -13))) ^ ((i14 >>> 22) | (i14 << -22)))) - (((i14 & i15) ^ (i14 & i16)) ^ (i15 & i16));
            iArr[0] = i14;
            iArr[1] = i15;
            iArr[2] = i16;
            iArr[3] = iArr[4] - i17;
            int i18 = iArr[5];
            iArr[4] = i18;
            int i19 = iArr[6];
            iArr[5] = i19;
            int i20 = iArr[7];
            iArr[6] = i20;
            iArr[7] = (((i17 - K[i12]) - this.workingKey[i12]) - ((((i18 >>> 6) | (i18 << -6)) ^ ((i18 >>> 11) | (i18 << -11))) ^ ((i18 >>> 25) | (i18 << -25)))) - ((i18 & i19) ^ ((~i18) & i20));
        }
        ints2bytes(iArr, bArr2, i11);
    }

    private void encryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int[] iArr = new int[8];
        byteBlockToInts(bArr, iArr, i10, 0);
        for (int i12 = 0; i12 < 64; i12++) {
            int i13 = iArr[4];
            int i14 = iArr[5];
            int i15 = ~i13;
            int i16 = iArr[6];
            int i17 = ((((i13 >>> 6) | (i13 << -6)) ^ ((i13 >>> 11) | (i13 << -11))) ^ ((i13 >>> 25) | (i13 << -25))) + ((i13 & i14) ^ (i15 & i16)) + iArr[7] + K[i12] + this.workingKey[i12];
            iArr[7] = i16;
            iArr[6] = i14;
            iArr[5] = i13;
            iArr[4] = iArr[3] + i17;
            int i18 = iArr[2];
            iArr[3] = i18;
            int i19 = iArr[1];
            iArr[2] = i19;
            int i20 = iArr[0];
            iArr[1] = i20;
            iArr[0] = i17 + ((((i20 >>> 2) | (i20 << -2)) ^ ((i20 >>> 13) | (i20 << -13))) ^ ((i20 >>> 22) | (i20 << -22))) + (((i20 & i18) ^ (i20 & i19)) ^ (i19 & i18));
        }
        ints2bytes(iArr, bArr2, i11);
    }

    private void ints2bytes(int[] iArr, byte[] bArr, int i10) {
        for (int i11 : iArr) {
            int i12 = i10 + 1;
            bArr[i10] = (byte) (i11 >>> 24);
            int i13 = i12 + 1;
            bArr[i12] = (byte) (i11 >>> 16);
            int i14 = i13 + 1;
            bArr[i13] = (byte) (i11 >>> 8);
            i10 = i14 + 1;
            bArr[i14] = (byte) i11;
        }
    }

    public String getAlgorithmName() {
        return "Shacal2";
    }

    public int getBlockSize() {
        return 32;
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            this.forEncryption = z10;
            this.workingKey = new int[64];
            setKey(((KeyParameter) cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException("only simple KeyParameter expected.");
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        if (this.workingKey == null) {
            throw new IllegalStateException("Shacal2 not initialised");
        } else if (i10 + 32 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i11 + 32 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        } else if (this.forEncryption) {
            encryptBlock(bArr, i10, bArr2, i11);
            return 32;
        } else {
            decryptBlock(bArr, i10, bArr2, i11);
            return 32;
        }
    }

    public void reset() {
    }

    public void setKey(byte[] bArr) {
        if (bArr.length != 0 && bArr.length <= 64) {
            if (bArr.length >= 16 && bArr.length % 8 == 0) {
                bytes2ints(bArr, this.workingKey, 0, 0);
                for (int i10 = 16; i10 < 64; i10++) {
                    int[] iArr = this.workingKey;
                    int i11 = iArr[i10 - 2];
                    int i12 = ((i11 >>> 10) ^ (((i11 >>> 17) | (i11 << -17)) ^ ((i11 >>> 19) | (i11 << -19)))) + iArr[i10 - 7];
                    int i13 = iArr[i10 - 15];
                    iArr[i10] = i12 + ((i13 >>> 3) ^ (((i13 >>> 7) | (i13 << -7)) ^ ((i13 >>> 18) | (i13 << -18)))) + iArr[i10 - 16];
                }
                return;
            }
        }
        throw new IllegalArgumentException("Shacal2-key must be 16 - 64 bytes and multiple of 8");
    }
}
