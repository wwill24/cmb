package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.e;

@Metadata(bv = {}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010%\u001a\u00020 ¢\u0006\u0004\b&\u0010'J.\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b*\u00020\u00032\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001c\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016J\u001e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0016J$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\t2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0013\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0016R\u001a\u0010%\u001a\u00020 8\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lkotlinx/coroutines/j1;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/r0;", "Ljava/util/concurrent/ScheduledExecutorService;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/coroutines/CoroutineContext;", "context", "", "timeMillis", "Ljava/util/concurrent/ScheduledFuture;", "f0", "Ljava/util/concurrent/RejectedExecutionException;", "exception", "", "c0", "E", "Lkotlinx/coroutines/n;", "continuation", "k", "Lkotlinx/coroutines/z0;", "u", "close", "", "toString", "", "other", "", "equals", "", "hashCode", "Ljava/util/concurrent/Executor;", "d", "Ljava/util/concurrent/Executor;", "Y", "()Ljava/util/concurrent/Executor;", "executor", "<init>", "(Ljava/util/concurrent/Executor;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class j1 extends ExecutorCoroutineDispatcher implements r0 {

    /* renamed from: d  reason: collision with root package name */
    private final Executor f32575d;

    public j1(Executor executor) {
        this.f32575d = executor;
        e.a(Y());
    }

    private final void c0(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        v1.c(coroutineContext, i1.a("The task was rejected", rejectedExecutionException));
    }

    private final ScheduledFuture<?> f0(ScheduledExecutorService scheduledExecutorService, Runnable runnable, CoroutineContext coroutineContext, long j10) {
        try {
            return scheduledExecutorService.schedule(runnable, j10, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e10) {
            c0(coroutineContext, e10);
            return null;
        }
    }

    public void E(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            Executor Y = Y();
            c.a();
            Y.execute(runnable);
        } catch (RejectedExecutionException e10) {
            c.a();
            c0(coroutineContext, e10);
            x0.b().E(coroutineContext, runnable);
        }
    }

    public Executor Y() {
        return this.f32575d;
    }

    public void close() {
        Executor Y = Y();
        ExecutorService executorService = Y instanceof ExecutorService ? (ExecutorService) Y : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof j1) && ((j1) obj).Y() == Y();
    }

    public int hashCode() {
        return System.identityHashCode(Y());
    }

    public void k(long j10, n<? super Unit> nVar) {
        ScheduledExecutorService scheduledExecutorService;
        Executor Y = Y();
        ScheduledFuture<?> scheduledFuture = null;
        if (Y instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) Y;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            scheduledFuture = f0(scheduledExecutorService, new k2(this, nVar), nVar.getContext(), j10);
        }
        if (scheduledFuture != null) {
            v1.g(nVar, scheduledFuture);
        } else {
            n0.f32584h.k(j10, nVar);
        }
    }

    public String toString() {
        return Y().toString();
    }

    public z0 u(long j10, Runnable runnable, CoroutineContext coroutineContext) {
        ScheduledExecutorService scheduledExecutorService;
        Executor Y = Y();
        ScheduledFuture<?> scheduledFuture = null;
        if (Y instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) Y;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            scheduledFuture = f0(scheduledExecutorService, runnable, coroutineContext, j10);
        }
        if (scheduledFuture != null) {
            return new y0(scheduledFuture);
        }
        return n0.f32584h.u(j10, runnable, coroutineContext);
    }
}
