package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.macs.CMac;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class EAXBlockCipher implements AEADBlockCipher {
    private static final byte cTAG = 2;
    private static final byte hTAG = 1;
    private static final byte nTAG = 0;
    private byte[] associatedTextMac;
    private int blockSize;
    private byte[] bufBlock;
    private int bufOff;
    private SICBlockCipher cipher;
    private boolean cipherInitialized;
    private boolean forEncryption;
    private byte[] initialAssociatedText;
    private Mac mac;
    private byte[] macBlock = new byte[this.blockSize];
    private int macSize;
    private byte[] nonceMac;

    public EAXBlockCipher(BlockCipher blockCipher) {
        this.blockSize = blockCipher.getBlockSize();
        CMac cMac = new CMac(blockCipher);
        this.mac = cMac;
        this.associatedTextMac = new byte[cMac.getMacSize()];
        this.nonceMac = new byte[this.mac.getMacSize()];
        this.cipher = new SICBlockCipher(blockCipher);
    }

    private void calculateMac() {
        byte[] bArr = new byte[this.blockSize];
        int i10 = 0;
        this.mac.doFinal(bArr, 0);
        while (true) {
            byte[] bArr2 = this.macBlock;
            if (i10 < bArr2.length) {
                bArr2[i10] = (byte) ((this.nonceMac[i10] ^ this.associatedTextMac[i10]) ^ bArr[i10]);
                i10++;
            } else {
                return;
            }
        }
    }

    private void initCipher() {
        if (!this.cipherInitialized) {
            this.cipherInitialized = true;
            this.mac.doFinal(this.associatedTextMac, 0);
            int i10 = this.blockSize;
            byte[] bArr = new byte[i10];
            bArr[i10 - 1] = 2;
            this.mac.update(bArr, 0, i10);
        }
    }

    private int process(byte b10, byte[] bArr, int i10) {
        int i11;
        byte[] bArr2 = this.bufBlock;
        int i12 = this.bufOff;
        int i13 = i12 + 1;
        this.bufOff = i13;
        bArr2[i12] = b10;
        if (i13 != bArr2.length) {
            return 0;
        }
        int length = bArr.length;
        int i14 = this.blockSize;
        if (length >= i10 + i14) {
            if (this.forEncryption) {
                i11 = this.cipher.processBlock(bArr2, 0, bArr, i10);
                this.mac.update(bArr, i10, this.blockSize);
            } else {
                this.mac.update(bArr2, 0, i14);
                i11 = this.cipher.processBlock(this.bufBlock, 0, bArr, i10);
            }
            this.bufOff = 0;
            if (!this.forEncryption) {
                byte[] bArr3 = this.bufBlock;
                System.arraycopy(bArr3, this.blockSize, bArr3, 0, this.macSize);
                this.bufOff = this.macSize;
            }
            return i11;
        }
        throw new OutputLengthException("Output buffer is too short");
    }

    private void reset(boolean z10) {
        this.cipher.reset();
        this.mac.reset();
        this.bufOff = 0;
        Arrays.fill(this.bufBlock, (byte) 0);
        if (z10) {
            Arrays.fill(this.macBlock, (byte) 0);
        }
        int i10 = this.blockSize;
        byte[] bArr = new byte[i10];
        bArr[i10 - 1] = 1;
        this.mac.update(bArr, 0, i10);
        this.cipherInitialized = false;
        byte[] bArr2 = this.initialAssociatedText;
        if (bArr2 != null) {
            processAADBytes(bArr2, 0, bArr2.length);
        }
    }

    private boolean verifyMac(byte[] bArr, int i10) {
        byte b10 = 0;
        for (int i11 = 0; i11 < this.macSize; i11++) {
            b10 |= this.macBlock[i11] ^ bArr[i10 + i11];
        }
        return b10 == 0;
    }

    public int doFinal(byte[] bArr, int i10) throws IllegalStateException, InvalidCipherTextException {
        initCipher();
        int i11 = this.bufOff;
        byte[] bArr2 = this.bufBlock;
        byte[] bArr3 = new byte[bArr2.length];
        this.bufOff = 0;
        if (this.forEncryption) {
            int i12 = i10 + i11;
            if (bArr.length >= this.macSize + i12) {
                this.cipher.processBlock(bArr2, 0, bArr3, 0);
                System.arraycopy(bArr3, 0, bArr, i10, i11);
                this.mac.update(bArr3, 0, i11);
                calculateMac();
                System.arraycopy(this.macBlock, 0, bArr, i12, this.macSize);
                reset(false);
                return i11 + this.macSize;
            }
            throw new OutputLengthException("Output buffer too short");
        }
        int i13 = this.macSize;
        if (i11 < i13) {
            throw new InvalidCipherTextException("data too short");
        } else if (bArr.length >= (i10 + i11) - i13) {
            if (i11 > i13) {
                this.mac.update(bArr2, 0, i11 - i13);
                this.cipher.processBlock(this.bufBlock, 0, bArr3, 0);
                System.arraycopy(bArr3, 0, bArr, i10, i11 - this.macSize);
            }
            calculateMac();
            if (verifyMac(this.bufBlock, i11 - this.macSize)) {
                reset(false);
                return i11 - this.macSize;
            }
            throw new InvalidCipherTextException("mac check in EAX failed");
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
    }

    public String getAlgorithmName() {
        return this.cipher.getUnderlyingCipher().getAlgorithmName() + "/EAX";
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public byte[] getMac() {
        int i10 = this.macSize;
        byte[] bArr = new byte[i10];
        System.arraycopy(this.macBlock, 0, bArr, 0, i10);
        return bArr;
    }

    public int getOutputSize(int i10) {
        int i11 = i10 + this.bufOff;
        if (this.forEncryption) {
            return i11 + this.macSize;
        }
        int i12 = this.macSize;
        if (i11 < i12) {
            return 0;
        }
        return i11 - i12;
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher.getUnderlyingCipher();
    }

    public int getUpdateOutputSize(int i10) {
        int i11 = i10 + this.bufOff;
        if (!this.forEncryption) {
            int i12 = this.macSize;
            if (i11 < i12) {
                return 0;
            }
            i11 -= i12;
        }
        return i11 - (i11 % this.blockSize);
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters cipherParameters2;
        byte[] bArr;
        this.forEncryption = z10;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            bArr = aEADParameters.getNonce();
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            this.macSize = aEADParameters.getMacSize() / 8;
            cipherParameters2 = aEADParameters.getKey();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.getIV();
            this.initialAssociatedText = null;
            this.macSize = this.mac.getMacSize() / 2;
            cipherParameters2 = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to EAX");
        }
        this.bufBlock = new byte[(z10 ? this.blockSize : this.blockSize + this.macSize)];
        byte[] bArr2 = new byte[this.blockSize];
        this.mac.init(cipherParameters2);
        int i10 = this.blockSize;
        bArr2[i10 - 1] = 0;
        this.mac.update(bArr2, 0, i10);
        this.mac.update(bArr, 0, bArr.length);
        this.mac.doFinal(this.nonceMac, 0);
        this.cipher.init(true, new ParametersWithIV((CipherParameters) null, this.nonceMac));
        reset();
    }

    public void processAADByte(byte b10) {
        if (!this.cipherInitialized) {
            this.mac.update(b10);
            return;
        }
        throw new IllegalStateException("AAD data cannot be added after encryption/decryption processing has begun.");
    }

    public void processAADBytes(byte[] bArr, int i10, int i11) {
        if (!this.cipherInitialized) {
            this.mac.update(bArr, i10, i11);
            return;
        }
        throw new IllegalStateException("AAD data cannot be added after encryption/decryption processing has begun.");
    }

    public int processByte(byte b10, byte[] bArr, int i10) throws DataLengthException {
        initCipher();
        return process(b10, bArr, i10);
    }

    public int processBytes(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException {
        initCipher();
        if (bArr.length >= i10 + i11) {
            int i13 = 0;
            for (int i14 = 0; i14 != i11; i14++) {
                i13 += process(bArr[i10 + i14], bArr2, i12 + i13);
            }
            return i13;
        }
        throw new DataLengthException("Input buffer too short");
    }

    public void reset() {
        reset(true);
    }
}
