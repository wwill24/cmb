package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class OFBBlockCipher extends StreamBlockCipher {
    private byte[] IV;
    private final int blockSize;
    private int byteCount;
    private final BlockCipher cipher;
    private byte[] ofbOutV;
    private byte[] ofbV;

    public OFBBlockCipher(BlockCipher blockCipher, int i10) {
        super(blockCipher);
        if (i10 > blockCipher.getBlockSize() * 8 || i10 < 8 || i10 % 8 != 0) {
            throw new IllegalArgumentException("0FB" + i10 + " not supported");
        }
        this.cipher = blockCipher;
        this.blockSize = i10 / 8;
        this.IV = new byte[blockCipher.getBlockSize()];
        this.ofbV = new byte[blockCipher.getBlockSize()];
        this.ofbOutV = new byte[blockCipher.getBlockSize()];
    }

    /* access modifiers changed from: protected */
    public byte calculateByte(byte b10) throws DataLengthException, IllegalStateException {
        if (this.byteCount == 0) {
            this.cipher.processBlock(this.ofbV, 0, this.ofbOutV, 0);
        }
        byte[] bArr = this.ofbOutV;
        int i10 = this.byteCount;
        int i11 = i10 + 1;
        this.byteCount = i11;
        byte b11 = (byte) (b10 ^ bArr[i10]);
        int i12 = this.blockSize;
        if (i11 == i12) {
            this.byteCount = 0;
            byte[] bArr2 = this.ofbV;
            System.arraycopy(bArr2, i12, bArr2, 0, bArr2.length - i12);
            byte[] bArr3 = this.ofbOutV;
            byte[] bArr4 = this.ofbV;
            int length = bArr4.length;
            int i13 = this.blockSize;
            System.arraycopy(bArr3, 0, bArr4, length - i13, i13);
        }
        return b11;
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/OFB" + (this.blockSize * 8);
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        BlockCipher blockCipher;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            int length = iv.length;
            byte[] bArr = this.IV;
            if (length < bArr.length) {
                System.arraycopy(iv, 0, bArr, bArr.length - iv.length, iv.length);
                int i10 = 0;
                while (true) {
                    byte[] bArr2 = this.IV;
                    if (i10 >= bArr2.length - iv.length) {
                        break;
                    }
                    bArr2[i10] = 0;
                    i10++;
                }
            } else {
                System.arraycopy(iv, 0, bArr, 0, bArr.length);
            }
            reset();
            if (parametersWithIV.getParameters() != null) {
                blockCipher = this.cipher;
                cipherParameters = parametersWithIV.getParameters();
            } else {
                return;
            }
        } else {
            reset();
            if (cipherParameters != null) {
                blockCipher = this.cipher;
            } else {
                return;
            }
        }
        blockCipher.init(true, cipherParameters);
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        processBytes(bArr, i10, this.blockSize, bArr2, i11);
        return this.blockSize;
    }

    public void reset() {
        byte[] bArr = this.IV;
        System.arraycopy(bArr, 0, this.ofbV, 0, bArr.length);
        this.byteCount = 0;
        this.cipher.reset();
    }
}
