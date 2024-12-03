package org.apache.commons.collections;

public class BufferOverflowException extends RuntimeException {
    private final Throwable throwable;

    public BufferOverflowException() {
        this.throwable = null;
    }

    public final Throwable getCause() {
        return this.throwable;
    }

    public BufferOverflowException(String str) {
        this(str, (Throwable) null);
    }

    public BufferOverflowException(String str, Throwable th2) {
        super(str);
        this.throwable = th2;
    }
}
