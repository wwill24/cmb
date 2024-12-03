package org.bouncycastle.util;

public class StreamParsingException extends Exception {
    Throwable _e;

    public StreamParsingException(String str, Throwable th2) {
        super(str);
        this._e = th2;
    }

    public Throwable getCause() {
        return this._e;
    }
}
