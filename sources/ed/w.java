package ed;

import fk.a;
import gd.b;
import kd.e;
import ld.o;
import ld.s;

public final class w implements b<u> {

    /* renamed from: a  reason: collision with root package name */
    private final a<od.a> f40764a;

    /* renamed from: b  reason: collision with root package name */
    private final a<od.a> f40765b;

    /* renamed from: c  reason: collision with root package name */
    private final a<e> f40766c;

    /* renamed from: d  reason: collision with root package name */
    private final a<o> f40767d;

    /* renamed from: e  reason: collision with root package name */
    private final a<s> f40768e;

    public w(a<od.a> aVar, a<od.a> aVar2, a<e> aVar3, a<o> aVar4, a<s> aVar5) {
        this.f40764a = aVar;
        this.f40765b = aVar2;
        this.f40766c = aVar3;
        this.f40767d = aVar4;
        this.f40768e = aVar5;
    }

    public static w a(a<od.a> aVar, a<od.a> aVar2, a<e> aVar3, a<o> aVar4, a<s> aVar5) {
        return new w(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static u c(od.a aVar, od.a aVar2, e eVar, o oVar, s sVar) {
        return new u(aVar, aVar2, eVar, oVar, sVar);
    }

    /* renamed from: b */
    public u get() {
        return c(this.f40764a.get(), this.f40765b.get(), this.f40766c.get(), this.f40767d.get(), this.f40768e.get());
    }
}
