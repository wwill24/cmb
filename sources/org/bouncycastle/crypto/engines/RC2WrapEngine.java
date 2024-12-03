package org.bouncycastle.crypto.engines;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.util.Arrays;

public class RC2WrapEngine implements Wrapper {
    private static final byte[] IV2 = {74, -35, -94, 44, 121, -24, Framer.ENTER_FRAME_PREFIX, 5};
    byte[] digest = new byte[20];
    private CBCBlockCipher engine;
    private boolean forWrapping;
    private byte[] iv;
    private CipherParameters param;
    private ParametersWithIV paramPlusIV;
    Digest sha1 = DigestFactory.createSHA1();
    private SecureRandom sr;

    private byte[] calculateCMSKeyChecksum(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        this.sha1.update(bArr, 0, bArr.length);
        this.sha1.doFinal(this.digest, 0);
        System.arraycopy(this.digest, 0, bArr2, 0, 8);
        return bArr2;
    }

    private boolean checkCMSKeyChecksum(byte[] bArr, byte[] bArr2) {
        return Arrays.constantTimeAreEqual(calculateCMSKeyChecksum(bArr), bArr2);
    }

    public String getAlgorithmName() {
        return "RC2";
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        this.forWrapping = z10;
        this.engine = new CBCBlockCipher(new RC2Engine());
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.sr = parametersWithRandom.getRandom();
            cipherParameters = parametersWithRandom.getParameters();
        } else {
            this.sr = CryptoServicesRegistrar.getSecureRandom();
        }
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.paramPlusIV = parametersWithIV;
            this.iv = parametersWithIV.getIV();
            this.param = this.paramPlusIV.getParameters();
            if (this.forWrapping) {
                byte[] bArr = this.iv;
                if (bArr == null || bArr.length != 8) {
                    throw new IllegalArgumentException("IV is not 8 octets");
                }
                return;
            }
            throw new IllegalArgumentException("You should not supply an IV for unwrapping");
        }
        this.param = cipherParameters;
        if (this.forWrapping) {
            byte[] bArr2 = new byte[8];
            this.iv = bArr2;
            this.sr.nextBytes(bArr2);
            this.paramPlusIV = new ParametersWithIV(this.param, this.iv);
        }
    }

    public byte[] unwrap(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (this.forWrapping) {
            throw new IllegalStateException("Not set for unwrapping");
        } else if (bArr == null) {
            throw new InvalidCipherTextException("Null pointer as ciphertext");
        } else if (i11 % this.engine.getBlockSize() == 0) {
            this.engine.init(false, new ParametersWithIV(this.param, IV2));
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            for (int i12 = 0; i12 < i11 / this.engine.getBlockSize(); i12++) {
                int blockSize = this.engine.getBlockSize() * i12;
                this.engine.processBlock(bArr2, blockSize, bArr2, blockSize);
            }
            byte[] bArr3 = new byte[i11];
            int i13 = 0;
            while (i13 < i11) {
                int i14 = i13 + 1;
                bArr3[i13] = bArr2[i11 - i14];
                i13 = i14;
            }
            byte[] bArr4 = new byte[8];
            this.iv = bArr4;
            int i15 = i11 - 8;
            byte[] bArr5 = new byte[i15];
            System.arraycopy(bArr3, 0, bArr4, 0, 8);
            System.arraycopy(bArr3, 8, bArr5, 0, i15);
            ParametersWithIV parametersWithIV = new ParametersWithIV(this.param, this.iv);
            this.paramPlusIV = parametersWithIV;
            this.engine.init(false, parametersWithIV);
            byte[] bArr6 = new byte[i15];
            System.arraycopy(bArr5, 0, bArr6, 0, i15);
            for (int i16 = 0; i16 < i15 / this.engine.getBlockSize(); i16++) {
                int blockSize2 = this.engine.getBlockSize() * i16;
                this.engine.processBlock(bArr6, blockSize2, bArr6, blockSize2);
            }
            int i17 = i15 - 8;
            byte[] bArr7 = new byte[i17];
            byte[] bArr8 = new byte[8];
            System.arraycopy(bArr6, 0, bArr7, 0, i17);
            System.arraycopy(bArr6, i17, bArr8, 0, 8);
            if (checkCMSKeyChecksum(bArr7, bArr8)) {
                byte b10 = bArr7[0];
                if (i17 - ((b10 & 255) + 1) <= 7) {
                    byte[] bArr9 = new byte[b10];
                    System.arraycopy(bArr7, 1, bArr9, 0, b10);
                    return bArr9;
                }
                throw new InvalidCipherTextException("too many pad bytes (" + (i17 - ((bArr7[0] & 255) + 1)) + ")");
            }
            throw new InvalidCipherTextException("Checksum inside ciphertext is corrupted");
        } else {
            throw new InvalidCipherTextException("Ciphertext not multiple of " + this.engine.getBlockSize());
        }
    }

    public byte[] wrap(byte[] bArr, int i10, int i11) {
        if (this.forWrapping) {
            int i12 = i11 + 1;
            int i13 = i12 % 8;
            int i14 = i13 != 0 ? (8 - i13) + i12 : i12;
            byte[] bArr2 = new byte[i14];
            bArr2[0] = (byte) i11;
            System.arraycopy(bArr, i10, bArr2, 1, i11);
            int i15 = (i14 - i11) - 1;
            byte[] bArr3 = new byte[i15];
            if (i15 > 0) {
                this.sr.nextBytes(bArr3);
                System.arraycopy(bArr3, 0, bArr2, i12, i15);
            }
            byte[] calculateCMSKeyChecksum = calculateCMSKeyChecksum(bArr2);
            int length = calculateCMSKeyChecksum.length + i14;
            byte[] bArr4 = new byte[length];
            System.arraycopy(bArr2, 0, bArr4, 0, i14);
            System.arraycopy(calculateCMSKeyChecksum, 0, bArr4, i14, calculateCMSKeyChecksum.length);
            byte[] bArr5 = new byte[length];
            System.arraycopy(bArr4, 0, bArr5, 0, length);
            int blockSize = length / this.engine.getBlockSize();
            if (length % this.engine.getBlockSize() == 0) {
                this.engine.init(true, this.paramPlusIV);
                for (int i16 = 0; i16 < blockSize; i16++) {
                    int blockSize2 = this.engine.getBlockSize() * i16;
                    this.engine.processBlock(bArr5, blockSize2, bArr5, blockSize2);
                }
                byte[] bArr6 = this.iv;
                int length2 = bArr6.length + length;
                byte[] bArr7 = new byte[length2];
                System.arraycopy(bArr6, 0, bArr7, 0, bArr6.length);
                System.arraycopy(bArr5, 0, bArr7, this.iv.length, length);
                byte[] bArr8 = new byte[length2];
                int i17 = 0;
                while (i17 < length2) {
                    int i18 = i17 + 1;
                    bArr8[i17] = bArr7[length2 - i18];
                    i17 = i18;
                }
                this.engine.init(true, new ParametersWithIV(this.param, IV2));
                for (int i19 = 0; i19 < blockSize + 1; i19++) {
                    int blockSize3 = this.engine.getBlockSize() * i19;
                    this.engine.processBlock(bArr8, blockSize3, bArr8, blockSize3);
                }
                return bArr8;
            }
            throw new IllegalStateException("Not multiple of block length");
        }
        throw new IllegalStateException("Not initialized for wrapping");
    }
}
