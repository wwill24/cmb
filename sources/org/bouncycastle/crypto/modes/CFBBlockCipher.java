package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class CFBBlockCipher extends StreamBlockCipher {
    private byte[] IV;
    private int blockSize;
    private int byteCount;
    private byte[] cfbOutV;
    private byte[] cfbV;
    private BlockCipher cipher = null;
    private boolean encrypting;
    private byte[] inBuf;

    public CFBBlockCipher(BlockCipher blockCipher, int i10) {
        super(blockCipher);
        if (i10 > blockCipher.getBlockSize() * 8 || i10 < 8 || i10 % 8 != 0) {
            throw new IllegalArgumentException("CFB" + i10 + " not supported");
        }
        this.cipher = blockCipher;
        this.blockSize = i10 / 8;
        this.IV = new byte[blockCipher.getBlockSize()];
        this.cfbV = new byte[blockCipher.getBlockSize()];
        this.cfbOutV = new byte[blockCipher.getBlockSize()];
        this.inBuf = new byte[this.blockSize];
    }

    private byte decryptByte(byte b10) {
        if (this.byteCount == 0) {
            this.cipher.processBlock(this.cfbV, 0, this.cfbOutV, 0);
        }
        byte[] bArr = this.inBuf;
        int i10 = this.byteCount;
        bArr[i10] = b10;
        byte[] bArr2 = this.cfbOutV;
        int i11 = i10 + 1;
        this.byteCount = i11;
        byte b11 = (byte) (b10 ^ bArr2[i10]);
        int i12 = this.blockSize;
        if (i11 == i12) {
            this.byteCount = 0;
            byte[] bArr3 = this.cfbV;
            System.arraycopy(bArr3, i12, bArr3, 0, bArr3.length - i12);
            byte[] bArr4 = this.inBuf;
            byte[] bArr5 = this.cfbV;
            int length = bArr5.length;
            int i13 = this.blockSize;
            System.arraycopy(bArr4, 0, bArr5, length - i13, i13);
        }
        return b11;
    }

    private byte encryptByte(byte b10) {
        if (this.byteCount == 0) {
            this.cipher.processBlock(this.cfbV, 0, this.cfbOutV, 0);
        }
        byte[] bArr = this.cfbOutV;
        int i10 = this.byteCount;
        byte b11 = (byte) (b10 ^ bArr[i10]);
        byte[] bArr2 = this.inBuf;
        int i11 = i10 + 1;
        this.byteCount = i11;
        bArr2[i10] = b11;
        int i12 = this.blockSize;
        if (i11 == i12) {
            this.byteCount = 0;
            byte[] bArr3 = this.cfbV;
            System.arraycopy(bArr3, i12, bArr3, 0, bArr3.length - i12);
            byte[] bArr4 = this.inBuf;
            byte[] bArr5 = this.cfbV;
            int length = bArr5.length;
            int i13 = this.blockSize;
            System.arraycopy(bArr4, 0, bArr5, length - i13, i13);
        }
        return b11;
    }

    /* access modifiers changed from: protected */
    public byte calculateByte(byte b10) throws DataLengthException, IllegalStateException {
        return this.encrypting ? encryptByte(b10) : decryptByte(b10);
    }

    public int decryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        processBytes(bArr, i10, this.blockSize, bArr2, i11);
        return this.blockSize;
    }

    public int encryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        processBytes(bArr, i10, this.blockSize, bArr2, i11);
        return this.blockSize;
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CFB" + (this.blockSize * 8);
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public byte[] getCurrentIV() {
        return Arrays.clone(this.cfbV);
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        BlockCipher blockCipher;
        this.encrypting = z10;
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
        System.arraycopy(bArr, 0, this.cfbV, 0, bArr.length);
        Arrays.fill(this.inBuf, (byte) 0);
        this.byteCount = 0;
        this.cipher.reset();
    }
}
