package org.bouncycastle.jce.provider;

import java.security.cert.CRLException;

class ExtCRLException extends CRLException {
    Throwable cause;

    ExtCRLException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    public Throwable getCause() {
        return this.cause;
    }
}
