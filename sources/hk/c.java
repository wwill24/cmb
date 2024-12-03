package hk;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.j;

public final class c<K, V> extends a<Map.Entry<K, V>, K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final MapBuilder<K, V> f29747a;

    public c(MapBuilder<K, V> mapBuilder) {
        j.g(mapBuilder, "backing");
        this.f29747a = mapBuilder;
    }

    public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
        j.g(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public int b() {
        return this.f29747a.size();
    }

    public void clear() {
        this.f29747a.clear();
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        j.g(collection, "elements");
        return this.f29747a.m(collection);
    }

    public boolean f(Map.Entry<? extends K, ? extends V> entry) {
        j.g(entry, "element");
        return this.f29747a.n(entry);
    }

    public boolean g(Map.Entry entry) {
        j.g(entry, "element");
        return this.f29747a.K(entry);
    }

    public boolean isEmpty() {
        return this.f29747a.isEmpty();
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return this.f29747a.r();
    }

    /* renamed from: j */
    public boolean add(Map.Entry<K, V> entry) {
        j.g(entry, "element");
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        j.g(collection, "elements");
        this.f29747a.k();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        j.g(collection, "elements");
        this.f29747a.k();
        return super.retainAll(collection);
    }
}
