package org.apache.commons.collections.iterators;

import java.util.ListIterator;

public class AbstractListIteratorDecorator implements ListIterator {
    protected final ListIterator iterator;

    public AbstractListIteratorDecorator(ListIterator listIterator) {
        if (listIterator != null) {
            this.iterator = listIterator;
            return;
        }
        throw new IllegalArgumentException("ListIterator must not be null");
    }

    public void add(Object obj) {
        this.iterator.add(obj);
    }

    /* access modifiers changed from: protected */
    public ListIterator getListIterator() {
        return this.iterator;
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

    public int nextIndex() {
        return this.iterator.nextIndex();
    }

    public Object previous() {
        return this.iterator.previous();
    }

    public int previousIndex() {
        return this.iterator.previousIndex();
    }

    public void remove() {
        this.iterator.remove();
    }

    public void set(Object obj) {
        this.iterator.set(obj);
    }
}
