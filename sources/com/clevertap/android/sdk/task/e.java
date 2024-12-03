package com.clevertap.android.sdk.task;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class e implements ExecutorService {

    /* renamed from: a  reason: collision with root package name */
    private final int f10804a;

    /* renamed from: b  reason: collision with root package name */
    ExecutorService f10805b;

    e() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.f10804a = availableProcessors;
        this.f10805b = new ThreadPoolExecutor(availableProcessors * 2, availableProcessors * 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.f10805b.awaitTermination(j10, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.f10805b.execute(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f10805b.invokeAll(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return this.f10805b.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.f10805b.isShutdown();
    }

    public boolean isTerminated() {
        return this.f10805b.isTerminated();
    }

    public void shutdown() {
        this.f10805b.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.f10805b.shutdownNow();
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.f10805b.submit(callable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.f10805b.invokeAll(collection, j10, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.f10805b.invokeAny(collection, j10, timeUnit);
    }

    public <T> Future<T> submit(Runnable runnable, T t10) {
        return this.f10805b.submit(runnable, t10);
    }

    public Future<?> submit(Runnable runnable) {
        return this.f10805b.submit(runnable);
    }
}
