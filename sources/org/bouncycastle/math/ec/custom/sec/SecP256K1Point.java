package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;

public class SecP256K1Point extends ECPoint.AbstractFp {
    SecP256K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    SecP256K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
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
        SecP256K1FieldElement secP256K1FieldElement = (SecP256K1FieldElement) this.f23906x;
        SecP256K1FieldElement secP256K1FieldElement2 = (SecP256K1FieldElement) this.f23907y;
        SecP256K1FieldElement secP256K1FieldElement3 = (SecP256K1FieldElement) eCPoint.getXCoord();
        SecP256K1FieldElement secP256K1FieldElement4 = (SecP256K1FieldElement) eCPoint.getYCoord();
        SecP256K1FieldElement secP256K1FieldElement5 = (SecP256K1FieldElement) this.zs[0];
        SecP256K1FieldElement secP256K1FieldElement6 = (SecP256K1FieldElement) eCPoint.getZCoord(0);
        int[] createExt = Nat256.createExt();
        int[] create = Nat256.create();
        int[] create2 = Nat256.create();
        int[] create3 = Nat256.create();
        boolean isOne = secP256K1FieldElement5.isOne();
        if (isOne) {
            iArr2 = secP256K1FieldElement3.f23930x;
            iArr = secP256K1FieldElement4.f23930x;
        } else {
            SecP256K1Field.square(secP256K1FieldElement5.f23930x, create2);
            SecP256K1Field.multiply(create2, secP256K1FieldElement3.f23930x, create);
            SecP256K1Field.multiply(create2, secP256K1FieldElement5.f23930x, create2);
            SecP256K1Field.multiply(create2, secP256K1FieldElement4.f23930x, create2);
            iArr2 = create;
            iArr = create2;
        }
        boolean isOne2 = secP256K1FieldElement6.isOne();
        if (isOne2) {
            iArr4 = secP256K1FieldElement.f23930x;
            iArr3 = secP256K1FieldElement2.f23930x;
        } else {
            SecP256K1Field.square(secP256K1FieldElement6.f23930x, create3);
            SecP256K1Field.multiply(create3, secP256K1FieldElement.f23930x, createExt);
            SecP256K1Field.multiply(create3, secP256K1FieldElement6.f23930x, create3);
            SecP256K1Field.multiply(create3, secP256K1FieldElement2.f23930x, create3);
            iArr4 = createExt;
            iArr3 = create3;
        }
        int[] create4 = Nat256.create();
        SecP256K1Field.subtract(iArr4, iArr2, create4);
        SecP256K1Field.subtract(iArr3, iArr, create);
        if (Nat256.isZero(create4)) {
            return Nat256.isZero(create) ? twice() : curve.getInfinity();
        }
        SecP256K1Field.square(create4, create2);
        int[] create5 = Nat256.create();
        SecP256K1Field.multiply(create2, create4, create5);
        SecP256K1Field.multiply(create2, iArr4, create2);
        SecP256K1Field.negate(create5, create5);
        Nat256.mul(iArr3, create5, createExt);
        SecP256K1Field.reduce32(Nat256.addBothTo(create2, create2, create5), create5);
        SecP256K1FieldElement secP256K1FieldElement7 = new SecP256K1FieldElement(create3);
        SecP256K1Field.square(create, secP256K1FieldElement7.f23930x);
        int[] iArr5 = secP256K1FieldElement7.f23930x;
        SecP256K1Field.subtract(iArr5, create5, iArr5);
        SecP256K1FieldElement secP256K1FieldElement8 = new SecP256K1FieldElement(create5);
        SecP256K1Field.subtract(create2, secP256K1FieldElement7.f23930x, secP256K1FieldElement8.f23930x);
        SecP256K1Field.multiplyAddToExt(secP256K1FieldElement8.f23930x, create, createExt);
        SecP256K1Field.reduce(createExt, secP256K1FieldElement8.f23930x);
        SecP256K1FieldElement secP256K1FieldElement9 = new SecP256K1FieldElement(create4);
        if (!isOne) {
            int[] iArr6 = secP256K1FieldElement9.f23930x;
            SecP256K1Field.multiply(iArr6, secP256K1FieldElement5.f23930x, iArr6);
        }
        if (!isOne2) {
            int[] iArr7 = secP256K1FieldElement9.f23930x;
            SecP256K1Field.multiply(iArr7, secP256K1FieldElement6.f23930x, iArr7);
        }
        return new SecP256K1Point(curve, secP256K1FieldElement7, secP256K1FieldElement8, new ECFieldElement[]{secP256K1FieldElement9});
    }

    /* access modifiers changed from: protected */
    public ECPoint detach() {
        return new SecP256K1Point((ECCurve) null, getAffineXCoord(), getAffineYCoord());
    }

    public ECPoint negate() {
        return isInfinity() ? this : new SecP256K1Point(this.curve, this.f23906x, this.f23907y.negate(), this.zs);
    }

    public ECPoint threeTimes() {
        return (isInfinity() || this.f23907y.isZero()) ? this : twice().add(this);
    }

    public ECPoint twice() {
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecP256K1FieldElement secP256K1FieldElement = (SecP256K1FieldElement) this.f23907y;
        if (secP256K1FieldElement.isZero()) {
            return curve.getInfinity();
        }
        SecP256K1FieldElement secP256K1FieldElement2 = (SecP256K1FieldElement) this.f23906x;
        SecP256K1FieldElement secP256K1FieldElement3 = (SecP256K1FieldElement) this.zs[0];
        int[] create = Nat256.create();
        SecP256K1Field.square(secP256K1FieldElement.f23930x, create);
        int[] create2 = Nat256.create();
        SecP256K1Field.square(create, create2);
        int[] create3 = Nat256.create();
        SecP256K1Field.square(secP256K1FieldElement2.f23930x, create3);
        SecP256K1Field.reduce32(Nat256.addBothTo(create3, create3, create3), create3);
        SecP256K1Field.multiply(create, secP256K1FieldElement2.f23930x, create);
        SecP256K1Field.reduce32(Nat.shiftUpBits(8, create, 2, 0), create);
        int[] create4 = Nat256.create();
        SecP256K1Field.reduce32(Nat.shiftUpBits(8, create2, 3, 0, create4), create4);
        SecP256K1FieldElement secP256K1FieldElement4 = new SecP256K1FieldElement(create2);
        SecP256K1Field.square(create3, secP256K1FieldElement4.f23930x);
        int[] iArr = secP256K1FieldElement4.f23930x;
        SecP256K1Field.subtract(iArr, create, iArr);
        int[] iArr2 = secP256K1FieldElement4.f23930x;
        SecP256K1Field.subtract(iArr2, create, iArr2);
        SecP256K1FieldElement secP256K1FieldElement5 = new SecP256K1FieldElement(create);
        SecP256K1Field.subtract(create, secP256K1FieldElement4.f23930x, secP256K1FieldElement5.f23930x);
        int[] iArr3 = secP256K1FieldElement5.f23930x;
        SecP256K1Field.multiply(iArr3, create3, iArr3);
        int[] iArr4 = secP256K1FieldElement5.f23930x;
        SecP256K1Field.subtract(iArr4, create4, iArr4);
        SecP256K1FieldElement secP256K1FieldElement6 = new SecP256K1FieldElement(create3);
        SecP256K1Field.twice(secP256K1FieldElement.f23930x, secP256K1FieldElement6.f23930x);
        if (!secP256K1FieldElement3.isOne()) {
            int[] iArr5 = secP256K1FieldElement6.f23930x;
            SecP256K1Field.multiply(iArr5, secP256K1FieldElement3.f23930x, iArr5);
        }
        return new SecP256K1Point(curve, secP256K1FieldElement4, secP256K1FieldElement5, new ECFieldElement[]{secP256K1FieldElement6});
    }

    public ECPoint twicePlus(ECPoint eCPoint) {
        return this == eCPoint ? threeTimes() : isInfinity() ? eCPoint : eCPoint.isInfinity() ? twice() : this.f23907y.isZero() ? eCPoint : twice().add(eCPoint);
    }
}
