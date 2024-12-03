package u2;

import c3.i;
import d3.a;
import d3.c;
import d3.d;
import java.util.List;

public class l extends g<d> {

    /* renamed from: i  reason: collision with root package name */
    private final d f17983i = new d();

    public l(List<a<d>> list) {
        super(list);
    }

    /* renamed from: p */
    public d i(a<d> aVar, float f10) {
        T t10;
        T t11 = aVar.f14406b;
        if (t11 == null || (t10 = aVar.f14407c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        d dVar = (d) t11;
        d dVar2 = (d) t10;
        c<A> cVar = this.f17953e;
        if (cVar != null) {
            d dVar3 = (d) cVar.b(aVar.f14411g, aVar.f14412h.floatValue(), dVar, dVar2, f10, e(), f());
            if (dVar3 != null) {
                return dVar3;
            }
        }
        this.f17983i.d(i.i(dVar.b(), dVar2.b(), f10), i.i(dVar.c(), dVar2.c(), f10));
        return this.f17983i;
    }
}
