package org.apache.commons.collections.buffer;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.BoundedCollection;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BufferOverflowException;
import org.apache.commons.collections.BufferUnderflowException;
import org.apache.commons.collections.iterators.AbstractIteratorDecorator;

public class BoundedBuffer extends SynchronizedBuffer implements BoundedCollection {
    private static final long serialVersionUID = 1536432911093974264L;
    private final int maximumSize;
    private final long timeout;

    private class NotifyingIterator extends AbstractIteratorDecorator {
        private final /* synthetic */ BoundedBuffer this$0;

        public NotifyingIterator(BoundedBuffer boundedBuffer, Iterator it) {
            super(it);
            this.this$0 = boundedBuffer;
        }

        public void remove() {
            synchronized (this.this$0.lock) {
                this.iterator.remove();
                this.this$0.lock.notifyAll();
            }
        }
    }

    protected BoundedBuffer(Buffer buffer, int i10, long j10) {
        super(buffer);
        if (i10 >= 1) {
            this.maximumSize = i10;
            this.timeout = j10;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static BoundedBuffer decorate(Buffer buffer, int i10) {
        return new BoundedBuffer(buffer, i10, 0);
    }

    private void timeoutWait(int i10) {
        if (i10 > this.maximumSize) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Buffer size cannot exceed ");
            stringBuffer.append(this.maximumSize);
            throw new BufferOverflowException(stringBuffer.toString());
        } else if (this.timeout > 0) {
            long currentTimeMillis = System.currentTimeMillis() + this.timeout;
            long currentTimeMillis2 = System.currentTimeMillis();
            while (true) {
                long j10 = currentTimeMillis - currentTimeMillis2;
                if (j10 > 0 && getBuffer().size() + i10 > this.maximumSize) {
                    try {
                        this.lock.wait(j10);
                        currentTimeMillis2 = System.currentTimeMillis();
                    } catch (InterruptedException e10) {
                        PrintWriter printWriter = new PrintWriter(new StringWriter());
                        e10.printStackTrace(printWriter);
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("Caused by InterruptedException: ");
                        stringBuffer2.append(printWriter.toString());
                        throw new BufferUnderflowException(stringBuffer2.toString());
                    }
                }
            }
            if (getBuffer().size() + i10 > this.maximumSize) {
                throw new BufferOverflowException("Timeout expired");
            }
        } else if (getBuffer().size() + i10 > this.maximumSize) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Buffer size cannot exceed ");
            stringBuffer3.append(this.maximumSize);
            throw new BufferOverflowException(stringBuffer3.toString());
        }
    }

    public boolean add(Object obj) {
        boolean add;
        synchronized (this.lock) {
            timeoutWait(1);
            add = getBuffer().add(obj);
        }
        return add;
    }

    public boolean addAll(Collection collection) {
        boolean addAll;
        synchronized (this.lock) {
            timeoutWait(collection.size());
            addAll = getBuffer().addAll(collection);
        }
        return addAll;
    }

    public boolean isFull() {
        return size() == maxSize();
    }

    public Iterator iterator() {
        return new NotifyingIterator(this, this.collection.iterator());
    }

    public int maxSize() {
        return this.maximumSize;
    }

    public Object remove() {
        Object remove;
        synchronized (this.lock) {
            remove = getBuffer().remove();
            this.lock.notifyAll();
        }
        return remove;
    }

    public static BoundedBuffer decorate(Buffer buffer, int i10, long j10) {
        return new BoundedBuffer(buffer, i10, j10);
    }
}
