package org.apache.commons.digester.xmlrules;

public class DigesterLoadingException extends Exception {
    private Throwable cause;

    public DigesterLoadingException(String str) {
        super(str);
        this.cause = null;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public DigesterLoadingException(Throwable th2) {
        this(th2.getMessage());
        this.cause = th2;
    }

    public DigesterLoadingException(String str, Throwable th2) {
        this(str);
        this.cause = th2;
    }
}
