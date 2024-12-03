package androidx.camera.core.impl;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.l1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public final class f1<T> implements l1<T> {

    /* renamed from: a  reason: collision with root package name */
    final t<b<T>> f2517a = new t<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<l1.a<? super T>, a<T>> f2518b = new HashMap();

    private static final class a<T> implements u<b<T>> {

        /* renamed from: a  reason: collision with root package name */
        final AtomicBoolean f2519a = new AtomicBoolean(true);

        /* renamed from: b  reason: collision with root package name */
        final l1.a<? super T> f2520b;

        /* renamed from: c  reason: collision with root package name */
        final Executor f2521c;

        a(@NonNull Executor executor, @NonNull l1.a<? super T> aVar) {
            this.f2521c = executor;
            this.f2520b = aVar;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(b bVar) {
            if (this.f2519a.get()) {
                if (bVar.a()) {
                    this.f2520b.a(bVar.d());
                    return;
                }
                h.g(bVar.c());
                this.f2520b.onError(bVar.c());
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f2519a.set(false);
        }

        /* renamed from: e */
        public void b(@NonNull b<T> bVar) {
            this.f2521c.execute(new e1(this, bVar));
        }
    }

    public static final class b<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f2522a;

        /* renamed from: b  reason: collision with root package name */
        private final Throwable f2523b;

        private b(T t10, Throwable th2) {
            this.f2522a = t10;
            this.f2523b = th2;
        }

        static <T> b<T> b(T t10) {
            return new b<>(t10, (Throwable) null);
        }

        public boolean a() {
            return this.f2523b == null;
        }

        public Throwable c() {
            return this.f2523b;
        }

        public T d() {
            if (a()) {
                return this.f2522a;
            }
            throw new IllegalStateException("Result contains an error. Does not contain a value.");
        }

        @NonNull
        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[Result: <");
            if (a()) {
                str = "Value: " + this.f2522a;
            } else {
                str = "Error: " + this.f2523b;
            }
            sb2.append(str);
            sb2.append(">]");
            return sb2.toString();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(a aVar, a aVar2) {
        if (aVar != null) {
            this.f2517a.n(aVar);
        }
        this.f2517a.j(aVar2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(CallbackToFutureAdapter.a aVar) {
        b f10 = this.f2517a.f();
        if (f10 == null) {
            aVar.f(new IllegalStateException("Observable has not yet been initialized with a value."));
        } else if (f10.a()) {
            aVar.c(f10.d());
        } else {
            h.g(f10.c());
            aVar.f(f10.c());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object k(CallbackToFutureAdapter.a aVar) throws Exception {
        androidx.camera.core.impl.utils.executor.a.d().execute(new b1(this, aVar));
        return this + " [fetch@" + SystemClock.uptimeMillis() + "]";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(a aVar) {
        this.f2517a.n(aVar);
    }

    @NonNull
    public zf.a<T> b() {
        return CallbackToFutureAdapter.a(new a1(this));
    }

    public void c(@NonNull Executor executor, @NonNull l1.a<? super T> aVar) {
        synchronized (this.f2518b) {
            a aVar2 = this.f2518b.get(aVar);
            if (aVar2 != null) {
                aVar2.c();
            }
            a aVar3 = new a(executor, aVar);
            this.f2518b.put(aVar, aVar3);
            androidx.camera.core.impl.utils.executor.a.d().execute(new d1(this, aVar2, aVar3));
        }
    }

    public void d(@NonNull l1.a<? super T> aVar) {
        synchronized (this.f2518b) {
            a remove = this.f2518b.remove(aVar);
            if (remove != null) {
                remove.c();
                androidx.camera.core.impl.utils.executor.a.d().execute(new c1(this, remove));
            }
        }
    }

    public void m(T t10) {
        this.f2517a.m(b.b(t10));
    }
}
