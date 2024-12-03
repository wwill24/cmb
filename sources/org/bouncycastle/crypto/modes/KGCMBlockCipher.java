package org.bouncycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.modes.kgcm.KGCMMultiplier;
import org.bouncycastle.crypto.modes.kgcm.Tables16kKGCMMultiplier_512;
import org.bouncycastle.crypto.modes.kgcm.Tables4kKGCMMultiplier_128;
import org.bouncycastle.crypto.modes.kgcm.Tables8kKGCMMultiplier_256;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;
import org.jivesoftware.smack.datatypes.UInt32;

public class KGCMBlockCipher implements AEADBlockCipher {
    private static final int MIN_MAC_BITS = 64;
    private ExposedByteArrayOutputStream associatedText = new ExposedByteArrayOutputStream();

    /* renamed from: b  reason: collision with root package name */
    private long[] f41492b;
    private final int blockSize;
    private BufferedBlockCipher ctrEngine;
    private ExposedByteArrayOutputStream data = new ExposedByteArrayOutputStream();
    private BlockCipher engine;
    private boolean forEncryption;
    private byte[] initialAssociatedText;
    private byte[] iv;
    private byte[] macBlock;
    private int macSize;
    private KGCMMultiplier multiplier;

    private class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public ExposedByteArrayOutputStream() {
        }

