package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.w;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class v extends c<Integer> implements w.g, RandomAccess, u0 {

    /* renamed from: d  reason: collision with root package name */
    private static final v f21946d;

    /* renamed from: b  reason: collision with root package name */
    private int[] f21947b;

    /* renamed from: c  reason: collision with root package name */
    private int f21948c;

    static {
        v vVar = new v(new int[0], 0);
        f21946d = vVar;
        vVar.c();
    }

    v() {
        this(new int[10], 0);
    }

    private void g(int i10, int i11) {
        int i12;
        b();
        if (i10 < 0 || i10 > (i12 = this.f21948c)) {
            throw new IndexOutOfBoundsException(n(i10));
        }
        int[] iArr = this.f21947b;
        if (i12 < iArr.length) {
            System.arraycopy(iArr, i10, iArr, i10 + 1, i12 - i10);
        } else {
            int[] iArr2 = new int[(((i12 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            System.arraycopy(this.f21947b, i10, iArr2, i10 + 1, this.f21948c - i10);
            this.f21947b = iArr2;
        }
        this.f21947b[i10] = i11;
        this.f21948c++;
        this.modCount++;
    }

    public static v i() {
        return f21946d;
    }

    private void j(int i10) {
        if (i10 < 0 || i10 >= this.f21948c) {
            throw new IndexOutOfBoundsException(n(i10));
        }
    }

    private String n(int i10) {
        return "Index:" + i10 + ", Size:" + this.f21948c;
    }

    public int G(int i10, int i11) {
        b();
        j(i10);
        int[] iArr = this.f21947b;
        int i12 = iArr[i10];
        iArr[i10] = i11;
        return i12;
    }

    public void U0(int i10) {
        b();
        int i11 = this.f21948c;
        int[] iArr = this.f21947b;
        if (i11 == iArr.length) {
            int[] iArr2 = new int[(((i11 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            this.f21947b = iArr2;
        }
        int[] iArr3 = this.f21947b;
        int i12 = this.f21948c;
        this.f21948c = i12 + 1;
        iArr3[i12] = i10;
    }

    public boolean addAll(Collection<? extends Integer> collection) {
        b();
        w.a(collection);
        if (!(collection instanceof v)) {
            return super.addAll(collection);
        }
        v vVar = (v) collection;
        int i10 = vVar.f21948c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f21948c;
        if (a.e.API_PRIORITY_OTHER - i11 >= i10) {
            int i12 = i11 + i10;
            int[] iArr = this.f21947b;
            if (i12 > iArr.length) {
                this.f21947b = Arrays.copyOf(iArr, i12);
            }
            System.arraycopy(vVar.f21947b, 0, this.f21947b, this.f21948c, vVar.f21948c);
            this.f21948c = i12;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /* renamed from: d */
    public void add(int i10, Integer num) {
        g(i10, num.intValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return super.equals(obj);
        }
        v vVar = (v) obj;
        if (this.f21948c != vVar.f21948c) {
            return false;
        }
        int[] iArr = vVar.f21947b;
        for (int i10 = 0; i10 < this.f21948c; i10++) {
            if (this.f21947b[i10] != iArr[i10]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public boolean add(Integer num) {
        U0(num.intValue());
        return true;
    }

    public int getInt(int i10) {
        j(i10);
        return this.f21947b[i10];
    }

    public int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f21948c; i11++) {
            i10 = (i10 * 31) + this.f21947b[i11];
        }
        return i10;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f21947b[i10] == intValue) {
                return i10;
            }
        }
        return -1;
    }

    /* renamed from: m */
    public Integer get(int i10) {
        return Integer.valueOf(getInt(i10));
    }

    /* renamed from: o */
    public Integer remove(int i10) {
        b();
        j(i10);
        int[] iArr = this.f21947b;
        int i11 = iArr[i10];
        int i12 = this.f21948c;
        if (i10 < i12 - 1) {
            System.arraycopy(iArr, i10 + 1, iArr, i10, (i12 - i10) - 1);
        }
        this.f21948c--;
        this.modCount++;
        return Integer.valueOf(i11);
    }

    /* renamed from: p */
    public Integer set(int i10, Integer num) {
        return Integer.valueOf(G(i10, num.intValue()));
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i10, int i11) {
        b();
        if (i11 >= i10) {
            int[] iArr = this.f21947b;
            System.arraycopy(iArr, i11, iArr, i10, this.f21948c - i11);
            this.f21948c -= i11 - i10;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public int size() {
        return this.f21948c;
    }

    private v(int[] iArr, int i10) {
        this.f21947b = iArr;
        this.f21948c = i10;
    }

    public w.g a(int i10) {
        if (i10 >= this.f21948c) {
            return new v(Arrays.copyOf(this.f21947b, i10), this.f21948c);
        }
        throw new IllegalArgumentException();
    }
}
