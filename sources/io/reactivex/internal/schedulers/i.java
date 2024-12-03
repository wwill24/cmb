package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import qj.v;
import tj.b;

public final class i extends v {

    /* renamed from: e  reason: collision with root package name */
    static final RxThreadFactory f30671e = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);

    /* renamed from: f  reason: collision with root package name */
    static final ScheduledExecutorService f30672f;

    /* renamed from: c  reason: collision with root package name */
    final ThreadFactory f30673c;

    /* renamed from: d  reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f30674d;

    static final class a extends v.c {

        /* renamed from: a  reason: collision with root package name */
        final ScheduledExecutorService f30675a;

        /* renamed from: b  reason: collision with root package name */
        final tj.a f30676b = new tj.a();

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f30677c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f30675a = scheduledExecutorService;
        }

        public boolean c() {
            return this.f30677c;
        }

        public b d(Runnable runnable, long j10, TimeUnit timeUnit) {
            Future future;
            if (this.f30677c) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(bk.a.u(runnable), this.f30676b);
            this.f30676b.a(scheduledRunnable);
            if (j10 <= 0) {
                try {
                    future = this.f30675a.submit(scheduledRunnable);
                } catch (RejectedExecutionException e10) {
                    dispose();
                    bk.a.s(e10);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.f30675a.schedule(scheduledRunnable, j10, timeUnit);
            }
            scheduledRunnable.a(future);
            return scheduledRunnable;
        }

        public void dispose() {
            if (!this.f30677c) {
                this.f30677c = true;
                this.f30676b.dispose();
            }
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f30672f = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    public i() {
        this(f30671e);
    }

    static ScheduledExecutorService f(ThreadFactory threadFactory) {
        return h.a(threadFactory);
    }

    public v.c b() {
        return new a(this.f30674d.get());
    }

    public b d(Runnable runnable, long j10, TimeUnit timeUnit) {
        Future future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(bk.a.u(runnable));
        if (j10 <= 0) {
            try {
                future = this.f30674d.get().submit(scheduledDirectTask);
            } catch (RejectedExecutionException e10) {
                bk.a.s(e10);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = this.f30674d.get().schedule(scheduledDirectTask, j10, timeUnit);
        }
        scheduledDirectTask.a(future);
        return scheduledDirectTask;
    }

    public b e(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        Future future;
        Runnable u10 = bk.a.u(runnable);
        if (j11 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f30674d.get();
            c cVar = new c(u10, scheduledExecutorService);
            if (j10 <= 0) {
                try {
                    future = scheduledExecutorService.submit(cVar);
                } catch (RejectedExecutionException e10) {
                    bk.a.s(e10);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = scheduledExecutorService.schedule(cVar, j10, timeUnit);
            }
            cVar.b(future);
            return cVar;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(u10);
        try {
            scheduledDirectPeriodicTask.a(this.f30674d.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j10, j11, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e11) {
            bk.a.s(e11);
            return EmptyDisposable.INSTANCE;
        }
    }

    public i(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f30674d = atomicReference;
        this.f30673c = threadFactory;
        atomicReference.lazySet(f(threadFactory));
    }
}
