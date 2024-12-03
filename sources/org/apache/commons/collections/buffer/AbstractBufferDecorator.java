package org.apache.commons.collections.buffer;

import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;

public abstract class AbstractBufferDecorator extends AbstractCollectionDecorator implements Buffer {
    protected AbstractBufferDecorator() {
    }

    public Object get() {
        return getBuffer().get();
    }

    /* access modifiers changed from: protected */
    public Buffer getBuffer() {
        return (Buffer) getCollection();
    }

    public Object remove() {
        return getBuffer().remove();
    }

    protected AbstractBufferDecorator(Buffer buffer) {
        super(buffer);
    }
}
