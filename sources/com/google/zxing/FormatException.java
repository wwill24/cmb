package com.google.zxing;

public final class FormatException extends ReaderException {

    /* renamed from: c  reason: collision with root package name */
    private static final FormatException f22022c;

    static {
        FormatException formatException = new FormatException();
        f22022c = formatException;
        formatException.setStackTrace(ReaderException.f22024b);
    }

    private FormatException() {
    }

    public static FormatException a() {
        return ReaderException.f22023a ? new FormatException() : f22022c;
    }
}
