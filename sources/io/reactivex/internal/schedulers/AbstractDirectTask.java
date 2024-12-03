package io.reactivex.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import tj.b;
import xj.a;

abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements b {

    /* renamed from: a  reason: collision with root package name */
    protected static final FutureTask<Void> f30602a;

    /* renamed from: b  reason: collision with root package name */
    protected static final FutureTask<Void> f30603b;
    private static final long serialVersionUID = 1811839108042568751L;
    protected final Runnable runnable;
    protected Thread runner;

    static {
        Runnable runnable2 = a.f33965b;
        f30602a = new FutureTask<>(runnable2, (Object) null);
        f30603b = new FutureTask<>(runnable2, (Object) null);
    }

    AbstractDirectTask(Runnable runnable2) {
        this.runnable = runnable2;
    }

    public final void a(Future<?> future) {
        Future future2;
        boolean z10;
        do {
            future2 = (Future) get();
            if (future2 != f30602a) {
                if (future2 == f30603b) {
                    if (this.runner != Thread.currentThread()) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    future.cancel(z10);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    public final boolean c() {
        Future future = (Future) get();
        if (future == f30602a || future == f30603b) {
            return true;
        }
        return false;
    }

    public final void dispose() {
        FutureTask<Void> futureTask;
        boolean z10;
        Future future = (Future) get();
        if (future != f30602a && future != (futureTask = f30603b) && compareAndSet(future, futureTask) && future != null) {
            if (this.runner != Thread.currentThread()) {
                z10 = true;
            } else {
                z10 = false;
            }
            future.cancel(z10);
        }
    }
}
