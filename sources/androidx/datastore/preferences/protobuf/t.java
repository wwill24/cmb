package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import com.google.android.gms.common.api.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class t extends c<Float> implements w.f, RandomAccess, t0 {

    /* renamed from: d  reason: collision with root package name */
    private static final t f5369d;

    /* renamed from: b  reason: collision with root package name */
    private float[] f5370b;

    /* renamed from: c  reason: collision with root package name */
    private int f5371c;

    static {
        t tVar = new t(new float[0], 0);
        f5369d = tVar;
        tVar.c();
    }

    t() {
        this(new float[10], 0);
    }

    private void i(int i10, float f10) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f5371c)) {
            throw new IndexOutOfBoundsException(o(i10));
        }
        float[] fArr = this.f5370b;
        if (i11 < fArr.length) {
            System.arraycopy(fArr, i10, fArr, i10 + 1, i11 - i10);
        } else {
            float[] fArr2 = new float[(((i11 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i10);
            System.arraycopy(this.f5370b, i10, fArr2, i10 + 1, this.f5371c - i10);
            this.f5370b = fArr2;
        }
        this.f5370b[i10] = f10;
        this.f5371c++;
        this.modCount++;
    }

    private void j(int i10) {
        if (i10 < 0 || i10 >= this.f5371c) {
            throw new IndexOutOfBoundsException(o(i10));
        }
    }

    private String o(int i10) {
        return "Index:" + i10 + ", Size:" + this.f5371c;
    }

    public boolean addAll(Collection<? extends Float> collection) {
        b();
        w.a(collection);
        if (!(collection instanceof t)) {
            return super.addAll(collection);
        }
        t tVar = (t) collection;
        int i10 = tVar.f5371c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f5371c;
        if (a.e.API_PRIORITY_OTHER - i11 >= i10) {
            int i12 = i11 + i10;
            float[] fArr = this.f5370b;
            if (i12 > fArr.length) {
                this.f5370b = Arrays.copyOf(fArr, i12);
            }
            System.arraycopy(tVar.f5370b, 0, this.f5370b, this.f5371c, tVar.f5371c);
            this.f5371c = i12;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
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
        if (this.f5371c != tVar.f5371c) {
            return false;
        }
        float[] fArr = tVar.f5370b;
        for (int i10 = 0; i10 < this.f5371c; i10++) {
            if (Float.floatToIntBits(this.f5370b[i10]) != Float.floatToIntBits(fArr[i10])) {
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
        int i10 = this.f5371c;
        float[] fArr = this.f5370b;
        if (i10 == fArr.length) {
            float[] fArr2 = new float[(((i10 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i10);
            this.f5370b = fArr2;
        }
        float[] fArr3 = this.f5370b;
        int i11 = this.f5371c;
        this.f5371c = i11 + 1;
        fArr3[i11] = f10;
    }

    public int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f5371c; i11++) {
            i10 = (i10 * 31) + Float.floatToIntBits(this.f5370b[i11]);
        }
        return i10;
    }

    /* renamed from: m */
    public Float get(int i10) {
        return Float.valueOf(n(i10));
    }

    public float n(int i10) {
        j(i10);
        return this.f5370b[i10];
    }

    /* renamed from: p */
    public w.f a(int i10) {
        if (i10 >= this.f5371c) {
            return new t(Arrays.copyOf(this.f5370b, i10), this.f5371c);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: q */
    public Float remove(int i10) {
        b();
        j(i10);
        float[] fArr = this.f5370b;
        float f10 = fArr[i10];
        int i11 = this.f5371c;
        if (i10 < i11 - 1) {
            System.arraycopy(fArr, i10 + 1, fArr, i10, (i11 - i10) - 1);
        }
        this.f5371c--;
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
            float[] fArr = this.f5370b;
            System.arraycopy(fArr, i11, fArr, i10, this.f5371c - i11);
            this.f5371c -= i11 - i10;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public float s(int i10, float f10) {
        b();
        j(i10);
        float[] fArr = this.f5370b;
        float f11 = fArr[i10];
        fArr[i10] = f10;
        return f11;
    }

    public int size() {
        return this.f5371c;
    }

    private t(float[] fArr, int i10) {
        this.f5370b = fArr;
        this.f5371c = i10;
    }

    public boolean remove(Object obj) {
        b();
        for (int i10 = 0; i10 < this.f5371c; i10++) {
            if (obj.equals(Float.valueOf(this.f5370b[i10]))) {
                float[] fArr = this.f5370b;
                System.arraycopy(fArr, i10 + 1, fArr, i10, (this.f5371c - i10) - 1);
                this.f5371c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
