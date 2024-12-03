package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.endo.ECEndomorphism;
import org.bouncycastle.math.ec.endo.EndoUtil;
import org.bouncycastle.math.ec.endo.GLVEndomorphism;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.PolynomialExtensionField;
import org.bouncycastle.math.raw.Nat;

public class ECAlgorithms {
    public static ECPoint cleanPoint(ECCurve eCCurve, ECPoint eCPoint) {
        if (eCCurve.equals(eCPoint.getCurve())) {
            return eCCurve.decodePoint(eCPoint.getEncoded(false));
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    static ECPoint implCheckResult(ECPoint eCPoint) {
        if (eCPoint.isValidPartial()) {
            return eCPoint;
        }
        throw new IllegalStateException("Invalid result");
    }

    private static ECPoint implShamirsTrickFixedPoint(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        ECPoint add;
        ECPoint offset;
        BigInteger bigInteger3 = bigInteger;
        BigInteger bigInteger4 = bigInteger2;
        ECCurve curve = eCPoint.getCurve();
        int combSize = FixedPointUtil.getCombSize(curve);
        if (bigInteger.bitLength() > combSize || bigInteger2.bitLength() > combSize) {
            throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
        }
        FixedPointPreCompInfo precompute = FixedPointUtil.precompute(eCPoint);
        FixedPointPreCompInfo precompute2 = FixedPointUtil.precompute(eCPoint2);
        ECLookupTable lookupTable = precompute.getLookupTable();
        ECLookupTable lookupTable2 = precompute2.getLookupTable();
        int width = precompute.getWidth();
        if (width != precompute2.getWidth()) {
            FixedPointCombMultiplier fixedPointCombMultiplier = new FixedPointCombMultiplier();
            add = fixedPointCombMultiplier.multiply(eCPoint, bigInteger3);
            offset = fixedPointCombMultiplier.multiply(eCPoint2, bigInteger4);
        } else {
            int i10 = ((combSize + width) - 1) / width;
            ECPoint infinity = curve.getInfinity();
            int i11 = width * i10;
            int[] fromBigInteger = Nat.fromBigInteger(i11, bigInteger3);
            int[] fromBigInteger2 = Nat.fromBigInteger(i11, bigInteger4);
            int i12 = i11 - 1;
            for (int i13 = 0; i13 < i10; i13++) {
                int i14 = 0;
                int i15 = 0;
                for (int i16 = i12 - i13; i16 >= 0; i16 -= i10) {
                    int i17 = i16 >>> 5;
                    int i18 = i16 & 31;
                    int i19 = fromBigInteger[i17] >>> i18;
                    i14 = ((i14 ^ (i19 >>> 1)) << 1) ^ i19;
                    int i20 = fromBigInteger2[i17] >>> i18;
                    i15 = ((i15 ^ (i20 >>> 1)) << 1) ^ i20;
                }
                infinity = infinity.twicePlus(lookupTable.lookupVar(i14).add(lookupTable2.lookupVar(i15)));
            }
            add = infinity.add(precompute.getOffset());
            offset = precompute2.getOffset();
        }
        return add.add(offset);
    }

    static ECPoint implShamirsTrickJsf(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        ECCurve curve = eCPoint.getCurve();
        ECPoint infinity = curve.getInfinity();
        ECPoint[] eCPointArr = {eCPoint2, eCPoint.subtract(eCPoint2), eCPoint, eCPoint.add(eCPoint2)};
        curve.normalizeAll(eCPointArr);
        ECPoint[] eCPointArr2 = {eCPointArr[3].negate(), eCPointArr[2].negate(), eCPointArr[1].negate(), eCPointArr[0].negate(), infinity, eCPointArr[0], eCPointArr[1], eCPointArr[2], eCPointArr[3]};
        byte[] generateJSF = WNafUtil.generateJSF(bigInteger, bigInteger2);
        int length = generateJSF.length;
        while (true) {
            length--;
            if (length < 0) {
                return infinity;
            }
            byte b10 = generateJSF[length];
            infinity = infinity.twicePlus(eCPointArr2[(((b10 << 24) >> 28) * 3) + 4 + ((b10 << 28) >> 28)]);
        }
    }

    static ECPoint implShamirsTrickWNaf(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        boolean z10 = false;
        boolean z11 = bigInteger.signum() < 0;
        if (bigInteger2.signum() < 0) {
            z10 = true;
        }
        BigInteger abs = bigInteger.abs();
        BigInteger abs2 = bigInteger2.abs();
        int windowSize = WNafUtil.getWindowSize(abs.bitLength(), 8);
        int windowSize2 = WNafUtil.getWindowSize(abs2.bitLength(), 8);
        WNafPreCompInfo precompute = WNafUtil.precompute(eCPoint, windowSize, true);
        WNafPreCompInfo precompute2 = WNafUtil.precompute(eCPoint2, windowSize2, true);
        int combSize = FixedPointUtil.getCombSize(eCPoint.getCurve());
        if (!z11 && !z10 && bigInteger.bitLength() <= combSize && bigInteger2.bitLength() <= combSize && precompute.isPromoted() && precompute2.isPromoted()) {
            return implShamirsTrickFixedPoint(eCPoint, bigInteger, eCPoint2, bigInteger2);
        }
        return implShamirsTrickWNaf(z11 ? precompute.getPreCompNeg() : precompute.getPreComp(), z11 ? precompute.getPreComp() : precompute.getPreCompNeg(), WNafUtil.generateWindowNaf(Math.min(8, precompute.getWidth()), abs), z10 ? precompute2.getPreCompNeg() : precompute2.getPreComp(), z10 ? precompute2.getPreComp() : precompute2.getPreCompNeg(), WNafUtil.generateWindowNaf(Math.min(8, precompute2.getWidth()), abs2));
    }

    static ECPoint implShamirsTrickWNaf(ECEndomorphism eCEndomorphism, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        boolean z10 = false;
        boolean z11 = bigInteger.signum() < 0;
        if (bigInteger2.signum() < 0) {
            z10 = true;
        }
        BigInteger abs = bigInteger.abs();
        BigInteger abs2 = bigInteger2.abs();
        WNafPreCompInfo precompute = WNafUtil.precompute(eCPoint, WNafUtil.getWindowSize(Math.max(abs.bitLength(), abs2.bitLength()), 8), true);
        WNafPreCompInfo precomputeWithPointMap = WNafUtil.precomputeWithPointMap(EndoUtil.mapPoint(eCEndomorphism, eCPoint), eCEndomorphism.getPointMap(), precompute, true);
        return implShamirsTrickWNaf(z11 ? precompute.getPreCompNeg() : precompute.getPreComp(), z11 ? precompute.getPreComp() : precompute.getPreCompNeg(), WNafUtil.generateWindowNaf(Math.min(8, precompute.getWidth()), abs), z10 ? precomputeWithPointMap.getPreCompNeg() : precomputeWithPointMap.getPreComp(), z10 ? precomputeWithPointMap.getPreComp() : precomputeWithPointMap.getPreCompNeg(), WNafUtil.generateWindowNaf(Math.min(8, precomputeWithPointMap.getWidth()), abs2));
    }

    private static ECPoint implShamirsTrickWNaf(ECPoint[] eCPointArr, ECPoint[] eCPointArr2, byte[] bArr, ECPoint[] eCPointArr3, ECPoint[] eCPointArr4, byte[] bArr2) {
        ECPoint eCPoint;
        int max = Math.max(bArr.length, bArr2.length);
        ECPoint infinity = eCPointArr[0].getCurve().getInfinity();
        int i10 = max - 1;
        int i11 = 0;
        ECPoint eCPoint2 = infinity;
        while (i10 >= 0) {
            byte b10 = i10 < bArr.length ? bArr[i10] : 0;
            byte b11 = i10 < bArr2.length ? bArr2[i10] : 0;
            if ((b10 | b11) == 0) {
                i11++;
            } else {
                if (b10 != 0) {
                    eCPoint = infinity.add((b10 < 0 ? eCPointArr2 : eCPointArr)[Math.abs(b10) >>> 1]);
                } else {
                    eCPoint = infinity;
                }
                if (b11 != 0) {
                    eCPoint = eCPoint.add((b11 < 0 ? eCPointArr4 : eCPointArr3)[Math.abs(b11) >>> 1]);
                }
                if (i11 > 0) {
                    eCPoint2 = eCPoint2.timesPow2(i11);
                    i11 = 0;
                }
                eCPoint2 = eCPoint2.twicePlus(eCPoint);
            }
            i10--;
        }
        return i11 > 0 ? eCPoint2.timesPow2(i11) : eCPoint2;
    }

    static ECPoint implSumOfMultiplies(ECEndomorphism eCEndomorphism, ECPoint[] eCPointArr, BigInteger[] bigIntegerArr) {
        ECPoint[] eCPointArr2 = eCPointArr;
        int length = eCPointArr2.length;
        int i10 = length << 1;
        boolean[] zArr = new boolean[i10];
        WNafPreCompInfo[] wNafPreCompInfoArr = new WNafPreCompInfo[i10];
        byte[][] bArr = new byte[i10][];
        ECPointMap pointMap = eCEndomorphism.getPointMap();
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 << 1;
            int i13 = i12 + 1;
            BigInteger bigInteger = bigIntegerArr[i12];
            zArr[i12] = bigInteger.signum() < 0;
            BigInteger abs = bigInteger.abs();
            BigInteger bigInteger2 = bigIntegerArr[i13];
            zArr[i13] = bigInteger2.signum() < 0;
            BigInteger abs2 = bigInteger2.abs();
            int windowSize = WNafUtil.getWindowSize(Math.max(abs.bitLength(), abs2.bitLength()), 8);
            ECPoint eCPoint = eCPointArr2[i11];
            WNafPreCompInfo precompute = WNafUtil.precompute(eCPoint, windowSize, true);
            WNafPreCompInfo precomputeWithPointMap = WNafUtil.precomputeWithPointMap(EndoUtil.mapPoint(eCEndomorphism, eCPoint), pointMap, precompute, true);
            int min = Math.min(8, precompute.getWidth());
            int min2 = Math.min(8, precomputeWithPointMap.getWidth());
            wNafPreCompInfoArr[i12] = precompute;
            wNafPreCompInfoArr[i13] = precomputeWithPointMap;
            bArr[i12] = WNafUtil.generateWindowNaf(min, abs);
            bArr[i13] = WNafUtil.generateWindowNaf(min2, abs2);
            i11++;
            eCPointArr2 = eCPointArr;
        }
        return implSumOfMultiplies(zArr, wNafPreCompInfoArr, bArr);
    }

    static ECPoint implSumOfMultiplies(ECPoint[] eCPointArr, BigInteger[] bigIntegerArr) {
        int length = eCPointArr.length;
        boolean[] zArr = new boolean[length];
        WNafPreCompInfo[] wNafPreCompInfoArr = new WNafPreCompInfo[length];
        byte[][] bArr = new byte[length][];
        for (int i10 = 0; i10 < length; i10++) {
            BigInteger bigInteger = bigIntegerArr[i10];
            zArr[i10] = bigInteger.signum() < 0;
            BigInteger abs = bigInteger.abs();
            WNafPreCompInfo precompute = WNafUtil.precompute(eCPointArr[i10], WNafUtil.getWindowSize(abs.bitLength(), 8), true);
            int min = Math.min(8, precompute.getWidth());
            wNafPreCompInfoArr[i10] = precompute;
            bArr[i10] = WNafUtil.generateWindowNaf(min, abs);
        }
        return implSumOfMultiplies(zArr, wNafPreCompInfoArr, bArr);
    }

    private static ECPoint implSumOfMultiplies(boolean[] zArr, WNafPreCompInfo[] wNafPreCompInfoArr, byte[][] bArr) {
        int i10 = 0;
        for (byte[] length : bArr) {
            i10 = Math.max(i10, length.length);
        }
        ECPoint infinity = wNafPreCompInfoArr[0].getPreComp()[0].getCurve().getInfinity();
        int i11 = i10 - 1;
        int i12 = 0;
        ECPoint eCPoint = infinity;
        while (i11 >= 0) {
            ECPoint eCPoint2 = infinity;
            for (int i13 = 0; i13 < r0; i13++) {
                byte[] bArr2 = bArr[i13];
                byte b10 = i11 < bArr2.length ? bArr2[i11] : 0;
                if (b10 != 0) {
                    int abs = Math.abs(b10);
                    WNafPreCompInfo wNafPreCompInfo = wNafPreCompInfoArr[i13];
                    eCPoint2 = eCPoint2.add(((b10 < 0) == zArr[i13] ? wNafPreCompInfo.getPreComp() : wNafPreCompInfo.getPreCompNeg())[abs >>> 1]);
                }
            }
            if (eCPoint2 == infinity) {
                i12++;
            } else {
                if (i12 > 0) {
                    eCPoint = eCPoint.timesPow2(i12);
                    i12 = 0;
                }
                eCPoint = eCPoint.twicePlus(eCPoint2);
            }
            i11--;
        }
        return i12 > 0 ? eCPoint.timesPow2(i12) : eCPoint;
    }

    static ECPoint implSumOfMultipliesGLV(ECPoint[] eCPointArr, BigInteger[] bigIntegerArr, GLVEndomorphism gLVEndomorphism) {
        BigInteger order = eCPointArr[0].getCurve().getOrder();
        int i10 = r2 << 1;
        BigInteger[] bigIntegerArr2 = new BigInteger[i10];
        int i11 = 0;
        for (int i12 = 0; i12 < r2; i12++) {
            BigInteger[] decomposeScalar = gLVEndomorphism.decomposeScalar(bigIntegerArr[i12].mod(order));
            int i13 = i11 + 1;
            bigIntegerArr2[i11] = decomposeScalar[0];
            i11 = i13 + 1;
            bigIntegerArr2[i13] = decomposeScalar[1];
        }
        if (gLVEndomorphism.hasEfficientPointMap()) {
            return implSumOfMultiplies((ECEndomorphism) gLVEndomorphism, eCPointArr, bigIntegerArr2);
        }
        ECPoint[] eCPointArr2 = new ECPoint[i10];
        int i14 = 0;
        for (ECPoint eCPoint : eCPointArr) {
            ECPoint mapPoint = EndoUtil.mapPoint(gLVEndomorphism, eCPoint);
            int i15 = i14 + 1;
            eCPointArr2[i14] = eCPoint;
            i14 = i15 + 1;
            eCPointArr2[i15] = mapPoint;
        }
        return implSumOfMultiplies(eCPointArr2, bigIntegerArr2);
    }

    public static ECPoint importPoint(ECCurve eCCurve, ECPoint eCPoint) {
        if (eCCurve.equals(eCPoint.getCurve())) {
            return eCCurve.importPoint(eCPoint);
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    public static boolean isF2mCurve(ECCurve eCCurve) {
        return isF2mField(eCCurve.getField());
    }

    public static boolean isF2mField(FiniteField finiteField) {
        return finiteField.getDimension() > 1 && finiteField.getCharacteristic().equals(ECConstants.TWO) && (finiteField instanceof PolynomialExtensionField);
    }

    public static boolean isFpCurve(ECCurve eCCurve) {
        return isFpField(eCCurve.getField());
    }

    public static boolean isFpField(FiniteField finiteField) {
        return finiteField.getDimension() == 1;
    }

    public static void montgomeryTrick(ECFieldElement[] eCFieldElementArr, int i10, int i11) {
        montgomeryTrick(eCFieldElementArr, i10, i11, (ECFieldElement) null);
    }

    public static void montgomeryTrick(ECFieldElement[] eCFieldElementArr, int i10, int i11, ECFieldElement eCFieldElement) {
        ECFieldElement[] eCFieldElementArr2 = new ECFieldElement[i11];
        int i12 = 0;
        eCFieldElementArr2[0] = eCFieldElementArr[i10];
        while (true) {
            i12++;
            if (i12 >= i11) {
                break;
            }
            eCFieldElementArr2[i12] = eCFieldElementArr2[i12 - 1].multiply(eCFieldElementArr[i10 + i12]);
        }
        int i13 = i12 - 1;
        if (eCFieldElement != null) {
            eCFieldElementArr2[i13] = eCFieldElementArr2[i13].multiply(eCFieldElement);
        }
        ECFieldElement invert = eCFieldElementArr2[i13].invert();
        while (i13 > 0) {
            int i14 = i13 - 1;
            int i15 = i13 + i10;
            ECFieldElement eCFieldElement2 = eCFieldElementArr[i15];
            eCFieldElementArr[i15] = eCFieldElementArr2[i14].multiply(invert);
            invert = invert.multiply(eCFieldElement2);
            i13 = i14;
        }
        eCFieldElementArr[i10] = invert;
    }

    public static ECPoint referenceMultiply(ECPoint eCPoint, BigInteger bigInteger) {
        BigInteger abs = bigInteger.abs();
        ECPoint infinity = eCPoint.getCurve().getInfinity();
        int bitLength = abs.bitLength();
        if (bitLength > 0) {
            if (abs.testBit(0)) {
                infinity = eCPoint;
            }
            for (int i10 = 1; i10 < bitLength; i10++) {
                eCPoint = eCPoint.twice();
                if (abs.testBit(i10)) {
                    infinity = infinity.add(eCPoint);
                }
            }
        }
        return bigInteger.signum() < 0 ? infinity.negate() : infinity;
    }

    public static ECPoint shamirsTrick(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        return implCheckResult(implShamirsTrickJsf(eCPoint, bigInteger, importPoint(eCPoint.getCurve(), eCPoint2), bigInteger2));
    }

    public static ECPoint sumOfMultiplies(ECPoint[] eCPointArr, BigInteger[] bigIntegerArr) {
        if (!(eCPointArr == null || bigIntegerArr == null || eCPointArr.length != bigIntegerArr.length)) {
            if (eCPointArr.length >= 1) {
                int length = eCPointArr.length;
                if (length == 1) {
                    return eCPointArr[0].multiply(bigIntegerArr[0]);
                }
                if (length == 2) {
                    return sumOfTwoMultiplies(eCPointArr[0], bigIntegerArr[0], eCPointArr[1], bigIntegerArr[1]);
                }
                ECPoint eCPoint = eCPointArr[0];
                ECCurve curve = eCPoint.getCurve();
                ECPoint[] eCPointArr2 = new ECPoint[length];
                eCPointArr2[0] = eCPoint;
                for (int i10 = 1; i10 < length; i10++) {
                    eCPointArr2[i10] = importPoint(curve, eCPointArr[i10]);
                }
                ECEndomorphism endomorphism = curve.getEndomorphism();
                return endomorphism instanceof GLVEndomorphism ? implCheckResult(implSumOfMultipliesGLV(eCPointArr2, bigIntegerArr, (GLVEndomorphism) endomorphism)) : implCheckResult(implSumOfMultiplies(eCPointArr2, bigIntegerArr));
            }
        }
        throw new IllegalArgumentException("point and scalar arrays should be non-null, and of equal, non-zero, length");
    }

    public static ECPoint sumOfTwoMultiplies(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        ECPoint implShamirsTrickWNaf;
        ECCurve curve = eCPoint.getCurve();
        ECPoint importPoint = importPoint(curve, eCPoint2);
        if (!(curve instanceof ECCurve.AbstractF2m) || !((ECCurve.AbstractF2m) curve).isKoblitz()) {
            ECEndomorphism endomorphism = curve.getEndomorphism();
            if (endomorphism instanceof GLVEndomorphism) {
                implShamirsTrickWNaf = implSumOfMultipliesGLV(new ECPoint[]{eCPoint, importPoint}, new BigInteger[]{bigInteger, bigInteger2}, (GLVEndomorphism) endomorphism);
            } else {
                implShamirsTrickWNaf = implShamirsTrickWNaf(eCPoint, bigInteger, importPoint, bigInteger2);
            }
        } else {
            implShamirsTrickWNaf = eCPoint.multiply(bigInteger).add(importPoint.multiply(bigInteger2));
        }
        return implCheckResult(implShamirsTrickWNaf);
    }

    public static ECPoint validatePoint(ECPoint eCPoint) {
        if (eCPoint.isValid()) {
            return eCPoint;
        }
        throw new IllegalStateException("Invalid point");
    }
}
