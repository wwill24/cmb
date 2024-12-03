package org.apache.commons.collections.iterators;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableListIterator;

public class ObjectArrayListIterator extends ObjectArrayIterator implements ListIterator, ResettableListIterator {
    protected int lastItemIndex = -1;

    public ObjectArrayListIterator() {
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
            Object[] objArr = this.f33513array;
            this.index = i10 + 1;
            return objArr[i10];
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
            return this.f33513array[i10];
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
            this.f33513array[i10] = obj;
            return;
        }
        throw new IllegalStateException("must call next() or previous() before a call to set()");
    }

    public ObjectArrayListIterator(Object[] objArr) {
        super(objArr);
    }

    public ObjectArrayListIterator(Object[] objArr, int i10) {
        super(objArr, i10);
    }

    public ObjectArrayListIterator(Object[] objArr, int i10, int i11) {
        super(objArr, i10, i11);
    }
}
