package org.bouncycastle.jce.spec;

import java.math.BigInteger;

public class GOST3410PublicKeyParameterSetSpec {

    /* renamed from: a  reason: collision with root package name */
    private BigInteger f23885a;

    /* renamed from: p  reason: collision with root package name */
    private BigInteger f23886p;

    /* renamed from: q  reason: collision with root package name */
    private BigInteger f23887q;

    public GOST3410PublicKeyParameterSetSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f23886p = bigInteger;
        this.f23887q = bigInteger2;
        this.f23885a = bigInteger3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410PublicKeyParameterSetSpec)) {
            return false;
        }
        GOST3410PublicKeyParameterSetSpec gOST3410PublicKeyParameterSetSpec = (GOST3410PublicKeyParameterSetSpec) obj;
        return this.f23885a.equals(gOST3410PublicKeyParameterSetSpec.f23885a) && this.f23886p.equals(gOST3410PublicKeyParameterSetSpec.f23886p) && this.f23887q.equals(gOST3410PublicKeyParameterSetSpec.f23887q);
    }

    public BigInteger getA() {
        return this.f23885a;
    }

    public BigInteger getP() {
        return this.f23886p;
    }

    public BigInteger getQ() {
        return this.f23887q;
    }

    public int hashCode() {
        return (this.f23885a.hashCode() ^ this.f23886p.hashCode()) ^ this.f23887q.hashCode();
    }
}
