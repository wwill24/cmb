package com.uber.autodispose;

import java.util.concurrent.atomic.AtomicReference;
import qj.d;
import qj.f;
import tj.b;

final class k implements d, b {

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<b> f23333a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<b> f23334b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    private final f f23335c;

    /* renamed from: d  reason: collision with root package name */
    private final d f23336d;

    class a extends ak.a {
        a() {
        }

        public void onComplete() {
            k.this.f23334b.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.a(k.this.f23333a);
        }

        public void onError(Throwable th2) {
            k.this.f23334b.lazySet(AutoDisposableHelper.DISPOSED);
            k.this.onError(th2);
        }
    }

    k(f fVar, d dVar) {
        this.f23335c = fVar;
        this.f23336d = dVar;
    }

    public void a(b bVar) {
        Class<k> cls = k.class;
        a aVar = new a();
        if (e.d(this.f23334b, aVar, cls)) {
            this.f23336d.a(this);
            this.f23335c.e(aVar);
            e.d(this.f23333a, bVar, cls);
        }
    }

    public boolean c() {
        return this.f23333a.get() == AutoDisposableHelper.DISPOSED;
    }

    public void dispose() {
        AutoDisposableHelper.a(this.f23334b);
        AutoDisposableHelper.a(this.f23333a);
    }

    public void onComplete() {
        if (!c()) {
            this.f23333a.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.a(this.f23334b);
            this.f23336d.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (!c()) {
            this.f23333a.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.a(this.f23334b);
            this.f23336d.onError(th2);
        }
    }
}
