package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class SM2Engine {
    private int curveLength;
    private final Digest digest;
    private ECKeyParameters ecKey;
    private ECDomainParameters ecParams;
    private boolean forEncryption;
    private final Mode mode;
    private SecureRandom random;

    /* renamed from: org.bouncycastle.crypto.engines.SM2Engine$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$bouncycastle$crypto$engines$SM2Engine$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$org$bouncycastle$crypto$engines$SM2Engine$Mode = iArr;
            try {
                iArr[Mode.C1C3C2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public enum Mode {
        C1C2C3,
        C1C3C2
    }

    public SM2Engine() {
        this((Digest) new SM3Digest());
    }

    public SM2Engine(Digest digest2) {
        this(digest2, Mode.C1C2C3);
    }

    public SM2Engine(Digest digest2, Mode mode2) {
        if (mode2 != null) {
            this.digest = digest2;
            this.mode = mode2;
            return;
        }
        throw new IllegalArgumentException("mode cannot be NULL");
    }

    public SM2Engine(Mode mode2) {
        this(new SM3Digest(), mode2);
    }

    private void addFieldElement(Digest digest2, ECFieldElement eCFieldElement) {
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.curveLength, eCFieldElement.toBigInteger());
        digest2.update(asUnsignedByteArray, 0, asUnsignedByteArray.length);
    }

    private byte[] decrypt(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        byte b10;
        int i12 = (this.curveLength * 2) + 1;
        byte[] bArr2 = new byte[i12];
        System.arraycopy(bArr, i10, bArr2, 0, i12);
        ECPoint decodePoint = this.ecParams.getCurve().decodePoint(bArr2);
        if (!decodePoint.multiply(this.ecParams.getH()).isInfinity()) {
            ECPoint normalize = decodePoint.multiply(((ECPrivateKeyParameters) this.ecKey).getD()).normalize();
            int digestSize = this.digest.getDigestSize();
            int i13 = (i11 - i12) - digestSize;
            byte[] bArr3 = new byte[i13];
            Mode mode2 = this.mode;
            Mode mode3 = Mode.C1C3C2;
            if (mode2 == mode3) {
                System.arraycopy(bArr, i10 + i12 + digestSize, bArr3, 0, i13);
            } else {
                System.arraycopy(bArr, i10 + i12, bArr3, 0, i13);
            }
            kdf(this.digest, normalize, bArr3);
            int digestSize2 = this.digest.getDigestSize();
            byte[] bArr4 = new byte[digestSize2];
            addFieldElement(this.digest, normalize.getAffineXCoord());
            this.digest.update(bArr3, 0, i13);
            addFieldElement(this.digest, normalize.getAffineYCoord());
            this.digest.doFinal(bArr4, 0);
            if (this.mode == mode3) {
                b10 = 0;
                for (int i14 = 0; i14 != digestSize2; i14++) {
                    b10 |= bArr4[i14] ^ bArr[(i10 + i12) + i14];
                }
            } else {
                byte b11 = 0;
                for (int i15 = 0; i15 != digestSize2; i15++) {
                    b11 = b10 | (bArr4[i15] ^ bArr[((i10 + i12) + i13) + i15]);
                }
            }
            Arrays.fill(bArr2, (byte) 0);
            Arrays.fill(bArr4, (byte) 0);
            if (b10 == 0) {
                return bArr3;
            }
            Arrays.fill(bArr3, (byte) 0);
            throw new InvalidCipherTextException("invalid cipher text");
        }
        throw new InvalidCipherTextException("[h]C1 at infinity");
    }

    private byte[] encrypt(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        byte[] encoded;
        ECPoint normalize;
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        ECMultiplier createBasePointMultiplier = createBasePointMultiplier();
        do {
            BigInteger nextK = nextK();
            encoded = createBasePointMultiplier.multiply(this.ecParams.getG(), nextK).normalize().getEncoded(false);
            normalize = ((ECPublicKeyParameters) this.ecKey).getQ().multiply(nextK).normalize();
            kdf(this.digest, normalize, bArr2);
        } while (notEncrypted(bArr2, bArr, i10));
        byte[] bArr3 = new byte[this.digest.getDigestSize()];
        addFieldElement(this.digest, normalize.getAffineXCoord());
        this.digest.update(bArr, i10, i11);
        addFieldElement(this.digest, normalize.getAffineYCoord());
        this.digest.doFinal(bArr3, 0);
        return AnonymousClass1.$SwitchMap$org$bouncycastle$crypto$engines$SM2Engine$Mode[this.mode.ordinal()] != 1 ? Arrays.concatenate(encoded, bArr2, bArr3) : Arrays.concatenate(encoded, bArr3, bArr2);
    }

    private void kdf(Digest digest2, ECPoint eCPoint, byte[] bArr) {
        Memoable memoable;
        int digestSize = digest2.getDigestSize();
        byte[] bArr2 = new byte[Math.max(4, digestSize)];
        Memoable memoable2 = null;
        if (digest2 instanceof Memoable) {
            addFieldElement(digest2, eCPoint.getAffineXCoord());
            addFieldElement(digest2, eCPoint.getAffineYCoord());
            memoable2 = (Memoable) digest2;
            memoable = memoable2.copy();
        } else {
            memoable = null;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < bArr.length) {
            if (memoable2 != null) {
                memoable2.reset(memoable);
            } else {
                addFieldElement(digest2, eCPoint.getAffineXCoord());
                addFieldElement(digest2, eCPoint.getAffineYCoord());
            }
            i11++;
            Pack.intToBigEndian(i11, bArr2, 0);
            digest2.update(bArr2, 0, 4);
            digest2.doFinal(bArr2, 0);
            int min = Math.min(digestSize, bArr.length - i10);
            xor(bArr, bArr2, i10, min);
            i10 += min;
        }
    }

    private BigInteger nextK() {
        int bitLength = this.ecParams.getN().bitLength();
        while (true) {
            BigInteger createRandomBigInteger = BigIntegers.createRandomBigInteger(bitLength, this.random);
            if (!createRandomBigInteger.equals(BigIntegers.ZERO) && createRandomBigInteger.compareTo(this.ecParams.getN()) < 0) {
                return createRandomBigInteger;
            }
        }
    }

    private boolean notEncrypted(byte[] bArr, byte[] bArr2, int i10) {
        for (int i11 = 0; i11 != bArr.length; i11++) {
            if (bArr[i11] != bArr2[i10 + i11]) {
                return false;
            }
        }
        return true;
    }

    private void xor(byte[] bArr, byte[] bArr2, int i10, int i11) {
        for (int i12 = 0; i12 != i11; i12++) {
            int i13 = i10 + i12;
            bArr[i13] = (byte) (bArr[i13] ^ bArr2[i12]);
        }
    }

    /* access modifiers changed from: protected */
    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    public int getOutputSize(int i10) {
        return (this.curveLength * 2) + 1 + i10 + this.digest.getDigestSize();
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        this.forEncryption = z10;
        if (z10) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            ECKeyParameters eCKeyParameters = (ECKeyParameters) parametersWithRandom.getParameters();
            this.ecKey = eCKeyParameters;
            this.ecParams = eCKeyParameters.getParameters();
            if (!((ECPublicKeyParameters) this.ecKey).getQ().multiply(this.ecParams.getH()).isInfinity()) {
                this.random = parametersWithRandom.getRandom();
            } else {
                throw new IllegalArgumentException("invalid key: [h]Q at infinity");
            }
        } else {
            ECKeyParameters eCKeyParameters2 = (ECKeyParameters) cipherParameters;
            this.ecKey = eCKeyParameters2;
            this.ecParams = eCKeyParameters2.getParameters();
        }
        this.curveLength = (this.ecParams.getCurve().getFieldSize() + 7) / 8;
    }

    public byte[] processBlock(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        return this.forEncryption ? encrypt(bArr, i10, i11) : decrypt(bArr, i10, i11);
    }
}
