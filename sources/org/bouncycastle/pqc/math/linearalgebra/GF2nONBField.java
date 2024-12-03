package org.bouncycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Vector;

public class GF2nONBField extends GF2nField {
    private static final int MAXLONG = 64;
    private int mBit;
    private int mLength;
    int[][] mMult;
    private int mType;

    public GF2nONBField(int i10, SecureRandom secureRandom) throws RuntimeException {
        super(secureRandom);
        if (i10 >= 3) {
            this.mDegree = i10;
            int i11 = i10 / 64;
            this.mLength = i11;
            int i12 = i10 & 63;
            this.mBit = i12;
            if (i12 == 0) {
                this.mBit = 64;
            } else {
                this.mLength = i11 + 1;
            }
            computeType();
            if (this.mType < 3) {
                int i13 = this.mDegree;
                int[] iArr = new int[2];
                iArr[1] = 2;
                iArr[0] = i13;
                this.mMult = (int[][]) Array.newInstance(Integer.TYPE, iArr);
                for (int i14 = 0; i14 < this.mDegree; i14++) {
                    int[] iArr2 = this.mMult[i14];
                    iArr2[0] = -1;
                    iArr2[1] = -1;
                }
                computeMultMatrix();
                computeFieldPolynomial();
                this.fields = new Vector();
                this.matrices = new Vector();
                return;
            }
            throw new RuntimeException("\nThe type of this field is " + this.mType);
        }
        throw new IllegalArgumentException("k must be at least 3");
    }

    private void computeMultMatrix() {
        int i10;
        int i11 = this.mType;
        if ((i11 & 7) != 0) {
            int i12 = (this.mDegree * i11) + 1;
            int[] iArr = new int[i12];
            int elementOfOrder = i11 == 1 ? 1 : i11 == 2 ? i12 - 1 : elementOfOrder(i11, i12);
            int i13 = 1;
            int i14 = 0;
            while (true) {
                i10 = this.mType;
                if (i14 >= i10) {
                    break;
                }
                int i15 = i13;
                for (int i16 = 0; i16 < this.mDegree; i16++) {
                    iArr[i15] = i16;
                    i15 = (i15 << 1) % i12;
                    if (i15 < 0) {
                        i15 += i12;
                    }
                }
                i13 = (i13 * elementOfOrder) % i12;
                if (i13 < 0) {
                    i13 += i12;
                }
                i14++;
            }
            if (i10 == 1) {
                int i17 = 1;
                while (i17 < i12 - 1) {
                    int i18 = i17 + 1;
                    int[] iArr2 = this.mMult[iArr[i18]];
                    int i19 = i12 - i17;
                    if (iArr2[0] == -1) {
                        iArr2[0] = iArr[i19];
                    } else {
                        iArr2[1] = iArr[i19];
                    }
                    i17 = i18;
                }
                int i20 = this.mDegree >> 1;
                for (int i21 = 1; i21 <= i20; i21++) {
                    int[][] iArr3 = this.mMult;
                    int i22 = i21 - 1;
                    int[] iArr4 = iArr3[i22];
                    if (iArr4[0] == -1) {
                        iArr4[0] = (i20 + i21) - 1;
                    } else {
                        iArr4[1] = (i20 + i21) - 1;
                    }
                    int[] iArr5 = iArr3[(i20 + i21) - 1];
                    if (iArr5[0] == -1) {
                        iArr5[0] = i22;
                    } else {
                        iArr5[1] = i22;
                    }
                }
            } else if (i10 == 2) {
                int i23 = 1;
                while (i23 < i12 - 1) {
                    int i24 = i23 + 1;
                    int[] iArr6 = this.mMult[iArr[i24]];
                    int i25 = i12 - i23;
                    if (iArr6[0] == -1) {
                        iArr6[0] = iArr[i25];
                    } else {
                        iArr6[1] = iArr[i25];
                    }
                    i23 = i24;
                }
            } else {
                throw new RuntimeException("only type 1 or type 2 implemented");
            }
        } else {
            throw new RuntimeException("bisher nur fuer Gausssche Normalbasen implementiert");
        }
    }

