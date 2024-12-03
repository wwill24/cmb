package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import qj.p;
import qj.s;
import tj.b;

public final class u<T> extends a<T, p<T>> {

    static final class a<T> implements qj.u<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final qj.u<? super p<T>> f30491a;

        /* renamed from: b  reason: collision with root package name */
        b f30492b;

        a(qj.u<? super p<T>> uVar) {
            this.f30491a = uVar;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.f30492b, bVar)) {
                this.f30492b = bVar;
                this.f30491a.a(this);
            }
        }

        public boolean c() {
            return this.f30492b.c();
        }

        public void d(T t10) {
            this.f30491a.d(p.c(t10));
        }

        public void dispose() {
            this.f30492b.dispose();
        }

        public void onComplete() {
            this.f30491a.d(p.a());
            this.f30491a.onComplete();
        }

        public void onError(Throwable th2) {
            this.f30491a.d(p.b(th2));
            this.f30491a.onComplete();
        }
    }

    public u(s<T> sVar) {
        super(sVar);
    }

    public void l0(qj.u<? super p<T>> uVar) {
        this.f30395a.e(new a(uVar));
    }
}
