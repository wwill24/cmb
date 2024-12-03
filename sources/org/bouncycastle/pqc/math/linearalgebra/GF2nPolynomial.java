package org.bouncycastle.pqc.math.linearalgebra;

public class GF2nPolynomial {
    private GF2nElement[] coeff;
    private int size;

    private GF2nPolynomial(int i10) {
        this.size = i10;
        this.coeff = new GF2nElement[i10];
    }

    public GF2nPolynomial(int i10, GF2nElement gF2nElement) {
        this.size = i10;
        this.coeff = new GF2nElement[i10];
        for (int i11 = 0; i11 < this.size; i11++) {
            this.coeff[i11] = (GF2nElement) gF2nElement.clone();
        }
    }

    public GF2nPolynomial(GF2Polynomial gF2Polynomial, GF2nField gF2nField) {
        int degree = gF2nField.getDegree() + 1;
        this.size = degree;
        this.coeff = new GF2nElement[degree];
        int i10 = 0;
        if (gF2nField instanceof GF2nONBField) {
            while (i10 < this.size) {
                if (gF2Polynomial.testBit(i10)) {
                    this.coeff[i10] = GF2nONBElement.ONE((GF2nONBField) gF2nField);
                } else {
                    this.coeff[i10] = GF2nONBElement.ZERO((GF2nONBField) gF2nField);
                }
                i10++;
            }
        } else if (gF2nField instanceof GF2nPolynomialField) {
            while (i10 < this.size) {
                if (gF2Polynomial.testBit(i10)) {
                    this.coeff[i10] = GF2nPolynomialElement.ONE((GF2nPolynomialField) gF2nField);
                } else {
                    this.coeff[i10] = GF2nPolynomialElement.ZERO((GF2nPolynomialField) gF2nField);
                }
                i10++;
            }
        } else {
            throw new IllegalArgumentException("PolynomialGF2n(Bitstring, GF2nField): B1 must be an instance of GF2nONBField or GF2nPolynomialField!");
        }
    }

    public GF2nPolynomial(GF2nPolynomial gF2nPolynomial) {
        int i10 = gF2nPolynomial.size;
        this.coeff = new GF2nElement[i10];
        this.size = i10;
        for (int i11 = 0; i11 < this.size; i11++) {
            this.coeff[i11] = (GF2nElement) gF2nPolynomial.coeff[i11].clone();
        }
    }

    public final GF2nPolynomial add(GF2nPolynomial gF2nPolynomial) {
        GF2nPolynomial gF2nPolynomial2;
        int i10 = 0;
        if (size() >= gF2nPolynomial.size()) {
            gF2nPolynomial2 = new GF2nPolynomial(size());
            while (i10 < gF2nPolynomial.size()) {
                gF2nPolynomial2.coeff[i10] = (GF2nElement) this.coeff[i10].add(gF2nPolynomial.coeff[i10]);
                i10++;
            }
            while (i10 < size()) {
                gF2nPolynomial2.coeff[i10] = this.coeff[i10];
                i10++;
            }
        } else {
            gF2nPolynomial2 = new GF2nPolynomial(gF2nPolynomial.size());
            while (i10 < size()) {
                gF2nPolynomial2.coeff[i10] = (GF2nElement) this.coeff[i10].add(gF2nPolynomial.coeff[i10]);
                i10++;
            }
            while (i10 < gF2nPolynomial.size()) {
                gF2nPolynomial2.coeff[i10] = gF2nPolynomial.coeff[i10];
                i10++;
            }
        }
        return gF2nPolynomial2;
    }

    public final void assignZeroToElements() {
        for (int i10 = 0; i10 < this.size; i10++) {
            this.coeff[i10].assignZero();
        }
    }

    public final GF2nElement at(int i10) {
        return this.coeff[i10];
    }

