package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class NaccacheSternKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: g  reason: collision with root package name */
    private BigInteger f41543g;
    int lowerSigmaBound;

    /* renamed from: n  reason: collision with root package name */
    private BigInteger f41544n;

    public NaccacheSternKeyParameters(boolean z10, BigInteger bigInteger, BigInteger bigInteger2, int i10) {
        super(z10);
        this.f41543g = bigInteger;
        this.f41544n = bigInteger2;
        this.lowerSigmaBound = i10;
    }

    public BigInteger getG() {
        return this.f41543g;
    }

    public int getLowerSigmaBound() {
        return this.lowerSigmaBound;
    }

    public BigInteger getModulus() {
        return this.f41544n;
    }
}
