package org.bouncycastle.jce.spec;

import java.math.BigInteger;

public class ECPrivateKeySpec extends ECKeySpec {

    /* renamed from: d  reason: collision with root package name */
    private BigInteger f23875d;

    public ECPrivateKeySpec(BigInteger bigInteger, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        this.f23875d = bigInteger;
    }

    public BigInteger getD() {
        return this.f23875d;
    }
}
