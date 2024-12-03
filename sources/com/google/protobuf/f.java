package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.w;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class f extends c<Boolean> implements w.a, RandomAccess, u0 {

    /* renamed from: d  reason: collision with root package name */
    private static final f f21792d;

    /* renamed from: b  reason: collision with root package name */
    private boolean[] f21793b;

    /* renamed from: c  reason: collision with root package name */
    private int f21794c;

    static {
        f fVar = new f(new boolean[0], 0);
        f21792d = fVar;
        fVar.c();
    }

    f() {
        this(new boolean[10], 0);
    }

    private void g(int i10, boolean z10) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f21794c)) {
            throw new IndexOutOfBoundsException(p(i10));
        }
        boolean[] zArr = this.f21793b;
        if (i11 < zArr.length) {
            System.arraycopy(zArr, i10, zArr, i10 + 1, i11 - i10);
        } else {
            boolean[] zArr2 = new boolean[(((i11 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i10);
            System.arraycopy(this.f21793b, i10, zArr2, i10 + 1, this.f21794c - i10);
            this.f21793b = zArr2;
        }
        this.f21793b[i10] = z10;
        this.f21794c++;
        this.modCount++;
    }

    public static f j() {
        return f21792d;
    }

    private void m(int i10) {
        if (i10 < 0 || i10 >= this.f21794c) {
            throw new IndexOutOfBoundsException(p(i10));
        }
    }

    private String p(int i10) {
        return "Index:" + i10 + ", Size:" + this.f21794c;
    }

    public boolean addAll(Collection<? extends Boolean> collection) {
        b();
        w.a(collection);
        if (!(collection instanceof f)) {
            return super.addAll(collection);
        }
        f fVar = (f) collection;
        int i10 = fVar.f21794c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f21794c;
        if (a.e.API_PRIORITY_OTHER - i11 >= i10) {
            int i12 = i11 + i10;
            boolean[] zArr = this.f21793b;
            if (i12 > zArr.length) {
                this.f21793b = Arrays.copyOf(zArr, i12);
            }
            System.arraycopy(fVar.f21793b, 0, this.f21793b, this.f21794c, fVar.f21794c);
            this.f21794c = i12;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /* renamed from: d */
    public void add(int i10, Boolean bool) {
        g(i10, bool.booleanValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return super.equals(obj);
        }
        f fVar = (f) obj;
        if (this.f21794c != fVar.f21794c) {
            return false;
        }
        boolean[] zArr = fVar.f21793b;
        for (int i10 = 0; i10 < this.f21794c; i10++) {
            if (this.f21793b[i10] != zArr[i10]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public boolean add(Boolean bool) {
        i(bool.booleanValue());
        return true;
    }

    public int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f21794c; i11++) {
            i10 = (i10 * 31) + w.c(this.f21793b[i11]);
        }
        return i10;
    }

    public void i(boolean z10) {
        b();
        int i10 = this.f21794c;
        boolean[] zArr = this.f21793b;
        if (i10 == zArr.length) {
            boolean[] zArr2 = new boolean[(((i10 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i10);
            this.f21793b = zArr2;
        }
        boolean[] zArr3 = this.f21793b;
        int i11 = this.f21794c;
        this.f21794c = i11 + 1;
        zArr3[i11] = z10;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f21793b[i10] == booleanValue) {
                return i10;
            }
        }
        return -1;
    }

    /* renamed from: n */
    public Boolean get(int i10) {
        return Boolean.valueOf(o(i10));
    }

    public boolean o(int i10) {
        m(i10);
        return this.f21793b[i10];
    }

    /* renamed from: q */
    public Boolean remove(int i10) {
        b();
        m(i10);
        boolean[] zArr = this.f21793b;
        boolean z10 = zArr[i10];
        int i11 = this.f21794c;
        if (i10 < i11 - 1) {
            System.arraycopy(zArr, i10 + 1, zArr, i10, (i11 - i10) - 1);
        }
        this.f21794c--;
        this.modCount++;
        return Boolean.valueOf(z10);
    }

    /* renamed from: r */
    public Boolean set(int i10, Boolean bool) {
        return Boolean.valueOf(s(i10, bool.booleanValue()));
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i10, int i11) {
        b();
        if (i11 >= i10) {
            boolean[] zArr = this.f21793b;
            System.arraycopy(zArr, i11, zArr, i10, this.f21794c - i11);
            this.f21794c -= i11 - i10;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public boolean s(int i10, boolean z10) {
        b();
        m(i10);
        boolean[] zArr = this.f21793b;
        boolean z11 = zArr[i10];
        zArr[i10] = z10;
        return z11;
    }

    public int size() {
        return this.f21794c;
    }

    private f(boolean[] zArr, int i10) {
        this.f21793b = zArr;
        this.f21794c = i10;
    }

    public w.a a(int i10) {
        if (i10 >= this.f21794c) {
            return new f(Arrays.copyOf(this.f21793b, i10), this.f21794c);
        }
        throw new IllegalArgumentException();
    }
}
