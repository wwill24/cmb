package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class KCTRBlockCipher extends StreamBlockCipher {
    private int byteCount;
    private BlockCipher engine;
    private boolean initialised;
    private byte[] iv;
    private byte[] ofbOutV;
    private byte[] ofbV;

    public KCTRBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.engine = blockCipher;
        this.iv = new byte[blockCipher.getBlockSize()];
        this.ofbV = new byte[blockCipher.getBlockSize()];
        this.ofbOutV = new byte[blockCipher.getBlockSize()];
    }

    private void checkCounter() {
    }

    private void incrementCounterAt(int i10) {
        while (true) {
            byte[] bArr = this.ofbV;
            if (i10 < bArr.length) {
                int i11 = i10 + 1;
                byte b10 = (byte) (bArr[i10] + 1);
                bArr[i10] = b10;
                if (b10 == 0) {
                    i10 = i11;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public byte calculateByte(byte b10) {
        int i10 = this.byteCount;
        if (i10 == 0) {
            incrementCounterAt(0);
            checkCounter();
            this.engine.processBlock(this.ofbV, 0, this.ofbOutV, 0);
            byte[] bArr = this.ofbOutV;
            int i11 = this.byteCount;
            this.byteCount = i11 + 1;
            return (byte) (b10 ^ bArr[i11]);
        }
        byte[] bArr2 = this.ofbOutV;
        int i12 = i10 + 1;
        this.byteCount = i12;
        byte b11 = (byte) (b10 ^ bArr2[i10]);
        if (i12 == this.ofbV.length) {
            this.byteCount = 0;
        }
        return b11;
    }

    public String getAlgorithmName() {
        return this.engine.getAlgorithmName() + "/KCTR";
    }

    public int getBlockSize() {
        return this.engine.getBlockSize();
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.initialised = true;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv2 = parametersWithIV.getIV();
            byte[] bArr = this.iv;
            Arrays.fill(bArr, (byte) 0);
            System.arraycopy(iv2, 0, this.iv, bArr.length - iv2.length, iv2.length);
            CipherParameters parameters = parametersWithIV.getParameters();
            if (parameters != null) {
                this.engine.init(true, parameters);
            }
            reset();
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed");
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        if (bArr.length - i10 < getBlockSize()) {
            throw new DataLengthException("input buffer too short");
        } else if (bArr2.length - i11 >= getBlockSize()) {
            processBytes(bArr, i10, getBlockSize(), bArr2, i11);
            return getBlockSize();
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
        if (this.initialised) {
            this.engine.processBlock(this.iv, 0, this.ofbV, 0);
        }
        this.engine.reset();
        this.byteCount = 0;
    }
}
