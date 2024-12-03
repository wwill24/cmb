package org.apache.commons.collections.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableIterator;

public class SingletonIterator implements Iterator, ResettableIterator {
    private boolean beforeFirst;
    private Object object;
    private final boolean removeAllowed;
    private boolean removed;

    public SingletonIterator(Object obj) {
        this(obj, true);
    }

    public boolean hasNext() {
        return this.beforeFirst && !this.removed;
    }

    public Object next() {
        if (!this.beforeFirst || this.removed) {
            throw new NoSuchElementException();
        }
        this.beforeFirst = false;
        return this.object;
    }

    public void remove() {
        if (!this.removeAllowed) {
            throw new UnsupportedOperationException();
        } else if (this.removed || this.beforeFirst) {
            throw new IllegalStateException();
        } else {
            this.object = null;
            this.removed = true;
        }
    }

    public void reset() {
        this.beforeFirst = true;
    }

    public SingletonIterator(Object obj, boolean z10) {
        this.beforeFirst = true;
        this.removed = false;
        this.object = obj;
        this.removeAllowed = z10;
    }
}
