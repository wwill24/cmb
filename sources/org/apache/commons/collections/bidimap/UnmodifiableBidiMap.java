package org.apache.commons.collections.bidimap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections.map.UnmodifiableEntrySet;
import org.apache.commons.collections.set.UnmodifiableSet;

public final class UnmodifiableBidiMap extends AbstractBidiMapDecorator implements Unmodifiable {
    private UnmodifiableBidiMap inverse;

    private UnmodifiableBidiMap(BidiMap bidiMap) {
        super(bidiMap);
    }

    public static BidiMap decorate(BidiMap bidiMap) {
        if (bidiMap instanceof Unmodifiable) {
            return bidiMap;
        }
        return new UnmodifiableBidiMap(bidiMap);
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Set entrySet() {
        return UnmodifiableEntrySet.decorate(super.entrySet());
    }

    public BidiMap inverseBidiMap() {
        if (this.inverse == null) {
            UnmodifiableBidiMap unmodifiableBidiMap = new UnmodifiableBidiMap(getBidiMap().inverseBidiMap());
            this.inverse = unmodifiableBidiMap;
            unmodifiableBidiMap.inverse = this;
        }
        return this.inverse;
    }

    public Set keySet() {
        return UnmodifiableSet.decorate(super.keySet());
    }

    public MapIterator mapIterator() {
        return UnmodifiableMapIterator.decorate(getBidiMap().mapIterator());
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
