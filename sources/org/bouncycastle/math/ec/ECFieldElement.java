package org.bouncycastle.math.ec;

import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Integers;

public abstract class ECFieldElement implements ECConstants {

    public static abstract class AbstractF2m extends ECFieldElement {
        public ECFieldElement halfTrace() {
            int fieldSize = getFieldSize();
            if ((fieldSize & 1) != 0) {
                int i10 = (fieldSize + 1) >>> 1;
                int numberOfLeadingZeros = 31 - Integers.numberOfLeadingZeros(i10);
                ECFieldElement eCFieldElement = this;
                int i11 = 1;
                while (numberOfLeadingZeros > 0) {
                    eCFieldElement = eCFieldElement.squarePow(i11 << 1).add(eCFieldElement);
                    numberOfLeadingZeros--;
                    i11 = i10 >>> numberOfLeadingZeros;
                    if ((i11 & 1) != 0) {
                        eCFieldElement = eCFieldElement.squarePow(2).add(this);
                    }
                }
                return eCFieldElement;
            }
            throw new IllegalStateException("Half-trace only defined for odd m");
        }

        public boolean hasFastTrace() {
            return false;
        }

        public int trace() {
            int fieldSize = getFieldSize();
            int numberOfLeadingZeros = 31 - Integers.numberOfLeadingZeros(fieldSize);
            ECFieldElement eCFieldElement = this;
            int i10 = 1;
            while (numberOfLeadingZeros > 0) {
                eCFieldElement = eCFieldElement.squarePow(i10).add(eCFieldElement);
                numberOfLeadingZeros--;
                i10 = fieldSize >>> numberOfLeadingZeros;
                if ((i10 & 1) != 0) {
                    eCFieldElement = eCFieldElement.square().add(this);
                }
            }
            if (eCFieldElement.isZero()) {
                return 0;
            }
            if (eCFieldElement.isOne()) {
                return 1;
            }
            throw new IllegalStateException("Internal error in trace calculation");
        }
    }

    public static abstract class AbstractFp extends ECFieldElement {
    }

    public static class F2m extends AbstractF2m {
        public static final int GNB = 1;
        public static final int PPB = 3;
        public static final int TPB = 2;
        private int[] ks;

        /* renamed from: m  reason: collision with root package name */
        private int f23901m;
        private int representation;

        /* renamed from: x  reason: collision with root package name */
        LongArray f23902x;

        public F2m(int i10, int i11, int i12, int i13, BigInteger bigInteger) {
            if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > i10) {
                throw new IllegalArgumentException("x value invalid in F2m field element");
            }
            if (i12 == 0 && i13 == 0) {
                this.representation = 2;
                this.ks = new int[]{i11};
            } else if (i12 >= i13) {
                throw new IllegalArgumentException("k2 must be smaller than k3");
            } else if (i12 > 0) {
                this.representation = 3;
                this.ks = new int[]{i11, i12, i13};
            } else {
                throw new IllegalArgumentException("k2 must be larger than 0");
            }
            this.f23901m = i10;
            this.f23902x = new LongArray(bigInteger);
        }

        F2m(int i10, int[] iArr, LongArray longArray) {
            this.f23901m = i10;
            this.representation = iArr.length == 1 ? 2 : 3;
            this.ks = iArr;
            this.f23902x = longArray;
        }

        public ECFieldElement add(ECFieldElement eCFieldElement) {
            LongArray longArray = (LongArray) this.f23902x.clone();
            longArray.addShiftedByWords(((F2m) eCFieldElement).f23902x, 0);
            return new F2m(this.f23901m, this.ks, longArray);
        }

        public ECFieldElement addOne() {
            return new F2m(this.f23901m, this.ks, this.f23902x.addOne());
        }

