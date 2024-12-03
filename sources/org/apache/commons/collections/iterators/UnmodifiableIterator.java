package org.apache.commons.collections.iterators;

import java.util.Iterator;
import org.apache.commons.collections.Unmodifiable;

public final class UnmodifiableIterator implements Iterator, Unmodifiable {
    private Iterator iterator;

    private UnmodifiableIterator(Iterator it) {
        this.iterator = it;
    }

    public static Iterator decorate(Iterator it) {
        if (it == null) {
            throw new IllegalArgumentException("Iterator must not be null");
        } else if (it instanceof Unmodifiable) {
            return it;
        } else {
            return new UnmodifiableIterator(it);
        }
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
}
