package org.apache.commons.collections.buffer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.BoundedCollection;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BufferOverflowException;
import org.apache.commons.collections.BufferUnderflowException;

public class BoundedFifoBuffer extends AbstractCollection implements Buffer, BoundedCollection, Serializable {
    private static final long serialVersionUID = 5603722811189451017L;
    /* access modifiers changed from: private */
    public transient Object[] elements;
    /* access modifiers changed from: private */
    public transient int end;
    /* access modifiers changed from: private */
    public transient boolean full;
    /* access modifiers changed from: private */
    public final int maxElements;
    /* access modifiers changed from: private */
    public transient int start;

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

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        boolean z10;
        objectInputStream.defaultReadObject();
        this.elements = new Object[this.maxElements];
        int readInt = objectInputStream.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            this.elements[i10] = objectInputStream.readObject();
        }
        this.start = 0;
        if (readInt == this.maxElements) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.full = z10;
        if (z10) {
            this.end = 0;
        } else {
            this.end = readInt;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    public boolean add(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Attempted to add null object to buffer");
        } else if (!this.full) {
            Object[] objArr = this.elements;
            int i10 = this.end;
            int i11 = i10 + 1;
            this.end = i11;
            objArr[i10] = obj;
            if (i11 >= this.maxElements) {
                this.end = 0;
            }
            if (this.end == this.start) {
                this.full = true;
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
        this.full = false;
        this.start = 0;
        this.end = 0;
        Arrays.fill(this.elements, (Object) null);
    }

    public Object get() {
        if (!isEmpty()) {
            return this.elements[this.start];
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
                this.index = BoundedFifoBuffer.this.start;
                this.isFirst = BoundedFifoBuffer.this.full;
            }

            public boolean hasNext() {
                return this.isFirst || this.index != BoundedFifoBuffer.this.end;
            }

            public Object next() {
                if (hasNext()) {
                    this.isFirst = false;
                    int i10 = this.index;
                    this.lastReturnedIndex = i10;
                    this.index = BoundedFifoBuffer.this.increment(i10);
                    return BoundedFifoBuffer.this.elements[this.lastReturnedIndex];
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                int i10 = this.lastReturnedIndex;
                if (i10 == -1) {
                    throw new IllegalStateException();
                } else if (i10 == BoundedFifoBuffer.this.start) {
                    BoundedFifoBuffer.this.remove();
                    this.lastReturnedIndex = -1;
                } else {
                    int i11 = this.lastReturnedIndex + 1;
                    if (BoundedFifoBuffer.this.start >= this.lastReturnedIndex || i11 >= BoundedFifoBuffer.this.end) {
                        while (i11 != BoundedFifoBuffer.this.end) {
                            if (i11 >= BoundedFifoBuffer.this.maxElements) {
                                BoundedFifoBuffer.this.elements[i11 - 1] = BoundedFifoBuffer.this.elements[0];
                                i11 = 0;
                            } else {
                                BoundedFifoBuffer.this.elements[BoundedFifoBuffer.this.decrement(i11)] = BoundedFifoBuffer.this.elements[i11];
                                i11 = BoundedFifoBuffer.this.increment(i11);
                            }
                        }
                    } else {
                        System.arraycopy(BoundedFifoBuffer.this.elements, i11, BoundedFifoBuffer.this.elements, this.lastReturnedIndex, BoundedFifoBuffer.this.end - i11);
                    }
                    this.lastReturnedIndex = -1;
                    BoundedFifoBuffer boundedFifoBuffer = BoundedFifoBuffer.this;
                    int unused = boundedFifoBuffer.end = boundedFifoBuffer.decrement(boundedFifoBuffer.end);
                    BoundedFifoBuffer.this.elements[BoundedFifoBuffer.this.end] = null;
                    boolean unused2 = BoundedFifoBuffer.this.full = false;
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
            Object[] objArr = this.elements;
            int i10 = this.start;
            Object obj = objArr[i10];
            if (obj != null) {
                int i11 = i10 + 1;
                this.start = i11;
                objArr[i10] = null;
                if (i11 >= this.maxElements) {
                    this.start = 0;
                }
                this.full = false;
            }
            return obj;
        }
        throw new BufferUnderflowException("The buffer is already empty");
    }

    public int size() {
        int i10;
        int i11 = this.end;
        int i12 = this.start;
        if (i11 < i12) {
            return (this.maxElements - i12) + i11;
        }
        if (i11 != i12) {
            return i11 - i12;
        }
        if (this.full) {
            i10 = this.maxElements;
        } else {
            i10 = 0;
        }
        return i10;
    }

    public BoundedFifoBuffer(int i10) {
        this.start = 0;
        this.end = 0;
        this.full = false;
        if (i10 > 0) {
            Object[] objArr = new Object[i10];
            this.elements = objArr;
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
