package io.reactivex.internal.operators.single;

import io.reactivex.disposables.a;
import java.util.concurrent.Callable;
import qj.w;
import qj.z;
import tj.b;

public final class h<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final Callable<? extends T> f30578a;

    public h(Callable<? extends T> callable) {
        this.f30578a = callable;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        b b10 = a.b();
        zVar.a(b10);
        if (!b10.c()) {
            try {
                Object e10 = xj.b.e(this.f30578a.call(), "The callable returned a null value");
                if (!b10.c()) {
                    zVar.onSuccess(e10);
                }
            } catch (Throwable th2) {
                uj.a.b(th2);
                if (!b10.c()) {
                    zVar.onError(th2);
                } else {
                    bk.a.s(th2);
                }
            }
        }
    }
}
