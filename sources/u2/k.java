package u2;

import android.graphics.PointF;
import d3.a;
import d3.c;
import java.util.List;

public class k extends g<PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f17982i = new PointF();

    public k(List<a<PointF>> list) {
        super(list);
    }

    /* renamed from: p */
    public PointF i(a<PointF> aVar, float f10) {
        return j(aVar, f10, f10, f10);
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public PointF j(a<PointF> aVar, float f10, float f11, float f12) {
        T t10;
        T t11 = aVar.f14406b;
        if (t11 == null || (t10 = aVar.f14407c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = (PointF) t11;
        PointF pointF2 = (PointF) t10;
        c<A> cVar = this.f17953e;
        if (cVar != null) {
            PointF pointF3 = (PointF) cVar.b(aVar.f14411g, aVar.f14412h.floatValue(), pointF, pointF2, f10, e(), f());
            if (pointF3 != null) {
                return pointF3;
            }
        }
        PointF pointF4 = this.f17982i;
        float f13 = pointF.x;
        float f14 = f13 + (f11 * (pointF2.x - f13));
        float f15 = pointF.y;
        pointF4.set(f14, f15 + (f12 * (pointF2.y - f15)));
        return this.f17982i;
    }
}
