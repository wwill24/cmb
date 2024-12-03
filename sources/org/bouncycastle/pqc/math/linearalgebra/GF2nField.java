package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;
import java.util.Vector;

public abstract class GF2nField {
    protected GF2Polynomial fieldPolynomial;
    protected Vector fields;
    protected int mDegree;
    protected Vector matrices;
    protected final SecureRandom random;

    protected GF2nField(SecureRandom secureRandom) {
        this.random = secureRandom;
    }

    /* access modifiers changed from: protected */
    public abstract void computeCOBMatrix(GF2nField gF2nField);

    /* access modifiers changed from: protected */
    public abstract void computeFieldPolynomial();

    public final GF2nElement convert(GF2nElement gF2nElement, GF2nField gF2nField) throws RuntimeException {
        if (gF2nField == this || this.fieldPolynomial.equals(gF2nField.fieldPolynomial)) {
            return (GF2nElement) gF2nElement.clone();
        }
        if (this.mDegree == gF2nField.mDegree) {
            int indexOf = this.fields.indexOf(gF2nField);
            if (indexOf == -1) {
                computeCOBMatrix(gF2nField);
                indexOf = this.fields.indexOf(gF2nField);
            }
            GF2Polynomial[] gF2PolynomialArr = (GF2Polynomial[]) this.matrices.elementAt(indexOf);
            GF2nElement gF2nElement2 = (GF2nElement) gF2nElement.clone();
            if (gF2nElement2 instanceof GF2nONBElement) {
                ((GF2nONBElement) gF2nElement2).reverseOrder();
            }
            GF2Polynomial gF2Polynomial = new GF2Polynomial(this.mDegree, gF2nElement2.toFlexiBigInt());
            gF2Polynomial.expandN(this.mDegree);
            GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this.mDegree);
            for (int i10 = 0; i10 < this.mDegree; i10++) {
                if (gF2Polynomial.vectorMult(gF2PolynomialArr[i10])) {
                    gF2Polynomial2.setBit((this.mDegree - 1) - i10);
                }
            }
            if (gF2nField instanceof GF2nPolynomialField) {
                return new GF2nPolynomialElement((GF2nPolynomialField) gF2nField, gF2Polynomial2);
            }
            if (gF2nField instanceof GF2nONBField) {
                GF2nONBElement gF2nONBElement = new GF2nONBElement((GF2nONBField) gF2nField, gF2Polynomial2.toFlexiBigInt());
                gF2nONBElement.reverseOrder();
                return gF2nONBElement;
            }
            throw new RuntimeException("GF2nField.convert: B1 must be an instance of GF2nPolynomialField or GF2nONBField!");
        }
        throw new RuntimeException("GF2nField.convert: B1 has a different degree and thus cannot be coverted to!");
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GF2nField)) {
            return false;
        }
        GF2nField gF2nField = (GF2nField) obj;
        if (gF2nField.mDegree != this.mDegree || !this.fieldPolynomial.equals(gF2nField.fieldPolynomial)) {
            return false;
        }
        if (!(this instanceof GF2nPolynomialField) || (gF2nField instanceof GF2nPolynomialField)) {
            return !(this instanceof GF2nONBField) || (gF2nField instanceof GF2nONBField);
        }
        return false;
    }

    public final int getDegree() {
        return this.mDegree;
    }

    public final GF2Polynomial getFieldPolynomial() {
        if (this.fieldPolynomial == null) {
            computeFieldPolynomial();
        }
        return new GF2Polynomial(this.fieldPolynomial);
    }

    /* access modifiers changed from: protected */
    public abstract GF2nElement getRandomRoot(GF2Polynomial gF2Polynomial);

    public int hashCode() {
        return this.mDegree + this.fieldPolynomial.hashCode();
    }

    /* access modifiers changed from: protected */
    public final GF2Polynomial[] invertMatrix(GF2Polynomial[] gF2PolynomialArr) {
        GF2Polynomial[] gF2PolynomialArr2 = new GF2Polynomial[gF2PolynomialArr.length];
        GF2Polynomial[] gF2PolynomialArr3 = new GF2Polynomial[gF2PolynomialArr.length];
        int i10 = 0;
        for (int i11 = 0; i11 < this.mDegree; i11++) {
            gF2PolynomialArr2[i11] = new GF2Polynomial(gF2PolynomialArr[i11]);
            GF2Polynomial gF2Polynomial = new GF2Polynomial(this.mDegree);
            gF2PolynomialArr3[i11] = gF2Polynomial;
            gF2Polynomial.setBit((this.mDegree - 1) - i11);
        }
        while (true) {
            int i12 = this.mDegree;
            if (i10 < i12 - 1) {
                int i13 = i10;
                while (true) {
                    int i14 = this.mDegree;
                    if (i13 < i14 && !gF2PolynomialArr2[i13].testBit((i14 - 1) - i10)) {
                        i13++;
                    }
                }
                if (i13 < this.mDegree) {
                    if (i10 != i13) {
                        GF2Polynomial gF2Polynomial2 = gF2PolynomialArr2[i10];
                        gF2PolynomialArr2[i10] = gF2PolynomialArr2[i13];
                        gF2PolynomialArr2[i13] = gF2Polynomial2;
                        GF2Polynomial gF2Polynomial3 = gF2PolynomialArr3[i10];
                        gF2PolynomialArr3[i10] = gF2PolynomialArr3[i13];
                        gF2PolynomialArr3[i13] = gF2Polynomial3;
                    }
                    int i15 = i10 + 1;
                    int i16 = i15;
                    while (true) {
                        int i17 = this.mDegree;
                        if (i16 >= i17) {
                            break;
                        }
                        if (gF2PolynomialArr2[i16].testBit((i17 - 1) - i10)) {
                            gF2PolynomialArr2[i16].addToThis(gF2PolynomialArr2[i10]);
                            gF2PolynomialArr3[i16].addToThis(gF2PolynomialArr3[i10]);
                        }
                        i16++;
                    }
                    i10 = i15;
                } else {
                    throw new RuntimeException("GF2nField.invertMatrix: Matrix cannot be inverted!");
                }
            } else {
                for (int i18 = i12 - 1; i18 > 0; i18--) {
                    for (int i19 = i18 - 1; i19 >= 0; i19--) {
                        if (gF2PolynomialArr2[i19].testBit((this.mDegree - 1) - i18)) {
                            gF2PolynomialArr2[i19].addToThis(gF2PolynomialArr2[i18]);
                            gF2PolynomialArr3[i19].addToThis(gF2PolynomialArr3[i18]);
                        }
                    }
                }
                return gF2PolynomialArr3;
            }
        }
    }
}
