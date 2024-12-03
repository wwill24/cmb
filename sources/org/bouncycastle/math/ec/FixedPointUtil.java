package org.bouncycastle.math.ec;

import java.math.BigInteger;

public class FixedPointUtil {
    public static final String PRECOMP_NAME = "bc_fixed_point";

    public static int getCombSize(ECCurve eCCurve) {
        BigInteger order = eCCurve.getOrder();
        return order == null ? eCCurve.getFieldSize() + 1 : order.bitLength();
    }

    public static FixedPointPreCompInfo getFixedPointPreCompInfo(PreCompInfo preCompInfo) {
        if (preCompInfo instanceof FixedPointPreCompInfo) {
            return (FixedPointPreCompInfo) preCompInfo;
        }
        return null;
    }

    public static FixedPointPreCompInfo precompute(final ECPoint eCPoint) {
        final ECCurve curve = eCPoint.getCurve();
        return (FixedPointPreCompInfo) curve.precompute(eCPoint, PRECOMP_NAME, new PreCompCallback() {
            private boolean checkExisting(FixedPointPreCompInfo fixedPointPreCompInfo, int i10) {
                return fixedPointPreCompInfo != null && checkTable(fixedPointPreCompInfo.getLookupTable(), i10);
            }

            private boolean checkTable(ECLookupTable eCLookupTable, int i10) {
                return eCLookupTable != null && eCLookupTable.getSize() >= i10;
            }

            public PreCompInfo precompute(PreCompInfo preCompInfo) {
                FixedPointPreCompInfo fixedPointPreCompInfo = preCompInfo instanceof FixedPointPreCompInfo ? (FixedPointPreCompInfo) preCompInfo : null;
                int combSize = FixedPointUtil.getCombSize(curve);
                int i10 = combSize > 250 ? 6 : 5;
                int i11 = 1 << i10;
                if (checkExisting(fixedPointPreCompInfo, i11)) {
                    return fixedPointPreCompInfo;
                }
                int i12 = ((combSize + i10) - 1) / i10;
                ECPoint[] eCPointArr = new ECPoint[(i10 + 1)];
                eCPointArr[0] = eCPoint;
                for (int i13 = 1; i13 < i10; i13++) {
                    eCPointArr[i13] = eCPointArr[i13 - 1].timesPow2(i12);
                }
                eCPointArr[i10] = eCPointArr[0].subtract(eCPointArr[1]);
                curve.normalizeAll(eCPointArr);
                ECPoint[] eCPointArr2 = new ECPoint[i11];
                eCPointArr2[0] = eCPointArr[0];
                for (int i14 = i10 - 1; i14 >= 0; i14--) {
                    ECPoint eCPoint = eCPointArr[i14];
                    int i15 = 1 << i14;
                    for (int i16 = i15; i16 < i11; i16 += i15 << 1) {
                        eCPointArr2[i16] = eCPointArr2[i16 - i15].add(eCPoint);
                    }
                }
                curve.normalizeAll(eCPointArr2);
                FixedPointPreCompInfo fixedPointPreCompInfo2 = new FixedPointPreCompInfo();
                fixedPointPreCompInfo2.setLookupTable(curve.createCacheSafeLookupTable(eCPointArr2, 0, i11));
                fixedPointPreCompInfo2.setOffset(eCPointArr[i10]);
                fixedPointPreCompInfo2.setWidth(i10);
                return fixedPointPreCompInfo2;
            }
        });
    }
}
