package u2;

import c3.i;
import d3.a;
import d3.c;
import java.util.List;

public class f extends g<Integer> {
    public f(List<a<Integer>> list) {
        super(list);
    }

    public int p() {
        return q(b(), d());
    }

    /* access modifiers changed from: package-private */
    public int q(a<Integer> aVar, float f10) {
        if (aVar.f14406b == null || aVar.f14407c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        c<A> cVar = this.f17953e;
        if (cVar != null) {
            Integer num = (Integer) cVar.b(aVar.f14411g, aVar.f14412h.floatValue(), (Integer) aVar.f14406b, (Integer) aVar.f14407c, f10, e(), f());
            if (num != null) {
                return num.intValue();
            }
        }
        return i.j(aVar.h(), aVar.e(), f10);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public Integer i(a<Integer> aVar, float f10) {
        return Integer.valueOf(q(aVar, f10));
    }
}
