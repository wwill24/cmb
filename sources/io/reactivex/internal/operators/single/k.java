package io.reactivex.internal.operators.single;

import io.reactivex.exceptions.CompositeException;
import qj.b0;
import qj.w;
import qj.z;
import tj.b;
import vj.j;

public final class k<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final b0<? extends T> f30584a;

    /* renamed from: b  reason: collision with root package name */
    final j<? super Throwable, ? extends T> f30585b;

    /* renamed from: c  reason: collision with root package name */
    final T f30586c;

    final class a implements z<T> {

        /* renamed from: a  reason: collision with root package name */
        private final z<? super T> f30587a;

        a(z<? super T> zVar) {
            this.f30587a = zVar;
        }

        public void a(b bVar) {
            this.f30587a.a(bVar);
        }

        public void onError(Throwable th2) {
            T t10;
            k kVar = k.this;
            j<? super Throwable, ? extends T> jVar = kVar.f30585b;
            if (jVar != null) {
                try {
                    t10 = jVar.apply(th2);
                } catch (Throwable th3) {
                    uj.a.b(th3);
                    this.f30587a.onError(new CompositeException(th2, th3));
                    return;
                }
            } else {
                t10 = kVar.f30586c;
            }
            if (t10 == null) {
                NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                nullPointerException.initCause(th2);
                this.f30587a.onError(nullPointerException);
                return;
            }
            this.f30587a.onSuccess(t10);
        }

        public void onSuccess(T t10) {
            this.f30587a.onSuccess(t10);
        }
    }

    public k(b0<? extends T> b0Var, j<? super Throwable, ? extends T> jVar, T t10) {
        this.f30584a = b0Var;
        this.f30585b = jVar;
        this.f30586c = t10;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        this.f30584a.f(new a(zVar));
    }
}
