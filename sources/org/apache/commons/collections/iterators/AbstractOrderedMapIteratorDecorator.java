package org.apache.commons.collections.iterators;

import org.apache.commons.collections.OrderedMapIterator;

public class AbstractOrderedMapIteratorDecorator implements OrderedMapIterator {
    protected final OrderedMapIterator iterator;

    public AbstractOrderedMapIteratorDecorator(OrderedMapIterator orderedMapIterator) {
        if (orderedMapIterator != null) {
            this.iterator = orderedMapIterator;
            return;
        }
        throw new IllegalArgumentException("OrderedMapIterator must not be null");
    }

    public Object getKey() {
        return this.iterator.getKey();
    }

    /* access modifiers changed from: protected */
    public OrderedMapIterator getOrderedMapIterator() {
        return this.iterator;
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
        this.iterator.remove();
    }

    public Object setValue(Object obj) {
        return this.iterator.setValue(obj);
    }
}
