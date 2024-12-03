package androidx.datastore.preferences.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

final class v0<E> extends c<E> implements RandomAccess {

    /* renamed from: d  reason: collision with root package name */
    private static final v0<Object> f5379d;

    /* renamed from: b  reason: collision with root package name */
    private E[] f5380b;

    /* renamed from: c  reason: collision with root package name */
    private int f5381c;

    static {
        v0<Object> v0Var = new v0<>(new Object[0], 0);
        f5379d = v0Var;
        v0Var.c();
    }

    private v0(E[] eArr, int i10) {
        this.f5380b = eArr;
        this.f5381c = i10;
    }

    private static <E> E[] d(int i10) {
        return new Object[i10];
    }

    public static <E> v0<E> f() {
        return f5379d;
    }

    private void g(int i10) {
        if (i10 < 0 || i10 >= this.f5381c) {
            throw new IndexOutOfBoundsException(i(i10));
        }
    }

    private String i(int i10) {
        return "Index:" + i10 + ", Size:" + this.f5381c;
    }

    public boolean add(E e10) {
        b();
        int i10 = this.f5381c;
        E[] eArr = this.f5380b;
        if (i10 == eArr.length) {
            this.f5380b = Arrays.copyOf(eArr, ((i10 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f5380b;
        int i11 = this.f5381c;
        this.f5381c = i11 + 1;
        eArr2[i11] = e10;
        this.modCount++;
        return true;
    }

    public E get(int i10) {
        g(i10);
        return this.f5380b[i10];
    }

    /* renamed from: j */
    public v0<E> a(int i10) {
        if (i10 >= this.f5381c) {
            return new v0<>(Arrays.copyOf(this.f5380b, i10), this.f5381c);
        }
        throw new IllegalArgumentException();
    }

    public E remove(int i10) {
        b();
        g(i10);
        E[] eArr = this.f5380b;
        E e10 = eArr[i10];
        int i11 = this.f5381c;
        if (i10 < i11 - 1) {
            System.arraycopy(eArr, i10 + 1, eArr, i10, (i11 - i10) - 1);
        }
        this.f5381c--;
        this.modCount++;
        return e10;
    }

    public E set(int i10, E e10) {
        b();
        g(i10);
        E[] eArr = this.f5380b;
        E e11 = eArr[i10];
        eArr[i10] = e10;
        this.modCount++;
        return e11;
    }

    public int size() {
        return this.f5381c;
    }

    public void add(int i10, E e10) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f5381c)) {
            throw new IndexOutOfBoundsException(i(i10));
        }
        E[] eArr = this.f5380b;
        if (i11 < eArr.length) {
            System.arraycopy(eArr, i10, eArr, i10 + 1, i11 - i10);
        } else {
            E[] d10 = d(((i11 * 3) / 2) + 1);
            System.arraycopy(this.f5380b, 0, d10, 0, i10);
            System.arraycopy(this.f5380b, i10, d10, i10 + 1, this.f5381c - i10);
            this.f5380b = d10;
        }
        this.f5380b[i10] = e10;
        this.f5381c++;
        this.modCount++;
    }
}
