package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.ParametersWithIV;

class MacCFBBlockCipher {
    private byte[] IV;
    private int blockSize;
    private byte[] cfbOutV;
    private byte[] cfbV;
    private BlockCipher cipher;

    public MacCFBBlockCipher(BlockCipher blockCipher, int i10) {
        this.cipher = blockCipher;
        this.blockSize = i10 / 8;
        this.IV = new byte[blockCipher.getBlockSize()];
        this.cfbV = new byte[blockCipher.getBlockSize()];
        this.cfbOutV = new byte[blockCipher.getBlockSize()];
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CFB" + (this.blockSize * 8);
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    /* access modifiers changed from: package-private */
    public void getMacBlock(byte[] bArr) {
        this.cipher.processBlock(this.cfbV, 0, bArr, 0);
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        BlockCipher blockCipher;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            int length = iv.length;
            byte[] bArr = this.IV;
            if (length < bArr.length) {
                System.arraycopy(iv, 0, bArr, bArr.length - iv.length, iv.length);
            } else {
                System.arraycopy(iv, 0, bArr, 0, bArr.length);
            }
            reset();
            blockCipher = this.cipher;
            cipherParameters = parametersWithIV.getParameters();
        } else {
            reset();
            blockCipher = this.cipher;
        }
        blockCipher.init(true, cipherParameters);
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        int i12 = this.blockSize;
        if (i10 + i12 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 + i11 <= bArr2.length) {
            this.cipher.processBlock(this.cfbV, 0, this.cfbOutV, 0);
            int i13 = 0;
            while (true) {
                int i14 = this.blockSize;
                if (i13 < i14) {
                    bArr2[i11 + i13] = (byte) (this.cfbOutV[i13] ^ bArr[i10 + i13]);
                    i13++;
                } else {
                    byte[] bArr3 = this.cfbV;
                    System.arraycopy(bArr3, i14, bArr3, 0, bArr3.length - i14);
                    byte[] bArr4 = this.cfbV;
                    int length = bArr4.length;
                    int i15 = this.blockSize;
                    System.arraycopy(bArr2, i11, bArr4, length - i15, i15);
                    return this.blockSize;
                }
            }
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
        byte[] bArr = this.IV;
        System.arraycopy(bArr, 0, this.cfbV, 0, bArr.length);
        this.cipher.reset();
    }
}
