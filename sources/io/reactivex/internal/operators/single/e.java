package io.reactivex.internal.operators.single;

import qj.b0;
import qj.w;
import qj.z;
import tj.b;
import vj.f;

public final class e<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final b0<T> f30569a;

    /* renamed from: b  reason: collision with root package name */
    final f<? super T> f30570b;

    final class a implements z<T> {

        /* renamed from: a  reason: collision with root package name */
        final z<? super T> f30571a;

        a(z<? super T> zVar) {
            this.f30571a = zVar;
        }

        public void a(b bVar) {
            this.f30571a.a(bVar);
        }

        public void onError(Throwable th2) {
            this.f30571a.onError(th2);
        }

        public void onSuccess(T t10) {
            try {
                e.this.f30570b.accept(t10);
                this.f30571a.onSuccess(t10);
            } catch (Throwable th2) {
                uj.a.b(th2);
                this.f30571a.onError(th2);
            }
        }
    }

    public e(b0<T> b0Var, f<? super T> fVar) {
        this.f30569a = b0Var;
        this.f30570b = fVar;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        this.f30569a.f(new a(zVar));
    }
}
