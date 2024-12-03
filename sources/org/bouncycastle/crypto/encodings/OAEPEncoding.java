package org.bouncycastle.crypto.encodings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.util.Arrays;

public class OAEPEncoding implements AsymmetricBlockCipher {
    private byte[] defHash;
    private AsymmetricBlockCipher engine;
    private boolean forEncryption;
    private Digest mgf1Hash;
    private SecureRandom random;

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this(asymmetricBlockCipher, DigestFactory.createSHA1(), (byte[]) null);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest) {
        this(asymmetricBlockCipher, digest, (byte[]) null);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, byte[] bArr) {
        this.engine = asymmetricBlockCipher;
        this.mgf1Hash = digest2;
        this.defHash = new byte[digest.getDigestSize()];
        digest.reset();
        if (bArr != null) {
            digest.update(bArr, 0, bArr.length);
        }
        digest.doFinal(this.defHash, 0);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, byte[] bArr) {
        this(asymmetricBlockCipher, digest, digest, bArr);
    }

    private void ItoOSP(int i10, byte[] bArr) {
        bArr[0] = (byte) (i10 >>> 24);
        bArr[1] = (byte) (i10 >>> 16);
        bArr[2] = (byte) (i10 >>> 8);
        bArr[3] = (byte) (i10 >>> 0);
    }

    private byte[] maskGeneratorFunction1(byte[] bArr, int i10, int i11, int i12) {
        byte[] bArr2 = new byte[i12];
        int digestSize = this.mgf1Hash.getDigestSize();
        byte[] bArr3 = new byte[digestSize];
        byte[] bArr4 = new byte[4];
        this.mgf1Hash.reset();
        int i13 = 0;
        while (i13 < i12 / digestSize) {
            ItoOSP(i13, bArr4);
            this.mgf1Hash.update(bArr, i10, i11);
            this.mgf1Hash.update(bArr4, 0, 4);
            this.mgf1Hash.doFinal(bArr3, 0);
            System.arraycopy(bArr3, 0, bArr2, i13 * digestSize, digestSize);
            i13++;
        }
        int i14 = digestSize * i13;
        if (i14 < i12) {
            ItoOSP(i13, bArr4);
            this.mgf1Hash.update(bArr, i10, i11);
            this.mgf1Hash.update(bArr4, 0, 4);
            this.mgf1Hash.doFinal(bArr3, 0);
            System.arraycopy(bArr3, 0, bArr2, i14, i12 - i14);
        }
        return bArr2;
    }

    public byte[] decodeBlock(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        byte[] bArr2;
        byte[] bArr3;
        byte[] processBlock = this.engine.processBlock(bArr, i10, i11);
        int outputBlockSize = this.engine.getOutputBlockSize();
        byte[] bArr4 = new byte[outputBlockSize];
        boolean z10 = outputBlockSize < (this.defHash.length * 2) + 1;
        if (processBlock.length <= outputBlockSize) {
            System.arraycopy(processBlock, 0, bArr4, outputBlockSize - processBlock.length, processBlock.length);
        } else {
            System.arraycopy(processBlock, 0, bArr4, 0, outputBlockSize);
            z10 = true;
        }
        byte[] bArr5 = this.defHash;
        byte[] maskGeneratorFunction1 = maskGeneratorFunction1(bArr4, bArr5.length, outputBlockSize - bArr5.length, bArr5.length);
        int i12 = 0;
        while (true) {
            bArr2 = this.defHash;
            if (i12 == bArr2.length) {
                break;
            }
            bArr4[i12] = (byte) (bArr4[i12] ^ maskGeneratorFunction1[i12]);
            i12++;
        }
        byte[] maskGeneratorFunction12 = maskGeneratorFunction1(bArr4, 0, bArr2.length, outputBlockSize - bArr2.length);
        for (int length = this.defHash.length; length != outputBlockSize; length++) {
            bArr4[length] = (byte) (bArr4[length] ^ maskGeneratorFunction12[length - this.defHash.length]);
        }
        int i13 = 0;
        boolean z11 = false;
        while (true) {
            bArr3 = this.defHash;
            if (i13 == bArr3.length) {
                break;
            }
            if (bArr3[i13] != bArr4[bArr3.length + i13]) {
                z11 = true;
            }
            i13++;
        }
        int i14 = outputBlockSize;
        for (int length2 = bArr3.length * 2; length2 != outputBlockSize; length2++) {
            if ((bArr4[length2] != 0) && (i14 == outputBlockSize)) {
                i14 = length2;
            }
        }
        boolean z12 = i14 > outputBlockSize + -1;
        boolean z13 = bArr4[i14] != 1;
        int i15 = i14 + 1;
        if (!(z12 | z13) && !(z10 | z11)) {
            int i16 = outputBlockSize - i15;
            byte[] bArr6 = new byte[i16];
            System.arraycopy(bArr4, i15, bArr6, 0, i16);
            Arrays.fill(bArr4, (byte) 0);
            return bArr6;
        }
        Arrays.fill(bArr4, (byte) 0);
        throw new InvalidCipherTextException("data wrong");
    }

    public byte[] encodeBlock(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (i11 <= getInputBlockSize()) {
            int inputBlockSize = getInputBlockSize() + 1 + (this.defHash.length * 2);
            byte[] bArr2 = new byte[inputBlockSize];
            int i12 = inputBlockSize - i11;
            System.arraycopy(bArr, i10, bArr2, i12, i11);
            bArr2[i12 - 1] = 1;
            byte[] bArr3 = this.defHash;
            System.arraycopy(bArr3, 0, bArr2, bArr3.length, bArr3.length);
            int length = this.defHash.length;
            byte[] bArr4 = new byte[length];
            this.random.nextBytes(bArr4);
            byte[] maskGeneratorFunction1 = maskGeneratorFunction1(bArr4, 0, length, inputBlockSize - this.defHash.length);
            for (int length2 = this.defHash.length; length2 != inputBlockSize; length2++) {
                bArr2[length2] = (byte) (bArr2[length2] ^ maskGeneratorFunction1[length2 - this.defHash.length]);
            }
            System.arraycopy(bArr4, 0, bArr2, 0, this.defHash.length);
            byte[] bArr5 = this.defHash;
            byte[] maskGeneratorFunction12 = maskGeneratorFunction1(bArr2, bArr5.length, inputBlockSize - bArr5.length, bArr5.length);
            for (int i13 = 0; i13 != this.defHash.length; i13++) {
                bArr2[i13] = (byte) (bArr2[i13] ^ maskGeneratorFunction12[i13]);
            }
            return this.engine.processBlock(bArr2, 0, inputBlockSize);
        }
        throw new DataLengthException("input data too long");
    }

    public int getInputBlockSize() {
        int inputBlockSize = this.engine.getInputBlockSize();
        return this.forEncryption ? (inputBlockSize - 1) - (this.defHash.length * 2) : inputBlockSize;
    }

    public int getOutputBlockSize() {
        int outputBlockSize = this.engine.getOutputBlockSize();
        return this.forEncryption ? outputBlockSize : (outputBlockSize - 1) - (this.defHash.length * 2);
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        this.random = cipherParameters instanceof ParametersWithRandom ? ((ParametersWithRandom) cipherParameters).getRandom() : CryptoServicesRegistrar.getSecureRandom();
        this.engine.init(z10, cipherParameters);
        this.forEncryption = z10;
    }

    public byte[] processBlock(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        return this.forEncryption ? encodeBlock(bArr, i10, i11) : decodeBlock(bArr, i10, i11);
    }
}
