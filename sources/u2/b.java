package u2;

import c3.d;
import c3.i;
import d3.a;
import d3.c;
import java.util.List;

public class b extends g<Integer> {
    public b(List<a<Integer>> list) {
        super(list);
    }

    public int p() {
        return q(b(), d());
    }

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
        return d.c(i.b(f10, 0.0f, 1.0f), ((Integer) aVar.f14406b).intValue(), ((Integer) aVar.f14407c).intValue());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public Integer i(a<Integer> aVar, float f10) {
        return Integer.valueOf(q(aVar, f10));
    }
}
