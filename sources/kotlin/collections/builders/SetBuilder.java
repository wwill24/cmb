package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.e;
import kotlin.jvm.internal.j;

public final class SetBuilder<E> extends e<E> implements Serializable {
    private final MapBuilder<E, ?> backing;

    public SetBuilder(MapBuilder<E, ?> mapBuilder) {
        j.g(mapBuilder, "backing");
        this.backing = mapBuilder;
    }

    private final Object writeReplace() {
        if (this.backing.C()) {
            return new SerializedCollection(this, 1);
        }
        throw new NotSerializableException("The set cannot be serialized while it is being built.");
    }

    public boolean add(E e10) {
        return this.backing.g(e10) >= 0;
    }

    public boolean addAll(Collection<? extends E> collection) {
        j.g(collection, "elements");
        this.backing.k();
        return super.addAll(collection);
    }

    public int b() {
        return this.backing.size();
    }

    public void clear() {
        this.backing.clear();
    }

    public boolean contains(Object obj) {
        return this.backing.containsKey(obj);
    }

    public final Set<E> d() {
        this.backing.j();
        return this;
    }

    public boolean isEmpty() {
        return this.backing.isEmpty();
    }

    public Iterator<E> iterator() {
        return this.backing.D();
    }

    public boolean remove(Object obj) {
        return this.backing.M(obj) >= 0;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        j.g(collection, "elements");
        this.backing.k();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        j.g(collection, "elements");
        this.backing.k();
        return super.retainAll(collection);
    }

    public SetBuilder() {
        this(new MapBuilder());
    }

    public SetBuilder(int i10) {
        this(new MapBuilder(i10));
    }
}
