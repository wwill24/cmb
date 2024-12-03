package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import com.google.android.gms.common.api.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class k extends c<Double> implements w.b, RandomAccess, t0 {

    /* renamed from: d  reason: collision with root package name */
    private static final k f5324d;

    /* renamed from: b  reason: collision with root package name */
    private double[] f5325b;

    /* renamed from: c  reason: collision with root package name */
    private int f5326c;

    static {
        k kVar = new k(new double[0], 0);
        f5324d = kVar;
        kVar.c();
    }

    k() {
        this(new double[10], 0);
    }

    private void i(int i10, double d10) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f5326c)) {
            throw new IndexOutOfBoundsException(o(i10));
        }
        double[] dArr = this.f5325b;
        if (i11 < dArr.length) {
            System.arraycopy(dArr, i10, dArr, i10 + 1, i11 - i10);
        } else {
            double[] dArr2 = new double[(((i11 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i10);
            System.arraycopy(this.f5325b, i10, dArr2, i10 + 1, this.f5326c - i10);
            this.f5325b = dArr2;
        }
        this.f5325b[i10] = d10;
        this.f5326c++;
        this.modCount++;
    }

    private void j(int i10) {
        if (i10 < 0 || i10 >= this.f5326c) {
            throw new IndexOutOfBoundsException(o(i10));
        }
    }

    private String o(int i10) {
        return "Index:" + i10 + ", Size:" + this.f5326c;
    }

    public boolean addAll(Collection<? extends Double> collection) {
        b();
        w.a(collection);
        if (!(collection instanceof k)) {
            return super.addAll(collection);
        }
        k kVar = (k) collection;
        int i10 = kVar.f5326c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f5326c;
        if (a.e.API_PRIORITY_OTHER - i11 >= i10) {
            int i12 = i11 + i10;
            double[] dArr = this.f5325b;
            if (i12 > dArr.length) {
                this.f5325b = Arrays.copyOf(dArr, i12);
            }
            System.arraycopy(kVar.f5325b, 0, this.f5325b, this.f5326c, kVar.f5326c);
            this.f5326c = i12;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
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
        if (this.f5326c != kVar.f5326c) {
            return false;
        }
        double[] dArr = kVar.f5325b;
        for (int i10 = 0; i10 < this.f5326c; i10++) {
            if (Double.doubleToLongBits(this.f5325b[i10]) != Double.doubleToLongBits(dArr[i10])) {
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
        int i10 = this.f5326c;
        double[] dArr = this.f5325b;
        if (i10 == dArr.length) {
            double[] dArr2 = new double[(((i10 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i10);
            this.f5325b = dArr2;
        }
        double[] dArr3 = this.f5325b;
        int i11 = this.f5326c;
        this.f5326c = i11 + 1;
        dArr3[i11] = d10;
    }

    public int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f5326c; i11++) {
            i10 = (i10 * 31) + w.f(Double.doubleToLongBits(this.f5325b[i11]));
        }
        return i10;
    }

    /* renamed from: m */
    public Double get(int i10) {
        return Double.valueOf(n(i10));
    }

    public double n(int i10) {
        j(i10);
        return this.f5325b[i10];
    }

    /* renamed from: p */
    public w.b a(int i10) {
        if (i10 >= this.f5326c) {
            return new k(Arrays.copyOf(this.f5325b, i10), this.f5326c);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: q */
    public Double remove(int i10) {
        b();
        j(i10);
        double[] dArr = this.f5325b;
        double d10 = dArr[i10];
        int i11 = this.f5326c;
        if (i10 < i11 - 1) {
            System.arraycopy(dArr, i10 + 1, dArr, i10, (i11 - i10) - 1);
        }
        this.f5326c--;
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
            double[] dArr = this.f5325b;
            System.arraycopy(dArr, i11, dArr, i10, this.f5326c - i11);
            this.f5326c -= i11 - i10;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public double s(int i10, double d10) {
        b();
        j(i10);
        double[] dArr = this.f5325b;
        double d11 = dArr[i10];
        dArr[i10] = d10;
        return d11;
    }

    public int size() {
        return this.f5326c;
    }

    private k(double[] dArr, int i10) {
        this.f5325b = dArr;
        this.f5326c = i10;
    }

    public boolean remove(Object obj) {
        b();
        for (int i10 = 0; i10 < this.f5326c; i10++) {
            if (obj.equals(Double.valueOf(this.f5325b[i10]))) {
                double[] dArr = this.f5325b;
                System.arraycopy(dArr, i10 + 1, dArr, i10, (this.f5326c - i10) - 1);
                this.f5326c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
