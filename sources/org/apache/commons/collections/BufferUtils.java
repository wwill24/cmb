package org.apache.commons.collections;

import org.apache.commons.collections.buffer.BlockingBuffer;
import org.apache.commons.collections.buffer.BoundedBuffer;
import org.apache.commons.collections.buffer.PredicatedBuffer;
import org.apache.commons.collections.buffer.SynchronizedBuffer;
import org.apache.commons.collections.buffer.TransformedBuffer;
import org.apache.commons.collections.buffer.TypedBuffer;
import org.apache.commons.collections.buffer.UnmodifiableBuffer;

public class BufferUtils {
    public static final Buffer EMPTY_BUFFER = UnmodifiableBuffer.decorate(new ArrayStack(1));

    public static Buffer blockingBuffer(Buffer buffer) {
        return BlockingBuffer.decorate(buffer);
    }

    public static Buffer boundedBuffer(Buffer buffer, int i10) {
        return BoundedBuffer.decorate(buffer, i10);
    }

    public static Buffer predicatedBuffer(Buffer buffer, Predicate predicate) {
        return PredicatedBuffer.decorate(buffer, predicate);
    }

    public static Buffer synchronizedBuffer(Buffer buffer) {
        return SynchronizedBuffer.decorate(buffer);
    }

    public static Buffer transformedBuffer(Buffer buffer, Transformer transformer) {
        return TransformedBuffer.decorate(buffer, transformer);
    }

    public static Buffer typedBuffer(Buffer buffer, Class cls) {
        return TypedBuffer.decorate(buffer, cls);
    }

    public static Buffer unmodifiableBuffer(Buffer buffer) {
        return UnmodifiableBuffer.decorate(buffer);
    }

    public static Buffer blockingBuffer(Buffer buffer, long j10) {
        return BlockingBuffer.decorate(buffer, j10);
    }

    public static Buffer boundedBuffer(Buffer buffer, int i10, long j10) {
        return BoundedBuffer.decorate(buffer, i10, j10);
    }
}
