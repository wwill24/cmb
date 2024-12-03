package org.apache.commons.collections.iterators;

import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.ResettableListIterator;

public class ReverseListIterator implements ResettableListIterator {
    private ListIterator iterator;
    private final List list;
    private boolean validForUpdate = true;

    public ReverseListIterator(List list2) {
        this.list = list2;
        this.iterator = list2.listIterator(list2.size());
    }

    public void add(Object obj) {
        if (this.validForUpdate) {
            this.validForUpdate = false;
            this.iterator.add(obj);
            this.iterator.previous();
            return;
        }
        throw new IllegalStateException("Cannot add to list until next() or previous() called");
    }

    public boolean hasNext() {
        return this.iterator.hasPrevious();
    }

    public boolean hasPrevious() {
        return this.iterator.hasNext();
    }

    public Object next() {
        Object previous = this.iterator.previous();
        this.validForUpdate = true;
        return previous;
    }

    public int nextIndex() {
        return this.iterator.previousIndex();
    }

    public Object previous() {
        Object next = this.iterator.next();
        this.validForUpdate = true;
        return next;
    }

    public int previousIndex() {
        return this.iterator.nextIndex();
    }

    public void remove() {
        if (this.validForUpdate) {
            this.iterator.remove();
            return;
        }
        throw new IllegalStateException("Cannot remove from list until next() or previous() called");
    }

    public void reset() {
        List list2 = this.list;
        this.iterator = list2.listIterator(list2.size());
    }

    public void set(Object obj) {
        if (this.validForUpdate) {
            this.iterator.set(obj);
            return;
        }
        throw new IllegalStateException("Cannot set to list until next() or previous() called");
    }
}
