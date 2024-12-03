package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class GOST3410PublicKeySpec implements KeySpec {

    /* renamed from: a  reason: collision with root package name */
    private BigInteger f23888a;

    /* renamed from: p  reason: collision with root package name */
    private BigInteger f23889p;

    /* renamed from: q  reason: collision with root package name */
    private BigInteger f23890q;

    /* renamed from: y  reason: collision with root package name */
    private BigInteger f23891y;

    public GOST3410PublicKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f23891y = bigInteger;
        this.f23889p = bigInteger2;
        this.f23890q = bigInteger3;
        this.f23888a = bigInteger4;
    }

    public BigInteger getA() {
        return this.f23888a;
    }

    public BigInteger getP() {
        return this.f23889p;
    }

    public BigInteger getQ() {
        return this.f23890q;
    }

    public BigInteger getY() {
        return this.f23891y;
    }
}
