package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import rn.b;
import uj.a;

public final class h<T> extends qj.h<T> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<? extends Throwable> f30270b;

    public h(Callable<? extends Throwable> callable) {
        this.f30270b = callable;
    }

    public void n0(b<? super T> bVar) {
        try {
            th = (Throwable) xj.b.e(this.f30270b.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            a.b(th);
        }
        EmptySubscription.c(th, bVar);
    }
}
