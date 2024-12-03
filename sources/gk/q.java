package gk;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class q implements Collection<p>, qk.a {

    /* renamed from: a  reason: collision with root package name */
    private final short[] f29712a;

    private static final class a implements Iterator<p>, qk.a {

        /* renamed from: a  reason: collision with root package name */
        private final short[] f29713a;

        /* renamed from: b  reason: collision with root package name */
        private int f29714b;

        public a(short[] sArr) {
            j.g(sArr, "array");
            this.f29713a = sArr;
        }

        public short a() {
            int i10 = this.f29714b;
            short[] sArr = this.f29713a;
            if (i10 < sArr.length) {
                this.f29714b = i10 + 1;
                return p.b(sArr[i10]);
            }
            throw new NoSuchElementException(String.valueOf(this.f29714b));
        }

        public boolean hasNext() {
            return this.f29714b < this.f29713a.length;
        }

        public /* bridge */ /* synthetic */ Object next() {
            return p.a(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ q(short[] sArr) {
        this.f29712a = sArr;
    }

    public static final /* synthetic */ q b(short[] sArr) {
        return new q(sArr);
    }

    public static boolean f(short[] sArr, short s10) {
        return l.w(sArr, s10);
    }

    public static boolean g(short[] sArr, Collection<p> collection) {
        boolean z10;
        j.g(collection, "elements");
        if (!collection.isEmpty()) {
            for (T next : collection) {
                if (!(next instanceof p) || !l.w(sArr, ((p) next).h())) {
                    z10 = false;
                    continue;
                } else {
                    z10 = true;
                    continue;
                }
                if (!z10) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean j(short[] sArr, Object obj) {
        return (obj instanceof q) && j.b(sArr, ((q) obj).s());
    }

    public static int n(short[] sArr) {
        return sArr.length;
    }

    public static int o(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static boolean p(short[] sArr) {
        return sArr.length == 0;
    }

    public static Iterator<p> q(short[] sArr) {
        return new a(sArr);
    }

    public static String r(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + PropertyUtils.MAPPED_DELIM2;
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends p> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        return d(((p) obj).h());
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        j.g(collection, "elements");
        return g(this.f29712a, collection);
    }

    public boolean d(short s10) {
        return f(this.f29712a, s10);
    }

    public boolean equals(Object obj) {
        return j(this.f29712a, obj);
    }

    public int hashCode() {
        return o(this.f29712a);
    }

    public boolean isEmpty() {
        return p(this.f29712a);
    }

    public Iterator<p> iterator() {
        return q(this.f29712a);
    }

    /* renamed from: m */
    public int size() {
        return n(this.f29712a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* synthetic */ short[] s() {
        return this.f29712a;
    }

    public Object[] toArray() {
        return e.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        j.g(tArr, "array");
        return e.b(this, tArr);
    }

    public String toString() {
        return r(this.f29712a);
    }
}
