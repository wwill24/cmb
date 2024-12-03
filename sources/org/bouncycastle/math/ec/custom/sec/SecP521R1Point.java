package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat;

public class SecP521R1Point extends ECPoint.AbstractFp {
    SecP521R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    SecP521R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    /* JADX WARNING: type inference failed for: r17v0, types: [org.bouncycastle.math.ec.ECPoint] */
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
            org.bouncycastle.math.ec.ECFieldElement r3 = r0.f23906x
            org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement r3 = (org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement) r3
            org.bouncycastle.math.ec.ECFieldElement r4 = r0.f23907y
            org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement r4 = (org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement) r4
            org.bouncycastle.math.ec.ECFieldElement r5 = r17.getXCoord()
            org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement r5 = (org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement) r5
            org.bouncycastle.math.ec.ECFieldElement r6 = r17.getYCoord()
            org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement r6 = (org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement) r6
            org.bouncycastle.math.ec.ECFieldElement[] r7 = r0.zs
            r8 = 0
            r7 = r7[r8]
            org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement r7 = (org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement) r7
            org.bouncycastle.math.ec.ECFieldElement r1 = r1.getZCoord(r8)
            org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement r1 = (org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement) r1
            r9 = 17
            int[] r10 = org.bouncycastle.math.raw.Nat.create(r9)
            int[] r11 = org.bouncycastle.math.raw.Nat.create(r9)
            int[] r12 = org.bouncycastle.math.raw.Nat.create(r9)
            int[] r13 = org.bouncycastle.math.raw.Nat.create(r9)
            boolean r14 = r7.isOne()
            if (r14 == 0) goto L_0x005b
            int[] r5 = r5.f23936x
            int[] r6 = r6.f23936x
            goto L_0x0071
        L_0x005b:
            int[] r15 = r7.f23936x
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.square(r15, r12)
            int[] r5 = r5.f23936x
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.multiply(r12, r5, r11)
            int[] r5 = r7.f23936x
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.multiply(r12, r5, r12)
            int[] r5 = r6.f23936x
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.multiply(r12, r5, r12)
            r5 = r11
            r6 = r12
        L_0x0071:
            boolean r15 = r1.isOne()
            if (r15 == 0) goto L_0x007c
            int[] r3 = r3.f23936x
            int[] r4 = r4.f23936x
            goto L_0x0092
        L_0x007c:
            int[] r8 = r1.f23936x
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.square(r8, r13)
            int[] r3 = r3.f23936x
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.multiply(r13, r3, r10)
            int[] r3 = r1.f23936x
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.multiply(r13, r3, r13)
            int[] r3 = r4.f23936x
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.multiply(r13, r3, r13)
            r3 = r10
            r4 = r13
        L_0x0092:
            int[] r8 = org.bouncycastle.math.raw.Nat.create(r9)
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.subtract(r3, r5, r8)
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.subtract(r4, r6, r11)
            boolean r5 = org.bouncycastle.math.raw.Nat.isZero(r9, r8)
            if (r5 == 0) goto L_0x00b2
            boolean r1 = org.bouncycastle.math.raw.Nat.isZero(r9, r11)
            if (r1 == 0) goto L_0x00ad
            org.bouncycastle.math.ec.ECPoint r1 = r16.twice()
            return r1
        L_0x00ad:
            org.bouncycastle.math.ec.ECPoint r1 = r2.getInfinity()
            return r1
        L_0x00b2:
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.square(r8, r12)
            int[] r5 = org.bouncycastle.math.raw.Nat.create(r9)
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.multiply(r12, r8, r5)
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.multiply(r12, r3, r12)
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.multiply(r4, r5, r10)
            org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement r3 = new org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement
            r3.<init>((int[]) r13)
            int[] r4 = r3.f23936x
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.square(r11, r4)
            int[] r4 = r3.f23936x
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.add(r4, r5, r4)
            int[] r4 = r3.f23936x
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.subtract(r4, r12, r4)
            int[] r4 = r3.f23936x
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.subtract(r4, r12, r4)
            org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement r4 = new org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement
            r4.<init>((int[]) r5)
            int[] r5 = r3.f23936x
            int[] r6 = r4.f23936x
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.subtract(r12, r5, r6)
            int[] r5 = r4.f23936x
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.multiply(r5, r11, r11)
            int[] r5 = r4.f23936x
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.subtract(r11, r10, r5)
            org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement r5 = new org.bouncycastle.math.ec.custom.sec.SecP521R1FieldElement
            r5.<init>((int[]) r8)
            if (r14 != 0) goto L_0x00ff
            int[] r6 = r5.f23936x
            int[] r7 = r7.f23936x
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.multiply(r6, r7, r6)
        L_0x00ff:
            if (r15 != 0) goto L_0x0108
            int[] r6 = r5.f23936x
            int[] r1 = r1.f23936x
            org.bouncycastle.math.ec.custom.sec.SecP521R1Field.multiply(r6, r1, r6)
        L_0x0108:
            r1 = 1
            org.bouncycastle.math.ec.ECFieldElement[] r1 = new org.bouncycastle.math.ec.ECFieldElement[r1]
            r6 = 0
            r1[r6] = r5
            org.bouncycastle.math.ec.custom.sec.SecP521R1Point r5 = new org.bouncycastle.math.ec.custom.sec.SecP521R1Point
            r5.<init>(r2, r3, r4, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.math.ec.custom.sec.SecP521R1Point.add(org.bouncycastle.math.ec.ECPoint):org.bouncycastle.math.ec.ECPoint");
    }

