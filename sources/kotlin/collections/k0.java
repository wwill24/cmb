package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.j;

final class k0<T> extends b<T> implements RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f32057b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f32058c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f32059d;

    /* renamed from: e  reason: collision with root package name */
    private int f32060e;

    public static final class a extends a<T> {

        /* renamed from: c  reason: collision with root package name */
        private int f32061c;

        /* renamed from: d  reason: collision with root package name */
        private int f32062d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ k0<T> f32063e;

        a(k0<T> k0Var) {
            this.f32063e = k0Var;
            this.f32061c = k0Var.size();
            this.f32062d = k0Var.f32059d;
        }

        /* access modifiers changed from: protected */
        public void a() {
            if (this.f32061c == 0) {
                c();
                return;
            }
            d(this.f32063e.f32057b[this.f32062d]);
            this.f32062d = (this.f32062d + 1) % this.f32063e.f32058c;
            this.f32061c--;
        }
    }

    public k0(Object[] objArr, int i10) {
        j.g(objArr, "buffer");
        this.f32057b = objArr;
        boolean z10 = true;
        if (i10 >= 0) {
            if (i10 > objArr.length ? false : z10) {
                this.f32058c = objArr.length;
                this.f32060e = i10;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i10 + " cannot be larger than the buffer size: " + objArr.length).toString());
        }
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i10).toString());
    }

    public int b() {
        return this.f32060e;
    }

    public T get(int i10) {
        b.f32031a.b(i10, size());
        return this.f32057b[(this.f32059d + i10) % this.f32058c];
    }

    public final boolean isFull() {
        return size() == this.f32058c;
    }

    public Iterator<T> iterator() {
        return new a(this);
    }

    public final void j(T t10) {
        if (!isFull()) {
            this.f32057b[(this.f32059d + size()) % this.f32058c] = t10;
            this.f32060e = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    public final k0<T> m(int i10) {
        Object[] objArr;
        int i11 = this.f32058c;
        int g10 = j.g(i11 + (i11 >> 1) + 1, i10);
        if (this.f32059d == 0) {
            objArr = Arrays.copyOf(this.f32057b, g10);
            j.f(objArr, "copyOf(this, newSize)");
        } else {
            objArr = toArray(new Object[g10]);
        }
        return new k0<>(objArr, size());
    }

    public final void n(int i10) {
        boolean z10;
        boolean z11 = true;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (i10 > size()) {
                z11 = false;
            }
            if (!z11) {
                throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i10 + ", size = " + size()).toString());
            } else if (i10 > 0) {
                int i11 = this.f32059d;
                int f10 = (i11 + i10) % this.f32058c;
                if (i11 > f10) {
                    k.m(this.f32057b, null, i11, this.f32058c);
                    k.m(this.f32057b, null, 0, f10);
                } else {
                    k.m(this.f32057b, null, i11, f10);
                }
                this.f32059d = f10;
                this.f32060e = size() - i10;
            }
        } else {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i10).toString());
        }
    }

    public <T> T[] toArray(T[] tArr) {
        j.g(tArr, "array");
        if (tArr.length < size()) {
            tArr = Arrays.copyOf(tArr, size());
            j.f(tArr, "copyOf(this, newSize)");
        }
        int size = size();
        int i10 = this.f32059d;
        int i11 = 0;
        int i12 = 0;
        while (i12 < size && i10 < this.f32058c) {
            tArr[i12] = this.f32057b[i10];
            i12++;
            i10++;
        }
        while (i12 < size) {
            tArr[i12] = this.f32057b[i11];
            i12++;
            i11++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        return tArr;
    }

    public k0(int i10) {
        this(new Object[i10], 0);
    }

    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
