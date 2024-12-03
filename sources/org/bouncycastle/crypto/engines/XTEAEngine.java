package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public class XTEAEngine implements BlockCipher {
    private static final int block_size = 8;
    private static final int delta = -1640531527;
    private static final int rounds = 32;
    private int[] _S = new int[4];
    private boolean _forEncryption;
    private boolean _initialised = false;
    private int[] _sum0 = new int[32];
    private int[] _sum1 = new int[32];

    private int bytesToInt(byte[] bArr, int i10) {
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        byte b10 = (bArr[i10] << 24) | ((bArr[i11] & 255) << Tnaf.POW_2_WIDTH);
        return (bArr[i12 + 1] & 255) | b10 | ((bArr[i12] & 255) << 8);
    }

    private int decryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int bytesToInt = bytesToInt(bArr, i10);
        int bytesToInt2 = bytesToInt(bArr, i10 + 4);
        for (int i12 = 31; i12 >= 0; i12--) {
            bytesToInt2 -= (((bytesToInt << 4) ^ (bytesToInt >>> 5)) + bytesToInt) ^ this._sum1[i12];
            bytesToInt -= (((bytesToInt2 << 4) ^ (bytesToInt2 >>> 5)) + bytesToInt2) ^ this._sum0[i12];
        }
        unpackInt(bytesToInt, bArr2, i11);
        unpackInt(bytesToInt2, bArr2, i11 + 4);
        return 8;
    }

    private int encryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int bytesToInt = bytesToInt(bArr, i10);
        int bytesToInt2 = bytesToInt(bArr, i10 + 4);
        for (int i12 = 0; i12 < 32; i12++) {
            bytesToInt += (((bytesToInt2 << 4) ^ (bytesToInt2 >>> 5)) + bytesToInt2) ^ this._sum0[i12];
            bytesToInt2 += (((bytesToInt << 4) ^ (bytesToInt >>> 5)) + bytesToInt) ^ this._sum1[i12];
        }
        unpackInt(bytesToInt, bArr2, i11);
        unpackInt(bytesToInt2, bArr2, i11 + 4);
        return 8;
    }

    private void setKey(byte[] bArr) {
        if (bArr.length == 16) {
            int i10 = 0;
            int i11 = 0;
            while (i10 < 4) {
                this._S[i10] = bytesToInt(bArr, i11);
                i10++;
                i11 += 4;
            }
            int i12 = 0;
            for (int i13 = 0; i13 < 32; i13++) {
                int[] iArr = this._sum0;
                int[] iArr2 = this._S;
                iArr[i13] = iArr2[i12 & 3] + i12;
                i12 -= 1640531527;
                this._sum1[i13] = iArr2[(i12 >>> 11) & 3] + i12;
            }
            return;
        }
        throw new IllegalArgumentException("Key size must be 128 bits.");
    }

    private void unpackInt(int i10, byte[] bArr, int i11) {
        int i12 = i11 + 1;
        bArr[i11] = (byte) (i10 >>> 24);
        int i13 = i12 + 1;
        bArr[i12] = (byte) (i10 >>> 16);
        bArr[i13] = (byte) (i10 >>> 8);
        bArr[i13 + 1] = (byte) i10;
    }

    public String getAlgorithmName() {
        return "XTEA";
    }

    public int getBlockSize() {
        return 8;
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this._forEncryption = z10;
            this._initialised = true;
            setKey(((KeyParameter) cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to TEA init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        if (!this._initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i10 + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i11 + 8 <= bArr2.length) {
            return this._forEncryption ? encryptBlock(bArr, i10, bArr2, i11) : decryptBlock(bArr, i10, bArr2, i11);
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
