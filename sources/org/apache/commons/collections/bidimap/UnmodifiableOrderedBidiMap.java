package org.apache.commons.collections.bidimap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.OrderedBidiMap;
import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.iterators.UnmodifiableOrderedMapIterator;
import org.apache.commons.collections.map.UnmodifiableEntrySet;
import org.apache.commons.collections.set.UnmodifiableSet;

public final class UnmodifiableOrderedBidiMap extends AbstractOrderedBidiMapDecorator implements Unmodifiable {
    private UnmodifiableOrderedBidiMap inverse;

    private UnmodifiableOrderedBidiMap(OrderedBidiMap orderedBidiMap) {
        super(orderedBidiMap);
    }

    public static OrderedBidiMap decorate(OrderedBidiMap orderedBidiMap) {
        if (orderedBidiMap instanceof Unmodifiable) {
            return orderedBidiMap;
        }
        return new UnmodifiableOrderedBidiMap(orderedBidiMap);
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Set entrySet() {
        return UnmodifiableEntrySet.decorate(super.entrySet());
    }

    public BidiMap inverseBidiMap() {
        return inverseOrderedBidiMap();
    }

    public OrderedBidiMap inverseOrderedBidiMap() {
        if (this.inverse == null) {
            UnmodifiableOrderedBidiMap unmodifiableOrderedBidiMap = new UnmodifiableOrderedBidiMap(getOrderedBidiMap().inverseOrderedBidiMap());
            this.inverse = unmodifiableOrderedBidiMap;
            unmodifiableOrderedBidiMap.inverse = this;
        }
        return this.inverse;
    }

    public Set keySet() {
        return UnmodifiableSet.decorate(super.keySet());
    }

    public MapIterator mapIterator() {
        return orderedMapIterator();
    }

    public OrderedMapIterator orderedMapIterator() {
        return UnmodifiableOrderedMapIterator.decorate(getOrderedBidiMap().orderedMapIterator());
    }

    public Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    public Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Object removeValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Collection values() {
        return UnmodifiableCollection.decorate(super.values());
    }
}
