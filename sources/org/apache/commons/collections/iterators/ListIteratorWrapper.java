package org.apache.commons.collections.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableListIterator;

public class ListIteratorWrapper implements ResettableListIterator {
    private static final String UNSUPPORTED_OPERATION_MESSAGE = "ListIteratorWrapper does not support optional operations of ListIterator.";
    private int currentIndex = 0;
    private final Iterator iterator;
    private final List list = new ArrayList();
    private int wrappedIteratorIndex = 0;

    public ListIteratorWrapper(Iterator it) {
        if (it != null) {
            this.iterator = it;
            return;
        }
        throw new NullPointerException("Iterator must not be null");
    }

    public void add(Object obj) throws UnsupportedOperationException {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public boolean hasNext() {
        if (this.currentIndex == this.wrappedIteratorIndex) {
            return this.iterator.hasNext();
        }
        return true;
    }

    public boolean hasPrevious() {
        return this.currentIndex != 0;
    }

    public Object next() throws NoSuchElementException {
        int i10 = this.currentIndex;
        if (i10 < this.wrappedIteratorIndex) {
            int i11 = i10 + 1;
            this.currentIndex = i11;
            return this.list.get(i11 - 1);
        }
        Object next = this.iterator.next();
        this.list.add(next);
        this.currentIndex++;
        this.wrappedIteratorIndex++;
        return next;
    }

    public int nextIndex() {
        return this.currentIndex;
    }

    public Object previous() throws NoSuchElementException {
        int i10 = this.currentIndex;
        if (i10 != 0) {
            int i11 = i10 - 1;
            this.currentIndex = i11;
            return this.list.get(i11);
        }
        throw new NoSuchElementException();
    }

    public int previousIndex() {
        return this.currentIndex - 1;
    }

    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    public void reset() {
        this.currentIndex = 0;
    }

    public void set(Object obj) throws UnsupportedOperationException {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }
}
