package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import qj.n;
import qj.o;
import tj.b;
import vj.l;

public final class c<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final l<? super T> f30311b;

    static final class a<T> implements n<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final n<? super T> f30312a;

        /* renamed from: b  reason: collision with root package name */
        final l<? super T> f30313b;

        /* renamed from: c  reason: collision with root package name */
        b f30314c;

        a(n<? super T> nVar, l<? super T> lVar) {
            this.f30312a = nVar;
            this.f30313b = lVar;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.f30314c, bVar)) {
                this.f30314c = bVar;
                this.f30312a.a(this);
            }
        }

        public boolean c() {
            return this.f30314c.c();
        }

        public void dispose() {
            b bVar = this.f30314c;
            this.f30314c = DisposableHelper.DISPOSED;
            bVar.dispose();
        }

        public void onComplete() {
            this.f30312a.onComplete();
        }

        public void onError(Throwable th2) {
            this.f30312a.onError(th2);
        }

        public void onSuccess(T t10) {
            try {
                if (this.f30313b.test(t10)) {
                    this.f30312a.onSuccess(t10);
                } else {
                    this.f30312a.onComplete();
                }
            } catch (Throwable th2) {
                uj.a.b(th2);
                this.f30312a.onError(th2);
            }
        }
    }

    public c(o<T> oVar, l<? super T> lVar) {
        super(oVar);
        this.f30311b = lVar;
    }

    /* access modifiers changed from: protected */
    public void f(n<? super T> nVar) {
        this.f30309a.a(new a(nVar, this.f30311b));
    }
}
