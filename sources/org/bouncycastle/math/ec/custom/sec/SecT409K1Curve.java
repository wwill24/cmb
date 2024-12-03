package org.bouncycastle.math.ec.custom.sec;

import com.withpersona.sdk2.inquiry.network.HttpStatusCode;
import java.math.BigInteger;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.WTauNafMultiplier;
import org.bouncycastle.math.raw.Nat448;
import org.bouncycastle.util.encoders.Hex;

public class SecT409K1Curve extends ECCurve.AbstractF2m {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECT409K1_AFFINE_ZS = {new SecT409FieldElement(ECConstants.ONE)};
    private static final int SECT409K1_DEFAULT_COORDS = 6;
    protected SecT409K1Point infinity = new SecT409K1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SecT409K1Curve() {
        super(HttpStatusCode.CONFLICT_409, 87, 0, 0);
        this.f23892a = fromBigInteger(BigInteger.valueOf(0));
        this.f23893b = fromBigInteger(BigInteger.valueOf(1));
        this.order = new BigInteger(1, Hex.decodeStrict("7FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE5F83B2D4EA20400EC4557D5ED3E3E7CA5B4B5C83B8E01E5FCF"));
        this.cofactor = BigInteger.valueOf(4);
        this.coord = 6;
    }

    /* access modifiers changed from: protected */
    public ECCurve cloneCurve() {
        return new SecT409K1Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i10, final int i11) {
        final long[] jArr = new long[(i11 * 7 * 2)];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ECPoint eCPoint = eCPointArr[i10 + i13];
            Nat448.copy64(((SecT409FieldElement) eCPoint.getRawXCoord()).f23944x, 0, jArr, i12);
            int i14 = i12 + 7;
            Nat448.copy64(((SecT409FieldElement) eCPoint.getRawYCoord()).f23944x, 0, jArr, i14);
            i12 = i14 + 7;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(long[] jArr, long[] jArr2) {
                return SecT409K1Curve.this.createRawPoint(new SecT409FieldElement(jArr), new SecT409FieldElement(jArr2), SecT409K1Curve.SECT409K1_AFFINE_ZS);
            }

            public int getSize() {
                return i11;
            }

            public ECPoint lookup(int i10) {
                long[] create64 = Nat448.create64();
                long[] create642 = Nat448.create64();
                int i11 = 0;
                for (int i12 = 0; i12 < i11; i12++) {
                    long j10 = (long) (((i12 ^ i10) - 1) >> 31);
                    for (int i13 = 0; i13 < 7; i13++) {
                        long j11 = create64[i13];
                        long[] jArr = jArr;
                        create64[i13] = j11 ^ (jArr[i11 + i13] & j10);
                        create642[i13] = create642[i13] ^ (jArr[(i11 + 7) + i13] & j10);
                    }
                    i11 += 14;
                }
                return createPoint(create64, create642);
            }

            public ECPoint lookupVar(int i10) {
                long[] create64 = Nat448.create64();
                long[] create642 = Nat448.create64();
                int i11 = i10 * 7 * 2;
                for (int i12 = 0; i12 < 7; i12++) {
                    long[] jArr = jArr;
                    create64[i12] = jArr[i11 + i12];
                    create642[i12] = jArr[i11 + 7 + i12];
                }
                return createPoint(create64, create642);
            }
        };
    }

    /* access modifiers changed from: protected */
    public ECMultiplier createDefaultMultiplier() {
        return new WTauNafMultiplier();
    }

    /* access modifiers changed from: protected */
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT409K1Point(this, eCFieldElement, eCFieldElement2);
    }

    /* access modifiers changed from: protected */
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecT409K1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT409FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return HttpStatusCode.CONFLICT_409;
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public int getK1() {
        return 87;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return HttpStatusCode.CONFLICT_409;
    }

    public boolean isKoblitz() {
        return true;
    }

    public boolean isTrinomial() {
        return true;
    }

    public boolean supportsCoordinateSystem(int i10) {
        return i10 == 6;
    }
}
