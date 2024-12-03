package io.reactivex.internal.schedulers;

import androidx.camera.view.h;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import tj.b;
import xj.a;

final class c implements Callable<Void>, b {

    /* renamed from: f  reason: collision with root package name */
    static final FutureTask<Void> f30637f = new FutureTask<>(a.f33965b, (Object) null);

    /* renamed from: a  reason: collision with root package name */
    final Runnable f30638a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<Future<?>> f30639b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<Future<?>> f30640c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    final ExecutorService f30641d;

    /* renamed from: e  reason: collision with root package name */
    Thread f30642e;

    c(Runnable runnable, ExecutorService executorService) {
        this.f30638a = runnable;
        this.f30641d = executorService;
    }

    /* renamed from: a */
    public Void call() throws Exception {
        this.f30642e = Thread.currentThread();
        try {
            this.f30638a.run();
            d(this.f30641d.submit(this));
            this.f30642e = null;
        } catch (Throwable th2) {
            this.f30642e = null;
            bk.a.s(th2);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void b(Future<?> future) {
        Future future2;
        boolean z10;
        do {
            future2 = this.f30640c.get();
            if (future2 == f30637f) {
                if (this.f30642e != Thread.currentThread()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                future.cancel(z10);
                return;
            }
        } while (!h.a(this.f30640c, future2, future));
    }

    public boolean c() {
        return this.f30640c.get() == f30637f;
    }

    /* access modifiers changed from: package-private */
    public void d(Future<?> future) {
        Future future2;
        boolean z10;
        do {
            future2 = this.f30639b.get();
            if (future2 == f30637f) {
                if (this.f30642e != Thread.currentThread()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                future.cancel(z10);
                return;
            }
        } while (!h.a(this.f30639b, future2, future));
    }

    public void dispose() {
        boolean z10;
        AtomicReference<Future<?>> atomicReference = this.f30640c;
        Future future = f30637f;
        Future andSet = atomicReference.getAndSet(future);
        boolean z11 = true;
        if (!(andSet == null || andSet == future)) {
            if (this.f30642e != Thread.currentThread()) {
                z10 = true;
            } else {
                z10 = false;
            }
            andSet.cancel(z10);
        }
        Future andSet2 = this.f30639b.getAndSet(future);
        if (andSet2 != null && andSet2 != future) {
            if (this.f30642e == Thread.currentThread()) {
                z11 = false;
            }
            andSet2.cancel(z11);
        }
    }
}
