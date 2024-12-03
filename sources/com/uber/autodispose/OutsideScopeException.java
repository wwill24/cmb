package com.uber.autodispose;

public class OutsideScopeException extends RuntimeException {
    public OutsideScopeException(String str) {
        super(str);
    }

    public final synchronized Throwable fillInStackTrace() {
        if (!h.f23329b) {
            return this;
        }
        return super.fillInStackTrace();
    }
}