    /* access modifiers changed from: protected */
    public ECPoint detach() {
        return new SecP521R1Point((ECCurve) null, getAffineXCoord(), getAffineYCoord());
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

    public ECPoint negate() {
        return isInfinity() ? this : new SecP521R1Point(this.curve, this.f23906x, this.f23907y.negate(), this.zs);
    }

    /* access modifiers changed from: protected */
    public ECFieldElement three(ECFieldElement eCFieldElement) {
        return two(eCFieldElement).add(eCFieldElement);
    }

    public ECPoint threeTimes() {
        return (isInfinity() || this.f23907y.isZero()) ? this : twice().add(this);
    }

    public ECPoint twice() {
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecP521R1FieldElement secP521R1FieldElement = (SecP521R1FieldElement) this.f23907y;
        if (secP521R1FieldElement.isZero()) {
            return curve.getInfinity();
        }
        SecP521R1FieldElement secP521R1FieldElement2 = (SecP521R1FieldElement) this.f23906x;
        SecP521R1FieldElement secP521R1FieldElement3 = (SecP521R1FieldElement) this.zs[0];
        int[] create = Nat.create(17);
        int[] create2 = Nat.create(17);
        int[] create3 = Nat.create(17);
        SecP521R1Field.square(secP521R1FieldElement.f23936x, create3);
        int[] create4 = Nat.create(17);
        SecP521R1Field.square(create3, create4);
        boolean isOne = secP521R1FieldElement3.isOne();
        int[] iArr = secP521R1FieldElement3.f23936x;
        if (!isOne) {
            SecP521R1Field.square(iArr, create2);
            iArr = create2;
        }
        SecP521R1Field.subtract(secP521R1FieldElement2.f23936x, iArr, create);
        SecP521R1Field.add(secP521R1FieldElement2.f23936x, iArr, create2);
        SecP521R1Field.multiply(create2, create, create2);
        Nat.addBothTo(17, create2, create2, create2);
        SecP521R1Field.reduce23(create2);
        SecP521R1Field.multiply(create3, secP521R1FieldElement2.f23936x, create3);
        Nat.shiftUpBits(17, create3, 2, 0);
        SecP521R1Field.reduce23(create3);
        Nat.shiftUpBits(17, create4, 3, 0, create);
        SecP521R1Field.reduce23(create);
        SecP521R1FieldElement secP521R1FieldElement4 = new SecP521R1FieldElement(create4);
        SecP521R1Field.square(create2, secP521R1FieldElement4.f23936x);
        int[] iArr2 = secP521R1FieldElement4.f23936x;
        SecP521R1Field.subtract(iArr2, create3, iArr2);
        int[] iArr3 = secP521R1FieldElement4.f23936x;
        SecP521R1Field.subtract(iArr3, create3, iArr3);
        SecP521R1FieldElement secP521R1FieldElement5 = new SecP521R1FieldElement(create3);
        SecP521R1Field.subtract(create3, secP521R1FieldElement4.f23936x, secP521R1FieldElement5.f23936x);
        int[] iArr4 = secP521R1FieldElement5.f23936x;
        SecP521R1Field.multiply(iArr4, create2, iArr4);
        int[] iArr5 = secP521R1FieldElement5.f23936x;
        SecP521R1Field.subtract(iArr5, create, iArr5);
        SecP521R1FieldElement secP521R1FieldElement6 = new SecP521R1FieldElement(create2);
        SecP521R1Field.twice(secP521R1FieldElement.f23936x, secP521R1FieldElement6.f23936x);
        if (!isOne) {
            int[] iArr6 = secP521R1FieldElement6.f23936x;
            SecP521R1Field.multiply(iArr6, secP521R1FieldElement3.f23936x, iArr6);
        }
        return new SecP521R1Point(curve, secP521R1FieldElement4, secP521R1FieldElement5, new ECFieldElement[]{secP521R1FieldElement6});
    }

    public ECPoint twicePlus(ECPoint eCPoint) {
        return this == eCPoint ? threeTimes() : isInfinity() ? eCPoint : eCPoint.isInfinity() ? twice() : this.f23907y.isZero() ? eCPoint : twice().add(eCPoint);
    }

    /* access modifiers changed from: protected */
    public ECFieldElement two(ECFieldElement eCFieldElement) {
        return eCFieldElement.add(eCFieldElement);
    }
}
