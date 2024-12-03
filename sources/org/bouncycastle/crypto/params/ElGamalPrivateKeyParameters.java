package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class ElGamalPrivateKeyParameters extends ElGamalKeyParameters {

    /* renamed from: x  reason: collision with root package name */
    private BigInteger f41528x;

    public ElGamalPrivateKeyParameters(BigInteger bigInteger, ElGamalParameters elGamalParameters) {
        super(true, elGamalParameters);
        this.f41528x = bigInteger;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ElGamalPrivateKeyParameters) && ((ElGamalPrivateKeyParameters) obj).getX().equals(this.f41528x)) {
            return super.equals(obj);
        }
        return false;
    }

    public BigInteger getX() {
        return this.f41528x;
    }

    public int hashCode() {
        return getX().hashCode();
    }
}
