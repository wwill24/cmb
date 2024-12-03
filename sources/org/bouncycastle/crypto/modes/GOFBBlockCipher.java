package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class GOFBBlockCipher extends StreamBlockCipher {
    static final int C1 = 16843012;
    static final int C2 = 16843009;
    private byte[] IV;
    int N3;
    int N4;
    private final int blockSize;
    private int byteCount;
    private final BlockCipher cipher;
    boolean firstStep = true;
    private byte[] ofbOutV;
    private byte[] ofbV;

    public GOFBBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.cipher = blockCipher;
        int blockSize2 = blockCipher.getBlockSize();
        this.blockSize = blockSize2;
        if (blockSize2 == 8) {
            this.IV = new byte[blockCipher.getBlockSize()];
            this.ofbV = new byte[blockCipher.getBlockSize()];
            this.ofbOutV = new byte[blockCipher.getBlockSize()];
            return;
        }
        throw new IllegalArgumentException("GCTR only for 64 bit block ciphers");
    }

    private int bytesToint(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] << 24) & -16777216) + ((bArr[i10 + 2] << Tnaf.POW_2_WIDTH) & 16711680) + ((bArr[i10 + 1] << 8) & 65280) + (bArr[i10] & 255);
    }

    private void intTobytes(int i10, byte[] bArr, int i11) {
        bArr[i11 + 3] = (byte) (i10 >>> 24);
        bArr[i11 + 2] = (byte) (i10 >>> 16);
        bArr[i11 + 1] = (byte) (i10 >>> 8);
        bArr[i11] = (byte) i10;
    }

    /* access modifiers changed from: protected */
    public byte calculateByte(byte b10) {
        if (this.byteCount == 0) {
            if (this.firstStep) {
                this.firstStep = false;
                this.cipher.processBlock(this.ofbV, 0, this.ofbOutV, 0);
                this.N3 = bytesToint(this.ofbOutV, 0);
                this.N4 = bytesToint(this.ofbOutV, 4);
            }
            int i10 = this.N3 + C2;
            this.N3 = i10;
            int i11 = this.N4 + C1;
            this.N4 = i11;
            if (i11 < C1 && i11 > 0) {
                this.N4 = i11 + 1;
            }
            intTobytes(i10, this.ofbV, 0);
            intTobytes(this.N4, this.ofbV, 4);
            this.cipher.processBlock(this.ofbV, 0, this.ofbOutV, 0);
        }
        byte[] bArr = this.ofbOutV;
        int i12 = this.byteCount;
        int i13 = i12 + 1;
        this.byteCount = i13;
        byte b11 = (byte) (b10 ^ bArr[i12]);
        int i14 = this.blockSize;
        if (i13 == i14) {
            this.byteCount = 0;
            byte[] bArr2 = this.ofbV;
            System.arraycopy(bArr2, i14, bArr2, 0, bArr2.length - i14);
            byte[] bArr3 = this.ofbOutV;
            byte[] bArr4 = this.ofbV;
            int length = bArr4.length;
            int i15 = this.blockSize;
            System.arraycopy(bArr3, 0, bArr4, length - i15, i15);
        }
        return b11;
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/GCTR";
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        BlockCipher blockCipher;
        this.firstStep = true;
        this.N3 = 0;
        this.N4 = 0;
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
        this.firstStep = true;
        this.N3 = 0;
        this.N4 = 0;
        byte[] bArr = this.IV;
        System.arraycopy(bArr, 0, this.ofbV, 0, bArr.length);
        this.byteCount = 0;
        this.cipher.reset();
    }
}
