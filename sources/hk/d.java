package hk;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.builders.MapBuilder;
import kotlin.collections.e;
import kotlin.jvm.internal.j;

public final class d<E> extends e<E> {

    /* renamed from: a  reason: collision with root package name */
    private final MapBuilder<E, ?> f29748a;

    public d(MapBuilder<E, ?> mapBuilder) {
        j.g(mapBuilder, "backing");
        this.f29748a = mapBuilder;
    }

    public boolean add(E e10) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends E> collection) {
        j.g(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public int b() {
        return this.f29748a.size();
    }

    public void clear() {
        this.f29748a.clear();
    }

    public boolean contains(Object obj) {
        return this.f29748a.containsKey(obj);
    }

    public boolean isEmpty() {
        return this.f29748a.isEmpty();
    }

    public Iterator<E> iterator() {
        return this.f29748a.D();
    }

    public boolean remove(Object obj) {
        return this.f29748a.M(obj) >= 0;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        j.g(collection, "elements");
        this.f29748a.k();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        j.g(collection, "elements");
        this.f29748a.k();
        return super.retainAll(collection);
    }
}
