package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import qj.b0;
import qj.q;
import qj.u;
import qj.z;
import tj.b;

public final class SingleToObservable<T> extends q<T> {

    /* renamed from: a  reason: collision with root package name */
    final b0<? extends T> f30543a;

    static final class SingleToObservableObserver<T> extends DeferredScalarDisposable<T> implements z<T> {
        private static final long serialVersionUID = 3786543492451018833L;
        b upstream;

        SingleToObservableObserver(u<? super T> uVar) {
            super(uVar);
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.a(this);
            }
        }

        public void dispose() {
            super.dispose();
            this.upstream.dispose();
        }

        public void onError(Throwable th2) {
            f(th2);
        }

        public void onSuccess(T t10) {
            e(t10);
        }
    }

    public SingleToObservable(b0<? extends T> b0Var) {
        this.f30543a = b0Var;
    }

    public static <T> z<T> A0(u<? super T> uVar) {
        return new SingleToObservableObserver(uVar);
    }

    public void l0(u<? super T> uVar) {
        this.f30543a.f(A0(uVar));
    }
}
