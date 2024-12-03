package org.apache.commons.collections.iterators;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableListIterator;

public class SingletonListIterator implements ListIterator, ResettableListIterator {
    private boolean beforeFirst = true;
    private boolean nextCalled = false;
    private Object object;
    private boolean removed = false;

    public SingletonListIterator(Object obj) {
        this.object = obj;
    }

    public void add(Object obj) {
        throw new UnsupportedOperationException("add() is not supported by this iterator");
    }

    public boolean hasNext() {
        return this.beforeFirst && !this.removed;
    }

    public boolean hasPrevious() {
        return !this.beforeFirst && !this.removed;
    }

    public Object next() {
        if (!this.beforeFirst || this.removed) {
            throw new NoSuchElementException();
        }
        this.beforeFirst = false;
        this.nextCalled = true;
        return this.object;
    }

    public int nextIndex() {
        return this.beforeFirst ^ true ? 1 : 0;
    }

    public Object previous() {
        if (this.beforeFirst || this.removed) {
            throw new NoSuchElementException();
        }
        this.beforeFirst = true;
        return this.object;
    }

    public int previousIndex() {
        return this.beforeFirst ? -1 : 0;
    }

    public void remove() {
        if (!this.nextCalled || this.removed) {
            throw new IllegalStateException();
        }
        this.object = null;
        this.removed = true;
    }

    public void reset() {
        this.beforeFirst = true;
        this.nextCalled = false;
    }

    public void set(Object obj) {
        if (!this.nextCalled || this.removed) {
            throw new IllegalStateException();
        }
        this.object = obj;
    }
}
