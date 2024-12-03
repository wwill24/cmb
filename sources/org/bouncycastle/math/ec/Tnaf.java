package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

class Tnaf {
    private static final BigInteger MINUS_ONE;
    private static final BigInteger MINUS_THREE;
    private static final BigInteger MINUS_TWO = ECConstants.TWO.negate();
    public static final byte POW_2_WIDTH = 16;
    public static final byte WIDTH = 4;
    public static final ZTauElement[] alpha0;
    public static final byte[][] alpha0Tnaf = {null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, 1}};
    public static final ZTauElement[] alpha1;
    public static final byte[][] alpha1Tnaf = {null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, -1}};

    static {
        BigInteger bigInteger = ECConstants.ONE;
        BigInteger negate = bigInteger.negate();
        MINUS_ONE = negate;
        BigInteger negate2 = ECConstants.THREE.negate();
        MINUS_THREE = negate2;
        BigInteger bigInteger2 = ECConstants.ZERO;
        alpha0 = new ZTauElement[]{null, new ZTauElement(bigInteger, bigInteger2), null, new ZTauElement(negate2, negate), null, new ZTauElement(negate, negate), null, new ZTauElement(bigInteger, negate), null};
        alpha1 = new ZTauElement[]{null, new ZTauElement(bigInteger, bigInteger2), null, new ZTauElement(negate2, bigInteger), null, new ZTauElement(negate, bigInteger), null, new ZTauElement(bigInteger, bigInteger), null};
    }

    Tnaf() {
    }

    public static SimpleBigDecimal approximateDivisionByN(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte b10, int i10, int i11) {
        int i12 = ((i10 + 5) / 2) + i11;
        BigInteger multiply = bigInteger2.multiply(bigInteger.shiftRight(((i10 - i12) - 2) + b10));
        BigInteger add = multiply.add(bigInteger3.multiply(multiply.shiftRight(i10)));
        int i13 = i12 - i11;
        BigInteger shiftRight = add.shiftRight(i13);
        if (add.testBit(i13 - 1)) {
            shiftRight = shiftRight.add(ECConstants.ONE);
        }
        return new SimpleBigDecimal(shiftRight, i11);
    }

    public static BigInteger[] getLucas(byte b10, int i10, boolean z10) {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        if (b10 == 1 || b10 == -1) {
            if (z10) {
                bigInteger = ECConstants.TWO;
                bigInteger2 = BigInteger.valueOf((long) b10);
            } else {
                bigInteger = ECConstants.ZERO;
                bigInteger2 = ECConstants.ONE;
            }
            int i11 = 1;
            while (i11 < i10) {
                i11++;
                BigInteger bigInteger3 = bigInteger2;
                bigInteger2 = (b10 == 1 ? bigInteger2 : bigInteger2.negate()).subtract(bigInteger.shiftLeft(1));
                bigInteger = bigInteger3;
            }
            return new BigInteger[]{bigInteger, bigInteger2};
        }
        throw new IllegalArgumentException("mu must be 1 or -1");
    }

    public static byte getMu(int i10) {
        return (byte) (i10 == 0 ? -1 : 1);
    }

    public static byte getMu(ECCurve.AbstractF2m abstractF2m) {
        if (abstractF2m.isKoblitz()) {
            return abstractF2m.getA().isZero() ? (byte) -1 : 1;
        }
        throw new IllegalArgumentException("No Koblitz curve (ABC), TNAF multiplication not possible");
    }

    public static byte getMu(ECFieldElement eCFieldElement) {
        return (byte) (eCFieldElement.isZero() ? -1 : 1);
    }

    public static ECPoint.AbstractF2m[] getPreComp(ECPoint.AbstractF2m abstractF2m, byte b10) {
        byte[][] bArr = b10 == 0 ? alpha0Tnaf : alpha1Tnaf;
        ECPoint.AbstractF2m[] abstractF2mArr = new ECPoint.AbstractF2m[((bArr.length + 1) >>> 1)];
        abstractF2mArr[0] = abstractF2m;
        int length = bArr.length;
        for (int i10 = 3; i10 < length; i10 += 2) {
            abstractF2mArr[i10 >>> 1] = multiplyFromTnaf(abstractF2m, bArr[i10]);
        }
        abstractF2m.getCurve().normalizeAll(abstractF2mArr);
        return abstractF2mArr;
    }

    protected static int getShiftsForCofactor(BigInteger bigInteger) {
        if (bigInteger != null) {
            if (bigInteger.equals(ECConstants.TWO)) {
                return 1;
            }
            if (bigInteger.equals(ECConstants.FOUR)) {
                return 2;
            }
        }
        throw new IllegalArgumentException("h (Cofactor) must be 2 or 4");
    }

    public static BigInteger[] getSi(int i10, int i11, BigInteger bigInteger) {
        byte mu = getMu(i11);
        int shiftsForCofactor = getShiftsForCofactor(bigInteger);
        BigInteger[] lucas = getLucas(mu, (i10 + 3) - i11, false);
        if (mu == 1) {
            lucas[0] = lucas[0].negate();
            lucas[1] = lucas[1].negate();
        }
        BigInteger bigInteger2 = ECConstants.ONE;
        return new BigInteger[]{bigInteger2.add(lucas[1]).shiftRight(shiftsForCofactor), bigInteger2.add(lucas[0]).shiftRight(shiftsForCofactor).negate()};
    }

    public static BigInteger[] getSi(ECCurve.AbstractF2m abstractF2m) {
        if (abstractF2m.isKoblitz()) {
            int fieldSize = abstractF2m.getFieldSize();
            int intValue = abstractF2m.getA().toBigInteger().intValue();
            byte mu = getMu(intValue);
            int shiftsForCofactor = getShiftsForCofactor(abstractF2m.getCofactor());
            BigInteger[] lucas = getLucas(mu, (fieldSize + 3) - intValue, false);
            if (mu == 1) {
                lucas[0] = lucas[0].negate();
                lucas[1] = lucas[1].negate();
            }
            BigInteger bigInteger = ECConstants.ONE;
            return new BigInteger[]{bigInteger.add(lucas[1]).shiftRight(shiftsForCofactor), bigInteger.add(lucas[0]).shiftRight(shiftsForCofactor).negate()};
        }
        throw new IllegalArgumentException("si is defined for Koblitz curves only");
    }

    public static BigInteger getTw(byte b10, int i10) {
        if (i10 == 4) {
            return b10 == 1 ? BigInteger.valueOf(6) : BigInteger.valueOf(10);
        }
        BigInteger[] lucas = getLucas(b10, i10, false);
        BigInteger bit = ECConstants.ZERO.setBit(i10);
        return ECConstants.TWO.multiply(lucas[0]).multiply(lucas[1].modInverse(bit)).mod(bit);
    }

    public static ECPoint.AbstractF2m multiplyFromTnaf(ECPoint.AbstractF2m abstractF2m, byte[] bArr) {
        ECPoint.AbstractF2m abstractF2m2 = (ECPoint.AbstractF2m) abstractF2m.getCurve().getInfinity();
        ECPoint.AbstractF2m abstractF2m3 = (ECPoint.AbstractF2m) abstractF2m.negate();
        int i10 = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            i10++;
            byte b10 = bArr[length];
            if (b10 != 0) {
                abstractF2m2 = (ECPoint.AbstractF2m) abstractF2m2.tauPow(i10).add(b10 > 0 ? abstractF2m : abstractF2m3);
                i10 = 0;
            }
        }
        return i10 > 0 ? abstractF2m2.tauPow(i10) : abstractF2m2;
    }

    public static ECPoint.AbstractF2m multiplyRTnaf(ECPoint.AbstractF2m abstractF2m, BigInteger bigInteger) {
        ECCurve.AbstractF2m abstractF2m2 = (ECCurve.AbstractF2m) abstractF2m.getCurve();
        int fieldSize = abstractF2m2.getFieldSize();
        int intValue = abstractF2m2.getA().toBigInteger().intValue();
        byte mu = getMu(intValue);
        byte b10 = (byte) intValue;
        return multiplyTnaf(abstractF2m, partModReduction(bigInteger, fieldSize, b10, abstractF2m2.getSi(), mu, (byte) 10));
    }

    public static ECPoint.AbstractF2m multiplyTnaf(ECPoint.AbstractF2m abstractF2m, ZTauElement zTauElement) {
        return multiplyFromTnaf(abstractF2m, tauAdicNaf(getMu(((ECCurve.AbstractF2m) abstractF2m.getCurve()).getA()), zTauElement));
    }

    public static BigInteger norm(byte b10, ZTauElement zTauElement) {
        BigInteger subtract;
        BigInteger bigInteger = zTauElement.f23908u;
        BigInteger multiply = bigInteger.multiply(bigInteger);
        BigInteger multiply2 = zTauElement.f23908u.multiply(zTauElement.f23909v);
        BigInteger bigInteger2 = zTauElement.f23909v;
        BigInteger shiftLeft = bigInteger2.multiply(bigInteger2).shiftLeft(1);
        if (b10 == 1) {
            subtract = multiply.add(multiply2);
        } else if (b10 == -1) {
            subtract = multiply.subtract(multiply2);
        } else {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        return subtract.add(shiftLeft);
    }

    public static SimpleBigDecimal norm(byte b10, SimpleBigDecimal simpleBigDecimal, SimpleBigDecimal simpleBigDecimal2) {
        SimpleBigDecimal subtract;
        SimpleBigDecimal multiply = simpleBigDecimal.multiply(simpleBigDecimal);
        SimpleBigDecimal multiply2 = simpleBigDecimal.multiply(simpleBigDecimal2);
        SimpleBigDecimal shiftLeft = simpleBigDecimal2.multiply(simpleBigDecimal2).shiftLeft(1);
        if (b10 == 1) {
            subtract = multiply.add(multiply2);
        } else if (b10 == -1) {
            subtract = multiply.subtract(multiply2);
        } else {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        return subtract.add(shiftLeft);
    }

    public static ZTauElement partModReduction(BigInteger bigInteger, int i10, byte b10, BigInteger[] bigIntegerArr, byte b11, byte b12) {
        byte b13 = b11;
        BigInteger add = b13 == 1 ? bigIntegerArr[0].add(bigIntegerArr[1]) : bigIntegerArr[0].subtract(bigIntegerArr[1]);
        int i11 = i10;
        BigInteger bigInteger2 = bigInteger;
        BigInteger bigInteger3 = getLucas(b13, i10, true)[1];
        byte b14 = b10;
        int i12 = i10;
        byte b15 = b12;
        ZTauElement round = round(approximateDivisionByN(bigInteger2, bigIntegerArr[0], bigInteger3, b14, i12, b15), approximateDivisionByN(bigInteger2, bigIntegerArr[1], bigInteger3, b14, i12, b15), b13);
        BigInteger bigInteger4 = bigInteger;
        return new ZTauElement(bigInteger.subtract(add.multiply(round.f23908u)).subtract(BigInteger.valueOf(2).multiply(bigIntegerArr[1]).multiply(round.f23909v)), bigIntegerArr[1].multiply(round.f23908u).subtract(bigIntegerArr[0].multiply(round.f23909v)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
        if (r5.compareTo(MINUS_ONE) < 0) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0081, code lost:
        if (r5.compareTo(r9) >= 0) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008a, code lost:
        if (r8.compareTo(MINUS_TWO) < 0) goto L_0x008c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.bouncycastle.math.ec.ZTauElement round(org.bouncycastle.math.ec.SimpleBigDecimal r8, org.bouncycastle.math.ec.SimpleBigDecimal r9, byte r10) {
        /*
            int r0 = r8.getScale()
            int r1 = r9.getScale()
            if (r1 != r0) goto L_0x00a7
            r0 = -1
            r1 = 1
            if (r10 == r1) goto L_0x0019
            if (r10 != r0) goto L_0x0011
            goto L_0x0019
        L_0x0011:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "mu must be 1 or -1"
            r8.<init>(r9)
            throw r8
        L_0x0019:
            java.math.BigInteger r2 = r8.round()
            java.math.BigInteger r3 = r9.round()
            org.bouncycastle.math.ec.SimpleBigDecimal r8 = r8.subtract((java.math.BigInteger) r2)
            org.bouncycastle.math.ec.SimpleBigDecimal r9 = r9.subtract((java.math.BigInteger) r3)
            org.bouncycastle.math.ec.SimpleBigDecimal r4 = r8.add((org.bouncycastle.math.ec.SimpleBigDecimal) r8)
            if (r10 != r1) goto L_0x0034
            org.bouncycastle.math.ec.SimpleBigDecimal r4 = r4.add((org.bouncycastle.math.ec.SimpleBigDecimal) r9)
            goto L_0x0038
        L_0x0034:
            org.bouncycastle.math.ec.SimpleBigDecimal r4 = r4.subtract((org.bouncycastle.math.ec.SimpleBigDecimal) r9)
        L_0x0038:
            org.bouncycastle.math.ec.SimpleBigDecimal r5 = r9.add((org.bouncycastle.math.ec.SimpleBigDecimal) r9)
            org.bouncycastle.math.ec.SimpleBigDecimal r5 = r5.add((org.bouncycastle.math.ec.SimpleBigDecimal) r9)
            org.bouncycastle.math.ec.SimpleBigDecimal r9 = r5.add((org.bouncycastle.math.ec.SimpleBigDecimal) r9)
            if (r10 != r1) goto L_0x004f
            org.bouncycastle.math.ec.SimpleBigDecimal r5 = r8.subtract((org.bouncycastle.math.ec.SimpleBigDecimal) r5)
            org.bouncycastle.math.ec.SimpleBigDecimal r8 = r8.add((org.bouncycastle.math.ec.SimpleBigDecimal) r9)
            goto L_0x0057
        L_0x004f:
            org.bouncycastle.math.ec.SimpleBigDecimal r5 = r8.add((org.bouncycastle.math.ec.SimpleBigDecimal) r5)
            org.bouncycastle.math.ec.SimpleBigDecimal r8 = r8.subtract((org.bouncycastle.math.ec.SimpleBigDecimal) r9)
        L_0x0057:
            java.math.BigInteger r9 = org.bouncycastle.math.ec.ECConstants.ONE
            int r6 = r4.compareTo((java.math.BigInteger) r9)
            r7 = 0
            if (r6 < 0) goto L_0x0069
            java.math.BigInteger r6 = MINUS_ONE
            int r6 = r5.compareTo((java.math.BigInteger) r6)
            if (r6 >= 0) goto L_0x0075
            goto L_0x0071
        L_0x0069:
            java.math.BigInteger r1 = org.bouncycastle.math.ec.ECConstants.TWO
            int r1 = r8.compareTo((java.math.BigInteger) r1)
            if (r1 < 0) goto L_0x0074
        L_0x0071:
            r1 = r7
            r7 = r10
            goto L_0x0075
        L_0x0074:
            r1 = r7
        L_0x0075:
            java.math.BigInteger r6 = MINUS_ONE
            int r4 = r4.compareTo((java.math.BigInteger) r6)
            if (r4 >= 0) goto L_0x0084
            int r8 = r5.compareTo((java.math.BigInteger) r9)
            if (r8 < 0) goto L_0x008f
            goto L_0x008c
        L_0x0084:
            java.math.BigInteger r9 = MINUS_TWO
            int r8 = r8.compareTo((java.math.BigInteger) r9)
            if (r8 >= 0) goto L_0x008e
        L_0x008c:
            int r8 = -r10
            byte r7 = (byte) r8
        L_0x008e:
            r0 = r1
        L_0x008f:
            long r8 = (long) r0
            java.math.BigInteger r8 = java.math.BigInteger.valueOf(r8)
            java.math.BigInteger r8 = r2.add(r8)
            long r9 = (long) r7
            java.math.BigInteger r9 = java.math.BigInteger.valueOf(r9)
            java.math.BigInteger r9 = r3.add(r9)
            org.bouncycastle.math.ec.ZTauElement r10 = new org.bouncycastle.math.ec.ZTauElement
            r10.<init>(r8, r9)
            return r10
        L_0x00a7:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "lambda0 and lambda1 do not have same scale"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.math.ec.Tnaf.round(org.bouncycastle.math.ec.SimpleBigDecimal, org.bouncycastle.math.ec.SimpleBigDecimal, byte):org.bouncycastle.math.ec.ZTauElement");
    }

    public static ECPoint.AbstractF2m tau(ECPoint.AbstractF2m abstractF2m) {
        return abstractF2m.tau();
    }

    public static byte[] tauAdicNaf(byte b10, ZTauElement zTauElement) {
        BigInteger bigInteger;
        if (b10 == 1 || b10 == -1) {
            int bitLength = norm(b10, zTauElement).bitLength();
            byte[] bArr = new byte[(bitLength > 30 ? bitLength + 4 : 34)];
            BigInteger bigInteger2 = zTauElement.f23908u;
            BigInteger bigInteger3 = zTauElement.f23909v;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                BigInteger bigInteger4 = ECConstants.ZERO;
                if (!bigInteger.equals(bigInteger4) || !bigInteger3.equals(bigInteger4)) {
                    if (bigInteger.testBit(0)) {
                        byte intValue = (byte) ECConstants.TWO.subtract(bigInteger.subtract(bigInteger3.shiftLeft(1)).mod(ECConstants.FOUR)).intValue();
                        bArr[i11] = intValue;
                        bigInteger = intValue == 1 ? bigInteger.clearBit(0) : bigInteger.add(ECConstants.ONE);
                        i10 = i11;
                    } else {
                        bArr[i11] = 0;
                    }
                    BigInteger shiftRight = bigInteger.shiftRight(1);
                    BigInteger add = b10 == 1 ? bigInteger3.add(shiftRight) : bigInteger3.subtract(shiftRight);
                    i11++;
                    BigInteger negate = bigInteger.shiftRight(1).negate();
                    bigInteger2 = add;
                    bigInteger3 = negate;
                } else {
                    int i12 = i10 + 1;
                    byte[] bArr2 = new byte[i12];
                    System.arraycopy(bArr, 0, bArr2, 0, i12);
                    return bArr2;
                }
            }
        } else {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
    }

    public static byte[] tauAdicWNaf(byte b10, ZTauElement zTauElement, byte b11, BigInteger bigInteger, BigInteger bigInteger2, ZTauElement[] zTauElementArr) {
        boolean z10;
        if (b10 == 1 || b10 == -1) {
            int bitLength = norm(b10, zTauElement).bitLength();
            byte[] bArr = new byte[(bitLength > 30 ? bitLength + 4 + b11 : b11 + 34)];
            BigInteger shiftRight = bigInteger.shiftRight(1);
            BigInteger bigInteger3 = zTauElement.f23908u;
            BigInteger bigInteger4 = zTauElement.f23909v;
            int i10 = 0;
            while (true) {
                BigInteger bigInteger5 = ECConstants.ZERO;
                if (bigInteger3.equals(bigInteger5) && bigInteger4.equals(bigInteger5)) {
                    return bArr;
                }
                if (bigInteger3.testBit(0)) {
                    BigInteger mod = bigInteger3.add(bigInteger4.multiply(bigInteger2)).mod(bigInteger);
                    if (mod.compareTo(shiftRight) >= 0) {
                        mod = mod.subtract(bigInteger);
                    }
                    byte intValue = (byte) mod.intValue();
                    bArr[i10] = intValue;
                    if (intValue < 0) {
                        intValue = (byte) (-intValue);
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    if (z10) {
                        bigInteger3 = bigInteger3.subtract(zTauElementArr[intValue].f23908u);
                        bigInteger4 = bigInteger4.subtract(zTauElementArr[intValue].f23909v);
                    } else {
                        bigInteger3 = bigInteger3.add(zTauElementArr[intValue].f23908u);
                        bigInteger4 = bigInteger4.add(zTauElementArr[intValue].f23909v);
                    }
                } else {
                    bArr[i10] = 0;
                }
                BigInteger shiftRight2 = bigInteger3.shiftRight(1);
                BigInteger add = b10 == 1 ? bigInteger4.add(shiftRight2) : bigInteger4.subtract(shiftRight2);
                i10++;
                BigInteger negate = bigInteger3.shiftRight(1).negate();
                bigInteger3 = add;
                bigInteger4 = negate;
            }
        } else {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
    }
}
