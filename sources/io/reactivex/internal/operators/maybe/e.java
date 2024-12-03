package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.a;
import qj.m;
import qj.n;
import yj.g;

public final class e<T> extends m<T> implements g<T> {

    /* renamed from: a  reason: collision with root package name */
    final T f30316a;

    public e(T t10) {
        this.f30316a = t10;
    }

    public T call() {
        return this.f30316a;
    }

    /* access modifiers changed from: protected */
    public void f(n<? super T> nVar) {
        nVar.a(a.a());
        nVar.onSuccess(this.f30316a);
    }
}
