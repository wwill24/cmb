package io.reactivex.internal.operators.single;

import qj.b0;
import qj.w;
import qj.z;
import tj.b;

public final class j<T, R> extends w<R> {

    /* renamed from: a  reason: collision with root package name */
    final b0<? extends T> f30580a;

    /* renamed from: b  reason: collision with root package name */
    final vj.j<? super T, ? extends R> f30581b;

    static final class a<T, R> implements z<T> {

        /* renamed from: a  reason: collision with root package name */
        final z<? super R> f30582a;

        /* renamed from: b  reason: collision with root package name */
        final vj.j<? super T, ? extends R> f30583b;

        a(z<? super R> zVar, vj.j<? super T, ? extends R> jVar) {
            this.f30582a = zVar;
            this.f30583b = jVar;
        }

        public void a(b bVar) {
            this.f30582a.a(bVar);
        }

        public void onError(Throwable th2) {
            this.f30582a.onError(th2);
        }

        public void onSuccess(T t10) {
            try {
                this.f30582a.onSuccess(xj.b.e(this.f30583b.apply(t10), "The mapper function returned a null value."));
            } catch (Throwable th2) {
                uj.a.b(th2);
                onError(th2);
            }
        }
    }

    public j(b0<? extends T> b0Var, vj.j<? super T, ? extends R> jVar) {
        this.f30580a = b0Var;
        this.f30581b = jVar;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super R> zVar) {
        this.f30580a.f(new a(zVar, this.f30581b));
    }
}
