package org.bouncycastle.crypto.engines;

import java.security.SecureRandom;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;

public class RFC3211WrapEngine implements Wrapper {
    private CBCBlockCipher engine;
    private boolean forWrapping;
    private ParametersWithIV param;
    private SecureRandom rand;

    public RFC3211WrapEngine(BlockCipher blockCipher) {
        this.engine = new CBCBlockCipher(blockCipher);
    }

    public String getAlgorithmName() {
        return this.engine.getUnderlyingCipher().getAlgorithmName() + "/RFC3211Wrap";
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        this.forWrapping = z10;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.rand = parametersWithRandom.getRandom();
            if (parametersWithRandom.getParameters() instanceof ParametersWithIV) {
                this.param = (ParametersWithIV) parametersWithRandom.getParameters();
                return;
            }
            throw new IllegalArgumentException("RFC3211Wrap requires an IV");
        }
        if (z10) {
            this.rand = CryptoServicesRegistrar.getSecureRandom();
        }
        if (cipherParameters instanceof ParametersWithIV) {
            this.param = (ParametersWithIV) cipherParameters;
            return;
        }
        throw new IllegalArgumentException("RFC3211Wrap requires an IV");
    }

    public byte[] unwrap(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (!this.forWrapping) {
            int blockSize = this.engine.getBlockSize();
            if (i11 >= blockSize * 2) {
                byte[] bArr2 = new byte[i11];
                byte[] bArr3 = new byte[blockSize];
                boolean z10 = false;
                System.arraycopy(bArr, i10, bArr2, 0, i11);
                System.arraycopy(bArr, i10, bArr3, 0, blockSize);
                this.engine.init(false, new ParametersWithIV(this.param.getParameters(), bArr3));
                for (int i12 = blockSize; i12 < i11; i12 += blockSize) {
                    this.engine.processBlock(bArr2, i12, bArr2, i12);
                }
                System.arraycopy(bArr2, i11 - blockSize, bArr3, 0, blockSize);
                this.engine.init(false, new ParametersWithIV(this.param.getParameters(), bArr3));
                this.engine.processBlock(bArr2, 0, bArr2, 0);
                this.engine.init(false, this.param);
                for (int i13 = 0; i13 < i11; i13 += blockSize) {
                    this.engine.processBlock(bArr2, i13, bArr2, i13);
                }
                byte b10 = bArr2[0];
                int i14 = i11 - 4;
                boolean z11 = (b10 & 255) > i14;
                byte[] bArr4 = z11 ? new byte[i14] : new byte[(b10 & 255)];
                System.arraycopy(bArr2, 4, bArr4, 0, bArr4.length);
                int i15 = 0;
                byte b11 = 0;
                while (i15 != 3) {
                    int i16 = i15 + 1;
                    b11 |= bArr2[i15 + 4] ^ ((byte) (~bArr2[i16]));
                    i15 = i16;
                }
                Arrays.clear(bArr2);
                if (b11 != 0) {
                    z10 = true;
                }
                if (!z11 && !z10) {
                    return bArr4;
                }
                throw new InvalidCipherTextException("wrapped key corrupted");
            }
            throw new InvalidCipherTextException("input too short");
        }
        throw new IllegalStateException("not set for unwrapping");
    }

    public byte[] wrap(byte[] bArr, int i10, int i11) {
        if (!this.forWrapping) {
            throw new IllegalStateException("not set for wrapping");
        } else if (i11 > 255 || i11 < 0) {
            throw new IllegalArgumentException("input must be from 0 to 255 bytes");
        } else {
            this.engine.init(true, this.param);
            int blockSize = this.engine.getBlockSize();
            int i12 = i11 + 4;
            int i13 = blockSize * 2;
            if (i12 >= i13) {
                i13 = i12 % blockSize == 0 ? i12 : ((i12 / blockSize) + 1) * blockSize;
            }
            byte[] bArr2 = new byte[i13];
            bArr2[0] = (byte) i11;
            System.arraycopy(bArr, i10, bArr2, 4, i11);
            int length = bArr2.length - i12;
            byte[] bArr3 = new byte[length];
            this.rand.nextBytes(bArr3);
            System.arraycopy(bArr3, 0, bArr2, i12, length);
            bArr2[1] = (byte) (~bArr2[4]);
            bArr2[2] = (byte) (~bArr2[5]);
            bArr2[3] = (byte) (~bArr2[6]);
            for (int i14 = 0; i14 < bArr2.length; i14 += blockSize) {
                this.engine.processBlock(bArr2, i14, bArr2, i14);
            }
            for (int i15 = 0; i15 < bArr2.length; i15 += blockSize) {
                this.engine.processBlock(bArr2, i15, bArr2, i15);
            }
            return bArr2;
        }
    }
}
