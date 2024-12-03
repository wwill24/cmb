package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat128;
import org.bouncycastle.util.encoders.Hex;

public class SecT113R1Curve extends ECCurve.AbstractF2m {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECT113R1_AFFINE_ZS = {new SecT113FieldElement(ECConstants.ONE)};
    private static final int SECT113R1_DEFAULT_COORDS = 6;
    protected SecT113R1Point infinity = new SecT113R1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SecT113R1Curve() {
        super(113, 9, 0, 0);
        this.f23892a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("003088250CA6E7C7FE649CE85820F7")));
        this.f23893b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("00E8BEE4D3E2260744188BE0E9C723")));
        this.order = new BigInteger(1, Hex.decodeStrict("0100000000000000D9CCEC8A39E56F"));
        this.cofactor = BigInteger.valueOf(2);
        this.coord = 6;
    }

    /* access modifiers changed from: protected */
    public ECCurve cloneCurve() {
        return new SecT113R1Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i10, final int i11) {
        final long[] jArr = new long[(i11 * 2 * 2)];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ECPoint eCPoint = eCPointArr[i10 + i13];
            Nat128.copy64(((SecT113FieldElement) eCPoint.getRawXCoord()).f23937x, 0, jArr, i12);
            int i14 = i12 + 2;
            Nat128.copy64(((SecT113FieldElement) eCPoint.getRawYCoord()).f23937x, 0, jArr, i14);
            i12 = i14 + 2;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(long[] jArr, long[] jArr2) {
                return SecT113R1Curve.this.createRawPoint(new SecT113FieldElement(jArr), new SecT113FieldElement(jArr2), SecT113R1Curve.SECT113R1_AFFINE_ZS);
            }

            public int getSize() {
                return i11;
            }

            public ECPoint lookup(int i10) {
                long[] create64 = Nat128.create64();
                long[] create642 = Nat128.create64();
                int i11 = 0;
                for (int i12 = 0; i12 < i11; i12++) {
                    long j10 = (long) (((i12 ^ i10) - 1) >> 31);
                    for (int i13 = 0; i13 < 2; i13++) {
                        long j11 = create64[i13];
                        long[] jArr = jArr;
                        create64[i13] = j11 ^ (jArr[i11 + i13] & j10);
                        create642[i13] = create642[i13] ^ (jArr[(i11 + 2) + i13] & j10);
                    }
                    i11 += 4;
                }
                return createPoint(create64, create642);
            }

            public ECPoint lookupVar(int i10) {
                long[] create64 = Nat128.create64();
                long[] create642 = Nat128.create64();
                int i11 = i10 * 2 * 2;
                for (int i12 = 0; i12 < 2; i12++) {
                    long[] jArr = jArr;
                    create64[i12] = jArr[i11 + i12];
                    create642[i12] = jArr[i11 + 2 + i12];
                }
                return createPoint(create64, create642);
            }
        };
    }

    /* access modifiers changed from: protected */
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT113R1Point(this, eCFieldElement, eCFieldElement2);
    }

    /* access modifiers changed from: protected */
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecT113R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT113FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return 113;
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public int getK1() {
        return 9;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return 113;
    }

    public boolean isKoblitz() {
        return false;
    }

    public boolean isTrinomial() {
        return true;
    }

    public boolean supportsCoordinateSystem(int i10) {
        return i10 == 6;
    }
}