    public final GF2nPolynomial[] divide(GF2nPolynomial gF2nPolynomial) {
        GF2nPolynomial gF2nPolynomial2;
        GF2nPolynomial[] gF2nPolynomialArr = new GF2nPolynomial[2];
        GF2nPolynomial gF2nPolynomial3 = new GF2nPolynomial(this);
        gF2nPolynomial3.shrink();
        int degree = gF2nPolynomial.getDegree();
        GF2nElement gF2nElement = (GF2nElement) gF2nPolynomial.coeff[degree].invert();
        if (gF2nPolynomial3.getDegree() < degree) {
            GF2nPolynomial gF2nPolynomial4 = new GF2nPolynomial(this);
            gF2nPolynomialArr[0] = gF2nPolynomial4;
            gF2nPolynomial4.assignZeroToElements();
            gF2nPolynomialArr[0].shrink();
            gF2nPolynomial2 = new GF2nPolynomial(this);
            gF2nPolynomialArr[1] = gF2nPolynomial2;
        } else {
            GF2nPolynomial gF2nPolynomial5 = new GF2nPolynomial(this);
            gF2nPolynomialArr[0] = gF2nPolynomial5;
            gF2nPolynomial5.assignZeroToElements();
            while (true) {
                int degree2 = gF2nPolynomial3.getDegree() - degree;
                if (degree2 < 0) {
                    break;
                }
                GF2nElement gF2nElement2 = (GF2nElement) gF2nPolynomial3.coeff[gF2nPolynomial3.getDegree()].multiply(gF2nElement);
                GF2nPolynomial scalarMultiply = gF2nPolynomial.scalarMultiply(gF2nElement2);
                scalarMultiply.shiftThisLeft(degree2);
                gF2nPolynomial3 = gF2nPolynomial3.add(scalarMultiply);
                gF2nPolynomial3.shrink();
                gF2nPolynomialArr[0].coeff[degree2] = (GF2nElement) gF2nElement2.clone();
            }
            gF2nPolynomialArr[1] = gF2nPolynomial3;
            gF2nPolynomial2 = gF2nPolynomialArr[0];
        }
        gF2nPolynomial2.shrink();
        return gF2nPolynomialArr;
    }

