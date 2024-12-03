package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

public class PolynomialGF2mSmallM {
    public static final char RANDOM_IRREDUCIBLE_POLYNOMIAL = 'I';
    private int[] coefficients;
    private int degree;
    private GF2mField field;

    public PolynomialGF2mSmallM(GF2mField gF2mField) {
        this.field = gF2mField;
        this.degree = -1;
        this.coefficients = new int[1];
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, int i10) {
        this.field = gF2mField;
        this.degree = i10;
        int[] iArr = new int[(i10 + 1)];
        this.coefficients = iArr;
        iArr[i10] = 1;
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, int i10, char c10, SecureRandom secureRandom) {
        this.field = gF2mField;
        if (c10 == 'I') {
            this.coefficients = createRandomIrreduciblePolynomial(i10, secureRandom);
            computeDegree();
            return;
        }
        throw new IllegalArgumentException(" Error: type " + c10 + " is not defined for GF2smallmPolynomial");
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, byte[] bArr) {
        this.field = gF2mField;
        int i10 = 8;
        int i11 = 1;
        while (gF2mField.getDegree() > i10) {
            i11++;
            i10 += 8;
        }
        if (bArr.length % i11 == 0) {
            this.coefficients = new int[(bArr.length / i11)];
            int i12 = 0;
            int i13 = 0;
            while (true) {
                int[] iArr = this.coefficients;
                if (i12 < iArr.length) {
                    int i14 = 0;
                    while (i14 < i10) {
                        int[] iArr2 = this.coefficients;
                        iArr2[i12] = ((bArr[i13] & 255) << i14) ^ iArr2[i12];
                        i14 += 8;
                        i13++;
                    }
                    if (this.field.isElementOfThisField(this.coefficients[i12])) {
                        i12++;
                    } else {
                        throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
                    }
                } else if (iArr.length == 1 || iArr[iArr.length - 1] != 0) {
                    computeDegree();
                    return;
                } else {
                    throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
                }
            }
        } else {
            throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
        }
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, int[] iArr) {
        this.field = gF2mField;
        this.coefficients = normalForm(iArr);
        computeDegree();
    }

    public PolynomialGF2mSmallM(GF2mVector gF2mVector) {
        this(gF2mVector.getField(), gF2mVector.getIntArrayForm());
    }

    public PolynomialGF2mSmallM(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        this.field = polynomialGF2mSmallM.field;
        this.degree = polynomialGF2mSmallM.degree;
        this.coefficients = IntUtils.clone(polynomialGF2mSmallM.coefficients);
    }

