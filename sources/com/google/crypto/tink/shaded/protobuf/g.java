package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.a;
import com.google.crypto.tink.shaded.protobuf.x;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class g extends c<Boolean> implements x.a, RandomAccess, u0 {

    /* renamed from: d  reason: collision with root package name */
    private static final g f20798d;

    /* renamed from: b  reason: collision with root package name */
    private boolean[] f20799b;

    /* renamed from: c  reason: collision with root package name */
    private int f20800c;

    static {
        g gVar = new g(new boolean[0], 0);
        f20798d = gVar;
        gVar.c();
    }

    g() {
        this(new boolean[10], 0);
    }

    private void g(int i10, boolean z10) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f20800c)) {
            throw new IndexOutOfBoundsException(o(i10));
        }
        boolean[] zArr = this.f20799b;
        if (i11 < zArr.length) {
            System.arraycopy(zArr, i10, zArr, i10 + 1, i11 - i10);
        } else {
            boolean[] zArr2 = new boolean[(((i11 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i10);
            System.arraycopy(this.f20799b, i10, zArr2, i10 + 1, this.f20800c - i10);
            this.f20799b = zArr2;
        }
        this.f20799b[i10] = z10;
        this.f20800c++;
        this.modCount++;
    }

    private void j(int i10) {
        if (i10 < 0 || i10 >= this.f20800c) {
            throw new IndexOutOfBoundsException(o(i10));
        }
    }

    private String o(int i10) {
        return "Index:" + i10 + ", Size:" + this.f20800c;
    }

    public boolean addAll(Collection<? extends Boolean> collection) {
        b();
        x.a(collection);
        if (!(collection instanceof g)) {
            return super.addAll(collection);
        }
        g gVar = (g) collection;
        int i10 = gVar.f20800c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f20800c;
        if (a.e.API_PRIORITY_OTHER - i11 >= i10) {
            int i12 = i11 + i10;
            boolean[] zArr = this.f20799b;
            if (i12 > zArr.length) {
                this.f20799b = Arrays.copyOf(zArr, i12);
            }
            System.arraycopy(gVar.f20799b, 0, this.f20799b, this.f20800c, gVar.f20800c);
            this.f20800c = i12;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    /* renamed from: d */
    public void add(int i10, Boolean bool) {
        g(i10, bool.booleanValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return super.equals(obj);
        }
        g gVar = (g) obj;
        if (this.f20800c != gVar.f20800c) {
            return false;
        }
        boolean[] zArr = gVar.f20799b;
        for (int i10 = 0; i10 < this.f20800c; i10++) {
            if (this.f20799b[i10] != zArr[i10]) {
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
        for (int i11 = 0; i11 < this.f20800c; i11++) {
            i10 = (i10 * 31) + x.c(this.f20799b[i11]);
        }
        return i10;
    }

    public void i(boolean z10) {
        b();
        int i10 = this.f20800c;
        boolean[] zArr = this.f20799b;
        if (i10 == zArr.length) {
            boolean[] zArr2 = new boolean[(((i10 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i10);
            this.f20799b = zArr2;
        }
        boolean[] zArr3 = this.f20799b;
        int i11 = this.f20800c;
        this.f20800c = i11 + 1;
        zArr3[i11] = z10;
    }

    /* renamed from: m */
    public Boolean get(int i10) {
        return Boolean.valueOf(n(i10));
    }

    public boolean n(int i10) {
        j(i10);
        return this.f20799b[i10];
    }

    /* renamed from: p */
    public x.a a(int i10) {
        if (i10 >= this.f20800c) {
            return new g(Arrays.copyOf(this.f20799b, i10), this.f20800c);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: q */
    public Boolean remove(int i10) {
        b();
        j(i10);
        boolean[] zArr = this.f20799b;
        boolean z10 = zArr[i10];
        int i11 = this.f20800c;
        if (i10 < i11 - 1) {
            System.arraycopy(zArr, i10 + 1, zArr, i10, (i11 - i10) - 1);
        }
        this.f20800c--;
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
            boolean[] zArr = this.f20799b;
            System.arraycopy(zArr, i11, zArr, i10, this.f20800c - i11);
            this.f20800c -= i11 - i10;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public boolean s(int i10, boolean z10) {
        b();
        j(i10);
        boolean[] zArr = this.f20799b;
        boolean z11 = zArr[i10];
        zArr[i10] = z10;
        return z11;
    }

    public int size() {
        return this.f20800c;
    }

    private g(boolean[] zArr, int i10) {
        this.f20799b = zArr;
        this.f20800c = i10;
    }

    public boolean remove(Object obj) {
        b();
        for (int i10 = 0; i10 < this.f20800c; i10++) {
            if (obj.equals(Boolean.valueOf(this.f20799b[i10]))) {
                boolean[] zArr = this.f20799b;
                System.arraycopy(zArr, i10 + 1, zArr, i10, (this.f20800c - i10) - 1);
                this.f20800c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