        public byte[] getBuffer() {
            return this.buf;
        }
    }

    public KGCMBlockCipher(BlockCipher blockCipher) {
        this.engine = blockCipher;
        this.ctrEngine = new BufferedBlockCipher(new KCTRBlockCipher(blockCipher));
        this.macSize = -1;
        int blockSize2 = this.engine.getBlockSize();
        this.blockSize = blockSize2;
        this.initialAssociatedText = new byte[blockSize2];
        this.iv = new byte[blockSize2];
        this.multiplier = createDefaultMultiplier(blockSize2);
        this.f41492b = new long[(blockSize2 >>> 3)];
        this.macBlock = null;
    }

    private void calculateMac(byte[] bArr, int i10, int i11, int i12) {
        int i13 = i10 + i11;
        while (i10 < i13) {
            xorWithInput(this.f41492b, bArr, i10);
            this.multiplier.multiplyH(this.f41492b);
            i10 += this.blockSize;
        }
        long j10 = (UInt32.MAX_VALUE_LONG & ((long) i11)) << 3;
        long[] jArr = this.f41492b;
        jArr[0] = ((((long) i12) & UInt32.MAX_VALUE_LONG) << 3) ^ jArr[0];
        int i14 = this.blockSize >>> 4;
        jArr[i14] = jArr[i14] ^ j10;
        byte[] longToLittleEndian = Pack.longToLittleEndian(jArr);
        this.macBlock = longToLittleEndian;
        this.engine.processBlock(longToLittleEndian, 0, longToLittleEndian, 0);
    }

    private static KGCMMultiplier createDefaultMultiplier(int i10) {
        if (i10 == 16) {
            return new Tables4kKGCMMultiplier_128();
        }
        if (i10 == 32) {
            return new Tables8kKGCMMultiplier_256();
        }
        if (i10 == 64) {
            return new Tables16kKGCMMultiplier_512();
        }
        throw new IllegalArgumentException("Only 128, 256, and 512 -bit block sizes supported");
    }

    private void processAAD(byte[] bArr, int i10, int i11) {
        int i12 = i11 + i10;
        while (i10 < i12) {
            xorWithInput(this.f41492b, bArr, i10);
            this.multiplier.multiplyH(this.f41492b);
            i10 += this.blockSize;
        }
    }

    private static void xorWithInput(long[] jArr, byte[] bArr, int i10) {
        for (int i11 = 0; i11 < jArr.length; i11++) {
            jArr[i11] = jArr[i11] ^ Pack.littleEndianToLong(bArr, i10);
            i10 += 8;
        }
    }

    public int doFinal(byte[] bArr, int i10) throws IllegalStateException, InvalidCipherTextException {
        int i11;
        int size = this.data.size();
        if (this.forEncryption || size >= this.macSize) {
            byte[] bArr2 = new byte[this.blockSize];
            this.engine.processBlock(bArr2, 0, bArr2, 0);
            long[] jArr = new long[(this.blockSize >>> 3)];
            Pack.littleEndianToLong(bArr2, 0, jArr);
            this.multiplier.init(jArr);
            Arrays.fill(bArr2, (byte) 0);
            Arrays.fill(jArr, 0);
            int size2 = this.associatedText.size();
            if (size2 > 0) {
                processAAD(this.associatedText.getBuffer(), 0, size2);
            }
            if (!this.forEncryption) {
                int i12 = size - this.macSize;
                if (bArr.length - i10 >= i12) {
                    calculateMac(this.data.getBuffer(), 0, i12, size2);
                    int processBytes = this.ctrEngine.processBytes(this.data.getBuffer(), 0, i12, bArr, i10);
                    i11 = processBytes + this.ctrEngine.doFinal(bArr, i10 + processBytes);
                } else {
                    throw new OutputLengthException("Output buffer too short");
                }
            } else if ((bArr.length - i10) - this.macSize >= size) {
                int processBytes2 = this.ctrEngine.processBytes(this.data.getBuffer(), 0, size, bArr, i10);
                i11 = processBytes2 + this.ctrEngine.doFinal(bArr, i10 + processBytes2);
                calculateMac(bArr, i10, size, size2);
            } else {
                throw new OutputLengthException("Output buffer too short");
            }
            byte[] bArr3 = this.macBlock;
            if (bArr3 == null) {
                throw new IllegalStateException("mac is not calculated");
            } else if (this.forEncryption) {
                System.arraycopy(bArr3, 0, bArr, i10 + i11, this.macSize);
                reset();
                return i11 + this.macSize;
            } else {
                byte[] bArr4 = new byte[this.macSize];
                byte[] buffer = this.data.getBuffer();
                int i13 = this.macSize;
                System.arraycopy(buffer, size - i13, bArr4, 0, i13);
                int i14 = this.macSize;
                byte[] bArr5 = new byte[i14];
                System.arraycopy(this.macBlock, 0, bArr5, 0, i14);
                if (Arrays.constantTimeAreEqual(bArr4, bArr5)) {
                    reset();
                    return i11;
                }
                throw new InvalidCipherTextException("mac verification failed");
            }
        } else {
            throw new InvalidCipherTextException("data too short");
        }
    }

    public String getAlgorithmName() {
        return this.engine.getAlgorithmName() + "/KGCM";
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
        return this.engine;
    }

    public int getUpdateOutputSize(int i10) {
        return 0;
    }

    public void init(boolean z10, CipherParameters cipherParameters) throws IllegalArgumentException {
        KeyParameter keyParameter;
        this.forEncryption = z10;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            byte[] nonce = aEADParameters.getNonce();
            byte[] bArr = this.iv;
            Arrays.fill(bArr, (byte) 0);
            System.arraycopy(nonce, 0, this.iv, bArr.length - nonce.length, nonce.length);
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            int macSize2 = aEADParameters.getMacSize();
            if (macSize2 < 64 || macSize2 > (this.blockSize << 3) || (macSize2 & 7) != 0) {
                throw new IllegalArgumentException("Invalid value for MAC size: " + macSize2);
            }
            this.macSize = macSize2 >>> 3;
            keyParameter = aEADParameters.getKey();
            byte[] bArr2 = this.initialAssociatedText;
            if (bArr2 != null) {
                processAADBytes(bArr2, 0, bArr2.length);
            }
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv2 = parametersWithIV.getIV();
            byte[] bArr3 = this.iv;
            Arrays.fill(bArr3, (byte) 0);
            System.arraycopy(iv2, 0, this.iv, bArr3.length - iv2.length, iv2.length);
            this.initialAssociatedText = null;
            this.macSize = this.blockSize;
            keyParameter = (KeyParameter) parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("Invalid parameter passed");
        }
        this.macBlock = new byte[this.blockSize];
        this.ctrEngine.init(true, new ParametersWithIV(keyParameter, this.iv));
        this.engine.init(true, keyParameter);
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
        throw new DataLengthException("input buffer too short");
    }

    public void reset() {
        Arrays.fill(this.f41492b, 0);
        this.engine.reset();
        this.data.reset();
        this.associatedText.reset();
        byte[] bArr = this.initialAssociatedText;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }
}
