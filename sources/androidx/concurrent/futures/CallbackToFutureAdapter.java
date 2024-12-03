package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class CallbackToFutureAdapter {

    static final class FutureGarbageCollectedException extends Throwable {
        FutureGarbageCollectedException(String str) {
            super(str);
        }

        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        Object f3628a;

        /* renamed from: b  reason: collision with root package name */
        c<T> f3629b;

        /* renamed from: c  reason: collision with root package name */
        private b<Void> f3630c = b.a();

        /* renamed from: d  reason: collision with root package name */
        private boolean f3631d;

        a() {
        }

        private void e() {
            this.f3628a = null;
            this.f3629b = null;
            this.f3630c = null;
        }

        public void a(@NonNull Runnable runnable, @NonNull Executor executor) {
            b<Void> bVar = this.f3630c;
            if (bVar != null) {
                bVar.addListener(runnable, executor);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f3628a = null;
            this.f3629b = null;
            this.f3630c.set(null);
        }

        public boolean c(T t10) {
            boolean z10 = true;
            this.f3631d = true;
            c<T> cVar = this.f3629b;
            if (cVar == null || !cVar.b(t10)) {
                z10 = false;
            }
            if (z10) {
                e();
            }
            return z10;
        }

        public boolean d() {
            boolean z10 = true;
            this.f3631d = true;
            c<T> cVar = this.f3629b;
            if (cVar == null || !cVar.a(true)) {
                z10 = false;
            }
            if (z10) {
                e();
            }
            return z10;
        }

        public boolean f(@NonNull Throwable th2) {
            boolean z10 = true;
            this.f3631d = true;
            c<T> cVar = this.f3629b;
            if (cVar == null || !cVar.c(th2)) {
                z10 = false;
            }
            if (z10) {
                e();
            }
            return z10;
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            b<Void> bVar;
            c<T> cVar = this.f3629b;
            if (cVar != null && !cVar.isDone()) {
                cVar.c(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f3628a));
            }
            if (!this.f3631d && (bVar = this.f3630c) != null) {
                bVar.set(null);
            }
        }
    }

    public interface b<T> {
        Object a(@NonNull a<T> aVar) throws Exception;
    }

    private static final class c<T> implements zf.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<a<T>> f3632a;

        /* renamed from: b  reason: collision with root package name */
        private final AbstractResolvableFuture<T> f3633b = new a();

        class a extends AbstractResolvableFuture<T> {
            a() {
            }

            /* access modifiers changed from: protected */
            public String pendingToString() {
                a aVar = c.this.f3632a.get();
                if (aVar == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + aVar.f3628a + "]";
            }
        }

        c(a<T> aVar) {
            this.f3632a = new WeakReference<>(aVar);
        }

        /* access modifiers changed from: package-private */
        public boolean a(boolean z10) {
            return this.f3633b.cancel(z10);
        }

        public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
            this.f3633b.addListener(runnable, executor);
        }

        /* access modifiers changed from: package-private */
        public boolean b(T t10) {
            return this.f3633b.set(t10);
        }

        /* access modifiers changed from: package-private */
        public boolean c(Throwable th2) {
            return this.f3633b.setException(th2);
        }

        public boolean cancel(boolean z10) {
            a aVar = this.f3632a.get();
            boolean cancel = this.f3633b.cancel(z10);
            if (cancel && aVar != null) {
                aVar.b();
            }
            return cancel;
        }

        public T get() throws InterruptedException, ExecutionException {
            return this.f3633b.get();
        }

        public boolean isCancelled() {
            return this.f3633b.isCancelled();
        }

        public boolean isDone() {
            return this.f3633b.isDone();
        }

        public String toString() {
            return this.f3633b.toString();
        }

        public T get(long j10, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return this.f3633b.get(j10, timeUnit);
        }
    }

    @NonNull
    public static <T> zf.a<T> a(@NonNull b<T> bVar) {
        a aVar = new a();
        c<T> cVar = new c<>(aVar);
        aVar.f3629b = cVar;
        aVar.f3628a = bVar.getClass();
        try {
            Object a10 = bVar.a(aVar);
            if (a10 != null) {
                aVar.f3628a = a10;
            }
        } catch (Exception e10) {
            cVar.c(e10);
        }
        return cVar;
    }
}
