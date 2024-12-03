package io.reactivex.internal.operators.completable;

import qj.b0;
import qj.d;
import qj.z;
import tj.b;

public final class f<T> extends qj.a {

    /* renamed from: a  reason: collision with root package name */
    final b0<T> f30119a;

    static final class a<T> implements z<T> {

        /* renamed from: a  reason: collision with root package name */
        final d f30120a;

        a(d dVar) {
            this.f30120a = dVar;
        }

        public void a(b bVar) {
            this.f30120a.a(bVar);
        }

        public void onError(Throwable th2) {
            this.f30120a.onError(th2);
        }

        public void onSuccess(T t10) {
            this.f30120a.onComplete();
        }
    }

    public f(b0<T> b0Var) {
        this.f30119a = b0Var;
    }

    /* access modifiers changed from: protected */
    public void E(d dVar) {
        this.f30119a.f(new a(dVar));
    }
}
