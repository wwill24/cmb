package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;
import org.bouncycastle.util.Arrays;

public class Permutation {
    private int[] perm;

    public Permutation(int i10) {
        if (i10 > 0) {
            this.perm = new int[i10];
            for (int i11 = i10 - 1; i11 >= 0; i11--) {
                this.perm[i11] = i11;
            }
            return;
        }
        throw new IllegalArgumentException("invalid length");
    }

    public Permutation(int i10, SecureRandom secureRandom) {
        if (i10 > 0) {
            this.perm = new int[i10];
            int[] iArr = new int[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                iArr[i11] = i11;
            }
            int i12 = i10;
            for (int i13 = 0; i13 < i10; i13++) {
                int nextInt = RandUtils.nextInt(secureRandom, i12);
                i12--;
                this.perm[i13] = iArr[nextInt];
                iArr[nextInt] = iArr[i12];
            }
            return;
        }
        throw new IllegalArgumentException("invalid length");
    }

    public Permutation(byte[] bArr) {
        if (bArr.length > 4) {
            int OS2IP = LittleEndianConversions.OS2IP(bArr, 0);
            int ceilLog256 = IntegerFunctions.ceilLog256(OS2IP - 1);
            if (bArr.length == (OS2IP * ceilLog256) + 4) {
                this.perm = new int[OS2IP];
                for (int i10 = 0; i10 < OS2IP; i10++) {
                    this.perm[i10] = LittleEndianConversions.OS2IP(bArr, (i10 * ceilLog256) + 4, ceilLog256);
                }
                if (!isPermutation(this.perm)) {
                    throw new IllegalArgumentException("invalid encoding");
                }
                return;
            }
            throw new IllegalArgumentException("invalid encoding");
        }
        throw new IllegalArgumentException("invalid encoding");
    }

    public Permutation(int[] iArr) {
        if (isPermutation(iArr)) {
            this.perm = IntUtils.clone(iArr);
            return;
        }
        throw new IllegalArgumentException("array is not a permutation vector");
    }

    private boolean isPermutation(int[] iArr) {
        boolean[] zArr = new boolean[r0];
        for (int i10 : iArr) {
            if (i10 < 0 || i10 >= r0 || zArr[i10]) {
                return false;
            }
            zArr[i10] = true;
        }
        return true;
    }

    public Permutation computeInverse() {
        Permutation permutation = new Permutation(this.perm.length);
        for (int length = this.perm.length - 1; length >= 0; length--) {
            permutation.perm[this.perm[length]] = length;
        }
        return permutation;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Permutation)) {
            return false;
        }
        return IntUtils.equals(this.perm, ((Permutation) obj).perm);
    }

    public byte[] getEncoded() {
        int length = this.perm.length;
        int ceilLog256 = IntegerFunctions.ceilLog256(length - 1);
        byte[] bArr = new byte[((length * ceilLog256) + 4)];
        LittleEndianConversions.I2OSP(length, bArr, 0);
        for (int i10 = 0; i10 < length; i10++) {
            LittleEndianConversions.I2OSP(this.perm[i10], bArr, (i10 * ceilLog256) + 4, ceilLog256);
        }
        return bArr;
    }

    public int[] getVector() {
        return IntUtils.clone(this.perm);
    }

    public int hashCode() {
        return Arrays.hashCode(this.perm);
    }

    public Permutation rightMultiply(Permutation permutation) {
        int length = permutation.perm.length;
        int[] iArr = this.perm;
        if (length == iArr.length) {
            Permutation permutation2 = new Permutation(iArr.length);
            for (int length2 = this.perm.length - 1; length2 >= 0; length2--) {
                permutation2.perm[length2] = this.perm[permutation.perm[length2]];
            }
            return permutation2;
        }
        throw new IllegalArgumentException("length mismatch");
    }

    public String toString() {
        String str = "[" + this.perm[0];
        for (int i10 = 1; i10 < this.perm.length; i10++) {
            str = str + ", " + this.perm[i10];
        }
        return str + "]";
    }
}
