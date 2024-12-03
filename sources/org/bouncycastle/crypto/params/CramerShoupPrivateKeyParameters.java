package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class CramerShoupPrivateKeyParameters extends CramerShoupKeyParameters {

    /* renamed from: pk  reason: collision with root package name */
    private CramerShoupPublicKeyParameters f41497pk;

    /* renamed from: x1  reason: collision with root package name */
    private BigInteger f41498x1;

    /* renamed from: x2  reason: collision with root package name */
    private BigInteger f41499x2;

    /* renamed from: y1  reason: collision with root package name */
    private BigInteger f41500y1;

    /* renamed from: y2  reason: collision with root package name */
    private BigInteger f41501y2;

    /* renamed from: z  reason: collision with root package name */
    private BigInteger f41502z;

    public CramerShoupPrivateKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
        super(true, cramerShoupParameters);
        this.f41498x1 = bigInteger;
        this.f41499x2 = bigInteger2;
        this.f41500y1 = bigInteger3;
        this.f41501y2 = bigInteger4;
        this.f41502z = bigInteger5;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupPrivateKeyParameters)) {
            return false;
        }
        CramerShoupPrivateKeyParameters cramerShoupPrivateKeyParameters = (CramerShoupPrivateKeyParameters) obj;
        return cramerShoupPrivateKeyParameters.getX1().equals(this.f41498x1) && cramerShoupPrivateKeyParameters.getX2().equals(this.f41499x2) && cramerShoupPrivateKeyParameters.getY1().equals(this.f41500y1) && cramerShoupPrivateKeyParameters.getY2().equals(this.f41501y2) && cramerShoupPrivateKeyParameters.getZ().equals(this.f41502z) && super.equals(obj);
    }

    public CramerShoupPublicKeyParameters getPk() {
        return this.f41497pk;
    }

    public BigInteger getX1() {
        return this.f41498x1;
    }

    public BigInteger getX2() {
        return this.f41499x2;
    }

    public BigInteger getY1() {
        return this.f41500y1;
    }

    public BigInteger getY2() {
        return this.f41501y2;
    }

    public BigInteger getZ() {
        return this.f41502z;
    }

    public int hashCode() {
        return ((((this.f41498x1.hashCode() ^ this.f41499x2.hashCode()) ^ this.f41500y1.hashCode()) ^ this.f41501y2.hashCode()) ^ this.f41502z.hashCode()) ^ super.hashCode();
    }

    public void setPk(CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters) {
        this.f41497pk = cramerShoupPublicKeyParameters;
    }
}