    private void computeType() throws RuntimeException {
        if ((this.mDegree & 7) != 0) {
            this.mType = 1;
            int i10 = 0;
            while (i10 != 1) {
                int i11 = (this.mType * this.mDegree) + 1;
                if (IntegerFunctions.isPrime(i11)) {
                    int order = IntegerFunctions.order(2, i11);
                    int i12 = this.mType;
                    int i13 = this.mDegree;
                    i10 = IntegerFunctions.gcd((i12 * i13) / order, i13);
                }
                this.mType++;
            }
            int i14 = this.mType - 1;
            this.mType = i14;
            if (i14 == 1) {
                int i15 = (this.mDegree << 1) + 1;
                if (IntegerFunctions.isPrime(i15)) {
                    int order2 = IntegerFunctions.order(2, i15);
                    int i16 = this.mDegree;
                    if (IntegerFunctions.gcd((i16 << 1) / order2, i16) == 1) {
                        this.mType++;
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new RuntimeException("The extension degree is divisible by 8!");
    }

    private int elementOfOrder(int i10, int i11) {
        int order;
        Random random = new Random();
        int i12 = 0;
        while (i12 == 0) {
            int i13 = i11 - 1;
            i12 = random.nextInt() % i13;
            if (i12 < 0) {
                i12 += i13;
            }
        }
        while (true) {
            order = IntegerFunctions.order(i12, i11);
            if (order % i10 == 0 && order != 0) {
                break;
            }
            while (i12 == 0) {
                int i14 = i11 - 1;
                int nextInt = random.nextInt() % i14;
                if (nextInt < 0) {
                    nextInt += i14;
                }
            }
        }
        int i15 = i12;
        for (int i16 = 2; i16 <= i10 / order; i16++) {
            i15 *= i12;
        }
        return i15;
    }

    /* access modifiers changed from: protected */
    public void computeCOBMatrix(GF2nField gF2nField) {
        GF2nElement randomRoot;
        int i10 = this.mDegree;
        if (i10 == gF2nField.mDegree) {
            GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[i10];
            for (int i11 = 0; i11 < this.mDegree; i11++) {
                gF2PolynomialArr[i11] = new GF2Polynomial(this.mDegree);
            }
            do {
                randomRoot = gF2nField.getRandomRoot(this.fieldPolynomial);
            } while (randomRoot.isZero());
            GF2nElement[] gF2nElementArr = new GF2nPolynomialElement[this.mDegree];
            gF2nElementArr[0] = (GF2nElement) randomRoot.clone();
            for (int i12 = 1; i12 < this.mDegree; i12++) {
                gF2nElementArr[i12] = gF2nElementArr[i12 - 1].square();
            }
            for (int i13 = 0; i13 < this.mDegree; i13++) {
                for (int i14 = 0; i14 < this.mDegree; i14++) {
                    if (gF2nElementArr[i13].testBit(i14)) {
                        int i15 = this.mDegree;
                        gF2PolynomialArr[(i15 - i14) - 1].setBit((i15 - i13) - 1);
                    }
                }
            }
            this.fields.addElement(gF2nField);
            this.matrices.addElement(gF2PolynomialArr);
            gF2nField.fields.addElement(this);
            gF2nField.matrices.addElement(invertMatrix(gF2PolynomialArr));
            return;
        }
        throw new IllegalArgumentException("GF2nField.computeCOBMatrix: B1 has a different degree and thus cannot be coverted to!");
    }

    /* access modifiers changed from: protected */
    public void computeFieldPolynomial() {
        GF2Polynomial gF2Polynomial;
        int i10 = this.mType;
        if (i10 == 1) {
            gF2Polynomial = new GF2Polynomial(this.mDegree + 1, "ALL");
        } else if (i10 == 2) {
            GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this.mDegree + 1, "ONE");
            GF2Polynomial gF2Polynomial3 = new GF2Polynomial(this.mDegree + 1, "X");
            gF2Polynomial3.addToThis(gF2Polynomial2);
            GF2Polynomial gF2Polynomial4 = gF2Polynomial2;
            gF2Polynomial = gF2Polynomial3;
            int i11 = 1;
            while (i11 < this.mDegree) {
                GF2Polynomial shiftLeft = gF2Polynomial.shiftLeft();
                shiftLeft.addToThis(gF2Polynomial4);
                i11++;
                gF2Polynomial4 = gF2Polynomial;
                gF2Polynomial = shiftLeft;
            }
        } else {
            return;
        }
        this.fieldPolynomial = gF2Polynomial;
    }

    /* access modifiers changed from: package-private */
    public int getONBBit() {
        return this.mBit;
    }

    /* access modifiers changed from: package-private */
    public int getONBLength() {
        return this.mLength;
    }

    /* access modifiers changed from: protected */
    public GF2nElement getRandomRoot(GF2Polynomial gF2Polynomial) {
        GF2nPolynomial gcd;
        int degree;
        int degree2;
        GF2nPolynomial gF2nPolynomial = new GF2nPolynomial(gF2Polynomial, (GF2nField) this);
        while (gF2nPolynomial.getDegree() > 1) {
            while (true) {
                GF2nONBElement gF2nONBElement = new GF2nONBElement(this, this.random);
                GF2nPolynomial gF2nPolynomial2 = new GF2nPolynomial(2, (GF2nElement) GF2nONBElement.ZERO(this));
                gF2nPolynomial2.set(1, gF2nONBElement);
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

    /* access modifiers changed from: package-private */
    public int[][] invMatrix(int[][] iArr) {
        int i10 = this.mDegree;
        int[] iArr2 = new int[2];
        iArr2[1] = i10;
        iArr2[0] = i10;
        Class cls = Integer.TYPE;
        int[][] iArr3 = (int[][]) Array.newInstance(cls, iArr2);
        int i11 = this.mDegree;
        int[] iArr4 = new int[2];
        iArr4[1] = i11;
        iArr4[0] = i11;
        int[][] iArr5 = (int[][]) Array.newInstance(cls, iArr4);
        for (int i12 = 0; i12 < this.mDegree; i12++) {
            iArr5[i12][i12] = 1;
        }
        for (int i13 = 0; i13 < this.mDegree; i13++) {
            int i14 = i13;
            while (true) {
                int i15 = this.mDegree;
                if (i14 >= i15) {
                    break;
                }
                iArr[(i15 - 1) - i13][i14] = iArr[i13][i13];
                i14++;
            }
        }
        return null;
    }
}
