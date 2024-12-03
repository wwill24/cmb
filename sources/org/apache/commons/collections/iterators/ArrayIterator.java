package org.apache.commons.collections.iterators;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableIterator;

public class ArrayIterator implements ResettableIterator {

    /* renamed from: array  reason: collision with root package name */
    protected Object f33512array;
    protected int endIndex = 0;
    protected int index = 0;
    protected int startIndex = 0;

    public ArrayIterator() {
    }

    /* access modifiers changed from: protected */
    public void checkBound(int i10, String str) {
        if (i10 > this.endIndex) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Attempt to make an ArrayIterator that ");
            stringBuffer.append(str);
            stringBuffer.append("s beyond the end of the array. ");
            throw new ArrayIndexOutOfBoundsException(stringBuffer.toString());
        } else if (i10 < 0) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Attempt to make an ArrayIterator that ");
            stringBuffer2.append(str);
            stringBuffer2.append("s before the start of the array. ");
            throw new ArrayIndexOutOfBoundsException(stringBuffer2.toString());
        }
    }

    public Object getArray() {
        return this.f33512array;
    }

    public boolean hasNext() {
        return this.index < this.endIndex;
    }

    public Object next() {
        if (hasNext()) {
            Object obj = this.f33512array;
            int i10 = this.index;
            this.index = i10 + 1;
            return Array.get(obj, i10);
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() method is not supported");
    }

    public void reset() {
        this.index = this.startIndex;
    }

    public void setArray(Object obj) {
        this.endIndex = Array.getLength(obj);
        this.startIndex = 0;
        this.f33512array = obj;
        this.index = 0;
    }

    public ArrayIterator(Object obj) {
        setArray(obj);
    }

    public ArrayIterator(Object obj, int i10) {
        setArray(obj);
        checkBound(i10, "start");
        this.startIndex = i10;
        this.index = i10;
    }

    public ArrayIterator(Object obj, int i10, int i11) {
        setArray(obj);
        checkBound(i10, "start");
        checkBound(i11, "end");
        if (i11 >= i10) {
            this.startIndex = i10;
            this.endIndex = i11;
            this.index = i10;
            return;
        }
        throw new IllegalArgumentException("End index must not be less than start index.");
    }
}
