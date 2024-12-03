package org.bouncycastle.math.ec;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.Random;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.endo.ECEndomorphism;
import org.bouncycastle.math.ec.endo.GLVEndomorphism;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.FiniteFields;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Integers;

public abstract class ECCurve {
    public static final int COORD_AFFINE = 0;
    public static final int COORD_HOMOGENEOUS = 1;
    public static final int COORD_JACOBIAN = 2;
    public static final int COORD_JACOBIAN_CHUDNOVSKY = 3;
    public static final int COORD_JACOBIAN_MODIFIED = 4;
    public static final int COORD_LAMBDA_AFFINE = 5;
    public static final int COORD_LAMBDA_PROJECTIVE = 6;
    public static final int COORD_SKEWED = 7;

    /* renamed from: a  reason: collision with root package name */
    protected ECFieldElement f23892a;

    /* renamed from: b  reason: collision with root package name */
    protected ECFieldElement f23893b;
    protected BigInteger cofactor;
    protected int coord = 0;
    protected ECEndomorphism endomorphism = null;
    protected FiniteField field;
    protected ECMultiplier multiplier = null;
    protected BigInteger order;

    public static abstract class AbstractF2m extends ECCurve {

        /* renamed from: si  reason: collision with root package name */
        private BigInteger[] f23894si = null;

        protected AbstractF2m(int i10, int i11, int i12, int i13) {
            super(buildField(i10, i11, i12, i13));
        }

        private static FiniteField buildField(int i10, int i11, int i12, int i13) {
            if (i11 == 0) {
                throw new IllegalArgumentException("k1 must be > 0");
            } else if (i12 == 0) {
                if (i13 == 0) {
                    return FiniteFields.getBinaryExtensionField(new int[]{0, i11, i10});
                }
                throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
            } else if (i12 <= i11) {
                throw new IllegalArgumentException("k2 must be > k1");
            } else if (i13 > i12) {
                return FiniteFields.getBinaryExtensionField(new int[]{0, i11, i12, i13, i10});
            } else {
                throw new IllegalArgumentException("k3 must be > k2");
            }
        }

        private static BigInteger implRandomFieldElementMult(SecureRandom secureRandom, int i10) {
            BigInteger createRandomBigInteger;
            do {
                createRandomBigInteger = BigIntegers.createRandomBigInteger(i10, secureRandom);
            } while (createRandomBigInteger.signum() <= 0);
            return createRandomBigInteger;
        }

        public static BigInteger inverse(int i10, int[] iArr, BigInteger bigInteger) {
            return new LongArray(bigInteger).modInverse(i10, iArr).toBigInteger();
        }

        public ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2) {
            ECFieldElement fromBigInteger = fromBigInteger(bigInteger);
            ECFieldElement fromBigInteger2 = fromBigInteger(bigInteger2);
            int coordinateSystem = getCoordinateSystem();
            if (coordinateSystem == 5 || coordinateSystem == 6) {
                if (!fromBigInteger.isZero()) {
                    fromBigInteger2 = fromBigInteger2.divide(fromBigInteger).add(fromBigInteger);
                } else if (!fromBigInteger2.square().equals(getB())) {
                    throw new IllegalArgumentException();
                }
            }
            return createRawPoint(fromBigInteger, fromBigInteger2);
        }

