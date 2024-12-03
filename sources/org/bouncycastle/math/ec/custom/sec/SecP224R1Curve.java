package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat224;
import org.bouncycastle.util.encoders.Hex;

public class SecP224R1Curve extends ECCurve.AbstractFp {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECP224R1_AFFINE_ZS = {new SecP224R1FieldElement(ECConstants.ONE)};
    private static final int SECP224R1_DEFAULT_COORDS = 2;

    /* renamed from: q  reason: collision with root package name */
    public static final BigInteger f23927q = SecP224R1FieldElement.Q;
    protected SecP224R1Point infinity = new SecP224R1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SecP224R1Curve() {
        super(f23927q);
        this.f23892a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFE")));
        this.f23893b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("B4050A850C04B3ABF54132565044B0B7D7BFD8BA270B39432355FFB4")));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D"));
        this.cofactor = BigInteger.valueOf(1);
        this.coord = 2;
    }

    /* access modifiers changed from: protected */
    public ECCurve cloneCurve() {
        return new SecP224R1Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i10, final int i11) {
        final int[] iArr = new int[(i11 * 7 * 2)];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ECPoint eCPoint = eCPointArr[i10 + i13];
            Nat224.copy(((SecP224R1FieldElement) eCPoint.getRawXCoord()).f23928x, 0, iArr, i12);
            int i14 = i12 + 7;
            Nat224.copy(((SecP224R1FieldElement) eCPoint.getRawYCoord()).f23928x, 0, iArr, i14);
            i12 = i14 + 7;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(int[] iArr, int[] iArr2) {
                return SecP224R1Curve.this.createRawPoint(new SecP224R1FieldElement(iArr), new SecP224R1FieldElement(iArr2), SecP224R1Curve.SECP224R1_AFFINE_ZS);
            }

            public int getSize() {
                return i11;
            }

            public ECPoint lookup(int i10) {
                int[] create = Nat224.create();
                int[] create2 = Nat224.create();
                int i11 = 0;
                for (int i12 = 0; i12 < i11; i12++) {
                    int i13 = ((i12 ^ i10) - 1) >> 31;
                    for (int i14 = 0; i14 < 7; i14++) {
                        int i15 = create[i14];
                        int[] iArr = iArr;
                        create[i14] = i15 ^ (iArr[i11 + i14] & i13);
                        create2[i14] = create2[i14] ^ (iArr[(i11 + 7) + i14] & i13);
                    }
                    i11 += 14;
                }
                return createPoint(create, create2);
            }

            public ECPoint lookupVar(int i10) {
                int[] create = Nat224.create();
                int[] create2 = Nat224.create();
                int i11 = i10 * 7 * 2;
                for (int i12 = 0; i12 < 7; i12++) {
                    int[] iArr = iArr;
                    create[i12] = iArr[i11 + i12];
                    create2[i12] = iArr[i11 + 7 + i12];
                }
                return createPoint(create, create2);
            }
        };
    }

    /* access modifiers changed from: protected */
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP224R1Point(this, eCFieldElement, eCFieldElement2);
    }

    /* access modifiers changed from: protected */
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecP224R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP224R1FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return f23927q.bitLength();
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public BigInteger getQ() {
        return f23927q;
    }

    public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
        int[] create = Nat224.create();
        SecP224R1Field.random(secureRandom, create);
        return new SecP224R1FieldElement(create);
    }

    public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
        int[] create = Nat224.create();
        SecP224R1Field.randomMult(secureRandom, create);
        return new SecP224R1FieldElement(create);
    }

    public boolean supportsCoordinateSystem(int i10) {
        return i10 == 2;
    }
}
