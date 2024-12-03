package u;

import androidx.annotation.NonNull;
import androidx.camera.core.v1;
import androidx.core.util.h;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

abstract class g<V> implements zf.a<V> {

    static class a<V> extends g<V> {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final Throwable f17929a;

        a(@NonNull Throwable th2) {
            this.f17929a = th2;
        }

        public V get() throws ExecutionException {
            throw new ExecutionException(this.f17929a);
        }

        @NonNull
        public String toString() {
            return super.toString() + "[status=FAILURE, cause=[" + this.f17929a + "]]";
        }
    }

    static final class b<V> extends a<V> implements ScheduledFuture<V> {
        b(@NonNull Throwable th2) {
            super(th2);
        }

        /* renamed from: b */
        public int compareTo(@NonNull Delayed delayed) {
            return -1;
        }

        public long getDelay(@NonNull TimeUnit timeUnit) {
            return 0;
        }
    }

    static final class c<V> extends g<V> {

        /* renamed from: b  reason: collision with root package name */
        static final g<Object> f17930b = new c((Object) null);

        /* renamed from: a  reason: collision with root package name */
        private final V f17931a;

        c(V v10) {
            this.f17931a = v10;
        }

        public V get() {
            return this.f17931a;
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.f17931a + "]]";
        }
    }

    g() {
    }

    public static <V> zf.a<V> a() {
        return c.f17930b;
    }

    public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
        h.g(runnable);
        h.g(executor);
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            v1.d("ImmediateFuture", "Experienced RuntimeException while attempting to notify " + runnable + " on Executor " + executor, e10);
        }
    }

    public boolean cancel(boolean z10) {
        return false;
    }

    public abstract V get() throws ExecutionException;

    public V get(long j10, @NonNull TimeUnit timeUnit) throws ExecutionException {
        h.g(timeUnit);
        return get();
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }
}
