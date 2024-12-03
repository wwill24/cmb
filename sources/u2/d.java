package u2;

import c3.i;
import d3.a;
import d3.c;
import java.util.List;

public class d extends g<Float> {
    public d(List<a<Float>> list) {
        super(list);
    }

    public float p() {
        return q(b(), d());
    }

    /* access modifiers changed from: package-private */
    public float q(a<Float> aVar, float f10) {
        if (aVar.f14406b == null || aVar.f14407c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        c<A> cVar = this.f17953e;
        if (cVar != null) {
            Float f11 = (Float) cVar.b(aVar.f14411g, aVar.f14412h.floatValue(), (Float) aVar.f14406b, (Float) aVar.f14407c, f10, e(), f());
            if (f11 != null) {
                return f11.floatValue();
            }
        }
        return i.i(aVar.g(), aVar.d(), f10);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public Float i(a<Float> aVar, float f10) {
        return Float.valueOf(q(aVar, f10));
    }
}
