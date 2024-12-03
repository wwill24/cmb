package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class RSAPrivateCrtKeyParameters extends RSAKeyParameters {
    private BigInteger dP;
    private BigInteger dQ;

    /* renamed from: e  reason: collision with root package name */
    private BigInteger f41546e;

    /* renamed from: p  reason: collision with root package name */
    private BigInteger f41547p;

    /* renamed from: q  reason: collision with root package name */
    private BigInteger f41548q;
    private BigInteger qInv;

    public RSAPrivateCrtKeyParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        super(true, bigInteger, bigInteger3);
        this.f41546e = bigInteger2;
        this.f41547p = bigInteger4;
        this.f41548q = bigInteger5;
        this.dP = bigInteger6;
        this.dQ = bigInteger7;
        this.qInv = bigInteger8;
    }

    public BigInteger getDP() {
        return this.dP;
    }

    public BigInteger getDQ() {
        return this.dQ;
    }

    public BigInteger getP() {
        return this.f41547p;
    }

    public BigInteger getPublicExponent() {
        return this.f41546e;
    }

    public BigInteger getQ() {
        return this.f41548q;
    }

    public BigInteger getQInv() {
        return this.qInv;
    }
}
