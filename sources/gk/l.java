package gk;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class l implements Collection<k>, qk.a {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f29701a;

    private static final class a implements Iterator<k>, qk.a {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f29702a;

        /* renamed from: b  reason: collision with root package name */
        private int f29703b;

        public a(int[] iArr) {
            j.g(iArr, "array");
            this.f29702a = iArr;
        }

        public int a() {
            int i10 = this.f29703b;
            int[] iArr = this.f29702a;
            if (i10 < iArr.length) {
                this.f29703b = i10 + 1;
                return k.b(iArr[i10]);
            }
            throw new NoSuchElementException(String.valueOf(this.f29703b));
        }

        public boolean hasNext() {
            return this.f29703b < this.f29702a.length;
        }

        public /* bridge */ /* synthetic */ Object next() {
            return k.a(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ l(int[] iArr) {
        this.f29701a = iArr;
    }

    public static final /* synthetic */ l b(int[] iArr) {
        return new l(iArr);
    }

    public static boolean f(int[] iArr, int i10) {
        return l.t(iArr, i10);
    }

    public static boolean g(int[] iArr, Collection<k> collection) {
        boolean z10;
        j.g(collection, "elements");
        if (!collection.isEmpty()) {
            for (T next : collection) {
                if (!(next instanceof k) || !l.t(iArr, ((k) next).h())) {
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

    public static boolean j(int[] iArr, Object obj) {
        return (obj instanceof l) && j.b(iArr, ((l) obj).s());
    }

    public static int n(int[] iArr) {
        return iArr.length;
    }

    public static int o(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static boolean p(int[] iArr) {
        return iArr.length == 0;
    }

    public static Iterator<k> q(int[] iArr) {
        return new a(iArr);
    }

    public static String r(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + PropertyUtils.MAPPED_DELIM2;
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends k> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        return d(((k) obj).h());
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        j.g(collection, "elements");
        return g(this.f29701a, collection);
    }

    public boolean d(int i10) {
        return f(this.f29701a, i10);
    }

    public boolean equals(Object obj) {
        return j(this.f29701a, obj);
    }

    public int hashCode() {
        return o(this.f29701a);
    }

    public boolean isEmpty() {
        return p(this.f29701a);
    }

    public Iterator<k> iterator() {
        return q(this.f29701a);
    }

    /* renamed from: m */
    public int size() {
        return n(this.f29701a);
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

    public final /* synthetic */ int[] s() {
        return this.f29701a;
    }

    public Object[] toArray() {
        return e.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        j.g(tArr, "array");
        return e.b(this, tArr);
    }

    public String toString() {
        return r(this.f29701a);
    }
}
