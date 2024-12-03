package u;

import androidx.annotation.NonNull;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import com.mparticle.kits.AppsFlyerKit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import u.g;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final k.a<?, ?> f17922a = new b();

    class a implements a<I, O> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k.a f17923a;

        a(k.a aVar) {
            this.f17923a = aVar;
        }

        @NonNull
        public zf.a<O> apply(I i10) {
            return f.h(this.f17923a.apply(i10));
        }
    }

    class b implements k.a<Object, Object> {
        b() {
        }

        public Object apply(Object obj) {
            return obj;
        }
    }

    class c implements c<I> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CallbackToFutureAdapter.a f17924a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k.a f17925b;

        c(CallbackToFutureAdapter.a aVar, k.a aVar2) {
            this.f17924a = aVar;
            this.f17925b = aVar2;
        }

        public void onFailure(@NonNull Throwable th2) {
            this.f17924a.f(th2);
        }

        public void onSuccess(I i10) {
            try {
                this.f17924a.c(this.f17925b.apply(i10));
            } catch (Throwable th2) {
                this.f17924a.f(th2);
            }
        }
    }

    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ zf.a f17926a;

        d(zf.a aVar) {
            this.f17926a = aVar;
        }

        public void run() {
            this.f17926a.cancel(true);
        }
    }

    private static final class e<V> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Future<V> f17927a;

        /* renamed from: b  reason: collision with root package name */
        final c<? super V> f17928b;

        e(Future<V> future, c<? super V> cVar) {
            this.f17927a = future;
            this.f17928b = cVar;
        }

        public void run() {
            try {
                this.f17928b.onSuccess(f.d(this.f17927a));
            } catch (ExecutionException e10) {
                Throwable cause = e10.getCause();
                if (cause == null) {
                    this.f17928b.onFailure(e10);
                } else {
                    this.f17928b.onFailure(cause);
                }
            } catch (Error | RuntimeException e11) {
                this.f17928b.onFailure(e11);
            }
        }

        public String toString() {
            return e.class.getSimpleName() + AppsFlyerKit.COMMA + this.f17928b;
        }
    }

    public static <V> void b(@NonNull zf.a<V> aVar, @NonNull c<? super V> cVar, @NonNull Executor executor) {
        h.g(cVar);
        aVar.addListener(new e(aVar, cVar), executor);
    }

    @NonNull
    public static <V> zf.a<List<V>> c(@NonNull Collection<? extends zf.a<? extends V>> collection) {
        return new h(new ArrayList(collection), true, androidx.camera.core.impl.utils.executor.a.a());
    }

    public static <V> V d(@NonNull Future<V> future) throws ExecutionException {
        boolean isDone = future.isDone();
        h.j(isDone, "Future was expected to be done, " + future);
        return e(future);
    }

    public static <V> V e(@NonNull Future<V> future) throws ExecutionException {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                v10 = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th2) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return v10;
    }

    @NonNull
    public static <V> zf.a<V> f(@NonNull Throwable th2) {
        return new g.a(th2);
    }

    @NonNull
    public static <V> ScheduledFuture<V> g(@NonNull Throwable th2) {
        return new g.b(th2);
    }

    @NonNull
    public static <V> zf.a<V> h(V v10) {
        if (v10 == null) {
            return g.a();
        }
        return new g.c(v10);
    }

    @NonNull
    public static <V> zf.a<V> j(@NonNull zf.a<V> aVar) {
        h.g(aVar);
        if (aVar.isDone()) {
            return aVar;
        }
        return CallbackToFutureAdapter.a(new e(aVar));
    }

    public static <V> void k(@NonNull zf.a<V> aVar, @NonNull CallbackToFutureAdapter.a<V> aVar2) {
        l(aVar, f17922a, aVar2, androidx.camera.core.impl.utils.executor.a.a());
    }

    public static <I, O> void l(@NonNull zf.a<I> aVar, @NonNull k.a<? super I, ? extends O> aVar2, @NonNull CallbackToFutureAdapter.a<O> aVar3, @NonNull Executor executor) {
        m(true, aVar, aVar2, aVar3, executor);
    }

    /* access modifiers changed from: private */
    public static <I, O> void m(boolean z10, @NonNull zf.a<I> aVar, @NonNull k.a<? super I, ? extends O> aVar2, @NonNull CallbackToFutureAdapter.a<O> aVar3, @NonNull Executor executor) {
        h.g(aVar);
        h.g(aVar2);
        h.g(aVar3);
        h.g(executor);
        b(aVar, new c(aVar3, aVar2), executor);
        if (z10) {
            aVar3.a(new d(aVar), androidx.camera.core.impl.utils.executor.a.a());
        }
    }

    @NonNull
    public static <V> zf.a<List<V>> n(@NonNull Collection<? extends zf.a<? extends V>> collection) {
        return new h(new ArrayList(collection), false, androidx.camera.core.impl.utils.executor.a.a());
    }

    @NonNull
    public static <I, O> zf.a<O> o(@NonNull zf.a<I> aVar, @NonNull k.a<? super I, ? extends O> aVar2, @NonNull Executor executor) {
        h.g(aVar2);
        return p(aVar, new a(aVar2), executor);
    }

    @NonNull
    public static <I, O> zf.a<O> p(@NonNull zf.a<I> aVar, @NonNull a<? super I, ? extends O> aVar2, @NonNull Executor executor) {
        b bVar = new b(aVar2, aVar);
        aVar.addListener(bVar, executor);
        return bVar;
    }
}
