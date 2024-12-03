package org.bouncycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.util.Arrays;

public class GF2Matrix extends Matrix {
    private int length;
    private int[][] matrix;

    public GF2Matrix(int i10, char c10) {
        this(i10, c10, new SecureRandom());
    }

    public GF2Matrix(int i10, char c10, SecureRandom secureRandom) {
        if (i10 <= 0) {
            throw new ArithmeticException("Size of matrix is non-positive.");
        } else if (c10 == 'I') {
            assignUnitMatrix(i10);
        } else if (c10 == 'L') {
            assignRandomLowerTriangularMatrix(i10, secureRandom);
        } else if (c10 == 'R') {
            assignRandomRegularMatrix(i10, secureRandom);
        } else if (c10 == 'U') {
            assignRandomUpperTriangularMatrix(i10, secureRandom);
        } else if (c10 == 'Z') {
            assignZeroMatrix(i10, i10);
        } else {
            throw new ArithmeticException("Unknown matrix type.");
        }
    }

    private GF2Matrix(int i10, int i11) {
        if (i11 <= 0 || i10 <= 0) {
            throw new ArithmeticException("size of matrix is non-positive");
        }
        assignZeroMatrix(i10, i11);
    }

    public GF2Matrix(int i10, int[][] iArr) {
        int[] iArr2 = iArr[0];
        if (iArr2.length == ((i10 + 31) >> 5)) {
            this.numColumns = i10;
            this.numRows = iArr.length;
            this.length = iArr2.length;
            int i11 = i10 & 31;
            int i12 = i11 == 0 ? -1 : (1 << i11) - 1;
            for (int i13 = 0; i13 < this.numRows; i13++) {
                int[] iArr3 = iArr[i13];
                int i14 = this.length - 1;
                iArr3[i14] = iArr3[i14] & i12;
            }
            this.matrix = iArr;
            return;
        }
        throw new ArithmeticException("Int array does not match given number of columns.");
    }

    public GF2Matrix(GF2Matrix gF2Matrix) {
        this.numColumns = gF2Matrix.getNumColumns();
        this.numRows = gF2Matrix.getNumRows();
        this.length = gF2Matrix.length;
        this.matrix = new int[gF2Matrix.matrix.length][];
        int i10 = 0;
        while (true) {
            int[][] iArr = this.matrix;
            if (i10 < iArr.length) {
                iArr[i10] = IntUtils.clone(gF2Matrix.matrix[i10]);
                i10++;
            } else {
                return;
            }
        }
    }

    public GF2Matrix(byte[] bArr) {
        if (bArr.length >= 9) {
            this.numRows = LittleEndianConversions.OS2IP(bArr, 0);
            int OS2IP = LittleEndianConversions.OS2IP(bArr, 4);
            this.numColumns = OS2IP;
            int i10 = this.numRows;
            int i11 = ((OS2IP + 7) >>> 3) * i10;
            if (i10 > 0) {
                int i12 = 8;
                if (i11 == bArr.length - 8) {
                    int i13 = (OS2IP + 31) >>> 5;
                    this.length = i13;
                    int[] iArr = new int[2];
                    iArr[1] = i13;
                    iArr[0] = i10;
                    this.matrix = (int[][]) Array.newInstance(Integer.TYPE, iArr);
                    int i14 = this.numColumns;
                    int i15 = i14 >> 5;
                    int i16 = i14 & 31;
                    for (int i17 = 0; i17 < this.numRows; i17++) {
                        int i18 = 0;
                        while (i18 < i15) {
                            this.matrix[i17][i18] = LittleEndianConversions.OS2IP(bArr, i12);
                            i18++;
                            i12 += 4;
                        }
                        int i19 = 0;
                        while (i19 < i16) {
                            int[] iArr2 = this.matrix[i17];
                            iArr2[i15] = ((bArr[i12] & 255) << i19) ^ iArr2[i15];
                            i19 += 8;
                            i12++;
                        }
                    }
                    return;
                }
            }
            throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
        }
        throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    }

