package org.apache.commons.collections.buffer;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BufferUnderflowException;

public class PriorityBuffer extends AbstractCollection implements Buffer, Serializable {
    private static final int DEFAULT_CAPACITY = 13;
    private static final long serialVersionUID = 6891186490470027896L;
    protected boolean ascendingOrder;
    protected Comparator comparator;
    protected Object[] elements;
    protected int size;

    public PriorityBuffer() {
        this(13, true, (Comparator) null);
    }

    public boolean add(Object obj) {
        if (isAtCapacity()) {
            grow();
        }
        if (this.ascendingOrder) {
            percolateUpMinHeap(obj);
            return true;
        }
        percolateUpMaxHeap(obj);
        return true;
    }

    public void clear() {
        this.elements = new Object[this.elements.length];
        this.size = 0;
    }

    public Comparator comparator() {
        return this.comparator;
    }

    /* access modifiers changed from: protected */
    public int compare(Object obj, Object obj2) {
        Comparator comparator2 = this.comparator;
        if (comparator2 != null) {
            return comparator2.compare(obj, obj2);
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    public Object get() {
        if (!isEmpty()) {
            return this.elements[1];
        }
        throw new BufferUnderflowException();
    }

    /* access modifiers changed from: protected */
    public void grow() {
        Object[] objArr = this.elements;
        Object[] objArr2 = new Object[(objArr.length * 2)];
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        this.elements = objArr2;
    }

    public boolean isAscendingOrder() {
        return this.ascendingOrder;
    }

    /* access modifiers changed from: protected */
    public boolean isAtCapacity() {
        return this.elements.length == this.size + 1;
    }

    public Iterator iterator() {
        return new Iterator() {
            private int index = 1;
            private int lastReturnedIndex = -1;

            public boolean hasNext() {
                return this.index <= PriorityBuffer.this.size;
            }

            public Object next() {
                if (hasNext()) {
                    int i10 = this.index;
                    this.lastReturnedIndex = i10;
                    this.index = i10 + 1;
                    return PriorityBuffer.this.elements[i10];
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                int i10 = this.lastReturnedIndex;
                if (i10 != -1) {
                    PriorityBuffer priorityBuffer = PriorityBuffer.this;
                    Object[] objArr = priorityBuffer.elements;
                    int i11 = priorityBuffer.size;
                    objArr[i10] = objArr[i11];
                    objArr[i11] = null;
                    int i12 = i11 - 1;
                    priorityBuffer.size = i12;
                    if (i12 != 0 && i10 <= i12) {
                        int i13 = 0;
                        if (i10 > 1) {
                            i13 = priorityBuffer.compare(objArr[i10], objArr[i10 / 2]);
                        }
                        PriorityBuffer priorityBuffer2 = PriorityBuffer.this;
                        if (priorityBuffer2.ascendingOrder) {
                            int i14 = this.lastReturnedIndex;
                            if (i14 <= 1 || i13 >= 0) {
                                priorityBuffer2.percolateDownMinHeap(i14);
                            } else {
                                priorityBuffer2.percolateUpMinHeap(i14);
                            }
                        } else {
                            int i15 = this.lastReturnedIndex;
                            if (i15 <= 1 || i13 <= 0) {
                                priorityBuffer2.percolateDownMaxHeap(i15);
                            } else {
                                priorityBuffer2.percolateUpMaxHeap(i15);
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

    /* access modifiers changed from: protected */
    public void percolateDownMaxHeap(int i10) {
        Object obj = this.elements[i10];
        while (true) {
            int i11 = i10 * 2;
            int i12 = this.size;
            if (i11 > i12) {
                break;
            }
            if (i11 != i12) {
                Object[] objArr = this.elements;
                int i13 = i11 + 1;
                if (compare(objArr[i13], objArr[i11]) > 0) {
                    i11 = i13;
                }
            }
            if (compare(this.elements[i11], obj) <= 0) {
                break;
            }
            Object[] objArr2 = this.elements;
            objArr2[i10] = objArr2[i11];
            i10 = i11;
        }
        this.elements[i10] = obj;
    }

    /* access modifiers changed from: protected */
    public void percolateDownMinHeap(int i10) {
        Object obj = this.elements[i10];
        while (true) {
            int i11 = i10 * 2;
            int i12 = this.size;
            if (i11 > i12) {
                break;
            }
            if (i11 != i12) {
                Object[] objArr = this.elements;
                int i13 = i11 + 1;
                if (compare(objArr[i13], objArr[i11]) < 0) {
                    i11 = i13;
                }
            }
            if (compare(this.elements[i11], obj) >= 0) {
                break;
            }
            Object[] objArr2 = this.elements;
            objArr2[i10] = objArr2[i11];
            i10 = i11;
        }
        this.elements[i10] = obj;
    }

    /* access modifiers changed from: protected */
    public void percolateUpMaxHeap(int i10) {
        Object obj = this.elements[i10];
        while (i10 > 1) {
            int i11 = i10 / 2;
            if (compare(obj, this.elements[i11]) <= 0) {
                break;
            }
            Object[] objArr = this.elements;
            objArr[i10] = objArr[i11];
            i10 = i11;
        }
        this.elements[i10] = obj;
    }

    /* access modifiers changed from: protected */
    public void percolateUpMinHeap(int i10) {
        Object obj = this.elements[i10];
        while (i10 > 1) {
            int i11 = i10 / 2;
            if (compare(obj, this.elements[i11]) >= 0) {
                break;
            }
            Object[] objArr = this.elements;
            objArr[i10] = objArr[i11];
            i10 = i11;
        }
        this.elements[i10] = obj;
    }

    public Object remove() {
        Object obj = get();
        Object[] objArr = this.elements;
        int i10 = this.size;
        int i11 = i10 - 1;
        this.size = i11;
        objArr[1] = objArr[i10];
        objArr[i11 + 1] = null;
        if (i11 != 0) {
            if (this.ascendingOrder) {
                percolateDownMinHeap(1);
            } else {
                percolateDownMaxHeap(1);
            }
        }
        return obj;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ ");
        for (int i10 = 1; i10 < this.size + 1; i10++) {
            if (i10 != 1) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(this.elements[i10]);
        }
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }

    public PriorityBuffer(Comparator comparator2) {
        this(13, true, comparator2);
    }

    public PriorityBuffer(boolean z10) {
        this(13, z10, (Comparator) null);
    }

    public PriorityBuffer(boolean z10, Comparator comparator2) {
        this(13, z10, comparator2);
    }

    public PriorityBuffer(int i10) {
        this(i10, true, (Comparator) null);
    }

    /* access modifiers changed from: protected */
    public void percolateUpMaxHeap(Object obj) {
        Object[] objArr = this.elements;
        int i10 = this.size + 1;
        this.size = i10;
        objArr[i10] = obj;
        percolateUpMaxHeap(i10);
    }

    /* access modifiers changed from: protected */
    public void percolateUpMinHeap(Object obj) {
        Object[] objArr = this.elements;
        int i10 = this.size + 1;
        this.size = i10;
        objArr[i10] = obj;
        percolateUpMinHeap(i10);
    }

    public PriorityBuffer(int i10, Comparator comparator2) {
        this(i10, true, comparator2);
    }

    public PriorityBuffer(int i10, boolean z10) {
        this(i10, z10, (Comparator) null);
    }

    public PriorityBuffer(int i10, boolean z10, Comparator comparator2) {
        if (i10 > 0) {
            this.ascendingOrder = z10;
            this.elements = new Object[(i10 + 1)];
            this.comparator = comparator2;
            return;
        }
        throw new IllegalArgumentException("invalid capacity");
    }
}
