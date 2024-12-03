package org.bouncycastle.pqc.crypto.lms;

public class LMSException extends Exception {
    public LMSException() {
    }

    public LMSException(String str) {
        super(str);
    }

    public LMSException(String str, Throwable th2) {
        super(str, th2);
    }

    public LMSException(String str, Throwable th2, boolean z10, boolean z11) {
        super(str, th2, z10, z11);
    }

    public LMSException(Throwable th2) {
        super(th2);
    }
}