    private static void addToRow(int[] iArr, int[] iArr2, int i10) {
        for (int length2 = iArr2.length - 1; length2 >= i10; length2--) {
            iArr2[length2] = iArr[length2] ^ iArr2[length2];
        }
    }

    private void assignRandomLowerTriangularMatrix(int i10, SecureRandom secureRandom) {
        this.numRows = i10;
        this.numColumns = i10;
        int i11 = (i10 + 31) >>> 5;
        this.length = i11;
        int[] iArr = new int[2];
        iArr[1] = i11;
        iArr[0] = i10;
        this.matrix = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        for (int i12 = 0; i12 < this.numRows; i12++) {
            int i13 = i12 >>> 5;
            int i14 = i12 & 31;
            int i15 = 31 - i14;
            int i16 = 1 << i14;
            for (int i17 = 0; i17 < i13; i17++) {
                this.matrix[i12][i17] = secureRandom.nextInt();
            }
            this.matrix[i12][i13] = i16 | (secureRandom.nextInt() >>> i15);
            while (true) {
                i13++;
                if (i13 >= this.length) {
                    break;
                }
                this.matrix[i12][i13] = 0;
            }
        }
    }

    private void assignRandomRegularMatrix(int i10, SecureRandom secureRandom) {
        this.numRows = i10;
        this.numColumns = i10;
        int i11 = (i10 + 31) >>> 5;
        this.length = i11;
        int[] iArr = new int[2];
        iArr[1] = i11;
        iArr[0] = i10;
        this.matrix = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        GF2Matrix gF2Matrix = (GF2Matrix) new GF2Matrix(i10, Matrix.MATRIX_TYPE_RANDOM_LT, secureRandom).rightMultiply((Matrix) new GF2Matrix(i10, Matrix.MATRIX_TYPE_RANDOM_UT, secureRandom));
        int[] vector = new Permutation(i10, secureRandom).getVector();
        for (int i12 = 0; i12 < i10; i12++) {
            System.arraycopy(gF2Matrix.matrix[i12], 0, this.matrix[vector[i12]], 0, this.length);
        }
    }

    private void assignRandomUpperTriangularMatrix(int i10, SecureRandom secureRandom) {
        int i11;
        this.numRows = i10;
        this.numColumns = i10;
        int i12 = (i10 + 31) >>> 5;
        this.length = i12;
        int[] iArr = new int[2];
        iArr[1] = i12;
        iArr[0] = i10;
        this.matrix = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        int i13 = i10 & 31;
        int i14 = i13 == 0 ? -1 : (1 << i13) - 1;
        for (int i15 = 0; i15 < this.numRows; i15++) {
            int i16 = i15 >>> 5;
            int i17 = i15 & 31;
            int i18 = 1 << i17;
            for (int i19 = 0; i19 < i16; i19++) {
                this.matrix[i15][i19] = 0;
            }
            this.matrix[i15][i16] = (secureRandom.nextInt() << i17) | i18;
            while (true) {
                i16++;
                i11 = this.length;
                if (i16 >= i11) {
                    break;
                }
                this.matrix[i15][i16] = secureRandom.nextInt();
            }
            int[] iArr2 = this.matrix[i15];
            int i20 = i11 - 1;
            iArr2[i20] = iArr2[i20] & i14;
        }
    }

    private void assignUnitMatrix(int i10) {
        this.numRows = i10;
        this.numColumns = i10;
        int i11 = (i10 + 31) >>> 5;
        this.length = i11;
        int[] iArr = new int[2];
        iArr[1] = i11;
        iArr[0] = i10;
        this.matrix = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        for (int i12 = 0; i12 < this.numRows; i12++) {
            for (int i13 = 0; i13 < this.length; i13++) {
                this.matrix[i12][i13] = 0;
            }
        }
        for (int i14 = 0; i14 < this.numRows; i14++) {
            this.matrix[i14][i14 >>> 5] = 1 << (i14 & 31);
        }
    }

