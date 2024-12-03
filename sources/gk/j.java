package gk;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.e;
import org.apache.commons.beanutils.PropertyUtils;

public final class j implements Collection<i>, qk.a {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f29696a;

    private static final class a implements Iterator<i>, qk.a {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f29697a;

        /* renamed from: b  reason: collision with root package name */
        private int f29698b;

        public a(byte[] bArr) {
            kotlin.jvm.internal.j.g(bArr, "array");
            this.f29697a = bArr;
        }

        public byte a() {
            int i10 = this.f29698b;
            byte[] bArr = this.f29697a;
            if (i10 < bArr.length) {
                this.f29698b = i10 + 1;
                return i.b(bArr[i10]);
            }
            throw new NoSuchElementException(String.valueOf(this.f29698b));
        }

        public boolean hasNext() {
            return this.f29698b < this.f29697a.length;
        }

        public /* bridge */ /* synthetic */ Object next() {
            return i.a(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ j(byte[] bArr) {
        this.f29696a = bArr;
    }

    public static final /* synthetic */ j b(byte[] bArr) {
        return new j(bArr);
    }

    public static boolean f(byte[] bArr, byte b10) {
        return l.r(bArr, b10);
    }

    public static boolean g(byte[] bArr, Collection<i> collection) {
        boolean z10;
        kotlin.jvm.internal.j.g(collection, "elements");
        if (!collection.isEmpty()) {
            for (T next : collection) {
                if (!(next instanceof i) || !l.r(bArr, ((i) next).h())) {
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

    public static boolean j(byte[] bArr, Object obj) {
        return (obj instanceof j) && kotlin.jvm.internal.j.b(bArr, ((j) obj).s());
    }

    public static int n(byte[] bArr) {
        return bArr.length;
    }

    public static int o(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static boolean p(byte[] bArr) {
        return bArr.length == 0;
    }

    public static Iterator<i> q(byte[] bArr) {
        return new a(bArr);
    }

    public static String r(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + PropertyUtils.MAPPED_DELIM2;
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends i> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        return d(((i) obj).h());
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        kotlin.jvm.internal.j.g(collection, "elements");
        return g(this.f29696a, collection);
    }

    public boolean d(byte b10) {
        return f(this.f29696a, b10);
    }

    public boolean equals(Object obj) {
        return j(this.f29696a, obj);
    }

    public int hashCode() {
        return o(this.f29696a);
    }

    public boolean isEmpty() {
        return p(this.f29696a);
    }

    public Iterator<i> iterator() {
        return q(this.f29696a);
    }

    /* renamed from: m */
    public int size() {
        return n(this.f29696a);
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

    public final /* synthetic */ byte[] s() {
        return this.f29696a;
    }

    public Object[] toArray() {
        return e.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        kotlin.jvm.internal.j.g(tArr, "array");
        return e.b(this, tArr);
    }

    public String toString() {
        return r(this.f29696a);
    }
}
