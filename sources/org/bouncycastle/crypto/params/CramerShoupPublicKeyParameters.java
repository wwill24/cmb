package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class CramerShoupPublicKeyParameters extends CramerShoupKeyParameters {

    /* renamed from: c  reason: collision with root package name */
    private BigInteger f41503c;

    /* renamed from: d  reason: collision with root package name */
    private BigInteger f41504d;

    /* renamed from: h  reason: collision with root package name */
    private BigInteger f41505h;

    public CramerShoupPublicKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        super(false, cramerShoupParameters);
        this.f41503c = bigInteger;
        this.f41504d = bigInteger2;
        this.f41505h = bigInteger3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupPublicKeyParameters)) {
            return false;
        }
        CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters = (CramerShoupPublicKeyParameters) obj;
        return cramerShoupPublicKeyParameters.getC().equals(this.f41503c) && cramerShoupPublicKeyParameters.getD().equals(this.f41504d) && cramerShoupPublicKeyParameters.getH().equals(this.f41505h) && super.equals(obj);
    }

    public BigInteger getC() {
        return this.f41503c;
    }

    public BigInteger getD() {
        return this.f41504d;
    }

    public BigInteger getH() {
        return this.f41505h;
    }

    public int hashCode() {
        return ((this.f41503c.hashCode() ^ this.f41504d.hashCode()) ^ this.f41505h.hashCode()) ^ super.hashCode();
    }
}
