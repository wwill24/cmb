package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import qj.q;
import qj.u;
import yj.g;

public final class s<T> extends q<T> implements g<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f30488a;

    public s(T t10) {
        this.f30488a = t10;
    }

    public T call() {
        return this.f30488a;
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super T> uVar) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(uVar, this.f30488a);
        uVar.a(scalarDisposable);
        scalarDisposable.run();
    }
}
