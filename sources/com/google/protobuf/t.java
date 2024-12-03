package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.w;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class t extends c<Float> implements w.f, RandomAccess, u0 {

    /* renamed from: d  reason: collision with root package name */
    private static final t f21942d;

    /* renamed from: b  reason: collision with root package name */
    private float[] f21943b;

    /* renamed from: c  reason: collision with root package name */
    private int f21944c;

    static {
        t tVar = new t(new float[0], 0);
        f21942d = tVar;
        tVar.c();
    }

    t() {
        this(new float[10], 0);
    }

    private void i(int i10, float f10) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f21944c)) {
            throw new IndexOutOfBoundsException(p(i10));
        }
        float[] fArr = this.f21943b;
        if (i11 < fArr.length) {
            System.arraycopy(fArr, i10, fArr, i10 + 1, i11 - i10);
        } else {
            float[] fArr2 = new float[(((i11 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i10);
            System.arraycopy(this.f21943b, i10, fArr2, i10 + 1, this.f21944c - i10);
            this.f21943b = fArr2;
        }
        this.f21943b[i10] = f10;
        this.f21944c++;
        this.modCount++;
    }

    public static t j() {
        return f21942d;
    }

    private void m(int i10) {
        if (i10 < 0 || i10 >= this.f21944c) {
            throw new IndexOutOfBoundsException(p(i10));
        }
    }

    private String p(int i10) {
        return "Index:" + i10 + ", Size:" + this.f21944c;
    }

    public boolean addAll(Collection<? extends Float> collection) {
        b();
        w.a(collection);
        if (!(collection instanceof t)) {
            return super.addAll(collection);
        }
        t tVar = (t) collection;
        int i10 = tVar.f21944c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f21944c;
        if (a.e.API_PRIORITY_OTHER - i11 >= i10) {
            int i12 = i11 + i10;
            float[] fArr = this.f21943b;
            if (i12 > fArr.length) {
                this.f21943b = Arrays.copyOf(fArr, i12);
            }
            System.arraycopy(tVar.f21943b, 0, this.f21943b, this.f21944c, tVar.f21944c);
            this.f21944c = i12;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /* renamed from: d */
    public void add(int i10, Float f10) {
        i(i10, f10.floatValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return super.equals(obj);
        }
        t tVar = (t) obj;
        if (this.f21944c != tVar.f21944c) {
            return false;
        }
        float[] fArr = tVar.f21943b;
        for (int i10 = 0; i10 < this.f21944c; i10++) {
            if (Float.floatToIntBits(this.f21943b[i10]) != Float.floatToIntBits(fArr[i10])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public boolean add(Float f10) {
        g(f10.floatValue());
        return true;
    }

    public void g(float f10) {
        b();
        int i10 = this.f21944c;
        float[] fArr = this.f21943b;
        if (i10 == fArr.length) {
            float[] fArr2 = new float[(((i10 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i10);
            this.f21943b = fArr2;
        }
        float[] fArr3 = this.f21943b;
        int i11 = this.f21944c;
        this.f21944c = i11 + 1;
        fArr3[i11] = f10;
    }

    public int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f21944c; i11++) {
            i10 = (i10 * 31) + Float.floatToIntBits(this.f21943b[i11]);
        }
        return i10;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f21943b[i10] == floatValue) {
                return i10;
            }
        }
        return -1;
    }

    /* renamed from: n */
    public Float get(int i10) {
        return Float.valueOf(o(i10));
    }

    public float o(int i10) {
        m(i10);
        return this.f21943b[i10];
    }

    /* renamed from: q */
    public Float remove(int i10) {
        b();
        m(i10);
        float[] fArr = this.f21943b;
        float f10 = fArr[i10];
        int i11 = this.f21944c;
        if (i10 < i11 - 1) {
            System.arraycopy(fArr, i10 + 1, fArr, i10, (i11 - i10) - 1);
        }
        this.f21944c--;
        this.modCount++;
        return Float.valueOf(f10);
    }

    /* renamed from: r */
    public Float set(int i10, Float f10) {
        return Float.valueOf(s(i10, f10.floatValue()));
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i10, int i11) {
        b();
        if (i11 >= i10) {
            float[] fArr = this.f21943b;
            System.arraycopy(fArr, i11, fArr, i10, this.f21944c - i11);
            this.f21944c -= i11 - i10;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public float s(int i10, float f10) {
        b();
        m(i10);
        float[] fArr = this.f21943b;
        float f11 = fArr[i10];
        fArr[i10] = f10;
        return f11;
    }

    public int size() {
        return this.f21944c;
    }

    private t(float[] fArr, int i10) {
        this.f21943b = fArr;
        this.f21944c = i10;
    }

    public w.f a(int i10) {
        if (i10 >= this.f21944c) {
            return new t(Arrays.copyOf(this.f21943b, i10), this.f21944c);
        }
        throw new IllegalArgumentException();
    }
}
