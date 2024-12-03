package org.apache.commons.collections.iterators;

import org.apache.commons.collections.MapIterator;

public class AbstractMapIteratorDecorator implements MapIterator {
    protected final MapIterator iterator;

    public AbstractMapIteratorDecorator(MapIterator mapIterator) {
        if (mapIterator != null) {
            this.iterator = mapIterator;
            return;
        }
        throw new IllegalArgumentException("MapIterator must not be null");
    }

    public Object getKey() {
        return this.iterator.getKey();
    }

    /* access modifiers changed from: protected */
    public MapIterator getMapIterator() {
        return this.iterator;
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
        this.iterator.remove();
    }

    public Object setValue(Object obj) {
        return this.iterator.setValue(obj);
    }
}
