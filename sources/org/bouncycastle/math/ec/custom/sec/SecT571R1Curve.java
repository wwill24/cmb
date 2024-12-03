package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.encoders.Hex;

public class SecT571R1Curve extends ECCurve.AbstractF2m {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECT571R1_AFFINE_ZS = {new SecT571FieldElement(ECConstants.ONE)};
    private static final int SECT571R1_DEFAULT_COORDS = 6;
    static final SecT571FieldElement SecT571R1_B;
    static final SecT571FieldElement SecT571R1_B_SQRT;
    protected SecT571R1Point infinity = new SecT571R1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    static {
        SecT571FieldElement secT571FieldElement = new SecT571FieldElement(new BigInteger(1, Hex.decodeStrict("02F40E7E2221F295DE297117B7F3D62F5C6A97FFCB8CEFF1CD6BA8CE4A9A18AD84FFABBD8EFA59332BE7AD6756A66E294AFD185A78FF12AA520E4DE739BACA0C7FFEFF7F2955727A")));
        SecT571R1_B = secT571FieldElement;
        SecT571R1_B_SQRT = (SecT571FieldElement) secT571FieldElement.sqrt();
    }

    public SecT571R1Curve() {
        super(571, 2, 5, 10);
        this.f23892a = fromBigInteger(BigInteger.valueOf(1));
        this.f23893b = SecT571R1_B;
        this.order = new BigInteger(1, Hex.decodeStrict("03FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE661CE18FF55987308059B186823851EC7DD9CA1161DE93D5174D66E8382E9BB2FE84E47"));
        this.cofactor = BigInteger.valueOf(2);
        this.coord = 6;
    }

    /* access modifiers changed from: protected */
    public ECCurve cloneCurve() {
        return new SecT571R1Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i10, final int i11) {
        final long[] jArr = new long[(i11 * 9 * 2)];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ECPoint eCPoint = eCPointArr[i10 + i13];
            Nat576.copy64(((SecT571FieldElement) eCPoint.getRawXCoord()).f23945x, 0, jArr, i12);
            int i14 = i12 + 9;
            Nat576.copy64(((SecT571FieldElement) eCPoint.getRawYCoord()).f23945x, 0, jArr, i14);
            i12 = i14 + 9;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(long[] jArr, long[] jArr2) {
                return SecT571R1Curve.this.createRawPoint(new SecT571FieldElement(jArr), new SecT571FieldElement(jArr2), SecT571R1Curve.SECT571R1_AFFINE_ZS);
            }

            public int getSize() {
                return i11;
            }

            public ECPoint lookup(int i10) {
                long[] create64 = Nat576.create64();
                long[] create642 = Nat576.create64();
                int i11 = 0;
                for (int i12 = 0; i12 < i11; i12++) {
                    long j10 = (long) (((i12 ^ i10) - 1) >> 31);
                    for (int i13 = 0; i13 < 9; i13++) {
                        long j11 = create64[i13];
                        long[] jArr = jArr;
                        create64[i13] = j11 ^ (jArr[i11 + i13] & j10);
                        create642[i13] = create642[i13] ^ (jArr[(i11 + 9) + i13] & j10);
                    }
                    i11 += 18;
                }
                return createPoint(create64, create642);
            }

            public ECPoint lookupVar(int i10) {
                long[] create64 = Nat576.create64();
                long[] create642 = Nat576.create64();
                int i11 = i10 * 9 * 2;
                for (int i12 = 0; i12 < 9; i12++) {
                    long[] jArr = jArr;
                    create64[i12] = jArr[i11 + i12];
                    create642[i12] = jArr[i11 + 9 + i12];
                }
                return createPoint(create64, create642);
            }
        };
    }

    /* access modifiers changed from: protected */
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT571R1Point(this, eCFieldElement, eCFieldElement2);
    }

    /* access modifiers changed from: protected */
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecT571R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT571FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return 571;
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public int getK1() {
        return 2;
    }

    public int getK2() {
        return 5;
    }

    public int getK3() {
        return 10;
    }

    public int getM() {
        return 571;
    }

    public boolean isKoblitz() {
        return false;
    }

    public boolean isTrinomial() {
        return false;
    }

    public boolean supportsCoordinateSystem(int i10) {
        return i10 == 6;
    }
}
