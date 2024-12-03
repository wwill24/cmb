package org.apache.commons.collections.iterators;

import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.Unmodifiable;

public final class UnmodifiableOrderedMapIterator implements OrderedMapIterator, Unmodifiable {
    private OrderedMapIterator iterator;

    private UnmodifiableOrderedMapIterator(OrderedMapIterator orderedMapIterator) {
        this.iterator = orderedMapIterator;
    }

    public static OrderedMapIterator decorate(OrderedMapIterator orderedMapIterator) {
        if (orderedMapIterator == null) {
            throw new IllegalArgumentException("OrderedMapIterator must not be null");
        } else if (orderedMapIterator instanceof Unmodifiable) {
            return orderedMapIterator;
        } else {
            return new UnmodifiableOrderedMapIterator(orderedMapIterator);
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

    public boolean hasPrevious() {
        return this.iterator.hasPrevious();
    }

    public Object next() {
        return this.iterator.next();
    }

    public Object previous() {
        return this.iterator.previous();
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }

    public Object setValue(Object obj) {
        throw new UnsupportedOperationException("setValue() is not supported");
    }
}
