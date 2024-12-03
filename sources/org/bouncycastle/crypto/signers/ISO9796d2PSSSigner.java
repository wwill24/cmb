package org.bouncycastle.crypto.signers;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.SignerWithRecovery;
import org.bouncycastle.util.Arrays;

public class ISO9796d2PSSSigner implements SignerWithRecovery {
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
    private int hLen;
    private int keyBits;
    private byte[] mBuf;
    private int messageLength;
    private byte[] preBlock;
    private int preMStart;
    private byte[] preSig;
    private int preTLength;
    private SecureRandom random;
    private byte[] recoveredMessage;
    private int saltLength;
    private byte[] standardSalt;
    private int trailer;

    public ISO9796d2PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest2, int i10) {
        this(asymmetricBlockCipher, digest2, i10, false);
    }

    public ISO9796d2PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest2, int i10, boolean z10) {
        int intValue;
        this.cipher = asymmetricBlockCipher;
        this.digest = digest2;
        this.hLen = digest2.getDigestSize();
        this.saltLength = i10;
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

    private void ItoOSP(int i10, byte[] bArr) {
        bArr[0] = (byte) (i10 >>> 24);
        bArr[1] = (byte) (i10 >>> 16);
        bArr[2] = (byte) (i10 >>> 8);
        bArr[3] = (byte) (i10 >>> 0);
    }

    private void LtoOSP(long j10, byte[] bArr) {
        bArr[0] = (byte) ((int) (j10 >>> 56));
        bArr[1] = (byte) ((int) (j10 >>> 48));
        bArr[2] = (byte) ((int) (j10 >>> 40));
        bArr[3] = (byte) ((int) (j10 >>> 32));
        bArr[4] = (byte) ((int) (j10 >>> 24));
        bArr[5] = (byte) ((int) (j10 >>> 16));
        bArr[6] = (byte) ((int) (j10 >>> 8));
        bArr[7] = (byte) ((int) (j10 >>> 0));
    }

    private void clearBlock(byte[] bArr) {
        for (int i10 = 0; i10 != bArr.length; i10++) {
            bArr[i10] = 0;
        }
    }

    private boolean isSameAs(byte[] bArr, byte[] bArr2) {
        boolean z10 = this.messageLength == bArr2.length;
        for (int i10 = 0; i10 != bArr2.length; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                z10 = false;
            }
        }
        return z10;
    }

    private byte[] maskGeneratorFunction1(byte[] bArr, int i10, int i11, int i12) {
        int i13;
        byte[] bArr2 = new byte[i12];
        byte[] bArr3 = new byte[this.hLen];
        byte[] bArr4 = new byte[4];
        this.digest.reset();
        int i14 = 0;
        while (true) {
            i13 = this.hLen;
            if (i14 >= i12 / i13) {
                break;
            }
            ItoOSP(i14, bArr4);
            this.digest.update(bArr, i10, i11);
            this.digest.update(bArr4, 0, 4);
            this.digest.doFinal(bArr3, 0);
            int i15 = this.hLen;
            System.arraycopy(bArr3, 0, bArr2, i14 * i15, i15);
            i14++;
        }
        if (i13 * i14 < i12) {
            ItoOSP(i14, bArr4);
            this.digest.update(bArr, i10, i11);
            this.digest.update(bArr4, 0, 4);
            this.digest.doFinal(bArr3, 0);
            int i16 = this.hLen;
            System.arraycopy(bArr3, 0, bArr2, i14 * i16, i12 - (i14 * i16));
        }
        return bArr2;
    }

    public byte[] generateSignature() throws CryptoException {
        int digestSize = this.digest.getDigestSize();
        byte[] bArr = new byte[digestSize];
        this.digest.doFinal(bArr, 0);
        byte[] bArr2 = new byte[8];
        LtoOSP((long) (this.messageLength * 8), bArr2);
        this.digest.update(bArr2, 0, 8);
        this.digest.update(this.mBuf, 0, this.messageLength);
        this.digest.update(bArr, 0, digestSize);
        byte[] bArr3 = this.standardSalt;
        if (bArr3 == null) {
            bArr3 = new byte[this.saltLength];
            this.random.nextBytes(bArr3);
        }
        this.digest.update(bArr3, 0, bArr3.length);
        int digestSize2 = this.digest.getDigestSize();
        byte[] bArr4 = new byte[digestSize2];
        this.digest.doFinal(bArr4, 0);
        boolean z10 = true;
        int i10 = this.trailer == 188 ? 1 : 2;
        byte[] bArr5 = this.block;
        int length = bArr5.length;
        int i11 = this.messageLength;
        int length2 = ((((length - i11) - bArr3.length) - this.hLen) - i10) - 1;
        bArr5[length2] = 1;
        int i12 = length2 + 1;
        System.arraycopy(this.mBuf, 0, bArr5, i12, i11);
        System.arraycopy(bArr3, 0, this.block, i12 + this.messageLength, bArr3.length);
        byte[] maskGeneratorFunction1 = maskGeneratorFunction1(bArr4, 0, digestSize2, (this.block.length - this.hLen) - i10);
        for (int i13 = 0; i13 != maskGeneratorFunction1.length; i13++) {
            byte[] bArr6 = this.block;
            bArr6[i13] = (byte) (bArr6[i13] ^ maskGeneratorFunction1[i13]);
        }
        byte[] bArr7 = this.block;
        int length3 = bArr7.length;
        int i14 = this.hLen;
        System.arraycopy(bArr4, 0, bArr7, (length3 - i14) - i10, i14);
        int i15 = this.trailer;
        if (i15 == 188) {
            byte[] bArr8 = this.block;
            bArr8[bArr8.length - 1] = PSSSigner.TRAILER_IMPLICIT;
        } else {
            byte[] bArr9 = this.block;
            bArr9[bArr9.length - 2] = (byte) (i15 >>> 8);
            bArr9[bArr9.length - 1] = (byte) i15;
        }
        byte[] bArr10 = this.block;
        bArr10[0] = (byte) (bArr10[0] & Byte.MAX_VALUE);
        byte[] processBlock = this.cipher.processBlock(bArr10, 0, bArr10.length);
        int i16 = this.messageLength;
        byte[] bArr11 = new byte[i16];
        this.recoveredMessage = bArr11;
        byte[] bArr12 = this.mBuf;
        if (i16 > bArr12.length) {
            z10 = false;
        }
        this.fullMessage = z10;
        System.arraycopy(bArr12, 0, bArr11, 0, bArr11.length);
        clearBlock(this.mBuf);
        clearBlock(this.block);
        this.messageLength = 0;
        return processBlock;
    }

    public byte[] getRecoveredMessage() {
        return this.recoveredMessage;
    }

    public boolean hasFullMessage() {
        return this.fullMessage;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [org.bouncycastle.crypto.CipherParameters] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init(boolean r4, org.bouncycastle.crypto.CipherParameters r5) {
        /*
            r3 = this;
            int r0 = r3.saltLength
            boolean r1 = r5 instanceof org.bouncycastle.crypto.params.ParametersWithRandom
            if (r1 == 0) goto L_0x0017
            org.bouncycastle.crypto.params.ParametersWithRandom r5 = (org.bouncycastle.crypto.params.ParametersWithRandom) r5
            org.bouncycastle.crypto.CipherParameters r1 = r5.getParameters()
            org.bouncycastle.crypto.params.RSAKeyParameters r1 = (org.bouncycastle.crypto.params.RSAKeyParameters) r1
            if (r4 == 0) goto L_0x0043
            java.security.SecureRandom r5 = r5.getRandom()
        L_0x0014:
            r3.random = r5
            goto L_0x0043
        L_0x0017:
            boolean r1 = r5 instanceof org.bouncycastle.crypto.params.ParametersWithSalt
            if (r1 == 0) goto L_0x0039
            org.bouncycastle.crypto.params.ParametersWithSalt r5 = (org.bouncycastle.crypto.params.ParametersWithSalt) r5
            org.bouncycastle.crypto.CipherParameters r0 = r5.getParameters()
            r1 = r0
            org.bouncycastle.crypto.params.RSAKeyParameters r1 = (org.bouncycastle.crypto.params.RSAKeyParameters) r1
            byte[] r5 = r5.getSalt()
            r3.standardSalt = r5
            int r0 = r5.length
            int r5 = r5.length
            int r2 = r3.saltLength
            if (r5 != r2) goto L_0x0031
            goto L_0x0043
        L_0x0031:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Fixed salt is of wrong length"
            r4.<init>(r5)
            throw r4
        L_0x0039:
            r1 = r5
            org.bouncycastle.crypto.params.RSAKeyParameters r1 = (org.bouncycastle.crypto.params.RSAKeyParameters) r1
            if (r4 == 0) goto L_0x0043
            java.security.SecureRandom r5 = org.bouncycastle.crypto.CryptoServicesRegistrar.getSecureRandom()
            goto L_0x0014
        L_0x0043:
            org.bouncycastle.crypto.AsymmetricBlockCipher r5 = r3.cipher
            r5.init(r4, r1)
            java.math.BigInteger r4 = r1.getModulus()
            int r4 = r4.bitLength()
            r3.keyBits = r4
            int r4 = r4 + 7
            int r4 = r4 / 8
            byte[] r4 = new byte[r4]
            r3.block = r4
            int r5 = r3.trailer
            r1 = 188(0xbc, float:2.63E-43)
            int r4 = r4.length
            if (r5 != r1) goto L_0x0072
            org.bouncycastle.crypto.Digest r5 = r3.digest
            int r5 = r5.getDigestSize()
            int r4 = r4 - r5
            int r4 = r4 - r0
            int r4 = r4 + -1
            int r4 = r4 + -1
            byte[] r4 = new byte[r4]
            r3.mBuf = r4
            goto L_0x0082
        L_0x0072:
            org.bouncycastle.crypto.Digest r5 = r3.digest
            int r5 = r5.getDigestSize()
            int r4 = r4 - r5
            int r4 = r4 - r0
            int r4 = r4 + -1
            int r4 = r4 + -2
            byte[] r4 = new byte[r4]
            r3.mBuf = r4
        L_0x0082:
            r3.reset()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.signers.ISO9796d2PSSSigner.init(boolean, org.bouncycastle.crypto.CipherParameters):void");
    }

    public void reset() {
        this.digest.reset();
        this.messageLength = 0;
        byte[] bArr = this.mBuf;
        if (bArr != null) {
            clearBlock(bArr);
        }
        byte[] bArr2 = this.recoveredMessage;
        if (bArr2 != null) {
            clearBlock(bArr2);
            this.recoveredMessage = null;
        }
        this.fullMessage = false;
        if (this.preSig != null) {
            this.preSig = null;
            clearBlock(this.preBlock);
            this.preBlock = null;
        }
    }

    public void update(byte b10) {
        if (this.preSig == null) {
            int i10 = this.messageLength;
            byte[] bArr = this.mBuf;
            if (i10 < bArr.length) {
                this.messageLength = i10 + 1;
                bArr[i10] = b10;
                return;
            }
        }
        this.digest.update(b10);
    }

    public void update(byte[] bArr, int i10, int i11) {
        if (this.preSig == null) {
            while (i11 > 0 && this.messageLength < this.mBuf.length) {
                update(bArr[i10]);
                i10++;
                i11--;
            }
        }
        if (i11 > 0) {
            this.digest.update(bArr, i10, i11);
        }
    }

    public void updateWithRecoveredMessage(byte[] bArr) throws InvalidCipherTextException {
        byte[] processBlock = this.cipher.processBlock(bArr, 0, bArr.length);
        int length = processBlock.length;
        int i10 = this.keyBits;
        if (length < (i10 + 7) / 8) {
            int i11 = (i10 + 7) / 8;
            byte[] bArr2 = new byte[i11];
            System.arraycopy(processBlock, 0, bArr2, i11 - processBlock.length, processBlock.length);
            clearBlock(processBlock);
            processBlock = bArr2;
        }
        boolean z10 = true;
        int i12 = 2;
        if (((processBlock[processBlock.length - 1] & 255) ^ PSSSigner.TRAILER_IMPLICIT) == 0) {
            i12 = 1;
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
        this.digest.doFinal(new byte[this.hLen], 0);
        int length2 = processBlock.length;
        int i13 = this.hLen;
        byte[] maskGeneratorFunction1 = maskGeneratorFunction1(processBlock, (length2 - i13) - i12, i13, (processBlock.length - i13) - i12);
        for (int i14 = 0; i14 != maskGeneratorFunction1.length; i14++) {
            processBlock[i14] = (byte) (processBlock[i14] ^ maskGeneratorFunction1[i14]);
        }
        processBlock[0] = (byte) (processBlock[0] & Byte.MAX_VALUE);
        int i15 = 0;
        while (i15 != processBlock.length && processBlock[i15] != 1) {
            i15++;
        }
        int i16 = i15 + 1;
        if (i16 >= processBlock.length) {
            clearBlock(processBlock);
        }
        if (i16 <= 1) {
            z10 = false;
        }
        this.fullMessage = z10;
        byte[] bArr3 = new byte[((maskGeneratorFunction1.length - i16) - this.saltLength)];
        this.recoveredMessage = bArr3;
        System.arraycopy(processBlock, i16, bArr3, 0, bArr3.length);
        byte[] bArr4 = this.recoveredMessage;
        System.arraycopy(bArr4, 0, this.mBuf, 0, bArr4.length);
        this.preSig = bArr;
        this.preBlock = processBlock;
        this.preMStart = i16;
        this.preTLength = i12;
    }

    public boolean verifySignature(byte[] bArr) {
        int i10 = this.hLen;
        byte[] bArr2 = new byte[i10];
        this.digest.doFinal(bArr2, 0);
        byte[] bArr3 = this.preSig;
        if (bArr3 == null) {
            try {
                updateWithRecoveredMessage(bArr);
            } catch (Exception unused) {
                return false;
            }
        } else if (!Arrays.areEqual(bArr3, bArr)) {
            throw new IllegalStateException("updateWithRecoveredMessage called on different signature");
        }
        byte[] bArr4 = this.preBlock;
        int i11 = this.preMStart;
        int i12 = this.preTLength;
        this.preSig = null;
        this.preBlock = null;
        byte[] bArr5 = new byte[8];
        LtoOSP((long) (this.recoveredMessage.length * 8), bArr5);
        this.digest.update(bArr5, 0, 8);
        byte[] bArr6 = this.recoveredMessage;
        if (bArr6.length != 0) {
            this.digest.update(bArr6, 0, bArr6.length);
        }
        this.digest.update(bArr2, 0, i10);
        byte[] bArr7 = this.standardSalt;
        if (bArr7 != null) {
            this.digest.update(bArr7, 0, bArr7.length);
        } else {
            this.digest.update(bArr4, i11 + this.recoveredMessage.length, this.saltLength);
        }
        int digestSize = this.digest.getDigestSize();
        byte[] bArr8 = new byte[digestSize];
        this.digest.doFinal(bArr8, 0);
        int length = (bArr4.length - i12) - digestSize;
        boolean z10 = true;
        for (int i13 = 0; i13 != digestSize; i13++) {
            if (bArr8[i13] != bArr4[length + i13]) {
                z10 = false;
            }
        }
        clearBlock(bArr4);
        clearBlock(bArr8);
        if (!z10) {
            this.fullMessage = false;
            this.messageLength = 0;
            clearBlock(this.recoveredMessage);
            return false;
        } else if (this.messageLength == 0 || isSameAs(this.mBuf, this.recoveredMessage)) {
            this.messageLength = 0;
            clearBlock(this.mBuf);
            return true;
        } else {
            this.messageLength = 0;
            clearBlock(this.mBuf);
            return false;
        }
    }
}
