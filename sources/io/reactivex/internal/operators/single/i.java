package io.reactivex.internal.operators.single;

import io.reactivex.disposables.a;
import qj.w;
import qj.z;

public final class i<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final T f30579a;

    public i(T t10) {
        this.f30579a = t10;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        zVar.a(a.a());
        zVar.onSuccess(this.f30579a);
    }
}
