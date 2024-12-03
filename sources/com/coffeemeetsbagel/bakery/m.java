package com.coffeemeetsbagel.bakery;

import com.coffeemeetsbagel.match.l;
import fj.d;
import fj.g;
import fk.a;
import u6.e;

public final class m implements d<l> {

    /* renamed from: a  reason: collision with root package name */
    private final a<f7.a> f11269a;

    /* renamed from: b  reason: collision with root package name */
    private final a<t7.a> f11270b;

    /* renamed from: c  reason: collision with root package name */
    private final a<e> f11271c;

    public m(a<f7.a> aVar, a<t7.a> aVar2, a<e> aVar3) {
        this.f11269a = aVar;
        this.f11270b = aVar2;
        this.f11271c = aVar3;
    }

    public static l a(f7.a aVar, t7.a aVar2, e eVar) {
        return (l) g.e(c.j(aVar, aVar2, eVar));
    }

    public static m b(a<f7.a> aVar, a<t7.a> aVar2, a<e> aVar3) {
        return new m(aVar, aVar2, aVar3);
    }

    /* renamed from: c */
    public l get() {
        return a(this.f11269a.get(), this.f11270b.get(), this.f11271c.get());
    }
}
