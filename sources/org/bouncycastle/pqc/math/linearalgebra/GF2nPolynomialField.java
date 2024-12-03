package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Vector;

public class GF2nPolynomialField extends GF2nField {
    private boolean isPentanomial = false;
    private boolean isTrinomial = false;

    /* renamed from: pc  reason: collision with root package name */
    private int[] f24069pc = new int[3];
    GF2Polynomial[] squaringMatrix;

    /* renamed from: tc  reason: collision with root package name */
    private int f24070tc;

    public GF2nPolynomialField(int i10, SecureRandom secureRandom) {
        super(secureRandom);
        if (i10 >= 3) {
            this.mDegree = i10;
            computeFieldPolynomial();
            computeSquaringMatrix();
            this.fields = new Vector();
            this.matrices = new Vector();
            return;
        }
        throw new IllegalArgumentException("k must be at least 3");
    }

    public GF2nPolynomialField(int i10, SecureRandom secureRandom, GF2Polynomial gF2Polynomial) throws RuntimeException {
        super(secureRandom);
        if (i10 < 3) {
            throw new IllegalArgumentException("degree must be at least 3");
        } else if (gF2Polynomial.getLength() != i10 + 1) {
            throw new RuntimeException();
        } else if (gF2Polynomial.isIrreducible()) {
            this.mDegree = i10;
            this.fieldPolynomial = gF2Polynomial;
            computeSquaringMatrix();
            int i11 = 2;
            for (int i12 = 1; i12 < this.fieldPolynomial.getLength() - 1; i12++) {
                if (this.fieldPolynomial.testBit(i12)) {
                    i11++;
                    if (i11 == 3) {
                        this.f24070tc = i12;
                    }
                    if (i11 <= 5) {
                        this.f24069pc[i11 - 3] = i12;
                    }
                }
            }
            if (i11 == 3) {
                this.isTrinomial = true;
            }
            if (i11 == 5) {
                this.isPentanomial = true;
            }
            this.fields = new Vector();
            this.matrices = new Vector();
        } else {
            throw new RuntimeException();
        }
    }

    public GF2nPolynomialField(int i10, SecureRandom secureRandom, boolean z10) {
        super(secureRandom);
        if (i10 >= 3) {
            this.mDegree = i10;
            if (z10) {
                computeFieldPolynomial();
            } else {
                computeFieldPolynomial2();
            }
            computeSquaringMatrix();
            this.fields = new Vector();
            this.matrices = new Vector();
            return;
        }
        throw new IllegalArgumentException("k must be at least 3");
    }

    private void computeSquaringMatrix() {
        int i10 = this.mDegree;
        GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[(i10 - 1)];
        this.squaringMatrix = new GF2Polynomial[i10];
        int i11 = 0;
        while (true) {
            GF2Polynomial[] gF2PolynomialArr2 = this.squaringMatrix;
            if (i11 >= gF2PolynomialArr2.length) {
                break;
            }
            gF2PolynomialArr2[i11] = new GF2Polynomial(this.mDegree, "ZERO");
            i11++;
        }
        for (int i12 = 0; i12 < this.mDegree - 1; i12++) {
            gF2PolynomialArr[i12] = new GF2Polynomial(1, "ONE").shiftLeft(this.mDegree + i12).remainder(this.fieldPolynomial);
        }
        for (int i13 = 1; i13 <= Math.abs(this.mDegree >> 1); i13++) {
            int i14 = 1;
            while (true) {
                int i15 = this.mDegree;
                if (i14 > i15) {
                    break;
                }
                if (gF2PolynomialArr[i15 - (i13 << 1)].testBit(i15 - i14)) {
                    this.squaringMatrix[i14 - 1].setBit(this.mDegree - i13);
                }
                i14++;
            }
        }
        int abs = Math.abs(this.mDegree >> 1) + 1;
        while (true) {
            int i16 = this.mDegree;
            if (abs <= i16) {
                this.squaringMatrix[((abs << 1) - i16) - 1].setBit(i16 - abs);
                abs++;
            } else {
                return;
            }
        }
    }

