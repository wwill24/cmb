package org.apache.commons.collections.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableIterator;

public class ObjectArrayIterator implements Iterator, ResettableIterator {

    /* renamed from: array  reason: collision with root package name */
    protected Object[] f33513array;
    protected int endIndex;
    protected int index;
    protected int startIndex;

    public ObjectArrayIterator() {
        this.f33513array = null;
        this.startIndex = 0;
        this.endIndex = 0;
        this.index = 0;
    }

    public Object[] getArray() {
        return this.f33513array;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public boolean hasNext() {
        return this.index < this.endIndex;
    }

    public Object next() {
        if (hasNext()) {
            Object[] objArr = this.f33513array;
            int i10 = this.index;
            this.index = i10 + 1;
            return objArr[i10];
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() method is not supported for an ObjectArrayIterator");
    }

    public void reset() {
        this.index = this.startIndex;
    }

    public void setArray(Object[] objArr) {
        if (this.f33513array == null) {
            this.f33513array = objArr;
            this.startIndex = 0;
            this.endIndex = objArr.length;
            this.index = 0;
            return;
        }
        throw new IllegalStateException("The array to iterate over has already been set");
    }

    public ObjectArrayIterator(Object[] objArr) {
        this(objArr, 0, objArr.length);
    }

    public ObjectArrayIterator(Object[] objArr, int i10) {
        this(objArr, i10, objArr.length);
    }

    public ObjectArrayIterator(Object[] objArr, int i10, int i11) {
        this.f33513array = null;
        this.startIndex = 0;
        this.endIndex = 0;
        this.index = 0;
        if (i10 < 0) {
            throw new ArrayIndexOutOfBoundsException("Start index must not be less than zero");
        } else if (i11 > objArr.length) {
            throw new ArrayIndexOutOfBoundsException("End index must not be greater than the array length");
        } else if (i10 > objArr.length) {
            throw new ArrayIndexOutOfBoundsException("Start index must not be greater than the array length");
        } else if (i11 >= i10) {
            this.f33513array = objArr;
            this.startIndex = i10;
            this.endIndex = i11;
            this.index = i10;
        } else {
            throw new IllegalArgumentException("End index must not be less than start index");
        }
    }
}
