package org.apache.commons.collections.iterators;

import java.util.ListIterator;
import org.apache.commons.collections.Unmodifiable;

public final class UnmodifiableListIterator implements ListIterator, Unmodifiable {
    private ListIterator iterator;

    private UnmodifiableListIterator(ListIterator listIterator) {
        this.iterator = listIterator;
    }

    public static ListIterator decorate(ListIterator listIterator) {
        if (listIterator == null) {
            throw new IllegalArgumentException("ListIterator must not be null");
        } else if (listIterator instanceof Unmodifiable) {
            return listIterator;
        } else {
            return new UnmodifiableListIterator(listIterator);
        }
    }

    public void add(Object obj) {
        throw new UnsupportedOperationException("add() is not supported");
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
        throw new UnsupportedOperationException("remove() is not supported");
    }

    public void set(Object obj) {
        throw new UnsupportedOperationException("set() is not supported");
    }
}
