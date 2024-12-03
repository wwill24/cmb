package org.apache.commons.collections.buffer;

import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.collection.SynchronizedCollection;

public class SynchronizedBuffer extends SynchronizedCollection implements Buffer {
    private static final long serialVersionUID = -6859936183953626253L;

    protected SynchronizedBuffer(Buffer buffer) {
        super(buffer);
    }

    public static Buffer decorate(Buffer buffer) {
        return new SynchronizedBuffer(buffer);
    }

    public Object get() {
        Object obj;
        synchronized (this.lock) {
            obj = getBuffer().get();
        }
        return obj;
    }

    /* access modifiers changed from: protected */
    public Buffer getBuffer() {
        return (Buffer) this.collection;
    }

    public Object remove() {
        Object remove;
        synchronized (this.lock) {
            remove = getBuffer().remove();
        }
        return remove;
    }

    protected SynchronizedBuffer(Buffer buffer, Object obj) {
        super(buffer, obj);
    }
}
