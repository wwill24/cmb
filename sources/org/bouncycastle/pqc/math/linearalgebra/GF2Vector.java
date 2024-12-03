package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;
import org.bouncycastle.util.Arrays;

public class GF2Vector extends Vector {

    /* renamed from: v  reason: collision with root package name */
    private int[] f24068v;

    public GF2Vector(int i10) {
        if (i10 >= 0) {
            this.length = i10;
            this.f24068v = new int[((i10 + 31) >> 5)];
            return;
        }
        throw new ArithmeticException("Negative length.");
    }

    public GF2Vector(int i10, int i11, SecureRandom secureRandom) {
        if (i11 <= i10) {
            this.length = i10;
            this.f24068v = new int[((i10 + 31) >> 5)];
            int[] iArr = new int[i10];
            for (int i12 = 0; i12 < i10; i12++) {
                iArr[i12] = i12;
            }
            for (int i13 = 0; i13 < i11; i13++) {
                int nextInt = RandUtils.nextInt(secureRandom, i10);
                setBit(iArr[nextInt]);
                i10--;
                iArr[nextInt] = iArr[i10];
            }
            return;
        }
        throw new ArithmeticException("The hamming weight is greater than the length of vector.");
    }

    public GF2Vector(int i10, SecureRandom secureRandom) {
        this.length = i10;
        int i11 = (i10 + 31) >> 5;
        this.f24068v = new int[i11];
        int i12 = i11 - 1;
        for (int i13 = i12; i13 >= 0; i13--) {
            this.f24068v[i13] = secureRandom.nextInt();
        }
        int i14 = i10 & 31;
        if (i14 != 0) {
            int[] iArr = this.f24068v;
            iArr[i12] = ((1 << i14) - 1) & iArr[i12];
        }
    }

    public GF2Vector(int i10, int[] iArr) {
        if (i10 >= 0) {
            this.length = i10;
            int i11 = (i10 + 31) >> 5;
            if (iArr.length == i11) {
                int[] clone = IntUtils.clone(iArr);
                this.f24068v = clone;
                int i12 = i10 & 31;
                if (i12 != 0) {
                    int i13 = i11 - 1;
                    clone[i13] = ((1 << i12) - 1) & clone[i13];
                    return;
                }
                return;
            }
            throw new ArithmeticException("length mismatch");
        }
        throw new ArithmeticException("negative length");
    }

    public GF2Vector(GF2Vector gF2Vector) {
        this.length = gF2Vector.length;
        this.f24068v = IntUtils.clone(gF2Vector.f24068v);
    }

    protected GF2Vector(int[] iArr, int i10) {
        this.f24068v = iArr;
        this.length = i10;
    }

    public static GF2Vector OS2VP(int i10, byte[] bArr) {
        if (i10 >= 0) {
            if (bArr.length <= ((i10 + 7) >> 3)) {
                return new GF2Vector(i10, LittleEndianConversions.toIntArray(bArr));
            }
            throw new ArithmeticException("length mismatch");
        }
        throw new ArithmeticException("negative length");
    }

