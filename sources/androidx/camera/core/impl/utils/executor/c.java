package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import u.f;

final class c extends AbstractExecutorService implements ScheduledExecutorService {

    /* renamed from: b  reason: collision with root package name */
    private static ThreadLocal<ScheduledExecutorService> f2636b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Handler f2637a;

    class a extends ThreadLocal<ScheduledExecutorService> {
        a() {
        }

        /* renamed from: a */
        public ScheduledExecutorService initialValue() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return a.d();
            }
            if (Looper.myLooper() != null) {
                return new c(new Handler(Looper.myLooper()));
            }
            return null;
        }
    }

    class b implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f2638a;

        b(Runnable runnable) {
            this.f2638a = runnable;
        }

        /* renamed from: a */
        public Void call() {
            this.f2638a.run();
            return null;
        }
    }

    /* renamed from: androidx.camera.core.impl.utils.executor.c$c  reason: collision with other inner class name */
    private static class C0019c<V> implements RunnableScheduledFuture<V> {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReference<CallbackToFutureAdapter.a<V>> f2640a = new AtomicReference<>((Object) null);

        /* renamed from: b  reason: collision with root package name */
        private final long f2641b;

        /* renamed from: c  reason: collision with root package name */
        private final Callable<V> f2642c;

        /* renamed from: d  reason: collision with root package name */
        private final zf.a<V> f2643d;

        /* renamed from: androidx.camera.core.impl.utils.executor.c$c$a */
        class a implements CallbackToFutureAdapter.b<V> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Handler f2644a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Callable f2645b;

            /* renamed from: androidx.camera.core.impl.utils.executor.c$c$a$a  reason: collision with other inner class name */
            class C0020a implements Runnable {
                C0020a() {
                }

                public void run() {
                    if (C0019c.this.f2640a.getAndSet((Object) null) != null) {
                        a aVar = a.this;
                        aVar.f2644a.removeCallbacks(C0019c.this);
                    }
                }
            }

            a(Handler handler, Callable callable) {
                this.f2644a = handler;
                this.f2645b = callable;
            }

            public Object a(@NonNull CallbackToFutureAdapter.a<V> aVar) throws RejectedExecutionException {
                aVar.a(new C0020a(), a.a());
                C0019c.this.f2640a.set(aVar);
                return "HandlerScheduledFuture-" + this.f2645b.toString();
            }
        }

        C0019c(Handler handler, long j10, Callable<V> callable) {
            this.f2641b = j10;
            this.f2642c = callable;
            this.f2643d = CallbackToFutureAdapter.a(new a(handler, callable));
        }

        /* renamed from: a */
        public int compareTo(Delayed delayed) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return Long.compare(getDelay(timeUnit), delayed.getDelay(timeUnit));
        }

        public boolean cancel(boolean z10) {
            return this.f2643d.cancel(z10);
        }

        public V get() throws ExecutionException, InterruptedException {
            return this.f2643d.get();
        }

        public long getDelay(TimeUnit timeUnit) {
            return timeUnit.convert(this.f2641b - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public boolean isCancelled() {
            return this.f2643d.isCancelled();
        }

        public boolean isDone() {
            return this.f2643d.isDone();
        }

        public boolean isPeriodic() {
            return false;
        }

        public void run() {
            CallbackToFutureAdapter.a andSet = this.f2640a.getAndSet((Object) null);
            if (andSet != null) {
                try {
                    andSet.c(this.f2642c.call());
                } catch (Exception e10) {
                    andSet.f(e10);
                }
            }
        }

        public V get(long j10, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return this.f2643d.get(j10, timeUnit);
        }
    }

    c(@NonNull Handler handler) {
        this.f2637a = handler;
    }

    private RejectedExecutionException a() {
        return new RejectedExecutionException(this.f2637a + " is shutting down");
    }

    public boolean awaitTermination(long j10, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException(c.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    }

    public void execute(@NonNull Runnable runnable) {
        if (!this.f2637a.post(runnable)) {
            throw a();
        }
    }

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public ScheduledFuture<?> schedule(@NonNull Runnable runnable, long j10, @NonNull TimeUnit timeUnit) {
        return schedule(new b(runnable), j10, timeUnit);
    }

    @NonNull
    public ScheduledFuture<?> scheduleAtFixedRate(@NonNull Runnable runnable, long j10, long j11, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException(c.class.getSimpleName() + " does not yet support fixed-rate scheduling.");
    }

    @NonNull
    public ScheduledFuture<?> scheduleWithFixedDelay(@NonNull Runnable runnable, long j10, long j11, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException(c.class.getSimpleName() + " does not yet support fixed-delay scheduling.");
    }

    public void shutdown() {
        throw new UnsupportedOperationException(c.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    }

    @NonNull
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException(c.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    }

    @NonNull
    public <V> ScheduledFuture<V> schedule(@NonNull Callable<V> callable, long j10, @NonNull TimeUnit timeUnit) {
        long uptimeMillis = SystemClock.uptimeMillis() + TimeUnit.MILLISECONDS.convert(j10, timeUnit);
        C0019c cVar = new C0019c(this.f2637a, uptimeMillis, callable);
        if (this.f2637a.postAtTime(cVar, uptimeMillis)) {
            return cVar;
        }
        return f.g(a());
    }
}
