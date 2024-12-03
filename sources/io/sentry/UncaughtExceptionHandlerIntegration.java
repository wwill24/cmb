package io.sentry;

import io.sentry.exception.ExceptionMechanismException;
import io.sentry.hints.d;
import io.sentry.hints.e;
import io.sentry.hints.h;
import io.sentry.protocol.g;
import io.sentry.protocol.o;
import io.sentry.util.i;
import io.sentry.util.l;
import io.sentry.w4;
import java.io.Closeable;
import java.lang.Thread;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class UncaughtExceptionHandlerIntegration implements Integration, Thread.UncaughtExceptionHandler, Closeable {

    /* renamed from: a  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f30807a;

    /* renamed from: b  reason: collision with root package name */
    private g0 f30808b;

    /* renamed from: c  reason: collision with root package name */
    private SentryOptions f30809c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f30810d;

    /* renamed from: e  reason: collision with root package name */
    private final w4 f30811e;

    private static final class a implements d, e, h {

        /* renamed from: a  reason: collision with root package name */
        private final CountDownLatch f30812a = new CountDownLatch(1);

        /* renamed from: b  reason: collision with root package name */
        private final long f30813b;

        /* renamed from: c  reason: collision with root package name */
        private final h0 f30814c;

        a(long j10, h0 h0Var) {
            this.f30813b = j10;
            this.f30814c = h0Var;
        }

        public void a() {
            this.f30812a.countDown();
        }

        public boolean d() {
            try {
                return this.f30812a.await(this.f30813b, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e10) {
                Thread.currentThread().interrupt();
                this.f30814c.b(SentryLevel.ERROR, "Exception while awaiting for flush in UncaughtExceptionHint", e10);
                return false;
            }
        }
    }

    public UncaughtExceptionHandlerIntegration() {
        this(w4.a.c());
    }

    static Throwable e(Thread thread, Throwable th2) {
        g gVar = new g();
        gVar.i(Boolean.FALSE);
        gVar.j("UncaughtExceptionHandler");
        return new ExceptionMechanismException(gVar, th2, thread);
    }

    public final void a(g0 g0Var, SentryOptions sentryOptions) {
        if (this.f30810d) {
            sentryOptions.getLogger().c(SentryLevel.ERROR, "Attempt to register a UncaughtExceptionHandlerIntegration twice.", new Object[0]);
            return;
        }
        this.f30810d = true;
        this.f30808b = (g0) l.c(g0Var, "Hub is required");
        SentryOptions sentryOptions2 = (SentryOptions) l.c(sentryOptions, "SentryOptions is required");
        this.f30809c = sentryOptions2;
        h0 logger = sentryOptions2.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "UncaughtExceptionHandlerIntegration enabled: %s", Boolean.valueOf(this.f30809c.isEnableUncaughtExceptionHandler()));
        if (this.f30809c.isEnableUncaughtExceptionHandler()) {
            Thread.UncaughtExceptionHandler b10 = this.f30811e.b();
            if (b10 != null) {
                h0 logger2 = this.f30809c.getLogger();
                logger2.c(sentryLevel, "default UncaughtExceptionHandler class='" + b10.getClass().getName() + "'", new Object[0]);
                this.f30807a = b10;
            }
            this.f30811e.a(this);
            this.f30809c.getLogger().c(sentryLevel, "UncaughtExceptionHandlerIntegration installed.", new Object[0]);
            c();
        }
    }

    public void close() {
        if (this == this.f30811e.b()) {
            this.f30811e.a(this.f30807a);
            SentryOptions sentryOptions = this.f30809c;
            if (sentryOptions != null) {
                sentryOptions.getLogger().c(SentryLevel.DEBUG, "UncaughtExceptionHandlerIntegration removed.", new Object[0]);
            }
        }
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        SentryOptions sentryOptions = this.f30809c;
        if (sentryOptions != null && this.f30808b != null) {
            sentryOptions.getLogger().c(SentryLevel.INFO, "Uncaught exception received.", new Object[0]);
            try {
                a aVar = new a(this.f30809c.getFlushTimeoutMillis(), this.f30809c.getLogger());
                p3 p3Var = new p3(e(thread, th2));
                p3Var.x0(SentryLevel.FATAL);
                if (!this.f30808b.x(p3Var, i.e(aVar)).equals(o.f31517b) && !aVar.d()) {
                    this.f30809c.getLogger().c(SentryLevel.WARNING, "Timed out waiting to flush event to disk before crashing. Event: %s", p3Var.G());
                }
            } catch (Throwable th3) {
                this.f30809c.getLogger().b(SentryLevel.ERROR, "Error sending uncaught exception to Sentry.", th3);
            }
            if (this.f30807a != null) {
                this.f30809c.getLogger().c(SentryLevel.INFO, "Invoking inner uncaught exception handler.", new Object[0]);
                this.f30807a.uncaughtException(thread, th2);
            } else if (this.f30809c.isPrintUncaughtStackTrace()) {
                th2.printStackTrace();
            }
        }
    }

    UncaughtExceptionHandlerIntegration(w4 w4Var) {
        this.f30810d = false;
        this.f30811e = (w4) l.c(w4Var, "threadAdapter is required.");
    }
}
