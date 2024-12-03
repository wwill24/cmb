package l8;

import d7.l;
import fj.d;
import fj.g;
import fk.a;
import n8.s;
import u6.e;
import u6.h;

public final class j1 implements d<s> {

    /* renamed from: a  reason: collision with root package name */
    private final a<t7.a> f16129a;

    /* renamed from: b  reason: collision with root package name */
    private final a<l> f16130b;

    /* renamed from: c  reason: collision with root package name */
    private final a<h> f16131c;

    /* renamed from: d  reason: collision with root package name */
    private final a<e> f16132d;

    public j1(a<t7.a> aVar, a<l> aVar2, a<h> aVar3, a<e> aVar4) {
        this.f16129a = aVar;
        this.f16130b = aVar2;
        this.f16131c = aVar3;
        this.f16132d = aVar4;
    }

    public static j1 a(a<t7.a> aVar, a<l> aVar2, a<h> aVar3, a<e> aVar4) {
        return new j1(aVar, aVar2, aVar3, aVar4);
    }

    public static s c(t7.a aVar, l lVar, h hVar, e eVar) {
        return (s) g.e(i1.a(aVar, lVar, hVar, eVar));
    }

    /* renamed from: b */
    public s get() {
        return c(this.f16129a.get(), this.f16130b.get(), this.f16131c.get(), this.f16132d.get());
    }
}