    private boolean testPentanomials() {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.mDegree + 1);
        this.fieldPolynomial = gF2Polynomial;
        gF2Polynomial.setBit(0);
        this.fieldPolynomial.setBit(this.mDegree);
        boolean z10 = false;
        int i10 = 1;
        while (i10 <= this.mDegree - 3 && !z10) {
            this.fieldPolynomial.setBit(i10);
            int i11 = i10 + 1;
            int i12 = i11;
            while (i12 <= this.mDegree - 2 && !z10) {
                this.fieldPolynomial.setBit(i12);
                int i13 = i12 + 1;
                int i14 = i13;
                while (i14 <= this.mDegree - 1 && !z10) {
                    this.fieldPolynomial.setBit(i14);
                    if ((!(((this.mDegree & 1) != 0) | ((i10 & 1) != 0) | ((i12 & 1) != 0)) && !((i14 & 1) != 0)) || !(z10 = this.fieldPolynomial.isIrreducible())) {
                        this.fieldPolynomial.resetBit(i14);
                        i14++;
                    } else {
                        this.isPentanomial = true;
                        int[] iArr = this.f24069pc;
                        iArr[0] = i10;
                        iArr[1] = i12;
                        iArr[2] = i14;
                        return z10;
                    }
                }
                this.fieldPolynomial.resetBit(i12);
                i12 = i13;
            }
            this.fieldPolynomial.resetBit(i10);
            i10 = i11;
        }
        return z10;
    }

    private boolean testRandom() {
        this.fieldPolynomial = new GF2Polynomial(this.mDegree + 1);
        do {
            this.fieldPolynomial.randomize();
            this.fieldPolynomial.setBit(this.mDegree);
            this.fieldPolynomial.setBit(0);
        } while (!this.fieldPolynomial.isIrreducible());
        return true;
    }

    private boolean testTrinomials() {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.mDegree + 1);
        this.fieldPolynomial = gF2Polynomial;
        boolean z10 = false;
        gF2Polynomial.setBit(0);
        this.fieldPolynomial.setBit(this.mDegree);
        for (int i10 = 1; i10 < this.mDegree && !z10; i10++) {
            this.fieldPolynomial.setBit(i10);
            boolean isIrreducible = this.fieldPolynomial.isIrreducible();
            if (isIrreducible) {
                this.isTrinomial = true;
                this.f24070tc = i10;
                return isIrreducible;
            }
            this.fieldPolynomial.resetBit(i10);
            z10 = this.fieldPolynomial.isIrreducible();
        }
        return z10;
    }

    /* access modifiers changed from: protected */
    public void computeCOBMatrix(GF2nField gF2nField) {
        GF2nElement randomRoot;
        GF2nElement[] gF2nElementArr;
        int i10 = this.mDegree;
        if (i10 == gF2nField.mDegree) {
            boolean z10 = gF2nField instanceof GF2nONBField;
            if (z10) {
                gF2nField.computeCOBMatrix(this);
                return;
            }
            GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[i10];
            for (int i11 = 0; i11 < this.mDegree; i11++) {
                gF2PolynomialArr[i11] = new GF2Polynomial(this.mDegree);
            }
            do {
                randomRoot = gF2nField.getRandomRoot(this.fieldPolynomial);
            } while (randomRoot.isZero());
            if (randomRoot instanceof GF2nONBElement) {
                int i12 = this.mDegree;
                gF2nElementArr = new GF2nONBElement[i12];
                gF2nElementArr[i12 - 1] = GF2nONBElement.ONE((GF2nONBField) gF2nField);
            } else {
                int i13 = this.mDegree;
                gF2nElementArr = new GF2nPolynomialElement[i13];
                gF2nElementArr[i13 - 1] = GF2nPolynomialElement.ONE((GF2nPolynomialField) gF2nField);
            }
            int i14 = this.mDegree;
            gF2nElementArr[i14 - 2] = randomRoot;
            for (int i15 = i14 - 3; i15 >= 0; i15--) {
                gF2nElementArr[i15] = (GF2nElement) gF2nElementArr[i15 + 1].multiply(randomRoot);
            }
            if (z10) {
                for (int i16 = 0; i16 < this.mDegree; i16++) {
                    int i17 = 0;
                    while (true) {
                        int i18 = this.mDegree;
                        if (i17 >= i18) {
                            break;
                        }
                        if (gF2nElementArr[i16].testBit((i18 - i17) - 1)) {
                            int i19 = this.mDegree;
                            gF2PolynomialArr[(i19 - i17) - 1].setBit((i19 - i16) - 1);
                        }
                        i17++;
                    }
                }
            } else {
                for (int i20 = 0; i20 < this.mDegree; i20++) {
                    for (int i21 = 0; i21 < this.mDegree; i21++) {
                        if (gF2nElementArr[i20].testBit(i21)) {
                            int i22 = this.mDegree;
                            gF2PolynomialArr[(i22 - i21) - 1].setBit((i22 - i20) - 1);
                        }
                    }
                }
            }
            this.fields.addElement(gF2nField);
            this.matrices.addElement(gF2PolynomialArr);
            gF2nField.fields.addElement(this);
            gF2nField.matrices.addElement(invertMatrix(gF2PolynomialArr));
            return;
        }
        throw new IllegalArgumentException("GF2nPolynomialField.computeCOBMatrix: B1 has a different degree and thus cannot be coverted to!");
    }

    /* access modifiers changed from: protected */
    public void computeFieldPolynomial() {
        if (!testTrinomials() && !testPentanomials()) {
            testRandom();
        }
    }

    /* access modifiers changed from: protected */
    public void computeFieldPolynomial2() {
        if (!testTrinomials() && !testPentanomials()) {
            testRandom();
        }
    }

    public int[] getPc() throws RuntimeException {
        if (this.isPentanomial) {
            int[] iArr = new int[3];
            System.arraycopy(this.f24069pc, 0, iArr, 0, 3);
            return iArr;
        }
        throw new RuntimeException();
    }

    /* access modifiers changed from: protected */
    public GF2nElement getRandomRoot(GF2Polynomial gF2Polynomial) {
        GF2nPolynomial gcd;
        int degree;
        int degree2;
        GF2nPolynomial gF2nPolynomial = new GF2nPolynomial(gF2Polynomial, (GF2nField) this);
        while (gF2nPolynomial.getDegree() > 1) {
            while (true) {
                GF2nPolynomialElement gF2nPolynomialElement = new GF2nPolynomialElement(this, (Random) this.random);
                GF2nPolynomial gF2nPolynomial2 = new GF2nPolynomial(2, (GF2nElement) GF2nPolynomialElement.ZERO(this));
                gF2nPolynomial2.set(1, gF2nPolynomialElement);
                GF2nPolynomial gF2nPolynomial3 = new GF2nPolynomial(gF2nPolynomial2);
                for (int i10 = 1; i10 <= this.mDegree - 1; i10++) {
                    gF2nPolynomial3 = gF2nPolynomial3.multiplyAndReduce(gF2nPolynomial3, gF2nPolynomial).add(gF2nPolynomial2);
                }
                gcd = gF2nPolynomial3.gcd(gF2nPolynomial);
                degree = gcd.getDegree();
                degree2 = gF2nPolynomial.getDegree();
                if (degree != 0 && degree != degree2) {
                    break;
                }
            }
            gF2nPolynomial = (degree << 1) > degree2 ? gF2nPolynomial.quotient(gcd) : new GF2nPolynomial(gcd);
        }
        return gF2nPolynomial.at(0);
    }

    public GF2Polynomial getSquaringVector(int i10) {
        return new GF2Polynomial(this.squaringMatrix[i10]);
    }

    public int getTc() throws RuntimeException {
        if (this.isTrinomial) {
            return this.f24070tc;
        }
        throw new RuntimeException();
    }

    public boolean isPentanomial() {
        return this.isPentanomial;
    }

    public boolean isTrinomial() {
        return this.isTrinomial;
    }
}
