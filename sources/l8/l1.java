package l8;

import fj.d;
import fj.g;
import fk.a;
import hb.c;

public final class l1 implements d<o2> {

    /* renamed from: a  reason: collision with root package name */
    private final a<a7.a> f16152a;

    /* renamed from: b  reason: collision with root package name */
    private final a<c7.d> f16153b;

    /* renamed from: c  reason: collision with root package name */
    private final a<c> f16154c;

    /* renamed from: d  reason: collision with root package name */
    private final a<e> f16155d;

    public l1(a<a7.a> aVar, a<c7.d> aVar2, a<c> aVar3, a<e> aVar4) {
        this.f16152a = aVar;
        this.f16153b = aVar2;
        this.f16154c = aVar3;
        this.f16155d = aVar4;
    }

    public static l1 a(a<a7.a> aVar, a<c7.d> aVar2, a<c> aVar3, a<e> aVar4) {
        return new l1(aVar, aVar2, aVar3, aVar4);
    }

    public static o2 c(a7.a aVar, c7.d dVar, c cVar, e eVar) {
        return (o2) g.e(i1.c(aVar, dVar, cVar, eVar));
    }

    /* renamed from: b */
    public o2 get() {
        return c(this.f16152a.get(), this.f16153b.get(), this.f16154c.get(), this.f16155d.get());
    }
}
