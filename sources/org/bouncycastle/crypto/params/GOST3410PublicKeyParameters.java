package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class GOST3410PublicKeyParameters extends GOST3410KeyParameters {

    /* renamed from: y  reason: collision with root package name */
    private BigInteger f41534y;

    public GOST3410PublicKeyParameters(BigInteger bigInteger, GOST3410Parameters gOST3410Parameters) {
        super(false, gOST3410Parameters);
        this.f41534y = bigInteger;
    }

    public BigInteger getY() {
        return this.f41534y;
    }
}
