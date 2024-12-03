package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import net.bytebuddy.jar.asm.Opcodes;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.encoders.Hex;

public class SecT193R2Curve extends ECCurve.AbstractF2m {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECT193R2_AFFINE_ZS = {new SecT193FieldElement(ECConstants.ONE)};
    private static final int SECT193R2_DEFAULT_COORDS = 6;
    protected SecT193R2Point infinity = new SecT193R2Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SecT193R2Curve() {
        super(Opcodes.INSTANCEOF, 15, 0, 0);
        this.f23892a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("0163F35A5137C2CE3EA6ED8667190B0BC43ECD69977702709B")));
        this.f23893b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("00C9BB9E8927D4D64C377E2AB2856A5B16E3EFB7F61D4316AE")));
        this.order = new BigInteger(1, Hex.decodeStrict("010000000000000000000000015AAB561B005413CCD4EE99D5"));
        this.cofactor = BigInteger.valueOf(2);
        this.coord = 6;
    }

    /* access modifiers changed from: protected */
    public ECCurve cloneCurve() {
        return new SecT193R2Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i10, final int i11) {
        final long[] jArr = new long[(i11 * 4 * 2)];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ECPoint eCPoint = eCPointArr[i10 + i13];
            Nat256.copy64(((SecT193FieldElement) eCPoint.getRawXCoord()).f23940x, 0, jArr, i12);
            int i14 = i12 + 4;
            Nat256.copy64(((SecT193FieldElement) eCPoint.getRawYCoord()).f23940x, 0, jArr, i14);
            i12 = i14 + 4;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(long[] jArr, long[] jArr2) {
                return SecT193R2Curve.this.createRawPoint(new SecT193FieldElement(jArr), new SecT193FieldElement(jArr2), SecT193R2Curve.SECT193R2_AFFINE_ZS);
            }

            public int getSize() {
                return i11;
            }

            public ECPoint lookup(int i10) {
                long[] create64 = Nat256.create64();
                long[] create642 = Nat256.create64();
                int i11 = 0;
                for (int i12 = 0; i12 < i11; i12++) {
                    long j10 = (long) (((i12 ^ i10) - 1) >> 31);
                    for (int i13 = 0; i13 < 4; i13++) {
                        long j11 = create64[i13];
                        long[] jArr = jArr;
                        create64[i13] = j11 ^ (jArr[i11 + i13] & j10);
                        create642[i13] = create642[i13] ^ (jArr[(i11 + 4) + i13] & j10);
                    }
                    i11 += 8;
                }
                return createPoint(create64, create642);
            }

            public ECPoint lookupVar(int i10) {
                long[] create64 = Nat256.create64();
                long[] create642 = Nat256.create64();
                int i11 = i10 * 4 * 2;
                for (int i12 = 0; i12 < 4; i12++) {
                    long j10 = create64[i12];
                    long[] jArr = jArr;
                    create64[i12] = j10 ^ jArr[i11 + i12];
                    create642[i12] = create642[i12] ^ jArr[(i11 + 4) + i12];
                }
                return createPoint(create64, create642);
            }
        };
    }

    /* access modifiers changed from: protected */
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT193R2Point(this, eCFieldElement, eCFieldElement2);
    }

    /* access modifiers changed from: protected */
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecT193R2Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT193FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return Opcodes.INSTANCEOF;
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public int getK1() {
        return 15;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return Opcodes.INSTANCEOF;
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
