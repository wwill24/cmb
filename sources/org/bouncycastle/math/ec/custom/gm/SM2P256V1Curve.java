package org.bouncycastle.math.ec.custom.gm;

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

public class SM2P256V1Curve extends ECCurve.AbstractFp {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SM2P256V1_AFFINE_ZS = {new SM2P256V1FieldElement(ECConstants.ONE)};
    private static final int SM2P256V1_DEFAULT_COORDS = 2;

    /* renamed from: q  reason: collision with root package name */
    public static final BigInteger f23912q = SM2P256V1FieldElement.Q;
    protected SM2P256V1Point infinity = new SM2P256V1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SM2P256V1Curve() {
        super(f23912q);
        this.f23892a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC")));
        this.f23893b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93")));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123"));
        this.cofactor = BigInteger.valueOf(1);
        this.coord = 2;
    }

    /* access modifiers changed from: protected */
    public ECCurve cloneCurve() {
        return new SM2P256V1Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i10, final int i11) {
        final int[] iArr = new int[(i11 * 8 * 2)];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ECPoint eCPoint = eCPointArr[i10 + i13];
            Nat256.copy(((SM2P256V1FieldElement) eCPoint.getRawXCoord()).f23913x, 0, iArr, i12);
            int i14 = i12 + 8;
            Nat256.copy(((SM2P256V1FieldElement) eCPoint.getRawYCoord()).f23913x, 0, iArr, i14);
            i12 = i14 + 8;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(int[] iArr, int[] iArr2) {
                return SM2P256V1Curve.this.createRawPoint(new SM2P256V1FieldElement(iArr), new SM2P256V1FieldElement(iArr2), SM2P256V1Curve.SM2P256V1_AFFINE_ZS);
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
        return new SM2P256V1Point(this, eCFieldElement, eCFieldElement2);
    }

    /* access modifiers changed from: protected */
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SM2P256V1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SM2P256V1FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return f23912q.bitLength();
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public BigInteger getQ() {
        return f23912q;
    }

    public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
        int[] create = Nat256.create();
        SM2P256V1Field.random(secureRandom, create);
        return new SM2P256V1FieldElement(create);
    }

    public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
        int[] create = Nat256.create();
        SM2P256V1Field.randomMult(secureRandom, create);
        return new SM2P256V1FieldElement(create);
    }

    public boolean supportsCoordinateSystem(int i10) {
        return i10 == 2;
    }
}
