package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class GOST3410PrivateKeyParameters extends GOST3410KeyParameters {

    /* renamed from: x  reason: collision with root package name */
    private BigInteger f41533x;

    public GOST3410PrivateKeyParameters(BigInteger bigInteger, GOST3410Parameters gOST3410Parameters) {
        super(true, gOST3410Parameters);
        this.f41533x = bigInteger;
    }

    public BigInteger getX() {
        return this.f41533x;
    }
}
