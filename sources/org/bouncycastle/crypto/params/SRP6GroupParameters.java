package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class SRP6GroupParameters {
    private BigInteger N;

    /* renamed from: g  reason: collision with root package name */
    private BigInteger f41549g;

    public SRP6GroupParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this.N = bigInteger;
        this.f41549g = bigInteger2;
    }

    public BigInteger getG() {
        return this.f41549g;
    }

    public BigInteger getN() {
        return this.N;
    }
}
