package io.reactivex.internal.util;

public final class f<T> {

    /* renamed from: a  reason: collision with root package name */
    final float f30720a;

    /* renamed from: b  reason: collision with root package name */
    int f30721b;

    /* renamed from: c  reason: collision with root package name */
    int f30722c;

    /* renamed from: d  reason: collision with root package name */
    int f30723d;

    /* renamed from: e  reason: collision with root package name */
    T[] f30724e;

    public f() {
        this(16, 0.75f);
    }

    static int c(int i10) {
        int i11 = i10 * -1640531527;
        return i11 ^ (i11 >>> 16);
    }

    public boolean a(T t10) {
        T t11;
        T[] tArr = this.f30724e;
        int i10 = this.f30721b;
        int c10 = c(t10.hashCode()) & i10;
        T t12 = tArr[c10];
        if (t12 != null) {
            if (t12.equals(t10)) {
                return false;
            }
            do {
                c10 = (c10 + 1) & i10;
                t11 = tArr[c10];
                if (t11 == null) {
                }
            } while (!t11.equals(t10));
            return false;
        }
        tArr[c10] = t10;
        int i11 = this.f30722c + 1;
        this.f30722c = i11;
        if (i11 >= this.f30723d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.f30724e;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        T t10;
        T[] tArr = this.f30724e;
        int length = tArr.length;
        int i10 = length << 1;
        int i11 = i10 - 1;
        T[] tArr2 = new Object[i10];
        int i12 = this.f30722c;
        while (true) {
            int i13 = i12 - 1;
            if (i12 != 0) {
                do {
                    length--;
                    t10 = tArr[length];
                } while (t10 == null);
                int c10 = c(t10.hashCode()) & i11;
                if (tArr2[c10] != null) {
                    do {
                        c10 = (c10 + 1) & i11;
                    } while (tArr2[c10] != null);
                }
                tArr2[c10] = tArr[length];
                i12 = i13;
            } else {
                this.f30721b = i11;
                this.f30723d = (int) (((float) i10) * this.f30720a);
                this.f30724e = tArr2;
                return;
            }
        }
    }

    public boolean e(T t10) {
        T t11;
        T[] tArr = this.f30724e;
        int i10 = this.f30721b;
        int c10 = c(t10.hashCode()) & i10;
        T t12 = tArr[c10];
        if (t12 == null) {
            return false;
        }
        if (t12.equals(t10)) {
            return f(c10, tArr, i10);
        }
        do {
            c10 = (c10 + 1) & i10;
            t11 = tArr[c10];
            if (t11 == null) {
                return false;
            }
        } while (!t11.equals(t10));
        return f(c10, tArr, i10);
    }

    /* access modifiers changed from: package-private */
    public boolean f(int i10, T[] tArr, int i11) {
        int i12;
        T t10;
        this.f30722c--;
        while (true) {
            int i13 = i10 + 1;
            while (true) {
                i12 = i13 & i11;
                t10 = tArr[i12];
                if (t10 == null) {
                    tArr[i10] = null;
                    return true;
                }
                int c10 = c(t10.hashCode()) & i11;
                if (i10 <= i12) {
                    if (i10 >= c10 || c10 > i12) {
                        break;
                    }
                    i13 = i12 + 1;
                } else {
                    if (i10 >= c10 && c10 > i12) {
                        break;
                    }
                    i13 = i12 + 1;
                }
            }
            tArr[i10] = t10;
            i10 = i12;
        }
    }

    public f(int i10, float f10) {
        this.f30720a = f10;
        int a10 = g.a(i10);
        this.f30721b = a10 - 1;
        this.f30723d = (int) (f10 * ((float) a10));
        this.f30724e = new Object[a10];
    }
}
