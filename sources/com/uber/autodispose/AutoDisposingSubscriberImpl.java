package com.uber.autodispose;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import qj.f;
import qj.l;
import rn.c;
import tj.b;

final class AutoDisposingSubscriberImpl<T> extends AtomicInteger implements l, c, b {
    private final rn.b<? super T> delegate;
    private final AtomicThrowable error = new AtomicThrowable();
    final AtomicReference<c> mainSubscription = new AtomicReference<>();
    private final AtomicReference<c> ref = new AtomicReference<>();
    private final AtomicLong requested = new AtomicLong();
    private final f scope;
    final AtomicReference<b> scopeDisposable = new AtomicReference<>();

    class a extends ak.a {
        a() {
        }

        public void onComplete() {
            AutoDisposingSubscriberImpl.this.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            AutoSubscriptionHelper.a(AutoDisposingSubscriberImpl.this.mainSubscription);
        }

        public void onError(Throwable th2) {
            AutoDisposingSubscriberImpl.this.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposingSubscriberImpl.this.onError(th2);
        }
    }

    AutoDisposingSubscriberImpl(f fVar, rn.b<? super T> bVar) {
        this.scope = fVar;
        this.delegate = bVar;
    }

    public boolean c() {
        return this.mainSubscription.get() == AutoSubscriptionHelper.CANCELLED;
    }

    public void cancel() {
        AutoDisposableHelper.a(this.scopeDisposable);
        AutoSubscriptionHelper.a(this.mainSubscription);
    }

    public void d(T t10) {
        if (!c() && o.f(this.delegate, t10, this, this.error)) {
            this.mainSubscription.lazySet(AutoSubscriptionHelper.CANCELLED);
            AutoDisposableHelper.a(this.scopeDisposable);
        }
    }

    public void dispose() {
        cancel();
    }

    public void e(c cVar) {
        a aVar = new a();
        if (e.d(this.scopeDisposable, aVar, AutoDisposingSubscriberImpl.class)) {
            this.delegate.e(this);
            this.scope.e(aVar);
            if (e.c(this.mainSubscription, cVar, AutoDisposingSubscriberImpl.class)) {
                AutoSubscriptionHelper.c(this.ref, this.requested, cVar);
            }
        }
    }

    public void onComplete() {
        if (!c()) {
            this.mainSubscription.lazySet(AutoSubscriptionHelper.CANCELLED);
            AutoDisposableHelper.a(this.scopeDisposable);
            o.b(this.delegate, this, this.error);
        }
    }

    public void onError(Throwable th2) {
        if (!c()) {
            this.mainSubscription.lazySet(AutoSubscriptionHelper.CANCELLED);
            AutoDisposableHelper.a(this.scopeDisposable);
            o.d(this.delegate, th2, this, this.error);
        }
    }

    public void r(long j10) {
        AutoSubscriptionHelper.b(this.ref, this.requested, j10);
    }
}
