package org.apache.commons.collections.buffer;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BufferUnderflowException;

public class BlockingBuffer extends SynchronizedBuffer {
    private static final long serialVersionUID = 1719328905017860541L;
    private final long timeout;

    protected BlockingBuffer(Buffer buffer) {
        super(buffer);
        this.timeout = 0;
    }

    public static Buffer decorate(Buffer buffer) {
        return new BlockingBuffer(buffer);
    }

    public boolean add(Object obj) {
        boolean add;
        synchronized (this.lock) {
            add = this.collection.add(obj);
            this.lock.notifyAll();
        }
        return add;
    }

    public boolean addAll(Collection collection) {
        boolean addAll;
        synchronized (this.lock) {
            addAll = this.collection.addAll(collection);
            this.lock.notifyAll();
        }
        return addAll;
    }

    public Object get() {
        synchronized (this.lock) {
            while (this.collection.isEmpty()) {
                try {
                    long j10 = this.timeout;
                    if (j10 <= 0) {
                        this.lock.wait();
                    } else {
                        Object obj = get(j10);
                        return obj;
                    }
                } catch (InterruptedException e10) {
                    PrintWriter printWriter = new PrintWriter(new StringWriter());
                    e10.printStackTrace(printWriter);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Caused by InterruptedException: ");
                    stringBuffer.append(printWriter.toString());
                    throw new BufferUnderflowException(stringBuffer.toString());
                }
            }
            Object obj2 = getBuffer().get();
            return obj2;
        }
    }

    public Object remove() {
        synchronized (this.lock) {
            while (this.collection.isEmpty()) {
                try {
                    long j10 = this.timeout;
                    if (j10 <= 0) {
                        this.lock.wait();
                    } else {
                        Object remove = remove(j10);
                        return remove;
                    }
                } catch (InterruptedException e10) {
                    PrintWriter printWriter = new PrintWriter(new StringWriter());
                    e10.printStackTrace(printWriter);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Caused by InterruptedException: ");
                    stringBuffer.append(printWriter.toString());
                    throw new BufferUnderflowException(stringBuffer.toString());
                }
            }
            Object remove2 = getBuffer().remove();
            return remove2;
        }
    }

    public static Buffer decorate(Buffer buffer, long j10) {
        return new BlockingBuffer(buffer, j10);
    }

    protected BlockingBuffer(Buffer buffer, long j10) {
        super(buffer);
        this.timeout = j10 < 0 ? 0 : j10;
    }

    public Object get(long j10) {
        Object obj;
        synchronized (this.lock) {
            long currentTimeMillis = System.currentTimeMillis() + j10;
            long currentTimeMillis2 = System.currentTimeMillis();
            while (true) {
                long j11 = currentTimeMillis - currentTimeMillis2;
                if (j11 > 0 && this.collection.isEmpty()) {
                    try {
                        this.lock.wait(j11);
                        currentTimeMillis2 = System.currentTimeMillis();
                    } catch (InterruptedException e10) {
                        PrintWriter printWriter = new PrintWriter(new StringWriter());
                        e10.printStackTrace(printWriter);
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Caused by InterruptedException: ");
                        stringBuffer.append(printWriter.toString());
                        throw new BufferUnderflowException(stringBuffer.toString());
                    }
                }
            }
            if (!this.collection.isEmpty()) {
                obj = getBuffer().get();
            } else {
                throw new BufferUnderflowException("Timeout expired");
            }
        }
        return obj;
    }

    public Object remove(long j10) {
        Object remove;
        synchronized (this.lock) {
            long currentTimeMillis = System.currentTimeMillis() + j10;
            long currentTimeMillis2 = System.currentTimeMillis();
            while (true) {
                long j11 = currentTimeMillis - currentTimeMillis2;
                if (j11 > 0 && this.collection.isEmpty()) {
                    try {
                        this.lock.wait(j11);
                        currentTimeMillis2 = System.currentTimeMillis();
                    } catch (InterruptedException e10) {
                        PrintWriter printWriter = new PrintWriter(new StringWriter());
                        e10.printStackTrace(printWriter);
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Caused by InterruptedException: ");
                        stringBuffer.append(printWriter.toString());
                        throw new BufferUnderflowException(stringBuffer.toString());
                    }
                }
            }
            if (!this.collection.isEmpty()) {
                remove = getBuffer().remove();
            } else {
                throw new BufferUnderflowException("Timeout expired");
            }
        }
        return remove;
    }
}
