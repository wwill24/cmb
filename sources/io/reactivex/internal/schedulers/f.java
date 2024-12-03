package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import qj.v;
import tj.b;
import wj.a;

public class f extends v.c {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f30665a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f30666b;

    public f(ThreadFactory threadFactory) {
        this.f30665a = h.a(threadFactory);
    }

    public b b(Runnable runnable) {
        return d(runnable, 0, (TimeUnit) null);
    }

    public boolean c() {
        return this.f30666b;
    }

    public b d(Runnable runnable, long j10, TimeUnit timeUnit) {
        if (this.f30666b) {
            return EmptyDisposable.INSTANCE;
        }
        return f(runnable, j10, timeUnit, (a) null);
    }

    public void dispose() {
        if (!this.f30666b) {
            this.f30666b = true;
            this.f30665a.shutdownNow();
        }
    }

    public ScheduledRunnable f(Runnable runnable, long j10, TimeUnit timeUnit, a aVar) {
        Future future;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(bk.a.u(runnable), aVar);
        if (aVar != null && !aVar.a(scheduledRunnable)) {
            return scheduledRunnable;
        }
        if (j10 <= 0) {
            try {
                future = this.f30665a.submit(scheduledRunnable);
            } catch (RejectedExecutionException e10) {
                if (aVar != null) {
                    aVar.d(scheduledRunnable);
                }
                bk.a.s(e10);
            }
        } else {
            future = this.f30665a.schedule(scheduledRunnable, j10, timeUnit);
        }
        scheduledRunnable.a(future);
        return scheduledRunnable;
    }

    public b g(Runnable runnable, long j10, TimeUnit timeUnit) {
        Future future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(bk.a.u(runnable));
        if (j10 <= 0) {
            try {
                future = this.f30665a.submit(scheduledDirectTask);
            } catch (RejectedExecutionException e10) {
                bk.a.s(e10);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = this.f30665a.schedule(scheduledDirectTask, j10, timeUnit);
        }
        scheduledDirectTask.a(future);
        return scheduledDirectTask;
    }

    public b h(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        Future future;
        Runnable u10 = bk.a.u(runnable);
        if (j11 <= 0) {
            c cVar = new c(u10, this.f30665a);
            if (j10 <= 0) {
                try {
                    future = this.f30665a.submit(cVar);
                } catch (RejectedExecutionException e10) {
                    bk.a.s(e10);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.f30665a.schedule(cVar, j10, timeUnit);
            }
            cVar.b(future);
            return cVar;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(u10);
        try {
            scheduledDirectPeriodicTask.a(this.f30665a.scheduleAtFixedRate(scheduledDirectPeriodicTask, j10, j11, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e11) {
            bk.a.s(e11);
            return EmptyDisposable.INSTANCE;
        }
    }

    public void i() {
        if (!this.f30666b) {
            this.f30666b = true;
            this.f30665a.shutdown();
        }
    }
}
