package com.google.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

final class w0<E> extends c<E> implements RandomAccess {

    /* renamed from: d  reason: collision with root package name */
    private static final w0<Object> f21960d;

    /* renamed from: b  reason: collision with root package name */
    private E[] f21961b;

    /* renamed from: c  reason: collision with root package name */
    private int f21962c;

    static {
        w0<Object> w0Var = new w0<>(new Object[0], 0);
        f21960d = w0Var;
        w0Var.c();
    }

    private w0(E[] eArr, int i10) {
        this.f21961b = eArr;
        this.f21962c = i10;
    }

    private static <E> E[] d(int i10) {
        return new Object[i10];
    }

    public static <E> w0<E> f() {
        return f21960d;
    }

    private void g(int i10) {
        if (i10 < 0 || i10 >= this.f21962c) {
            throw new IndexOutOfBoundsException(i(i10));
        }
    }

    private String i(int i10) {
        return "Index:" + i10 + ", Size:" + this.f21962c;
    }

    public boolean add(E e10) {
        b();
        int i10 = this.f21962c;
        E[] eArr = this.f21961b;
        if (i10 == eArr.length) {
            this.f21961b = Arrays.copyOf(eArr, ((i10 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f21961b;
        int i11 = this.f21962c;
        this.f21962c = i11 + 1;
        eArr2[i11] = e10;
        this.modCount++;
        return true;
    }

    public E get(int i10) {
        g(i10);
        return this.f21961b[i10];
    }

    /* renamed from: j */
    public w0<E> a(int i10) {
        if (i10 >= this.f21962c) {
            return new w0<>(Arrays.copyOf(this.f21961b, i10), this.f21962c);
        }
        throw new IllegalArgumentException();
    }

    public E remove(int i10) {
        b();
        g(i10);
        E[] eArr = this.f21961b;
        E e10 = eArr[i10];
        int i11 = this.f21962c;
        if (i10 < i11 - 1) {
            System.arraycopy(eArr, i10 + 1, eArr, i10, (i11 - i10) - 1);
        }
        this.f21962c--;
        this.modCount++;
        return e10;
    }

    public E set(int i10, E e10) {
        b();
        g(i10);
        E[] eArr = this.f21961b;
        E e11 = eArr[i10];
        eArr[i10] = e10;
        this.modCount++;
        return e11;
    }

    public int size() {
        return this.f21962c;
    }

    public void add(int i10, E e10) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f21962c)) {
            throw new IndexOutOfBoundsException(i(i10));
        }
        E[] eArr = this.f21961b;
        if (i11 < eArr.length) {
            System.arraycopy(eArr, i10, eArr, i10 + 1, i11 - i10);
        } else {
            E[] d10 = d(((i11 * 3) / 2) + 1);
            System.arraycopy(this.f21961b, 0, d10, 0, i10);
            System.arraycopy(this.f21961b, i10, d10, i10 + 1, this.f21962c - i10);
            this.f21961b = d10;
        }
        this.f21961b[i10] = e10;
        this.f21962c++;
        this.modCount++;
    }
}
