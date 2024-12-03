package md;

import fk.a;
import gd.b;

public final class n0 implements b<m0> {

    /* renamed from: a  reason: collision with root package name */
    private final a<od.a> f41224a;

    /* renamed from: b  reason: collision with root package name */
    private final a<od.a> f41225b;

    /* renamed from: c  reason: collision with root package name */
    private final a<e> f41226c;

    /* renamed from: d  reason: collision with root package name */
    private final a<t0> f41227d;

    /* renamed from: e  reason: collision with root package name */
    private final a<String> f41228e;

    public n0(a<od.a> aVar, a<od.a> aVar2, a<e> aVar3, a<t0> aVar4, a<String> aVar5) {
        this.f41224a = aVar;
        this.f41225b = aVar2;
        this.f41226c = aVar3;
        this.f41227d = aVar4;
        this.f41228e = aVar5;
    }

    public static n0 a(a<od.a> aVar, a<od.a> aVar2, a<e> aVar3, a<t0> aVar4, a<String> aVar5) {
        return new n0(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static m0 c(od.a aVar, od.a aVar2, Object obj, Object obj2, a<String> aVar3) {
        return new m0(aVar, aVar2, (e) obj, (t0) obj2, aVar3);
    }

    /* renamed from: b */
    public m0 get() {
        return c(this.f41224a.get(), this.f41225b.get(), this.f41226c.get(), this.f41227d.get(), this.f41228e);
    }
}
