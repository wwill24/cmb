package com.clevertap.android.sdk.task;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class f implements ExecutorService {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public long f10806a = 0;

    /* renamed from: b  reason: collision with root package name */
    ExecutorService f10807b = Executors.newSingleThreadExecutor();

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f10808a;

        a(Runnable runnable) {
            this.f10808a = runnable;
        }

        public void run() {
            long unused = f.this.f10806a = Thread.currentThread().getId();
            this.f10808a.run();
        }
    }

    class b implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Callable f10810a;

        b(Callable callable) {
            this.f10810a = callable;
        }

        public T call() throws Exception {
            long unused = f.this.f10806a = Thread.currentThread().getId();
            return this.f10810a.call();
        }
    }

    f() {
    }

    public boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.f10807b.awaitTermination(j10, timeUnit);
    }

    public void execute(Runnable runnable) {
        boolean z10;
        if (runnable != null) {
            if (Thread.currentThread().getId() == this.f10806a) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                runnable.run();
            } else {
                this.f10807b.execute(new a(runnable));
            }
        } else {
            throw new NullPointerException("PostAsyncSafelyExecutor#execute: task can't ne null");
        }
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("PostAsyncSafelyExecutor#invokeAll: This method is not supported");
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("PostAsyncSafelyExecutor#invokeAny: This method is not supported");
    }

    public boolean isShutdown() {
        return this.f10807b.isShutdown();
    }

    public boolean isTerminated() {
        return this.f10807b.isTerminated();
    }

    public void shutdown() {
        this.f10807b.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.f10807b.shutdownNow();
    }

    public <T> Future<T> submit(Callable<T> callable) {
        if (callable != null) {
            if (!(Thread.currentThread().getId() == this.f10806a)) {
                return this.f10807b.submit(new b(callable));
            }
            try {
                callable.call();
                return null;
            } catch (Exception e10) {
                e10.printStackTrace();
                return null;
            }
        } else {
            throw new NullPointerException("PostAsyncSafelyExecutor#submit: task can't ne null");
        }
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("PostAsyncSafelyExecutor#invokeAll: This method is not supported");
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("PostAsyncSafelyExecutor#invokeAny: This method is not supported");
    }

    public <T> Future<T> submit(Runnable runnable, T t10) {
        if (runnable != null) {
            FutureTask futureTask = new FutureTask(runnable, t10);
            execute(futureTask);
            return futureTask;
        }
        throw new NullPointerException("PostAsyncSafelyExecutor#submit: task can't ne null");
    }

    public Future<?> submit(Runnable runnable) {
        if (runnable != null) {
            FutureTask futureTask = new FutureTask(runnable, (Object) null);
            execute(futureTask);
            return futureTask;
        }
        throw new NullPointerException("PostAsyncSafelyExecutor#submit: task can't ne null");
    }
}
