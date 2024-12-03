package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.w;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class d0 extends c<Long> implements w.i, RandomAccess, u0 {

    /* renamed from: d  reason: collision with root package name */
    private static final d0 f21775d;

    /* renamed from: b  reason: collision with root package name */
    private long[] f21776b;

    /* renamed from: c  reason: collision with root package name */
    private int f21777c;

    static {
        d0 d0Var = new d0(new long[0], 0);
        f21775d = d0Var;
        d0Var.c();
    }

    d0() {
        this(new long[10], 0);
    }

    private void g(int i10, long j10) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f21777c)) {
            throw new IndexOutOfBoundsException(p(i10));
        }
        long[] jArr = this.f21776b;
        if (i11 < jArr.length) {
            System.arraycopy(jArr, i10, jArr, i10 + 1, i11 - i10);
        } else {
            long[] jArr2 = new long[(((i11 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            System.arraycopy(this.f21776b, i10, jArr2, i10 + 1, this.f21777c - i10);
            this.f21776b = jArr2;
        }
        this.f21776b[i10] = j10;
        this.f21777c++;
        this.modCount++;
    }

    public static d0 j() {
        return f21775d;
    }

    private void m(int i10) {
        if (i10 < 0 || i10 >= this.f21777c) {
            throw new IndexOutOfBoundsException(p(i10));
        }
    }

    private String p(int i10) {
        return "Index:" + i10 + ", Size:" + this.f21777c;
    }

    public boolean addAll(Collection<? extends Long> collection) {
        b();
        w.a(collection);
        if (!(collection instanceof d0)) {
            return super.addAll(collection);
        }
        d0 d0Var = (d0) collection;
        int i10 = d0Var.f21777c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f21777c;
        if (a.e.API_PRIORITY_OTHER - i11 >= i10) {
            int i12 = i11 + i10;
            long[] jArr = this.f21776b;
            if (i12 > jArr.length) {
                this.f21776b = Arrays.copyOf(jArr, i12);
            }
            System.arraycopy(d0Var.f21776b, 0, this.f21776b, this.f21777c, d0Var.f21777c);
            this.f21777c = i12;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
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
        if (this.f21777c != d0Var.f21777c) {
            return false;
        }
        long[] jArr = d0Var.f21776b;
        for (int i10 = 0; i10 < this.f21777c; i10++) {
            if (this.f21776b[i10] != jArr[i10]) {
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
        for (int i11 = 0; i11 < this.f21777c; i11++) {
            i10 = (i10 * 31) + w.f(this.f21776b[i11]);
        }
        return i10;
    }

    public void i(long j10) {
        b();
        int i10 = this.f21777c;
        long[] jArr = this.f21776b;
        if (i10 == jArr.length) {
            long[] jArr2 = new long[(((i10 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            this.f21776b = jArr2;
        }
        long[] jArr3 = this.f21776b;
        int i11 = this.f21777c;
        this.f21777c = i11 + 1;
        jArr3[i11] = j10;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f21776b[i10] == longValue) {
                return i10;
            }
        }
        return -1;
    }

    /* renamed from: n */
    public Long get(int i10) {
        return Long.valueOf(o(i10));
    }

    public long o(int i10) {
        m(i10);
        return this.f21776b[i10];
    }

    /* renamed from: q */
    public Long remove(int i10) {
        b();
        m(i10);
        long[] jArr = this.f21776b;
        long j10 = jArr[i10];
        int i11 = this.f21777c;
        if (i10 < i11 - 1) {
            System.arraycopy(jArr, i10 + 1, jArr, i10, (i11 - i10) - 1);
        }
        this.f21777c--;
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
            long[] jArr = this.f21776b;
            System.arraycopy(jArr, i11, jArr, i10, this.f21777c - i11);
            this.f21777c -= i11 - i10;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public long s(int i10, long j10) {
        b();
        m(i10);
        long[] jArr = this.f21776b;
        long j11 = jArr[i10];
        jArr[i10] = j10;
        return j11;
    }

    public int size() {
        return this.f21777c;
    }

    private d0(long[] jArr, int i10) {
        this.f21776b = jArr;
        this.f21777c = i10;
    }

    public w.i a(int i10) {
        if (i10 >= this.f21777c) {
            return new d0(Arrays.copyOf(this.f21776b, i10), this.f21777c);
        }
        throw new IllegalArgumentException();
    }
}
