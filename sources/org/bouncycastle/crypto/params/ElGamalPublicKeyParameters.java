package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class ElGamalPublicKeyParameters extends ElGamalKeyParameters {

    /* renamed from: y  reason: collision with root package name */
    private BigInteger f41529y;

    public ElGamalPublicKeyParameters(BigInteger bigInteger, ElGamalParameters elGamalParameters) {
        super(false, elGamalParameters);
        this.f41529y = bigInteger;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ElGamalPublicKeyParameters) && ((ElGamalPublicKeyParameters) obj).getY().equals(this.f41529y) && super.equals(obj);
    }

    public BigInteger getY() {
        return this.f41529y;
    }

    public int hashCode() {
        return this.f41529y.hashCode() ^ super.hashCode();
    }
}
