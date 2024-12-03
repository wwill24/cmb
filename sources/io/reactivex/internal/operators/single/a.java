package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import qj.b0;
import qj.w;
import qj.z;
import xj.b;

public final class a<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final Callable<? extends b0<? extends T>> f30547a;

    public a(Callable<? extends b0<? extends T>> callable) {
        this.f30547a = callable;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        try {
            ((b0) b.e(this.f30547a.call(), "The singleSupplier returned a null SingleSource")).f(zVar);
        } catch (Throwable th2) {
            uj.a.b(th2);
            EmptyDisposable.j(th2, zVar);
        }
    }
}
