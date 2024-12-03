package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public class RC6Engine implements BlockCipher {
    private static final int LGW = 5;
    private static final int P32 = -1209970333;
    private static final int Q32 = -1640531527;
    private static final int _noRounds = 20;
    private static final int bytesPerWord = 4;
    private static final int wordSize = 32;
    private int[] _S = null;
    private boolean forEncryption;

    private int bytesToWord(byte[] bArr, int i10) {
        int i11 = 0;
        for (int i12 = 3; i12 >= 0; i12--) {
            i11 = (i11 << 8) + (bArr[i12 + i10] & 255);
        }
        return i11;
    }

    private int decryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int bytesToWord = bytesToWord(bArr, i10);
        int bytesToWord2 = bytesToWord(bArr, i10 + 4);
        int bytesToWord3 = bytesToWord(bArr, i10 + 8);
        int bytesToWord4 = bytesToWord(bArr, i10 + 12);
        int[] iArr = this._S;
        int i12 = bytesToWord3 - iArr[43];
        int i13 = bytesToWord - iArr[42];
        int i14 = 20;
        while (i14 >= 1) {
            int rotateLeft = rotateLeft(((i13 * 2) + 1) * i13, 5);
            int rotateLeft2 = rotateLeft(((i12 * 2) + 1) * i12, 5);
            int i15 = i14 * 2;
            i14--;
            int i16 = i13;
            i13 = rotateRight(bytesToWord4 - this._S[i15], rotateLeft2) ^ rotateLeft;
            bytesToWord4 = i12;
            i12 = rotateRight(bytesToWord2 - this._S[i15 + 1], rotateLeft) ^ rotateLeft2;
            bytesToWord2 = i16;
        }
        int[] iArr2 = this._S;
        wordToBytes(i13, bArr2, i11);
        wordToBytes(bytesToWord2 - iArr2[0], bArr2, i11 + 4);
        wordToBytes(i12, bArr2, i11 + 8);
        wordToBytes(bytesToWord4 - iArr2[1], bArr2, i11 + 12);
        return 16;
    }

    private int encryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int bytesToWord = bytesToWord(bArr, i10);
        int bytesToWord2 = bytesToWord(bArr, i10 + 4);
        int bytesToWord3 = bytesToWord(bArr, i10 + 8);
        int bytesToWord4 = bytesToWord(bArr, i10 + 12);
        int[] iArr = this._S;
        int i12 = bytesToWord2 + iArr[0];
        int i13 = bytesToWord4 + iArr[1];
        int i14 = 1;
        while (i14 <= 20) {
            int rotateLeft = rotateLeft(((i12 * 2) + 1) * i12, 5);
            int rotateLeft2 = rotateLeft(((i13 * 2) + 1) * i13, 5);
            int i15 = i14 * 2;
            i14++;
            int rotateLeft3 = rotateLeft(bytesToWord3 ^ rotateLeft2, rotateLeft) + this._S[i15 + 1];
            bytesToWord3 = i13;
            i13 = rotateLeft(bytesToWord ^ rotateLeft, rotateLeft2) + this._S[i15];
            bytesToWord = i12;
            i12 = rotateLeft3;
        }
        int[] iArr2 = this._S;
        int i16 = bytesToWord3 + iArr2[43];
        wordToBytes(bytesToWord + iArr2[42], bArr2, i11);
        wordToBytes(i12, bArr2, i11 + 4);
        wordToBytes(i16, bArr2, i11 + 8);
        wordToBytes(i13, bArr2, i11 + 12);
        return 16;
    }

    private int rotateLeft(int i10, int i11) {
        return (i10 >>> (-i11)) | (i10 << i11);
    }

    private int rotateRight(int i10, int i11) {
        return (i10 << (-i11)) | (i10 >>> i11);
    }

    private void setKey(byte[] bArr) {
        int[] iArr;
        int length = (bArr.length + 3) / 4;
        int length2 = ((bArr.length + 4) - 1) / 4;
        int[] iArr2 = new int[length2];
        for (int length3 = bArr.length - 1; length3 >= 0; length3--) {
            int i10 = length3 / 4;
            iArr2[i10] = (iArr2[i10] << 8) + (bArr[length3] & 255);
        }
        int[] iArr3 = new int[44];
        this._S = iArr3;
        iArr3[0] = P32;
        int i11 = 1;
        while (true) {
            iArr = this._S;
            if (i11 >= iArr.length) {
                break;
            }
            iArr[i11] = iArr[i11 - 1] + Q32;
            i11++;
        }
        int length4 = length2 > iArr.length ? length2 * 3 : iArr.length * 3;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < length4; i16++) {
            int[] iArr4 = this._S;
            i13 = rotateLeft(iArr4[i12] + i13 + i14, 3);
            iArr4[i12] = i13;
            i14 = rotateLeft(iArr2[i15] + i13 + i14, i14 + i13);
            iArr2[i15] = i14;
            i12 = (i12 + 1) % this._S.length;
            i15 = (i15 + 1) % length2;
        }
    }

    private void wordToBytes(int i10, byte[] bArr, int i11) {
        for (int i12 = 0; i12 < 4; i12++) {
            bArr[i12 + i11] = (byte) i10;
            i10 >>>= 8;
        }
    }

    public String getAlgorithmName() {
        return "RC6";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.forEncryption = z10;
            setKey(((KeyParameter) cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to RC6 init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int blockSize = getBlockSize();
        if (this._S == null) {
            throw new IllegalStateException("RC6 engine not initialised");
        } else if (i10 + blockSize > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (blockSize + i11 <= bArr2.length) {
            return this.forEncryption ? encryptBlock(bArr, i10, bArr2, i11) : decryptBlock(bArr, i10, bArr2, i11);
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
