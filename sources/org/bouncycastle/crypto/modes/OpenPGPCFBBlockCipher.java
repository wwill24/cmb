package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

public class OpenPGPCFBBlockCipher implements BlockCipher {
    private byte[] FR;
    private byte[] FRE;
    private byte[] IV;
    private int blockSize;
    private BlockCipher cipher;
    private int count;
    private boolean forEncryption;

    public OpenPGPCFBBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        int blockSize2 = blockCipher.getBlockSize();
        this.blockSize = blockSize2;
        this.IV = new byte[blockSize2];
        this.FR = new byte[blockSize2];
        this.FRE = new byte[blockSize2];
    }

    private int decryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        int i12;
        int i13;
        int i14;
        int i15 = this.blockSize;
        if (i10 + i15 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i11 + i15 <= bArr2.length) {
            int i16 = this.count;
            int i17 = 2;
            int i18 = 0;
            if (i16 > i15) {
                byte b10 = bArr[i10];
                this.FR[i15 - 2] = b10;
                bArr2[i11] = encryptByte(b10, i15 - 2);
                byte b11 = bArr[i10 + 1];
                byte[] bArr3 = this.FR;
                int i19 = this.blockSize;
                bArr3[i19 - 1] = b11;
                bArr2[i11 + 1] = encryptByte(b11, i19 - 1);
                this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                while (i17 < this.blockSize) {
                    byte b12 = bArr[i10 + i17];
                    int i20 = i17 - 2;
                    this.FR[i20] = b12;
                    bArr2[i11 + i17] = encryptByte(b12, i20);
                    i17++;
                }
            } else {
                if (i16 == 0) {
                    this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                    while (true) {
                        i14 = this.blockSize;
                        if (i18 >= i14) {
                            break;
                        }
                        int i21 = i10 + i18;
                        this.FR[i18] = bArr[i21];
                        bArr2[i18] = encryptByte(bArr[i21], i18);
                        i18++;
                    }
                    i13 = this.count + i14;
                } else if (i16 == i15) {
                    this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                    byte b13 = bArr[i10];
                    byte b14 = bArr[i10 + 1];
                    bArr2[i11] = encryptByte(b13, 0);
                    bArr2[i11 + 1] = encryptByte(b14, 1);
                    byte[] bArr4 = this.FR;
                    System.arraycopy(bArr4, 2, bArr4, 0, this.blockSize - 2);
                    byte[] bArr5 = this.FR;
                    int i22 = this.blockSize;
                    bArr5[i22 - 2] = b13;
                    bArr5[i22 - 1] = b14;
                    this.cipher.processBlock(bArr5, 0, this.FRE, 0);
                    while (true) {
                        i12 = this.blockSize;
                        if (i17 >= i12) {
                            break;
                        }
                        byte b15 = bArr[i10 + i17];
                        int i23 = i17 - 2;
                        this.FR[i23] = b15;
                        bArr2[i11 + i17] = encryptByte(b15, i23);
                        i17++;
                    }
                    i13 = this.count + i12;
                }
                this.count = i13;
            }
            return this.blockSize;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    private int encryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        int i12;
        int i13 = this.blockSize;
        if (i10 + i13 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i11 + i13 <= bArr2.length) {
            int i14 = this.count;
            int i15 = 2;
            int i16 = 0;
            if (i14 > i13) {
                byte[] bArr3 = this.FR;
                int i17 = i13 - 2;
                byte encryptByte = encryptByte(bArr[i10], i13 - 2);
                bArr2[i11] = encryptByte;
                bArr3[i17] = encryptByte;
                byte[] bArr4 = this.FR;
                int i18 = this.blockSize;
                int i19 = i18 - 1;
                byte encryptByte2 = encryptByte(bArr[i10 + 1], i18 - 1);
                bArr2[i11 + 1] = encryptByte2;
                bArr4[i19] = encryptByte2;
                this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                while (i15 < this.blockSize) {
                    byte[] bArr5 = this.FR;
                    int i20 = i15 - 2;
                    byte encryptByte3 = encryptByte(bArr[i10 + i15], i20);
                    bArr2[i11 + i15] = encryptByte3;
                    bArr5[i20] = encryptByte3;
                    i15++;
                }
            } else {
                if (i14 != 0) {
                    if (i14 == i13) {
                        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                        bArr2[i11] = encryptByte(bArr[i10], 0);
                        bArr2[i11 + 1] = encryptByte(bArr[i10 + 1], 1);
                        byte[] bArr6 = this.FR;
                        System.arraycopy(bArr6, 2, bArr6, 0, this.blockSize - 2);
                        System.arraycopy(bArr2, i11, this.FR, this.blockSize - 2, 2);
                        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                        while (true) {
                            i12 = this.blockSize;
                            if (i15 >= i12) {
                                break;
                            }
                            byte[] bArr7 = this.FR;
                            int i21 = i15 - 2;
                            byte encryptByte4 = encryptByte(bArr[i10 + i15], i21);
                            bArr2[i11 + i15] = encryptByte4;
                            bArr7[i21] = encryptByte4;
                            i15++;
                        }
                    }
                } else {
                    this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                    while (true) {
                        i12 = this.blockSize;
                        if (i16 >= i12) {
                            break;
                        }
                        byte[] bArr8 = this.FR;
                        byte encryptByte5 = encryptByte(bArr[i10 + i16], i16);
                        bArr2[i11 + i16] = encryptByte5;
                        bArr8[i16] = encryptByte5;
                        i16++;
                    }
                }
                this.count += i12;
            }
            return this.blockSize;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    private byte encryptByte(byte b10, int i10) {
        return (byte) (b10 ^ this.FRE[i10]);
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/OpenPGPCFB";
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.forEncryption = z10;
        reset();
        this.cipher.init(true, cipherParameters);
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        return this.forEncryption ? encryptBlock(bArr, i10, bArr2, i11) : decryptBlock(bArr, i10, bArr2, i11);
    }

    public void reset() {
        this.count = 0;
        byte[] bArr = this.IV;
        byte[] bArr2 = this.FR;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.cipher.reset();
    }
}
