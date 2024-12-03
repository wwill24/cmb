package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import qj.w;
import qj.z;
import uj.a;
import xj.b;

public final class g<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final Callable<? extends Throwable> f30577a;

    public g(Callable<? extends Throwable> callable) {
        this.f30577a = callable;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        try {
            th = (Throwable) b.e(this.f30577a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            a.b(th);
        }
        EmptyDisposable.j(th, zVar);
    }
}