    private void assignZeroMatrix(int i10, int i11) {
        this.numRows = i10;
        this.numColumns = i11;
        int i12 = (i11 + 31) >>> 5;
        this.length = i12;
        int[] iArr = new int[2];
        iArr[1] = i12;
        iArr[0] = i10;
        this.matrix = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        for (int i13 = 0; i13 < this.numRows; i13++) {
            for (int i14 = 0; i14 < this.length; i14++) {
                this.matrix[i13][i14] = 0;
            }
        }
    }

    public static GF2Matrix[] createRandomRegularMatrixAndItsInverse(int i10, SecureRandom secureRandom) {
        int i11 = i10;
        SecureRandom secureRandom2 = secureRandom;
        GF2Matrix[] gF2MatrixArr = new GF2Matrix[2];
        int i12 = (i11 + 31) >> 5;
        GF2Matrix gF2Matrix = new GF2Matrix(i11, Matrix.MATRIX_TYPE_RANDOM_LT, secureRandom2);
        GF2Matrix gF2Matrix2 = new GF2Matrix(i11, Matrix.MATRIX_TYPE_RANDOM_UT, secureRandom2);
        GF2Matrix gF2Matrix3 = (GF2Matrix) gF2Matrix.rightMultiply((Matrix) gF2Matrix2);
        Permutation permutation = new Permutation(i11, secureRandom2);
        int[] vector = permutation.getVector();
        int[] iArr = new int[2];
        iArr[1] = i12;
        int i13 = 0;
        iArr[0] = i11;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        for (int i14 = 0; i14 < i11; i14++) {
            System.arraycopy(gF2Matrix3.matrix[vector[i14]], 0, iArr2[i14], 0, i12);
        }
        gF2MatrixArr[0] = new GF2Matrix(i11, iArr2);
        GF2Matrix gF2Matrix4 = new GF2Matrix(i11, 'I');
        int i15 = 0;
        while (i15 < i11) {
            int i16 = i15 >>> 5;
            int i17 = 1 << (i15 & 31);
            int i18 = i15 + 1;
            int i19 = i18;
            while (i19 < i11) {
                if ((gF2Matrix.matrix[i19][i16] & i17) != 0) {
                    for (int i20 = i13; i20 <= i16; i20++) {
                        int[][] iArr3 = gF2Matrix4.matrix;
                        int[] iArr4 = iArr3[i19];
                        iArr4[i20] = iArr4[i20] ^ iArr3[i15][i20];
                    }
                }
                i19++;
                i13 = 0;
            }
            i15 = i18;
        }
        GF2Matrix gF2Matrix5 = new GF2Matrix(i11, 'I');
        for (int i21 = i11 - 1; i21 >= 0; i21--) {
            int i22 = i21 >>> 5;
            int i23 = 1 << (i21 & 31);
            for (int i24 = i21 - 1; i24 >= 0; i24--) {
                if ((gF2Matrix2.matrix[i24][i22] & i23) != 0) {
                    for (int i25 = i22; i25 < i12; i25++) {
                        int[][] iArr5 = gF2Matrix5.matrix;
                        int[] iArr6 = iArr5[i24];
                        iArr6[i25] = iArr5[i21][i25] ^ iArr6[i25];
                    }
                }
            }
        }
        gF2MatrixArr[1] = (GF2Matrix) gF2Matrix5.rightMultiply(gF2Matrix4.rightMultiply(permutation));
        return gF2MatrixArr;
    }

    private static void swapRows(int[][] iArr, int i10, int i11) {
        int[] iArr2 = iArr[i10];
        iArr[i10] = iArr[i11];
        iArr[i11] = iArr2;
    }

