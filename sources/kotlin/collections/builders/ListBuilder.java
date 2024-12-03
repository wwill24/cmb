package kotlin.collections.builders;

import hk.b;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.d;
import kotlin.collections.g;
import kotlin.jvm.internal.j;

public final class ListBuilder<E> extends d<E> implements RandomAccess, Serializable {
    /* access modifiers changed from: private */

    /* renamed from: array  reason: collision with root package name */
    public E[] f32038array;
    private final ListBuilder<E> backing;
    private boolean isReadOnly;
    /* access modifiers changed from: private */
    public int length;
    /* access modifiers changed from: private */
    public int offset;
    private final ListBuilder<E> root;

    private static final class a<E> implements ListIterator<E>, qk.a {

        /* renamed from: a  reason: collision with root package name */
        private final ListBuilder<E> f32039a;

        /* renamed from: b  reason: collision with root package name */
        private int f32040b;

        /* renamed from: c  reason: collision with root package name */
        private int f32041c = -1;

        public a(ListBuilder<E> listBuilder, int i10) {
            j.g(listBuilder, "list");
            this.f32039a = listBuilder;
            this.f32040b = i10;
        }

        public void add(E e10) {
            ListBuilder<E> listBuilder = this.f32039a;
            int i10 = this.f32040b;
            this.f32040b = i10 + 1;
            listBuilder.add(i10, e10);
            this.f32041c = -1;
        }

        public boolean hasNext() {
            return this.f32040b < this.f32039a.length;
        }

        public boolean hasPrevious() {
            return this.f32040b > 0;
        }

        public E next() {
            if (this.f32040b < this.f32039a.length) {
                int i10 = this.f32040b;
                this.f32040b = i10 + 1;
                this.f32041c = i10;
                return this.f32039a.f32038array[this.f32039a.offset + this.f32041c];
            }
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return this.f32040b;
        }

        public E previous() {
            int i10 = this.f32040b;
            if (i10 > 0) {
                int i11 = i10 - 1;
                this.f32040b = i11;
                this.f32041c = i11;
                return this.f32039a.f32038array[this.f32039a.offset + this.f32041c];
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return this.f32040b - 1;
        }

        public void remove() {
            boolean z10;
            int i10 = this.f32041c;
            if (i10 != -1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.f32039a.remove(i10);
                this.f32040b = this.f32041c;
                this.f32041c = -1;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }

        public void set(E e10) {
            boolean z10;
            int i10 = this.f32041c;
            if (i10 != -1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.f32039a.set(i10, e10);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
    }

    private ListBuilder(E[] eArr, int i10, int i11, boolean z10, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.f32038array = eArr;
        this.offset = i10;
        this.length = i11;
        this.isReadOnly = z10;
        this.backing = listBuilder;
        this.root = listBuilder2;
    }

    private final void m(int i10, Collection<? extends E> collection, int i11) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.m(i10, collection, i11);
            this.f32038array = this.backing.f32038array;
            this.length += i11;
            return;
        }
        t(i10, i11);
        Iterator<? extends E> it = collection.iterator();
        for (int i12 = 0; i12 < i11; i12++) {
            this.f32038array[i10 + i12] = it.next();
        }
    }

    private final void n(int i10, E e10) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.n(i10, e10);
            this.f32038array = this.backing.f32038array;
            this.length++;
            return;
        }
        t(i10, 1);
        this.f32038array[i10] = e10;
    }

