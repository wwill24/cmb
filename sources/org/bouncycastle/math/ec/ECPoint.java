package org.bouncycastle.math.ec;

import java.math.BigInteger;
import java.util.Hashtable;
import org.apache.commons.beanutils.PropertyUtils;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;

public abstract class ECPoint {
    protected static final ECFieldElement[] EMPTY_ZS = new ECFieldElement[0];
    protected ECCurve curve;
    protected Hashtable preCompTable;

    /* renamed from: x  reason: collision with root package name */
    protected ECFieldElement f23906x;

    /* renamed from: y  reason: collision with root package name */
    protected ECFieldElement f23907y;
    protected ECFieldElement[] zs;

    public static abstract class AbstractF2m extends ECPoint {
        protected AbstractF2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
        }

        protected AbstractF2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }

        /* access modifiers changed from: protected */
        public boolean satisfiesCurveEquation() {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECCurve curve = getCurve();
            ECFieldElement eCFieldElement3 = this.f23906x;
            ECFieldElement a10 = curve.getA();
            ECFieldElement b10 = curve.getB();
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem == 6) {
                ECFieldElement eCFieldElement4 = this.zs[0];
                boolean isOne = eCFieldElement4.isOne();
                if (eCFieldElement3.isZero()) {
                    ECFieldElement square = this.f23907y.square();
                    if (!isOne) {
                        b10 = b10.multiply(eCFieldElement4.square());
                    }
                    return square.equals(b10);
                }
                ECFieldElement eCFieldElement5 = this.f23907y;
                ECFieldElement square2 = eCFieldElement3.square();
                if (isOne) {
                    eCFieldElement2 = eCFieldElement5.square().add(eCFieldElement5).add(a10);
                    eCFieldElement = square2.square().add(b10);
                } else {
                    ECFieldElement square3 = eCFieldElement4.square();
                    ECFieldElement square4 = square3.square();
                    eCFieldElement2 = eCFieldElement5.add(eCFieldElement4).multiplyPlusProduct(eCFieldElement5, a10, square3);
                    eCFieldElement = square2.squarePlusProduct(b10, square4);
                }
                return eCFieldElement2.multiply(square2).equals(eCFieldElement);
            }
            ECFieldElement eCFieldElement6 = this.f23907y;
            ECFieldElement multiply = eCFieldElement6.add(eCFieldElement3).multiply(eCFieldElement6);
            if (coordinateSystem != 0) {
                if (coordinateSystem == 1) {
                    ECFieldElement eCFieldElement7 = this.zs[0];
                    if (!eCFieldElement7.isOne()) {
                        ECFieldElement multiply2 = eCFieldElement7.multiply(eCFieldElement7.square());
                        multiply = multiply.multiply(eCFieldElement7);
                        a10 = a10.multiply(eCFieldElement7);
                        b10 = b10.multiply(multiply2);
                    }
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
            return multiply.equals(eCFieldElement3.add(a10).multiply(eCFieldElement3.square()).add(b10));
        }

        /* access modifiers changed from: protected */
        public boolean satisfiesOrder() {
            BigInteger cofactor = this.curve.getCofactor();
            if (ECConstants.TWO.equals(cofactor)) {
                return ((ECFieldElement.AbstractF2m) normalize().getAffineXCoord()).trace() != 0;
            }
            if (!ECConstants.FOUR.equals(cofactor)) {
                return ECPoint.super.satisfiesOrder();
            }
            ECPoint normalize = normalize();
            ECFieldElement affineXCoord = normalize.getAffineXCoord();
            ECCurve eCCurve = this.curve;
            ECFieldElement solveQuadraticEquation = ((ECCurve.AbstractF2m) eCCurve).solveQuadraticEquation(affineXCoord.add(eCCurve.getA()));
            if (solveQuadraticEquation == null) {
                return false;
            }
            return ((ECFieldElement.AbstractF2m) affineXCoord.multiply(solveQuadraticEquation).add(normalize.getAffineYCoord())).trace() == 0;
        }

        public ECPoint scaleX(ECFieldElement eCFieldElement) {
            if (isInfinity()) {
                return this;
            }
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem == 5) {
                ECFieldElement rawXCoord = getRawXCoord();
                ECFieldElement rawYCoord = getRawYCoord();
                return getCurve().createRawPoint(rawXCoord, rawYCoord.add(rawXCoord).divide(eCFieldElement).add(rawXCoord.multiply(eCFieldElement)), getRawZCoords());
            } else if (curveCoordinateSystem != 6) {
                return ECPoint.super.scaleX(eCFieldElement);
            } else {
                ECFieldElement rawXCoord2 = getRawXCoord();
                ECFieldElement rawYCoord2 = getRawYCoord();
                ECFieldElement eCFieldElement2 = getRawZCoords()[0];
                ECFieldElement multiply = rawXCoord2.multiply(eCFieldElement.square());
                ECFieldElement add = rawYCoord2.add(rawXCoord2).add(multiply);
                ECFieldElement multiply2 = eCFieldElement2.multiply(eCFieldElement);
                return getCurve().createRawPoint(multiply, add, new ECFieldElement[]{multiply2});
            }
        }

        public ECPoint scaleXNegateY(ECFieldElement eCFieldElement) {
            return scaleX(eCFieldElement);
        }

        public ECPoint scaleY(ECFieldElement eCFieldElement) {
            if (isInfinity()) {
                return this;
            }
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem != 5 && curveCoordinateSystem != 6) {
                return ECPoint.super.scaleY(eCFieldElement);
            }
            ECFieldElement rawXCoord = getRawXCoord();
            return getCurve().createRawPoint(rawXCoord, getRawYCoord().add(rawXCoord).multiply(eCFieldElement).add(rawXCoord), getRawZCoords());
        }

        public ECPoint scaleYNegateX(ECFieldElement eCFieldElement) {
            return scaleY(eCFieldElement);
        }

        public ECPoint subtract(ECPoint eCPoint) {
            return eCPoint.isInfinity() ? this : add(eCPoint.negate());
        }

        public AbstractF2m tau() {
            ECPoint createRawPoint;
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElement = this.f23906x;
            if (coordinateSystem != 0) {
                if (coordinateSystem != 1) {
                    if (coordinateSystem != 5) {
                        if (coordinateSystem != 6) {
                            throw new IllegalStateException("unsupported coordinate system");
                        }
                    }
                }
                ECFieldElement eCFieldElement2 = this.f23907y;
                ECFieldElement eCFieldElement3 = this.zs[0];
                createRawPoint = curve.createRawPoint(eCFieldElement.square(), eCFieldElement2.square(), new ECFieldElement[]{eCFieldElement3.square()});
                return (AbstractF2m) createRawPoint;
            }
            createRawPoint = curve.createRawPoint(eCFieldElement.square(), this.f23907y.square());
            return (AbstractF2m) createRawPoint;
        }

        public AbstractF2m tauPow(int i10) {
            ECPoint createRawPoint;
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElement = this.f23906x;
            if (coordinateSystem != 0) {
                if (coordinateSystem != 1) {
                    if (coordinateSystem != 5) {
                        if (coordinateSystem != 6) {
                            throw new IllegalStateException("unsupported coordinate system");
                        }
                    }
                }
                ECFieldElement eCFieldElement2 = this.f23907y;
                ECFieldElement eCFieldElement3 = this.zs[0];
                createRawPoint = curve.createRawPoint(eCFieldElement.squarePow(i10), eCFieldElement2.squarePow(i10), new ECFieldElement[]{eCFieldElement3.squarePow(i10)});
                return (AbstractF2m) createRawPoint;
            }
            createRawPoint = curve.createRawPoint(eCFieldElement.squarePow(i10), this.f23907y.squarePow(i10));
            return (AbstractF2m) createRawPoint;
        }
    }

    public static abstract class AbstractFp extends ECPoint {
        protected AbstractFp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
        }

        protected AbstractFp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }

        /* access modifiers changed from: protected */
        public boolean getCompressionYTilde() {
            return getAffineYCoord().testBitZero();
        }

        /* access modifiers changed from: protected */
        public boolean satisfiesCurveEquation() {
            ECFieldElement eCFieldElement = this.f23906x;
            ECFieldElement eCFieldElement2 = this.f23907y;
            ECFieldElement a10 = this.curve.getA();
            ECFieldElement b10 = this.curve.getB();
            ECFieldElement square = eCFieldElement2.square();
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem != 0) {
                if (curveCoordinateSystem == 1) {
                    ECFieldElement eCFieldElement3 = this.zs[0];
                    if (!eCFieldElement3.isOne()) {
                        ECFieldElement square2 = eCFieldElement3.square();
                        ECFieldElement multiply = eCFieldElement3.multiply(square2);
                        square = square.multiply(eCFieldElement3);
                        a10 = a10.multiply(square2);
                        b10 = b10.multiply(multiply);
                    }
                } else if (curveCoordinateSystem == 2 || curveCoordinateSystem == 3 || curveCoordinateSystem == 4) {
                    ECFieldElement eCFieldElement4 = this.zs[0];
                    if (!eCFieldElement4.isOne()) {
                        ECFieldElement square3 = eCFieldElement4.square();
                        ECFieldElement square4 = square3.square();
                        ECFieldElement multiply2 = square3.multiply(square4);
                        a10 = a10.multiply(square4);
                        b10 = b10.multiply(multiply2);
                    }
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
            return square.equals(eCFieldElement.square().add(a10).multiply(eCFieldElement).add(b10));
        }

        public ECPoint subtract(ECPoint eCPoint) {
            return eCPoint.isInfinity() ? this : add(eCPoint.negate());
        }
    }

    public static class F2m extends AbstractF2m {
        F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
        }

        F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }

        public ECPoint add(ECPoint eCPoint) {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECFieldElement eCFieldElement3;
            ECFieldElement eCFieldElement4;
            ECFieldElement eCFieldElement5;
            ECFieldElement eCFieldElement6;
            ECPoint eCPoint2 = eCPoint;
            if (isInfinity()) {
                return eCPoint2;
            }
            if (eCPoint.isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElement7 = this.f23906x;
            ECFieldElement eCFieldElement8 = eCPoint2.f23906x;
            if (coordinateSystem == 0) {
                ECFieldElement eCFieldElement9 = this.f23907y;
                ECFieldElement eCFieldElement10 = eCPoint2.f23907y;
                ECFieldElement add = eCFieldElement7.add(eCFieldElement8);
                ECFieldElement add2 = eCFieldElement9.add(eCFieldElement10);
                if (add.isZero()) {
                    return add2.isZero() ? twice() : curve.getInfinity();
                }
                ECFieldElement divide = add2.divide(add);
                ECFieldElement add3 = divide.square().add(divide).add(add).add(curve.getA());
                return new F2m(curve, add3, divide.multiply(eCFieldElement7.add(add3)).add(add3).add(eCFieldElement9));
            } else if (coordinateSystem == 1) {
                ECFieldElement eCFieldElement11 = this.f23907y;
                ECFieldElement eCFieldElement12 = this.zs[0];
                ECFieldElement eCFieldElement13 = eCPoint2.f23907y;
                ECFieldElement eCFieldElement14 = eCPoint2.zs[0];
                boolean isOne = eCFieldElement14.isOne();
                ECFieldElement add4 = eCFieldElement12.multiply(eCFieldElement13).add(isOne ? eCFieldElement11 : eCFieldElement11.multiply(eCFieldElement14));
                ECFieldElement add5 = eCFieldElement12.multiply(eCFieldElement8).add(isOne ? eCFieldElement7 : eCFieldElement7.multiply(eCFieldElement14));
                if (add5.isZero()) {
                    return add4.isZero() ? twice() : curve.getInfinity();
                }
                ECFieldElement square = add5.square();
                ECFieldElement multiply = square.multiply(add5);
                if (!isOne) {
                    eCFieldElement12 = eCFieldElement12.multiply(eCFieldElement14);
                }
                ECFieldElement add6 = add4.add(add5);
                ECFieldElement add7 = add6.multiplyPlusProduct(add4, square, curve.getA()).multiply(eCFieldElement12).add(multiply);
                ECFieldElement multiply2 = add5.multiply(add7);
                if (!isOne) {
                    square = square.multiply(eCFieldElement14);
                }
                return new F2m(curve, multiply2, add4.multiplyPlusProduct(eCFieldElement7, add5, eCFieldElement11).multiplyPlusProduct(square, add6, add7), new ECFieldElement[]{multiply.multiply(eCFieldElement12)});
            } else if (coordinateSystem != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            } else if (eCFieldElement7.isZero()) {
                return eCFieldElement8.isZero() ? curve.getInfinity() : eCPoint2.add(this);
            } else {
                ECFieldElement eCFieldElement15 = this.f23907y;
                ECFieldElement eCFieldElement16 = this.zs[0];
                ECFieldElement eCFieldElement17 = eCPoint2.f23907y;
                ECFieldElement eCFieldElement18 = eCPoint2.zs[0];
                boolean isOne2 = eCFieldElement16.isOne();
                if (!isOne2) {
                    eCFieldElement2 = eCFieldElement8.multiply(eCFieldElement16);
                    eCFieldElement = eCFieldElement17.multiply(eCFieldElement16);
                } else {
                    eCFieldElement2 = eCFieldElement8;
                    eCFieldElement = eCFieldElement17;
                }
                boolean isOne3 = eCFieldElement18.isOne();
                if (!isOne3) {
                    eCFieldElement7 = eCFieldElement7.multiply(eCFieldElement18);
                    eCFieldElement3 = eCFieldElement15.multiply(eCFieldElement18);
                } else {
                    eCFieldElement3 = eCFieldElement15;
                }
                ECFieldElement add8 = eCFieldElement3.add(eCFieldElement);
                ECFieldElement add9 = eCFieldElement7.add(eCFieldElement2);
                if (add9.isZero()) {
                    return add8.isZero() ? twice() : curve.getInfinity();
                }
                if (eCFieldElement8.isZero()) {
                    ECPoint normalize = normalize();
                    ECFieldElement xCoord = normalize.getXCoord();
                    ECFieldElement yCoord = normalize.getYCoord();
                    ECFieldElement divide2 = yCoord.add(eCFieldElement17).divide(xCoord);
                    eCFieldElement4 = divide2.square().add(divide2).add(xCoord).add(curve.getA());
                    if (eCFieldElement4.isZero()) {
                        return new F2m(curve, eCFieldElement4, curve.getB().sqrt());
                    }
                    eCFieldElement6 = divide2.multiply(xCoord.add(eCFieldElement4)).add(eCFieldElement4).add(yCoord).divide(eCFieldElement4).add(eCFieldElement4);
                    eCFieldElement5 = curve.fromBigInteger(ECConstants.ONE);
                } else {
                    ECFieldElement square2 = add9.square();
                    ECFieldElement multiply3 = add8.multiply(eCFieldElement7);
                    ECFieldElement multiply4 = add8.multiply(eCFieldElement2);
                    ECFieldElement multiply5 = multiply3.multiply(multiply4);
                    if (multiply5.isZero()) {
                        return new F2m(curve, multiply5, curve.getB().sqrt());
                    }
                    ECFieldElement multiply6 = add8.multiply(square2);
                    ECFieldElement multiply7 = !isOne3 ? multiply6.multiply(eCFieldElement18) : multiply6;
                    ECFieldElement squarePlusProduct = multiply4.add(square2).squarePlusProduct(multiply7, eCFieldElement15.add(eCFieldElement16));
                    if (!isOne2) {
                        multiply7 = multiply7.multiply(eCFieldElement16);
                    }
                    eCFieldElement4 = multiply5;
                    ECFieldElement eCFieldElement19 = squarePlusProduct;
                    eCFieldElement5 = multiply7;
                    eCFieldElement6 = eCFieldElement19;
                }
                return new F2m(curve, eCFieldElement4, eCFieldElement6, new ECFieldElement[]{eCFieldElement5});
            }
        }

        /* access modifiers changed from: protected */
        public ECPoint detach() {
            return new F2m((ECCurve) null, getAffineXCoord(), getAffineYCoord());
        }

        /* access modifiers changed from: protected */
        public boolean getCompressionYTilde() {
            ECFieldElement rawXCoord = getRawXCoord();
            if (rawXCoord.isZero()) {
                return false;
            }
            ECFieldElement rawYCoord = getRawYCoord();
            int curveCoordinateSystem = getCurveCoordinateSystem();
            return (curveCoordinateSystem == 5 || curveCoordinateSystem == 6) ? rawYCoord.testBitZero() != rawXCoord.testBitZero() : rawYCoord.divide(rawXCoord).testBitZero();
        }

        public ECFieldElement getYCoord() {
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem != 5 && curveCoordinateSystem != 6) {
                return this.f23907y;
            }
            ECFieldElement eCFieldElement = this.f23906x;
            ECFieldElement eCFieldElement2 = this.f23907y;
            if (isInfinity() || eCFieldElement.isZero()) {
                return eCFieldElement2;
            }
            ECFieldElement multiply = eCFieldElement2.add(eCFieldElement).multiply(eCFieldElement);
            if (6 != curveCoordinateSystem) {
                return multiply;
            }
            ECFieldElement eCFieldElement3 = this.zs[0];
            return !eCFieldElement3.isOne() ? multiply.divide(eCFieldElement3) : multiply;
        }

        public ECPoint negate() {
            if (isInfinity()) {
                return this;
            }
            ECFieldElement eCFieldElement = this.f23906x;
            if (eCFieldElement.isZero()) {
                return this;
            }
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem == 0) {
                return new F2m(this.curve, eCFieldElement, this.f23907y.add(eCFieldElement));
            } else if (curveCoordinateSystem == 1) {
                ECFieldElement eCFieldElement2 = this.f23907y;
                ECFieldElement eCFieldElement3 = this.zs[0];
                return new F2m(this.curve, eCFieldElement, eCFieldElement2.add(eCFieldElement), new ECFieldElement[]{eCFieldElement3});
            } else if (curveCoordinateSystem == 5) {
                return new F2m(this.curve, eCFieldElement, this.f23907y.addOne());
            } else if (curveCoordinateSystem == 6) {
                ECFieldElement eCFieldElement4 = this.f23907y;
                ECFieldElement eCFieldElement5 = this.zs[0];
                return new F2m(this.curve, eCFieldElement, eCFieldElement4.add(eCFieldElement5), new ECFieldElement[]{eCFieldElement5});
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        public ECPoint twice() {
            ECFieldElement eCFieldElement;
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            ECFieldElement eCFieldElement2 = this.f23906x;
            if (eCFieldElement2.isZero()) {
                return curve.getInfinity();
            }
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem == 0) {
                ECFieldElement add = this.f23907y.divide(eCFieldElement2).add(eCFieldElement2);
                ECFieldElement add2 = add.square().add(add).add(curve.getA());
                return new F2m(curve, add2, eCFieldElement2.squarePlusProduct(add2, add.addOne()));
            } else if (coordinateSystem == 1) {
                ECFieldElement eCFieldElement3 = this.f23907y;
                ECFieldElement eCFieldElement4 = this.zs[0];
                boolean isOne = eCFieldElement4.isOne();
                ECFieldElement multiply = isOne ? eCFieldElement2 : eCFieldElement2.multiply(eCFieldElement4);
                if (!isOne) {
                    eCFieldElement3 = eCFieldElement3.multiply(eCFieldElement4);
                }
                ECFieldElement square = eCFieldElement2.square();
                ECFieldElement add3 = square.add(eCFieldElement3);
                ECFieldElement square2 = multiply.square();
                ECFieldElement add4 = add3.add(multiply);
                ECFieldElement multiplyPlusProduct = add4.multiplyPlusProduct(add3, square2, curve.getA());
                return new F2m(curve, multiply.multiply(multiplyPlusProduct), square.square().multiplyPlusProduct(multiply, multiplyPlusProduct, add4), new ECFieldElement[]{multiply.multiply(square2)});
            } else if (coordinateSystem == 6) {
                ECFieldElement eCFieldElement5 = this.f23907y;
                ECFieldElement eCFieldElement6 = this.zs[0];
                boolean isOne2 = eCFieldElement6.isOne();
                ECFieldElement multiply2 = isOne2 ? eCFieldElement5 : eCFieldElement5.multiply(eCFieldElement6);
                ECFieldElement square3 = isOne2 ? eCFieldElement6 : eCFieldElement6.square();
                ECFieldElement a10 = curve.getA();
                ECFieldElement multiply3 = isOne2 ? a10 : a10.multiply(square3);
                ECFieldElement add5 = eCFieldElement5.square().add(multiply2).add(multiply3);
                if (add5.isZero()) {
                    return new F2m(curve, add5, curve.getB().sqrt());
                }
                ECFieldElement square4 = add5.square();
                ECFieldElement multiply4 = isOne2 ? add5 : add5.multiply(square3);
                ECFieldElement b10 = curve.getB();
                if (b10.bitLength() < (curve.getFieldSize() >> 1)) {
                    ECFieldElement square5 = eCFieldElement5.add(eCFieldElement2).square();
                    eCFieldElement = square5.add(add5).add(square3).multiply(square5).add(b10.isOne() ? multiply3.add(square3).square() : multiply3.squarePlusProduct(b10, square3.square())).add(square4);
                    if (!a10.isZero()) {
                        if (!a10.isOne()) {
                            eCFieldElement = eCFieldElement.add(a10.addOne().multiply(multiply4));
                        }
                        return new F2m(curve, square4, eCFieldElement, new ECFieldElement[]{multiply4});
                    }
                } else {
                    if (!isOne2) {
                        eCFieldElement2 = eCFieldElement2.multiply(eCFieldElement6);
                    }
                    eCFieldElement = eCFieldElement2.squarePlusProduct(add5, multiply2).add(square4);
                }
                eCFieldElement = eCFieldElement.add(multiply4);
                return new F2m(curve, square4, eCFieldElement, new ECFieldElement[]{multiply4});
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        public ECPoint twicePlus(ECPoint eCPoint) {
            if (isInfinity()) {
                return eCPoint;
            }
            if (eCPoint.isInfinity()) {
                return twice();
            }
            ECCurve curve = getCurve();
            ECFieldElement eCFieldElement = this.f23906x;
            if (eCFieldElement.isZero()) {
                return eCPoint;
            }
            if (curve.getCoordinateSystem() != 6) {
                return twice().add(eCPoint);
            }
            ECFieldElement eCFieldElement2 = eCPoint.f23906x;
            ECFieldElement eCFieldElement3 = eCPoint.zs[0];
            if (eCFieldElement2.isZero() || !eCFieldElement3.isOne()) {
                return twice().add(eCPoint);
            }
            ECFieldElement eCFieldElement4 = this.f23907y;
            ECFieldElement eCFieldElement5 = this.zs[0];
            ECFieldElement eCFieldElement6 = eCPoint.f23907y;
            ECFieldElement square = eCFieldElement.square();
            ECFieldElement square2 = eCFieldElement4.square();
            ECFieldElement square3 = eCFieldElement5.square();
            ECFieldElement add = curve.getA().multiply(square3).add(square2).add(eCFieldElement4.multiply(eCFieldElement5));
            ECFieldElement addOne = eCFieldElement6.addOne();
            ECFieldElement multiplyPlusProduct = curve.getA().add(addOne).multiply(square3).add(square2).multiplyPlusProduct(add, square, square3);
            ECFieldElement multiply = eCFieldElement2.multiply(square3);
            ECFieldElement square4 = multiply.add(add).square();
            if (square4.isZero()) {
                return multiplyPlusProduct.isZero() ? eCPoint.twice() : curve.getInfinity();
            }
            if (multiplyPlusProduct.isZero()) {
                return new F2m(curve, multiplyPlusProduct, curve.getB().sqrt());
            }
            ECFieldElement multiply2 = multiplyPlusProduct.square().multiply(multiply);
            ECFieldElement multiply3 = multiplyPlusProduct.multiply(square4).multiply(square3);
            return new F2m(curve, multiply2, multiplyPlusProduct.add(square4).square().multiplyPlusProduct(add, addOne, multiply3), new ECFieldElement[]{multiply3});
        }
    }

    public static class Fp extends AbstractFp {
        Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
        }

        Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }

        /* JADX WARNING: type inference failed for: r17v0, types: [org.bouncycastle.math.ec.ECPoint] */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0128  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x0136  */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.bouncycastle.math.ec.ECPoint add(org.bouncycastle.math.ec.ECPoint r17) {
            /*
                r16 = this;
                r0 = r16
                r1 = r17
                boolean r2 = r16.isInfinity()
                if (r2 == 0) goto L_0x000b
                return r1
            L_0x000b:
                boolean r2 = r17.isInfinity()
                if (r2 == 0) goto L_0x0012
                return r0
            L_0x0012:
                if (r0 != r1) goto L_0x0019
                org.bouncycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x0019:
                org.bouncycastle.math.ec.ECCurve r2 = r16.getCurve()
                int r3 = r2.getCoordinateSystem()
                org.bouncycastle.math.ec.ECFieldElement r4 = r0.f23906x
                org.bouncycastle.math.ec.ECFieldElement r5 = r0.f23907y
                org.bouncycastle.math.ec.ECFieldElement r6 = r1.f23906x
                org.bouncycastle.math.ec.ECFieldElement r7 = r1.f23907y
                if (r3 == 0) goto L_0x01d4
                r8 = 1
                r9 = 0
                if (r3 == r8) goto L_0x0142
                r10 = 4
                r11 = 2
                if (r3 == r11) goto L_0x003e
                if (r3 != r10) goto L_0x0036
                goto L_0x003e
            L_0x0036:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "unsupported coordinate system"
                r1.<init>(r2)
                throw r1
            L_0x003e:
                org.bouncycastle.math.ec.ECFieldElement[] r12 = r0.zs
                r12 = r12[r9]
                org.bouncycastle.math.ec.ECFieldElement[] r1 = r1.zs
                r1 = r1[r9]
                boolean r13 = r12.isOne()
                if (r13 != 0) goto L_0x00a3
                boolean r15 = r12.equals(r1)
                if (r15 == 0) goto L_0x00a3
                org.bouncycastle.math.ec.ECFieldElement r1 = r4.subtract(r6)
                org.bouncycastle.math.ec.ECFieldElement r7 = r5.subtract(r7)
                boolean r13 = r1.isZero()
                if (r13 == 0) goto L_0x0070
                boolean r1 = r7.isZero()
                if (r1 == 0) goto L_0x006b
                org.bouncycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x006b:
                org.bouncycastle.math.ec.ECPoint r1 = r2.getInfinity()
                return r1
            L_0x0070:
                org.bouncycastle.math.ec.ECFieldElement r13 = r1.square()
                org.bouncycastle.math.ec.ECFieldElement r4 = r4.multiply(r13)
                org.bouncycastle.math.ec.ECFieldElement r6 = r6.multiply(r13)
                org.bouncycastle.math.ec.ECFieldElement r13 = r4.subtract(r6)
                org.bouncycastle.math.ec.ECFieldElement r5 = r13.multiply(r5)
                org.bouncycastle.math.ec.ECFieldElement r13 = r7.square()
                org.bouncycastle.math.ec.ECFieldElement r13 = r13.subtract(r4)
                org.bouncycastle.math.ec.ECFieldElement r6 = r13.subtract(r6)
                org.bouncycastle.math.ec.ECFieldElement r4 = r4.subtract(r6)
                org.bouncycastle.math.ec.ECFieldElement r4 = r4.multiply(r7)
                org.bouncycastle.math.ec.ECFieldElement r4 = r4.subtract(r5)
                org.bouncycastle.math.ec.ECFieldElement r1 = r1.multiply(r12)
            L_0x00a0:
                r14 = 0
                goto L_0x0126
            L_0x00a3:
                if (r13 == 0) goto L_0x00a6
                goto L_0x00b6
            L_0x00a6:
                org.bouncycastle.math.ec.ECFieldElement r15 = r12.square()
                org.bouncycastle.math.ec.ECFieldElement r6 = r15.multiply(r6)
                org.bouncycastle.math.ec.ECFieldElement r15 = r15.multiply(r12)
                org.bouncycastle.math.ec.ECFieldElement r7 = r15.multiply(r7)
            L_0x00b6:
                boolean r15 = r1.isOne()
                if (r15 == 0) goto L_0x00bd
                goto L_0x00cd
            L_0x00bd:
                org.bouncycastle.math.ec.ECFieldElement r14 = r1.square()
                org.bouncycastle.math.ec.ECFieldElement r4 = r14.multiply(r4)
                org.bouncycastle.math.ec.ECFieldElement r14 = r14.multiply(r1)
                org.bouncycastle.math.ec.ECFieldElement r5 = r14.multiply(r5)
            L_0x00cd:
                org.bouncycastle.math.ec.ECFieldElement r6 = r4.subtract(r6)
                org.bouncycastle.math.ec.ECFieldElement r7 = r5.subtract(r7)
                boolean r14 = r6.isZero()
                if (r14 == 0) goto L_0x00eb
                boolean r1 = r7.isZero()
                if (r1 == 0) goto L_0x00e6
                org.bouncycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x00e6:
                org.bouncycastle.math.ec.ECPoint r1 = r2.getInfinity()
                return r1
            L_0x00eb:
                org.bouncycastle.math.ec.ECFieldElement r14 = r6.square()
                org.bouncycastle.math.ec.ECFieldElement r8 = r14.multiply(r6)
                org.bouncycastle.math.ec.ECFieldElement r4 = r14.multiply(r4)
                org.bouncycastle.math.ec.ECFieldElement r9 = r7.square()
                org.bouncycastle.math.ec.ECFieldElement r9 = r9.add(r8)
                org.bouncycastle.math.ec.ECFieldElement r11 = r0.two(r4)
                org.bouncycastle.math.ec.ECFieldElement r9 = r9.subtract(r11)
                org.bouncycastle.math.ec.ECFieldElement r4 = r4.subtract(r9)
                org.bouncycastle.math.ec.ECFieldElement r4 = r4.multiplyMinusProduct(r7, r8, r5)
                if (r13 != 0) goto L_0x0116
                org.bouncycastle.math.ec.ECFieldElement r5 = r6.multiply(r12)
                goto L_0x0117
            L_0x0116:
                r5 = r6
            L_0x0117:
                if (r15 != 0) goto L_0x011e
                org.bouncycastle.math.ec.ECFieldElement r1 = r5.multiply(r1)
                goto L_0x011f
            L_0x011e:
                r1 = r5
            L_0x011f:
                if (r1 != r6) goto L_0x0123
                r6 = r9
                goto L_0x0126
            L_0x0123:
                r6 = r9
                goto L_0x00a0
            L_0x0126:
                if (r3 != r10) goto L_0x0136
                org.bouncycastle.math.ec.ECFieldElement r3 = r0.calculateJacobianModifiedW(r1, r14)
                r5 = 2
                org.bouncycastle.math.ec.ECFieldElement[] r5 = new org.bouncycastle.math.ec.ECFieldElement[r5]
                r8 = 0
                r5[r8] = r1
                r7 = 1
                r5[r7] = r3
                goto L_0x013c
            L_0x0136:
                r7 = 1
                r8 = 0
                org.bouncycastle.math.ec.ECFieldElement[] r5 = new org.bouncycastle.math.ec.ECFieldElement[r7]
                r5[r8] = r1
            L_0x013c:
                org.bouncycastle.math.ec.ECPoint$Fp r1 = new org.bouncycastle.math.ec.ECPoint$Fp
                r1.<init>(r2, r6, r4, r5)
                return r1
            L_0x0142:
                r8 = r9
                org.bouncycastle.math.ec.ECFieldElement[] r3 = r0.zs
                r3 = r3[r8]
                org.bouncycastle.math.ec.ECFieldElement[] r1 = r1.zs
                r1 = r1[r8]
                boolean r8 = r3.isOne()
                boolean r9 = r1.isOne()
                if (r8 == 0) goto L_0x0156
                goto L_0x015a
            L_0x0156:
                org.bouncycastle.math.ec.ECFieldElement r7 = r7.multiply(r3)
            L_0x015a:
                if (r9 == 0) goto L_0x015d
                goto L_0x0161
            L_0x015d:
                org.bouncycastle.math.ec.ECFieldElement r5 = r5.multiply(r1)
            L_0x0161:
                org.bouncycastle.math.ec.ECFieldElement r7 = r7.subtract(r5)
                if (r8 == 0) goto L_0x0168
                goto L_0x016c
            L_0x0168:
                org.bouncycastle.math.ec.ECFieldElement r6 = r6.multiply(r3)
            L_0x016c:
                if (r9 == 0) goto L_0x016f
                goto L_0x0173
            L_0x016f:
                org.bouncycastle.math.ec.ECFieldElement r4 = r4.multiply(r1)
            L_0x0173:
                org.bouncycastle.math.ec.ECFieldElement r6 = r6.subtract(r4)
                boolean r10 = r6.isZero()
                if (r10 == 0) goto L_0x018d
                boolean r1 = r7.isZero()
                if (r1 == 0) goto L_0x0188
                org.bouncycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x0188:
                org.bouncycastle.math.ec.ECPoint r1 = r2.getInfinity()
                return r1
            L_0x018d:
                if (r8 == 0) goto L_0x0191
                r3 = r1
                goto L_0x0198
            L_0x0191:
                if (r9 == 0) goto L_0x0194
                goto L_0x0198
            L_0x0194:
                org.bouncycastle.math.ec.ECFieldElement r3 = r3.multiply(r1)
            L_0x0198:
                org.bouncycastle.math.ec.ECFieldElement r1 = r6.square()
                org.bouncycastle.math.ec.ECFieldElement r8 = r1.multiply(r6)
                org.bouncycastle.math.ec.ECFieldElement r1 = r1.multiply(r4)
                org.bouncycastle.math.ec.ECFieldElement r4 = r7.square()
                org.bouncycastle.math.ec.ECFieldElement r4 = r4.multiply(r3)
                org.bouncycastle.math.ec.ECFieldElement r4 = r4.subtract(r8)
                org.bouncycastle.math.ec.ECFieldElement r9 = r0.two(r1)
                org.bouncycastle.math.ec.ECFieldElement r4 = r4.subtract(r9)
                org.bouncycastle.math.ec.ECFieldElement r6 = r6.multiply(r4)
                org.bouncycastle.math.ec.ECFieldElement r1 = r1.subtract(r4)
                org.bouncycastle.math.ec.ECFieldElement r1 = r1.multiplyMinusProduct(r7, r5, r8)
                org.bouncycastle.math.ec.ECFieldElement r3 = r8.multiply(r3)
                org.bouncycastle.math.ec.ECPoint$Fp r4 = new org.bouncycastle.math.ec.ECPoint$Fp
                r5 = 1
                org.bouncycastle.math.ec.ECFieldElement[] r5 = new org.bouncycastle.math.ec.ECFieldElement[r5]
                r7 = 0
                r5[r7] = r3
                r4.<init>(r2, r6, r1, r5)
                return r4
            L_0x01d4:
                org.bouncycastle.math.ec.ECFieldElement r1 = r6.subtract(r4)
                org.bouncycastle.math.ec.ECFieldElement r3 = r7.subtract(r5)
                boolean r7 = r1.isZero()
                if (r7 == 0) goto L_0x01f2
                boolean r1 = r3.isZero()
                if (r1 == 0) goto L_0x01ed
                org.bouncycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x01ed:
                org.bouncycastle.math.ec.ECPoint r1 = r2.getInfinity()
                return r1
            L_0x01f2:
                org.bouncycastle.math.ec.ECFieldElement r1 = r3.divide(r1)
                org.bouncycastle.math.ec.ECFieldElement r3 = r1.square()
                org.bouncycastle.math.ec.ECFieldElement r3 = r3.subtract(r4)
                org.bouncycastle.math.ec.ECFieldElement r3 = r3.subtract(r6)
                org.bouncycastle.math.ec.ECFieldElement r4 = r4.subtract(r3)
                org.bouncycastle.math.ec.ECFieldElement r1 = r1.multiply(r4)
                org.bouncycastle.math.ec.ECFieldElement r1 = r1.subtract(r5)
                org.bouncycastle.math.ec.ECPoint$Fp r4 = new org.bouncycastle.math.ec.ECPoint$Fp
                r4.<init>(r2, r3, r1)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.math.ec.ECPoint.Fp.add(org.bouncycastle.math.ec.ECPoint):org.bouncycastle.math.ec.ECPoint");
        }

        /* access modifiers changed from: protected */
        public ECFieldElement calculateJacobianModifiedW(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            ECFieldElement a10 = getCurve().getA();
            if (a10.isZero() || eCFieldElement.isOne()) {
                return a10;
            }
            if (eCFieldElement2 == null) {
                eCFieldElement2 = eCFieldElement.square();
            }
            ECFieldElement square = eCFieldElement2.square();
            ECFieldElement negate = a10.negate();
            return negate.bitLength() < a10.bitLength() ? square.multiply(negate).negate() : square.multiply(a10);
        }

        /* access modifiers changed from: protected */
        public ECPoint detach() {
            return new Fp((ECCurve) null, getAffineXCoord(), getAffineYCoord());
        }

        /* access modifiers changed from: protected */
        public ECFieldElement doubleProductFromSquares(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3, ECFieldElement eCFieldElement4) {
            return eCFieldElement.add(eCFieldElement2).square().subtract(eCFieldElement3).subtract(eCFieldElement4);
        }

        /* access modifiers changed from: protected */
        public ECFieldElement eight(ECFieldElement eCFieldElement) {
            return four(two(eCFieldElement));
        }

        /* access modifiers changed from: protected */
        public ECFieldElement four(ECFieldElement eCFieldElement) {
            return two(two(eCFieldElement));
        }

        /* access modifiers changed from: protected */
        public ECFieldElement getJacobianModifiedW() {
            ECFieldElement[] eCFieldElementArr = this.zs;
            ECFieldElement eCFieldElement = eCFieldElementArr[1];
            if (eCFieldElement != null) {
                return eCFieldElement;
            }
            ECFieldElement calculateJacobianModifiedW = calculateJacobianModifiedW(eCFieldElementArr[0], (ECFieldElement) null);
            eCFieldElementArr[1] = calculateJacobianModifiedW;
            return calculateJacobianModifiedW;
        }

        public ECFieldElement getZCoord(int i10) {
            return (i10 == 1 && 4 == getCurveCoordinateSystem()) ? getJacobianModifiedW() : ECPoint.super.getZCoord(i10);
        }

        public ECPoint negate() {
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            return curve.getCoordinateSystem() != 0 ? new Fp(curve, this.f23906x, this.f23907y.negate(), this.zs) : new Fp(curve, this.f23906x, this.f23907y.negate());
        }

        /* access modifiers changed from: protected */
        public ECFieldElement three(ECFieldElement eCFieldElement) {
            return two(eCFieldElement).add(eCFieldElement);
        }

        public ECPoint threeTimes() {
            if (isInfinity()) {
                return this;
            }
            ECFieldElement eCFieldElement = this.f23907y;
            if (eCFieldElement.isZero()) {
                return this;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem != 0) {
                return coordinateSystem != 4 ? twice().add(this) : twiceJacobianModified(false).add(this);
            }
            ECFieldElement eCFieldElement2 = this.f23906x;
            ECFieldElement two = two(eCFieldElement);
            ECFieldElement square = two.square();
            ECFieldElement add = three(eCFieldElement2.square()).add(getCurve().getA());
            ECFieldElement subtract = three(eCFieldElement2).multiply(square).subtract(add.square());
            if (subtract.isZero()) {
                return getCurve().getInfinity();
            }
            ECFieldElement invert = subtract.multiply(two).invert();
            ECFieldElement multiply = subtract.multiply(invert).multiply(add);
            ECFieldElement subtract2 = square.square().multiply(invert).subtract(multiply);
            ECFieldElement add2 = subtract2.subtract(multiply).multiply(multiply.add(subtract2)).add(eCFieldElement2);
            return new Fp(curve, add2, eCFieldElement2.subtract(add2).multiply(subtract2).subtract(eCFieldElement));
        }

        public ECPoint timesPow2(int i10) {
            ECFieldElement eCFieldElement;
            int i11 = i10;
            if (i11 < 0) {
                throw new IllegalArgumentException("'e' cannot be negative");
            } else if (i11 == 0 || isInfinity()) {
                return this;
            } else {
                if (i11 == 1) {
                    return twice();
                }
                ECCurve curve = getCurve();
                ECFieldElement eCFieldElement2 = this.f23907y;
                if (eCFieldElement2.isZero()) {
                    return curve.getInfinity();
                }
                int coordinateSystem = curve.getCoordinateSystem();
                ECFieldElement a10 = curve.getA();
                ECFieldElement eCFieldElement3 = this.f23906x;
                ECFieldElement[] eCFieldElementArr = this.zs;
                ECFieldElement fromBigInteger = eCFieldElementArr.length < 1 ? curve.fromBigInteger(ECConstants.ONE) : eCFieldElementArr[0];
                if (!fromBigInteger.isOne() && coordinateSystem != 0) {
                    if (coordinateSystem == 1) {
                        eCFieldElement = fromBigInteger.square();
                        eCFieldElement3 = eCFieldElement3.multiply(fromBigInteger);
                        eCFieldElement2 = eCFieldElement2.multiply(eCFieldElement);
                    } else if (coordinateSystem == 2) {
                        eCFieldElement = null;
                    } else if (coordinateSystem == 4) {
                        a10 = getJacobianModifiedW();
                    } else {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                    a10 = calculateJacobianModifiedW(fromBigInteger, eCFieldElement);
                }
                int i12 = 0;
                while (i12 < i11) {
                    if (eCFieldElement2.isZero()) {
                        return curve.getInfinity();
                    }
                    ECFieldElement three = three(eCFieldElement3.square());
                    ECFieldElement two = two(eCFieldElement2);
                    ECFieldElement multiply = two.multiply(eCFieldElement2);
                    ECFieldElement two2 = two(eCFieldElement3.multiply(multiply));
                    ECFieldElement two3 = two(multiply.square());
                    if (!a10.isZero()) {
                        three = three.add(a10);
                        a10 = two(two3.multiply(a10));
                    }
                    ECFieldElement subtract = three.square().subtract(two(two2));
                    eCFieldElement2 = three.multiply(two2.subtract(subtract)).subtract(two3);
                    fromBigInteger = fromBigInteger.isOne() ? two : two.multiply(fromBigInteger);
                    i12++;
                    eCFieldElement3 = subtract;
                }
                if (coordinateSystem == 0) {
                    ECFieldElement invert = fromBigInteger.invert();
                    ECFieldElement square = invert.square();
                    return new Fp(curve, eCFieldElement3.multiply(square), eCFieldElement2.multiply(square.multiply(invert)));
                } else if (coordinateSystem == 1) {
                    return new Fp(curve, eCFieldElement3.multiply(fromBigInteger), eCFieldElement2, new ECFieldElement[]{fromBigInteger.multiply(fromBigInteger.square())});
                } else if (coordinateSystem == 2) {
                    return new Fp(curve, eCFieldElement3, eCFieldElement2, new ECFieldElement[]{fromBigInteger});
                } else if (coordinateSystem == 4) {
                    return new Fp(curve, eCFieldElement3, eCFieldElement2, new ECFieldElement[]{fromBigInteger, a10});
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
        }

        public ECPoint twice() {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            ECFieldElement eCFieldElement3 = this.f23907y;
            if (eCFieldElement3.isZero()) {
                return curve.getInfinity();
            }
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElement4 = this.f23906x;
            if (coordinateSystem == 0) {
                ECFieldElement divide = three(eCFieldElement4.square()).add(getCurve().getA()).divide(two(eCFieldElement3));
                ECFieldElement subtract = divide.square().subtract(two(eCFieldElement4));
                return new Fp(curve, subtract, divide.multiply(eCFieldElement4.subtract(subtract)).subtract(eCFieldElement3));
            } else if (coordinateSystem == 1) {
                ECFieldElement eCFieldElement5 = this.zs[0];
                boolean isOne = eCFieldElement5.isOne();
                ECFieldElement a10 = curve.getA();
                if (!a10.isZero() && !isOne) {
                    a10 = a10.multiply(eCFieldElement5.square());
                }
                ECFieldElement add = a10.add(three(eCFieldElement4.square()));
                ECFieldElement multiply = isOne ? eCFieldElement3 : eCFieldElement3.multiply(eCFieldElement5);
                ECFieldElement square = isOne ? eCFieldElement3.square() : multiply.multiply(eCFieldElement3);
                ECFieldElement four = four(eCFieldElement4.multiply(square));
                ECFieldElement subtract2 = add.square().subtract(two(four));
                ECFieldElement two = two(multiply);
                ECFieldElement multiply2 = subtract2.multiply(two);
                ECFieldElement two2 = two(square);
                return new Fp(curve, multiply2, four.subtract(subtract2).multiply(add).subtract(two(two2.square())), new ECFieldElement[]{two(isOne ? two(two2) : two.square()).multiply(multiply)});
            } else if (coordinateSystem == 2) {
                ECFieldElement eCFieldElement6 = this.zs[0];
                boolean isOne2 = eCFieldElement6.isOne();
                ECFieldElement square2 = eCFieldElement3.square();
                ECFieldElement square3 = square2.square();
                ECFieldElement a11 = curve.getA();
                ECFieldElement negate = a11.negate();
                if (negate.toBigInteger().equals(BigInteger.valueOf(3))) {
                    ECFieldElement square4 = isOne2 ? eCFieldElement6 : eCFieldElement6.square();
                    eCFieldElement = three(eCFieldElement4.add(square4).multiply(eCFieldElement4.subtract(square4)));
                    eCFieldElement2 = square2.multiply(eCFieldElement4);
                } else {
                    ECFieldElement three = three(eCFieldElement4.square());
                    if (!isOne2) {
                        if (!a11.isZero()) {
                            ECFieldElement square5 = eCFieldElement6.square().square();
                            if (negate.bitLength() < a11.bitLength()) {
                                eCFieldElement = three.subtract(square5.multiply(negate));
                            } else {
                                a11 = square5.multiply(a11);
                            }
                        } else {
                            eCFieldElement = three;
                        }
                        eCFieldElement2 = eCFieldElement4.multiply(square2);
                    }
                    eCFieldElement = three.add(a11);
                    eCFieldElement2 = eCFieldElement4.multiply(square2);
                }
                ECFieldElement four2 = four(eCFieldElement2);
                ECFieldElement subtract3 = eCFieldElement.square().subtract(two(four2));
                ECFieldElement subtract4 = four2.subtract(subtract3).multiply(eCFieldElement).subtract(eight(square3));
                ECFieldElement two3 = two(eCFieldElement3);
                if (!isOne2) {
                    two3 = two3.multiply(eCFieldElement6);
                }
                return new Fp(curve, subtract3, subtract4, new ECFieldElement[]{two3});
            } else if (coordinateSystem == 4) {
                return twiceJacobianModified(true);
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        /* access modifiers changed from: protected */
        public Fp twiceJacobianModified(boolean z10) {
            ECFieldElement eCFieldElement = this.f23906x;
            ECFieldElement eCFieldElement2 = this.f23907y;
            ECFieldElement eCFieldElement3 = this.zs[0];
            ECFieldElement jacobianModifiedW = getJacobianModifiedW();
            ECFieldElement add = three(eCFieldElement.square()).add(jacobianModifiedW);
            ECFieldElement two = two(eCFieldElement2);
            ECFieldElement multiply = two.multiply(eCFieldElement2);
            ECFieldElement two2 = two(eCFieldElement.multiply(multiply));
            ECFieldElement subtract = add.square().subtract(two(two2));
            ECFieldElement two3 = two(multiply.square());
            ECFieldElement subtract2 = add.multiply(two2.subtract(subtract)).subtract(two3);
            ECFieldElement two4 = z10 ? two(two3.multiply(jacobianModifiedW)) : null;
            if (!eCFieldElement3.isOne()) {
                two = two.multiply(eCFieldElement3);
            }
            return new Fp(getCurve(), subtract, subtract2, new ECFieldElement[]{two, two4});
        }

        public ECPoint twicePlus(ECPoint eCPoint) {
            if (this == eCPoint) {
                return threeTimes();
            }
            if (isInfinity()) {
                return eCPoint;
            }
            if (eCPoint.isInfinity()) {
                return twice();
            }
            ECFieldElement eCFieldElement = this.f23907y;
            if (eCFieldElement.isZero()) {
                return eCPoint;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem != 0) {
                return coordinateSystem != 4 ? twice().add(eCPoint) : twiceJacobianModified(false).add(eCPoint);
            }
            ECFieldElement eCFieldElement2 = this.f23906x;
            ECFieldElement eCFieldElement3 = eCPoint.f23906x;
            ECFieldElement eCFieldElement4 = eCPoint.f23907y;
            ECFieldElement subtract = eCFieldElement3.subtract(eCFieldElement2);
            ECFieldElement subtract2 = eCFieldElement4.subtract(eCFieldElement);
            if (subtract.isZero()) {
                return subtract2.isZero() ? threeTimes() : this;
            }
            ECFieldElement square = subtract.square();
            ECFieldElement subtract3 = square.multiply(two(eCFieldElement2).add(eCFieldElement3)).subtract(subtract2.square());
            if (subtract3.isZero()) {
                return curve.getInfinity();
            }
            ECFieldElement invert = subtract3.multiply(subtract).invert();
            ECFieldElement multiply = subtract3.multiply(invert).multiply(subtract2);
            ECFieldElement subtract4 = two(eCFieldElement).multiply(square).multiply(subtract).multiply(invert).subtract(multiply);
            ECFieldElement add = subtract4.subtract(multiply).multiply(multiply.add(subtract4)).add(eCFieldElement3);
            return new Fp(curve, add, eCFieldElement2.subtract(add).multiply(subtract4).subtract(eCFieldElement));
        }

        /* access modifiers changed from: protected */
        public ECFieldElement two(ECFieldElement eCFieldElement) {
            return eCFieldElement.add(eCFieldElement);
        }
    }

    protected ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, getInitialZCoords(eCCurve));
    }

    protected ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        this.preCompTable = null;
        this.curve = eCCurve;
        this.f23906x = eCFieldElement;
        this.f23907y = eCFieldElement2;
        this.zs = eCFieldElementArr;
    }

    protected static ECFieldElement[] getInitialZCoords(ECCurve eCCurve) {
        int coordinateSystem = eCCurve == null ? 0 : eCCurve.getCoordinateSystem();
        if (coordinateSystem == 0 || coordinateSystem == 5) {
            return EMPTY_ZS;
        }
        ECFieldElement fromBigInteger = eCCurve.fromBigInteger(ECConstants.ONE);
        if (!(coordinateSystem == 1 || coordinateSystem == 2)) {
            if (coordinateSystem == 3) {
                return new ECFieldElement[]{fromBigInteger, fromBigInteger, fromBigInteger};
            } else if (coordinateSystem == 4) {
                return new ECFieldElement[]{fromBigInteger, eCCurve.getA()};
            } else if (coordinateSystem != 6) {
                throw new IllegalArgumentException("unknown coordinate system");
            }
        }
        return new ECFieldElement[]{fromBigInteger};
    }

    public abstract ECPoint add(ECPoint eCPoint);

    /* access modifiers changed from: protected */
    public void checkNormalized() {
        if (!isNormalized()) {
            throw new IllegalStateException("point not in normal form");
        }
    }

    /* access modifiers changed from: protected */
    public ECPoint createScaledPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return getCurve().createRawPoint(getRawXCoord().multiply(eCFieldElement), getRawYCoord().multiply(eCFieldElement2));
    }

    /* access modifiers changed from: protected */
    public abstract ECPoint detach();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ECPoint)) {
            return false;
        }
        return equals((ECPoint) obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(org.bouncycastle.math.ec.ECPoint r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            org.bouncycastle.math.ec.ECCurve r1 = r8.getCurve()
            org.bouncycastle.math.ec.ECCurve r2 = r9.getCurve()
            r3 = 1
            if (r1 != 0) goto L_0x0011
            r4 = r3
            goto L_0x0012
        L_0x0011:
            r4 = r0
        L_0x0012:
            if (r2 != 0) goto L_0x0016
            r5 = r3
            goto L_0x0017
        L_0x0016:
            r5 = r0
        L_0x0017:
            boolean r6 = r8.isInfinity()
            boolean r7 = r9.isInfinity()
            if (r6 != 0) goto L_0x006f
            if (r7 == 0) goto L_0x0024
            goto L_0x006f
        L_0x0024:
            if (r4 == 0) goto L_0x0029
            if (r5 == 0) goto L_0x0029
            goto L_0x002f
        L_0x0029:
            if (r4 == 0) goto L_0x0031
            org.bouncycastle.math.ec.ECPoint r9 = r9.normalize()
        L_0x002f:
            r1 = r8
            goto L_0x0051
        L_0x0031:
            if (r5 == 0) goto L_0x0038
            org.bouncycastle.math.ec.ECPoint r1 = r8.normalize()
            goto L_0x0051
        L_0x0038:
            boolean r2 = r1.equals((org.bouncycastle.math.ec.ECCurve) r2)
            if (r2 != 0) goto L_0x003f
            return r0
        L_0x003f:
            r2 = 2
            org.bouncycastle.math.ec.ECPoint[] r2 = new org.bouncycastle.math.ec.ECPoint[r2]
            r2[r0] = r8
            org.bouncycastle.math.ec.ECPoint r9 = r1.importPoint(r9)
            r2[r3] = r9
            r1.normalizeAll(r2)
            r1 = r2[r0]
            r9 = r2[r3]
        L_0x0051:
            org.bouncycastle.math.ec.ECFieldElement r2 = r1.getXCoord()
            org.bouncycastle.math.ec.ECFieldElement r4 = r9.getXCoord()
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x006e
            org.bouncycastle.math.ec.ECFieldElement r1 = r1.getYCoord()
            org.bouncycastle.math.ec.ECFieldElement r9 = r9.getYCoord()
            boolean r9 = r1.equals(r9)
            if (r9 == 0) goto L_0x006e
            r0 = r3
        L_0x006e:
            return r0
        L_0x006f:
            if (r6 == 0) goto L_0x007e
            if (r7 == 0) goto L_0x007e
            if (r4 != 0) goto L_0x007d
            if (r5 != 0) goto L_0x007d
            boolean r9 = r1.equals((org.bouncycastle.math.ec.ECCurve) r2)
            if (r9 == 0) goto L_0x007e
        L_0x007d:
            r0 = r3
        L_0x007e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.math.ec.ECPoint.equals(org.bouncycastle.math.ec.ECPoint):boolean");
    }

    public ECFieldElement getAffineXCoord() {
        checkNormalized();
        return getXCoord();
    }

    public ECFieldElement getAffineYCoord() {
        checkNormalized();
        return getYCoord();
    }

    /* access modifiers changed from: protected */
    public abstract boolean getCompressionYTilde();

    public ECCurve getCurve() {
        return this.curve;
    }

    /* access modifiers changed from: protected */
    public int getCurveCoordinateSystem() {
        ECCurve eCCurve = this.curve;
        if (eCCurve == null) {
            return 0;
        }
        return eCCurve.getCoordinateSystem();
    }

    public final ECPoint getDetachedPoint() {
        return normalize().detach();
    }

    public byte[] getEncoded(boolean z10) {
        if (isInfinity()) {
            return new byte[1];
        }
        ECPoint normalize = normalize();
        byte[] encoded = normalize.getXCoord().getEncoded();
        if (z10) {
            byte[] bArr = new byte[(encoded.length + 1)];
            bArr[0] = (byte) (normalize.getCompressionYTilde() ? 3 : 2);
            System.arraycopy(encoded, 0, bArr, 1, encoded.length);
            return bArr;
        }
        byte[] encoded2 = normalize.getYCoord().getEncoded();
        byte[] bArr2 = new byte[(encoded.length + encoded2.length + 1)];
        bArr2[0] = 4;
        System.arraycopy(encoded, 0, bArr2, 1, encoded.length);
        System.arraycopy(encoded2, 0, bArr2, encoded.length + 1, encoded2.length);
        return bArr2;
    }

    public final ECFieldElement getRawXCoord() {
        return this.f23906x;
    }

    public final ECFieldElement getRawYCoord() {
        return this.f23907y;
    }

    /* access modifiers changed from: protected */
    public final ECFieldElement[] getRawZCoords() {
        return this.zs;
    }

    public ECFieldElement getXCoord() {
        return this.f23906x;
    }

    public ECFieldElement getYCoord() {
        return this.f23907y;
    }

    public ECFieldElement getZCoord(int i10) {
        if (i10 >= 0) {
            ECFieldElement[] eCFieldElementArr = this.zs;
            if (i10 < eCFieldElementArr.length) {
                return eCFieldElementArr[i10];
            }
        }
        return null;
    }

    public ECFieldElement[] getZCoords() {
        ECFieldElement[] eCFieldElementArr = this.zs;
        int length = eCFieldElementArr.length;
        if (length == 0) {
            return EMPTY_ZS;
        }
        ECFieldElement[] eCFieldElementArr2 = new ECFieldElement[length];
        System.arraycopy(eCFieldElementArr, 0, eCFieldElementArr2, 0, length);
        return eCFieldElementArr2;
    }

    public int hashCode() {
        ECCurve curve2 = getCurve();
        int i10 = curve2 == null ? 0 : ~curve2.hashCode();
        if (isInfinity()) {
            return i10;
        }
        ECPoint normalize = normalize();
        return (i10 ^ (normalize.getXCoord().hashCode() * 17)) ^ (normalize.getYCoord().hashCode() * 257);
    }

    /* access modifiers changed from: package-private */
    public boolean implIsValid(final boolean z10, final boolean z11) {
        if (isInfinity()) {
            return true;
        }
        return !((ValidityPrecompInfo) getCurve().precompute(this, "bc_validity", new PreCompCallback() {
            public PreCompInfo precompute(PreCompInfo preCompInfo) {
                ValidityPrecompInfo validityPrecompInfo = preCompInfo instanceof ValidityPrecompInfo ? (ValidityPrecompInfo) preCompInfo : null;
                if (validityPrecompInfo == null) {
                    validityPrecompInfo = new ValidityPrecompInfo();
                }
                if (validityPrecompInfo.hasFailed()) {
                    return validityPrecompInfo;
                }
                if (!validityPrecompInfo.hasCurveEquationPassed()) {
                    if (z10 || ECPoint.this.satisfiesCurveEquation()) {
                        validityPrecompInfo.reportCurveEquationPassed();
                    } else {
                        validityPrecompInfo.reportFailed();
                        return validityPrecompInfo;
                    }
                }
                if (z11 && !validityPrecompInfo.hasOrderPassed()) {
                    if (!ECPoint.this.satisfiesOrder()) {
                        validityPrecompInfo.reportFailed();
                        return validityPrecompInfo;
                    }
                    validityPrecompInfo.reportOrderPassed();
                }
                return validityPrecompInfo;
            }
        })).hasFailed();
    }

    public boolean isInfinity() {
        if (!(this.f23906x == null || this.f23907y == null)) {
            ECFieldElement[] eCFieldElementArr = this.zs;
            if (eCFieldElementArr.length <= 0 || !eCFieldElementArr[0].isZero()) {
                return false;
            }
        }
        return true;
    }

    public boolean isNormalized() {
        int curveCoordinateSystem = getCurveCoordinateSystem();
        return curveCoordinateSystem == 0 || curveCoordinateSystem == 5 || isInfinity() || this.zs[0].isOne();
    }

    public boolean isValid() {
        return implIsValid(false, true);
    }

    /* access modifiers changed from: package-private */
    public boolean isValidPartial() {
        return implIsValid(false, false);
    }

    public ECPoint multiply(BigInteger bigInteger) {
        return getCurve().getMultiplier().multiply(this, bigInteger);
    }

    public abstract ECPoint negate();

    public ECPoint normalize() {
        int curveCoordinateSystem;
        if (isInfinity() || (curveCoordinateSystem = getCurveCoordinateSystem()) == 0 || curveCoordinateSystem == 5) {
            return this;
        }
        ECFieldElement zCoord = getZCoord(0);
        if (zCoord.isOne()) {
            return this;
        }
        if (this.curve != null) {
            ECFieldElement randomFieldElementMult = this.curve.randomFieldElementMult(CryptoServicesRegistrar.getSecureRandom());
            return normalize(zCoord.multiply(randomFieldElementMult).invert().multiply(randomFieldElementMult));
        }
        throw new IllegalStateException("Detached points must be in affine coordinates");
    }

    /* access modifiers changed from: package-private */
    public ECPoint normalize(ECFieldElement eCFieldElement) {
        int curveCoordinateSystem = getCurveCoordinateSystem();
        if (curveCoordinateSystem != 1) {
            if (curveCoordinateSystem == 2 || curveCoordinateSystem == 3 || curveCoordinateSystem == 4) {
                ECFieldElement square = eCFieldElement.square();
                return createScaledPoint(square, square.multiply(eCFieldElement));
            } else if (curveCoordinateSystem != 6) {
                throw new IllegalStateException("not a projective coordinate system");
            }
        }
        return createScaledPoint(eCFieldElement, eCFieldElement);
    }

    /* access modifiers changed from: protected */
    public abstract boolean satisfiesCurveEquation();

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r0 = r2.curve.getOrder();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean satisfiesOrder() {
        /*
            r2 = this;
            java.math.BigInteger r0 = org.bouncycastle.math.ec.ECConstants.ONE
            org.bouncycastle.math.ec.ECCurve r1 = r2.curve
            java.math.BigInteger r1 = r1.getCofactor()
            boolean r0 = r0.equals(r1)
            r1 = 1
            if (r0 == 0) goto L_0x0010
            return r1
        L_0x0010:
            org.bouncycastle.math.ec.ECCurve r0 = r2.curve
            java.math.BigInteger r0 = r0.getOrder()
            if (r0 == 0) goto L_0x0024
            org.bouncycastle.math.ec.ECPoint r0 = org.bouncycastle.math.ec.ECAlgorithms.referenceMultiply(r2, r0)
            boolean r0 = r0.isInfinity()
            if (r0 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r1 = 0
        L_0x0024:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.math.ec.ECPoint.satisfiesOrder():boolean");
    }

    public ECPoint scaleX(ECFieldElement eCFieldElement) {
        return isInfinity() ? this : getCurve().createRawPoint(getRawXCoord().multiply(eCFieldElement), getRawYCoord(), getRawZCoords());
    }

    public ECPoint scaleXNegateY(ECFieldElement eCFieldElement) {
        return isInfinity() ? this : getCurve().createRawPoint(getRawXCoord().multiply(eCFieldElement), getRawYCoord().negate(), getRawZCoords());
    }

    public ECPoint scaleY(ECFieldElement eCFieldElement) {
        return isInfinity() ? this : getCurve().createRawPoint(getRawXCoord(), getRawYCoord().multiply(eCFieldElement), getRawZCoords());
    }

    public ECPoint scaleYNegateX(ECFieldElement eCFieldElement) {
        return isInfinity() ? this : getCurve().createRawPoint(getRawXCoord().negate(), getRawYCoord().multiply(eCFieldElement), getRawZCoords());
    }

    public abstract ECPoint subtract(ECPoint eCPoint);

    public ECPoint threeTimes() {
        return twicePlus(this);
    }

    public ECPoint timesPow2(int i10) {
        if (i10 >= 0) {
            ECPoint eCPoint = this;
            while (true) {
                i10--;
                if (i10 < 0) {
                    return eCPoint;
                }
                eCPoint = eCPoint.twice();
            }
        } else {
            throw new IllegalArgumentException("'e' cannot be negative");
        }
    }

    public String toString() {
        if (isInfinity()) {
            return "INF";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(PropertyUtils.MAPPED_DELIM);
        stringBuffer.append(getRawXCoord());
        stringBuffer.append(',');
        stringBuffer.append(getRawYCoord());
        for (ECFieldElement append : this.zs) {
            stringBuffer.append(',');
            stringBuffer.append(append);
        }
        stringBuffer.append(PropertyUtils.MAPPED_DELIM2);
        return stringBuffer.toString();
    }

    public abstract ECPoint twice();

    public ECPoint twicePlus(ECPoint eCPoint) {
        return twice().add(eCPoint);
    }
}
