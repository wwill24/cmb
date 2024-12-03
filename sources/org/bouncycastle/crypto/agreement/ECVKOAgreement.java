package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithUKM;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.BigIntegers;

public class ECVKOAgreement {
    private final Digest digest;
    private ECPrivateKeyParameters key;
    private BigInteger ukm;

    public ECVKOAgreement(Digest digest2) {
        this.digest = digest2;
    }

    private byte[] fromPoint(ECPoint eCPoint) {
        BigInteger bigInteger = eCPoint.getAffineXCoord().toBigInteger();
        BigInteger bigInteger2 = eCPoint.getAffineYCoord().toBigInteger();
        int i10 = bigInteger.toByteArray().length > 33 ? 64 : 32;
        int i11 = i10 * 2;
        byte[] bArr = new byte[i11];
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(i10, bigInteger);
        byte[] asUnsignedByteArray2 = BigIntegers.asUnsignedByteArray(i10, bigInteger2);
        for (int i12 = 0; i12 != i10; i12++) {
            bArr[i12] = asUnsignedByteArray[(i10 - i12) - 1];
        }
        for (int i13 = 0; i13 != i10; i13++) {
            bArr[i10 + i13] = asUnsignedByteArray2[(i10 - i13) - 1];
        }
        this.digest.update(bArr, 0, i11);
        byte[] bArr2 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr2, 0);
        return bArr2;
    }

    private static BigInteger toInteger(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i10 = 0; i10 != length; i10++) {
            bArr2[i10] = bArr[(bArr.length - i10) - 1];
        }
        return new BigInteger(1, bArr2);
    }

    public byte[] calculateAgreement(CipherParameters cipherParameters) {
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) cipherParameters;
        ECDomainParameters parameters = this.key.getParameters();
        if (parameters.equals(eCPublicKeyParameters.getParameters())) {
            BigInteger mod = parameters.getH().multiply(this.ukm).multiply(this.key.getD()).mod(parameters.getN());
            ECPoint cleanPoint = ECAlgorithms.cleanPoint(parameters.getCurve(), eCPublicKeyParameters.getQ());
            if (!cleanPoint.isInfinity()) {
                ECPoint normalize = cleanPoint.multiply(mod).normalize();
                if (!normalize.isInfinity()) {
                    return fromPoint(normalize);
                }
                throw new IllegalStateException("Infinity is not a valid agreement value for ECVKO");
            }
            throw new IllegalStateException("Infinity is not a valid public key for ECDHC");
        }
        throw new IllegalStateException("ECVKO public key has wrong domain parameters");
    }

    public int getFieldSize() {
        return (this.key.getParameters().getCurve().getFieldSize() + 7) / 8;
    }

    public void init(CipherParameters cipherParameters) {
        ParametersWithUKM parametersWithUKM = (ParametersWithUKM) cipherParameters;
        this.key = (ECPrivateKeyParameters) parametersWithUKM.getParameters();
        this.ukm = toInteger(parametersWithUKM.getUKM());
    }
}
