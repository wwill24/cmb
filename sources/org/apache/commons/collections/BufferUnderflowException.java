package org.apache.commons.collections;

import java.util.NoSuchElementException;

public class BufferUnderflowException extends NoSuchElementException {
    private final Throwable throwable;

    public BufferUnderflowException() {
        this.throwable = null;
    }

    public final Throwable getCause() {
        return this.throwable;
    }

    public BufferUnderflowException(String str) {
        this(str, (Throwable) null);
    }

    public BufferUnderflowException(String str, Throwable th2) {
        super(str);
        this.throwable = th2;
    }
}
