package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.b;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import qk.a;

final class f<T> implements Collection<T>, a {

    /* renamed from: a  reason: collision with root package name */
    private final T[] f32050a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f32051b;

    public f(T[] tArr, boolean z10) {
        j.g(tArr, "values");
        this.f32050a = tArr;
        this.f32051b = z10;
    }

    public boolean add(T t10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int b() {
        return this.f32050a.length;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object obj) {
        return l.v(this.f32050a, obj);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        j.g(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.f32050a.length == 0;
    }

    public Iterator<T> iterator() {
        return b.a(this.f32050a);
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

    public final /* bridge */ int size() {
        return b();
    }

    public final Object[] toArray() {
        return p.b(this.f32050a, this.f32051b);
    }

    public <T> T[] toArray(T[] tArr) {
        j.g(tArr, "array");
        return e.b(this, tArr);
    }
}
