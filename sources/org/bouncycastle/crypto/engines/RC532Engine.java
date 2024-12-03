package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.RC5Parameters;

public class RC532Engine implements BlockCipher {
    private static final int P32 = -1209970333;
    private static final int Q32 = -1640531527;
    private int[] _S = null;
    private int _noRounds = 12;
    private boolean forEncryption;

    private int bytesToWord(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << Tnaf.POW_2_WIDTH);
    }

    private int decryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int bytesToWord = bytesToWord(bArr, i10);
        int bytesToWord2 = bytesToWord(bArr, i10 + 4);
        for (int i12 = this._noRounds; i12 >= 1; i12--) {
            int i13 = i12 * 2;
            bytesToWord2 = rotateRight(bytesToWord2 - this._S[i13 + 1], bytesToWord) ^ bytesToWord;
            bytesToWord = rotateRight(bytesToWord - this._S[i13], bytesToWord2) ^ bytesToWord2;
        }
        wordToBytes(bytesToWord - this._S[0], bArr2, i11);
        wordToBytes(bytesToWord2 - this._S[1], bArr2, i11 + 4);
        return 8;
    }

    private int encryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int bytesToWord = bytesToWord(bArr, i10) + this._S[0];
        int bytesToWord2 = bytesToWord(bArr, i10 + 4) + this._S[1];
        for (int i12 = 1; i12 <= this._noRounds; i12++) {
            int i13 = i12 * 2;
            bytesToWord = rotateLeft(bytesToWord ^ bytesToWord2, bytesToWord2) + this._S[i13];
            bytesToWord2 = rotateLeft(bytesToWord2 ^ bytesToWord, bytesToWord) + this._S[i13 + 1];
        }
        wordToBytes(bytesToWord, bArr2, i11);
        wordToBytes(bytesToWord2, bArr2, i11 + 4);
        return 8;
    }

    private int rotateLeft(int i10, int i11) {
        int i12 = i11 & 31;
        return (i10 >>> (32 - i12)) | (i10 << i12);
    }

    private int rotateRight(int i10, int i11) {
        int i12 = i11 & 31;
        return (i10 << (32 - i12)) | (i10 >>> i12);
    }

    private void setKey(byte[] bArr) {
        int[] iArr;
        int length = (bArr.length + 3) / 4;
        int[] iArr2 = new int[length];
        for (int i10 = 0; i10 != bArr.length; i10++) {
            int i11 = i10 / 4;
            iArr2[i11] = iArr2[i11] + ((bArr[i10] & 255) << ((i10 % 4) * 8));
        }
        int[] iArr3 = new int[((this._noRounds + 1) * 2)];
        this._S = iArr3;
        iArr3[0] = P32;
        int i12 = 1;
        while (true) {
            iArr = this._S;
            if (i12 >= iArr.length) {
                break;
            }
            iArr[i12] = iArr[i12 - 1] + Q32;
            i12++;
        }
        int length2 = length > iArr.length ? length * 3 : iArr.length * 3;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < length2; i17++) {
            int[] iArr4 = this._S;
            i14 = rotateLeft(iArr4[i13] + i14 + i15, 3);
            iArr4[i13] = i14;
            i15 = rotateLeft(iArr2[i16] + i14 + i15, i15 + i14);
            iArr2[i16] = i15;
            i13 = (i13 + 1) % this._S.length;
            i16 = (i16 + 1) % length;
        }
    }

    private void wordToBytes(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        bArr[i11 + 1] = (byte) (i10 >> 8);
        bArr[i11 + 2] = (byte) (i10 >> 16);
        bArr[i11 + 3] = (byte) (i10 >> 24);
    }

    public String getAlgorithmName() {
        return "RC5-32";
    }

    public int getBlockSize() {
        return 8;
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        if (cipherParameters instanceof RC5Parameters) {
            RC5Parameters rC5Parameters = (RC5Parameters) cipherParameters;
            this._noRounds = rC5Parameters.getRounds();
            setKey(rC5Parameters.getKey());
        } else if (cipherParameters instanceof KeyParameter) {
            setKey(((KeyParameter) cipherParameters).getKey());
        } else {
            throw new IllegalArgumentException("invalid parameter passed to RC532 init - " + cipherParameters.getClass().getName());
        }
        this.forEncryption = z10;
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        return this.forEncryption ? encryptBlock(bArr, i10, bArr2, i11) : decryptBlock(bArr, i10, bArr2, i11);
    }

    public void reset() {
    }
}
