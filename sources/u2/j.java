package u2;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import d3.a;
import d3.c;
import java.util.List;

public class j extends g<PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f17978i = new PointF();

    /* renamed from: j  reason: collision with root package name */
    private final float[] f17979j = new float[2];

    /* renamed from: k  reason: collision with root package name */
    private final PathMeasure f17980k = new PathMeasure();

    /* renamed from: l  reason: collision with root package name */
    private i f17981l;

    public j(List<? extends a<PointF>> list) {
        super(list);
    }

    /* renamed from: p */
    public PointF i(a<PointF> aVar, float f10) {
        i iVar = (i) aVar;
        Path k10 = iVar.k();
        if (k10 == null) {
            return (PointF) aVar.f14406b;
        }
        c<A> cVar = this.f17953e;
        if (cVar != null) {
            PointF pointF = (PointF) cVar.b(iVar.f14411g, iVar.f14412h.floatValue(), (PointF) iVar.f14406b, (PointF) iVar.f14407c, e(), f10, f());
            if (pointF != null) {
                return pointF;
            }
        }
        if (this.f17981l != iVar) {
            this.f17980k.setPath(k10, false);
            this.f17981l = iVar;
        }
        PathMeasure pathMeasure = this.f17980k;
        pathMeasure.getPosTan(f10 * pathMeasure.getLength(), this.f17979j, (float[]) null);
        PointF pointF2 = this.f17978i;
        float[] fArr = this.f17979j;
        pointF2.set(fArr[0], fArr[1]);
        return this.f17978i;
    }
}
