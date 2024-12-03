package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

public class ElGamalParameters implements CipherParameters {

    /* renamed from: g  reason: collision with root package name */
    private BigInteger f41525g;

    /* renamed from: l  reason: collision with root package name */
    private int f41526l;

    /* renamed from: p  reason: collision with root package name */
    private BigInteger f41527p;

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, 0);
    }

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2, int i10) {
        this.f41525g = bigInteger2;
        this.f41527p = bigInteger;
        this.f41526l = i10;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ElGamalParameters)) {
            return false;
        }
        ElGamalParameters elGamalParameters = (ElGamalParameters) obj;
        return elGamalParameters.getP().equals(this.f41527p) && elGamalParameters.getG().equals(this.f41525g) && elGamalParameters.getL() == this.f41526l;
    }

    public BigInteger getG() {
        return this.f41525g;
    }

    public int getL() {
        return this.f41526l;
    }

    public BigInteger getP() {
        return this.f41527p;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) + this.f41526l;
    }
}
