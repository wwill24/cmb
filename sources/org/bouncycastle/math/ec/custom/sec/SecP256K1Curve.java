package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.encoders.Hex;

public class SecP256K1Curve extends ECCurve.AbstractFp {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECP256K1_AFFINE_ZS = {new SecP256K1FieldElement(ECConstants.ONE)};
    private static final int SECP256K1_DEFAULT_COORDS = 2;

    /* renamed from: q  reason: collision with root package name */
    public static final BigInteger f23929q = SecP256K1FieldElement.Q;
    protected SecP256K1Point infinity = new SecP256K1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SecP256K1Curve() {
        super(f23929q);
        this.f23892a = fromBigInteger(ECConstants.ZERO);
        this.f23893b = fromBigInteger(BigInteger.valueOf(7));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141"));
        this.cofactor = BigInteger.valueOf(1);
        this.coord = 2;
    }

    /* access modifiers changed from: protected */
    public ECCurve cloneCurve() {
        return new SecP256K1Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i10, final int i11) {
        final int[] iArr = new int[(i11 * 8 * 2)];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ECPoint eCPoint = eCPointArr[i10 + i13];
            Nat256.copy(((SecP256K1FieldElement) eCPoint.getRawXCoord()).f23930x, 0, iArr, i12);
            int i14 = i12 + 8;
            Nat256.copy(((SecP256K1FieldElement) eCPoint.getRawYCoord()).f23930x, 0, iArr, i14);
            i12 = i14 + 8;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(int[] iArr, int[] iArr2) {
                return SecP256K1Curve.this.createRawPoint(new SecP256K1FieldElement(iArr), new SecP256K1FieldElement(iArr2), SecP256K1Curve.SECP256K1_AFFINE_ZS);
            }

            public int getSize() {
                return i11;
            }

            public ECPoint lookup(int i10) {
                int[] create = Nat256.create();
                int[] create2 = Nat256.create();
                int i11 = 0;
                for (int i12 = 0; i12 < i11; i12++) {
                    int i13 = ((i12 ^ i10) - 1) >> 31;
                    for (int i14 = 0; i14 < 8; i14++) {
                        int i15 = create[i14];
                        int[] iArr = iArr;
                        create[i14] = i15 ^ (iArr[i11 + i14] & i13);
                        create2[i14] = create2[i14] ^ (iArr[(i11 + 8) + i14] & i13);
                    }
                    i11 += 16;
                }
                return createPoint(create, create2);
            }

            public ECPoint lookupVar(int i10) {
                int[] create = Nat256.create();
                int[] create2 = Nat256.create();
                int i11 = i10 * 8 * 2;
                for (int i12 = 0; i12 < 8; i12++) {
                    int[] iArr = iArr;
                    create[i12] = iArr[i11 + i12];
                    create2[i12] = iArr[i11 + 8 + i12];
                }
                return createPoint(create, create2);
            }
        };
    }

    /* access modifiers changed from: protected */
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP256K1Point(this, eCFieldElement, eCFieldElement2);
    }

    /* access modifiers changed from: protected */
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecP256K1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP256K1FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return f23929q.bitLength();
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public BigInteger getQ() {
        return f23929q;
    }

    public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
        int[] create = Nat256.create();
        SecP256K1Field.random(secureRandom, create);
        return new SecP256K1FieldElement(create);
    }

    public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
        int[] create = Nat256.create();
        SecP256K1Field.randomMult(secureRandom, create);
        return new SecP256K1FieldElement(create);
    }

    public boolean supportsCoordinateSystem(int i10) {
        return i10 == 2;
    }
}
