package hk;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.builders.MapBuilder;
import kotlin.collections.c;
import kotlin.jvm.internal.j;

public final class e<V> extends c<V> {

    /* renamed from: a  reason: collision with root package name */
    private final MapBuilder<?, V> f29749a;

    public e(MapBuilder<?, V> mapBuilder) {
        j.g(mapBuilder, "backing");
        this.f29749a = mapBuilder;
    }

    public boolean add(V v10) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends V> collection) {
        j.g(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public int b() {
        return this.f29749a.size();
    }

    public void clear() {
        this.f29749a.clear();
    }

    public boolean contains(Object obj) {
        return this.f29749a.containsValue(obj);
    }

    public boolean isEmpty() {
        return this.f29749a.isEmpty();
    }

    public Iterator<V> iterator() {
        return this.f29749a.Q();
    }

    public boolean remove(Object obj) {
        return this.f29749a.P(obj);
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        j.g(collection, "elements");
        this.f29749a.k();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        j.g(collection, "elements");
        this.f29749a.k();
        return super.retainAll(collection);
    }
}
