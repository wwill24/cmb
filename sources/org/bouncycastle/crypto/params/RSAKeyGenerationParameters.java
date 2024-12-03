package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class RSAKeyGenerationParameters extends KeyGenerationParameters {
    private int certainty;
    private BigInteger publicExponent;

    public RSAKeyGenerationParameters(BigInteger bigInteger, SecureRandom secureRandom, int i10, int i11) {
        super(secureRandom, i10);
        if (i10 < 12) {
            throw new IllegalArgumentException("key strength too small");
        } else if (bigInteger.testBit(0)) {
            this.publicExponent = bigInteger;
            this.certainty = i11;
        } else {
            throw new IllegalArgumentException("public exponent cannot be even");
        }
    }

    public int getCertainty() {
        return this.certainty;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }
}
