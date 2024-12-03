package org.bouncycastle.crypto.ec;

import org.bouncycastle.math.ec.ECPoint;

public class ECPair {

    /* renamed from: x  reason: collision with root package name */
    private final ECPoint f41400x;

    /* renamed from: y  reason: collision with root package name */
    private final ECPoint f41401y;

    public ECPair(ECPoint eCPoint, ECPoint eCPoint2) {
        this.f41400x = eCPoint;
        this.f41401y = eCPoint2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ECPair) {
            return equals((ECPair) obj);
        }
        return false;
    }

    public boolean equals(ECPair eCPair) {
        return eCPair.getX().equals(getX()) && eCPair.getY().equals(getY());
    }

    public ECPoint getX() {
        return this.f41400x;
    }

    public ECPoint getY() {
        return this.f41401y;
    }

    public int hashCode() {
        return this.f41400x.hashCode() + (this.f41401y.hashCode() * 37);
    }
}
