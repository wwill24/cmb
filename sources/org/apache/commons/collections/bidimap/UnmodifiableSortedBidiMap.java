package org.apache.commons.collections.bidimap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.OrderedBidiMap;
import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.SortedBidiMap;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.iterators.UnmodifiableOrderedMapIterator;
import org.apache.commons.collections.map.UnmodifiableEntrySet;
import org.apache.commons.collections.map.UnmodifiableSortedMap;
import org.apache.commons.collections.set.UnmodifiableSet;

public final class UnmodifiableSortedBidiMap extends AbstractSortedBidiMapDecorator implements Unmodifiable {
    private UnmodifiableSortedBidiMap inverse;

    private UnmodifiableSortedBidiMap(SortedBidiMap sortedBidiMap) {
        super(sortedBidiMap);
    }

    public static SortedBidiMap decorate(SortedBidiMap sortedBidiMap) {
        if (sortedBidiMap instanceof Unmodifiable) {
            return sortedBidiMap;
        }
        return new UnmodifiableSortedBidiMap(sortedBidiMap);
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Set entrySet() {
        return UnmodifiableEntrySet.decorate(super.entrySet());
    }

    public SortedMap headMap(Object obj) {
        return UnmodifiableSortedMap.decorate(getSortedBidiMap().headMap(obj));
    }

    public BidiMap inverseBidiMap() {
        return inverseSortedBidiMap();
    }

    public OrderedBidiMap inverseOrderedBidiMap() {
        return inverseSortedBidiMap();
    }

    public SortedBidiMap inverseSortedBidiMap() {
        if (this.inverse == null) {
            UnmodifiableSortedBidiMap unmodifiableSortedBidiMap = new UnmodifiableSortedBidiMap(getSortedBidiMap().inverseSortedBidiMap());
            this.inverse = unmodifiableSortedBidiMap;
            unmodifiableSortedBidiMap.inverse = this;
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
        return UnmodifiableOrderedMapIterator.decorate(getSortedBidiMap().orderedMapIterator());
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

    public SortedMap subMap(Object obj, Object obj2) {
        return UnmodifiableSortedMap.decorate(getSortedBidiMap().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return UnmodifiableSortedMap.decorate(getSortedBidiMap().tailMap(obj));
    }

    public Collection values() {
        return UnmodifiableCollection.decorate(super.values());
    }
}