    public Matrix computeInverse() {
        int i10 = this.numRows;
        if (i10 == this.numColumns) {
            int[] iArr = new int[2];
            iArr[1] = this.length;
            iArr[0] = i10;
            int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
            for (int i11 = this.numRows - 1; i11 >= 0; i11--) {
                iArr2[i11] = IntUtils.clone(this.matrix[i11]);
            }
            int i12 = this.numRows;
            int[] iArr3 = new int[2];
            iArr3[1] = this.length;
            iArr3[0] = i12;
            int[][] iArr4 = (int[][]) Array.newInstance(Integer.TYPE, iArr3);
            for (int i13 = this.numRows - 1; i13 >= 0; i13--) {
                iArr4[i13][i13 >> 5] = 1 << (i13 & 31);
            }
            for (int i14 = 0; i14 < this.numRows; i14++) {
                int i15 = i14 >> 5;
                int i16 = 1 << (i14 & 31);
                if ((iArr2[i14][i15] & i16) == 0) {
                    int i17 = i14 + 1;
                    boolean z10 = false;
                    while (i17 < this.numRows) {
                        if ((iArr2[i17][i15] & i16) != 0) {
                            swapRows(iArr2, i14, i17);
                            swapRows(iArr4, i14, i17);
                            i17 = this.numRows;
                            z10 = true;
                        }
                        i17++;
                    }
                    if (!z10) {
                        throw new ArithmeticException("Matrix is not invertible.");
                    }
                }
                for (int i18 = this.numRows - 1; i18 >= 0; i18--) {
                    if (i18 != i14) {
                        int[] iArr5 = iArr2[i18];
                        if ((iArr5[i15] & i16) != 0) {
                            addToRow(iArr2[i14], iArr5, i15);
                            addToRow(iArr4[i14], iArr4[i18], 0);
                        }
                    }
                }
            }
            return new GF2Matrix(this.numColumns, iArr4);
        }
        throw new ArithmeticException("Matrix is not invertible.");
    }

