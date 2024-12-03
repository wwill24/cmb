package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Callable;
import qj.q;
import qj.u;
import uj.a;
import xj.b;

public final class l<T> extends q<T> implements Callable<T> {

    /* renamed from: a  reason: collision with root package name */
    final Callable<? extends T> f30469a;

    public l(Callable<? extends T> callable) {
        this.f30469a = callable;
    }

    public T call() throws Exception {
        return b.e(this.f30469a.call(), "The callable returned a null value");
    }

    public void l0(u<? super T> uVar) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(uVar);
        uVar.a(deferredScalarDisposable);
        if (!deferredScalarDisposable.c()) {
            try {
                deferredScalarDisposable.e(b.e(this.f30469a.call(), "Callable returned null"));
            } catch (Throwable th2) {
                a.b(th2);
                if (!deferredScalarDisposable.c()) {
                    uVar.onError(th2);
                } else {
                    bk.a.s(th2);
                }
            }
        }
    }
}
