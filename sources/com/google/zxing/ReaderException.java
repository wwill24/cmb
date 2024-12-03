package com.google.zxing;

public abstract class ReaderException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    protected static boolean f22023a;

    /* renamed from: b  reason: collision with root package name */
    protected static final StackTraceElement[] f22024b = new StackTraceElement[0];

    static {
        boolean z10;
        if (System.getProperty("surefire.test.class.path") != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        f22023a = z10;
    }

    ReaderException() {
    }

    public final synchronized Throwable fillInStackTrace() {
        return null;
    }
}