    public Vector add(Vector vector) {
        if (vector instanceof GF2Vector) {
            GF2Vector gF2Vector = (GF2Vector) vector;
            if (this.length == gF2Vector.length) {
                int[] clone = IntUtils.clone(gF2Vector.f24068v);
                for (int length = clone.length - 1; length >= 0; length--) {
                    clone[length] = clone[length] ^ this.f24068v[length];
                }
                return new GF2Vector(this.length, clone);
            }
            throw new ArithmeticException("length mismatch");
        }
        throw new ArithmeticException("vector is not defined over GF(2)");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GF2Vector)) {
            return false;
        }
        GF2Vector gF2Vector = (GF2Vector) obj;
        return this.length == gF2Vector.length && IntUtils.equals(this.f24068v, gF2Vector.f24068v);
    }

    public GF2Vector extractLeftVector(int i10) {
        int i11 = this.length;
        if (i10 > i11) {
            throw new ArithmeticException("invalid length");
        } else if (i10 == i11) {
            return new GF2Vector(this);
        } else {
            GF2Vector gF2Vector = new GF2Vector(i10);
            int i12 = i10 >> 5;
            int i13 = i10 & 31;
            System.arraycopy(this.f24068v, 0, gF2Vector.f24068v, 0, i12);
            if (i13 != 0) {
                gF2Vector.f24068v[i12] = ((1 << i13) - 1) & this.f24068v[i12];
            }
            return gF2Vector;
        }
    }

    public GF2Vector extractRightVector(int i10) {
        int i11;
        int i12 = this.length;
        if (i10 > i12) {
            throw new ArithmeticException("invalid length");
        } else if (i10 == i12) {
            return new GF2Vector(this);
        } else {
            GF2Vector gF2Vector = new GF2Vector(i10);
            int i13 = this.length;
            int i14 = (i13 - i10) >> 5;
            int i15 = (i13 - i10) & 31;
            int i16 = (i10 + 31) >> 5;
            int i17 = 0;
            if (i15 != 0) {
                while (true) {
                    i11 = i16 - 1;
                    if (i17 >= i11) {
                        break;
                    }
                    int[] iArr = gF2Vector.f24068v;
                    int[] iArr2 = this.f24068v;
                    int i18 = i14 + 1;
                    iArr[i17] = (iArr2[i14] >>> i15) | (iArr2[i18] << (32 - i15));
                    i17++;
                    i14 = i18;
                }
                int[] iArr3 = gF2Vector.f24068v;
                int[] iArr4 = this.f24068v;
                int i19 = i14 + 1;
                int i20 = iArr4[i14] >>> i15;
                iArr3[i11] = i20;
                if (i19 < iArr4.length) {
                    iArr3[i11] = (iArr4[i19] << (32 - i15)) | i20;
                }
            } else {
                System.arraycopy(this.f24068v, i14, gF2Vector.f24068v, 0, i16);
            }
            return gF2Vector;
        }
    }

    public GF2Vector extractVector(int[] iArr) {
        int length = iArr.length;
        if (iArr[length - 1] <= this.length) {
            GF2Vector gF2Vector = new GF2Vector(length);
            for (int i10 = 0; i10 < length; i10++) {
                int[] iArr2 = this.f24068v;
                int i11 = iArr[i10];
                if ((iArr2[i11 >> 5] & (1 << (i11 & 31))) != 0) {
                    int[] iArr3 = gF2Vector.f24068v;
                    int i12 = i10 >> 5;
                    iArr3[i12] = (1 << (i10 & 31)) | iArr3[i12];
                }
            }
            return gF2Vector;
        }
        throw new ArithmeticException("invalid index set");
    }

    public int getBit(int i10) {
        if (i10 < this.length) {
            int i11 = i10 >> 5;
            int i12 = i10 & 31;
            return (this.f24068v[i11] & (1 << i12)) >>> i12;
        }
        throw new IndexOutOfBoundsException();
    }

    public byte[] getEncoded() {
        return LittleEndianConversions.toByteArray(this.f24068v, (this.length + 7) >> 3);
    }

    public int getHammingWeight() {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int[] iArr = this.f24068v;
            if (i10 >= iArr.length) {
                return i11;
            }
            int i12 = iArr[i10];
            for (int i13 = 0; i13 < 32; i13++) {
                if ((i12 & 1) != 0) {
                    i11++;
                }
                i12 >>>= 1;
            }
            i10++;
        }
    }

    public int[] getVecArray() {
        return this.f24068v;
    }

    public int hashCode() {
        return (this.length * 31) + Arrays.hashCode(this.f24068v);
    }

    public boolean isZero() {
        for (int length = this.f24068v.length - 1; length >= 0; length--) {
            if (this.f24068v[length] != 0) {
                return false;
            }
        }
        return true;
    }

    public Vector multiply(Permutation permutation) {
        int[] vector = permutation.getVector();
        int i10 = this.length;
        if (i10 == vector.length) {
            GF2Vector gF2Vector = new GF2Vector(i10);
            for (int i11 = 0; i11 < vector.length; i11++) {
                int[] iArr = this.f24068v;
                int i12 = vector[i11];
                if ((iArr[i12 >> 5] & (1 << (i12 & 31))) != 0) {
                    int[] iArr2 = gF2Vector.f24068v;
                    int i13 = i11 >> 5;
                    iArr2[i13] = (1 << (i11 & 31)) | iArr2[i13];
                }
            }
            return gF2Vector;
        }
        throw new ArithmeticException("length mismatch");
    }

    public void setBit(int i10) {
        if (i10 < this.length) {
            int[] iArr = this.f24068v;
            int i11 = i10 >> 5;
            iArr[i11] = (1 << (i10 & 31)) | iArr[i11];
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public GF2mVector toExtensionFieldVector(GF2mField gF2mField) {
        int degree = gF2mField.getDegree();
        int i10 = this.length;
        if (i10 % degree == 0) {
            int i11 = i10 / degree;
            int[] iArr = new int[i11];
            int i12 = 0;
            for (int i13 = i11 - 1; i13 >= 0; i13--) {
                for (int degree2 = gF2mField.getDegree() - 1; degree2 >= 0; degree2--) {
                    if (((this.f24068v[i12 >>> 5] >>> (i12 & 31)) & 1) == 1) {
                        iArr[i13] = iArr[i13] ^ (1 << degree2);
                    }
                    i12++;
                }
            }
            return new GF2mVector(gF2mField, iArr);
        }
        throw new ArithmeticException("conversion is impossible");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < this.length; i10++) {
            if (i10 != 0 && (i10 & 31) == 0) {
                stringBuffer.append(' ');
            }
            stringBuffer.append((this.f24068v[i10 >> 5] & (1 << (i10 & 31))) == 0 ? '0' : '1');
        }
        return stringBuffer.toString();
    }
}
