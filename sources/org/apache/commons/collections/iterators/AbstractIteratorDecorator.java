package org.apache.commons.collections.iterators;

import java.util.Iterator;

public class AbstractIteratorDecorator implements Iterator {
    protected final Iterator iterator;

    public AbstractIteratorDecorator(Iterator it) {
        if (it != null) {
            this.iterator = it;
            return;
        }
        throw new IllegalArgumentException("Iterator must not be null");
    }

    /* access modifiers changed from: protected */
    public Iterator getIterator() {
        return this.iterator;
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
}
