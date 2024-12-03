package org.apache.commons.collections.buffer;

import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.collection.PredicatedCollection;

public class PredicatedBuffer extends PredicatedCollection implements Buffer {
    private static final long serialVersionUID = 2307609000539943581L;

    protected PredicatedBuffer(Buffer buffer, Predicate predicate) {
        super(buffer, predicate);
    }

    public static Buffer decorate(Buffer buffer, Predicate predicate) {
        return new PredicatedBuffer(buffer, predicate);
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
}
