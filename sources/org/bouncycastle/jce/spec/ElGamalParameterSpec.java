package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class ElGamalParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: g  reason: collision with root package name */
    private BigInteger f23877g;

    /* renamed from: p  reason: collision with root package name */
    private BigInteger f23878p;

    public ElGamalParameterSpec(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f23878p = bigInteger;
        this.f23877g = bigInteger2;
    }

    public BigInteger getG() {
        return this.f23877g;
    }

    public BigInteger getP() {
        return this.f23878p;
    }
}
