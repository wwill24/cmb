package org.apache.commons.beanutils;

public class ConversionException extends RuntimeException {
    protected Throwable cause;

    public ConversionException(String str) {
        super(str);
        this.cause = null;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public ConversionException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    public ConversionException(Throwable th2) {
        super(th2.getMessage());
        this.cause = th2;
    }
}
