package io.sentry.exception;

import io.sentry.protocol.g;
import io.sentry.util.l;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class ExceptionMechanismException extends RuntimeException {
    private static final long serialVersionUID = 142345454265713915L;
    private final g exceptionMechanism;
    private final boolean snapshot;
    private final Thread thread;
    private final Throwable throwable;

    public ExceptionMechanismException(g gVar, Throwable th2, Thread thread2, boolean z10) {
        this.exceptionMechanism = (g) l.c(gVar, "Mechanism is required.");
        this.throwable = (Throwable) l.c(th2, "Throwable is required.");
        this.thread = (Thread) l.c(thread2, "Thread is required.");
        this.snapshot = z10;
    }

    public g a() {
        return this.exceptionMechanism;
    }

    public Thread b() {
        return this.thread;
    }

    public Throwable c() {
        return this.throwable;
    }

    public boolean d() {
        return this.snapshot;
    }

    public ExceptionMechanismException(g gVar, Throwable th2, Thread thread2) {
        this(gVar, th2, thread2, false);
    }
}
