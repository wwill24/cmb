package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;

public class PaddedBlockCipher extends BufferedBlockCipher {
    public PaddedBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        this.buf = new byte[blockCipher.getBlockSize()];
        this.bufOff = 0;
    }

    public int doFinal(byte[] bArr, int i10) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        int i11;
        int i12;
        int blockSize = this.cipher.getBlockSize();
        if (this.forEncryption) {
            if (this.bufOff != blockSize) {
                i12 = 0;
            } else if ((blockSize * 2) + i10 <= bArr.length) {
                i12 = this.cipher.processBlock(this.buf, 0, bArr, i10);
                this.bufOff = 0;
            } else {
                throw new OutputLengthException("output buffer too short");
            }
            byte b10 = (byte) (blockSize - this.bufOff);
            while (true) {
                int i13 = this.bufOff;
                if (i13 >= blockSize) {
                    break;
                }
                this.buf[i13] = b10;
                this.bufOff = i13 + 1;
            }
            i11 = i12 + this.cipher.processBlock(this.buf, 0, bArr, i10 + i12);
        } else if (this.bufOff == blockSize) {
            BlockCipher blockCipher = this.cipher;
            byte[] bArr2 = this.buf;
            int processBlock = blockCipher.processBlock(bArr2, 0, bArr2, 0);
            this.bufOff = 0;
            byte[] bArr3 = this.buf;
            byte b11 = bArr3[blockSize - 1] & 255;
            if (b11 <= blockSize) {
                i11 = processBlock - b11;
                System.arraycopy(bArr3, 0, bArr, i10, i11);
            } else {
                throw new InvalidCipherTextException("pad block corrupted");
            }
        } else {
            throw new DataLengthException("last block incomplete in decryption");
        }
        reset();
        return i11;
    }

    public int getOutputSize(int i10) {
        int i11 = i10 + this.bufOff;
        byte[] bArr = this.buf;
        int length = i11 % bArr.length;
        if (length != 0) {
            i11 -= length;
        } else if (!this.forEncryption) {
            return i11;
        }
        return i11 + bArr.length;
    }

    public int getUpdateOutputSize(int i10) {
        int i11 = i10 + this.bufOff;
        byte[] bArr = this.buf;
        int length = i11 % bArr.length;
        return length == 0 ? i11 - bArr.length : i11 - length;
    }

    public int processByte(byte b10, byte[] bArr, int i10) throws DataLengthException, IllegalStateException {
        int i11 = this.bufOff;
        byte[] bArr2 = this.buf;
        int i12 = 0;
        if (i11 == bArr2.length) {
            int processBlock = this.cipher.processBlock(bArr2, 0, bArr, i10);
            this.bufOff = 0;
            i12 = processBlock;
        }
        byte[] bArr3 = this.buf;
        int i13 = this.bufOff;
        this.bufOff = i13 + 1;
        bArr3[i13] = b10;
        return i12;
    }

    public int processBytes(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException {
        if (i11 >= 0) {
            int blockSize = getBlockSize();
            int updateOutputSize = getUpdateOutputSize(i11);
            if (updateOutputSize <= 0 || updateOutputSize + i12 <= bArr2.length) {
                byte[] bArr3 = this.buf;
                int length = bArr3.length;
                int i13 = this.bufOff;
                int i14 = length - i13;
                int i15 = 0;
                if (i11 > i14) {
                    System.arraycopy(bArr, i10, bArr3, i13, i14);
                    this.bufOff = 0;
                    i11 -= i14;
                    i10 += i14;
                    i15 = this.cipher.processBlock(this.buf, 0, bArr2, i12) + 0;
                    while (i11 > this.buf.length) {
                        i15 += this.cipher.processBlock(bArr, i10, bArr2, i12 + i15);
                        i11 -= blockSize;
                        i10 += blockSize;
                    }
                }
                System.arraycopy(bArr, i10, this.buf, this.bufOff, i11);
                this.bufOff += i11;
                return i15;
            }
            throw new OutputLengthException("output buffer too short");
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
