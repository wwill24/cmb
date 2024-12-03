package com.uber.autodispose;

import qj.h;
import rn.a;
import rn.b;

final class f<T> extends h<T> implements n<T> {

    /* renamed from: b  reason: collision with root package name */
    private final a<T> f23324b;

    /* renamed from: c  reason: collision with root package name */
    private final qj.f f23325c;

    f(a<T> aVar, qj.f fVar) {
        this.f23324b = aVar;
        this.f23325c = fVar;
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super T> bVar) {
        this.f23324b.a(new AutoDisposingSubscriberImpl(this.f23325c, bVar));
    }
}
