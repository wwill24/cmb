package org.apache.commons.collections;

import java.util.AbstractCollection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class BinaryHeap extends AbstractCollection implements PriorityQueue, Buffer {
    private static final int DEFAULT_CAPACITY = 13;
    Comparator m_comparator;
    Object[] m_elements;
    boolean m_isMinHeap;
    int m_size;

    public BinaryHeap() {
        this(13, true);
    }

    /* access modifiers changed from: private */
    public int compare(Object obj, Object obj2) {
        Comparator comparator = this.m_comparator;
        if (comparator != null) {
            return comparator.compare(obj, obj2);
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    public boolean add(Object obj) {
        insert(obj);
        return true;
    }

    public void clear() {
        this.m_elements = new Object[this.m_elements.length];
        this.m_size = 0;
    }

    public Object get() {
        try {
            return peek();
        } catch (NoSuchElementException unused) {
            throw new BufferUnderflowException();
        }
    }

    /* access modifiers changed from: protected */
    public void grow() {
        Object[] objArr = this.m_elements;
        Object[] objArr2 = new Object[(objArr.length * 2)];
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        this.m_elements = objArr2;
    }

    public void insert(Object obj) {
        if (isFull()) {
            grow();
        }
        if (this.m_isMinHeap) {
            percolateUpMinHeap(obj);
        } else {
            percolateUpMaxHeap(obj);
        }
    }

    public boolean isEmpty() {
        return this.m_size == 0;
    }

    public boolean isFull() {
        return this.m_elements.length == this.m_size + 1;
    }

    public Iterator iterator() {
        return new Iterator() {
            private int index = 1;
            private int lastReturnedIndex = -1;

            public boolean hasNext() {
                return this.index <= BinaryHeap.this.m_size;
            }

            public Object next() {
                if (hasNext()) {
                    int i10 = this.index;
                    this.lastReturnedIndex = i10;
                    this.index = i10 + 1;
                    return BinaryHeap.this.m_elements[i10];
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                int i10 = this.lastReturnedIndex;
                if (i10 != -1) {
                    BinaryHeap binaryHeap = BinaryHeap.this;
                    Object[] objArr = binaryHeap.m_elements;
                    int i11 = binaryHeap.m_size;
                    objArr[i10] = objArr[i11];
                    objArr[i11] = null;
                    int i12 = i11 - 1;
                    binaryHeap.m_size = i12;
                    if (i12 != 0 && i10 <= i12) {
                        int i13 = 0;
                        if (i10 > 1) {
                            i13 = binaryHeap.compare(objArr[i10], objArr[i10 / 2]);
                        }
                        BinaryHeap binaryHeap2 = BinaryHeap.this;
                        if (binaryHeap2.m_isMinHeap) {
                            int i14 = this.lastReturnedIndex;
                            if (i14 <= 1 || i13 >= 0) {
                                binaryHeap2.percolateDownMinHeap(i14);
                            } else {
                                binaryHeap2.percolateUpMinHeap(i14);
                            }
                        } else {
                            int i15 = this.lastReturnedIndex;
                            if (i15 <= 1 || i13 <= 0) {
                                binaryHeap2.percolateDownMaxHeap(i15);
                            } else {
                                binaryHeap2.percolateUpMaxHeap(i15);
                            }
                        }
                    }
                    this.index--;
                    this.lastReturnedIndex = -1;
                    return;
                }
                throw new IllegalStateException();
            }
        };
    }

    public Object peek() throws NoSuchElementException {
        if (!isEmpty()) {
            return this.m_elements[1];
        }
        throw new NoSuchElementException();
    }

    /* access modifiers changed from: protected */
    public void percolateDownMaxHeap(int i10) {
        Object obj = this.m_elements[i10];
        while (true) {
            int i11 = i10 * 2;
            int i12 = this.m_size;
            if (i11 > i12) {
                break;
            }
            if (i11 != i12) {
                Object[] objArr = this.m_elements;
                int i13 = i11 + 1;
                if (compare(objArr[i13], objArr[i11]) > 0) {
                    i11 = i13;
                }
            }
            if (compare(this.m_elements[i11], obj) <= 0) {
                break;
            }
            Object[] objArr2 = this.m_elements;
            objArr2[i10] = objArr2[i11];
            i10 = i11;
        }
        this.m_elements[i10] = obj;
    }

    /* access modifiers changed from: protected */
    public void percolateDownMinHeap(int i10) {
        Object obj = this.m_elements[i10];
        while (true) {
            int i11 = i10 * 2;
            int i12 = this.m_size;
            if (i11 > i12) {
                break;
            }
            if (i11 != i12) {
                Object[] objArr = this.m_elements;
                int i13 = i11 + 1;
                if (compare(objArr[i13], objArr[i11]) < 0) {
                    i11 = i13;
                }
            }
            if (compare(this.m_elements[i11], obj) >= 0) {
                break;
            }
            Object[] objArr2 = this.m_elements;
            objArr2[i10] = objArr2[i11];
            i10 = i11;
        }
        this.m_elements[i10] = obj;
    }

    /* access modifiers changed from: protected */
    public void percolateUpMaxHeap(int i10) {
        Object obj = this.m_elements[i10];
        while (i10 > 1) {
            int i11 = i10 / 2;
            if (compare(obj, this.m_elements[i11]) <= 0) {
                break;
            }
            Object[] objArr = this.m_elements;
            objArr[i10] = objArr[i11];
            i10 = i11;
        }
        this.m_elements[i10] = obj;
    }

    /* access modifiers changed from: protected */
    public void percolateUpMinHeap(int i10) {
        Object obj = this.m_elements[i10];
        while (i10 > 1) {
            int i11 = i10 / 2;
            if (compare(obj, this.m_elements[i11]) >= 0) {
                break;
            }
            Object[] objArr = this.m_elements;
            objArr[i10] = objArr[i11];
            i10 = i11;
        }
        this.m_elements[i10] = obj;
    }

    public Object pop() throws NoSuchElementException {
        Object peek = peek();
        Object[] objArr = this.m_elements;
        int i10 = this.m_size;
        int i11 = i10 - 1;
        this.m_size = i11;
        objArr[1] = objArr[i10];
        objArr[i11 + 1] = null;
        if (i11 != 0) {
            if (this.m_isMinHeap) {
                percolateDownMinHeap(1);
            } else {
                percolateDownMaxHeap(1);
            }
        }
        return peek;
    }

    public Object remove() {
        try {
            return pop();
        } catch (NoSuchElementException unused) {
            throw new BufferUnderflowException();
        }
    }

    public int size() {
        return this.m_size;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ ");
        for (int i10 = 1; i10 < this.m_size + 1; i10++) {
            if (i10 != 1) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(this.m_elements[i10]);
        }
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }

    public BinaryHeap(Comparator comparator) {
        this();
        this.m_comparator = comparator;
    }

    public BinaryHeap(int i10) {
        this(i10, true);
    }

    public BinaryHeap(int i10, Comparator comparator) {
        this(i10);
        this.m_comparator = comparator;
    }

    /* access modifiers changed from: protected */
    public void percolateUpMaxHeap(Object obj) {
        Object[] objArr = this.m_elements;
        int i10 = this.m_size + 1;
        this.m_size = i10;
        objArr[i10] = obj;
        percolateUpMaxHeap(i10);
    }

    /* access modifiers changed from: protected */
    public void percolateUpMinHeap(Object obj) {
        Object[] objArr = this.m_elements;
        int i10 = this.m_size + 1;
        this.m_size = i10;
        objArr[i10] = obj;
        percolateUpMinHeap(i10);
    }

    public BinaryHeap(boolean z10) {
        this(13, z10);
    }

    public BinaryHeap(boolean z10, Comparator comparator) {
        this(z10);
        this.m_comparator = comparator;
    }

    public BinaryHeap(int i10, boolean z10) {
        if (i10 > 0) {
            this.m_isMinHeap = z10;
            this.m_elements = new Object[(i10 + 1)];
            return;
        }
        throw new IllegalArgumentException("invalid capacity");
    }

    public BinaryHeap(int i10, boolean z10, Comparator comparator) {
        this(i10, z10);
        this.m_comparator = comparator;
    }
}
