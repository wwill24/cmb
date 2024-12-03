package org.apache.commons.collections.iterators;

import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.Unmodifiable;

public final class UnmodifiableMapIterator implements MapIterator, Unmodifiable {
    private MapIterator iterator;

    private UnmodifiableMapIterator(MapIterator mapIterator) {
        this.iterator = mapIterator;
    }

    public static MapIterator decorate(MapIterator mapIterator) {
        if (mapIterator == null) {
            throw new IllegalArgumentException("MapIterator must not be null");
        } else if (mapIterator instanceof Unmodifiable) {
            return mapIterator;
        } else {
            return new UnmodifiableMapIterator(mapIterator);
        }
    }

    public Object getKey() {
        return this.iterator.getKey();
    }

    public Object getValue() {
        return this.iterator.getValue();
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public Object next() {
        return this.iterator.next();
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }

    public Object setValue(Object obj) {
        throw new UnsupportedOperationException("setValue() is not supported");
    }
}
