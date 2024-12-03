package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;

public class OldCTSBlockCipher extends BufferedBlockCipher {
    private int blockSize;

    public OldCTSBlockCipher(BlockCipher blockCipher) {
        if ((blockCipher instanceof OFBBlockCipher) || (blockCipher instanceof CFBBlockCipher)) {
            throw new IllegalArgumentException("CTSBlockCipher can only accept ECB, or CBC ciphers");
        }
        this.cipher = blockCipher;
        int blockSize2 = blockCipher.getBlockSize();
        this.blockSize = blockSize2;
        this.buf = new byte[(blockSize2 * 2)];
        this.bufOff = 0;
    }

    public int doFinal(byte[] bArr, int i10) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        if (this.bufOff + i10 <= bArr.length) {
            int blockSize2 = this.cipher.getBlockSize();
            int i11 = this.bufOff - blockSize2;
            byte[] bArr2 = new byte[blockSize2];
            if (this.forEncryption) {
                this.cipher.processBlock(this.buf, 0, bArr2, 0);
                int i12 = this.bufOff;
                if (i12 >= blockSize2) {
                    while (true) {
                        byte[] bArr3 = this.buf;
                        if (i12 == bArr3.length) {
                            break;
                        }
                        bArr3[i12] = bArr2[i12 - blockSize2];
                        i12++;
                    }
                    for (int i13 = blockSize2; i13 != this.bufOff; i13++) {
                        byte[] bArr4 = this.buf;
                        bArr4[i13] = (byte) (bArr4[i13] ^ bArr2[i13 - blockSize2]);
                    }
                    BlockCipher blockCipher = this.cipher;
                    if (blockCipher instanceof CBCBlockCipher) {
                        ((CBCBlockCipher) blockCipher).getUnderlyingCipher().processBlock(this.buf, blockSize2, bArr, i10);
                    } else {
                        blockCipher.processBlock(this.buf, blockSize2, bArr, i10);
                    }
                    System.arraycopy(bArr2, 0, bArr, i10 + blockSize2, i11);
                } else {
                    throw new DataLengthException("need at least one block of input for CTS");
                }
            } else {
                byte[] bArr5 = new byte[blockSize2];
                BlockCipher blockCipher2 = this.cipher;
                if (blockCipher2 instanceof CBCBlockCipher) {
                    ((CBCBlockCipher) blockCipher2).getUnderlyingCipher().processBlock(this.buf, 0, bArr2, 0);
                } else {
                    blockCipher2.processBlock(this.buf, 0, bArr2, 0);
                }
                for (int i14 = blockSize2; i14 != this.bufOff; i14++) {
                    int i15 = i14 - blockSize2;
                    bArr5[i15] = (byte) (bArr2[i15] ^ this.buf[i14]);
                }
                System.arraycopy(this.buf, blockSize2, bArr2, 0, i11);
                this.cipher.processBlock(bArr2, 0, bArr, i10);
                System.arraycopy(bArr5, 0, bArr, i10 + blockSize2, i11);
            }
            int i16 = this.bufOff;
            reset();
            return i16;
        }
        throw new OutputLengthException("output buffer to small in doFinal");
    }

    public int getOutputSize(int i10) {
        return i10 + this.bufOff;
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
            byte[] bArr3 = this.buf;
            int i13 = this.blockSize;
            System.arraycopy(bArr3, i13, bArr3, 0, i13);
            this.bufOff = this.blockSize;
            i12 = processBlock;
        }
        byte[] bArr4 = this.buf;
        int i14 = this.bufOff;
        this.bufOff = i14 + 1;
        bArr4[i14] = b10;
        return i12;
    }

    public int processBytes(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException {
        if (i11 >= 0) {
            int blockSize2 = getBlockSize();
            int updateOutputSize = getUpdateOutputSize(i11);
            if (updateOutputSize <= 0 || updateOutputSize + i12 <= bArr2.length) {
                byte[] bArr3 = this.buf;
                int length = bArr3.length;
                int i13 = this.bufOff;
                int i14 = length - i13;
                int i15 = 0;
                if (i11 > i14) {
                    System.arraycopy(bArr, i10, bArr3, i13, i14);
                    int processBlock = this.cipher.processBlock(this.buf, 0, bArr2, i12) + 0;
                    byte[] bArr4 = this.buf;
                    System.arraycopy(bArr4, blockSize2, bArr4, 0, blockSize2);
                    this.bufOff = blockSize2;
                    i11 -= i14;
                    i10 += i14;
                    while (i11 > blockSize2) {
                        System.arraycopy(bArr, i10, this.buf, this.bufOff, blockSize2);
                        processBlock += this.cipher.processBlock(this.buf, 0, bArr2, i12 + processBlock);
                        byte[] bArr5 = this.buf;
                        System.arraycopy(bArr5, blockSize2, bArr5, 0, blockSize2);
                        i11 -= blockSize2;
                        i10 += blockSize2;
                    }
                    i15 = processBlock;
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
