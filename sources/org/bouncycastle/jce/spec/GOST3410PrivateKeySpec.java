package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class GOST3410PrivateKeySpec implements KeySpec {

    /* renamed from: a  reason: collision with root package name */
    private BigInteger f23881a;

    /* renamed from: p  reason: collision with root package name */
    private BigInteger f23882p;

    /* renamed from: q  reason: collision with root package name */
    private BigInteger f23883q;

    /* renamed from: x  reason: collision with root package name */
    private BigInteger f23884x;

    public GOST3410PrivateKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f23884x = bigInteger;
        this.f23882p = bigInteger2;
        this.f23883q = bigInteger3;
        this.f23881a = bigInteger4;
    }

    public BigInteger getA() {
        return this.f23881a;
    }

    public BigInteger getP() {
        return this.f23882p;
    }

    public BigInteger getQ() {
        return this.f23883q;
    }

    public BigInteger getX() {
        return this.f23884x;
    }
}
