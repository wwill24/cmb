package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import com.google.android.gms.common.api.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class f extends c<Boolean> implements w.a, RandomAccess, t0 {

    /* renamed from: d  reason: collision with root package name */
    private static final f f5252d;

    /* renamed from: b  reason: collision with root package name */
    private boolean[] f5253b;

    /* renamed from: c  reason: collision with root package name */
    private int f5254c;

    static {
        f fVar = new f(new boolean[0], 0);
        f5252d = fVar;
        fVar.c();
    }

    f() {
        this(new boolean[10], 0);
    }

    private void g(int i10, boolean z10) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f5254c)) {
            throw new IndexOutOfBoundsException(o(i10));
        }
        boolean[] zArr = this.f5253b;
        if (i11 < zArr.length) {
            System.arraycopy(zArr, i10, zArr, i10 + 1, i11 - i10);
        } else {
            boolean[] zArr2 = new boolean[(((i11 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i10);
            System.arraycopy(this.f5253b, i10, zArr2, i10 + 1, this.f5254c - i10);
            this.f5253b = zArr2;
        }
        this.f5253b[i10] = z10;
        this.f5254c++;
        this.modCount++;
    }

    private void j(int i10) {
        if (i10 < 0 || i10 >= this.f5254c) {
            throw new IndexOutOfBoundsException(o(i10));
        }
    }

    private String o(int i10) {
        return "Index:" + i10 + ", Size:" + this.f5254c;
    }

    public boolean addAll(Collection<? extends Boolean> collection) {
        b();
        w.a(collection);
        if (!(collection instanceof f)) {
            return super.addAll(collection);
        }
        f fVar = (f) collection;
        int i10 = fVar.f5254c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f5254c;
        if (a.e.API_PRIORITY_OTHER - i11 >= i10) {
            int i12 = i11 + i10;
            boolean[] zArr = this.f5253b;
            if (i12 > zArr.length) {
                this.f5253b = Arrays.copyOf(zArr, i12);
            }
            System.arraycopy(fVar.f5253b, 0, this.f5253b, this.f5254c, fVar.f5254c);
            this.f5254c = i12;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    /* renamed from: d */
    public void add(int i10, Boolean bool) {
        g(i10, bool.booleanValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return super.equals(obj);
        }
        f fVar = (f) obj;
        if (this.f5254c != fVar.f5254c) {
            return false;
        }
        boolean[] zArr = fVar.f5253b;
        for (int i10 = 0; i10 < this.f5254c; i10++) {
            if (this.f5253b[i10] != zArr[i10]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public boolean add(Boolean bool) {
        i(bool.booleanValue());
        return true;
    }

    public int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f5254c; i11++) {
            i10 = (i10 * 31) + w.c(this.f5253b[i11]);
        }
        return i10;
    }

    public void i(boolean z10) {
        b();
        int i10 = this.f5254c;
        boolean[] zArr = this.f5253b;
        if (i10 == zArr.length) {
            boolean[] zArr2 = new boolean[(((i10 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i10);
            this.f5253b = zArr2;
        }
        boolean[] zArr3 = this.f5253b;
        int i11 = this.f5254c;
        this.f5254c = i11 + 1;
        zArr3[i11] = z10;
    }

    /* renamed from: m */
    public Boolean get(int i10) {
        return Boolean.valueOf(n(i10));
    }

    public boolean n(int i10) {
        j(i10);
        return this.f5253b[i10];
    }

    /* renamed from: p */
    public w.a a(int i10) {
        if (i10 >= this.f5254c) {
            return new f(Arrays.copyOf(this.f5253b, i10), this.f5254c);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: q */
    public Boolean remove(int i10) {
        b();
        j(i10);
        boolean[] zArr = this.f5253b;
        boolean z10 = zArr[i10];
        int i11 = this.f5254c;
        if (i10 < i11 - 1) {
            System.arraycopy(zArr, i10 + 1, zArr, i10, (i11 - i10) - 1);
        }
        this.f5254c--;
        this.modCount++;
        return Boolean.valueOf(z10);
    }

    /* renamed from: r */
    public Boolean set(int i10, Boolean bool) {
        return Boolean.valueOf(s(i10, bool.booleanValue()));
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i10, int i11) {
        b();
        if (i11 >= i10) {
            boolean[] zArr = this.f5253b;
            System.arraycopy(zArr, i11, zArr, i10, this.f5254c - i11);
            this.f5254c -= i11 - i10;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public boolean s(int i10, boolean z10) {
        b();
        j(i10);
        boolean[] zArr = this.f5253b;
        boolean z11 = zArr[i10];
        zArr[i10] = z10;
        return z11;
    }

    public int size() {
        return this.f5254c;
    }

    private f(boolean[] zArr, int i10) {
        this.f5253b = zArr;
        this.f5254c = i10;
    }

    public boolean remove(Object obj) {
        b();
        for (int i10 = 0; i10 < this.f5254c; i10++) {
            if (obj.equals(Boolean.valueOf(this.f5253b[i10]))) {
                boolean[] zArr = this.f5253b;
                System.arraycopy(zArr, i10 + 1, zArr, i10, (this.f5254c - i10) - 1);
                this.f5254c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
