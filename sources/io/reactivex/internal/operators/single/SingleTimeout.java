package io.reactivex.internal.operators.single;

import bk.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import qj.b0;
import qj.v;
import qj.w;
import qj.z;
import tj.b;

public final class SingleTimeout<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final b0<T> f30534a;

    /* renamed from: b  reason: collision with root package name */
    final long f30535b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f30536c;

    /* renamed from: d  reason: collision with root package name */
    final v f30537d;

    /* renamed from: e  reason: collision with root package name */
    final b0<? extends T> f30538e;

    static final class TimeoutMainObserver<T> extends AtomicReference<b> implements z<T>, Runnable, b {
        private static final long serialVersionUID = 37497744973048446L;
        final z<? super T> downstream;
        final TimeoutFallbackObserver<T> fallback;
        b0<? extends T> other;
        final AtomicReference<b> task = new AtomicReference<>();
        final long timeout;
        final TimeUnit unit;

        static final class TimeoutFallbackObserver<T> extends AtomicReference<b> implements z<T> {
            private static final long serialVersionUID = 2071387740092105509L;
            final z<? super T> downstream;

            TimeoutFallbackObserver(z<? super T> zVar) {
                this.downstream = zVar;
            }

            public void a(b bVar) {
                DisposableHelper.i(this, bVar);
            }

            public void onError(Throwable th2) {
                this.downstream.onError(th2);
            }

            public void onSuccess(T t10) {
                this.downstream.onSuccess(t10);
            }
        }

        TimeoutMainObserver(z<? super T> zVar, b0<? extends T> b0Var, long j10, TimeUnit timeUnit) {
            this.downstream = zVar;
            this.other = b0Var;
            this.timeout = j10;
            this.unit = timeUnit;
            if (b0Var != null) {
                this.fallback = new TimeoutFallbackObserver<>(zVar);
            } else {
                this.fallback = null;
            }
        }

        public void a(b bVar) {
            DisposableHelper.i(this, bVar);
        }

        public boolean c() {
            return DisposableHelper.b((b) get());
        }

        public void dispose() {
            DisposableHelper.a(this);
            DisposableHelper.a(this.task);
            TimeoutFallbackObserver<T> timeoutFallbackObserver = this.fallback;
            if (timeoutFallbackObserver != null) {
                DisposableHelper.a(timeoutFallbackObserver);
            }
        }

        public void onError(Throwable th2) {
            b bVar = (b) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper || !compareAndSet(bVar, disposableHelper)) {
                a.s(th2);
                return;
            }
            DisposableHelper.a(this.task);
            this.downstream.onError(th2);
        }

        public void onSuccess(T t10) {
            b bVar = (b) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar != disposableHelper && compareAndSet(bVar, disposableHelper)) {
                DisposableHelper.a(this.task);
                this.downstream.onSuccess(t10);
            }
        }

        public void run() {
            b bVar = (b) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar != disposableHelper && compareAndSet(bVar, disposableHelper)) {
                if (bVar != null) {
                    bVar.dispose();
                }
                b0<? extends T> b0Var = this.other;
                if (b0Var == null) {
                    this.downstream.onError(new TimeoutException(ExceptionHelper.d(this.timeout, this.unit)));
                    return;
                }
                this.other = null;
                b0Var.f(this.fallback);
            }
        }
    }

    public SingleTimeout(b0<T> b0Var, long j10, TimeUnit timeUnit, v vVar, b0<? extends T> b0Var2) {
        this.f30534a = b0Var;
        this.f30535b = j10;
        this.f30536c = timeUnit;
        this.f30537d = vVar;
        this.f30538e = b0Var2;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        TimeoutMainObserver timeoutMainObserver = new TimeoutMainObserver(zVar, this.f30538e, this.f30535b, this.f30536c);
        zVar.a(timeoutMainObserver);
        DisposableHelper.d(timeoutMainObserver.task, this.f30537d.d(timeoutMainObserver, this.f30535b, this.f30536c));
        this.f30534a.f(timeoutMainObserver);
    }
}
