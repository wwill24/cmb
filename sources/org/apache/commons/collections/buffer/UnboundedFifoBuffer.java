package org.apache.commons.collections.buffer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BufferUnderflowException;

public class UnboundedFifoBuffer extends AbstractCollection implements Buffer, Serializable {
    private static final long serialVersionUID = -3482960336579541419L;
    protected transient Object[] buffer;
    protected transient int head;
    protected transient int tail;

    public UnboundedFifoBuffer() {
        this(32);
    }

    /* access modifiers changed from: private */
    public int decrement(int i10) {
        int i11 = i10 - 1;
        return i11 < 0 ? this.buffer.length - 1 : i11;
    }

    /* access modifiers changed from: private */
    public int increment(int i10) {
        int i11 = i10 + 1;
        if (i11 >= this.buffer.length) {
            return 0;
        }
        return i11;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        this.buffer = new Object[(readInt + 1)];
        for (int i10 = 0; i10 < readInt; i10++) {
            this.buffer[i10] = objectInputStream.readObject();
        }
        this.head = 0;
        this.tail = readInt;
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
        if (obj != null) {
            int size = size() + 1;
            Object[] objArr = this.buffer;
            if (size >= objArr.length) {
                Object[] objArr2 = new Object[(((objArr.length - 1) * 2) + 1)];
                int i10 = this.head;
                int i11 = 0;
                while (i10 != this.tail) {
                    Object[] objArr3 = this.buffer;
                    objArr2[i11] = objArr3[i10];
                    objArr3[i10] = null;
                    i11++;
                    i10 = increment(i10);
                }
                this.buffer = objArr2;
                this.head = 0;
                this.tail = i11;
            }
            Object[] objArr4 = this.buffer;
            int i12 = this.tail;
            objArr4[i12] = obj;
            this.tail = increment(i12);
            return true;
        }
        throw new NullPointerException("Attempted to add null object to buffer");
    }

    public Object get() {
        if (!isEmpty()) {
            return this.buffer[this.head];
        }
        throw new BufferUnderflowException("The buffer is already empty");
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterator iterator() {
        return new Iterator() {
            private int index;
            private int lastReturnedIndex = -1;

            {
                this.index = UnboundedFifoBuffer.this.head;
            }

            public boolean hasNext() {
                return this.index != UnboundedFifoBuffer.this.tail;
            }

            public Object next() {
                if (hasNext()) {
                    int i10 = this.index;
                    this.lastReturnedIndex = i10;
                    this.index = UnboundedFifoBuffer.this.increment(i10);
                    return UnboundedFifoBuffer.this.buffer[this.lastReturnedIndex];
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                int i10 = this.lastReturnedIndex;
                if (i10 != -1) {
                    UnboundedFifoBuffer unboundedFifoBuffer = UnboundedFifoBuffer.this;
                    if (i10 == unboundedFifoBuffer.head) {
                        unboundedFifoBuffer.remove();
                        this.lastReturnedIndex = -1;
                        return;
                    }
                    int access$000 = unboundedFifoBuffer.increment(i10);
                    while (true) {
                        UnboundedFifoBuffer unboundedFifoBuffer2 = UnboundedFifoBuffer.this;
                        int i11 = unboundedFifoBuffer2.tail;
                        if (access$000 != i11) {
                            Object[] objArr = unboundedFifoBuffer2.buffer;
                            int access$100 = unboundedFifoBuffer2.decrement(access$000);
                            UnboundedFifoBuffer unboundedFifoBuffer3 = UnboundedFifoBuffer.this;
                            objArr[access$100] = unboundedFifoBuffer3.buffer[access$000];
                            access$000 = unboundedFifoBuffer3.increment(access$000);
                        } else {
                            this.lastReturnedIndex = -1;
                            unboundedFifoBuffer2.tail = unboundedFifoBuffer2.decrement(i11);
                            UnboundedFifoBuffer unboundedFifoBuffer4 = UnboundedFifoBuffer.this;
                            unboundedFifoBuffer4.buffer[unboundedFifoBuffer4.tail] = null;
                            this.index = unboundedFifoBuffer4.decrement(this.index);
                            return;
                        }
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
        };
    }

    public Object remove() {
        if (!isEmpty()) {
            Object[] objArr = this.buffer;
            int i10 = this.head;
            Object obj = objArr[i10];
            if (obj != null) {
                objArr[i10] = null;
                this.head = increment(i10);
            }
            return obj;
        }
        throw new BufferUnderflowException("The buffer is already empty");
    }

    public int size() {
        int i10 = this.tail;
        int i11 = this.head;
        if (i10 < i11) {
            return (this.buffer.length - i11) + i10;
        }
        return i10 - i11;
    }

    public UnboundedFifoBuffer(int i10) {
        if (i10 > 0) {
            this.buffer = new Object[(i10 + 1)];
            this.head = 0;
            this.tail = 0;
            return;
        }
        throw new IllegalArgumentException("The size must be greater than 0");
    }
}