        /* access modifiers changed from: protected */
        public ECPoint decompressPoint(int i10, BigInteger bigInteger) {
            ECFieldElement eCFieldElement;
            ECFieldElement fromBigInteger = fromBigInteger(bigInteger);
            if (fromBigInteger.isZero()) {
                eCFieldElement = getB().sqrt();
            } else {
                ECFieldElement solveQuadraticEquation = solveQuadraticEquation(fromBigInteger.square().invert().multiply(getB()).add(getA()).add(fromBigInteger));
                if (solveQuadraticEquation != null) {
                    boolean testBitZero = solveQuadraticEquation.testBitZero();
                    boolean z10 = true;
                    if (i10 != 1) {
                        z10 = false;
                    }
                    if (testBitZero != z10) {
                        solveQuadraticEquation = solveQuadraticEquation.addOne();
                    }
                    int coordinateSystem = getCoordinateSystem();
                    eCFieldElement = (coordinateSystem == 5 || coordinateSystem == 6) ? solveQuadraticEquation.add(fromBigInteger) : solveQuadraticEquation.multiply(fromBigInteger);
                } else {
                    eCFieldElement = null;
                }
            }
            if (eCFieldElement != null) {
                return createRawPoint(fromBigInteger, eCFieldElement);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }

        /* access modifiers changed from: package-private */
        public synchronized BigInteger[] getSi() {
            if (this.f23894si == null) {
                this.f23894si = Tnaf.getSi(this);
            }
            return this.f23894si;
        }

        public boolean isKoblitz() {
            return this.order != null && this.cofactor != null && this.f23893b.isOne() && (this.f23892a.isZero() || this.f23892a.isOne());
        }

        public boolean isValidFieldElement(BigInteger bigInteger) {
            return bigInteger != null && bigInteger.signum() >= 0 && bigInteger.bitLength() <= getFieldSize();
        }

        public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
            return fromBigInteger(BigIntegers.createRandomBigInteger(getFieldSize(), secureRandom));
        }

