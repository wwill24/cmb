package org.apache.commons.digester.xmlrules;

public class XmlLoadException extends RuntimeException {
    private Throwable cause;

    public XmlLoadException(Throwable th2) {
        this(th2.getMessage());
        this.cause = th2;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public XmlLoadException(String str) {
        super(str);
        this.cause = null;
    }

    public XmlLoadException(String str, Throwable th2) {
        this(str);
        this.cause = th2;
    }
}
