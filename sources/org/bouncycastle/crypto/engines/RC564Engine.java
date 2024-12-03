package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.RC5Parameters;

public class RC564Engine implements BlockCipher {
    private static final long P64 = -5196783011329398165L;
    private static final long Q64 = -7046029254386353131L;
    private static final int bytesPerWord = 8;
    private static final int wordSize = 64;
    private long[] _S = null;
    private int _noRounds = 12;
    private boolean forEncryption;

    private long bytesToWord(byte[] bArr, int i10) {
        long j10 = 0;
        for (int i11 = 7; i11 >= 0; i11--) {
            j10 = (j10 << 8) + ((long) (bArr[i11 + i10] & 255));
        }
        return j10;
    }

    private int decryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        long bytesToWord = bytesToWord(bArr, i10);
        long bytesToWord2 = bytesToWord(bArr, i10 + 8);
        for (int i12 = this._noRounds; i12 >= 1; i12--) {
            int i13 = i12 * 2;
            bytesToWord2 = rotateRight(bytesToWord2 - this._S[i13 + 1], bytesToWord) ^ bytesToWord;
            bytesToWord = rotateRight(bytesToWord - this._S[i13], bytesToWord2) ^ bytesToWord2;
        }
        wordToBytes(bytesToWord - this._S[0], bArr2, i11);
        wordToBytes(bytesToWord2 - this._S[1], bArr2, i11 + 8);
        return 16;
    }

    private int encryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        long bytesToWord = bytesToWord(bArr, i10) + this._S[0];
        long bytesToWord2 = bytesToWord(bArr, i10 + 8) + this._S[1];
        for (int i12 = 1; i12 <= this._noRounds; i12++) {
            int i13 = i12 * 2;
            bytesToWord = rotateLeft(bytesToWord ^ bytesToWord2, bytesToWord2) + this._S[i13];
            bytesToWord2 = rotateLeft(bytesToWord2 ^ bytesToWord, bytesToWord) + this._S[i13 + 1];
        }
        wordToBytes(bytesToWord, bArr2, i11);
        wordToBytes(bytesToWord2, bArr2, i11 + 8);
        return 16;
    }

    private long rotateLeft(long j10, long j11) {
        long j12 = j11 & 63;
        return (j10 >>> ((int) (64 - j12))) | (j10 << ((int) j12));
    }

    private long rotateRight(long j10, long j11) {
        long j12 = j11 & 63;
        return (j10 << ((int) (64 - j12))) | (j10 >>> ((int) j12));
    }

    private void setKey(byte[] bArr) {
        long[] jArr;
        int length = (bArr.length + 7) / 8;
        long[] jArr2 = new long[length];
        for (int i10 = 0; i10 != bArr.length; i10++) {
            int i11 = i10 / 8;
            jArr2[i11] = jArr2[i11] + (((long) (bArr[i10] & 255)) << ((i10 % 8) * 8));
        }
        long[] jArr3 = new long[((this._noRounds + 1) * 2)];
        this._S = jArr3;
        jArr3[0] = -5196783011329398165L;
        int i12 = 1;
        while (true) {
            jArr = this._S;
            if (i12 >= jArr.length) {
                break;
            }
            jArr[i12] = jArr[i12 - 1] + Q64;
            i12++;
        }
        int length2 = length > jArr.length ? length * 3 : jArr.length * 3;
        long j10 = 0;
        long j11 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < length2; i15++) {
            long[] jArr4 = this._S;
            j10 = rotateLeft(jArr4[i13] + j10 + j11, 3);
            jArr4[i13] = j10;
            j11 = rotateLeft(jArr2[i14] + j10 + j11, j11 + j10);
            jArr2[i14] = j11;
            i13 = (i13 + 1) % this._S.length;
            i14 = (i14 + 1) % length;
        }
    }

    private void wordToBytes(long j10, byte[] bArr, int i10) {
        for (int i11 = 0; i11 < 8; i11++) {
            bArr[i11 + i10] = (byte) ((int) j10);
            j10 >>>= 8;
        }
    }

    public String getAlgorithmName() {
        return "RC5-64";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        if (cipherParameters instanceof RC5Parameters) {
            RC5Parameters rC5Parameters = (RC5Parameters) cipherParameters;
            this.forEncryption = z10;
            this._noRounds = rC5Parameters.getRounds();
            setKey(rC5Parameters.getKey());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to RC564 init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        return this.forEncryption ? encryptBlock(bArr, i10, bArr2, i11) : decryptBlock(bArr, i10, bArr2, i11);
    }

    public void reset() {
    }
}
