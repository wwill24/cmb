package com.uber.autodispose;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import qj.f;
import qj.u;
import tj.b;

final class AutoDisposingObserverImpl<T> extends AtomicInteger implements u, b {
    private final u<? super T> delegate;
    private final AtomicThrowable error = new AtomicThrowable();
    final AtomicReference<b> mainDisposable = new AtomicReference<>();
    private final f scope;
    final AtomicReference<b> scopeDisposable = new AtomicReference<>();

    class a extends ak.a {
        a() {
        }

        public void onComplete() {
            AutoDisposingObserverImpl.this.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.a(AutoDisposingObserverImpl.this.mainDisposable);
        }

        public void onError(Throwable th2) {
            AutoDisposingObserverImpl.this.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposingObserverImpl.this.onError(th2);
        }
    }

    AutoDisposingObserverImpl(f fVar, u<? super T> uVar) {
        this.scope = fVar;
        this.delegate = uVar;
    }

    public void a(b bVar) {
        a aVar = new a();
        if (e.d(this.scopeDisposable, aVar, AutoDisposingObserverImpl.class)) {
            this.delegate.a(this);
            this.scope.e(aVar);
            e.d(this.mainDisposable, bVar, AutoDisposingObserverImpl.class);
        }
    }

    public boolean c() {
        return this.mainDisposable.get() == AutoDisposableHelper.DISPOSED;
    }

    public void d(T t10) {
        if (!c() && o.e(this.delegate, t10, this, this.error)) {
            this.mainDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.a(this.scopeDisposable);
        }
    }

    public void dispose() {
        AutoDisposableHelper.a(this.scopeDisposable);
        AutoDisposableHelper.a(this.mainDisposable);
    }

    public void onComplete() {
        if (!c()) {
            this.mainDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.a(this.scopeDisposable);
            o.a(this.delegate, this, this.error);
        }
    }

    public void onError(Throwable th2) {
        if (!c()) {
            this.mainDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.a(this.scopeDisposable);
            o.c(this.delegate, th2, this, this.error);
        }
    }
}