        public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
            int fieldSize = getFieldSize();
            return fromBigInteger(implRandomFieldElementMult(secureRandom, fieldSize)).multiply(fromBigInteger(implRandomFieldElementMult(secureRandom, fieldSize)));
        }

        /* access modifiers changed from: protected */
        public ECFieldElement solveQuadraticEquation(ECFieldElement eCFieldElement) {
            ECFieldElement eCFieldElement2;
            ECFieldElement.AbstractF2m abstractF2m = (ECFieldElement.AbstractF2m) eCFieldElement;
            boolean hasFastTrace = abstractF2m.hasFastTrace();
            if (hasFastTrace && abstractF2m.trace() != 0) {
                return null;
            }
            int fieldSize = getFieldSize();
            if ((fieldSize & 1) != 0) {
                ECFieldElement halfTrace = abstractF2m.halfTrace();
                if (hasFastTrace || halfTrace.square().add(halfTrace).add(eCFieldElement).isZero()) {
                    return halfTrace;
                }
                return null;
            } else if (eCFieldElement.isZero()) {
                return eCFieldElement;
            } else {
                ECFieldElement fromBigInteger = fromBigInteger(ECConstants.ZERO);
                Random random = new Random();
                do {
                    ECFieldElement fromBigInteger2 = fromBigInteger(new BigInteger(fieldSize, random));
                    ECFieldElement eCFieldElement3 = eCFieldElement;
                    eCFieldElement2 = fromBigInteger;
                    for (int i10 = 1; i10 < fieldSize; i10++) {
                        ECFieldElement square = eCFieldElement3.square();
                        eCFieldElement2 = eCFieldElement2.square().add(square.multiply(fromBigInteger2));
                        eCFieldElement3 = square.add(eCFieldElement);
                    }
                    if (!eCFieldElement3.isZero()) {
                        return null;
                    }
                } while (eCFieldElement2.square().add(eCFieldElement2).isZero());
                return eCFieldElement2;
            }
        }
    }

    public static abstract class AbstractFp extends ECCurve {
        protected AbstractFp(BigInteger bigInteger) {
            super(FiniteFields.getPrimeField(bigInteger));
        }

        private static BigInteger implRandomFieldElement(SecureRandom secureRandom, BigInteger bigInteger) {
            BigInteger createRandomBigInteger;
            do {
                createRandomBigInteger = BigIntegers.createRandomBigInteger(bigInteger.bitLength(), secureRandom);
            } while (createRandomBigInteger.compareTo(bigInteger) >= 0);
            return createRandomBigInteger;
        }

        private static BigInteger implRandomFieldElementMult(SecureRandom secureRandom, BigInteger bigInteger) {
            while (true) {
                BigInteger createRandomBigInteger = BigIntegers.createRandomBigInteger(bigInteger.bitLength(), secureRandom);
                if (createRandomBigInteger.signum() > 0 && createRandomBigInteger.compareTo(bigInteger) < 0) {
                    return createRandomBigInteger;
                }
            }
        }

        /* access modifiers changed from: protected */
        public ECPoint decompressPoint(int i10, BigInteger bigInteger) {
            ECFieldElement fromBigInteger = fromBigInteger(bigInteger);
            ECFieldElement sqrt = fromBigInteger.square().add(this.f23892a).multiply(fromBigInteger).add(this.f23893b).sqrt();
            if (sqrt != null) {
                boolean testBitZero = sqrt.testBitZero();
                boolean z10 = true;
                if (i10 != 1) {
                    z10 = false;
                }
                if (testBitZero != z10) {
                    sqrt = sqrt.negate();
                }
                return createRawPoint(fromBigInteger, sqrt);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }

        public boolean isValidFieldElement(BigInteger bigInteger) {
            return bigInteger != null && bigInteger.signum() >= 0 && bigInteger.compareTo(getField().getCharacteristic()) < 0;
        }

        public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
            BigInteger characteristic = getField().getCharacteristic();
            return fromBigInteger(implRandomFieldElement(secureRandom, characteristic)).multiply(fromBigInteger(implRandomFieldElement(secureRandom, characteristic)));
        }

        public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
            BigInteger characteristic = getField().getCharacteristic();
            return fromBigInteger(implRandomFieldElementMult(secureRandom, characteristic)).multiply(fromBigInteger(implRandomFieldElementMult(secureRandom, characteristic)));
        }
    }

    public class Config {
        protected int coord;
        protected ECEndomorphism endomorphism;
        protected ECMultiplier multiplier;

        Config(int i10, ECEndomorphism eCEndomorphism, ECMultiplier eCMultiplier) {
            this.coord = i10;
            this.endomorphism = eCEndomorphism;
            this.multiplier = eCMultiplier;
        }

        public ECCurve create() {
            if (ECCurve.this.supportsCoordinateSystem(this.coord)) {
                ECCurve cloneCurve = ECCurve.this.cloneCurve();
                if (cloneCurve != ECCurve.this) {
                    synchronized (cloneCurve) {
                        cloneCurve.coord = this.coord;
                        cloneCurve.endomorphism = this.endomorphism;
                        cloneCurve.multiplier = this.multiplier;
                    }
                    return cloneCurve;
                }
                throw new IllegalStateException("implementation returned current curve");
            }
            throw new IllegalStateException("unsupported coordinate system");
        }

        public Config setCoordinateSystem(int i10) {
            this.coord = i10;
            return this;
        }

        public Config setEndomorphism(ECEndomorphism eCEndomorphism) {
            this.endomorphism = eCEndomorphism;
            return this;
        }

        public Config setMultiplier(ECMultiplier eCMultiplier) {
            this.multiplier = eCMultiplier;
            return this;
        }
    }

    public static class F2m extends AbstractF2m {
        private static final int F2M_DEFAULT_COORDS = 6;
        private ECPoint.F2m infinity;

        /* renamed from: k1  reason: collision with root package name */
        private int f23895k1;

        /* renamed from: k2  reason: collision with root package name */
        private int f23896k2;

        /* renamed from: k3  reason: collision with root package name */
        private int f23897k3;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public int f23898m;

        public F2m(int i10, int i11, int i12, int i13, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i10, i11, i12, i13, bigInteger, bigInteger2, (BigInteger) null, (BigInteger) null);
        }

        public F2m(int i10, int i11, int i12, int i13, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(i10, i11, i12, i13);
            this.f23898m = i10;
            this.f23895k1 = i11;
            this.f23896k2 = i12;
            this.f23897k3 = i13;
            this.order = bigInteger3;
            this.cofactor = bigInteger4;
            this.infinity = new ECPoint.F2m(this, (ECFieldElement) null, (ECFieldElement) null);
            this.f23892a = fromBigInteger(bigInteger);
            this.f23893b = fromBigInteger(bigInteger2);
            this.coord = 6;
        }

        protected F2m(int i10, int i11, int i12, int i13, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, BigInteger bigInteger, BigInteger bigInteger2) {
            super(i10, i11, i12, i13);
            this.f23898m = i10;
            this.f23895k1 = i11;
            this.f23896k2 = i12;
            this.f23897k3 = i13;
            this.order = bigInteger;
            this.cofactor = bigInteger2;
            this.infinity = new ECPoint.F2m(this, (ECFieldElement) null, (ECFieldElement) null);
            this.f23892a = eCFieldElement;
            this.f23893b = eCFieldElement2;
            this.coord = 6;
        }

        public F2m(int i10, int i11, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i10, i11, 0, 0, bigInteger, bigInteger2, (BigInteger) null, (BigInteger) null);
        }

        public F2m(int i10, int i11, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this(i10, i11, 0, 0, bigInteger, bigInteger2, bigInteger3, bigInteger4);
        }

        /* access modifiers changed from: protected */
        public ECCurve cloneCurve() {
            return new F2m(this.f23898m, this.f23895k1, this.f23896k2, this.f23897k3, this.f23892a, this.f23893b, this.order, this.cofactor);
        }

        public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i10, int i11) {
            final int i12 = (this.f23898m + 63) >>> 6;
            final int[] iArr = isTrinomial() ? new int[]{this.f23895k1} : new int[]{this.f23895k1, this.f23896k2, this.f23897k3};
            final long[] jArr = new long[(i11 * i12 * 2)];
            int i13 = 0;
            for (int i14 = 0; i14 < i11; i14++) {
                ECPoint eCPoint = eCPointArr[i10 + i14];
                ((ECFieldElement.F2m) eCPoint.getRawXCoord()).f23902x.copyTo(jArr, i13);
                int i15 = i13 + i12;
                ((ECFieldElement.F2m) eCPoint.getRawYCoord()).f23902x.copyTo(jArr, i15);
                i13 = i15 + i12;
            }
            final int i16 = i11;
            return new AbstractECLookupTable() {
                private ECPoint createPoint(long[] jArr, long[] jArr2) {
                    return F2m.this.createRawPoint(new ECFieldElement.F2m(F2m.this.f23898m, iArr, new LongArray(jArr)), new ECFieldElement.F2m(F2m.this.f23898m, iArr, new LongArray(jArr2)));
                }

                public int getSize() {
                    return i16;
                }

                public ECPoint lookup(int i10) {
                    int i11;
                    long[] create64 = Nat.create64(i12);
                    long[] create642 = Nat.create64(i12);
                    int i12 = 0;
                    for (int i13 = 0; i13 < i16; i13++) {
                        long j10 = (long) (((i13 ^ i10) - 1) >> 31);
                        int i14 = 0;
                        while (true) {
                            i11 = i12;
                            if (i14 >= i11) {
                                break;
                            }
                            long j11 = create64[i14];
                            long[] jArr = jArr;
                            create64[i14] = j11 ^ (jArr[i12 + i14] & j10);
                            create642[i14] = create642[i14] ^ (jArr[(i11 + i12) + i14] & j10);
                            i14++;
                        }
                        i12 += i11 * 2;
                    }
                    return createPoint(create64, create642);
                }

                public ECPoint lookupVar(int i10) {
                    long[] create64 = Nat.create64(i12);
                    long[] create642 = Nat.create64(i12);
                    int i11 = i10 * i12 * 2;
                    int i12 = 0;
                    while (true) {
                        int i13 = i12;
                        if (i12 >= i13) {
                            return createPoint(create64, create642);
                        }
                        long[] jArr = jArr;
                        create64[i12] = jArr[i11 + i12];
                        create642[i12] = jArr[i13 + i11 + i12];
                        i12++;
                    }
                }
            };
        }

        /* access modifiers changed from: protected */
        public ECMultiplier createDefaultMultiplier() {
            return isKoblitz() ? new WTauNafMultiplier() : ECCurve.super.createDefaultMultiplier();
        }

        /* access modifiers changed from: protected */
        public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            return new ECPoint.F2m(this, eCFieldElement, eCFieldElement2);
        }

        /* access modifiers changed from: protected */
        public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            return new ECPoint.F2m(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }

        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
            return new ECFieldElement.F2m(this.f23898m, this.f23895k1, this.f23896k2, this.f23897k3, bigInteger);
        }

        public int getFieldSize() {
            return this.f23898m;
        }

        public ECPoint getInfinity() {
            return this.infinity;
        }

        public int getK1() {
            return this.f23895k1;
        }

        public int getK2() {
            return this.f23896k2;
        }

        public int getK3() {
            return this.f23897k3;
        }

        public int getM() {
            return this.f23898m;
        }

        public boolean isTrinomial() {
            return this.f23896k2 == 0 && this.f23897k3 == 0;
        }

        public boolean supportsCoordinateSystem(int i10) {
            return i10 == 0 || i10 == 1 || i10 == 6;
        }
    }

    public static class Fp extends AbstractFp {
        private static final int FP_DEFAULT_COORDS = 4;
        ECPoint.Fp infinity;

        /* renamed from: q  reason: collision with root package name */
        BigInteger f23899q;

        /* renamed from: r  reason: collision with root package name */
        BigInteger f23900r;

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            this(bigInteger, bigInteger2, bigInteger3, (BigInteger) null, (BigInteger) null);
        }

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
            super(bigInteger);
            this.f23899q = bigInteger;
            this.f23900r = ECFieldElement.Fp.calculateResidue(bigInteger);
            this.infinity = new ECPoint.Fp(this, (ECFieldElement) null, (ECFieldElement) null);
            this.f23892a = fromBigInteger(bigInteger2);
            this.f23893b = fromBigInteger(bigInteger3);
            this.order = bigInteger4;
            this.cofactor = bigInteger5;
            this.coord = 4;
        }

        protected Fp(BigInteger bigInteger, BigInteger bigInteger2, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(bigInteger);
            this.f23899q = bigInteger;
            this.f23900r = bigInteger2;
            this.infinity = new ECPoint.Fp(this, (ECFieldElement) null, (ECFieldElement) null);
            this.f23892a = eCFieldElement;
            this.f23893b = eCFieldElement2;
            this.order = bigInteger3;
            this.cofactor = bigInteger4;
            this.coord = 4;
        }

        /* access modifiers changed from: protected */
        public ECCurve cloneCurve() {
            return new Fp(this.f23899q, this.f23900r, this.f23892a, this.f23893b, this.order, this.cofactor);
        }

        /* access modifiers changed from: protected */
        public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            return new ECPoint.Fp(this, eCFieldElement, eCFieldElement2);
        }

        /* access modifiers changed from: protected */
        public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            return new ECPoint.Fp(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }

        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
            return new ECFieldElement.Fp(this.f23899q, this.f23900r, bigInteger);
        }

        public int getFieldSize() {
            return this.f23899q.bitLength();
        }

        public ECPoint getInfinity() {
            return this.infinity;
        }

        public BigInteger getQ() {
            return this.f23899q;
        }

        public ECPoint importPoint(ECPoint eCPoint) {
            int coordinateSystem;
            if (this == eCPoint.getCurve() || getCoordinateSystem() != 2 || eCPoint.isInfinity() || ((coordinateSystem = eCPoint.getCurve().getCoordinateSystem()) != 2 && coordinateSystem != 3 && coordinateSystem != 4)) {
                return ECCurve.super.importPoint(eCPoint);
            }
            return new ECPoint.Fp(this, fromBigInteger(eCPoint.f23906x.toBigInteger()), fromBigInteger(eCPoint.f23907y.toBigInteger()), new ECFieldElement[]{fromBigInteger(eCPoint.zs[0].toBigInteger())});
        }

        public boolean supportsCoordinateSystem(int i10) {
            return i10 == 0 || i10 == 1 || i10 == 2 || i10 == 4;
        }
    }

    protected ECCurve(FiniteField finiteField) {
        this.field = finiteField;
    }

    public static int[] getAllCoordinateSystems() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    }

    /* access modifiers changed from: protected */
    public void checkPoint(ECPoint eCPoint) {
        if (eCPoint == null || this != eCPoint.getCurve()) {
            throw new IllegalArgumentException("'point' must be non-null and on this curve");
        }
    }

    /* access modifiers changed from: protected */
    public void checkPoints(ECPoint[] eCPointArr) {
        checkPoints(eCPointArr, 0, eCPointArr.length);
    }

    /* access modifiers changed from: protected */
    public void checkPoints(ECPoint[] eCPointArr, int i10, int i11) {
        if (eCPointArr == null) {
            throw new IllegalArgumentException("'points' cannot be null");
        } else if (i10 < 0 || i11 < 0 || i10 > eCPointArr.length - i11) {
            throw new IllegalArgumentException("invalid range specified for 'points'");
        } else {
            int i12 = 0;
            while (i12 < i11) {
                ECPoint eCPoint = eCPointArr[i10 + i12];
                if (eCPoint == null || this == eCPoint.getCurve()) {
                    i12++;
                } else {
                    throw new IllegalArgumentException("'points' entries must be null or on this curve");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract ECCurve cloneCurve();

    public synchronized Config configure() {
        return new Config(this.coord, this.endomorphism, this.multiplier);
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i10, final int i11) {
        final int fieldSize = (getFieldSize() + 7) >>> 3;
        final byte[] bArr = new byte[(i11 * fieldSize * 2)];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ECPoint eCPoint = eCPointArr[i10 + i13];
            byte[] byteArray = eCPoint.getRawXCoord().toBigInteger().toByteArray();
            byte[] byteArray2 = eCPoint.getRawYCoord().toBigInteger().toByteArray();
            int i14 = 1;
            int i15 = byteArray.length > fieldSize ? 1 : 0;
            int length = byteArray.length - i15;
            if (byteArray2.length <= fieldSize) {
                i14 = 0;
            }
            int length2 = byteArray2.length - i14;
            int i16 = i12 + fieldSize;
            System.arraycopy(byteArray, i15, bArr, i16 - length, length);
            i12 = i16 + fieldSize;
            System.arraycopy(byteArray2, i14, bArr, i12 - length2, length2);
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(byte[] bArr, byte[] bArr2) {
                ECCurve eCCurve = ECCurve.this;
                return eCCurve.createRawPoint(eCCurve.fromBigInteger(new BigInteger(1, bArr)), ECCurve.this.fromBigInteger(new BigInteger(1, bArr2)));
            }

            public int getSize() {
                return i11;
            }

            public ECPoint lookup(int i10) {
                int i11;
                int i12 = fieldSize;
                byte[] bArr = new byte[i12];
                byte[] bArr2 = new byte[i12];
                int i13 = 0;
                for (int i14 = 0; i14 < i11; i14++) {
                    int i15 = ((i14 ^ i10) - 1) >> 31;
                    int i16 = 0;
                    while (true) {
                        i11 = fieldSize;
                        if (i16 >= i11) {
                            break;
                        }
                        byte b10 = bArr[i16];
                        byte[] bArr3 = bArr;
                        bArr[i16] = (byte) (b10 ^ (bArr3[i13 + i16] & i15));
                        bArr2[i16] = (byte) ((bArr3[(i11 + i13) + i16] & i15) ^ bArr2[i16]);
                        i16++;
                    }
                    i13 += i11 * 2;
                }
                return createPoint(bArr, bArr2);
            }

            public ECPoint lookupVar(int i10) {
                int i11 = fieldSize;
                byte[] bArr = new byte[i11];
                byte[] bArr2 = new byte[i11];
                int i12 = i10 * i11 * 2;
                int i13 = 0;
                while (true) {
                    int i14 = fieldSize;
                    if (i13 >= i14) {
                        return createPoint(bArr, bArr2);
                    }
                    byte[] bArr3 = bArr;
                    bArr[i13] = bArr3[i12 + i13];
                    bArr2[i13] = bArr3[i14 + i12 + i13];
                    i13++;
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public ECMultiplier createDefaultMultiplier() {
        ECEndomorphism eCEndomorphism = this.endomorphism;
        return eCEndomorphism instanceof GLVEndomorphism ? new GLVMultiplier(this, (GLVEndomorphism) eCEndomorphism) : new WNafL2RMultiplier();
    }

    public ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2) {
        return createRawPoint(fromBigInteger(bigInteger), fromBigInteger(bigInteger2));
    }

    /* access modifiers changed from: protected */
    public abstract ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2);

    /* access modifiers changed from: protected */
    public abstract ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr);

    public ECPoint decodePoint(byte[] bArr) {
        ECPoint eCPoint;
        int fieldSize = (getFieldSize() + 7) / 8;
        boolean z10 = false;
        byte b10 = bArr[0];
        if (b10 != 0) {
            if (b10 == 2 || b10 == 3) {
                if (bArr.length == fieldSize + 1) {
                    eCPoint = decompressPoint(b10 & 1, BigIntegers.fromUnsignedByteArray(bArr, 1, fieldSize));
                    if (!eCPoint.implIsValid(true, true)) {
                        throw new IllegalArgumentException("Invalid point");
                    }
                } else {
                    throw new IllegalArgumentException("Incorrect length for compressed encoding");
                }
            } else if (b10 != 4) {
                if (b10 != 6 && b10 != 7) {
                    throw new IllegalArgumentException("Invalid point encoding 0x" + Integer.toString(b10, 16));
                } else if (bArr.length == (fieldSize * 2) + 1) {
                    BigInteger fromUnsignedByteArray = BigIntegers.fromUnsignedByteArray(bArr, 1, fieldSize);
                    BigInteger fromUnsignedByteArray2 = BigIntegers.fromUnsignedByteArray(bArr, fieldSize + 1, fieldSize);
                    boolean testBit = fromUnsignedByteArray2.testBit(0);
                    if (b10 == 7) {
                        z10 = true;
                    }
                    if (testBit == z10) {
                        eCPoint = validatePoint(fromUnsignedByteArray, fromUnsignedByteArray2);
                    } else {
                        throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
                    }
                } else {
                    throw new IllegalArgumentException("Incorrect length for hybrid encoding");
                }
            } else if (bArr.length == (fieldSize * 2) + 1) {
                eCPoint = validatePoint(BigIntegers.fromUnsignedByteArray(bArr, 1, fieldSize), BigIntegers.fromUnsignedByteArray(bArr, fieldSize + 1, fieldSize));
            } else {
                throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
            }
        } else if (bArr.length == 1) {
            eCPoint = getInfinity();
        } else {
            throw new IllegalArgumentException("Incorrect length for infinity encoding");
        }
        if (b10 == 0 || !eCPoint.isInfinity()) {
            return eCPoint;
        }
        throw new IllegalArgumentException("Invalid infinity encoding");
    }

    /* access modifiers changed from: protected */
    public abstract ECPoint decompressPoint(int i10, BigInteger bigInteger);

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof ECCurve) && equals((ECCurve) obj));
    }

    public boolean equals(ECCurve eCCurve) {
        return this == eCCurve || (eCCurve != null && getField().equals(eCCurve.getField()) && getA().toBigInteger().equals(eCCurve.getA().toBigInteger()) && getB().toBigInteger().equals(eCCurve.getB().toBigInteger()));
    }

    public abstract ECFieldElement fromBigInteger(BigInteger bigInteger);

    public ECFieldElement getA() {
        return this.f23892a;
    }

    public ECFieldElement getB() {
        return this.f23893b;
    }

    public BigInteger getCofactor() {
        return this.cofactor;
    }

    public int getCoordinateSystem() {
        return this.coord;
    }

    public ECEndomorphism getEndomorphism() {
        return this.endomorphism;
    }

    public FiniteField getField() {
        return this.field;
    }

    public abstract int getFieldSize();

    public abstract ECPoint getInfinity();

    public ECMultiplier getMultiplier() {
        if (this.multiplier == null) {
            this.multiplier = createDefaultMultiplier();
        }
        return this.multiplier;
    }

    public BigInteger getOrder() {
        return this.order;
    }

    public PreCompInfo getPreCompInfo(ECPoint eCPoint, String str) {
        Hashtable hashtable;
        PreCompInfo preCompInfo;
        checkPoint(eCPoint);
        synchronized (eCPoint) {
            hashtable = eCPoint.preCompTable;
        }
        if (hashtable == null) {
            return null;
        }
        synchronized (hashtable) {
            preCompInfo = (PreCompInfo) hashtable.get(str);
        }
        return preCompInfo;
    }

    public int hashCode() {
        return (getField().hashCode() ^ Integers.rotateLeft(getA().toBigInteger().hashCode(), 8)) ^ Integers.rotateLeft(getB().toBigInteger().hashCode(), 16);
    }

    public ECPoint importPoint(ECPoint eCPoint) {
        if (this == eCPoint.getCurve()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return getInfinity();
        }
        ECPoint normalize = eCPoint.normalize();
        return createPoint(normalize.getXCoord().toBigInteger(), normalize.getYCoord().toBigInteger());
    }

    public abstract boolean isValidFieldElement(BigInteger bigInteger);

    public void normalizeAll(ECPoint[] eCPointArr) {
        normalizeAll(eCPointArr, 0, eCPointArr.length, (ECFieldElement) null);
    }

    public void normalizeAll(ECPoint[] eCPointArr, int i10, int i11, ECFieldElement eCFieldElement) {
        checkPoints(eCPointArr, i10, i11);
        int coordinateSystem = getCoordinateSystem();
        if (coordinateSystem != 0 && coordinateSystem != 5) {
            ECFieldElement[] eCFieldElementArr = new ECFieldElement[i11];
            int[] iArr = new int[i11];
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                int i14 = i10 + i13;
                ECPoint eCPoint = eCPointArr[i14];
                if (eCPoint != null && (eCFieldElement != null || !eCPoint.isNormalized())) {
                    eCFieldElementArr[i12] = eCPoint.getZCoord(0);
                    iArr[i12] = i14;
                    i12++;
                }
            }
            if (i12 != 0) {
                ECAlgorithms.montgomeryTrick(eCFieldElementArr, 0, i12, eCFieldElement);
                for (int i15 = 0; i15 < i12; i15++) {
                    int i16 = iArr[i15];
                    eCPointArr[i16] = eCPointArr[i16].normalize(eCFieldElementArr[i15]);
                }
            }
        } else if (eCFieldElement != null) {
            throw new IllegalArgumentException("'iso' not valid for affine coordinates");
        }
    }

    public PreCompInfo precompute(ECPoint eCPoint, String str, PreCompCallback preCompCallback) {
        Hashtable hashtable;
        PreCompInfo precompute;
        checkPoint(eCPoint);
        synchronized (eCPoint) {
            hashtable = eCPoint.preCompTable;
            if (hashtable == null) {
                hashtable = new Hashtable(4);
                eCPoint.preCompTable = hashtable;
            }
        }
        synchronized (hashtable) {
            PreCompInfo preCompInfo = (PreCompInfo) hashtable.get(str);
            precompute = preCompCallback.precompute(preCompInfo);
            if (precompute != preCompInfo) {
                hashtable.put(str, precompute);
            }
        }
        return precompute;
    }

    public abstract ECFieldElement randomFieldElement(SecureRandom secureRandom);

    public abstract ECFieldElement randomFieldElementMult(SecureRandom secureRandom);

    public boolean supportsCoordinateSystem(int i10) {
        return i10 == 0;
    }

    public ECPoint validatePoint(BigInteger bigInteger, BigInteger bigInteger2) {
        ECPoint createPoint = createPoint(bigInteger, bigInteger2);
        if (createPoint.isValid()) {
            return createPoint;
        }
        throw new IllegalArgumentException("Invalid point coordinates");
    }
}
