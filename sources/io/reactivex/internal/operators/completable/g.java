package io.reactivex.internal.operators.completable;

import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import qj.d;
import tj.a;
import tj.b;

final class g implements d {

    /* renamed from: a  reason: collision with root package name */
    final d f30121a;

    /* renamed from: b  reason: collision with root package name */
    final a f30122b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicThrowable f30123c;

    /* renamed from: d  reason: collision with root package name */
    final AtomicInteger f30124d;

    g(d dVar, a aVar, AtomicThrowable atomicThrowable, AtomicInteger atomicInteger) {
        this.f30121a = dVar;
        this.f30122b = aVar;
        this.f30123c = atomicThrowable;
        this.f30124d = atomicInteger;
    }

    public void a(b bVar) {
        this.f30122b.a(bVar);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f30124d.decrementAndGet() == 0) {
            Throwable b10 = this.f30123c.b();
            if (b10 == null) {
                this.f30121a.onComplete();
            } else {
                this.f30121a.onError(b10);
            }
        }
    }

    public void onComplete() {
        b();
    }

    public void onError(Throwable th2) {
        if (this.f30123c.a(th2)) {
            b();
        } else {
            bk.a.s(th2);
        }
    }
}
