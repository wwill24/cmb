package org.apache.commons.collections;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BoundedFifoBuffer extends AbstractCollection implements Buffer, BoundedCollection {
    /* access modifiers changed from: private */
    public final Object[] m_elements;
    /* access modifiers changed from: private */
    public int m_end;
    /* access modifiers changed from: private */
    public boolean m_full;
    /* access modifiers changed from: private */
    public int m_start;
    /* access modifiers changed from: private */
    public final int maxElements;

    public BoundedFifoBuffer() {
        this(32);
    }

    /* access modifiers changed from: private */
    public int decrement(int i10) {
        int i11 = i10 - 1;
        return i11 < 0 ? this.maxElements - 1 : i11;
    }

    /* access modifiers changed from: private */
    public int increment(int i10) {
        int i11 = i10 + 1;
        if (i11 >= this.maxElements) {
            return 0;
        }
        return i11;
    }

    public boolean add(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Attempted to add null object to buffer");
        } else if (!this.m_full) {
            Object[] objArr = this.m_elements;
            int i10 = this.m_end;
            int i11 = i10 + 1;
            this.m_end = i11;
            objArr[i10] = obj;
            if (i11 >= this.maxElements) {
                this.m_end = 0;
            }
            if (this.m_end == this.m_start) {
                this.m_full = true;
            }
            return true;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("The buffer cannot hold more than ");
            stringBuffer.append(this.maxElements);
            stringBuffer.append(" objects.");
            throw new BufferOverflowException(stringBuffer.toString());
        }
    }

    public void clear() {
        this.m_full = false;
        this.m_start = 0;
        this.m_end = 0;
        Arrays.fill(this.m_elements, (Object) null);
    }

    public Object get() {
        if (!isEmpty()) {
            return this.m_elements[this.m_start];
        }
        throw new BufferUnderflowException("The buffer is already empty");
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == this.maxElements;
    }

    public Iterator iterator() {
        return new Iterator() {
            private int index;
            private boolean isFirst;
            private int lastReturnedIndex = -1;

            {
                this.index = BoundedFifoBuffer.this.m_start;
                this.isFirst = BoundedFifoBuffer.this.m_full;
            }

            public boolean hasNext() {
                return this.isFirst || this.index != BoundedFifoBuffer.this.m_end;
            }

            public Object next() {
                if (hasNext()) {
                    this.isFirst = false;
                    int i10 = this.index;
                    this.lastReturnedIndex = i10;
                    this.index = BoundedFifoBuffer.this.increment(i10);
                    return BoundedFifoBuffer.this.m_elements[this.lastReturnedIndex];
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                int i10 = this.lastReturnedIndex;
                if (i10 == -1) {
                    throw new IllegalStateException();
                } else if (i10 == BoundedFifoBuffer.this.m_start) {
                    BoundedFifoBuffer.this.remove();
                    this.lastReturnedIndex = -1;
                } else {
                    int i11 = this.lastReturnedIndex + 1;
                    while (i11 != BoundedFifoBuffer.this.m_end) {
                        if (i11 >= BoundedFifoBuffer.this.maxElements) {
                            BoundedFifoBuffer.this.m_elements[i11 - 1] = BoundedFifoBuffer.this.m_elements[0];
                            i11 = 0;
                        } else {
                            BoundedFifoBuffer.this.m_elements[i11 - 1] = BoundedFifoBuffer.this.m_elements[i11];
                            i11++;
                        }
                    }
                    this.lastReturnedIndex = -1;
                    BoundedFifoBuffer boundedFifoBuffer = BoundedFifoBuffer.this;
                    int unused = boundedFifoBuffer.m_end = boundedFifoBuffer.decrement(boundedFifoBuffer.m_end);
                    BoundedFifoBuffer.this.m_elements[BoundedFifoBuffer.this.m_end] = null;
                    boolean unused2 = BoundedFifoBuffer.this.m_full = false;
                    this.index = BoundedFifoBuffer.this.decrement(this.index);
                }
            }
        };
    }

    public int maxSize() {
        return this.maxElements;
    }

    public Object remove() {
        if (!isEmpty()) {
            Object[] objArr = this.m_elements;
            int i10 = this.m_start;
            Object obj = objArr[i10];
            if (obj != null) {
                int i11 = i10 + 1;
                this.m_start = i11;
                objArr[i10] = null;
                if (i11 >= this.maxElements) {
                    this.m_start = 0;
                }
                this.m_full = false;
            }
            return obj;
        }
        throw new BufferUnderflowException("The buffer is already empty");
    }

    public int size() {
        int i10;
        int i11 = this.m_end;
        int i12 = this.m_start;
        if (i11 < i12) {
            return (this.maxElements - i12) + i11;
        }
        if (i11 != i12) {
            return i11 - i12;
        }
        if (this.m_full) {
            i10 = this.maxElements;
        } else {
            i10 = 0;
        }
        return i10;
    }

    public BoundedFifoBuffer(int i10) {
        this.m_start = 0;
        this.m_end = 0;
        this.m_full = false;
        if (i10 > 0) {
            Object[] objArr = new Object[i10];
            this.m_elements = objArr;
            this.maxElements = objArr.length;
            return;
        }
        throw new IllegalArgumentException("The size must be greater than 0");
    }

    public BoundedFifoBuffer(Collection collection) {
        this(collection.size());
        addAll(collection);
    }
}
