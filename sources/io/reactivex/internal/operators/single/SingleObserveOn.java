package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import qj.b0;
import qj.v;
import qj.w;
import qj.z;
import tj.b;

public final class SingleObserveOn<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final b0<T> f30528a;

    /* renamed from: b  reason: collision with root package name */
    final v f30529b;

    static final class ObserveOnSingleObserver<T> extends AtomicReference<b> implements z<T>, b, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;
        final z<? super T> downstream;
        Throwable error;
        final v scheduler;
        T value;

        ObserveOnSingleObserver(z<? super T> zVar, v vVar) {
            this.downstream = zVar;
            this.scheduler = vVar;
        }

        public void a(b bVar) {
            if (DisposableHelper.i(this, bVar)) {
                this.downstream.a(this);
            }
        }

        public boolean c() {
            return DisposableHelper.b((b) get());
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public void onError(Throwable th2) {
            this.error = th2;
            DisposableHelper.d(this, this.scheduler.c(this));
        }

        public void onSuccess(T t10) {
            this.value = t10;
            DisposableHelper.d(this, this.scheduler.c(this));
        }

        public void run() {
            Throwable th2 = this.error;
            if (th2 != null) {
                this.downstream.onError(th2);
            } else {
                this.downstream.onSuccess(this.value);
            }
        }
    }

    public SingleObserveOn(b0<T> b0Var, v vVar) {
        this.f30528a = b0Var;
        this.f30529b = vVar;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        this.f30528a.f(new ObserveOnSingleObserver(zVar, this.f30529b));
    }
}
