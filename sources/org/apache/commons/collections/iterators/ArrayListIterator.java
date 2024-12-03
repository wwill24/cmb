package org.apache.commons.collections.iterators;

import java.lang.reflect.Array;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableListIterator;

public class ArrayListIterator extends ArrayIterator implements ListIterator, ResettableListIterator {
    protected int lastItemIndex = -1;

    public ArrayListIterator() {
    }

    public void add(Object obj) {
        throw new UnsupportedOperationException("add() method is not supported");
    }

    public boolean hasPrevious() {
        return this.index > this.startIndex;
    }

    public Object next() {
        if (hasNext()) {
            int i10 = this.index;
            this.lastItemIndex = i10;
            Object obj = this.f33512array;
            this.index = i10 + 1;
            return Array.get(obj, i10);
        }
        throw new NoSuchElementException();
    }

    public int nextIndex() {
        return this.index - this.startIndex;
    }

    public Object previous() {
        if (hasPrevious()) {
            int i10 = this.index - 1;
            this.index = i10;
            this.lastItemIndex = i10;
            return Array.get(this.f33512array, i10);
        }
        throw new NoSuchElementException();
    }

    public int previousIndex() {
        return (this.index - this.startIndex) - 1;
    }

    public void reset() {
        super.reset();
        this.lastItemIndex = -1;
    }

    public void set(Object obj) {
        int i10 = this.lastItemIndex;
        if (i10 != -1) {
            Array.set(this.f33512array, i10, obj);
            return;
        }
        throw new IllegalStateException("must call next() or previous() before a call to set()");
    }

    public ArrayListIterator(Object obj) {
        super(obj);
    }

    public ArrayListIterator(Object obj, int i10) {
        super(obj, i10);
        this.startIndex = i10;
    }

    public ArrayListIterator(Object obj, int i10, int i11) {
        super(obj, i10, i11);
        this.startIndex = i10;
    }
}
