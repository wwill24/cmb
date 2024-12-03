package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class DSAPrivateKeyParameters extends DSAKeyParameters {

    /* renamed from: x  reason: collision with root package name */
    private BigInteger f41519x;

    public DSAPrivateKeyParameters(BigInteger bigInteger, DSAParameters dSAParameters) {
        super(true, dSAParameters);
        this.f41519x = bigInteger;
    }

    public BigInteger getX() {
        return this.f41519x;
    }
}
