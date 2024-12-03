package io.sentry.android.core;

import io.sentry.util.l;

final class ApplicationNotResponding extends RuntimeException {
    private static final long serialVersionUID = 252541144579117016L;
    private final Thread thread;

    ApplicationNotResponding(String str, Thread thread2) {
        super(str);
        Thread thread3 = (Thread) l.c(thread2, "Thread must be provided.");
        this.thread = thread3;
        setStackTrace(thread3.getStackTrace());
    }

    public Thread a() {
        return this.thread;
    }
}
