package org.bouncycastle.crypto.signers;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSABlindingParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.Arrays;

public class PSSSigner implements Signer {
    public static final byte TRAILER_IMPLICIT = -68;
    private byte[] block;
    private AsymmetricBlockCipher cipher;
    private Digest contentDigest;
    private int emBits;
    private int hLen;
    private byte[] mDash;
    private Digest mgfDigest;
    private int mgfhLen;
    private SecureRandom random;
    private int sLen;
    private boolean sSet;
    private byte[] salt;
    private byte trailer;

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, int i10) {
        this(asymmetricBlockCipher, digest, i10, (byte) TRAILER_IMPLICIT);
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, int i10, byte b10) {
        this(asymmetricBlockCipher, digest, digest, i10, b10);
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, int i10) {
        this(asymmetricBlockCipher, digest, digest2, i10, (byte) TRAILER_IMPLICIT);
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, int i10, byte b10) {
        this.cipher = asymmetricBlockCipher;
        this.contentDigest = digest;
        this.mgfDigest = digest2;
        this.hLen = digest.getDigestSize();
        this.mgfhLen = digest2.getDigestSize();
        this.sSet = false;
        this.sLen = i10;
        this.salt = new byte[i10];
        this.mDash = new byte[(i10 + 8 + this.hLen)];
        this.trailer = b10;
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, byte[] bArr) {
        this(asymmetricBlockCipher, digest, digest2, bArr, (byte) TRAILER_IMPLICIT);
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, byte[] bArr, byte b10) {
        this.cipher = asymmetricBlockCipher;
        this.contentDigest = digest;
        this.mgfDigest = digest2;
        this.hLen = digest.getDigestSize();
        this.mgfhLen = digest2.getDigestSize();
        this.sSet = true;
        int length = bArr.length;
        this.sLen = length;
        this.salt = bArr;
        this.mDash = new byte[(length + 8 + this.hLen)];
        this.trailer = b10;
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, byte[] bArr) {
        this(asymmetricBlockCipher, digest, digest, bArr, (byte) TRAILER_IMPLICIT);
    }

    private void ItoOSP(int i10, byte[] bArr) {
        bArr[0] = (byte) (i10 >>> 24);
        bArr[1] = (byte) (i10 >>> 16);
        bArr[2] = (byte) (i10 >>> 8);
        bArr[3] = (byte) (i10 >>> 0);
    }

    private void clearBlock(byte[] bArr) {
        for (int i10 = 0; i10 != bArr.length; i10++) {
            bArr[i10] = 0;
        }
    }

    private byte[] maskGenerator(byte[] bArr, int i10, int i11, int i12) {
        Digest digest = this.mgfDigest;
        if (!(digest instanceof Xof)) {
            return maskGeneratorFunction1(bArr, i10, i11, i12);
        }
        byte[] bArr2 = new byte[i12];
        digest.update(bArr, i10, i11);
        ((Xof) this.mgfDigest).doFinal(bArr2, 0, i12);
        return bArr2;
    }

    private byte[] maskGeneratorFunction1(byte[] bArr, int i10, int i11, int i12) {
        int i13;
        byte[] bArr2 = new byte[i12];
        byte[] bArr3 = new byte[this.mgfhLen];
        byte[] bArr4 = new byte[4];
        this.mgfDigest.reset();
        int i14 = 0;
        while (true) {
            i13 = this.mgfhLen;
            if (i14 >= i12 / i13) {
                break;
            }
            ItoOSP(i14, bArr4);
            this.mgfDigest.update(bArr, i10, i11);
            this.mgfDigest.update(bArr4, 0, 4);
            this.mgfDigest.doFinal(bArr3, 0);
            int i15 = this.mgfhLen;
            System.arraycopy(bArr3, 0, bArr2, i14 * i15, i15);
            i14++;
        }
        if (i13 * i14 < i12) {
            ItoOSP(i14, bArr4);
            this.mgfDigest.update(bArr, i10, i11);
            this.mgfDigest.update(bArr4, 0, 4);
            this.mgfDigest.doFinal(bArr3, 0);
            int i16 = this.mgfhLen;
            System.arraycopy(bArr3, 0, bArr2, i14 * i16, i12 - (i14 * i16));
        }
        return bArr2;
    }

    public byte[] generateSignature() throws CryptoException, DataLengthException {
        Digest digest = this.contentDigest;
        byte[] bArr = this.mDash;
        digest.doFinal(bArr, (bArr.length - this.hLen) - this.sLen);
        if (this.sLen != 0) {
            if (!this.sSet) {
                this.random.nextBytes(this.salt);
            }
            byte[] bArr2 = this.salt;
            byte[] bArr3 = this.mDash;
            int length = bArr3.length;
            int i10 = this.sLen;
            System.arraycopy(bArr2, 0, bArr3, length - i10, i10);
        }
        int i11 = this.hLen;
        byte[] bArr4 = new byte[i11];
        Digest digest2 = this.contentDigest;
        byte[] bArr5 = this.mDash;
        digest2.update(bArr5, 0, bArr5.length);
        this.contentDigest.doFinal(bArr4, 0);
        byte[] bArr6 = this.block;
        int length2 = bArr6.length;
        int i12 = this.sLen;
        int i13 = this.hLen;
        bArr6[(((length2 - i12) - 1) - i13) - 1] = 1;
        System.arraycopy(this.salt, 0, bArr6, ((bArr6.length - i12) - i13) - 1, i12);
        byte[] maskGenerator = maskGenerator(bArr4, 0, i11, (this.block.length - this.hLen) - 1);
        for (int i14 = 0; i14 != maskGenerator.length; i14++) {
            byte[] bArr7 = this.block;
            bArr7[i14] = (byte) (bArr7[i14] ^ maskGenerator[i14]);
        }
        byte[] bArr8 = this.block;
        int length3 = bArr8.length;
        int i15 = this.hLen;
        System.arraycopy(bArr4, 0, bArr8, (length3 - i15) - 1, i15);
        byte[] bArr9 = this.block;
        bArr9[0] = (byte) ((255 >>> ((bArr9.length * 8) - this.emBits)) & bArr9[0]);
        bArr9[bArr9.length - 1] = this.trailer;
        byte[] processBlock = this.cipher.processBlock(bArr9, 0, bArr9.length);
        clearBlock(this.block);
        return processBlock;
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        CipherParameters cipherParameters2;
        RSAKeyParameters rSAKeyParameters;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            cipherParameters2 = parametersWithRandom.getParameters();
            this.random = parametersWithRandom.getRandom();
        } else {
            if (z10) {
                this.random = CryptoServicesRegistrar.getSecureRandom();
            }
            cipherParameters2 = cipherParameters;
        }
        if (cipherParameters2 instanceof RSABlindingParameters) {
            rSAKeyParameters = ((RSABlindingParameters) cipherParameters2).getPublicKey();
            this.cipher.init(z10, cipherParameters);
        } else {
            rSAKeyParameters = (RSAKeyParameters) cipherParameters2;
            this.cipher.init(z10, cipherParameters2);
        }
        int bitLength = rSAKeyParameters.getModulus().bitLength() - 1;
        this.emBits = bitLength;
        if (bitLength >= (this.hLen * 8) + (this.sLen * 8) + 9) {
            this.block = new byte[((bitLength + 7) / 8)];
            reset();
            return;
        }
        throw new IllegalArgumentException("key too small for specified hash and salt lengths");
    }

    public void reset() {
        this.contentDigest.reset();
    }

    public void update(byte b10) {
        this.contentDigest.update(b10);
    }

    public void update(byte[] bArr, int i10, int i11) {
        this.contentDigest.update(bArr, i10, i11);
    }

    public boolean verifySignature(byte[] bArr) {
        Digest digest = this.contentDigest;
        byte[] bArr2 = this.mDash;
        digest.doFinal(bArr2, (bArr2.length - this.hLen) - this.sLen);
        try {
            byte[] processBlock = this.cipher.processBlock(bArr, 0, bArr.length);
            byte[] bArr3 = this.block;
            Arrays.fill(bArr3, 0, bArr3.length - processBlock.length, (byte) 0);
            byte[] bArr4 = this.block;
            System.arraycopy(processBlock, 0, bArr4, bArr4.length - processBlock.length, processBlock.length);
            byte[] bArr5 = this.block;
            int length = 255 >>> ((bArr5.length * 8) - this.emBits);
            byte b10 = bArr5[0];
            if ((b10 & 255) == (b10 & length) && bArr5[bArr5.length - 1] == this.trailer) {
                int length2 = bArr5.length;
                int i10 = this.hLen;
                byte[] maskGenerator = maskGenerator(bArr5, (length2 - i10) - 1, i10, (bArr5.length - i10) - 1);
                for (int i11 = 0; i11 != maskGenerator.length; i11++) {
                    byte[] bArr6 = this.block;
                    bArr6[i11] = (byte) (bArr6[i11] ^ maskGenerator[i11]);
                }
                byte[] bArr7 = this.block;
                bArr7[0] = (byte) (length & bArr7[0]);
                int i12 = 0;
                while (true) {
                    byte[] bArr8 = this.block;
                    int length3 = bArr8.length;
                    int i13 = this.hLen;
                    int i14 = this.sLen;
                    if (i12 != ((length3 - i13) - i14) - 2) {
                        if (bArr8[i12] != 0) {
                            clearBlock(bArr8);
                            return false;
                        }
                        i12++;
                    } else if (bArr8[((bArr8.length - i13) - i14) - 2] != 1) {
                        clearBlock(bArr8);
                        return false;
                    } else {
                        if (this.sSet) {
                            byte[] bArr9 = this.salt;
                            byte[] bArr10 = this.mDash;
                            System.arraycopy(bArr9, 0, bArr10, bArr10.length - i14, i14);
                        } else {
                            byte[] bArr11 = this.mDash;
                            System.arraycopy(bArr8, ((bArr8.length - i14) - i13) - 1, bArr11, bArr11.length - i14, i14);
                        }
                        Digest digest2 = this.contentDigest;
                        byte[] bArr12 = this.mDash;
                        digest2.update(bArr12, 0, bArr12.length);
                        Digest digest3 = this.contentDigest;
                        byte[] bArr13 = this.mDash;
                        digest3.doFinal(bArr13, bArr13.length - this.hLen);
                        int length4 = this.block.length;
                        int i15 = this.hLen;
                        int i16 = (length4 - i15) - 1;
                        int length5 = this.mDash.length - i15;
                        while (true) {
                            byte[] bArr14 = this.mDash;
                            if (length5 == bArr14.length) {
                                clearBlock(bArr14);
                                clearBlock(this.block);
                                return true;
                            } else if ((this.block[i16] ^ bArr14[length5]) != 0) {
                                clearBlock(bArr14);
                                clearBlock(this.block);
                                return false;
                            } else {
                                i16++;
                                length5++;
                            }
                        }
                    }
                }
            } else {
                clearBlock(bArr5);
                return false;
            }
        } catch (Exception unused) {
        }
    }
}
