package io.reactivex.internal.operators.single;

import io.reactivex.exceptions.CompositeException;
import qj.b0;
import qj.w;
import qj.z;
import tj.b;

public final class f<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final b0<T> f30573a;

    /* renamed from: b  reason: collision with root package name */
    final vj.a f30574b;

    final class a implements z<T> {

        /* renamed from: a  reason: collision with root package name */
        final z<? super T> f30575a;

        a(z<? super T> zVar) {
            this.f30575a = zVar;
        }

        public void a(b bVar) {
            this.f30575a.a(bVar);
        }

        public void onError(Throwable th2) {
            try {
                f.this.f30574b.run();
            } catch (Throwable th3) {
                uj.a.b(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f30575a.onError(th2);
        }

        public void onSuccess(T t10) {
            try {
                f.this.f30574b.run();
                this.f30575a.onSuccess(t10);
            } catch (Throwable th2) {
                uj.a.b(th2);
                this.f30575a.onError(th2);
            }
        }
    }

    public f(b0<T> b0Var, vj.a aVar) {
        this.f30573a = b0Var;
        this.f30574b = aVar;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        this.f30573a.f(new a(zVar));
    }
}
