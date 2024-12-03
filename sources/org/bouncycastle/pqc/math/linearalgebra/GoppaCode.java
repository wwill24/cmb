package org.bouncycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;
import java.security.SecureRandom;

public final class GoppaCode {

    public static class MaMaPe {

        /* renamed from: h  reason: collision with root package name */
        private GF2Matrix f24071h;

        /* renamed from: p  reason: collision with root package name */
        private Permutation f24072p;

        /* renamed from: s  reason: collision with root package name */
        private GF2Matrix f24073s;

        public MaMaPe(GF2Matrix gF2Matrix, GF2Matrix gF2Matrix2, Permutation permutation) {
            this.f24073s = gF2Matrix;
            this.f24071h = gF2Matrix2;
            this.f24072p = permutation;
        }

        public GF2Matrix getFirstMatrix() {
            return this.f24073s;
        }

        public Permutation getPermutation() {
            return this.f24072p;
        }

        public GF2Matrix getSecondMatrix() {
            return this.f24071h;
        }
    }

    public static class MatrixSet {

        /* renamed from: g  reason: collision with root package name */
        private GF2Matrix f24074g;
        private int[] setJ;

        public MatrixSet(GF2Matrix gF2Matrix, int[] iArr) {
            this.f24074g = gF2Matrix;
            this.setJ = iArr;
        }

        public GF2Matrix getG() {
            return this.f24074g;
        }

        public int[] getSetJ() {
            return this.setJ;
        }
    }

    private GoppaCode() {
    }

    public static MaMaPe computeSystematicForm(GF2Matrix gF2Matrix, SecureRandom secureRandom) {
        Permutation permutation;
        GF2Matrix gF2Matrix2;
        GF2Matrix leftSubMatrix;
        boolean z10;
        int numColumns = gF2Matrix.getNumColumns();
        GF2Matrix gF2Matrix3 = null;
        do {
            permutation = new Permutation(numColumns, secureRandom);
            gF2Matrix2 = (GF2Matrix) gF2Matrix.rightMultiply(permutation);
            leftSubMatrix = gF2Matrix2.getLeftSubMatrix();
            z10 = true;
            try {
                gF2Matrix3 = (GF2Matrix) leftSubMatrix.computeInverse();
                continue;
            } catch (ArithmeticException unused) {
                z10 = false;
                continue;
            }
        } while (!z10);
        return new MaMaPe(leftSubMatrix, ((GF2Matrix) gF2Matrix3.rightMultiply((Matrix) gF2Matrix2)).getRightSubMatrix(), permutation);
    }

    public static GF2Matrix createCanonicalCheckMatrix(GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM) {
        GF2mField gF2mField2 = gF2mField;
        PolynomialGF2mSmallM polynomialGF2mSmallM2 = polynomialGF2mSmallM;
        int degree = gF2mField.getDegree();
        int i10 = 1 << degree;
        int degree2 = polynomialGF2mSmallM.getDegree();
        int[] iArr = new int[2];
        iArr[1] = i10;
        int i11 = 0;
        iArr[0] = degree2;
        Class cls = Integer.TYPE;
        int[][] iArr2 = (int[][]) Array.newInstance(cls, iArr);
        int[] iArr3 = new int[2];
        iArr3[1] = i10;
        iArr3[0] = degree2;
        int[][] iArr4 = (int[][]) Array.newInstance(cls, iArr3);
        for (int i12 = 0; i12 < i10; i12++) {
            iArr4[0][i12] = gF2mField2.inverse(polynomialGF2mSmallM2.evaluateAt(i12));
        }
        for (int i13 = 1; i13 < degree2; i13++) {
            for (int i14 = 0; i14 < i10; i14++) {
                iArr4[i13][i14] = gF2mField2.mult(iArr4[i13 - 1][i14], i14);
            }
        }
        int i15 = 0;
        while (i15 < degree2) {
            int i16 = i11;
            while (i16 < i10) {
                for (int i17 = i11; i17 <= i15; i17++) {
                    int[] iArr5 = iArr2[i15];
                    iArr5[i16] = gF2mField2.add(iArr5[i16], gF2mField2.mult(iArr4[i17][i16], polynomialGF2mSmallM2.getCoefficient((degree2 + i17) - i15)));
                }
                i16++;
                i11 = 0;
            }
            i15++;
            i11 = 0;
        }
        int[] iArr6 = new int[2];
        iArr6[1] = (i10 + 31) >>> 5;
        iArr6[0] = degree2 * degree;
        int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, iArr6);
        for (int i18 = 0; i18 < i10; i18++) {
            int i19 = i18 >>> 5;
            int i20 = 1 << (i18 & 31);
            for (int i21 = 0; i21 < degree2; i21++) {
                int i22 = iArr2[i21][i18];
                for (int i23 = 0; i23 < degree; i23++) {
                    if (((i22 >>> i23) & 1) != 0) {
                        int[] iArr8 = iArr7[(((i21 + 1) * degree) - i23) - 1];
                        iArr8[i19] = iArr8[i19] ^ i20;
                    }
                }
            }
        }
        return new GF2Matrix(i10, iArr7);
    }

    public static GF2Vector syndromeDecode(GF2Vector gF2Vector, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        int degree = 1 << gF2mField.getDegree();
        GF2Vector gF2Vector2 = new GF2Vector(degree);
        if (!gF2Vector.isZero()) {
            PolynomialGF2mSmallM[] modPolynomialToFracton = new PolynomialGF2mSmallM(gF2Vector.toExtensionFieldVector(gF2mField)).modInverse(polynomialGF2mSmallM).addMonomial(1).modSquareRootMatrix(polynomialGF2mSmallMArr).modPolynomialToFracton(polynomialGF2mSmallM);
            PolynomialGF2mSmallM polynomialGF2mSmallM2 = modPolynomialToFracton[0];
            PolynomialGF2mSmallM multiply = polynomialGF2mSmallM2.multiply(polynomialGF2mSmallM2);
            PolynomialGF2mSmallM polynomialGF2mSmallM3 = modPolynomialToFracton[1];
            PolynomialGF2mSmallM add = multiply.add(polynomialGF2mSmallM3.multiply(polynomialGF2mSmallM3).multWithMonomial(1));
            PolynomialGF2mSmallM multWithElement = add.multWithElement(gF2mField.inverse(add.getHeadCoefficient()));
            for (int i10 = 0; i10 < degree; i10++) {
                if (multWithElement.evaluateAt(i10) == 0) {
                    gF2Vector2.setBit(i10);
                }
            }
        }
        return gF2Vector2;
    }
}
