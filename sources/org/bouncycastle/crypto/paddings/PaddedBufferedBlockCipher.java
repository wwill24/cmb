package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.ParametersWithRandom;

public class PaddedBufferedBlockCipher extends BufferedBlockCipher {
    BlockCipherPadding padding;

    public PaddedBufferedBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, new PKCS7Padding());
    }

    public PaddedBufferedBlockCipher(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
        this.cipher = blockCipher;
        this.padding = blockCipherPadding;
        this.buf = new byte[blockCipher.getBlockSize()];
        this.bufOff = 0;
    }

    public int doFinal(byte[] bArr, int i10) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        int padCount;
        int i11;
        int blockSize = this.cipher.getBlockSize();
        if (this.forEncryption) {
            if (this.bufOff != blockSize) {
                i11 = 0;
            } else if ((blockSize * 2) + i10 <= bArr.length) {
                i11 = this.cipher.processBlock(this.buf, 0, bArr, i10);
                this.bufOff = 0;
            } else {
                reset();
                throw new OutputLengthException("output buffer too short");
            }
            this.padding.addPadding(this.buf, this.bufOff);
            padCount = i11 + this.cipher.processBlock(this.buf, 0, bArr, i10 + i11);
        } else if (this.bufOff == blockSize) {
            BlockCipher blockCipher = this.cipher;
            byte[] bArr2 = this.buf;
            int processBlock = blockCipher.processBlock(bArr2, 0, bArr2, 0);
            this.bufOff = 0;
            try {
                padCount = processBlock - this.padding.padCount(this.buf);
                System.arraycopy(this.buf, 0, bArr, i10, padCount);
            } catch (Throwable th2) {
                reset();
                throw th2;
            }
        } else {
            reset();
            throw new DataLengthException("last block incomplete in decryption");
        }
        reset();
        return padCount;
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
        return length == 0 ? Math.max(0, i11 - bArr.length) : i11 - length;
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        BlockCipher blockCipher;
        this.forEncryption = z10;
        reset();
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.padding.init(parametersWithRandom.getRandom());
            blockCipher = this.cipher;
            cipherParameters = parametersWithRandom.getParameters();
        } else {
            this.padding.init((SecureRandom) null);
            blockCipher = this.cipher;
        }
        blockCipher.init(z10, cipherParameters);
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
