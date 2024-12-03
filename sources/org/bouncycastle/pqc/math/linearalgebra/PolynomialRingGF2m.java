package org.bouncycastle.pqc.math.linearalgebra;

public class PolynomialRingGF2m {
    private GF2mField field;

    /* renamed from: p  reason: collision with root package name */
    private PolynomialGF2mSmallM f24075p;
    protected PolynomialGF2mSmallM[] sqMatrix;
    protected PolynomialGF2mSmallM[] sqRootMatrix;

    public PolynomialRingGF2m(GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM) {
        this.field = gF2mField;
        this.f24075p = polynomialGF2mSmallM;
        computeSquaringMatrix();
        computeSquareRootMatrix();
    }

    private void computeSquareRootMatrix() {
        int coefficient;
        int degree = this.f24075p.getDegree();
        PolynomialGF2mSmallM[] polynomialGF2mSmallMArr = new PolynomialGF2mSmallM[degree];
        int i10 = degree - 1;
        for (int i11 = i10; i11 >= 0; i11--) {
            polynomialGF2mSmallMArr[i11] = new PolynomialGF2mSmallM(this.sqMatrix[i11]);
        }
        this.sqRootMatrix = new PolynomialGF2mSmallM[degree];
        while (i10 >= 0) {
            this.sqRootMatrix[i10] = new PolynomialGF2mSmallM(this.field, i10);
            i10--;
        }
        for (int i12 = 0; i12 < degree; i12++) {
            if (polynomialGF2mSmallMArr[i12].getCoefficient(i12) == 0) {
                int i13 = i12 + 1;
                boolean z10 = false;
                while (i13 < degree) {
                    if (polynomialGF2mSmallMArr[i13].getCoefficient(i12) != 0) {
                        swapColumns(polynomialGF2mSmallMArr, i12, i13);
                        swapColumns(this.sqRootMatrix, i12, i13);
                        i13 = degree;
                        z10 = true;
                    }
                    i13++;
                }
                if (!z10) {
                    throw new ArithmeticException("Squaring matrix is not invertible.");
                }
            }
            int inverse = this.field.inverse(polynomialGF2mSmallMArr[i12].getCoefficient(i12));
            polynomialGF2mSmallMArr[i12].multThisWithElement(inverse);
            this.sqRootMatrix[i12].multThisWithElement(inverse);
            for (int i14 = 0; i14 < degree; i14++) {
                if (!(i14 == i12 || (coefficient = polynomialGF2mSmallMArr[i14].getCoefficient(i12)) == 0)) {
                    PolynomialGF2mSmallM multWithElement = polynomialGF2mSmallMArr[i12].multWithElement(coefficient);
                    PolynomialGF2mSmallM multWithElement2 = this.sqRootMatrix[i12].multWithElement(coefficient);
                    polynomialGF2mSmallMArr[i14].addToThis(multWithElement);
                    this.sqRootMatrix[i14].addToThis(multWithElement2);
                }
            }
        }
    }

    private void computeSquaringMatrix() {
        int i10;
        int degree = this.f24075p.getDegree();
        this.sqMatrix = new PolynomialGF2mSmallM[degree];
        int i11 = 0;
        while (true) {
            i10 = degree >> 1;
            if (i11 >= i10) {
                break;
            }
            int i12 = i11 << 1;
            int[] iArr = new int[(i12 + 1)];
            iArr[i12] = 1;
            this.sqMatrix[i11] = new PolynomialGF2mSmallM(this.field, iArr);
            i11++;
        }
        while (i10 < degree) {
            int i13 = i10 << 1;
            int[] iArr2 = new int[(i13 + 1)];
            iArr2[i13] = 1;
            this.sqMatrix[i10] = new PolynomialGF2mSmallM(this.field, iArr2).mod(this.f24075p);
            i10++;
        }
    }

    private static void swapColumns(PolynomialGF2mSmallM[] polynomialGF2mSmallMArr, int i10, int i11) {
        PolynomialGF2mSmallM polynomialGF2mSmallM = polynomialGF2mSmallMArr[i10];
        polynomialGF2mSmallMArr[i10] = polynomialGF2mSmallMArr[i11];
        polynomialGF2mSmallMArr[i11] = polynomialGF2mSmallM;
    }

    public PolynomialGF2mSmallM[] getSquareRootMatrix() {
        return this.sqRootMatrix;
    }

    public PolynomialGF2mSmallM[] getSquaringMatrix() {
        return this.sqMatrix;
    }
}