    public final void enlarge(int i10) {
        int i11 = this.size;
        if (i10 > i11) {
            GF2nElement[] gF2nElementArr = new GF2nElement[i10];
            System.arraycopy(this.coeff, 0, gF2nElementArr, 0, i11);
            GF2nField field = this.coeff[0].getField();
            GF2nElement gF2nElement = this.coeff[0];
            if (gF2nElement instanceof GF2nPolynomialElement) {
                for (int i12 = this.size; i12 < i10; i12++) {
                    gF2nElementArr[i12] = GF2nPolynomialElement.ZERO((GF2nPolynomialField) field);
                }
            } else if (gF2nElement instanceof GF2nONBElement) {
                for (int i13 = this.size; i13 < i10; i13++) {
                    gF2nElementArr[i13] = GF2nONBElement.ZERO((GF2nONBField) field);
                }
            }
            this.size = i10;
            this.coeff = gF2nElementArr;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GF2nPolynomial)) {
            return false;
        }
        GF2nPolynomial gF2nPolynomial = (GF2nPolynomial) obj;
        if (getDegree() != gF2nPolynomial.getDegree()) {
            return false;
        }
        for (int i10 = 0; i10 < this.size; i10++) {
            if (!this.coeff[i10].equals(gF2nPolynomial.coeff[i10])) {
                return false;
            }
        }
        return true;
    }

    public final GF2nPolynomial gcd(GF2nPolynomial gF2nPolynomial) {
        GF2nPolynomial gF2nPolynomial2 = new GF2nPolynomial(this);
        GF2nPolynomial gF2nPolynomial3 = new GF2nPolynomial(gF2nPolynomial);
        gF2nPolynomial2.shrink();
        gF2nPolynomial3.shrink();
        GF2nPolynomial gF2nPolynomial4 = gF2nPolynomial2;
        GF2nPolynomial gF2nPolynomial5 = gF2nPolynomial3;
        while (!gF2nPolynomial5.isZero()) {
            GF2nPolynomial gF2nPolynomial6 = gF2nPolynomial5;
            gF2nPolynomial5 = gF2nPolynomial4.remainder(gF2nPolynomial5);
            gF2nPolynomial4 = gF2nPolynomial6;
        }
        return gF2nPolynomial4.scalarMultiply((GF2nElement) gF2nPolynomial4.coeff[gF2nPolynomial4.getDegree()].invert());
    }

    public final int getDegree() {
        for (int i10 = this.size - 1; i10 >= 0; i10--) {
            if (!this.coeff[i10].isZero()) {
                return i10;
            }
        }
        return -1;
    }

    public int hashCode() {
        return getDegree() + this.coeff.hashCode();
    }

    public final boolean isZero() {
        for (int i10 = 0; i10 < this.size; i10++) {
            GF2nElement gF2nElement = this.coeff[i10];
            if (gF2nElement != null && !gF2nElement.isZero()) {
                return false;
            }
        }
        return true;
    }

    public final GF2nPolynomial multiply(GF2nPolynomial gF2nPolynomial) {
        int size2 = size();
        if (size2 == gF2nPolynomial.size()) {
            GF2nPolynomial gF2nPolynomial2 = new GF2nPolynomial((size2 << 1) - 1);
            for (int i10 = 0; i10 < size(); i10++) {
                for (int i11 = 0; i11 < gF2nPolynomial.size(); i11++) {
                    GF2nElement[] gF2nElementArr = gF2nPolynomial2.coeff;
                    int i12 = i10 + i11;
                    GF2nElement gF2nElement = gF2nElementArr[i12];
                    if (gF2nElement == null) {
                        gF2nElementArr[i12] = (GF2nElement) this.coeff[i10].multiply(gF2nPolynomial.coeff[i11]);
                    } else {
                        gF2nElementArr[i12] = (GF2nElement) gF2nElement.add(this.coeff[i10].multiply(gF2nPolynomial.coeff[i11]));
                    }
                }
            }
            return gF2nPolynomial2;
        }
        throw new IllegalArgumentException("PolynomialGF2n.multiply: this and b must have the same size!");
    }

    public final GF2nPolynomial multiplyAndReduce(GF2nPolynomial gF2nPolynomial, GF2nPolynomial gF2nPolynomial2) {
        return multiply(gF2nPolynomial).reduce(gF2nPolynomial2);
    }

    public final GF2nPolynomial quotient(GF2nPolynomial gF2nPolynomial) throws RuntimeException, ArithmeticException {
        return divide(gF2nPolynomial)[0];
    }

    public final GF2nPolynomial reduce(GF2nPolynomial gF2nPolynomial) throws RuntimeException, ArithmeticException {
        return remainder(gF2nPolynomial);
    }

    public final GF2nPolynomial remainder(GF2nPolynomial gF2nPolynomial) throws RuntimeException, ArithmeticException {
        return divide(gF2nPolynomial)[1];
    }

    public final GF2nPolynomial scalarMultiply(GF2nElement gF2nElement) {
        GF2nPolynomial gF2nPolynomial = new GF2nPolynomial(size());
        for (int i10 = 0; i10 < size(); i10++) {
            gF2nPolynomial.coeff[i10] = (GF2nElement) this.coeff[i10].multiply(gF2nElement);
        }
        return gF2nPolynomial;
    }

    public final void set(int i10, GF2nElement gF2nElement) {
        if ((gF2nElement instanceof GF2nPolynomialElement) || (gF2nElement instanceof GF2nONBElement)) {
            this.coeff[i10] = (GF2nElement) gF2nElement.clone();
            return;
        }
        throw new IllegalArgumentException("PolynomialGF2n.set f must be an instance of either GF2nPolynomialElement or GF2nONBElement!");
    }

    public final GF2nPolynomial shiftLeft(int i10) {
        if (i10 <= 0) {
            return new GF2nPolynomial(this);
        }
        GF2nPolynomial gF2nPolynomial = new GF2nPolynomial(this.size + i10, this.coeff[0]);
        gF2nPolynomial.assignZeroToElements();
        for (int i11 = 0; i11 < this.size; i11++) {
            gF2nPolynomial.coeff[i11 + i10] = this.coeff[i11];
        }
        return gF2nPolynomial;
    }

    public final void shiftThisLeft(int i10) {
        if (i10 > 0) {
            int i11 = this.size;
            GF2nField field = this.coeff[0].getField();
            enlarge(this.size + i10);
            for (int i12 = i11 - 1; i12 >= 0; i12--) {
                GF2nElement[] gF2nElementArr = this.coeff;
                gF2nElementArr[i12 + i10] = gF2nElementArr[i12];
            }
            GF2nElement gF2nElement = this.coeff[0];
            if (gF2nElement instanceof GF2nPolynomialElement) {
                for (int i13 = i10 - 1; i13 >= 0; i13--) {
                    this.coeff[i13] = GF2nPolynomialElement.ZERO((GF2nPolynomialField) field);
                }
            } else if (gF2nElement instanceof GF2nONBElement) {
                for (int i14 = i10 - 1; i14 >= 0; i14--) {
                    this.coeff[i14] = GF2nONBElement.ZERO((GF2nONBField) field);
                }
            }
        }
    }

    public final void shrink() {
        int i10 = this.size;
        while (true) {
            i10--;
            if (!this.coeff[i10].isZero() || i10 <= 0) {
                int i11 = i10 + 1;
            }
        }
        int i112 = i10 + 1;
        if (i112 < this.size) {
            GF2nElement[] gF2nElementArr = new GF2nElement[i112];
            System.arraycopy(this.coeff, 0, gF2nElementArr, 0, i112);
            this.coeff = gF2nElementArr;
            this.size = i112;
        }
    }

    public final int size() {
        return this.size;
    }
}