    private int[] add(int[] iArr, int[] iArr2) {
        int[] iArr3;
        if (iArr.length < iArr2.length) {
            iArr3 = new int[iArr2.length];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
        } else {
            iArr3 = new int[iArr.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            iArr = iArr2;
        }
        for (int length = iArr.length - 1; length >= 0; length--) {
            iArr3[length] = this.field.add(iArr3[length], iArr[length]);
        }
        return iArr3;
    }

    private static int computeDegree(int[] iArr) {
        int length = iArr.length - 1;
        while (length >= 0 && iArr[length] == 0) {
            length--;
        }
        return length;
    }

    private void computeDegree() {
        int length = this.coefficients.length;
        do {
            this.degree = length - 1;
            length = this.degree;
            if (length < 0 || this.coefficients[length] != 0) {
            }
            this.degree = length - 1;
            length = this.degree;
            return;
        } while (this.coefficients[length] != 0);
    }

    private int[] createRandomIrreduciblePolynomial(int i10, SecureRandom secureRandom) {
        int[] iArr = new int[(i10 + 1)];
        iArr[i10] = 1;
        iArr[0] = this.field.getRandomNonZeroElement(secureRandom);
        for (int i11 = 1; i11 < i10; i11++) {
            iArr[i11] = this.field.getRandomElement(secureRandom);
        }
        while (!isIrreducible(iArr)) {
            int nextInt = RandUtils.nextInt(secureRandom, i10);
            if (nextInt == 0) {
                iArr[0] = this.field.getRandomNonZeroElement(secureRandom);
            } else {
                iArr[nextInt] = this.field.getRandomElement(secureRandom);
            }
        }
        return iArr;
    }

    private int[][] div(int[] iArr, int[] iArr2) {
        int computeDegree = computeDegree(iArr2);
        int computeDegree2 = computeDegree(iArr) + 1;
        if (computeDegree != -1) {
            int[][] iArr3 = {new int[1], new int[computeDegree2]};
            int inverse = this.field.inverse(headCoefficient(iArr2));
            iArr3[0][0] = 0;
            int[] iArr4 = iArr3[1];
            System.arraycopy(iArr, 0, iArr4, 0, iArr4.length);
            while (computeDegree <= computeDegree(iArr3[1])) {
                int mult = this.field.mult(headCoefficient(iArr3[1]), inverse);
                int[] iArr5 = {mult};
                int[] multWithElement = multWithElement(iArr2, mult);
                int computeDegree3 = computeDegree(iArr3[1]) - computeDegree;
                int[] multWithMonomial = multWithMonomial(multWithElement, computeDegree3);
                iArr3[0] = add(multWithMonomial(iArr5, computeDegree3), iArr3[0]);
                iArr3[1] = add(multWithMonomial, iArr3[1]);
            }
            return iArr3;
        }
        throw new ArithmeticException("Division by zero.");
    }

    private int[] gcd(int[] iArr, int[] iArr2) {
        if (computeDegree(iArr) == -1) {
            return iArr2;
        }
        while (computeDegree(iArr2) != -1) {
            int[] mod = mod(iArr, iArr2);
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            System.arraycopy(iArr2, 0, iArr3, 0, length);
            int length2 = mod.length;
            int[] iArr4 = new int[length2];
            System.arraycopy(mod, 0, iArr4, 0, length2);
            iArr2 = iArr4;
            iArr = iArr3;
        }
        return multWithElement(iArr, this.field.inverse(headCoefficient(iArr)));
    }

    private static int headCoefficient(int[] iArr) {
        int computeDegree = computeDegree(iArr);
        if (computeDegree == -1) {
            return 0;
        }
        return iArr[computeDegree];
    }

    private static boolean isEqual(int[] iArr, int[] iArr2) {
        int computeDegree = computeDegree(iArr);
        if (computeDegree != computeDegree(iArr2)) {
            return false;
        }
        for (int i10 = 0; i10 <= computeDegree; i10++) {
            if (iArr[i10] != iArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    private boolean isIrreducible(int[] iArr) {
        if (iArr[0] == 0) {
            return false;
        }
        int computeDegree = computeDegree(iArr) >> 1;
        int[] iArr2 = {0, 1};
        int[] iArr3 = {0, 1};
        int degree2 = this.field.getDegree();
        for (int i10 = 0; i10 < computeDegree; i10++) {
            for (int i11 = degree2 - 1; i11 >= 0; i11--) {
                iArr2 = modMultiply(iArr2, iArr2, iArr);
            }
            iArr2 = normalForm(iArr2);
            if (computeDegree(gcd(add(iArr2, iArr3), iArr)) != 0) {
                return false;
            }
        }
        return true;
    }

    private int[] mod(int[] iArr, int[] iArr2) {
        int computeDegree = computeDegree(iArr2);
        if (computeDegree != -1) {
            int length = iArr.length;
            int[] iArr3 = new int[length];
            int inverse = this.field.inverse(headCoefficient(iArr2));
            System.arraycopy(iArr, 0, iArr3, 0, length);
            while (computeDegree <= computeDegree(iArr3)) {
                iArr3 = add(multWithElement(multWithMonomial(iArr2, computeDegree(iArr3) - computeDegree), this.field.mult(headCoefficient(iArr3), inverse)), iArr3);
            }
            return iArr3;
        }
        throw new ArithmeticException("Division by zero");
    }

    private int[] modDiv(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] normalForm = normalForm(iArr3);
        int[] mod = mod(iArr2, iArr3);
        int[] iArr4 = {0};
        int[] mod2 = mod(iArr, iArr3);
        while (computeDegree(mod) != -1) {
            int[][] div = div(normalForm, mod);
            int[] normalForm2 = normalForm(mod);
            int[] normalForm3 = normalForm(div[1]);
            int[] add = add(iArr4, modMultiply(div[0], mod2, iArr3));
            iArr4 = normalForm(mod2);
            mod2 = normalForm(add);
            normalForm = normalForm2;
            mod = normalForm3;
        }
        return multWithElement(iArr4, this.field.inverse(headCoefficient(normalForm)));
    }

    private int[] modMultiply(int[] iArr, int[] iArr2, int[] iArr3) {
        return mod(multiply(iArr, iArr2), iArr3);
    }

    private int[] multWithElement(int[] iArr, int i10) {
        int computeDegree = computeDegree(iArr);
        if (computeDegree == -1 || i10 == 0) {
            return new int[1];
        }
        if (i10 == 1) {
            return IntUtils.clone(iArr);
        }
        int[] iArr2 = new int[(computeDegree + 1)];
        while (computeDegree >= 0) {
            iArr2[computeDegree] = this.field.mult(iArr[computeDegree], i10);
            computeDegree--;
        }
        return iArr2;
    }

    private static int[] multWithMonomial(int[] iArr, int i10) {
        int computeDegree = computeDegree(iArr);
        if (computeDegree == -1) {
            return new int[1];
        }
        int[] iArr2 = new int[(computeDegree + i10 + 1)];
        System.arraycopy(iArr, 0, iArr2, i10, computeDegree + 1);
        return iArr2;
    }

    private int[] multiply(int[] iArr, int[] iArr2) {
        if (computeDegree(iArr) < computeDegree(iArr2)) {
            int[] iArr3 = iArr2;
            iArr2 = iArr;
            iArr = iArr3;
        }
        int[] normalForm = normalForm(iArr);
        int[] normalForm2 = normalForm(iArr2);
        if (normalForm2.length == 1) {
            return multWithElement(normalForm, normalForm2[0]);
        }
        int length = normalForm.length;
        int length2 = normalForm2.length;
        int[] iArr4 = new int[((length + length2) - 1)];
        if (length2 != length) {
            int[] iArr5 = new int[length2];
            int i10 = length - length2;
            int[] iArr6 = new int[i10];
            System.arraycopy(normalForm, 0, iArr5, 0, length2);
            System.arraycopy(normalForm, length2, iArr6, 0, i10);
            return add(multiply(iArr5, normalForm2), multWithMonomial(multiply(iArr6, normalForm2), length2));
        }
        int i11 = (length + 1) >>> 1;
        int i12 = length - i11;
        int[] iArr7 = new int[i11];
        int[] iArr8 = new int[i11];
        int[] iArr9 = new int[i12];
        int[] iArr10 = new int[i12];
        System.arraycopy(normalForm, 0, iArr7, 0, i11);
        System.arraycopy(normalForm, i11, iArr9, 0, i12);
        System.arraycopy(normalForm2, 0, iArr8, 0, i11);
        System.arraycopy(normalForm2, i11, iArr10, 0, i12);
        int[] add = add(iArr7, iArr9);
        int[] add2 = add(iArr8, iArr10);
        int[] multiply = multiply(iArr7, iArr8);
        int[] multiply2 = multiply(add, add2);
        int[] multiply3 = multiply(iArr9, iArr10);
        return add(multWithMonomial(add(add(add(multiply2, multiply), multiply3), multWithMonomial(multiply3, i11)), i11), multiply);
    }

    private static int[] normalForm(int[] iArr) {
        int computeDegree = computeDegree(iArr);
        if (computeDegree == -1) {
            return new int[1];
        }
        int i10 = computeDegree + 1;
        if (iArr.length == i10) {
            return IntUtils.clone(iArr);
        }
        int[] iArr2 = new int[i10];
        System.arraycopy(iArr, 0, iArr2, 0, i10);
        return iArr2;
    }

    public PolynomialGF2mSmallM add(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.field, add(this.coefficients, polynomialGF2mSmallM.coefficients));
    }

    public PolynomialGF2mSmallM addMonomial(int i10) {
        int[] iArr = new int[(i10 + 1)];
        iArr[i10] = 1;
        return new PolynomialGF2mSmallM(this.field, add(this.coefficients, iArr));
    }

    public void addToThis(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        this.coefficients = add(this.coefficients, polynomialGF2mSmallM.coefficients);
        computeDegree();
    }

    public PolynomialGF2mSmallM[] div(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        int[][] div = div(this.coefficients, polynomialGF2mSmallM.coefficients);
        return new PolynomialGF2mSmallM[]{new PolynomialGF2mSmallM(this.field, div[0]), new PolynomialGF2mSmallM(this.field, div[1])};
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof PolynomialGF2mSmallM)) {
            PolynomialGF2mSmallM polynomialGF2mSmallM = (PolynomialGF2mSmallM) obj;
            return this.field.equals(polynomialGF2mSmallM.field) && this.degree == polynomialGF2mSmallM.degree && isEqual(this.coefficients, polynomialGF2mSmallM.coefficients);
        }
    }

