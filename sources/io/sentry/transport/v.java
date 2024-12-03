package io.sentry.transport;

import io.sentry.SentryLevel;
import io.sentry.h0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class v extends ThreadPoolExecutor {

    /* renamed from: a  reason: collision with root package name */
    private final int f31675a;

    /* renamed from: b  reason: collision with root package name */
    private final h0 f31676b;

    /* renamed from: c  reason: collision with root package name */
    private final ReusableCountLatch f31677c = new ReusableCountLatch();

    static final class a<T> implements Future<T> {
        a() {
        }

        public boolean cancel(boolean z10) {
            return true;
        }

        public T get() {
            throw new CancellationException();
        }

        public boolean isCancelled() {
            return true;
        }

        public boolean isDone() {
            return true;
        }

        public T get(long j10, TimeUnit timeUnit) {
            throw new CancellationException();
        }
    }

    public v(int i10, int i11, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler, h0 h0Var) {
        super(i10, i10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory, rejectedExecutionHandler);
        this.f31675a = i11;
        this.f31676b = h0Var;
    }

    private boolean a() {
        return this.f31677c.b() < this.f31675a;
    }

    /* access modifiers changed from: protected */
    public void afterExecute(Runnable runnable, Throwable th2) {
        try {
            super.afterExecute(runnable, th2);
        } finally {
            this.f31677c.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(long j10) {
        try {
            this.f31677c.d(j10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            this.f31676b.b(SentryLevel.ERROR, "Failed to wait till idle", e10);
            Thread.currentThread().interrupt();
        }
    }

    public Future<?> submit(Runnable runnable) {
        if (a()) {
            this.f31677c.c();
            return super.submit(runnable);
        }
        this.f31676b.c(SentryLevel.WARNING, "Submit cancelled", new Object[0]);
        return new a();
    }
}
