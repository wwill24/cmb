package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat160;

public class SecP160K1Point extends ECPoint.AbstractFp {
    SecP160K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    SecP160K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    public ECPoint add(ECPoint eCPoint) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        if (isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return this;
        }
        if (this == eCPoint) {
            return twice();
        }
        ECCurve curve = getCurve();
        SecP160R2FieldElement secP160R2FieldElement = (SecP160R2FieldElement) this.f23906x;
        SecP160R2FieldElement secP160R2FieldElement2 = (SecP160R2FieldElement) this.f23907y;
        SecP160R2FieldElement secP160R2FieldElement3 = (SecP160R2FieldElement) eCPoint.getXCoord();
        SecP160R2FieldElement secP160R2FieldElement4 = (SecP160R2FieldElement) eCPoint.getYCoord();
        SecP160R2FieldElement secP160R2FieldElement5 = (SecP160R2FieldElement) this.zs[0];
        SecP160R2FieldElement secP160R2FieldElement6 = (SecP160R2FieldElement) eCPoint.getZCoord(0);
        int[] createExt = Nat160.createExt();
        int[] create = Nat160.create();
        int[] create2 = Nat160.create();
        int[] create3 = Nat160.create();
        boolean isOne = secP160R2FieldElement5.isOne();
        if (isOne) {
            iArr2 = secP160R2FieldElement3.f23920x;
            iArr = secP160R2FieldElement4.f23920x;
        } else {
            SecP160R2Field.square(secP160R2FieldElement5.f23920x, create2);
            SecP160R2Field.multiply(create2, secP160R2FieldElement3.f23920x, create);
            SecP160R2Field.multiply(create2, secP160R2FieldElement5.f23920x, create2);
            SecP160R2Field.multiply(create2, secP160R2FieldElement4.f23920x, create2);
            iArr2 = create;
            iArr = create2;
        }
        boolean isOne2 = secP160R2FieldElement6.isOne();
        if (isOne2) {
            iArr4 = secP160R2FieldElement.f23920x;
            iArr3 = secP160R2FieldElement2.f23920x;
        } else {
            SecP160R2Field.square(secP160R2FieldElement6.f23920x, create3);
            SecP160R2Field.multiply(create3, secP160R2FieldElement.f23920x, createExt);
            SecP160R2Field.multiply(create3, secP160R2FieldElement6.f23920x, create3);
            SecP160R2Field.multiply(create3, secP160R2FieldElement2.f23920x, create3);
            iArr4 = createExt;
            iArr3 = create3;
        }
        int[] create4 = Nat160.create();
        SecP160R2Field.subtract(iArr4, iArr2, create4);
        SecP160R2Field.subtract(iArr3, iArr, create);
        if (Nat160.isZero(create4)) {
            return Nat160.isZero(create) ? twice() : curve.getInfinity();
        }
        SecP160R2Field.square(create4, create2);
        int[] create5 = Nat160.create();
        SecP160R2Field.multiply(create2, create4, create5);
        SecP160R2Field.multiply(create2, iArr4, create2);
        SecP160R2Field.negate(create5, create5);
        Nat160.mul(iArr3, create5, createExt);
        SecP160R2Field.reduce32(Nat160.addBothTo(create2, create2, create5), create5);
        SecP160R2FieldElement secP160R2FieldElement7 = new SecP160R2FieldElement(create3);
        SecP160R2Field.square(create, secP160R2FieldElement7.f23920x);
        int[] iArr5 = secP160R2FieldElement7.f23920x;
        SecP160R2Field.subtract(iArr5, create5, iArr5);
        SecP160R2FieldElement secP160R2FieldElement8 = new SecP160R2FieldElement(create5);
        SecP160R2Field.subtract(create2, secP160R2FieldElement7.f23920x, secP160R2FieldElement8.f23920x);
        SecP160R2Field.multiplyAddToExt(secP160R2FieldElement8.f23920x, create, createExt);
        SecP160R2Field.reduce(createExt, secP160R2FieldElement8.f23920x);
        SecP160R2FieldElement secP160R2FieldElement9 = new SecP160R2FieldElement(create4);
        if (!isOne) {
            int[] iArr6 = secP160R2FieldElement9.f23920x;
            SecP160R2Field.multiply(iArr6, secP160R2FieldElement5.f23920x, iArr6);
        }
        if (!isOne2) {
            int[] iArr7 = secP160R2FieldElement9.f23920x;
            SecP160R2Field.multiply(iArr7, secP160R2FieldElement6.f23920x, iArr7);
        }
        return new SecP160K1Point(curve, secP160R2FieldElement7, secP160R2FieldElement8, new ECFieldElement[]{secP160R2FieldElement9});
    }

    /* access modifiers changed from: protected */
    public ECPoint detach() {
        return new SecP160K1Point((ECCurve) null, getAffineXCoord(), getAffineYCoord());
    }

    public ECPoint negate() {
        return isInfinity() ? this : new SecP160K1Point(this.curve, this.f23906x, this.f23907y.negate(), this.zs);
    }

    public ECPoint threeTimes() {
        return (isInfinity() || this.f23907y.isZero()) ? this : twice().add(this);
    }

    public ECPoint twice() {
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecP160R2FieldElement secP160R2FieldElement = (SecP160R2FieldElement) this.f23907y;
        if (secP160R2FieldElement.isZero()) {
            return curve.getInfinity();
        }
        SecP160R2FieldElement secP160R2FieldElement2 = (SecP160R2FieldElement) this.f23906x;
        SecP160R2FieldElement secP160R2FieldElement3 = (SecP160R2FieldElement) this.zs[0];
        int[] create = Nat160.create();
        SecP160R2Field.square(secP160R2FieldElement.f23920x, create);
        int[] create2 = Nat160.create();
        SecP160R2Field.square(create, create2);
        int[] create3 = Nat160.create();
        SecP160R2Field.square(secP160R2FieldElement2.f23920x, create3);
        SecP160R2Field.reduce32(Nat160.addBothTo(create3, create3, create3), create3);
        SecP160R2Field.multiply(create, secP160R2FieldElement2.f23920x, create);
        SecP160R2Field.reduce32(Nat.shiftUpBits(5, create, 2, 0), create);
        int[] create4 = Nat160.create();
        SecP160R2Field.reduce32(Nat.shiftUpBits(5, create2, 3, 0, create4), create4);
        SecP160R2FieldElement secP160R2FieldElement4 = new SecP160R2FieldElement(create2);
        SecP160R2Field.square(create3, secP160R2FieldElement4.f23920x);
        int[] iArr = secP160R2FieldElement4.f23920x;
        SecP160R2Field.subtract(iArr, create, iArr);
        int[] iArr2 = secP160R2FieldElement4.f23920x;
        SecP160R2Field.subtract(iArr2, create, iArr2);
        SecP160R2FieldElement secP160R2FieldElement5 = new SecP160R2FieldElement(create);
        SecP160R2Field.subtract(create, secP160R2FieldElement4.f23920x, secP160R2FieldElement5.f23920x);
        int[] iArr3 = secP160R2FieldElement5.f23920x;
        SecP160R2Field.multiply(iArr3, create3, iArr3);
        int[] iArr4 = secP160R2FieldElement5.f23920x;
        SecP160R2Field.subtract(iArr4, create4, iArr4);
        SecP160R2FieldElement secP160R2FieldElement6 = new SecP160R2FieldElement(create3);
        SecP160R2Field.twice(secP160R2FieldElement.f23920x, secP160R2FieldElement6.f23920x);
        if (!secP160R2FieldElement3.isOne()) {
            int[] iArr5 = secP160R2FieldElement6.f23920x;
            SecP160R2Field.multiply(iArr5, secP160R2FieldElement3.f23920x, iArr5);
        }
        return new SecP160K1Point(curve, secP160R2FieldElement4, secP160R2FieldElement5, new ECFieldElement[]{secP160R2FieldElement6});
    }

    public ECPoint twicePlus(ECPoint eCPoint) {
        return this == eCPoint ? threeTimes() : isInfinity() ? eCPoint : eCPoint.isInfinity() ? twice() : this.f23907y.isZero() ? eCPoint : twice().add(eCPoint);
    }
}
