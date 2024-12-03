package org.bouncycastle.crypto.prng.drbg;

import org.bouncycastle.math.ec.ECPoint;

public class DualECPoints {
    private final int cofactor;

    /* renamed from: p  reason: collision with root package name */
    private final ECPoint f41552p;

    /* renamed from: q  reason: collision with root package name */
    private final ECPoint f41553q;
    private final int securityStrength;

    public DualECPoints(int i10, ECPoint eCPoint, ECPoint eCPoint2, int i11) {
        if (eCPoint.getCurve().equals(eCPoint2.getCurve())) {
            this.securityStrength = i10;
            this.f41552p = eCPoint;
            this.f41553q = eCPoint2;
            this.cofactor = i11;
            return;
        }
        throw new IllegalArgumentException("points need to be on the same curve");
    }

    private static int log2(int i10) {
        int i11 = 0;
        while (true) {
            i10 >>= 1;
            if (i10 == 0) {
                return i11;
            }
            i11++;
        }
    }

    public int getCofactor() {
        return this.cofactor;
    }

    public int getMaxOutlen() {
        return ((this.f41552p.getCurve().getFieldSize() - (log2(this.cofactor) + 13)) / 8) * 8;
    }

    public ECPoint getP() {
        return this.f41552p;
    }

    public ECPoint getQ() {
        return this.f41553q;
    }

    public int getSecurityStrength() {
        return this.securityStrength;
    }

    public int getSeedLen() {
        return this.f41552p.getCurve().getFieldSize();
    }
}
