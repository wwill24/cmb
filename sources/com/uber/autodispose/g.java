package com.uber.autodispose;

import qj.f;
import qj.q;
import qj.s;
import qj.u;

final class g<T> extends q<T> implements p<T> {

    /* renamed from: a  reason: collision with root package name */
    private final s<T> f23326a;

    /* renamed from: b  reason: collision with root package name */
    private final f f23327b;

    g(s<T> sVar, f fVar) {
        this.f23326a = sVar;
        this.f23327b = fVar;
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super T> uVar) {
        this.f23326a.e(new AutoDisposingObserverImpl(this.f23327b, uVar));
    }
}
