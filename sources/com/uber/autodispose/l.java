package com.uber.autodispose;

import java.util.concurrent.atomic.AtomicReference;
import qj.f;
import qj.z;
import tj.b;

final class l<T> implements z, b {

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<b> f23338a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<b> f23339b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    private final f f23340c;

    /* renamed from: d  reason: collision with root package name */
    private final z<? super T> f23341d;

    class a extends ak.a {
        a() {
        }

        public void onComplete() {
            l.this.f23339b.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.a(l.this.f23338a);
        }

        public void onError(Throwable th2) {
            l.this.f23339b.lazySet(AutoDisposableHelper.DISPOSED);
            l.this.onError(th2);
        }
    }

    l(f fVar, z<? super T> zVar) {
        this.f23340c = fVar;
        this.f23341d = zVar;
    }

    public void a(b bVar) {
        Class<l> cls = l.class;
        a aVar = new a();
        if (e.d(this.f23339b, aVar, cls)) {
            this.f23341d.a(this);
            this.f23340c.e(aVar);
            e.d(this.f23338a, bVar, cls);
        }
    }

    public boolean c() {
        return this.f23338a.get() == AutoDisposableHelper.DISPOSED;
    }

    public void dispose() {
        AutoDisposableHelper.a(this.f23339b);
        AutoDisposableHelper.a(this.f23338a);
    }

    public void onError(Throwable th2) {
        if (!c()) {
            this.f23338a.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.a(this.f23339b);
            this.f23341d.onError(th2);
        }
    }

    public void onSuccess(T t10) {
        if (!c()) {
            this.f23338a.lazySet(AutoDisposableHelper.DISPOSED);
            AutoDisposableHelper.a(this.f23339b);
            this.f23341d.onSuccess(t10);
        }
    }
}
