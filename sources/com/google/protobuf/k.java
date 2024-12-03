package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.w;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class k extends c<Double> implements w.b, RandomAccess, u0 {

    /* renamed from: d  reason: collision with root package name */
    private static final k f21896d;

    /* renamed from: b  reason: collision with root package name */
    private double[] f21897b;

    /* renamed from: c  reason: collision with root package name */
    private int f21898c;

    static {
        k kVar = new k(new double[0], 0);
        f21896d = kVar;
        kVar.c();
    }

    k() {
        this(new double[10], 0);
    }

    private void i(int i10, double d10) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f21898c)) {
            throw new IndexOutOfBoundsException(p(i10));
        }
        double[] dArr = this.f21897b;
        if (i11 < dArr.length) {
            System.arraycopy(dArr, i10, dArr, i10 + 1, i11 - i10);
        } else {
            double[] dArr2 = new double[(((i11 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i10);
            System.arraycopy(this.f21897b, i10, dArr2, i10 + 1, this.f21898c - i10);
            this.f21897b = dArr2;
        }
        this.f21897b[i10] = d10;
        this.f21898c++;
        this.modCount++;
    }

    public static k j() {
        return f21896d;
    }

    private void m(int i10) {
        if (i10 < 0 || i10 >= this.f21898c) {
            throw new IndexOutOfBoundsException(p(i10));
        }
    }

    private String p(int i10) {
        return "Index:" + i10 + ", Size:" + this.f21898c;
    }

    public boolean addAll(Collection<? extends Double> collection) {
        b();
        w.a(collection);
        if (!(collection instanceof k)) {
            return super.addAll(collection);
        }
        k kVar = (k) collection;
        int i10 = kVar.f21898c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f21898c;
        if (a.e.API_PRIORITY_OTHER - i11 >= i10) {
            int i12 = i11 + i10;
            double[] dArr = this.f21897b;
            if (i12 > dArr.length) {
                this.f21897b = Arrays.copyOf(dArr, i12);
            }
            System.arraycopy(kVar.f21897b, 0, this.f21897b, this.f21898c, kVar.f21898c);
            this.f21898c = i12;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /* renamed from: d */
    public void add(int i10, Double d10) {
        i(i10, d10.doubleValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return super.equals(obj);
        }
        k kVar = (k) obj;
        if (this.f21898c != kVar.f21898c) {
            return false;
        }
        double[] dArr = kVar.f21897b;
        for (int i10 = 0; i10 < this.f21898c; i10++) {
            if (Double.doubleToLongBits(this.f21897b[i10]) != Double.doubleToLongBits(dArr[i10])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public boolean add(Double d10) {
        g(d10.doubleValue());
        return true;
    }

    public void g(double d10) {
        b();
        int i10 = this.f21898c;
        double[] dArr = this.f21897b;
        if (i10 == dArr.length) {
            double[] dArr2 = new double[(((i10 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i10);
            this.f21897b = dArr2;
        }
        double[] dArr3 = this.f21897b;
        int i11 = this.f21898c;
        this.f21898c = i11 + 1;
        dArr3[i11] = d10;
    }

    public int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f21898c; i11++) {
            i10 = (i10 * 31) + w.f(Double.doubleToLongBits(this.f21897b[i11]));
        }
        return i10;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f21897b[i10] == doubleValue) {
                return i10;
            }
        }
        return -1;
    }

    /* renamed from: n */
    public Double get(int i10) {
        return Double.valueOf(o(i10));
    }

    public double o(int i10) {
        m(i10);
        return this.f21897b[i10];
    }

    /* renamed from: q */
    public Double remove(int i10) {
        b();
        m(i10);
        double[] dArr = this.f21897b;
        double d10 = dArr[i10];
        int i11 = this.f21898c;
        if (i10 < i11 - 1) {
            System.arraycopy(dArr, i10 + 1, dArr, i10, (i11 - i10) - 1);
        }
        this.f21898c--;
        this.modCount++;
        return Double.valueOf(d10);
    }

    /* renamed from: r */
    public Double set(int i10, Double d10) {
        return Double.valueOf(s(i10, d10.doubleValue()));
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i10, int i11) {
        b();
        if (i11 >= i10) {
            double[] dArr = this.f21897b;
            System.arraycopy(dArr, i11, dArr, i10, this.f21898c - i11);
            this.f21898c -= i11 - i10;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public double s(int i10, double d10) {
        b();
        m(i10);
        double[] dArr = this.f21897b;
        double d11 = dArr[i10];
        dArr[i10] = d10;
        return d11;
    }

    public int size() {
        return this.f21898c;
    }

    private k(double[] dArr, int i10) {
        this.f21897b = dArr;
        this.f21898c = i10;
    }

    public w.b a(int i10) {
        if (i10 >= this.f21898c) {
            return new k(Arrays.copyOf(this.f21897b, i10), this.f21898c);
        }
        throw new IllegalArgumentException();
    }
}
