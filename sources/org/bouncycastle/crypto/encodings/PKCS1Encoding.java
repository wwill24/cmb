package org.bouncycastle.crypto.encodings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Properties;

public class PKCS1Encoding implements AsymmetricBlockCipher {
    private static final int HEADER_LENGTH = 10;
    public static final String NOT_STRICT_LENGTH_ENABLED_PROPERTY = "org.bouncycastle.pkcs1.not_strict";
    public static final String STRICT_LENGTH_ENABLED_PROPERTY = "org.bouncycastle.pkcs1.strict";
    private byte[] blockBuffer;
    private AsymmetricBlockCipher engine;
    private byte[] fallback = null;
    private boolean forEncryption;
    private boolean forPrivateKey;
    private int pLen = -1;
    private SecureRandom random;
    private boolean useStrictLength;

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.engine = asymmetricBlockCipher;
        this.useStrictLength = useStrict();
    }

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher, int i10) {
        this.engine = asymmetricBlockCipher;
        this.useStrictLength = useStrict();
        this.pLen = i10;
    }

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher, byte[] bArr) {
        this.engine = asymmetricBlockCipher;
        this.useStrictLength = useStrict();
        this.fallback = bArr;
        this.pLen = bArr.length;
    }

    private static int checkPkcs1Encoding(byte[] bArr, int i10) {
        byte b10 = 0 | (bArr[0] ^ 2);
        int i11 = i10 + 1;
        int length = bArr.length - i11;
        for (int i12 = 1; i12 < length; i12++) {
            byte b11 = bArr[i12];
            byte b12 = b11 | (b11 >> 1);
            byte b13 = b12 | (b12 >> 2);
            b10 |= ((b13 | (b13 >> 4)) & 1) - 1;
        }
        byte b14 = bArr[bArr.length - i11] | b10;
        byte b15 = b14 | (b14 >> 1);
        byte b16 = b15 | (b15 >> 2);
        return ~(((b16 | (b16 >> 4)) & 1) - 1);
    }

    private byte[] decodeBlock(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (this.pLen != -1) {
            return decodeBlockOrRandom(bArr, i10, i11);
        }
        byte[] processBlock = this.engine.processBlock(bArr, i10, i11);
        boolean z10 = true;
        boolean z11 = this.useStrictLength & (processBlock.length != this.engine.getOutputBlockSize());
        if (processBlock.length < getOutputBlockSize()) {
            processBlock = this.blockBuffer;
        }
        byte b10 = processBlock[0];
        boolean z12 = !this.forPrivateKey ? b10 != 1 : b10 != 2;
        int findStart = findStart(b10, processBlock) + 1;
        if (findStart >= 10) {
            z10 = false;
        }
        if (z12 || z10) {
            Arrays.fill(processBlock, (byte) 0);
            throw new InvalidCipherTextException("block incorrect");
        } else if (!z11) {
            int length = processBlock.length - findStart;
            byte[] bArr2 = new byte[length];
            System.arraycopy(processBlock, findStart, bArr2, 0, length);
            return bArr2;
        } else {
            Arrays.fill(processBlock, (byte) 0);
            throw new InvalidCipherTextException("block incorrect size");
        }
    }

    private byte[] decodeBlockOrRandom(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (this.forPrivateKey) {
            byte[] processBlock = this.engine.processBlock(bArr, i10, i11);
            byte[] bArr2 = this.fallback;
            if (bArr2 == null) {
                bArr2 = new byte[this.pLen];
                this.random.nextBytes(bArr2);
            }
            if (this.useStrictLength && (processBlock.length != this.engine.getOutputBlockSize())) {
                processBlock = this.blockBuffer;
            }
            int checkPkcs1Encoding = checkPkcs1Encoding(processBlock, this.pLen);
            byte[] bArr3 = new byte[this.pLen];
            int i12 = 0;
            while (true) {
                int i13 = this.pLen;
                if (i12 < i13) {
                    bArr3[i12] = (byte) ((processBlock[(processBlock.length - i13) + i12] & (~checkPkcs1Encoding)) | (bArr2[i12] & checkPkcs1Encoding));
                    i12++;
                } else {
                    Arrays.fill(processBlock, (byte) 0);
                    return bArr3;
                }
            }
        } else {
            throw new InvalidCipherTextException("sorry, this method is only for decryption, not for signing");
        }
    }

    private byte[] encodeBlock(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (i11 <= getInputBlockSize()) {
            int inputBlockSize = this.engine.getInputBlockSize();
            byte[] bArr2 = new byte[inputBlockSize];
            if (this.forPrivateKey) {
                bArr2[0] = 1;
                for (int i12 = 1; i12 != (inputBlockSize - i11) - 1; i12++) {
                    bArr2[i12] = -1;
                }
            } else {
                this.random.nextBytes(bArr2);
                bArr2[0] = 2;
                for (int i13 = 1; i13 != (inputBlockSize - i11) - 1; i13++) {
                    while (bArr2[i13] == 0) {
                        bArr2[i13] = (byte) this.random.nextInt();
                    }
                }
            }
            int i14 = inputBlockSize - i11;
            bArr2[i14 - 1] = 0;
            System.arraycopy(bArr, i10, bArr2, i14, i11);
            return this.engine.processBlock(bArr2, 0, inputBlockSize);
        }
        throw new IllegalArgumentException("input data too large");
    }

    private int findStart(byte b10, byte[] bArr) throws InvalidCipherTextException {
        int i10 = -1;
        boolean z10 = false;
        for (int i11 = 1; i11 != bArr.length; i11++) {
            byte b11 = bArr[i11];
            if ((b11 == 0) && (i10 < 0)) {
                i10 = i11;
            }
            z10 |= (b11 != -1) & (b10 == 1) & (i10 < 0);
        }
        if (z10) {
            return -1;
        }
        return i10;
    }

    private boolean useStrict() {
        if (Properties.isOverrideSetTo(NOT_STRICT_LENGTH_ENABLED_PROPERTY, true)) {
            return false;
        }
        return !Properties.isOverrideSetTo(STRICT_LENGTH_ENABLED_PROPERTY, false);
    }

    public int getInputBlockSize() {
        int inputBlockSize = this.engine.getInputBlockSize();
        return this.forEncryption ? inputBlockSize - 10 : inputBlockSize;
    }

    public int getOutputBlockSize() {
        int outputBlockSize = this.engine.getOutputBlockSize();
        return this.forEncryption ? outputBlockSize : outputBlockSize - 10;
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.random = parametersWithRandom.getRandom();
            asymmetricKeyParameter = (AsymmetricKeyParameter) parametersWithRandom.getParameters();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
            if (!asymmetricKeyParameter.isPrivate() && z10) {
                this.random = CryptoServicesRegistrar.getSecureRandom();
            }
        }
        this.engine.init(z10, cipherParameters);
        this.forPrivateKey = asymmetricKeyParameter.isPrivate();
        this.forEncryption = z10;
        this.blockBuffer = new byte[this.engine.getOutputBlockSize()];
        if (this.pLen > 0 && this.fallback == null && this.random == null) {
            throw new IllegalArgumentException("encoder requires random");
        }
    }

    public byte[] processBlock(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        return this.forEncryption ? encodeBlock(bArr, i10, i11) : decodeBlock(bArr, i10, i11);
    }
}
