package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;

public class DHBasicAgreement implements BasicAgreement {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private DHParameters dhParams;
    private DHPrivateKeyParameters key;

    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        DHPublicKeyParameters dHPublicKeyParameters = (DHPublicKeyParameters) cipherParameters;
        if (dHPublicKeyParameters.getParameters().equals(this.dhParams)) {
            BigInteger p10 = this.dhParams.getP();
            BigInteger y10 = dHPublicKeyParameters.getY();
            if (y10 != null) {
                BigInteger bigInteger = ONE;
                if (y10.compareTo(bigInteger) > 0 && y10.compareTo(p10.subtract(bigInteger)) < 0) {
                    BigInteger modPow = y10.modPow(this.key.getX(), p10);
                    if (!modPow.equals(bigInteger)) {
                        return modPow;
                    }
                    throw new IllegalStateException("Shared key can't be 1");
                }
            }
            throw new IllegalArgumentException("Diffie-Hellman public key is weak");
        }
        throw new IllegalArgumentException("Diffie-Hellman public key has wrong parameters.");
    }

    public int getFieldSize() {
        return (this.key.getParameters().getP().bitLength() + 7) / 8;
    }

    public void init(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        AsymmetricKeyParameter asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        if (asymmetricKeyParameter instanceof DHPrivateKeyParameters) {
            DHPrivateKeyParameters dHPrivateKeyParameters = (DHPrivateKeyParameters) asymmetricKeyParameter;
            this.key = dHPrivateKeyParameters;
            this.dhParams = dHPrivateKeyParameters.getParameters();
            return;
        }
        throw new IllegalArgumentException("DHEngine expects DHPrivateKeyParameters");
    }
}
