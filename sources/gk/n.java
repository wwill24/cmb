package gk;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class n implements Collection<m>, qk.a {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f29706a;

    private static final class a implements Iterator<m>, qk.a {

        /* renamed from: a  reason: collision with root package name */
        private final long[] f29707a;

        /* renamed from: b  reason: collision with root package name */
        private int f29708b;

        public a(long[] jArr) {
            j.g(jArr, "array");
            this.f29707a = jArr;
        }

        public long a() {
            int i10 = this.f29708b;
            long[] jArr = this.f29707a;
            if (i10 < jArr.length) {
                this.f29708b = i10 + 1;
                return m.b(jArr[i10]);
            }
            throw new NoSuchElementException(String.valueOf(this.f29708b));
        }

        public boolean hasNext() {
            return this.f29708b < this.f29707a.length;
        }

        public /* bridge */ /* synthetic */ Object next() {
            return m.a(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ n(long[] jArr) {
        this.f29706a = jArr;
    }

    public static final /* synthetic */ n b(long[] jArr) {
        return new n(jArr);
    }

    public static boolean f(long[] jArr, long j10) {
        return l.u(jArr, j10);
    }

    public static boolean g(long[] jArr, Collection<m> collection) {
        boolean z10;
        j.g(collection, "elements");
        if (!collection.isEmpty()) {
            for (T next : collection) {
                if (!(next instanceof m) || !l.u(jArr, ((m) next).h())) {
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

    public static boolean j(long[] jArr, Object obj) {
        return (obj instanceof n) && j.b(jArr, ((n) obj).s());
    }

    public static int n(long[] jArr) {
        return jArr.length;
    }

    public static int o(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public static boolean p(long[] jArr) {
        return jArr.length == 0;
    }

    public static Iterator<m> q(long[] jArr) {
        return new a(jArr);
    }

    public static String r(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + PropertyUtils.MAPPED_DELIM2;
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends m> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        return d(((m) obj).h());
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        j.g(collection, "elements");
        return g(this.f29706a, collection);
    }

    public boolean d(long j10) {
        return f(this.f29706a, j10);
    }

    public boolean equals(Object obj) {
        return j(this.f29706a, obj);
    }

    public int hashCode() {
        return o(this.f29706a);
    }

    public boolean isEmpty() {
        return p(this.f29706a);
    }

    public Iterator<m> iterator() {
        return q(this.f29706a);
    }

    /* renamed from: m */
    public int size() {
        return n(this.f29706a);
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

    public final /* synthetic */ long[] s() {
        return this.f29706a;
    }

    public Object[] toArray() {
        return e.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        j.g(tArr, "array");
        return e.b(this, tArr);
    }

    public String toString() {
        return r(this.f29706a);
    }
}
