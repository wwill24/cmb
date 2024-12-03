package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DSAExt;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

public class ECGOST3410Signer implements DSAExt {
    ECKeyParameters key;
    SecureRandom random;

    /* access modifiers changed from: protected */
    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    public BigInteger[] generateSignature(byte[] bArr) {
        BigInteger bigInteger = new BigInteger(1, Arrays.reverse(bArr));
        ECDomainParameters parameters = this.key.getParameters();
        BigInteger n10 = parameters.getN();
        BigInteger d10 = ((ECPrivateKeyParameters) this.key).getD();
        ECMultiplier createBasePointMultiplier = createBasePointMultiplier();
        while (true) {
            BigInteger createRandomBigInteger = BigIntegers.createRandomBigInteger(n10.bitLength(), this.random);
            BigInteger bigInteger2 = ECConstants.ZERO;
            if (!createRandomBigInteger.equals(bigInteger2)) {
                BigInteger mod = createBasePointMultiplier.multiply(parameters.getG(), createRandomBigInteger).normalize().getAffineXCoord().toBigInteger().mod(n10);
                if (!mod.equals(bigInteger2)) {
                    BigInteger mod2 = createRandomBigInteger.multiply(bigInteger).add(d10.multiply(mod)).mod(n10);
                    if (!mod2.equals(bigInteger2)) {
                        return new BigInteger[]{mod, mod2};
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public BigInteger getOrder() {
        return this.key.getParameters().getN();
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        ECKeyParameters eCKeyParameters;
        if (!z10) {
            eCKeyParameters = (ECPublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.random = parametersWithRandom.getRandom();
            this.key = (ECPrivateKeyParameters) parametersWithRandom.getParameters();
            return;
        } else {
            this.random = CryptoServicesRegistrar.getSecureRandom();
            eCKeyParameters = (ECPrivateKeyParameters) cipherParameters;
        }
        this.key = eCKeyParameters;
    }

    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = new BigInteger(1, Arrays.reverse(bArr));
        BigInteger n10 = this.key.getParameters().getN();
        BigInteger bigInteger4 = ECConstants.ONE;
        if (bigInteger.compareTo(bigInteger4) < 0 || bigInteger.compareTo(n10) >= 0 || bigInteger2.compareTo(bigInteger4) < 0 || bigInteger2.compareTo(n10) >= 0) {
            return false;
        }
        BigInteger modOddInverseVar = BigIntegers.modOddInverseVar(n10, bigInteger3);
        ECPoint normalize = ECAlgorithms.sumOfTwoMultiplies(this.key.getParameters().getG(), bigInteger2.multiply(modOddInverseVar).mod(n10), ((ECPublicKeyParameters) this.key).getQ(), n10.subtract(bigInteger).multiply(modOddInverseVar).mod(n10)).normalize();
        if (normalize.isInfinity()) {
            return false;
        }
        return normalize.getAffineXCoord().toBigInteger().mod(n10).equals(bigInteger);
    }
}
