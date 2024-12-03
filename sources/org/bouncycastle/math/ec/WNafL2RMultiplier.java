package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.util.Integers;

public class WNafL2RMultiplier extends AbstractECMultiplier {
    /* access modifiers changed from: protected */
    public ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger) {
        ECPoint eCPoint2;
        WNafPreCompInfo precompute = WNafUtil.precompute(eCPoint, WNafUtil.getWindowSize(bigInteger.bitLength()), true);
        ECPoint[] preComp = precompute.getPreComp();
        ECPoint[] preCompNeg = precompute.getPreCompNeg();
        int width = precompute.getWidth();
        int[] generateCompactWindowNaf = WNafUtil.generateCompactWindowNaf(width, bigInteger);
        ECPoint infinity = eCPoint.getCurve().getInfinity();
        int length = generateCompactWindowNaf.length;
        if (length > 1) {
            length--;
            int i10 = generateCompactWindowNaf[length];
            int i11 = i10 >> 16;
            int i12 = i10 & 65535;
            int abs = Math.abs(i11);
            ECPoint[] eCPointArr = i11 < 0 ? preCompNeg : preComp;
            if ((abs << 2) < (1 << width)) {
                int numberOfLeadingZeros = 32 - Integers.numberOfLeadingZeros(abs);
                int i13 = width - numberOfLeadingZeros;
                eCPoint2 = eCPointArr[((1 << (width - 1)) - 1) >>> 1].add(eCPointArr[(((abs ^ (1 << (numberOfLeadingZeros - 1))) << i13) + 1) >>> 1]);
                i12 -= i13;
            } else {
                eCPoint2 = eCPointArr[abs >>> 1];
            }
            infinity = eCPoint2.timesPow2(i12);
        }
        while (length > 0) {
            length--;
            int i14 = generateCompactWindowNaf[length];
            int i15 = i14 >> 16;
            infinity = infinity.twicePlus((i15 < 0 ? preCompNeg : preComp)[Math.abs(i15) >>> 1]).timesPow2(i14 & 65535);
        }
        return infinity;
    }
}
