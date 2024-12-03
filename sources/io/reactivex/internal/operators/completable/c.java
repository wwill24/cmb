package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.EmptyDisposable;
import qj.a;
import qj.d;

public final class c extends a {

    /* renamed from: a  reason: collision with root package name */
    final Throwable f30114a;

    public c(Throwable th2) {
        this.f30114a = th2;
    }

    /* access modifiers changed from: protected */
    public void E(d dVar) {
        EmptyDisposable.h(this.f30114a, dVar);
    }
}