        public int bitLength() {
            return this.f23902x.degree();
        }

        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return multiply(eCFieldElement.invert());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof F2m)) {
                return false;
            }
            F2m f2m = (F2m) obj;
            return this.f23901m == f2m.f23901m && this.representation == f2m.representation && Arrays.areEqual(this.ks, f2m.ks) && this.f23902x.equals(f2m.f23902x);
        }

        public String getFieldName() {
            return "F2m";
        }

        public int getFieldSize() {
            return this.f23901m;
        }

        public int getK1() {
            return this.ks[0];
        }

        public int getK2() {
            int[] iArr = this.ks;
            if (iArr.length >= 2) {
                return iArr[1];
            }
            return 0;
        }

        public int getK3() {
            int[] iArr = this.ks;
            if (iArr.length >= 3) {
                return iArr[2];
            }
            return 0;
        }

        public int getM() {
            return this.f23901m;
        }

        public int getRepresentation() {
            return this.representation;
        }

        public int hashCode() {
            return (this.f23902x.hashCode() ^ this.f23901m) ^ Arrays.hashCode(this.ks);
        }

        public ECFieldElement invert() {
            int i10 = this.f23901m;
            int[] iArr = this.ks;
            return new F2m(i10, iArr, this.f23902x.modInverse(i10, iArr));
        }

        public boolean isOne() {
            return this.f23902x.isOne();
        }

        public boolean isZero() {
            return this.f23902x.isZero();
        }

        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            int i10 = this.f23901m;
            int[] iArr = this.ks;
            return new F2m(i10, iArr, this.f23902x.modMultiply(((F2m) eCFieldElement).f23902x, i10, iArr));
        }

        public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: org.bouncycastle.math.ec.LongArray} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.bouncycastle.math.ec.ECFieldElement multiplyPlusProduct(org.bouncycastle.math.ec.ECFieldElement r5, org.bouncycastle.math.ec.ECFieldElement r6, org.bouncycastle.math.ec.ECFieldElement r7) {
            /*
                r4 = this;
                org.bouncycastle.math.ec.LongArray r0 = r4.f23902x
                org.bouncycastle.math.ec.ECFieldElement$F2m r5 = (org.bouncycastle.math.ec.ECFieldElement.F2m) r5
                org.bouncycastle.math.ec.LongArray r5 = r5.f23902x
                org.bouncycastle.math.ec.ECFieldElement$F2m r6 = (org.bouncycastle.math.ec.ECFieldElement.F2m) r6
                org.bouncycastle.math.ec.LongArray r6 = r6.f23902x
                org.bouncycastle.math.ec.ECFieldElement$F2m r7 = (org.bouncycastle.math.ec.ECFieldElement.F2m) r7
                org.bouncycastle.math.ec.LongArray r7 = r7.f23902x
                int r1 = r4.f23901m
                int[] r2 = r4.ks
                org.bouncycastle.math.ec.LongArray r1 = r0.multiply(r5, r1, r2)
                int r2 = r4.f23901m
                int[] r3 = r4.ks
                org.bouncycastle.math.ec.LongArray r6 = r6.multiply(r7, r2, r3)
                if (r1 == r0) goto L_0x0022
                if (r1 != r5) goto L_0x0029
            L_0x0022:
                java.lang.Object r5 = r1.clone()
                r1 = r5
                org.bouncycastle.math.ec.LongArray r1 = (org.bouncycastle.math.ec.LongArray) r1
            L_0x0029:
                r5 = 0
                r1.addShiftedByWords(r6, r5)
                int r5 = r4.f23901m
                int[] r6 = r4.ks
                r1.reduce(r5, r6)
                org.bouncycastle.math.ec.ECFieldElement$F2m r5 = new org.bouncycastle.math.ec.ECFieldElement$F2m
                int r6 = r4.f23901m
                int[] r7 = r4.ks
                r5.<init>(r6, r7, r1)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.math.ec.ECFieldElement.F2m.multiplyPlusProduct(org.bouncycastle.math.ec.ECFieldElement, org.bouncycastle.math.ec.ECFieldElement, org.bouncycastle.math.ec.ECFieldElement):org.bouncycastle.math.ec.ECFieldElement");
        }

        public ECFieldElement negate() {
            return this;
        }

        public ECFieldElement sqrt() {
            return (this.f23902x.isZero() || this.f23902x.isOne()) ? this : squarePow(this.f23901m - 1);
        }

        public ECFieldElement square() {
            int i10 = this.f23901m;
            int[] iArr = this.ks;
            return new F2m(i10, iArr, this.f23902x.modSquare(i10, iArr));
        }

        public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            return squarePlusProduct(eCFieldElement, eCFieldElement2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: org.bouncycastle.math.ec.LongArray} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.bouncycastle.math.ec.ECFieldElement squarePlusProduct(org.bouncycastle.math.ec.ECFieldElement r5, org.bouncycastle.math.ec.ECFieldElement r6) {
            /*
                r4 = this;
                org.bouncycastle.math.ec.LongArray r0 = r4.f23902x
                org.bouncycastle.math.ec.ECFieldElement$F2m r5 = (org.bouncycastle.math.ec.ECFieldElement.F2m) r5
                org.bouncycastle.math.ec.LongArray r5 = r5.f23902x
                org.bouncycastle.math.ec.ECFieldElement$F2m r6 = (org.bouncycastle.math.ec.ECFieldElement.F2m) r6
                org.bouncycastle.math.ec.LongArray r6 = r6.f23902x
                int r1 = r4.f23901m
                int[] r2 = r4.ks
                org.bouncycastle.math.ec.LongArray r1 = r0.square(r1, r2)
                int r2 = r4.f23901m
                int[] r3 = r4.ks
                org.bouncycastle.math.ec.LongArray r5 = r5.multiply(r6, r2, r3)
                if (r1 != r0) goto L_0x0023
                java.lang.Object r6 = r1.clone()
                r1 = r6
                org.bouncycastle.math.ec.LongArray r1 = (org.bouncycastle.math.ec.LongArray) r1
            L_0x0023:
                r6 = 0
                r1.addShiftedByWords(r5, r6)
                int r5 = r4.f23901m
                int[] r6 = r4.ks
                r1.reduce(r5, r6)
                org.bouncycastle.math.ec.ECFieldElement$F2m r5 = new org.bouncycastle.math.ec.ECFieldElement$F2m
                int r6 = r4.f23901m
                int[] r0 = r4.ks
                r5.<init>(r6, r0, r1)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.math.ec.ECFieldElement.F2m.squarePlusProduct(org.bouncycastle.math.ec.ECFieldElement, org.bouncycastle.math.ec.ECFieldElement):org.bouncycastle.math.ec.ECFieldElement");
        }

        public ECFieldElement squarePow(int i10) {
            if (i10 < 1) {
                return this;
            }
            int i11 = this.f23901m;
            int[] iArr = this.ks;
            return new F2m(i11, iArr, this.f23902x.modSquareN(i10, i11, iArr));
        }

        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return add(eCFieldElement);
        }

        public boolean testBitZero() {
            return this.f23902x.testBitZero();
        }

        public BigInteger toBigInteger() {
            return this.f23902x.toBigInteger();
        }
    }

    public static class Fp extends AbstractFp {

        /* renamed from: q  reason: collision with root package name */
        BigInteger f23903q;

        /* renamed from: r  reason: collision with root package name */
        BigInteger f23904r;

        /* renamed from: x  reason: collision with root package name */
        BigInteger f23905x;

        public Fp(BigInteger bigInteger, BigInteger bigInteger2) {
            this(bigInteger, calculateResidue(bigInteger), bigInteger2);
        }

        Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            if (bigInteger3 == null || bigInteger3.signum() < 0 || bigInteger3.compareTo(bigInteger) >= 0) {
                throw new IllegalArgumentException("x value invalid in Fp field element");
            }
            this.f23903q = bigInteger;
            this.f23904r = bigInteger2;
            this.f23905x = bigInteger3;
        }

        static BigInteger calculateResidue(BigInteger bigInteger) {
            int bitLength = bigInteger.bitLength();
            if (bitLength < 96 || bigInteger.shiftRight(bitLength - 64).longValue() != -1) {
                return null;
            }
            return ECConstants.ONE.shiftLeft(bitLength).subtract(bigInteger);
        }

        private ECFieldElement checkSqrt(ECFieldElement eCFieldElement) {
            if (eCFieldElement.square().equals(this)) {
                return eCFieldElement;
            }
            return null;
        }

        private BigInteger[] lucasSequence(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            int bitLength = bigInteger3.bitLength();
            int lowestSetBit = bigInteger3.getLowestSetBit();
            BigInteger bigInteger4 = ECConstants.ONE;
            BigInteger bigInteger5 = bigInteger;
            BigInteger bigInteger6 = bigInteger4;
            BigInteger bigInteger7 = ECConstants.TWO;
            BigInteger bigInteger8 = bigInteger6;
            for (int i10 = bitLength - 1; i10 >= lowestSetBit + 1; i10--) {
                bigInteger4 = modMult(bigInteger4, bigInteger8);
                if (bigInteger3.testBit(i10)) {
                    bigInteger8 = modMult(bigInteger4, bigInteger2);
                    bigInteger6 = modMult(bigInteger6, bigInteger5);
                    bigInteger7 = modReduce(bigInteger5.multiply(bigInteger7).subtract(bigInteger.multiply(bigInteger4)));
                    bigInteger5 = modReduce(bigInteger5.multiply(bigInteger5).subtract(bigInteger8.shiftLeft(1)));
                } else {
                    BigInteger modReduce = modReduce(bigInteger6.multiply(bigInteger7).subtract(bigInteger4));
                    BigInteger modReduce2 = modReduce(bigInteger5.multiply(bigInteger7).subtract(bigInteger.multiply(bigInteger4)));
                    bigInteger7 = modReduce(bigInteger7.multiply(bigInteger7).subtract(bigInteger4.shiftLeft(1)));
                    bigInteger5 = modReduce2;
                    bigInteger6 = modReduce;
                    bigInteger8 = bigInteger4;
                }
            }
            BigInteger modMult = modMult(bigInteger4, bigInteger8);
            BigInteger modMult2 = modMult(modMult, bigInteger2);
            BigInteger modReduce3 = modReduce(bigInteger6.multiply(bigInteger7).subtract(modMult));
            BigInteger modReduce4 = modReduce(bigInteger5.multiply(bigInteger7).subtract(bigInteger.multiply(modMult)));
            BigInteger modMult3 = modMult(modMult, modMult2);
            for (int i11 = 1; i11 <= lowestSetBit; i11++) {
                modReduce3 = modMult(modReduce3, modReduce4);
                modReduce4 = modReduce(modReduce4.multiply(modReduce4).subtract(modMult3.shiftLeft(1)));
                modMult3 = modMult(modMult3, modMult3);
            }
            return new BigInteger[]{modReduce3, modReduce4};
        }

        public ECFieldElement add(ECFieldElement eCFieldElement) {
            return new Fp(this.f23903q, this.f23904r, modAdd(this.f23905x, eCFieldElement.toBigInteger()));
        }

        public ECFieldElement addOne() {
            BigInteger add = this.f23905x.add(ECConstants.ONE);
            if (add.compareTo(this.f23903q) == 0) {
                add = ECConstants.ZERO;
            }
            return new Fp(this.f23903q, this.f23904r, add);
        }

        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return new Fp(this.f23903q, this.f23904r, modMult(this.f23905x, modInverse(eCFieldElement.toBigInteger())));
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Fp)) {
                return false;
            }
            Fp fp = (Fp) obj;
            return this.f23903q.equals(fp.f23903q) && this.f23905x.equals(fp.f23905x);
        }

        public String getFieldName() {
            return "Fp";
        }

        public int getFieldSize() {
            return this.f23903q.bitLength();
        }

        public BigInteger getQ() {
            return this.f23903q;
        }

        public int hashCode() {
            return this.f23903q.hashCode() ^ this.f23905x.hashCode();
        }

        public ECFieldElement invert() {
            return new Fp(this.f23903q, this.f23904r, modInverse(this.f23905x));
        }

        /* access modifiers changed from: protected */
        public BigInteger modAdd(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger add = bigInteger.add(bigInteger2);
            return add.compareTo(this.f23903q) >= 0 ? add.subtract(this.f23903q) : add;
        }

        /* access modifiers changed from: protected */
        public BigInteger modDouble(BigInteger bigInteger) {
            BigInteger shiftLeft = bigInteger.shiftLeft(1);
            return shiftLeft.compareTo(this.f23903q) >= 0 ? shiftLeft.subtract(this.f23903q) : shiftLeft;
        }

        /* access modifiers changed from: protected */
        public BigInteger modHalf(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.f23903q.add(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }

        /* access modifiers changed from: protected */
        public BigInteger modHalfAbs(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.f23903q.subtract(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }

        /* access modifiers changed from: protected */
        public BigInteger modInverse(BigInteger bigInteger) {
            return BigIntegers.modOddInverse(this.f23903q, bigInteger);
        }

        /* access modifiers changed from: protected */
        public BigInteger modMult(BigInteger bigInteger, BigInteger bigInteger2) {
            return modReduce(bigInteger.multiply(bigInteger2));
        }

        /* access modifiers changed from: protected */
        public BigInteger modReduce(BigInteger bigInteger) {
            if (this.f23904r == null) {
                return bigInteger.mod(this.f23903q);
            }
            boolean z10 = bigInteger.signum() < 0;
            if (z10) {
                bigInteger = bigInteger.abs();
            }
            int bitLength = this.f23903q.bitLength();
            boolean equals = this.f23904r.equals(ECConstants.ONE);
            while (bigInteger.bitLength() > bitLength + 1) {
                BigInteger shiftRight = bigInteger.shiftRight(bitLength);
                BigInteger subtract = bigInteger.subtract(shiftRight.shiftLeft(bitLength));
                if (!equals) {
                    shiftRight = shiftRight.multiply(this.f23904r);
                }
                bigInteger = shiftRight.add(subtract);
            }
            while (bigInteger.compareTo(this.f23903q) >= 0) {
                bigInteger = bigInteger.subtract(this.f23903q);
            }
            return (!z10 || bigInteger.signum() == 0) ? bigInteger : this.f23903q.subtract(bigInteger);
        }

        /* access modifiers changed from: protected */
        public BigInteger modSubtract(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger subtract = bigInteger.subtract(bigInteger2);
            return subtract.signum() < 0 ? subtract.add(this.f23903q) : subtract;
        }

        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            return new Fp(this.f23903q, this.f23904r, modMult(this.f23905x, eCFieldElement.toBigInteger()));
        }

        public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            BigInteger bigInteger = this.f23905x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            BigInteger bigInteger4 = eCFieldElement3.toBigInteger();
            return new Fp(this.f23903q, this.f23904r, modReduce(bigInteger.multiply(bigInteger2).subtract(bigInteger3.multiply(bigInteger4))));
        }

        public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            BigInteger bigInteger = this.f23905x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            BigInteger bigInteger4 = eCFieldElement3.toBigInteger();
            return new Fp(this.f23903q, this.f23904r, modReduce(bigInteger.multiply(bigInteger2).add(bigInteger3.multiply(bigInteger4))));
        }

        public ECFieldElement negate() {
            if (this.f23905x.signum() == 0) {
                return this;
            }
            BigInteger bigInteger = this.f23903q;
            return new Fp(bigInteger, this.f23904r, bigInteger.subtract(this.f23905x));
        }

        public ECFieldElement sqrt() {
            if (isZero() || isOne()) {
                return this;
            }
            if (!this.f23903q.testBit(0)) {
                throw new RuntimeException("not done yet");
            } else if (this.f23903q.testBit(1)) {
                BigInteger add = this.f23903q.shiftRight(2).add(ECConstants.ONE);
                BigInteger bigInteger = this.f23903q;
                return checkSqrt(new Fp(bigInteger, this.f23904r, this.f23905x.modPow(add, bigInteger)));
            } else if (this.f23903q.testBit(2)) {
                BigInteger modPow = this.f23905x.modPow(this.f23903q.shiftRight(3), this.f23903q);
                BigInteger modMult = modMult(modPow, this.f23905x);
                if (modMult(modMult, modPow).equals(ECConstants.ONE)) {
                    return checkSqrt(new Fp(this.f23903q, this.f23904r, modMult));
                }
                return checkSqrt(new Fp(this.f23903q, this.f23904r, modMult(modMult, ECConstants.TWO.modPow(this.f23903q.shiftRight(2), this.f23903q))));
            } else {
                BigInteger shiftRight = this.f23903q.shiftRight(1);
                BigInteger modPow2 = this.f23905x.modPow(shiftRight, this.f23903q);
                BigInteger bigInteger2 = ECConstants.ONE;
                if (!modPow2.equals(bigInteger2)) {
                    return null;
                }
                BigInteger bigInteger3 = this.f23905x;
                BigInteger modDouble = modDouble(modDouble(bigInteger3));
                BigInteger add2 = shiftRight.add(bigInteger2);
                BigInteger subtract = this.f23903q.subtract(bigInteger2);
                Random random = new Random();
                while (true) {
                    BigInteger bigInteger4 = new BigInteger(this.f23903q.bitLength(), random);
                    if (bigInteger4.compareTo(this.f23903q) < 0 && modReduce(bigInteger4.multiply(bigInteger4).subtract(modDouble)).modPow(shiftRight, this.f23903q).equals(subtract)) {
                        BigInteger[] lucasSequence = lucasSequence(bigInteger4, bigInteger3, add2);
                        BigInteger bigInteger5 = lucasSequence[0];
                        BigInteger bigInteger6 = lucasSequence[1];
                        if (modMult(bigInteger6, bigInteger6).equals(modDouble)) {
                            return new Fp(this.f23903q, this.f23904r, modHalfAbs(bigInteger6));
                        }
                        if (!bigInteger5.equals(ECConstants.ONE) && !bigInteger5.equals(subtract)) {
                            return null;
                        }
                    }
                }
            }
        }

        public ECFieldElement square() {
            BigInteger bigInteger = this.f23903q;
            BigInteger bigInteger2 = this.f23904r;
            BigInteger bigInteger3 = this.f23905x;
            return new Fp(bigInteger, bigInteger2, modMult(bigInteger3, bigInteger3));
        }

        public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            BigInteger bigInteger = this.f23905x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            return new Fp(this.f23903q, this.f23904r, modReduce(bigInteger.multiply(bigInteger).subtract(bigInteger2.multiply(bigInteger3))));
        }

        public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            BigInteger bigInteger = this.f23905x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            return new Fp(this.f23903q, this.f23904r, modReduce(bigInteger.multiply(bigInteger).add(bigInteger2.multiply(bigInteger3))));
        }

        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return new Fp(this.f23903q, this.f23904r, modSubtract(this.f23905x, eCFieldElement.toBigInteger()));
        }

        public BigInteger toBigInteger() {
            return this.f23905x;
        }
    }

    public abstract ECFieldElement add(ECFieldElement eCFieldElement);

    public abstract ECFieldElement addOne();

    public int bitLength() {
        return toBigInteger().bitLength();
    }

    public abstract ECFieldElement divide(ECFieldElement eCFieldElement);

    public byte[] getEncoded() {
        return BigIntegers.asUnsignedByteArray((getFieldSize() + 7) / 8, toBigInteger());
    }

    public abstract String getFieldName();

    public abstract int getFieldSize();

    public abstract ECFieldElement invert();

    public boolean isOne() {
        return bitLength() == 1;
    }

    public boolean isZero() {
        return toBigInteger().signum() == 0;
    }

    public abstract ECFieldElement multiply(ECFieldElement eCFieldElement);

    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiply(eCFieldElement).subtract(eCFieldElement2.multiply(eCFieldElement3));
    }

    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiply(eCFieldElement).add(eCFieldElement2.multiply(eCFieldElement3));
    }

    public abstract ECFieldElement negate();

    public abstract ECFieldElement sqrt();

    public abstract ECFieldElement square();

    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return square().subtract(eCFieldElement.multiply(eCFieldElement2));
    }

    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return square().add(eCFieldElement.multiply(eCFieldElement2));
    }

    public ECFieldElement squarePow(int i10) {
        ECFieldElement eCFieldElement = this;
        for (int i11 = 0; i11 < i10; i11++) {
            eCFieldElement = eCFieldElement.square();
        }
        return eCFieldElement;
    }

    public abstract ECFieldElement subtract(ECFieldElement eCFieldElement);

    public boolean testBitZero() {
        return toBigInteger().testBit(0);
    }

    public abstract BigInteger toBigInteger();

    public String toString() {
        return toBigInteger().toString(16);
    }
}
