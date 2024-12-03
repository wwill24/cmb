package io.reactivex.internal.operators.observable;

import qj.d;
import qj.q;
import qj.s;
import qj.u;
import tj.b;
import yj.c;

public final class r<T> extends qj.a implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    final s<T> f30485a;

    static final class a<T> implements u<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final d f30486a;

        /* renamed from: b  reason: collision with root package name */
        b f30487b;

        a(d dVar) {
            this.f30486a = dVar;
        }

        public void a(b bVar) {
            this.f30487b = bVar;
            this.f30486a.a(this);
        }

        public boolean c() {
            return this.f30487b.c();
        }

        public void d(T t10) {
        }

        public void dispose() {
            this.f30487b.dispose();
        }

        public void onComplete() {
            this.f30486a.onComplete();
        }

        public void onError(Throwable th2) {
            this.f30486a.onError(th2);
        }
    }

    public r(s<T> sVar) {
        this.f30485a = sVar;
    }

    public void E(d dVar) {
        this.f30485a.e(new a(dVar));
    }

    public q<T> h() {
        return bk.a.n(new q(this.f30485a));
    }
}
