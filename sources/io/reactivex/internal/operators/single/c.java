package io.reactivex.internal.operators.single;

import io.reactivex.exceptions.CompositeException;
import qj.b0;
import qj.w;
import qj.z;
import tj.b;
import vj.f;

public final class c<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final b0<T> f30560a;

    /* renamed from: b  reason: collision with root package name */
    final f<? super Throwable> f30561b;

    final class a implements z<T> {

        /* renamed from: a  reason: collision with root package name */
        private final z<? super T> f30562a;

        a(z<? super T> zVar) {
            this.f30562a = zVar;
        }

        public void a(b bVar) {
            this.f30562a.a(bVar);
        }

        public void onError(Throwable th2) {
            try {
                c.this.f30561b.accept(th2);
            } catch (Throwable th3) {
                uj.a.b(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f30562a.onError(th2);
        }

        public void onSuccess(T t10) {
            this.f30562a.onSuccess(t10);
        }
    }

    public c(b0<T> b0Var, f<? super Throwable> fVar) {
        this.f30560a = b0Var;
        this.f30561b = fVar;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        this.f30560a.f(new a(zVar));
    }
}
