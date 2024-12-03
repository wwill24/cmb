package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.a;
import com.google.crypto.tink.shaded.protobuf.x;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class u extends c<Float> implements x.f, RandomAccess, u0 {

    /* renamed from: d  reason: collision with root package name */
    private static final u f20904d;

    /* renamed from: b  reason: collision with root package name */
    private float[] f20905b;

    /* renamed from: c  reason: collision with root package name */
    private int f20906c;

    static {
        u uVar = new u(new float[0], 0);
        f20904d = uVar;
        uVar.c();
    }

    u() {
        this(new float[10], 0);
    }

    private void i(int i10, float f10) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f20906c)) {
            throw new IndexOutOfBoundsException(o(i10));
        }
        float[] fArr = this.f20905b;
        if (i11 < fArr.length) {
            System.arraycopy(fArr, i10, fArr, i10 + 1, i11 - i10);
        } else {
            float[] fArr2 = new float[(((i11 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i10);
            System.arraycopy(this.f20905b, i10, fArr2, i10 + 1, this.f20906c - i10);
            this.f20905b = fArr2;
        }
        this.f20905b[i10] = f10;
        this.f20906c++;
        this.modCount++;
    }

    private void j(int i10) {
        if (i10 < 0 || i10 >= this.f20906c) {
            throw new IndexOutOfBoundsException(o(i10));
        }
    }

    private String o(int i10) {
        return "Index:" + i10 + ", Size:" + this.f20906c;
    }

    public boolean addAll(Collection<? extends Float> collection) {
        b();
        x.a(collection);
        if (!(collection instanceof u)) {
            return super.addAll(collection);
        }
        u uVar = (u) collection;
        int i10 = uVar.f20906c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f20906c;
        if (a.e.API_PRIORITY_OTHER - i11 >= i10) {
            int i12 = i11 + i10;
            float[] fArr = this.f20905b;
            if (i12 > fArr.length) {
                this.f20905b = Arrays.copyOf(fArr, i12);
            }
            System.arraycopy(uVar.f20905b, 0, this.f20905b, this.f20906c, uVar.f20906c);
            this.f20906c = i12;
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
        if (!(obj instanceof u)) {
            return super.equals(obj);
        }
        u uVar = (u) obj;
        if (this.f20906c != uVar.f20906c) {
            return false;
        }
        float[] fArr = uVar.f20905b;
        for (int i10 = 0; i10 < this.f20906c; i10++) {
            if (Float.floatToIntBits(this.f20905b[i10]) != Float.floatToIntBits(fArr[i10])) {
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
        int i10 = this.f20906c;
        float[] fArr = this.f20905b;
        if (i10 == fArr.length) {
            float[] fArr2 = new float[(((i10 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i10);
            this.f20905b = fArr2;
        }
        float[] fArr3 = this.f20905b;
        int i11 = this.f20906c;
        this.f20906c = i11 + 1;
        fArr3[i11] = f10;
    }

    public int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f20906c; i11++) {
            i10 = (i10 * 31) + Float.floatToIntBits(this.f20905b[i11]);
        }
        return i10;
    }

    /* renamed from: m */
    public Float get(int i10) {
        return Float.valueOf(n(i10));
    }

    public float n(int i10) {
        j(i10);
        return this.f20905b[i10];
    }

    /* renamed from: p */
    public x.f a(int i10) {
        if (i10 >= this.f20906c) {
            return new u(Arrays.copyOf(this.f20905b, i10), this.f20906c);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: q */
    public Float remove(int i10) {
        b();
        j(i10);
        float[] fArr = this.f20905b;
        float f10 = fArr[i10];
        int i11 = this.f20906c;
        if (i10 < i11 - 1) {
            System.arraycopy(fArr, i10 + 1, fArr, i10, (i11 - i10) - 1);
        }
        this.f20906c--;
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
            float[] fArr = this.f20905b;
            System.arraycopy(fArr, i11, fArr, i10, this.f20906c - i11);
            this.f20906c -= i11 - i10;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public float s(int i10, float f10) {
        b();
        j(i10);
        float[] fArr = this.f20905b;
        float f11 = fArr[i10];
        fArr[i10] = f10;
        return f11;
    }

    public int size() {
        return this.f20906c;
    }

    private u(float[] fArr, int i10) {
        this.f20905b = fArr;
        this.f20906c = i10;
    }

    public boolean remove(Object obj) {
        b();
        for (int i10 = 0; i10 < this.f20906c; i10++) {
            if (obj.equals(Float.valueOf(this.f20905b[i10]))) {
                float[] fArr = this.f20905b;
                System.arraycopy(fArr, i10 + 1, fArr, i10, (this.f20906c - i10) - 1);
                this.f20906c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