    private final void p() {
        if (v()) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean q(List<?> list) {
        return b.h(this.f32038array, this.offset, this.length, list);
    }

    private final void r(int i10) {
        if (this.backing != null) {
            throw new IllegalStateException();
        } else if (i10 >= 0) {
            E[] eArr = this.f32038array;
            if (i10 > eArr.length) {
                this.f32038array = b.e(this.f32038array, g.f32052d.a(eArr.length, i10));
            }
        } else {
            throw new OutOfMemoryError();
        }
    }

    private final void s(int i10) {
        r(this.length + i10);
    }

    private final void t(int i10, int i11) {
        s(i11);
        E[] eArr = this.f32038array;
        Object[] unused = k.g(eArr, eArr, i10 + i11, i10, this.offset + this.length);
        this.length += i11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.root;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean v() {
        /*
            r1 = this;
            boolean r0 = r1.isReadOnly
            if (r0 != 0) goto L_0x000f
            kotlin.collections.builders.ListBuilder<E> r0 = r1.root
            if (r0 == 0) goto L_0x000d
            boolean r0 = r0.isReadOnly
            if (r0 == 0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            r0 = 0
            goto L_0x0010
        L_0x000f:
            r0 = 1
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.ListBuilder.v():boolean");
    }

    private final E w(int i10) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            this.length--;
            return listBuilder.w(i10);
        }
        E[] eArr = this.f32038array;
        E e10 = eArr[i10];
        Object[] unused = k.g(eArr, eArr, i10, i10 + 1, this.offset + this.length);
        b.f(this.f32038array, (this.offset + this.length) - 1);
        this.length--;
        return e10;
    }

    private final Object writeReplace() {
        if (v()) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    private final void y(int i10, int i11) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.y(i10, i11);
        } else {
            E[] eArr = this.f32038array;
            Object[] unused = k.g(eArr, eArr, i10, i10 + i11, this.length);
            E[] eArr2 = this.f32038array;
            int i12 = this.length;
            b.g(eArr2, i12 - i11, i12);
        }
        this.length -= i11;
    }

    private final int z(int i10, int i11, Collection<? extends E> collection, boolean z10) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            int z11 = listBuilder.z(i10, i11, collection, z10);
            this.length -= z11;
            return z11;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int i14 = i10 + i12;
            if (collection.contains(this.f32038array[i14]) == z10) {
                E[] eArr = this.f32038array;
                i12++;
                eArr[i13 + i10] = eArr[i14];
                i13++;
            } else {
                i12++;
            }
        }
        int i15 = i11 - i13;
        E[] eArr2 = this.f32038array;
        Object[] unused = k.g(eArr2, eArr2, i10 + i13, i11 + i10, this.length);
        E[] eArr3 = this.f32038array;
        int i16 = this.length;
        b.g(eArr3, i16 - i15, i16);
        this.length -= i15;
        return i15;
    }

    public boolean add(E e10) {
        p();
        n(this.offset + this.length, e10);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        j.g(collection, "elements");
        p();
        int size = collection.size();
        m(this.offset + this.length, collection, size);
        return size > 0;
    }

    public int b() {
        return this.length;
    }

    public void clear() {
        p();
        y(this.offset, this.length);
    }

    public E d(int i10) {
        p();
        kotlin.collections.b.f32031a.b(i10, this.length);
        return w(this.offset + i10);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof List) && q((List) obj));
    }

    public E get(int i10) {
        kotlin.collections.b.f32031a.b(i10, this.length);
        return this.f32038array[this.offset + i10];
    }

    public int hashCode() {
        return b.i(this.f32038array, this.offset, this.length);
    }

    public int indexOf(Object obj) {
        for (int i10 = 0; i10 < this.length; i10++) {
            if (j.b(this.f32038array[this.offset + i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public Iterator<E> iterator() {
        return new a(this, 0);
    }

    public int lastIndexOf(Object obj) {
        for (int i10 = this.length - 1; i10 >= 0; i10--) {
            if (j.b(this.f32038array[this.offset + i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    public ListIterator<E> listIterator() {
        return new a(this, 0);
    }

    public final List<E> o() {
        if (this.backing == null) {
            p();
            this.isReadOnly = true;
            return this;
        }
        throw new IllegalStateException();
    }

    public boolean remove(Object obj) {
        p();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        if (indexOf >= 0) {
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        j.g(collection, "elements");
        p();
        if (z(this.offset, this.length, collection, false) > 0) {
            return true;
        }
        return false;
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        j.g(collection, "elements");
        p();
        if (z(this.offset, this.length, collection, true) > 0) {
            return true;
        }
        return false;
    }

    public E set(int i10, E e10) {
        p();
        kotlin.collections.b.f32031a.b(i10, this.length);
        E[] eArr = this.f32038array;
        int i11 = this.offset;
        E e11 = eArr[i11 + i10];
        eArr[i11 + i10] = e10;
        return e11;
    }

    public List<E> subList(int i10, int i11) {
        ListBuilder<E> listBuilder;
        kotlin.collections.b.f32031a.d(i10, i11, this.length);
        E[] eArr = this.f32038array;
        int i12 = this.offset + i10;
        int i13 = i11 - i10;
        boolean z10 = this.isReadOnly;
        ListBuilder<E> listBuilder2 = this.root;
        if (listBuilder2 == null) {
            listBuilder = this;
        } else {
            listBuilder = listBuilder2;
        }
        return new ListBuilder(eArr, i12, i13, z10, this, listBuilder);
    }

    public <T> T[] toArray(T[] tArr) {
        j.g(tArr, "destination");
        int length2 = tArr.length;
        int i10 = this.length;
        if (length2 < i10) {
            E[] eArr = this.f32038array;
            int i11 = this.offset;
            T[] copyOfRange = Arrays.copyOfRange(eArr, i11, i10 + i11, tArr.getClass());
            j.f(copyOfRange, "copyOfRange(array, offse…h, destination.javaClass)");
            return copyOfRange;
        }
        E[] eArr2 = this.f32038array;
        int i12 = this.offset;
        Object[] unused = k.g(eArr2, tArr, 0, i12, i10 + i12);
        int length3 = tArr.length;
        int i13 = this.length;
        if (length3 > i13) {
            tArr[i13] = null;
        }
        return tArr;
    }

    public String toString() {
        return b.j(this.f32038array, this.offset, this.length);
    }

    public ListIterator<E> listIterator(int i10) {
        kotlin.collections.b.f32031a.c(i10, this.length);
        return new a(this, i10);
    }

    public void add(int i10, E e10) {
        p();
        kotlin.collections.b.f32031a.c(i10, this.length);
        n(this.offset + i10, e10);
    }

    public boolean addAll(int i10, Collection<? extends E> collection) {
        j.g(collection, "elements");
        p();
        kotlin.collections.b.f32031a.c(i10, this.length);
        int size = collection.size();
        m(this.offset + i10, collection, size);
        return size > 0;
    }

    public Object[] toArray() {
        E[] eArr = this.f32038array;
        int i10 = this.offset;
        return k.k(eArr, i10, this.length + i10);
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i10) {
        this(b.d(i10), 0, 0, false, (ListBuilder) null, (ListBuilder) null);
    }
}
