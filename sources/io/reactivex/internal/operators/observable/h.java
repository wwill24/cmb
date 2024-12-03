package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import qj.q;
import qj.u;
import uj.a;
import xj.b;

public final class h<T> extends q<T> {

    /* renamed from: a  reason: collision with root package name */
    final Callable<? extends Throwable> f30456a;

    public h(Callable<? extends Throwable> callable) {
        this.f30456a = callable;
    }

    public void l0(u<? super T> uVar) {
        try {
            th = (Throwable) b.e(this.f30456a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            a.b(th);
        }
        EmptyDisposable.i(th, uVar);
    }
}
