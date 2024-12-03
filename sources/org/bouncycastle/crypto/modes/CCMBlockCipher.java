package org.bouncycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.macs.CBCBlockCipherMac;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class CCMBlockCipher implements AEADBlockCipher {
    private ExposedByteArrayOutputStream associatedText = new ExposedByteArrayOutputStream();
    private int blockSize;
    private BlockCipher cipher;
    private ExposedByteArrayOutputStream data = new ExposedByteArrayOutputStream();
    private boolean forEncryption;
    private byte[] initialAssociatedText;
    private CipherParameters keyParam;
    private byte[] macBlock;
    private int macSize;
    private byte[] nonce;

    private class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public ExposedByteArrayOutputStream() {
        }

        public byte[] getBuffer() {
            return this.buf;
        }
    }

    public CCMBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        int blockSize2 = blockCipher.getBlockSize();
        this.blockSize = blockSize2;
        this.macBlock = new byte[blockSize2];
        if (blockSize2 != 16) {
            throw new IllegalArgumentException("cipher required with a block size of 16.");
        }
    }

    private int calculateMac(byte[] bArr, int i10, int i11, byte[] bArr2) {
        CBCBlockCipherMac cBCBlockCipherMac = new CBCBlockCipherMac(this.cipher, this.macSize * 8);
        cBCBlockCipherMac.init(this.keyParam);
        byte[] bArr3 = new byte[16];
        if (hasAssociatedText()) {
            bArr3[0] = (byte) (bArr3[0] | 64);
        }
        int i12 = 2;
        byte macSize2 = (byte) (bArr3[0] | ((((cBCBlockCipherMac.getMacSize() - 2) / 2) & 7) << 3));
        bArr3[0] = macSize2;
        byte[] bArr4 = this.nonce;
        bArr3[0] = (byte) (macSize2 | (((15 - bArr4.length) - 1) & 7));
        System.arraycopy(bArr4, 0, bArr3, 1, bArr4.length);
        int i13 = i11;
        int i14 = 1;
        while (i13 > 0) {
            bArr3[16 - i14] = (byte) (i13 & 255);
            i13 >>>= 8;
            i14++;
        }
        cBCBlockCipherMac.update(bArr3, 0, 16);
        if (hasAssociatedText()) {
            int associatedTextLength = getAssociatedTextLength();
            if (associatedTextLength < 65280) {
                cBCBlockCipherMac.update((byte) (associatedTextLength >> 8));
                cBCBlockCipherMac.update((byte) associatedTextLength);
            } else {
                cBCBlockCipherMac.update((byte) -1);
                cBCBlockCipherMac.update((byte) -2);
                cBCBlockCipherMac.update((byte) (associatedTextLength >> 24));
                cBCBlockCipherMac.update((byte) (associatedTextLength >> 16));
                cBCBlockCipherMac.update((byte) (associatedTextLength >> 8));
                cBCBlockCipherMac.update((byte) associatedTextLength);
                i12 = 6;
            }
            byte[] bArr5 = this.initialAssociatedText;
            if (bArr5 != null) {
                cBCBlockCipherMac.update(bArr5, 0, bArr5.length);
            }
            if (this.associatedText.size() > 0) {
                cBCBlockCipherMac.update(this.associatedText.getBuffer(), 0, this.associatedText.size());
            }
            int i15 = (i12 + associatedTextLength) % 16;
            if (i15 != 0) {
                while (i15 != 16) {
                    cBCBlockCipherMac.update((byte) 0);
                    i15++;
                }
            }
        }
        cBCBlockCipherMac.update(bArr, i10, i11);
        return cBCBlockCipherMac.doFinal(bArr2, 0);
    }

    private int getAssociatedTextLength() {
        int size = this.associatedText.size();
        byte[] bArr = this.initialAssociatedText;
        return size + (bArr == null ? 0 : bArr.length);
    }

    private int getMacSize(boolean z10, int i10) {
        if (!z10 || (i10 >= 32 && i10 <= 128 && (i10 & 15) == 0)) {
            return i10 >>> 3;
        }
        throw new IllegalArgumentException("tag length in octets must be one of {4,6,8,10,12,14,16}");
    }

    private boolean hasAssociatedText() {
        return getAssociatedTextLength() > 0;
    }

    public int doFinal(byte[] bArr, int i10) throws IllegalStateException, InvalidCipherTextException {
        int processPacket = processPacket(this.data.getBuffer(), 0, this.data.size(), bArr, i10);
        reset();
        return processPacket;
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CCM";
    }

    public byte[] getMac() {
        int i10 = this.macSize;
        byte[] bArr = new byte[i10];
        System.arraycopy(this.macBlock, 0, bArr, 0, i10);
        return bArr;
    }

    public int getOutputSize(int i10) {
        int size = i10 + this.data.size();
        if (this.forEncryption) {
            return size + this.macSize;
        }
        int i11 = this.macSize;
        if (size < i11) {
            return 0;
        }
        return size - i11;
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public int getUpdateOutputSize(int i10) {
        return 0;
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters cipherParameters2;
        this.forEncryption = z10;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            this.nonce = aEADParameters.getNonce();
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            this.macSize = getMacSize(z10, aEADParameters.getMacSize());
            cipherParameters2 = aEADParameters.getKey();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.nonce = parametersWithIV.getIV();
            this.initialAssociatedText = null;
            this.macSize = getMacSize(z10, 64);
            cipherParameters2 = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to CCM: " + cipherParameters.getClass().getName());
        }
        if (cipherParameters2 != null) {
            this.keyParam = cipherParameters2;
        }
        byte[] bArr = this.nonce;
        if (bArr == null || bArr.length < 7 || bArr.length > 13) {
            throw new IllegalArgumentException("nonce must have length from 7 to 13 octets");
        }
        reset();
    }

    public void processAADByte(byte b10) {
        this.associatedText.write(b10);
    }

    public void processAADBytes(byte[] bArr, int i10, int i11) {
        this.associatedText.write(bArr, i10, i11);
    }

    public int processByte(byte b10, byte[] bArr, int i10) throws DataLengthException, IllegalStateException {
        this.data.write(b10);
        return 0;
    }

    public int processBytes(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException {
        if (bArr.length >= i10 + i11) {
            this.data.write(bArr, i10, i11);
            return 0;
        }
        throw new DataLengthException("Input buffer too short");
    }

    public int processPacket(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws IllegalStateException, InvalidCipherTextException, DataLengthException {
        int i13;
        if (this.keyParam != null) {
            byte[] bArr3 = this.nonce;
            int length = 15 - bArr3.length;
            if (length >= 4 || i11 < (1 << (length * 8))) {
                byte[] bArr4 = new byte[this.blockSize];
                bArr4[0] = (byte) ((length - 1) & 7);
                System.arraycopy(bArr3, 0, bArr4, 1, bArr3.length);
                SICBlockCipher sICBlockCipher = new SICBlockCipher(this.cipher);
                sICBlockCipher.init(this.forEncryption, new ParametersWithIV(this.keyParam, bArr4));
                if (this.forEncryption) {
                    int i14 = this.macSize + i11;
                    if (bArr2.length >= i14 + i12) {
                        calculateMac(bArr, i10, i11, this.macBlock);
                        byte[] bArr5 = new byte[this.blockSize];
                        sICBlockCipher.processBlock(this.macBlock, 0, bArr5, 0);
                        int i15 = i10;
                        int i16 = i12;
                        while (true) {
                            int i17 = i10 + i11;
                            int i18 = this.blockSize;
                            if (i15 < i17 - i18) {
                                sICBlockCipher.processBlock(bArr, i15, bArr2, i16);
                                int i19 = this.blockSize;
                                i16 += i19;
                                i15 += i19;
                            } else {
                                byte[] bArr6 = new byte[i18];
                                int i20 = i17 - i15;
                                System.arraycopy(bArr, i15, bArr6, 0, i20);
                                sICBlockCipher.processBlock(bArr6, 0, bArr6, 0);
                                System.arraycopy(bArr6, 0, bArr2, i16, i20);
                                System.arraycopy(bArr5, 0, bArr2, i12 + i11, this.macSize);
                                return i14;
                            }
                        }
                    } else {
                        throw new OutputLengthException("Output buffer too short.");
                    }
                } else {
                    int i21 = this.macSize;
                    if (i11 >= i21) {
                        int i22 = i11 - i21;
                        if (bArr2.length >= i22 + i12) {
                            int i23 = i10 + i22;
                            System.arraycopy(bArr, i23, this.macBlock, 0, i21);
                            byte[] bArr7 = this.macBlock;
                            sICBlockCipher.processBlock(bArr7, 0, bArr7, 0);
                            int i24 = this.macSize;
                            while (true) {
                                byte[] bArr8 = this.macBlock;
                                if (i24 == bArr8.length) {
                                    break;
                                }
                                bArr8[i24] = 0;
                                i24++;
                            }
                            int i25 = i10;
                            int i26 = i12;
                            while (true) {
                                i13 = this.blockSize;
                                if (i25 >= i23 - i13) {
                                    break;
                                }
                                sICBlockCipher.processBlock(bArr, i25, bArr2, i26);
                                int i27 = this.blockSize;
                                i26 += i27;
                                i25 += i27;
                            }
                            byte[] bArr9 = new byte[i13];
                            int i28 = i22 - (i25 - i10);
                            System.arraycopy(bArr, i25, bArr9, 0, i28);
                            sICBlockCipher.processBlock(bArr9, 0, bArr9, 0);
                            System.arraycopy(bArr9, 0, bArr2, i26, i28);
                            byte[] bArr10 = new byte[this.blockSize];
                            calculateMac(bArr2, i12, i22, bArr10);
                            if (Arrays.constantTimeAreEqual(this.macBlock, bArr10)) {
                                return i22;
                            }
                            throw new InvalidCipherTextException("mac check in CCM failed");
                        }
                        throw new OutputLengthException("Output buffer too short.");
                    }
                    throw new InvalidCipherTextException("data too short");
                }
            } else {
                throw new IllegalStateException("CCM packet too large for choice of q.");
            }
        } else {
            throw new IllegalStateException("CCM cipher unitialized.");
        }
    }

    public byte[] processPacket(byte[] bArr, int i10, int i11) throws IllegalStateException, InvalidCipherTextException {
        int i12;
        if (this.forEncryption) {
            i12 = this.macSize + i11;
        } else {
            int i13 = this.macSize;
            if (i11 >= i13) {
                i12 = i11 - i13;
            } else {
                throw new InvalidCipherTextException("data too short");
            }
        }
        byte[] bArr2 = new byte[i12];
        processPacket(bArr, i10, i11, bArr2, 0);
        return bArr2;
    }

    public void reset() {
        this.cipher.reset();
        this.associatedText.reset();
        this.data.reset();
    }
}
