package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class DHPrivateKeyParameters extends DHKeyParameters {

    /* renamed from: x  reason: collision with root package name */
    private BigInteger f41512x;

    public DHPrivateKeyParameters(BigInteger bigInteger, DHParameters dHParameters) {
        super(true, dHParameters);
        this.f41512x = bigInteger;
    }

    public boolean equals(Object obj) {
        return (obj instanceof DHPrivateKeyParameters) && ((DHPrivateKeyParameters) obj).getX().equals(this.f41512x) && super.equals(obj);
    }

    public BigInteger getX() {
        return this.f41512x;
    }

    public int hashCode() {
        return this.f41512x.hashCode() ^ super.hashCode();
    }
}
