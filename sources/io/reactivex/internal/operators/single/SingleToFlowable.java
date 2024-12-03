package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import qj.b0;
import qj.h;
import qj.z;
import tj.b;

public final class SingleToFlowable<T> extends h<T> {

    /* renamed from: b  reason: collision with root package name */
    final b0<? extends T> f30542b;

    static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements z<T> {
        private static final long serialVersionUID = 187782011903685568L;
        b upstream;

        SingleToFlowableObserver(rn.b<? super T> bVar) {
            super(bVar);
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.e(this);
            }
        }

        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        public void onSuccess(T t10) {
            c(t10);
        }
    }

    public SingleToFlowable(b0<? extends T> b0Var) {
        this.f30542b = b0Var;
    }

    public void n0(rn.b<? super T> bVar) {
        this.f30542b.f(new SingleToFlowableObserver(bVar));
    }
}
