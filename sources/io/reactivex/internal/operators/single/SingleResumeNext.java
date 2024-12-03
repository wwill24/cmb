package io.reactivex.internal.operators.single;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.f;
import java.util.concurrent.atomic.AtomicReference;
import qj.b0;
import qj.w;
import qj.z;
import tj.b;
import uj.a;
import vj.j;

public final class SingleResumeNext<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final b0<? extends T> f30530a;

    /* renamed from: b  reason: collision with root package name */
    final j<? super Throwable, ? extends b0<? extends T>> f30531b;

    static final class ResumeMainSingleObserver<T> extends AtomicReference<b> implements z<T>, b {
        private static final long serialVersionUID = -5314538511045349925L;
        final z<? super T> downstream;
        final j<? super Throwable, ? extends b0<? extends T>> nextFunction;

        ResumeMainSingleObserver(z<? super T> zVar, j<? super Throwable, ? extends b0<? extends T>> jVar) {
            this.downstream = zVar;
            this.nextFunction = jVar;
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
            try {
                ((b0) xj.b.e(this.nextFunction.apply(th2), "The nextFunction returned a null SingleSource.")).f(new f(this, this.downstream));
            } catch (Throwable th3) {
                a.b(th3);
                this.downstream.onError(new CompositeException(th2, th3));
            }
        }

        public void onSuccess(T t10) {
            this.downstream.onSuccess(t10);
        }
    }

    public SingleResumeNext(b0<? extends T> b0Var, j<? super Throwable, ? extends b0<? extends T>> jVar) {
        this.f30530a = b0Var;
        this.f30531b = jVar;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        this.f30530a.f(new ResumeMainSingleObserver(zVar, this.f30531b));
    }
}
