package com.coffeemeetsbagel.domain.repository;

import fj.d;
import fk.a;
import u6.f;

public final class b0 implements d<a0> {

    /* renamed from: a  reason: collision with root package name */
    private final a<f> f12473a;

    public b0(a<f> aVar) {
        this.f12473a = aVar;
    }

    public static b0 a(a<f> aVar) {
        return new b0(aVar);
    }

    public static a0 c(f fVar) {
        return new a0(fVar);
    }

    /* renamed from: b */
    public a0 get() {
        return c(this.f12473a.get());
    }
}
