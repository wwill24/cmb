package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.a;
import com.google.crypto.tink.shaded.protobuf.x;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class w extends c<Integer> implements x.g, RandomAccess, u0 {

    /* renamed from: d  reason: collision with root package name */
    private static final w f20911d;

    /* renamed from: b  reason: collision with root package name */
    private int[] f20912b;

    /* renamed from: c  reason: collision with root package name */
    private int f20913c;

    static {
        w wVar = new w(new int[0], 0);
        f20911d = wVar;
        wVar.c();
    }

    w() {
        this(new int[10], 0);
    }

    private void g(int i10, int i11) {
        int i12;
        b();
        if (i10 < 0 || i10 > (i12 = this.f20913c)) {
            throw new IndexOutOfBoundsException(m(i10));
        }
        int[] iArr = this.f20912b;
        if (i12 < iArr.length) {
            System.arraycopy(iArr, i10, iArr, i10 + 1, i12 - i10);
        } else {
            int[] iArr2 = new int[(((i12 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            System.arraycopy(this.f20912b, i10, iArr2, i10 + 1, this.f20913c - i10);
            this.f20912b = iArr2;
        }
        this.f20912b[i10] = i11;
        this.f20913c++;
        this.modCount++;
    }

    private void i(int i10) {
        if (i10 < 0 || i10 >= this.f20913c) {
            throw new IndexOutOfBoundsException(m(i10));
        }
    }

    private String m(int i10) {
        return "Index:" + i10 + ", Size:" + this.f20913c;
    }

    public int G(int i10, int i11) {
        b();
        i(i10);
        int[] iArr = this.f20912b;
        int i12 = iArr[i10];
        iArr[i10] = i11;
        return i12;
    }

    public void U0(int i10) {
        b();
        int i11 = this.f20913c;
        int[] iArr = this.f20912b;
        if (i11 == iArr.length) {
            int[] iArr2 = new int[(((i11 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            this.f20912b = iArr2;
        }
        int[] iArr3 = this.f20912b;
        int i12 = this.f20913c;
        this.f20913c = i12 + 1;
        iArr3[i12] = i10;
    }

    public boolean addAll(Collection<? extends Integer> collection) {
        b();
        x.a(collection);
        if (!(collection instanceof w)) {
            return super.addAll(collection);
        }
        w wVar = (w) collection;
        int i10 = wVar.f20913c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f20913c;
        if (a.e.API_PRIORITY_OTHER - i11 >= i10) {
            int i12 = i11 + i10;
            int[] iArr = this.f20912b;
            if (i12 > iArr.length) {
                this.f20912b = Arrays.copyOf(iArr, i12);
            }
            System.arraycopy(wVar.f20912b, 0, this.f20912b, this.f20913c, wVar.f20913c);
            this.f20913c = i12;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    /* renamed from: d */
    public void add(int i10, Integer num) {
        g(i10, num.intValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return super.equals(obj);
        }
        w wVar = (w) obj;
        if (this.f20913c != wVar.f20913c) {
            return false;
        }
        int[] iArr = wVar.f20912b;
        for (int i10 = 0; i10 < this.f20913c; i10++) {
            if (this.f20912b[i10] != iArr[i10]) {
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
        i(i10);
        return this.f20912b[i10];
    }

    public int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f20913c; i11++) {
            i10 = (i10 * 31) + this.f20912b[i11];
        }
        return i10;
    }

    /* renamed from: j */
    public Integer get(int i10) {
        return Integer.valueOf(getInt(i10));
    }

    /* renamed from: n */
    public x.g a(int i10) {
        if (i10 >= this.f20913c) {
            return new w(Arrays.copyOf(this.f20912b, i10), this.f20913c);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: o */
    public Integer remove(int i10) {
        b();
        i(i10);
        int[] iArr = this.f20912b;
        int i11 = iArr[i10];
        int i12 = this.f20913c;
        if (i10 < i12 - 1) {
            System.arraycopy(iArr, i10 + 1, iArr, i10, (i12 - i10) - 1);
        }
        this.f20913c--;
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
            int[] iArr = this.f20912b;
            System.arraycopy(iArr, i11, iArr, i10, this.f20913c - i11);
            this.f20913c -= i11 - i10;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public int size() {
        return this.f20913c;
    }

    private w(int[] iArr, int i10) {
        this.f20912b = iArr;
        this.f20913c = i10;
    }

    public boolean remove(Object obj) {
        b();
        for (int i10 = 0; i10 < this.f20913c; i10++) {
            if (obj.equals(Integer.valueOf(this.f20912b[i10]))) {
                int[] iArr = this.f20912b;
                System.arraycopy(iArr, i10 + 1, iArr, i10, (this.f20913c - i10) - 1);
                this.f20913c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
