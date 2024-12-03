package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class G3413CTRBlockCipher extends StreamBlockCipher {
    private byte[] CTR;
    private byte[] IV;
    private final int blockSize;
    private byte[] buf;
    private int byteCount;
    private final BlockCipher cipher;
    private boolean initialized;

    /* renamed from: s  reason: collision with root package name */
    private final int f41489s;

    public G3413CTRBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, blockCipher.getBlockSize() * 8);
    }

    public G3413CTRBlockCipher(BlockCipher blockCipher, int i10) {
        super(blockCipher);
        this.byteCount = 0;
        if (i10 < 0 || i10 > blockCipher.getBlockSize() * 8) {
            throw new IllegalArgumentException("Parameter bitBlockSize must be in range 0 < bitBlockSize <= " + (blockCipher.getBlockSize() * 8));
        }
        this.cipher = blockCipher;
        int blockSize2 = blockCipher.getBlockSize();
        this.blockSize = blockSize2;
        this.f41489s = i10 / 8;
        this.CTR = new byte[blockSize2];
    }

    private byte[] generateBuf() {
        byte[] bArr = this.CTR;
        byte[] bArr2 = new byte[bArr.length];
        this.cipher.processBlock(bArr, 0, bArr2, 0);
        return GOST3413CipherUtil.MSB(bArr2, this.f41489s);
    }

    private void generateCRT() {
        byte[] bArr = this.CTR;
        int length = bArr.length - 1;
        bArr[length] = (byte) (bArr[length] + 1);
    }

    private void initArrays() {
        int i10 = this.blockSize;
        this.IV = new byte[(i10 / 2)];
        this.CTR = new byte[i10];
        this.buf = new byte[this.f41489s];
    }

    /* access modifiers changed from: protected */
    public byte calculateByte(byte b10) {
        if (this.byteCount == 0) {
            this.buf = generateBuf();
        }
        byte[] bArr = this.buf;
        int i10 = this.byteCount;
        byte b11 = (byte) (b10 ^ bArr[i10]);
        int i11 = i10 + 1;
        this.byteCount = i11;
        if (i11 == this.f41489s) {
            this.byteCount = 0;
            generateCRT();
        }
        return b11;
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/GCTR";
    }

    public int getBlockSize() {
        return this.f41489s;
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        BlockCipher blockCipher;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            initArrays();
            byte[] clone = Arrays.clone(parametersWithIV.getIV());
            this.IV = clone;
            if (clone.length == this.blockSize / 2) {
                System.arraycopy(clone, 0, this.CTR, 0, clone.length);
                for (int length = this.IV.length; length < this.blockSize; length++) {
                    this.CTR[length] = 0;
                }
                if (parametersWithIV.getParameters() != null) {
                    blockCipher = this.cipher;
                    cipherParameters = parametersWithIV.getParameters();
                }
                this.initialized = true;
            }
            throw new IllegalArgumentException("Parameter IV length must be == blockSize/2");
        }
        initArrays();
        if (cipherParameters != null) {
            blockCipher = this.cipher;
        }
        this.initialized = true;
        blockCipher.init(true, cipherParameters);
        this.initialized = true;
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) throws DataLengthException, IllegalStateException {
        processBytes(bArr, i10, this.f41489s, bArr2, i11);
        return this.f41489s;
    }

    public void reset() {
        if (this.initialized) {
            byte[] bArr = this.IV;
            System.arraycopy(bArr, 0, this.CTR, 0, bArr.length);
            for (int length = this.IV.length; length < this.blockSize; length++) {
                this.CTR[length] = 0;
            }
            this.byteCount = 0;
            this.cipher.reset();
        }
    }
}
