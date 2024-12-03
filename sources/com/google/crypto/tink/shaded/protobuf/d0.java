package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.a;
import com.google.crypto.tink.shaded.protobuf.x;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class d0 extends c<Long> implements x.h, RandomAccess, u0 {

    /* renamed from: d  reason: collision with root package name */
    private static final d0 f20774d;

    /* renamed from: b  reason: collision with root package name */
    private long[] f20775b;

    /* renamed from: c  reason: collision with root package name */
    private int f20776c;

    static {
        d0 d0Var = new d0(new long[0], 0);
        f20774d = d0Var;
        d0Var.c();
    }

    d0() {
        this(new long[10], 0);
    }

    private void g(int i10, long j10) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f20776c)) {
            throw new IndexOutOfBoundsException(o(i10));
        }
        long[] jArr = this.f20775b;
        if (i11 < jArr.length) {
            System.arraycopy(jArr, i10, jArr, i10 + 1, i11 - i10);
        } else {
            long[] jArr2 = new long[(((i11 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            System.arraycopy(this.f20775b, i10, jArr2, i10 + 1, this.f20776c - i10);
            this.f20775b = jArr2;
        }
        this.f20775b[i10] = j10;
        this.f20776c++;
        this.modCount++;
    }

    private void j(int i10) {
        if (i10 < 0 || i10 >= this.f20776c) {
            throw new IndexOutOfBoundsException(o(i10));
        }
    }

    private String o(int i10) {
        return "Index:" + i10 + ", Size:" + this.f20776c;
    }

    public boolean addAll(Collection<? extends Long> collection) {
        b();
        x.a(collection);
        if (!(collection instanceof d0)) {
            return super.addAll(collection);
        }
        d0 d0Var = (d0) collection;
        int i10 = d0Var.f20776c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f20776c;
        if (a.e.API_PRIORITY_OTHER - i11 >= i10) {
            int i12 = i11 + i10;
            long[] jArr = this.f20775b;
            if (i12 > jArr.length) {
                this.f20775b = Arrays.copyOf(jArr, i12);
            }
            System.arraycopy(d0Var.f20775b, 0, this.f20775b, this.f20776c, d0Var.f20776c);
            this.f20776c = i12;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    /* renamed from: d */
    public void add(int i10, Long l10) {
        g(i10, l10.longValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return super.equals(obj);
        }
        d0 d0Var = (d0) obj;
        if (this.f20776c != d0Var.f20776c) {
            return false;
        }
        long[] jArr = d0Var.f20775b;
        for (int i10 = 0; i10 < this.f20776c; i10++) {
            if (this.f20775b[i10] != jArr[i10]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public boolean add(Long l10) {
        i(l10.longValue());
        return true;
    }

    public int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f20776c; i11++) {
            i10 = (i10 * 31) + x.f(this.f20775b[i11]);
        }
        return i10;
    }

    public void i(long j10) {
        b();
        int i10 = this.f20776c;
        long[] jArr = this.f20775b;
        if (i10 == jArr.length) {
            long[] jArr2 = new long[(((i10 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            this.f20775b = jArr2;
        }
        long[] jArr3 = this.f20775b;
        int i11 = this.f20776c;
        this.f20776c = i11 + 1;
        jArr3[i11] = j10;
    }

    /* renamed from: m */
    public Long get(int i10) {
        return Long.valueOf(n(i10));
    }

    public long n(int i10) {
        j(i10);
        return this.f20775b[i10];
    }

    /* renamed from: p */
    public x.h a(int i10) {
        if (i10 >= this.f20776c) {
            return new d0(Arrays.copyOf(this.f20775b, i10), this.f20776c);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: q */
    public Long remove(int i10) {
        b();
        j(i10);
        long[] jArr = this.f20775b;
        long j10 = jArr[i10];
        int i11 = this.f20776c;
        if (i10 < i11 - 1) {
            System.arraycopy(jArr, i10 + 1, jArr, i10, (i11 - i10) - 1);
        }
        this.f20776c--;
        this.modCount++;
        return Long.valueOf(j10);
    }

    /* renamed from: r */
    public Long set(int i10, Long l10) {
        return Long.valueOf(s(i10, l10.longValue()));
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i10, int i11) {
        b();
        if (i11 >= i10) {
            long[] jArr = this.f20775b;
            System.arraycopy(jArr, i11, jArr, i10, this.f20776c - i11);
            this.f20776c -= i11 - i10;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public long s(int i10, long j10) {
        b();
        j(i10);
        long[] jArr = this.f20775b;
        long j11 = jArr[i10];
        jArr[i10] = j10;
        return j11;
    }

    public int size() {
        return this.f20776c;
    }

    private d0(long[] jArr, int i10) {
        this.f20775b = jArr;
        this.f20776c = i10;
    }

    public boolean remove(Object obj) {
        b();
        for (int i10 = 0; i10 < this.f20776c; i10++) {
            if (obj.equals(Long.valueOf(this.f20775b[i10]))) {
                long[] jArr = this.f20775b;
                System.arraycopy(jArr, i10 + 1, jArr, i10, (this.f20776c - i10) - 1);
                this.f20776c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
