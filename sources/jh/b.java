package jh;

import java.util.Arrays;

public final class b implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private int f23579a;

    /* renamed from: b  reason: collision with root package name */
    private int f23580b;

    /* renamed from: c  reason: collision with root package name */
    private int f23581c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f23582d;

    public b(int i10) {
        this(i10, i10);
    }

    private String a(String str, String str2, String str3) {
        String str4;
        StringBuilder sb2 = new StringBuilder(this.f23580b * (this.f23579a + 1));
        for (int i10 = 0; i10 < this.f23580b; i10++) {
            for (int i11 = 0; i11 < this.f23579a; i11++) {
                if (d(i11, i10)) {
                    str4 = str;
                } else {
                    str4 = str2;
                }
                sb2.append(str4);
            }
            sb2.append(str3);
        }
        return sb2.toString();
    }

    public void b() {
        int length = this.f23582d.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f23582d[i10] = 0;
        }
    }

    /* renamed from: c */
    public b clone() {
        return new b(this.f23579a, this.f23580b, this.f23581c, (int[]) this.f23582d.clone());
    }

    public boolean d(int i10, int i11) {
        if (((this.f23582d[(i11 * this.f23581c) + (i10 / 32)] >>> (i10 & 31)) & 1) != 0) {
            return true;
        }
        return false;
    }

    public int e() {
        return this.f23580b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f23579a == bVar.f23579a && this.f23580b == bVar.f23580b && this.f23581c == bVar.f23581c && Arrays.equals(this.f23582d, bVar.f23582d)) {
            return true;
        }
        return false;
    }

    public int h() {
        return this.f23579a;
    }

    public int hashCode() {
        int i10 = this.f23579a;
        return (((((((i10 * 31) + i10) * 31) + this.f23580b) * 31) + this.f23581c) * 31) + Arrays.hashCode(this.f23582d);
    }

    public void i(int i10, int i11) {
        int i12 = (i11 * this.f23581c) + (i10 / 32);
        int[] iArr = this.f23582d;
        iArr[i12] = (1 << (i10 & 31)) | iArr[i12];
    }

    public void j(int i10, int i11, int i12, int i13) {
        if (i11 < 0 || i10 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i13 < 1 || i12 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i14 = i12 + i10;
            int i15 = i13 + i11;
            if (i15 > this.f23580b || i14 > this.f23579a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i11 < i15) {
                int i16 = this.f23581c * i11;
                for (int i17 = i10; i17 < i14; i17++) {
                    int[] iArr = this.f23582d;
                    int i18 = (i17 / 32) + i16;
                    iArr[i18] = iArr[i18] | (1 << (i17 & 31));
                }
                i11++;
            }
        }
    }

    public String k(String str, String str2) {
        return a(str, str2, "\n");
    }

    public String toString() {
        return k("X ", "  ");
    }

    public b(int i10, int i11) {
        if (i10 < 1 || i11 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f23579a = i10;
        this.f23580b = i11;
        int i12 = (i10 + 31) / 32;
        this.f23581c = i12;
        this.f23582d = new int[(i12 * i11)];
    }

    private b(int i10, int i11, int i12, int[] iArr) {
        this.f23579a = i10;
        this.f23580b = i11;
        this.f23581c = i12;
        this.f23582d = iArr;
    }
}
