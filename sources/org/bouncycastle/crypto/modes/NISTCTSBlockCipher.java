package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;

public class NISTCTSBlockCipher extends BufferedBlockCipher {
    public static final int CS1 = 1;
    public static final int CS2 = 2;
    public static final int CS3 = 3;
    private final int blockSize;
    private final int type;

    public NISTCTSBlockCipher(int i10, BlockCipher blockCipher) {
        this.type = i10;
        this.cipher = new CBCBlockCipher(blockCipher);
        int blockSize2 = blockCipher.getBlockSize();
        this.blockSize = blockSize2;
        this.buf = new byte[(blockSize2 * 2)];
        this.bufOff = 0;
    }

    public int doFinal(byte[] bArr, int i10) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        if (this.bufOff + i10 <= bArr.length) {
            int blockSize2 = this.cipher.getBlockSize();
            int i11 = this.bufOff;
            int i12 = i11 - blockSize2;
            byte[] bArr2 = new byte[blockSize2];
            if (this.forEncryption) {
                if (i11 < blockSize2) {
                    throw new DataLengthException("need at least one block of input for NISTCTS");
                } else if (i11 > blockSize2) {
                    byte[] bArr3 = new byte[blockSize2];
                    int i13 = this.type;
                    if (i13 == 2 || i13 == 3) {
                        this.cipher.processBlock(this.buf, 0, bArr2, 0);
                        System.arraycopy(this.buf, blockSize2, bArr3, 0, i12);
                        this.cipher.processBlock(bArr3, 0, bArr3, 0);
                        if (this.type == 2 && i12 == blockSize2) {
                            System.arraycopy(bArr2, 0, bArr, i10, blockSize2);
                            System.arraycopy(bArr3, 0, bArr, i10 + blockSize2, i12);
                        } else {
                            System.arraycopy(bArr3, 0, bArr, i10, blockSize2);
                            System.arraycopy(bArr2, 0, bArr, i10 + blockSize2, i12);
                        }
                        int i14 = this.bufOff;
                        reset();
                        return i14;
                    }
                    System.arraycopy(this.buf, 0, bArr2, 0, blockSize2);
                    this.cipher.processBlock(bArr2, 0, bArr2, 0);
                    System.arraycopy(bArr2, 0, bArr, i10, i12);
                    System.arraycopy(this.buf, this.bufOff - i12, bArr3, 0, i12);
                    this.cipher.processBlock(bArr3, 0, bArr3, 0);
                    System.arraycopy(bArr3, 0, bArr, i10 + i12, blockSize2);
                    int i142 = this.bufOff;
                    reset();
                    return i142;
                } else {
                    this.cipher.processBlock(this.buf, 0, bArr2, 0);
                }
            } else if (i11 >= blockSize2) {
                byte[] bArr4 = new byte[blockSize2];
                if (i11 > blockSize2) {
                    int i15 = this.type;
                    if (i15 == 3 || (i15 == 2 && (this.buf.length - i11) % blockSize2 != 0)) {
                        BlockCipher blockCipher = this.cipher;
                        if (blockCipher instanceof CBCBlockCipher) {
                            ((CBCBlockCipher) blockCipher).getUnderlyingCipher().processBlock(this.buf, 0, bArr2, 0);
                        } else {
                            blockCipher.processBlock(this.buf, 0, bArr2, 0);
                        }
                        for (int i16 = blockSize2; i16 != this.bufOff; i16++) {
                            int i17 = i16 - blockSize2;
                            bArr4[i17] = (byte) (bArr2[i17] ^ this.buf[i16]);
                        }
                        System.arraycopy(this.buf, blockSize2, bArr2, 0, i12);
                        this.cipher.processBlock(bArr2, 0, bArr, i10);
                    } else {
                        ((CBCBlockCipher) this.cipher).getUnderlyingCipher().processBlock(this.buf, this.bufOff - blockSize2, bArr4, 0);
                        System.arraycopy(this.buf, 0, bArr2, 0, blockSize2);
                        if (i12 != blockSize2) {
                            System.arraycopy(bArr4, i12, bArr2, i12, blockSize2 - i12);
                        }
                        this.cipher.processBlock(bArr2, 0, bArr2, 0);
                        System.arraycopy(bArr2, 0, bArr, i10, blockSize2);
                        for (int i18 = 0; i18 != i12; i18++) {
                            bArr4[i18] = (byte) (bArr4[i18] ^ this.buf[i18]);
                        }
                    }
                    System.arraycopy(bArr4, 0, bArr, i10 + blockSize2, i12);
                    int i1422 = this.bufOff;
                    reset();
                    return i1422;
                }
                this.cipher.processBlock(this.buf, 0, bArr2, 0);
            } else {
                throw new DataLengthException("need at least one block of input for CTS");
            }
            System.arraycopy(bArr2, 0, bArr, i10, blockSize2);
            int i14222 = this.bufOff;
            reset();
            return i14222;
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
