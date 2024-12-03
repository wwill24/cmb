package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.a;
import java.util.concurrent.Callable;
import qj.m;
import qj.n;
import tj.b;

public final class d<T> extends m<T> implements Callable<T> {

    /* renamed from: a  reason: collision with root package name */
    final Callable<? extends T> f30315a;

    public d(Callable<? extends T> callable) {
        this.f30315a = callable;
    }

    public T call() throws Exception {
        return this.f30315a.call();
    }

    /* access modifiers changed from: protected */
    public void f(n<? super T> nVar) {
        b b10 = a.b();
        nVar.a(b10);
        if (!b10.c()) {
            try {
                Object call = this.f30315a.call();
                if (b10.c()) {
                    return;
                }
                if (call == null) {
                    nVar.onComplete();
                } else {
                    nVar.onSuccess(call);
                }
            } catch (Throwable th2) {
                uj.a.b(th2);
                if (!b10.c()) {
                    nVar.onError(th2);
                } else {
                    bk.a.s(th2);
                }
            }
        }
    }
}
