package org.bouncycastle.crypto.signers;

import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.SignerWithRecovery;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.Arrays;

public class ISO9796d2Signer implements SignerWithRecovery {
    public static final int TRAILER_IMPLICIT = 188;
    public static final int TRAILER_RIPEMD128 = 13004;
    public static final int TRAILER_RIPEMD160 = 12748;
    public static final int TRAILER_SHA1 = 13260;
    public static final int TRAILER_SHA256 = 13516;
    public static final int TRAILER_SHA384 = 14028;
    public static final int TRAILER_SHA512 = 13772;
    public static final int TRAILER_WHIRLPOOL = 14284;
    private byte[] block;
    private AsymmetricBlockCipher cipher;
    private Digest digest;
    private boolean fullMessage;
    private int keyBits;
    private byte[] mBuf;
    private int messageLength;
    private byte[] preBlock;
    private byte[] preSig;
    private byte[] recoveredMessage;
    private int trailer;

    public ISO9796d2Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest2) {
        this(asymmetricBlockCipher, digest2, false);
    }

    public ISO9796d2Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest2, boolean z10) {
        int intValue;
        this.cipher = asymmetricBlockCipher;
        this.digest = digest2;
        if (z10) {
            intValue = 188;
        } else {
            Integer trailer2 = ISOTrailers.getTrailer(digest2);
            if (trailer2 != null) {
                intValue = trailer2.intValue();
            } else {
                throw new IllegalArgumentException("no valid trailer for digest: " + digest2.getAlgorithmName());
            }
        }
        this.trailer = intValue;
    }

    private void clearBlock(byte[] bArr) {
        for (int i10 = 0; i10 != bArr.length; i10++) {
            bArr[i10] = 0;
        }
    }

    private boolean isSameAs(byte[] bArr, byte[] bArr2) {
        int i10 = this.messageLength;
        byte[] bArr3 = this.mBuf;
        boolean z10 = true;
        if (i10 > bArr3.length) {
            if (bArr3.length > bArr2.length) {
                z10 = false;
            }
            for (int i11 = 0; i11 != this.mBuf.length; i11++) {
                if (bArr[i11] != bArr2[i11]) {
                    z10 = false;
                }
            }
        } else {
            if (i10 != bArr2.length) {
                z10 = false;
            }
            for (int i12 = 0; i12 != bArr2.length; i12++) {
                if (bArr[i12] != bArr2[i12]) {
                    z10 = false;
                }
            }
        }
        return z10;
    }

    private boolean returnFalse(byte[] bArr) {
        this.messageLength = 0;
        clearBlock(this.mBuf);
        clearBlock(bArr);
        return false;
    }

    public byte[] generateSignature() throws CryptoException {
        int i10;
        int i11;
        int i12;
        int i13;
        int digestSize = this.digest.getDigestSize();
        boolean z10 = true;
        if (this.trailer == 188) {
            byte[] bArr = this.block;
            i10 = (bArr.length - digestSize) - 1;
            this.digest.doFinal(bArr, i10);
            byte[] bArr2 = this.block;
            bArr2[bArr2.length - 1] = PSSSigner.TRAILER_IMPLICIT;
            i11 = 8;
        } else {
            i11 = 16;
            byte[] bArr3 = this.block;
            int length = (bArr3.length - digestSize) - 2;
            this.digest.doFinal(bArr3, length);
            byte[] bArr4 = this.block;
            int i14 = this.trailer;
            bArr4[bArr4.length - 2] = (byte) (i14 >>> 8);
            bArr4[bArr4.length - 1] = (byte) i14;
            i10 = length;
        }
        int i15 = this.messageLength;
        int i16 = ((((digestSize + i15) * 8) + i11) + 4) - this.keyBits;
        if (i16 > 0) {
            int i17 = i15 - ((i16 + 7) / 8);
            i13 = 96;
            i12 = i10 - i17;
            System.arraycopy(this.mBuf, 0, this.block, i12, i17);
            this.recoveredMessage = new byte[i17];
        } else {
            i13 = 64;
            i12 = i10 - i15;
            System.arraycopy(this.mBuf, 0, this.block, i12, i15);
            this.recoveredMessage = new byte[this.messageLength];
        }
        int i18 = i12 - 1;
        if (i18 > 0) {
            for (int i19 = i18; i19 != 0; i19--) {
                this.block[i19] = -69;
            }
            byte[] bArr5 = this.block;
            bArr5[i18] = (byte) (bArr5[i18] ^ 1);
            bArr5[0] = 11;
            bArr5[0] = (byte) (11 | i13);
        } else {
            byte[] bArr6 = this.block;
            bArr6[0] = 10;
            bArr6[0] = (byte) (10 | i13);
        }
        AsymmetricBlockCipher asymmetricBlockCipher = this.cipher;
        byte[] bArr7 = this.block;
        byte[] processBlock = asymmetricBlockCipher.processBlock(bArr7, 0, bArr7.length);
        if ((i13 & 32) != 0) {
            z10 = false;
        }
        this.fullMessage = z10;
        byte[] bArr8 = this.mBuf;
        byte[] bArr9 = this.recoveredMessage;
        System.arraycopy(bArr8, 0, bArr9, 0, bArr9.length);
        this.messageLength = 0;
        clearBlock(this.mBuf);
        clearBlock(this.block);
        return processBlock;
    }

    public byte[] getRecoveredMessage() {
        return this.recoveredMessage;
    }

    public boolean hasFullMessage() {
        return this.fullMessage;
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        this.cipher.init(z10, rSAKeyParameters);
        int bitLength = rSAKeyParameters.getModulus().bitLength();
        this.keyBits = bitLength;
        byte[] bArr = new byte[((bitLength + 7) / 8)];
        this.block = bArr;
        int i10 = this.trailer;
        int length = bArr.length;
        if (i10 == 188) {
            this.mBuf = new byte[((length - this.digest.getDigestSize()) - 2)];
        } else {
            this.mBuf = new byte[((length - this.digest.getDigestSize()) - 3)];
        }
        reset();
    }

    public void reset() {
        this.digest.reset();
        this.messageLength = 0;
        clearBlock(this.mBuf);
        byte[] bArr = this.recoveredMessage;
        if (bArr != null) {
            clearBlock(bArr);
        }
        this.recoveredMessage = null;
        this.fullMessage = false;
        if (this.preSig != null) {
            this.preSig = null;
            clearBlock(this.preBlock);
            this.preBlock = null;
        }
    }

    public void update(byte b10) {
        this.digest.update(b10);
        int i10 = this.messageLength;
        byte[] bArr = this.mBuf;
        if (i10 < bArr.length) {
            bArr[i10] = b10;
        }
        this.messageLength = i10 + 1;
    }

    public void update(byte[] bArr, int i10, int i11) {
        while (i11 > 0 && this.messageLength < this.mBuf.length) {
            update(bArr[i10]);
            i10++;
            i11--;
        }
        this.digest.update(bArr, i10, i11);
        this.messageLength += i11;
    }

    public void updateWithRecoveredMessage(byte[] bArr) throws InvalidCipherTextException {
        byte[] processBlock = this.cipher.processBlock(bArr, 0, bArr.length);
        if (((processBlock[0] & 192) ^ 64) != 0) {
            throw new InvalidCipherTextException("malformed signature");
        } else if (((processBlock[processBlock.length - 1] & 15) ^ 12) == 0) {
            int i10 = 2;
            if (((processBlock[processBlock.length - 1] & 255) ^ PSSSigner.TRAILER_IMPLICIT) == 0) {
                i10 = 1;
            } else {
                byte b10 = ((processBlock[processBlock.length - 2] & 255) << 8) | (processBlock[processBlock.length - 1] & 255);
                Integer trailer2 = ISOTrailers.getTrailer(this.digest);
                if (trailer2 != null) {
                    int intValue = trailer2.intValue();
                    if (!(b10 == intValue || (intValue == 15052 && b10 == 16588))) {
                        throw new IllegalStateException("signer initialised with wrong digest for trailer " + b10);
                    }
                } else {
                    throw new IllegalArgumentException("unrecognised hash in signature");
                }
            }
            int i11 = 0;
            while (i11 != processBlock.length && ((processBlock[i11] & 15) ^ 10) != 0) {
                i11++;
            }
            int i12 = i11 + 1;
            int length = ((processBlock.length - i10) - this.digest.getDigestSize()) - i12;
            if (length > 0) {
                if ((processBlock[0] & 32) == 0) {
                    this.fullMessage = true;
                    byte[] bArr2 = new byte[length];
                    this.recoveredMessage = bArr2;
                    System.arraycopy(processBlock, i12, bArr2, 0, bArr2.length);
                } else {
                    this.fullMessage = false;
                    byte[] bArr3 = new byte[length];
                    this.recoveredMessage = bArr3;
                    System.arraycopy(processBlock, i12, bArr3, 0, bArr3.length);
                }
                this.preSig = bArr;
                this.preBlock = processBlock;
                Digest digest2 = this.digest;
                byte[] bArr4 = this.recoveredMessage;
                digest2.update(bArr4, 0, bArr4.length);
                byte[] bArr5 = this.recoveredMessage;
                this.messageLength = bArr5.length;
                System.arraycopy(bArr5, 0, this.mBuf, 0, bArr5.length);
                return;
            }
            throw new InvalidCipherTextException("malformed block");
        } else {
            throw new InvalidCipherTextException("malformed signature");
        }
    }

    public boolean verifySignature(byte[] bArr) {
        byte[] bArr2;
        byte[] bArr3 = this.preSig;
        if (bArr3 == null) {
            try {
                bArr2 = this.cipher.processBlock(bArr, 0, bArr.length);
            } catch (Exception unused) {
                return false;
            }
        } else if (Arrays.areEqual(bArr3, bArr)) {
            bArr2 = this.preBlock;
            this.preSig = null;
            this.preBlock = null;
        } else {
            throw new IllegalStateException("updateWithRecoveredMessage called on different signature");
        }
        if (((bArr2[0] & 192) ^ 64) != 0) {
            return returnFalse(bArr2);
        }
        if (((bArr2[bArr2.length - 1] & 15) ^ 12) != 0) {
            return returnFalse(bArr2);
        }
        int i10 = 2;
        if (((bArr2[bArr2.length - 1] & 255) ^ PSSSigner.TRAILER_IMPLICIT) == 0) {
            i10 = 1;
        } else {
            byte b10 = ((bArr2[bArr2.length - 2] & 255) << 8) | (bArr2[bArr2.length - 1] & 255);
            Integer trailer2 = ISOTrailers.getTrailer(this.digest);
            if (trailer2 != null) {
                int intValue = trailer2.intValue();
                if (!(b10 == intValue || (intValue == 15052 && b10 == 16588))) {
                    throw new IllegalStateException("signer initialised with wrong digest for trailer " + b10);
                }
            } else {
                throw new IllegalArgumentException("unrecognised hash in signature");
            }
        }
        int i11 = 0;
        while (i11 != bArr2.length && ((bArr2[i11] & 15) ^ 10) != 0) {
            i11++;
        }
        int i12 = i11 + 1;
        int digestSize = this.digest.getDigestSize();
        byte[] bArr4 = new byte[digestSize];
        int length = (bArr2.length - i10) - digestSize;
        int i13 = length - i12;
        if (i13 <= 0) {
            return returnFalse(bArr2);
        }
        if ((bArr2[0] & 32) == 0) {
            this.fullMessage = true;
            if (this.messageLength > i13) {
                return returnFalse(bArr2);
            }
            this.digest.reset();
            this.digest.update(bArr2, i12, i13);
            this.digest.doFinal(bArr4, 0);
            boolean z10 = true;
            for (int i14 = 0; i14 != digestSize; i14++) {
                int i15 = length + i14;
                byte b11 = (byte) (bArr2[i15] ^ bArr4[i14]);
                bArr2[i15] = b11;
                if (b11 != 0) {
                    z10 = false;
                }
            }
            if (!z10) {
                return returnFalse(bArr2);
            }
            byte[] bArr5 = new byte[i13];
            this.recoveredMessage = bArr5;
            System.arraycopy(bArr2, i12, bArr5, 0, bArr5.length);
        } else {
            this.fullMessage = false;
            this.digest.doFinal(bArr4, 0);
            boolean z11 = true;
            for (int i16 = 0; i16 != digestSize; i16++) {
                int i17 = length + i16;
                byte b12 = (byte) (bArr2[i17] ^ bArr4[i16]);
                bArr2[i17] = b12;
                if (b12 != 0) {
                    z11 = false;
                }
            }
            if (!z11) {
                return returnFalse(bArr2);
            }
            byte[] bArr6 = new byte[i13];
            this.recoveredMessage = bArr6;
            System.arraycopy(bArr2, i12, bArr6, 0, bArr6.length);
        }
        if (this.messageLength != 0 && !isSameAs(this.mBuf, this.recoveredMessage)) {
            return returnFalse(bArr2);
        }
        clearBlock(this.mBuf);
        clearBlock(bArr2);
        this.messageLength = 0;
        return true;
    }
}
