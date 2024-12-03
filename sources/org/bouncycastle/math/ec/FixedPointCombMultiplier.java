package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Nat;

public class FixedPointCombMultiplier extends AbstractECMultiplier {
    /* access modifiers changed from: protected */
    public ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger) {
        ECCurve curve = eCPoint.getCurve();
        int combSize = FixedPointUtil.getCombSize(curve);
        if (bigInteger.bitLength() <= combSize) {
            FixedPointPreCompInfo precompute = FixedPointUtil.precompute(eCPoint);
            ECLookupTable lookupTable = precompute.getLookupTable();
            int width = precompute.getWidth();
            int i10 = ((combSize + width) - 1) / width;
            ECPoint infinity = curve.getInfinity();
            int i11 = width * i10;
            int[] fromBigInteger = Nat.fromBigInteger(i11, bigInteger);
            int i12 = i11 - 1;
            for (int i13 = 0; i13 < i10; i13++) {
                int i14 = 0;
                for (int i15 = i12 - i13; i15 >= 0; i15 -= i10) {
                    int i16 = fromBigInteger[i15 >>> 5] >>> (i15 & 31);
                    i14 = ((i14 ^ (i16 >>> 1)) << 1) ^ i16;
                }
                infinity = infinity.twicePlus(lookupTable.lookup(i14));
            }
            return infinity.add(precompute.getOffset());
        }
        throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
    }
}
