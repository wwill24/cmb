package u;

import androidx.annotation.NonNull;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class d<V> implements zf.a<V> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final zf.a<V> f17918a;

    /* renamed from: b  reason: collision with root package name */
    CallbackToFutureAdapter.a<V> f17919b;

    class a implements CallbackToFutureAdapter.b<V> {
        a() {
        }

        public Object a(@NonNull CallbackToFutureAdapter.a<V> aVar) {
            boolean z10;
            if (d.this.f17919b == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            h.j(z10, "The result can only set once!");
            d.this.f17919b = aVar;
            return "FutureChain[" + d.this + "]";
        }
    }

    d(@NonNull zf.a<V> aVar) {
        this.f17918a = (zf.a) h.g(aVar);
    }

    @NonNull
    public static <V> d<V> a(@NonNull zf.a<V> aVar) {
        if (aVar instanceof d) {
            return (d) aVar;
        }
        return new d<>(aVar);
    }

    public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
        this.f17918a.addListener(runnable, executor);
    }

    /* access modifiers changed from: package-private */
    public boolean b(V v10) {
        CallbackToFutureAdapter.a<V> aVar = this.f17919b;
        if (aVar != null) {
            return aVar.c(v10);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean c(@NonNull Throwable th2) {
        CallbackToFutureAdapter.a<V> aVar = this.f17919b;
        if (aVar != null) {
            return aVar.f(th2);
        }
        return false;
    }

    public boolean cancel(boolean z10) {
        return this.f17918a.cancel(z10);
    }

    @NonNull
    public final <T> d<T> d(@NonNull k.a<? super V, T> aVar, @NonNull Executor executor) {
        return (d) f.o(this, aVar, executor);
    }

    @NonNull
    public final <T> d<T> e(@NonNull a<? super V, T> aVar, @NonNull Executor executor) {
        return (d) f.p(this, aVar, executor);
    }

    public V get() throws InterruptedException, ExecutionException {
        return this.f17918a.get();
    }

    public boolean isCancelled() {
        return this.f17918a.isCancelled();
    }

    public boolean isDone() {
        return this.f17918a.isDone();
    }

    public V get(long j10, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f17918a.get(j10, timeUnit);
    }

    d() {
        this.f17918a = CallbackToFutureAdapter.a(new a());
    }
}
