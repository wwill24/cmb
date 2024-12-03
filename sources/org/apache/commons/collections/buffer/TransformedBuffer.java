package org.apache.commons.collections.buffer;

import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.collection.TransformedCollection;

public class TransformedBuffer extends TransformedCollection implements Buffer {
    private static final long serialVersionUID = -7901091318986132033L;

    protected TransformedBuffer(Buffer buffer, Transformer transformer) {
        super(buffer, transformer);
    }

    public static Buffer decorate(Buffer buffer, Transformer transformer) {
        return new TransformedBuffer(buffer, transformer);
    }

    public Object get() {
        return getBuffer().get();
    }

    /* access modifiers changed from: protected */
    public Buffer getBuffer() {
        return (Buffer) this.collection;
    }

    public Object remove() {
        return getBuffer().remove();
    }
}
