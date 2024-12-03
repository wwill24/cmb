package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import net.bytebuddy.jar.asm.Opcodes;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat192;
import org.bouncycastle.util.Arrays;

public class SecT163FieldElement extends ECFieldElement.AbstractF2m {

    /* renamed from: x  reason: collision with root package name */
    protected long[] f23939x;

    public SecT163FieldElement() {
        this.f23939x = Nat192.create64();
    }

    public SecT163FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 163) {
            throw new IllegalArgumentException("x value invalid for SecT163FieldElement");
        }
        this.f23939x = SecT163Field.fromBigInteger(bigInteger);
    }

    protected SecT163FieldElement(long[] jArr) {
        this.f23939x = jArr;
    }

    public ECFieldElement add(ECFieldElement eCFieldElement) {
        long[] create64 = Nat192.create64();
        SecT163Field.add(this.f23939x, ((SecT163FieldElement) eCFieldElement).f23939x, create64);
        return new SecT163FieldElement(create64);
    }

    public ECFieldElement addOne() {
        long[] create64 = Nat192.create64();
        SecT163Field.addOne(this.f23939x, create64);
        return new SecT163FieldElement(create64);
    }

    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        return multiply(eCFieldElement.invert());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT163FieldElement)) {
            return false;
        }
        return Nat192.eq64(this.f23939x, ((SecT163FieldElement) obj).f23939x);
    }

    public String getFieldName() {
        return "SecT163Field";
    }

    public int getFieldSize() {
        return Opcodes.IF_ICMPGT;
    }

    public int getK1() {
        return 3;
    }

    public int getK2() {
        return 6;
    }

    public int getK3() {
        return 7;
    }

    public int getM() {
        return Opcodes.IF_ICMPGT;
    }

    public int getRepresentation() {
        return 3;
    }

    public ECFieldElement halfTrace() {
        long[] create64 = Nat192.create64();
        SecT163Field.halfTrace(this.f23939x, create64);
        return new SecT163FieldElement(create64);
    }

    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f23939x, 0, 3) ^ 163763;
    }

    public ECFieldElement invert() {
        long[] create64 = Nat192.create64();
        SecT163Field.invert(this.f23939x, create64);
        return new SecT163FieldElement(create64);
    }

    public boolean isOne() {
        return Nat192.isOne64(this.f23939x);
    }

    public boolean isZero() {
        return Nat192.isZero64(this.f23939x);
    }

    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        long[] create64 = Nat192.create64();
        SecT163Field.multiply(this.f23939x, ((SecT163FieldElement) eCFieldElement).f23939x, create64);
        return new SecT163FieldElement(create64);
    }

    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f23939x;
        long[] jArr2 = ((SecT163FieldElement) eCFieldElement).f23939x;
        long[] jArr3 = ((SecT163FieldElement) eCFieldElement2).f23939x;
        long[] jArr4 = ((SecT163FieldElement) eCFieldElement3).f23939x;
        long[] createExt64 = Nat192.createExt64();
        SecT163Field.multiplyAddToExt(jArr, jArr2, createExt64);
        SecT163Field.multiplyAddToExt(jArr3, jArr4, createExt64);
        long[] create64 = Nat192.create64();
        SecT163Field.reduce(createExt64, create64);
        return new SecT163FieldElement(create64);
    }

    public ECFieldElement negate() {
        return this;
    }

    public ECFieldElement sqrt() {
        long[] create64 = Nat192.create64();
        SecT163Field.sqrt(this.f23939x, create64);
        return new SecT163FieldElement(create64);
    }

    public ECFieldElement square() {
        long[] create64 = Nat192.create64();
        SecT163Field.square(this.f23939x, create64);
        return new SecT163FieldElement(create64);
    }

    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return squarePlusProduct(eCFieldElement, eCFieldElement2);
    }

    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f23939x;
        long[] jArr2 = ((SecT163FieldElement) eCFieldElement).f23939x;
        long[] jArr3 = ((SecT163FieldElement) eCFieldElement2).f23939x;
        long[] createExt64 = Nat192.createExt64();
        SecT163Field.squareAddToExt(jArr, createExt64);
        SecT163Field.multiplyAddToExt(jArr2, jArr3, createExt64);
        long[] create64 = Nat192.create64();
        SecT163Field.reduce(createExt64, create64);
        return new SecT163FieldElement(create64);
    }

    public ECFieldElement squarePow(int i10) {
        if (i10 < 1) {
            return this;
        }
        long[] create64 = Nat192.create64();
        SecT163Field.squareN(this.f23939x, i10, create64);
        return new SecT163FieldElement(create64);
    }

    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        return add(eCFieldElement);
    }

    public boolean testBitZero() {
        return (this.f23939x[0] & 1) != 0;
    }

    public BigInteger toBigInteger() {
        return Nat192.toBigInteger64(this.f23939x);
    }

    public int trace() {
        return SecT163Field.trace(this.f23939x);
    }
}
