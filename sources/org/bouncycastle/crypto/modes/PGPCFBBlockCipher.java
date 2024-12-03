package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class PGPCFBBlockCipher implements BlockCipher {
    private byte[] FR;
    private byte[] FRE;
    private byte[] IV;
    private int blockSize;
    private BlockCipher cipher;
    private int count;
    private boolean forEncryption;
    private boolean inlineIv;
    private byte[] tmp;

    public PGPCFBBlockCipher(BlockCipher blockCipher, boolean z10) {
        this.cipher = blockCipher;
        this.inlineIv = z10;
        int blockSize2 = blockCipher.getBlockSize();
        this.blockSize = blockSize2;
        this.IV = new byte[blockSize2];
        this.FR = new byte[blockSize2];
        this.FRE = new byte[blockSize2];
        this.tmp = new byte[blockSize2];
    }

    private int decryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        int i12 = this.blockSize;
        if (i10 + i12 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 + i11 <= bArr2.length) {
            int i13 = 0;
            this.cipher.processBlock(this.FR, 0, this.FRE, 0);
            for (int i14 = 0; i14 < this.blockSize; i14++) {
                bArr2[i11 + i14] = encryptByte(bArr[i10 + i14], i14);
            }
            while (true) {
                int i15 = this.blockSize;
                if (i13 >= i15) {
                    return i15;
                }
                this.FR[i13] = bArr[i10 + i13];
                i13++;
            }
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    private int decryptBlockWithIV(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        int i12;
        int i13 = this.blockSize;
        if (i10 + i13 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i11 + i13 <= bArr2.length) {
            int i14 = this.count;
            if (i14 == 0) {
                for (int i15 = 0; i15 < this.blockSize; i15++) {
                    this.FR[i15] = bArr[i10 + i15];
                }
                this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                this.count += this.blockSize;
                return 0;
            } else if (i14 == i13) {
                System.arraycopy(bArr, i10, this.tmp, 0, i13);
                byte[] bArr3 = this.FR;
                System.arraycopy(bArr3, 2, bArr3, 0, this.blockSize - 2);
                byte[] bArr4 = this.FR;
                int i16 = this.blockSize;
                byte[] bArr5 = this.tmp;
                bArr4[i16 - 2] = bArr5[0];
                bArr4[i16 - 1] = bArr5[1];
                this.cipher.processBlock(bArr4, 0, this.FRE, 0);
                int i17 = 0;
                while (true) {
                    int i18 = this.blockSize;
                    if (i17 < i18 - 2) {
                        bArr2[i11 + i17] = encryptByte(this.tmp[i17 + 2], i17);
                        i17++;
                    } else {
                        System.arraycopy(this.tmp, 2, this.FR, 0, i18 - 2);
                        this.count += 2;
                        return this.blockSize - 2;
                    }
                }
            } else {
                if (i14 >= i13 + 2) {
                    System.arraycopy(bArr, i10, this.tmp, 0, i13);
                    bArr2[i11 + 0] = encryptByte(this.tmp[0], this.blockSize - 2);
                    bArr2[i11 + 1] = encryptByte(this.tmp[1], this.blockSize - 1);
                    System.arraycopy(this.tmp, 0, this.FR, this.blockSize - 2, 2);
                    this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                    int i19 = 0;
                    while (true) {
                        i12 = this.blockSize;
                        if (i19 >= i12 - 2) {
                            break;
                        }
                        bArr2[i11 + i19 + 2] = encryptByte(this.tmp[i19 + 2], i19);
                        i19++;
                    }
                    System.arraycopy(this.tmp, 2, this.FR, 0, i12 - 2);
                }
                return this.blockSize;
            }
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    private int encryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        int i12 = this.blockSize;
        if (i10 + i12 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 + i11 <= bArr2.length) {
            int i13 = 0;
            this.cipher.processBlock(this.FR, 0, this.FRE, 0);
            for (int i14 = 0; i14 < this.blockSize; i14++) {
                bArr2[i11 + i14] = encryptByte(bArr[i10 + i14], i14);
            }
            while (true) {
                int i15 = this.blockSize;
                if (i13 >= i15) {
                    return i15;
                }
                this.FR[i13] = bArr2[i11 + i13];
                i13++;
            }
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    private int encryptBlockWithIV(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        int i12;
        int i13;
        int i14 = this.blockSize;
        if (i10 + i14 <= bArr.length) {
            int i15 = this.count;
            if (i15 != 0) {
                if (i15 >= i14 + 2) {
                    if (i14 + i11 <= bArr2.length) {
                        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                        int i16 = 0;
                        while (true) {
                            i12 = this.blockSize;
                            if (i16 >= i12) {
                                break;
                            }
                            bArr2[i11 + i16] = encryptByte(bArr[i10 + i16], i16);
                            i16++;
                        }
                        System.arraycopy(bArr2, i11, this.FR, 0, i12);
                    } else {
                        throw new OutputLengthException("output buffer too short");
                    }
                }
                return this.blockSize;
            } else if ((i14 * 2) + i11 + 2 <= bArr2.length) {
                this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                int i17 = 0;
                while (true) {
                    i13 = this.blockSize;
                    if (i17 >= i13) {
                        break;
                    }
                    bArr2[i11 + i17] = encryptByte(this.IV[i17], i17);
                    i17++;
                }
                System.arraycopy(bArr2, i11, this.FR, 0, i13);
                this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                int i18 = this.blockSize;
                bArr2[i11 + i18] = encryptByte(this.IV[i18 - 2], 0);
                int i19 = this.blockSize;
                bArr2[i11 + i19 + 1] = encryptByte(this.IV[i19 - 1], 1);
                System.arraycopy(bArr2, i11 + 2, this.FR, 0, this.blockSize);
                this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                int i20 = 0;
                while (true) {
                    int i21 = this.blockSize;
                    if (i20 < i21) {
                        bArr2[i21 + i11 + 2 + i20] = encryptByte(bArr[i10 + i20], i20);
                        i20++;
                    } else {
                        System.arraycopy(bArr2, i11 + i21 + 2, this.FR, 0, i21);
                        int i22 = this.count;
                        int i23 = this.blockSize;
                        this.count = i22 + (i23 * 2) + 2;
                        return (i23 * 2) + 2;
                    }
                }
            } else {
                throw new OutputLengthException("output buffer too short");
            }
        } else {
            throw new DataLengthException("input buffer too short");
        }
    }

    private byte encryptByte(byte b10, int i10) {
        return (byte) (b10 ^ this.FRE[i10]);
    }

    public String getAlgorithmName() {
        StringBuilder sb2;
        String str;
        if (this.inlineIv) {
            sb2 = new StringBuilder();
            sb2.append(this.cipher.getAlgorithmName());
            str = "/PGPCFBwithIV";
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.cipher.getAlgorithmName());
            str = "/PGPCFB";
        }
        sb2.append(str);
        return sb2.toString();
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        BlockCipher blockCipher;
        this.forEncryption = z10;
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
            blockCipher = this.cipher;
            cipherParameters = parametersWithIV.getParameters();
        } else {
            reset();
            blockCipher = this.cipher;
        }
        blockCipher.init(true, cipherParameters);
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        return this.inlineIv ? this.forEncryption ? encryptBlockWithIV(bArr, i10, bArr2, i11) : decryptBlockWithIV(bArr, i10, bArr2, i11) : this.forEncryption ? encryptBlock(bArr, i10, bArr2, i11) : decryptBlock(bArr, i10, bArr2, i11);
    }

    public void reset() {
        this.count = 0;
        int i10 = 0;
        while (true) {
            byte[] bArr = this.FR;
            if (i10 != bArr.length) {
                if (this.inlineIv) {
                    bArr[i10] = 0;
                } else {
                    bArr[i10] = this.IV[i10];
                }
                i10++;
            } else {
                this.cipher.reset();
                return;
            }
        }
    }
}
