package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;

public class RFC3394WrapEngine implements Wrapper {
    private BlockCipher engine;
    private boolean forWrapping;
    private byte[] iv;
    private KeyParameter param;
    private boolean wrapCipherMode;

    public RFC3394WrapEngine(BlockCipher blockCipher) {
        this(blockCipher, false);
    }

    public RFC3394WrapEngine(BlockCipher blockCipher, boolean z10) {
        this.iv = new byte[]{-90, -90, -90, -90, -90, -90, -90, -90};
        this.engine = blockCipher;
        this.wrapCipherMode = !z10;
    }

    public String getAlgorithmName() {
        return this.engine.getAlgorithmName();
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        this.forWrapping = z10;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        if (cipherParameters instanceof KeyParameter) {
            this.param = (KeyParameter) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.iv = parametersWithIV.getIV();
            this.param = (KeyParameter) parametersWithIV.getParameters();
            if (this.iv.length != 8) {
                throw new IllegalArgumentException("IV not equal to 8");
            }
        }
    }

    public byte[] unwrap(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (!this.forWrapping) {
            int i12 = i11 / 8;
            if (i12 * 8 == i11) {
                byte[] bArr2 = this.iv;
                byte[] bArr3 = new byte[(i11 - bArr2.length)];
                byte[] bArr4 = new byte[bArr2.length];
                byte[] bArr5 = new byte[(bArr2.length + 8)];
                System.arraycopy(bArr, i10, bArr4, 0, bArr2.length);
                byte[] bArr6 = this.iv;
                System.arraycopy(bArr, i10 + bArr6.length, bArr3, 0, i11 - bArr6.length);
                this.engine.init(!this.wrapCipherMode, this.param);
                int i13 = i12 - 1;
                for (int i14 = 5; i14 >= 0; i14--) {
                    for (int i15 = i13; i15 >= 1; i15--) {
                        System.arraycopy(bArr4, 0, bArr5, 0, this.iv.length);
                        int i16 = (i15 - 1) * 8;
                        System.arraycopy(bArr3, i16, bArr5, this.iv.length, 8);
                        int i17 = (i13 * i14) + i15;
                        int i18 = 1;
                        while (i17 != 0) {
                            int length = this.iv.length - i18;
                            bArr5[length] = (byte) (((byte) i17) ^ bArr5[length]);
                            i17 >>>= 8;
                            i18++;
                        }
                        this.engine.processBlock(bArr5, 0, bArr5, 0);
                        System.arraycopy(bArr5, 0, bArr4, 0, 8);
                        System.arraycopy(bArr5, 8, bArr3, i16, 8);
                    }
                }
                if (Arrays.constantTimeAreEqual(bArr4, this.iv)) {
                    return bArr3;
                }
                throw new InvalidCipherTextException("checksum failed");
            }
            throw new InvalidCipherTextException("unwrap data must be a multiple of 8 bytes");
        }
        throw new IllegalStateException("not set for unwrapping");
    }

    public byte[] wrap(byte[] bArr, int i10, int i11) {
        if (this.forWrapping) {
            int i12 = i11 / 8;
            if (i12 * 8 == i11) {
                byte[] bArr2 = this.iv;
                byte[] bArr3 = new byte[(bArr2.length + i11)];
                byte[] bArr4 = new byte[(bArr2.length + 8)];
                System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
                System.arraycopy(bArr, i10, bArr3, this.iv.length, i11);
                this.engine.init(this.wrapCipherMode, this.param);
                for (int i13 = 0; i13 != 6; i13++) {
                    for (int i14 = 1; i14 <= i12; i14++) {
                        System.arraycopy(bArr3, 0, bArr4, 0, this.iv.length);
                        int i15 = i14 * 8;
                        System.arraycopy(bArr3, i15, bArr4, this.iv.length, 8);
                        this.engine.processBlock(bArr4, 0, bArr4, 0);
                        int i16 = (i12 * i13) + i14;
                        int i17 = 1;
                        while (i16 != 0) {
                            int length = this.iv.length - i17;
                            bArr4[length] = (byte) (((byte) i16) ^ bArr4[length]);
                            i16 >>>= 8;
                            i17++;
                        }
                        System.arraycopy(bArr4, 0, bArr3, 0, 8);
                        System.arraycopy(bArr4, 8, bArr3, i15, 8);
                    }
                }
                return bArr3;
            }
            throw new DataLengthException("wrap data must be a multiple of 8 bytes");
        }
        throw new IllegalStateException("not set for wrapping");
    }
}
