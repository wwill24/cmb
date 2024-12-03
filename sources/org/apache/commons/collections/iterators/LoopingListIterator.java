package org.apache.commons.collections.iterators;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableListIterator;

public class LoopingListIterator implements ResettableListIterator {
    private ListIterator iterator;
    private List list;

    public LoopingListIterator(List list2) {
        if (list2 != null) {
            this.list = list2;
            reset();
            return;
        }
        throw new NullPointerException("The list must not be null");
    }

    public void add(Object obj) {
        this.iterator.add(obj);
    }

    public boolean hasNext() {
        return !this.list.isEmpty();
    }

    public boolean hasPrevious() {
        return !this.list.isEmpty();
    }

    public Object next() {
        if (!this.list.isEmpty()) {
            if (!this.iterator.hasNext()) {
                reset();
            }
            return this.iterator.next();
        }
        throw new NoSuchElementException("There are no elements for this iterator to loop on");
    }

    public int nextIndex() {
        if (this.list.isEmpty()) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        } else if (!this.iterator.hasNext()) {
            return 0;
        } else {
            return this.iterator.nextIndex();
        }
    }

    public Object previous() {
        if (this.list.isEmpty()) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        } else if (this.iterator.hasPrevious()) {
            return this.iterator.previous();
        } else {
            Object obj = null;
            while (this.iterator.hasNext()) {
                obj = this.iterator.next();
            }
            this.iterator.previous();
            return obj;
        }
    }

    public int previousIndex() {
        if (this.list.isEmpty()) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        } else if (!this.iterator.hasPrevious()) {
            return this.list.size() - 1;
        } else {
            return this.iterator.previousIndex();
        }
    }

    public void remove() {
        this.iterator.remove();
    }

    public void reset() {
        this.iterator = this.list.listIterator();
    }

    public void set(Object obj) {
        this.iterator.set(obj);
    }

    public int size() {
        return this.list.size();
    }
}
