package jh;

import java.util.Arrays;

public final class a implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f23576c = new int[0];

    /* renamed from: a  reason: collision with root package name */
    private int[] f23577a;

    /* renamed from: b  reason: collision with root package name */
    private int f23578b;

    public a() {
        this.f23578b = 0;
        this.f23577a = f23576c;
    }

    private void e(int i10) {
        if (i10 > this.f23577a.length * 32) {
            int[] k10 = k((int) Math.ceil((double) (((float) i10) / 0.75f)));
            int[] iArr = this.f23577a;
            System.arraycopy(iArr, 0, k10, 0, iArr.length);
            this.f23577a = k10;
        }
    }

    private static int[] k(int i10) {
        return new int[((i10 + 31) / 32)];
    }

    public void a(boolean z10) {
        e(this.f23578b + 1);
        if (z10) {
            int[] iArr = this.f23577a;
            int i10 = this.f23578b;
            int i11 = i10 / 32;
            iArr[i11] = (1 << (i10 & 31)) | iArr[i11];
        }
        this.f23578b++;
    }

    public void b(a aVar) {
        int i10 = aVar.f23578b;
        e(this.f23578b + i10);
        for (int i11 = 0; i11 < i10; i11++) {
            a(aVar.h(i11));
        }
    }

    public void c(int i10, int i11) {
        if (i11 < 0 || i11 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        int i12 = this.f23578b;
        e(i12 + i11);
        for (int i13 = i11 - 1; i13 >= 0; i13--) {
            if (((1 << i13) & i10) != 0) {
                int[] iArr = this.f23577a;
                int i14 = i12 / 32;
                iArr[i14] = iArr[i14] | (1 << (i12 & 31));
            }
            i12++;
        }
        this.f23578b = i12;
    }

    /* renamed from: d */
    public a clone() {
        return new a((int[]) this.f23577a.clone(), this.f23578b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f23578b != aVar.f23578b || !Arrays.equals(this.f23577a, aVar.f23577a)) {
            return false;
        }
        return true;
    }

    public boolean h(int i10) {
        return ((1 << (i10 & 31)) & this.f23577a[i10 / 32]) != 0;
    }

    public int hashCode() {
        return (this.f23578b * 31) + Arrays.hashCode(this.f23577a);
    }

    public int i() {
        return this.f23578b;
    }

    public int j() {
        return (this.f23578b + 7) / 8;
    }

    public void l(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = 0;
            for (int i15 = 0; i15 < 8; i15++) {
                if (h(i10)) {
                    i14 |= 1 << (7 - i15);
                }
                i10++;
            }
            bArr[i11 + i13] = (byte) i14;
        }
    }

    public void o(a aVar) {
        if (this.f23578b == aVar.f23578b) {
            int i10 = 0;
            while (true) {
                int[] iArr = this.f23577a;
                if (i10 < iArr.length) {
                    iArr[i10] = iArr[i10] ^ aVar.f23577a[i10];
                    i10++;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Sizes don't match");
        }
    }

    public String toString() {
        char c10;
        int i10 = this.f23578b;
        StringBuilder sb2 = new StringBuilder(i10 + (i10 / 8) + 1);
        for (int i11 = 0; i11 < this.f23578b; i11++) {
            if ((i11 & 7) == 0) {
                sb2.append(' ');
            }
            if (h(i11)) {
                c10 = 'X';
            } else {
                c10 = '.';
            }
            sb2.append(c10);
        }
        return sb2.toString();
    }

    a(int[] iArr, int i10) {
        this.f23577a = iArr;
        this.f23578b = i10;
    }
}
