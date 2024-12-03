package io.reactivex.internal.schedulers;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class b implements Future<Object> {

    /* renamed from: a  reason: collision with root package name */
    final tj.b f30636a;

    b(tj.b bVar) {
        this.f30636a = bVar;
    }

    public boolean cancel(boolean z10) {
        this.f30636a.dispose();
        return false;
    }

    public Object get() throws InterruptedException, ExecutionException {
        return null;
    }

    public Object get(long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return false;
    }
}
