package org.bouncycastle.crypto;

public class BufferedAsymmetricBlockCipher {
    protected byte[] buf;
    protected int bufOff;
    private final AsymmetricBlockCipher cipher;

    public BufferedAsymmetricBlockCipher(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.cipher = asymmetricBlockCipher;
    }

    public byte[] doFinal() throws InvalidCipherTextException {
        byte[] processBlock = this.cipher.processBlock(this.buf, 0, this.bufOff);
        reset();
        return processBlock;
    }

    public int getBufferPosition() {
        return this.bufOff;
    }

    public int getInputBlockSize() {
        return this.cipher.getInputBlockSize();
    }

    public int getOutputBlockSize() {
        return this.cipher.getOutputBlockSize();
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        reset();
        this.cipher.init(z10, cipherParameters);
        this.buf = new byte[(this.cipher.getInputBlockSize() + (z10 ? 1 : 0))];
        this.bufOff = 0;
    }

    public void processByte(byte b10) {
        int i10 = this.bufOff;
        byte[] bArr = this.buf;
        if (i10 < bArr.length) {
            this.bufOff = i10 + 1;
            bArr[i10] = b10;
            return;
        }
        throw new DataLengthException("attempt to process message too long for cipher");
    }

    public void processBytes(byte[] bArr, int i10, int i11) {
        if (i11 != 0) {
            if (i11 >= 0) {
                int i12 = this.bufOff;
                int i13 = i12 + i11;
                byte[] bArr2 = this.buf;
                if (i13 <= bArr2.length) {
                    System.arraycopy(bArr, i10, bArr2, i12, i11);
                    this.bufOff += i11;
                    return;
                }
                throw new DataLengthException("attempt to process message too long for cipher");
            }
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
    }

    public void reset() {
        if (this.buf != null) {
            int i10 = 0;
            while (true) {
                byte[] bArr = this.buf;
                if (i10 >= bArr.length) {
                    break;
                }
                bArr[i10] = 0;
                i10++;
            }
        }
        this.bufOff = 0;
    }
}
