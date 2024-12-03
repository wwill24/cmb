package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public abstract class b<E> extends AbstractCollection<E> implements List<E> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f32031a = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(int i10, int i11, int i12) {
            if (i10 < 0 || i11 > i12) {
                throw new IndexOutOfBoundsException("startIndex: " + i10 + ", endIndex: " + i11 + ", size: " + i12);
            } else if (i10 > i11) {
                throw new IllegalArgumentException("startIndex: " + i10 + " > endIndex: " + i11);
            }
        }

        public final void b(int i10, int i11) {
            if (i10 < 0 || i10 >= i11) {
                throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
            }
        }

        public final void c(int i10, int i11) {
            if (i10 < 0 || i10 > i11) {
                throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
            }
        }

        public final void d(int i10, int i11, int i12) {
            if (i10 < 0 || i11 > i12) {
                throw new IndexOutOfBoundsException("fromIndex: " + i10 + ", toIndex: " + i11 + ", size: " + i12);
            } else if (i10 > i11) {
                throw new IllegalArgumentException("fromIndex: " + i10 + " > toIndex: " + i11);
            }
        }

        public final boolean e(Collection<?> collection, Collection<?> collection2) {
            j.g(collection, "c");
            j.g(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            for (Object b10 : collection) {
                if (!j.b(b10, it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int f(Collection<?> collection) {
            int i10;
            j.g(collection, "c");
            int i11 = 1;
            for (Object next : collection) {
                int i12 = i11 * 31;
                if (next != null) {
                    i10 = next.hashCode();
                } else {
                    i10 = 0;
                }
                i11 = i12 + i10;
            }
            return i11;
        }
    }

    /* renamed from: kotlin.collections.b$b  reason: collision with other inner class name */
    private class C0368b implements Iterator<E>, qk.a {

        /* renamed from: a  reason: collision with root package name */
        private int f32032a;

        public C0368b() {
        }

        /* access modifiers changed from: protected */
        public final int a() {
            return this.f32032a;
        }

        /* access modifiers changed from: protected */
        public final void c(int i10) {
            this.f32032a = i10;
        }

        public boolean hasNext() {
            return this.f32032a < b.this.size();
        }

        public E next() {
            if (hasNext()) {
                b<E> bVar = b.this;
                int i10 = this.f32032a;
                this.f32032a = i10 + 1;
                return bVar.get(i10);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private class c extends b<E>.defpackage.b implements ListIterator<E> {
        public c(int i10) {
            super();
            b.f32031a.c(i10, b.this.size());
            c(i10);
        }

        public void add(E e10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean hasPrevious() {
            return a() > 0;
        }

        public int nextIndex() {
            return a();
        }

        public E previous() {
            if (hasPrevious()) {
                b<E> bVar = b.this;
                c(a() - 1);
                return bVar.get(a());
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return a() - 1;
        }

        public void set(E e10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private static final class d<E> extends b<E> implements RandomAccess {

        /* renamed from: b  reason: collision with root package name */
        private final b<E> f32035b;

        /* renamed from: c  reason: collision with root package name */
        private final int f32036c;

        /* renamed from: d  reason: collision with root package name */
        private int f32037d;

        public d(b<? extends E> bVar, int i10, int i11) {
            j.g(bVar, "list");
            this.f32035b = bVar;
            this.f32036c = i10;
            b.f32031a.d(i10, i11, bVar.size());
            this.f32037d = i11 - i10;
        }

        public int b() {
            return this.f32037d;
        }

        public E get(int i10) {
            b.f32031a.b(i10, this.f32037d);
            return this.f32035b.get(this.f32036c + i10);
        }
    }

    protected b() {
    }

    public void add(int i10, E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        return f32031a.e(this, (Collection) obj);
    }

    public abstract E get(int i10);

    public int hashCode() {
        return f32031a.f(this);
    }

    public int indexOf(E e10) {
        int i10 = 0;
        for (Object b10 : this) {
            if (j.b(b10, e10)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public Iterator<E> iterator() {
        return new C0368b();
    }

    public int lastIndexOf(E e10) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (j.b(listIterator.previous(), e10)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public ListIterator<E> listIterator() {
        return new c(0);
    }

    public E remove(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public E set(int i10, E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<E> subList(int i10, int i11) {
        return new d(this, i10, i11);
    }

    public ListIterator<E> listIterator(int i10) {
        return new c(i10);
    }
}
