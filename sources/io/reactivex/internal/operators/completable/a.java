package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import qj.d;
import qj.f;
import xj.b;

public final class a extends qj.a {

    /* renamed from: a  reason: collision with root package name */
    final Callable<? extends f> f30112a;

    public a(Callable<? extends f> callable) {
        this.f30112a = callable;
    }

    /* access modifiers changed from: protected */
    public void E(d dVar) {
        try {
            ((f) b.e(this.f30112a.call(), "The completableSupplier returned a null CompletableSource")).e(dVar);
        } catch (Throwable th2) {
            uj.a.b(th2);
            EmptyDisposable.h(th2, dVar);
        }
    }
}
