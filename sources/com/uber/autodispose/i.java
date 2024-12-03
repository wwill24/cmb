package com.uber.autodispose;

import qj.b0;
import qj.f;
import qj.w;
import qj.z;

final class i<T> extends w<T> implements t<T> {

    /* renamed from: a  reason: collision with root package name */
    private final b0<T> f23331a;

    /* renamed from: b  reason: collision with root package name */
    private final f f23332b;

    i(b0<T> b0Var, f fVar) {
        this.f23331a = b0Var;
        this.f23332b = fVar;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        this.f23331a.f(new l(this.f23332b, zVar));
    }
}
