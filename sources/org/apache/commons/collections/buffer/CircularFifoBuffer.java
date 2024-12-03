package org.apache.commons.collections.buffer;

import java.util.Collection;

public class CircularFifoBuffer extends BoundedFifoBuffer {
    private static final long serialVersionUID = -8423413834657610406L;

    public CircularFifoBuffer() {
        super(32);
    }

    public boolean add(Object obj) {
        if (isFull()) {
            remove();
        }
        return super.add(obj);
    }

    public CircularFifoBuffer(int i10) {
        super(i10);
    }

    public CircularFifoBuffer(Collection collection) {
        super(collection);
    }
}
