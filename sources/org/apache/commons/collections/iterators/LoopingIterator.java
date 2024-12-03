package org.apache.commons.collections.iterators;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableIterator;

public class LoopingIterator implements ResettableIterator {
    private Collection collection;
    private Iterator iterator;

    public LoopingIterator(Collection collection2) {
        if (collection2 != null) {
            this.collection = collection2;
            reset();
            return;
        }
        throw new NullPointerException("The collection must not be null");
    }

    public boolean hasNext() {
        return this.collection.size() > 0;
    }

    public Object next() {
        if (this.collection.size() != 0) {
            if (!this.iterator.hasNext()) {
                reset();
            }
            return this.iterator.next();
        }
        throw new NoSuchElementException("There are no elements for this iterator to loop on");
    }

    public void remove() {
        this.iterator.remove();
    }

    public void reset() {
        this.iterator = this.collection.iterator();
    }

    public int size() {
        return this.collection.size();
    }
}
