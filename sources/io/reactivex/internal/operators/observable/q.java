package io.reactivex.internal.operators.observable;

import qj.s;
import qj.u;
import tj.b;

public final class q<T> extends a<T, T> {

    static final class a<T> implements u<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super T> f30483a;

        /* renamed from: b  reason: collision with root package name */
        b f30484b;

        a(u<? super T> uVar) {
            this.f30483a = uVar;
        }

        public void a(b bVar) {
            this.f30484b = bVar;
            this.f30483a.a(this);
        }

        public boolean c() {
            return this.f30484b.c();
        }

        public void d(T t10) {
        }

        public void dispose() {
            this.f30484b.dispose();
        }

        public void onComplete() {
            this.f30483a.onComplete();
        }

        public void onError(Throwable th2) {
            this.f30483a.onError(th2);
        }
    }

    public q(s<T> sVar) {
        super(sVar);
    }

    public void l0(u<? super T> uVar) {
        this.f30395a.e(new a(uVar));
    }
}
