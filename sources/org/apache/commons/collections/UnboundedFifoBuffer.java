package org.apache.commons.collections;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnboundedFifoBuffer extends AbstractCollection implements Buffer {
    protected Object[] m_buffer;
    protected int m_head;
    protected int m_tail;

    public UnboundedFifoBuffer() {
        this(32);
    }

    /* access modifiers changed from: private */
    public int decrement(int i10) {
        int i11 = i10 - 1;
        return i11 < 0 ? this.m_buffer.length - 1 : i11;
    }

    /* access modifiers changed from: private */
    public int increment(int i10) {
        int i11 = i10 + 1;
        if (i11 >= this.m_buffer.length) {
            return 0;
        }
        return i11;
    }

    public boolean add(Object obj) {
        if (obj != null) {
            int size = size() + 1;
            Object[] objArr = this.m_buffer;
            if (size >= objArr.length) {
                Object[] objArr2 = new Object[(((objArr.length - 1) * 2) + 1)];
                int i10 = this.m_head;
                int i11 = 0;
                while (i10 != this.m_tail) {
                    Object[] objArr3 = this.m_buffer;
                    objArr2[i11] = objArr3[i10];
                    objArr3[i10] = null;
                    i11++;
                    i10++;
                    if (i10 == objArr3.length) {
                        i10 = 0;
                    }
                }
                this.m_buffer = objArr2;
                this.m_head = 0;
                this.m_tail = i11;
            }
            Object[] objArr4 = this.m_buffer;
            int i12 = this.m_tail;
            objArr4[i12] = obj;
            int i13 = i12 + 1;
            this.m_tail = i13;
            if (i13 >= objArr4.length) {
                this.m_tail = 0;
            }
            return true;
        }
        throw new NullPointerException("Attempted to add null object to buffer");
    }

    public Object get() {
        if (!isEmpty()) {
            return this.m_buffer[this.m_head];
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
                this.index = UnboundedFifoBuffer.this.m_head;
            }

            public boolean hasNext() {
                return this.index != UnboundedFifoBuffer.this.m_tail;
            }

            public Object next() {
                if (hasNext()) {
                    int i10 = this.index;
                    this.lastReturnedIndex = i10;
                    this.index = UnboundedFifoBuffer.this.increment(i10);
                    return UnboundedFifoBuffer.this.m_buffer[this.lastReturnedIndex];
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                int i10 = this.lastReturnedIndex;
                if (i10 != -1) {
                    UnboundedFifoBuffer unboundedFifoBuffer = UnboundedFifoBuffer.this;
                    if (i10 == unboundedFifoBuffer.m_head) {
                        unboundedFifoBuffer.remove();
                        this.lastReturnedIndex = -1;
                        return;
                    }
                    int access$000 = unboundedFifoBuffer.increment(i10);
                    while (true) {
                        UnboundedFifoBuffer unboundedFifoBuffer2 = UnboundedFifoBuffer.this;
                        int i11 = unboundedFifoBuffer2.m_tail;
                        if (access$000 != i11) {
                            Object[] objArr = unboundedFifoBuffer2.m_buffer;
                            int access$100 = unboundedFifoBuffer2.decrement(access$000);
                            UnboundedFifoBuffer unboundedFifoBuffer3 = UnboundedFifoBuffer.this;
                            objArr[access$100] = unboundedFifoBuffer3.m_buffer[access$000];
                            access$000 = unboundedFifoBuffer3.increment(access$000);
                        } else {
                            this.lastReturnedIndex = -1;
                            unboundedFifoBuffer2.m_tail = unboundedFifoBuffer2.decrement(i11);
                            UnboundedFifoBuffer unboundedFifoBuffer4 = UnboundedFifoBuffer.this;
                            unboundedFifoBuffer4.m_buffer[unboundedFifoBuffer4.m_tail] = null;
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
            Object[] objArr = this.m_buffer;
            int i10 = this.m_head;
            Object obj = objArr[i10];
            if (obj != null) {
                objArr[i10] = null;
                int i11 = i10 + 1;
                this.m_head = i11;
                if (i11 >= objArr.length) {
                    this.m_head = 0;
                }
            }
            return obj;
        }
        throw new BufferUnderflowException("The buffer is already empty");
    }

    public int size() {
        int i10 = this.m_tail;
        int i11 = this.m_head;
        if (i10 < i11) {
            return (this.m_buffer.length - i11) + i10;
        }
        return i10 - i11;
    }

    public UnboundedFifoBuffer(int i10) {
        if (i10 > 0) {
            this.m_buffer = new Object[(i10 + 1)];
            this.m_head = 0;
            this.m_tail = 0;
            return;
        }
        throw new IllegalArgumentException("The size must be greater than 0");
    }
}
