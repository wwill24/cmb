package com.coffeemeetsbagel.bakery;

import com.coffeemeetsbagel.experiment.t;
import fj.d;
import fj.g;
import fk.a;

public final class r0 implements d<t> {

    /* renamed from: a  reason: collision with root package name */
    private final a<y7.a> f11369a;

    /* renamed from: b  reason: collision with root package name */
    private final a<a7.a> f11370b;

    public r0(a<y7.a> aVar, a<a7.a> aVar2) {
        this.f11369a = aVar;
        this.f11370b = aVar2;
    }

    public static r0 a(a<y7.a> aVar, a<a7.a> aVar2) {
        return new r0(aVar, aVar2);
    }

    public static t c(y7.a aVar, a7.a aVar2) {
        return (t) g.e(c.P(aVar, aVar2));
    }

    /* renamed from: b */
    public t get() {
        return c(this.f11369a.get(), this.f11370b.get());
    }
}
