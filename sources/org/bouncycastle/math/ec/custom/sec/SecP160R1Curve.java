package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat160;
import org.bouncycastle.util.encoders.Hex;

public class SecP160R1Curve extends ECCurve.AbstractFp {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECP160R1_AFFINE_ZS = {new SecP160R1FieldElement(ECConstants.ONE)};
    private static final int SECP160R1_DEFAULT_COORDS = 2;

    /* renamed from: q  reason: collision with root package name */
    public static final BigInteger f23917q = SecP160R1FieldElement.Q;
    protected SecP160R1Point infinity = new SecP160R1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SecP160R1Curve() {
        super(f23917q);
        this.f23892a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFC")));
        this.f23893b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("1C97BEFC54BD7A8B65ACF89F81D4D4ADC565FA45")));
        this.order = new BigInteger(1, Hex.decodeStrict("0100000000000000000001F4C8F927AED3CA752257"));
        this.cofactor = BigInteger.valueOf(1);
        this.coord = 2;
    }

    /* access modifiers changed from: protected */
    public ECCurve cloneCurve() {
        return new SecP160R1Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i10, final int i11) {
        final int[] iArr = new int[(i11 * 5 * 2)];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ECPoint eCPoint = eCPointArr[i10 + i13];
            Nat160.copy(((SecP160R1FieldElement) eCPoint.getRawXCoord()).f23918x, 0, iArr, i12);
            int i14 = i12 + 5;
            Nat160.copy(((SecP160R1FieldElement) eCPoint.getRawYCoord()).f23918x, 0, iArr, i14);
            i12 = i14 + 5;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(int[] iArr, int[] iArr2) {
                return SecP160R1Curve.this.createRawPoint(new SecP160R1FieldElement(iArr), new SecP160R1FieldElement(iArr2), SecP160R1Curve.SECP160R1_AFFINE_ZS);
            }

            public int getSize() {
                return i11;
            }

            public ECPoint lookup(int i10) {
                int[] create = Nat160.create();
                int[] create2 = Nat160.create();
                int i11 = 0;
                for (int i12 = 0; i12 < i11; i12++) {
                    int i13 = ((i12 ^ i10) - 1) >> 31;
                    for (int i14 = 0; i14 < 5; i14++) {
                        int i15 = create[i14];
                        int[] iArr = iArr;
                        create[i14] = i15 ^ (iArr[i11 + i14] & i13);
                        create2[i14] = create2[i14] ^ (iArr[(i11 + 5) + i14] & i13);
                    }
                    i11 += 10;
                }
                return createPoint(create, create2);
            }

            public ECPoint lookupVar(int i10) {
                int[] create = Nat160.create();
                int[] create2 = Nat160.create();
                int i11 = i10 * 5 * 2;
                for (int i12 = 0; i12 < 5; i12++) {
                    int[] iArr = iArr;
                    create[i12] = iArr[i11 + i12];
                    create2[i12] = iArr[i11 + 5 + i12];
                }
                return createPoint(create, create2);
            }
        };
    }

    /* access modifiers changed from: protected */
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP160R1Point(this, eCFieldElement, eCFieldElement2);
    }

    /* access modifiers changed from: protected */
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecP160R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP160R1FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return f23917q.bitLength();
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public BigInteger getQ() {
        return f23917q;
    }

    public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
        int[] create = Nat160.create();
        SecP160R1Field.random(secureRandom, create);
        return new SecP160R1FieldElement(create);
    }

    public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
        int[] create = Nat160.create();
        SecP160R1Field.randomMult(secureRandom, create);
        return new SecP160R1FieldElement(create);
    }

    public boolean supportsCoordinateSystem(int i10) {
        return i10 == 2;
    }
}
