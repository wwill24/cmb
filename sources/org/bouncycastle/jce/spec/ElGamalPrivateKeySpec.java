package org.bouncycastle.jce.spec;

import java.math.BigInteger;

public class ElGamalPrivateKeySpec extends ElGamalKeySpec {

    /* renamed from: x  reason: collision with root package name */
    private BigInteger f23879x;

    public ElGamalPrivateKeySpec(BigInteger bigInteger, ElGamalParameterSpec elGamalParameterSpec) {
        super(elGamalParameterSpec);
        this.f23879x = bigInteger;
    }

    public BigInteger getX() {
        return this.f23879x;
    }
}