    public int evaluateAt(int i10) {
        int[] iArr = this.coefficients;
        int i11 = this.degree;
        int i12 = iArr[i11];
        for (int i13 = i11 - 1; i13 >= 0; i13--) {
            i12 = this.field.mult(i12, i10) ^ this.coefficients[i13];
        }
        return i12;
    }

    public PolynomialGF2mSmallM gcd(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.field, gcd(this.coefficients, polynomialGF2mSmallM.coefficients));
    }

    public int getCoefficient(int i10) {
        if (i10 < 0 || i10 > this.degree) {
            return 0;
        }
        return this.coefficients[i10];
    }

    public int getDegree() {
        int[] iArr = this.coefficients;
        int length = iArr.length - 1;
        if (iArr[length] == 0) {
            return -1;
        }
        return length;
    }

    public byte[] getEncoded() {
        int i10 = 8;
        int i11 = 1;
        while (this.field.getDegree() > i10) {
            i11++;
            i10 += 8;
        }
        byte[] bArr = new byte[(this.coefficients.length * i11)];
        int i12 = 0;
        for (int i13 = 0; i13 < this.coefficients.length; i13++) {
            int i14 = 0;
            while (i14 < i10) {
                bArr[i12] = (byte) (this.coefficients[i13] >>> i14);
                i14 += 8;
                i12++;
            }
        }
        return bArr;
    }

    public int getHeadCoefficient() {
        int i10 = this.degree;
        if (i10 == -1) {
            return 0;
        }
        return this.coefficients[i10];
    }

    public int hashCode() {
        int hashCode = this.field.hashCode();
        int i10 = 0;
        while (true) {
            int[] iArr = this.coefficients;
            if (i10 >= iArr.length) {
                return hashCode;
            }
            hashCode = (hashCode * 31) + iArr[i10];
            i10++;
        }
    }

    public PolynomialGF2mSmallM mod(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.field, mod(this.coefficients, polynomialGF2mSmallM.coefficients));
    }

    public PolynomialGF2mSmallM modDiv(PolynomialGF2mSmallM polynomialGF2mSmallM, PolynomialGF2mSmallM polynomialGF2mSmallM2) {
        return new PolynomialGF2mSmallM(this.field, modDiv(this.coefficients, polynomialGF2mSmallM.coefficients, polynomialGF2mSmallM2.coefficients));
    }

    public PolynomialGF2mSmallM modInverse(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.field, modDiv(new int[]{1}, this.coefficients, polynomialGF2mSmallM.coefficients));
    }

    public PolynomialGF2mSmallM modMultiply(PolynomialGF2mSmallM polynomialGF2mSmallM, PolynomialGF2mSmallM polynomialGF2mSmallM2) {
        return new PolynomialGF2mSmallM(this.field, modMultiply(this.coefficients, polynomialGF2mSmallM.coefficients, polynomialGF2mSmallM2.coefficients));
    }

    public PolynomialGF2mSmallM[] modPolynomialToFracton(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        int i10 = polynomialGF2mSmallM.degree >> 1;
        int[] normalForm = normalForm(polynomialGF2mSmallM.coefficients);
        int[] mod = mod(this.coefficients, polynomialGF2mSmallM.coefficients);
        int[] iArr = normalForm;
        int[] iArr2 = mod;
        int[] iArr3 = {1};
        int[] iArr4 = {0};
        int[] iArr5 = iArr3;
        while (computeDegree(iArr2) > i10) {
            int[][] div = div(iArr, iArr2);
            int[] iArr6 = div[1];
            int[] add = add(iArr4, modMultiply(div[0], iArr5, polynomialGF2mSmallM.coefficients));
            iArr4 = iArr5;
            iArr5 = add;
            iArr = iArr2;
            iArr2 = iArr6;
        }
        return new PolynomialGF2mSmallM[]{new PolynomialGF2mSmallM(this.field, iArr2), new PolynomialGF2mSmallM(this.field, iArr5)};
    }

    public PolynomialGF2mSmallM modSquareMatrix(PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        int length = polynomialGF2mSmallMArr.length;
        int[] iArr = new int[length];
        int[] iArr2 = new int[length];
        int i10 = 0;
        while (true) {
            int[] iArr3 = this.coefficients;
            if (i10 >= iArr3.length) {
                break;
            }
            GF2mField gF2mField = this.field;
            int i11 = iArr3[i10];
            iArr2[i10] = gF2mField.mult(i11, i11);
            i10++;
        }
        for (int i12 = 0; i12 < length; i12++) {
            for (int i13 = 0; i13 < length; i13++) {
                int[] iArr4 = polynomialGF2mSmallMArr[i13].coefficients;
                if (i12 < iArr4.length) {
                    iArr[i12] = this.field.add(iArr[i12], this.field.mult(iArr4[i12], iArr2[i13]));
                }
            }
        }
        return new PolynomialGF2mSmallM(this.field, iArr);
    }

    public PolynomialGF2mSmallM modSquareRoot(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        int[] clone = IntUtils.clone(this.coefficients);
        int[] modMultiply = modMultiply(clone, clone, polynomialGF2mSmallM.coefficients);
        while (!isEqual(modMultiply, this.coefficients)) {
            clone = normalForm(modMultiply);
            modMultiply = modMultiply(clone, clone, polynomialGF2mSmallM.coefficients);
        }
        return new PolynomialGF2mSmallM(this.field, clone);
    }

    public PolynomialGF2mSmallM modSquareRootMatrix(PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        int length = polynomialGF2mSmallMArr.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            for (int i11 = 0; i11 < length; i11++) {
                int[] iArr2 = polynomialGF2mSmallMArr[i11].coefficients;
                if (i10 < iArr2.length) {
                    int[] iArr3 = this.coefficients;
                    if (i11 < iArr3.length) {
                        iArr[i10] = this.field.add(iArr[i10], this.field.mult(iArr2[i10], iArr3[i11]));
                    }
                }
            }
        }
        for (int i12 = 0; i12 < length; i12++) {
            iArr[i12] = this.field.sqRoot(iArr[i12]);
        }
        return new PolynomialGF2mSmallM(this.field, iArr);
    }

    public void multThisWithElement(int i10) {
        if (this.field.isElementOfThisField(i10)) {
            this.coefficients = multWithElement(this.coefficients, i10);
            computeDegree();
            return;
        }
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    public PolynomialGF2mSmallM multWithElement(int i10) {
        if (this.field.isElementOfThisField(i10)) {
            return new PolynomialGF2mSmallM(this.field, multWithElement(this.coefficients, i10));
        }
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    public PolynomialGF2mSmallM multWithMonomial(int i10) {
        return new PolynomialGF2mSmallM(this.field, multWithMonomial(this.coefficients, i10));
    }

    public PolynomialGF2mSmallM multiply(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.field, multiply(this.coefficients, polynomialGF2mSmallM.coefficients));
    }

    public String toString() {
        String str = " Polynomial over " + this.field.toString() + ": \n";
        for (int i10 = 0; i10 < this.coefficients.length; i10++) {
            str = str + this.field.elementToStr(this.coefficients[i10]) + "Y^" + i10 + "+";
        }
        return str + ";";
    }
}
