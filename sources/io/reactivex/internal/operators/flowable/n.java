package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.ScalarSubscription;
import qj.h;
import rn.b;
import yj.g;

public final class n<T> extends h<T> implements g<T> {

    /* renamed from: b  reason: collision with root package name */
    private final T f30283b;

    public n(T t10) {
        this.f30283b = t10;
    }

    public T call() {
        return this.f30283b;
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super T> bVar) {
        bVar.e(new ScalarSubscription(bVar, this.f30283b));
    }
}