    public Matrix computeTranspose() {
        int i10 = this.numColumns;
        int[] iArr = new int[2];
        iArr[1] = (this.numRows + 31) >>> 5;
        iArr[0] = i10;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        int i11 = 0;
        while (true) {
            int i12 = this.numRows;
            if (i11 >= i12) {
                return new GF2Matrix(i12, iArr2);
            }
            for (int i13 = 0; i13 < this.numColumns; i13++) {
                int i14 = i11 >>> 5;
                int i15 = i11 & 31;
                if (((this.matrix[i11][i13 >>> 5] >>> (i13 & 31)) & 1) == 1) {
                    int[] iArr3 = iArr2[i13];
                    iArr3[i14] = (1 << i15) | iArr3[i14];
                }
            }
            i11++;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GF2Matrix)) {
            return false;
        }
        GF2Matrix gF2Matrix = (GF2Matrix) obj;
        if (this.numRows != gF2Matrix.numRows || this.numColumns != gF2Matrix.numColumns || this.length != gF2Matrix.length) {
            return false;
        }
        for (int i10 = 0; i10 < this.numRows; i10++) {
            if (!IntUtils.equals(this.matrix[i10], gF2Matrix.matrix[i10])) {
                return false;
            }
        }
        return true;
    }

    public GF2Matrix extendLeftCompactForm() {
        int i10 = this.numColumns;
        int i11 = this.numRows;
        GF2Matrix gF2Matrix = new GF2Matrix(i11, i10 + i11);
        int i12 = this.numRows;
        int i13 = (i12 - 1) + this.numColumns;
        int i14 = i12 - 1;
        while (i14 >= 0) {
            System.arraycopy(this.matrix[i14], 0, gF2Matrix.matrix[i14], 0, this.length);
            int[] iArr = gF2Matrix.matrix[i14];
            int i15 = i13 >> 5;
            iArr[i15] = iArr[i15] | (1 << (i13 & 31));
            i14--;
            i13--;
        }
        return gF2Matrix;
    }

    public GF2Matrix extendRightCompactForm() {
        int i10;
        int i11 = this.numRows;
        GF2Matrix gF2Matrix = new GF2Matrix(i11, this.numColumns + i11);
        int i12 = this.numRows;
        int i13 = i12 >> 5;
        int i14 = i12 & 31;
        for (int i15 = i12 - 1; i15 >= 0; i15--) {
            int[] iArr = gF2Matrix.matrix[i15];
            int i16 = i15 >> 5;
            iArr[i16] = iArr[i16] | (1 << (i15 & 31));
            int i17 = 0;
            if (i14 != 0) {
                int i18 = i13;
                while (true) {
                    i10 = this.length;
                    if (i17 >= i10 - 1) {
                        break;
                    }
                    int i19 = this.matrix[i15][i17];
                    int[] iArr2 = gF2Matrix.matrix[i15];
                    int i20 = i18 + 1;
                    iArr2[i18] = iArr2[i18] | (i19 << i14);
                    iArr2[i20] = iArr2[i20] | (i19 >>> (32 - i14));
                    i17++;
                    i18 = i20;
                }
                int i21 = this.matrix[i15][i10 - 1];
                int[] iArr3 = gF2Matrix.matrix[i15];
                int i22 = i18 + 1;
                iArr3[i18] = iArr3[i18] | (i21 << i14);
                if (i22 < gF2Matrix.length) {
                    iArr3[i22] = iArr3[i22] | (i21 >>> (32 - i14));
                }
            } else {
                System.arraycopy(this.matrix[i15], 0, iArr, i13, this.length);
            }
        }
        return gF2Matrix;
    }

    public byte[] getEncoded() {
        int i10 = this.numRows;
        int i11 = 8;
        byte[] bArr = new byte[((((this.numColumns + 7) >>> 3) * i10) + 8)];
        LittleEndianConversions.I2OSP(i10, bArr, 0);
        LittleEndianConversions.I2OSP(this.numColumns, bArr, 4);
        int i12 = this.numColumns;
        int i13 = i12 >>> 5;
        int i14 = i12 & 31;
        for (int i15 = 0; i15 < this.numRows; i15++) {
            int i16 = 0;
            while (i16 < i13) {
                LittleEndianConversions.I2OSP(this.matrix[i15][i16], bArr, i11);
                i16++;
                i11 += 4;
            }
            int i17 = 0;
            while (i17 < i14) {
                bArr[i11] = (byte) ((this.matrix[i15][i13] >>> i17) & 255);
                i17 += 8;
                i11++;
            }
        }
        return bArr;
    }

    public double getHammingWeight() {
        int i10 = this.numColumns & 31;
        int i11 = this.length;
        if (i10 != 0) {
            i11--;
        }
        double d10 = 0.0d;
        double d11 = 0.0d;
        for (int i12 = 0; i12 < this.numRows; i12++) {
            for (int i13 = 0; i13 < i11; i13++) {
                int i14 = this.matrix[i12][i13];
                for (int i15 = 0; i15 < 32; i15++) {
                    d10 += (double) ((i14 >>> i15) & 1);
                    d11 += 1.0d;
                }
            }
            int i16 = this.matrix[i12][this.length - 1];
            for (int i17 = 0; i17 < i10; i17++) {
                d10 += (double) ((i16 >>> i17) & 1);
                d11 += 1.0d;
            }
        }
        return d10 / d11;
    }

    public int[][] getIntArray() {
        return this.matrix;
    }

    public GF2Matrix getLeftSubMatrix() {
        int i10 = this.numColumns;
        int i11 = this.numRows;
        if (i10 > i11) {
            int i12 = (i11 + 31) >> 5;
            int[] iArr = new int[2];
            iArr[1] = i12;
            iArr[0] = i11;
            int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
            int i13 = this.numRows;
            int i14 = (1 << (i13 & 31)) - 1;
            if (i14 == 0) {
                i14 = -1;
            }
            for (int i15 = i13 - 1; i15 >= 0; i15--) {
                System.arraycopy(this.matrix[i15], 0, iArr2[i15], 0, i12);
                int[] iArr3 = iArr2[i15];
                int i16 = i12 - 1;
                iArr3[i16] = iArr3[i16] & i14;
            }
            return new GF2Matrix(this.numRows, iArr2);
        }
        throw new ArithmeticException("empty submatrix");
    }

    public int getLength() {
        return this.length;
    }

    public GF2Matrix getRightSubMatrix() {
        int i10;
        int i11 = this.numColumns;
        int i12 = this.numRows;
        if (i11 > i12) {
            int i13 = i12 >> 5;
            int i14 = i12 & 31;
            GF2Matrix gF2Matrix = new GF2Matrix(i12, i11 - i12);
            for (int i15 = this.numRows - 1; i15 >= 0; i15--) {
                int i16 = 0;
                if (i14 != 0) {
                    int i17 = i13;
                    while (true) {
                        i10 = gF2Matrix.length;
                        if (i16 >= i10 - 1) {
                            break;
                        }
                        int[] iArr = gF2Matrix.matrix[i15];
                        int[] iArr2 = this.matrix[i15];
                        int i18 = i17 + 1;
                        iArr[i16] = (iArr2[i17] >>> i14) | (iArr2[i18] << (32 - i14));
                        i16++;
                        i17 = i18;
                    }
                    int[] iArr3 = gF2Matrix.matrix[i15];
                    int[] iArr4 = this.matrix[i15];
                    int i19 = i17 + 1;
                    iArr3[i10 - 1] = iArr4[i17] >>> i14;
                    if (i19 < this.length) {
                        int i20 = i10 - 1;
                        iArr3[i20] = iArr3[i20] | (iArr4[i19] << (32 - i14));
                    }
                } else {
                    System.arraycopy(this.matrix[i15], i13, gF2Matrix.matrix[i15], 0, gF2Matrix.length);
                }
            }
            return gF2Matrix;
        }
        throw new ArithmeticException("empty submatrix");
    }

    public int[] getRow(int i10) {
        return this.matrix[i10];
    }

    public int hashCode() {
        int i10 = (((this.numRows * 31) + this.numColumns) * 31) + this.length;
        for (int i11 = 0; i11 < this.numRows; i11++) {
            i10 = (i10 * 31) + Arrays.hashCode(this.matrix[i11]);
        }
        return i10;
    }

    public boolean isZero() {
        for (int i10 = 0; i10 < this.numRows; i10++) {
            for (int i11 = 0; i11 < this.length; i11++) {
                if (this.matrix[i10][i11] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public Matrix leftMultiply(Permutation permutation) {
        int[] vector = permutation.getVector();
        int length2 = vector.length;
        int i10 = this.numRows;
        if (length2 == i10) {
            int[][] iArr = new int[i10][];
            for (int i11 = i10 - 1; i11 >= 0; i11--) {
                iArr[i11] = IntUtils.clone(this.matrix[vector[i11]]);
            }
            return new GF2Matrix(this.numRows, iArr);
        }
        throw new ArithmeticException("length mismatch");
    }

    public Vector leftMultiply(Vector vector) {
        if (!(vector instanceof GF2Vector)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        } else if (vector.length == this.numRows) {
            int[] vecArray = ((GF2Vector) vector).getVecArray();
            int[] iArr = new int[this.length];
            int i10 = this.numRows;
            int i11 = i10 >> 5;
            int i12 = 1 << (i10 & 31);
            int i13 = 0;
            for (int i14 = 0; i14 < i11; i14++) {
                int i15 = 1;
                do {
                    if ((vecArray[i14] & i15) != 0) {
                        for (int i16 = 0; i16 < this.length; i16++) {
                            iArr[i16] = iArr[i16] ^ this.matrix[i13][i16];
                        }
                    }
                    i13++;
                    i15 <<= 1;
                } while (i15 != 0);
            }
            for (int i17 = 1; i17 != i12; i17 <<= 1) {
                if ((vecArray[i11] & i17) != 0) {
                    for (int i18 = 0; i18 < this.length; i18++) {
                        iArr[i18] = iArr[i18] ^ this.matrix[i13][i18];
                    }
                }
                i13++;
            }
            return new GF2Vector(iArr, this.numColumns);
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    public Vector leftMultiplyLeftCompactForm(Vector vector) {
        if (!(vector instanceof GF2Vector)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        } else if (vector.length == this.numRows) {
            int[] vecArray = ((GF2Vector) vector).getVecArray();
            int i10 = this.numRows;
            int[] iArr = new int[(((this.numColumns + i10) + 31) >>> 5)];
            int i11 = i10 >>> 5;
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                int i14 = 1;
                do {
                    if ((vecArray[i13] & i14) != 0) {
                        for (int i15 = 0; i15 < this.length; i15++) {
                            iArr[i15] = iArr[i15] ^ this.matrix[i12][i15];
                        }
                        int i16 = this.numColumns;
                        int i17 = (i16 + i12) >>> 5;
                        iArr[i17] = (1 << ((i16 + i12) & 31)) | iArr[i17];
                    }
                    i12++;
                    i14 <<= 1;
                } while (i14 != 0);
            }
            int i18 = 1 << (this.numRows & 31);
            for (int i19 = 1; i19 != i18; i19 <<= 1) {
                if ((vecArray[i11] & i19) != 0) {
                    for (int i20 = 0; i20 < this.length; i20++) {
                        iArr[i20] = iArr[i20] ^ this.matrix[i12][i20];
                    }
                    int i21 = this.numColumns;
                    int i22 = (i21 + i12) >>> 5;
                    iArr[i22] = (1 << ((i21 + i12) & 31)) | iArr[i22];
                }
                i12++;
            }
            return new GF2Vector(iArr, this.numRows + this.numColumns);
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    public Matrix rightMultiply(Matrix matrix2) {
        if (!(matrix2 instanceof GF2Matrix)) {
            throw new ArithmeticException("matrix is not defined over GF(2)");
        } else if (matrix2.numRows == this.numColumns) {
            GF2Matrix gF2Matrix = (GF2Matrix) matrix2;
            GF2Matrix gF2Matrix2 = new GF2Matrix(this.numRows, matrix2.numColumns);
            int i10 = this.numColumns & 31;
            int i11 = this.length;
            if (i10 != 0) {
                i11--;
            }
            for (int i12 = 0; i12 < this.numRows; i12++) {
                int i13 = 0;
                for (int i14 = 0; i14 < i11; i14++) {
                    int i15 = this.matrix[i12][i14];
                    for (int i16 = 0; i16 < 32; i16++) {
                        if (((1 << i16) & i15) != 0) {
                            for (int i17 = 0; i17 < gF2Matrix.length; i17++) {
                                int[] iArr = gF2Matrix2.matrix[i12];
                                iArr[i17] = iArr[i17] ^ gF2Matrix.matrix[i13][i17];
                            }
                        }
                        i13++;
                    }
                }
                int i18 = this.matrix[i12][this.length - 1];
                for (int i19 = 0; i19 < i10; i19++) {
                    if (((1 << i19) & i18) != 0) {
                        for (int i20 = 0; i20 < gF2Matrix.length; i20++) {
                            int[] iArr2 = gF2Matrix2.matrix[i12];
                            iArr2[i20] = iArr2[i20] ^ gF2Matrix.matrix[i13][i20];
                        }
                    }
                    i13++;
                }
            }
            return gF2Matrix2;
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    public Matrix rightMultiply(Permutation permutation) {
        int[] vector = permutation.getVector();
        int length2 = vector.length;
        int i10 = this.numColumns;
        if (length2 == i10) {
            GF2Matrix gF2Matrix = new GF2Matrix(this.numRows, i10);
            for (int i11 = this.numColumns - 1; i11 >= 0; i11--) {
                int i12 = i11 >>> 5;
                int i13 = i11 & 31;
                int i14 = vector[i11];
                int i15 = i14 >>> 5;
                int i16 = i14 & 31;
                for (int i17 = this.numRows - 1; i17 >= 0; i17--) {
                    int[] iArr = gF2Matrix.matrix[i17];
                    iArr[i12] = iArr[i12] | (((this.matrix[i17][i15] >>> i16) & 1) << i13);
                }
            }
            return gF2Matrix;
        }
        throw new ArithmeticException("length mismatch");
    }

    public Vector rightMultiply(Vector vector) {
        if (!(vector instanceof GF2Vector)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        } else if (vector.length == this.numColumns) {
            int[] vecArray = ((GF2Vector) vector).getVecArray();
            int[] iArr = new int[((this.numRows + 31) >>> 5)];
            int i10 = 0;
            while (true) {
                int i11 = this.numRows;
                if (i10 >= i11) {
                    return new GF2Vector(iArr, i11);
                }
                int i12 = 0;
                for (int i13 = 0; i13 < this.length; i13++) {
                    i12 ^= this.matrix[i10][i13] & vecArray[i13];
                }
                int i14 = 0;
                for (int i15 = 0; i15 < 32; i15++) {
                    i14 ^= (i12 >>> i15) & 1;
                }
                if (i14 == 1) {
                    int i16 = i10 >>> 5;
                    iArr[i16] = iArr[i16] | (1 << (i10 & 31));
                }
                i10++;
            }
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    public Vector rightMultiplyRightCompactForm(Vector vector) {
        int i10;
        if (!(vector instanceof GF2Vector)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        } else if (vector.length == this.numColumns + this.numRows) {
            int[] vecArray = ((GF2Vector) vector).getVecArray();
            int i11 = this.numRows;
            int[] iArr = new int[((i11 + 31) >>> 5)];
            int i12 = i11 >> 5;
            int i13 = i11 & 31;
            int i14 = 0;
            while (true) {
                int i15 = this.numRows;
                if (i14 >= i15) {
                    return new GF2Vector(iArr, i15);
                }
                int i16 = i14 >> 5;
                int i17 = i14 & 31;
                int i18 = (vecArray[i16] >>> i17) & 1;
                int i19 = i12;
                int i20 = 0;
                if (i13 != 0) {
                    while (true) {
                        i10 = this.length;
                        if (i20 >= i10 - 1) {
                            break;
                        }
                        int i21 = i19 + 1;
                        i18 ^= ((vecArray[i19] >>> i13) | (vecArray[i21] << (32 - i13))) & this.matrix[i14][i20];
                        i20++;
                        i19 = i21;
                    }
                    int i22 = i19 + 1;
                    int i23 = vecArray[i19] >>> i13;
                    if (i22 < vecArray.length) {
                        i23 |= vecArray[i22] << (32 - i13);
                    }
                    i18 ^= this.matrix[i14][i10 - 1] & i23;
                } else {
                    while (i20 < this.length) {
                        i18 ^= vecArray[i19] & this.matrix[i14][i20];
                        i20++;
                        i19++;
                    }
                }
                int i24 = 0;
                for (int i25 = 0; i25 < 32; i25++) {
                    i24 ^= i18 & 1;
                    i18 >>>= 1;
                }
                if (i24 == 1) {
                    iArr[i16] = iArr[i16] | (1 << i17);
                }
                i14++;
            }
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    public String toString() {
        int i10 = this.numColumns & 31;
        int i11 = this.length;
        if (i10 != 0) {
            i11--;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i12 = 0; i12 < this.numRows; i12++) {
            stringBuffer.append(i12 + ": ");
            for (int i13 = 0; i13 < i11; i13++) {
                int i14 = this.matrix[i12][i13];
                for (int i15 = 0; i15 < 32; i15++) {
                    if (((i14 >>> i15) & 1) == 0) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append('1');
                    }
                }
                stringBuffer.append(' ');
            }
            int i16 = this.matrix[i12][this.length - 1];
            for (int i17 = 0; i17 < i10; i17++) {
                if (((i16 >>> i17) & 1) == 0) {
                    stringBuffer.append('0');
                } else {
                    stringBuffer.append('1');
                }
            }
            stringBuffer.append(10);
        }
        return stringBuffer.toString();
    }
}
