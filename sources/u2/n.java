package u2;

import android.graphics.PointF;
import d3.a;
import d3.c;
import java.util.Collections;

public class n extends a<PointF, PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f17987i = new PointF();

    /* renamed from: j  reason: collision with root package name */
    private final PointF f17988j = new PointF();

    /* renamed from: k  reason: collision with root package name */
    private final a<Float, Float> f17989k;

    /* renamed from: l  reason: collision with root package name */
    private final a<Float, Float> f17990l;

    /* renamed from: m  reason: collision with root package name */
    protected c<Float> f17991m;

    /* renamed from: n  reason: collision with root package name */
    protected c<Float> f17992n;

    public n(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f17989k = aVar;
        this.f17990l = aVar2;
        m(f());
    }

    public void m(float f10) {
        this.f17989k.m(f10);
        this.f17990l.m(f10);
        this.f17987i.set(this.f17989k.h().floatValue(), this.f17990l.h().floatValue());
        for (int i10 = 0; i10 < this.f17949a.size(); i10++) {
            this.f17949a.get(i10).a();
        }
    }

    /* renamed from: p */
    public PointF h() {
        return i((a<PointF>) null, 0.0f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public PointF i(a<PointF> aVar, float f10) {
        Float f11;
        a<Float> b10;
        float f12;
        a<Float> b11;
        float f13;
        Float f14 = null;
        if (this.f17991m == null || (b11 = this.f17989k.b()) == null) {
            f11 = null;
        } else {
            float d10 = this.f17989k.d();
            Float f15 = b11.f14412h;
            c<Float> cVar = this.f17991m;
            float f16 = b11.f14411g;
            if (f15 == null) {
                f13 = f16;
            } else {
                f13 = f15.floatValue();
            }
            f11 = cVar.b(f16, f13, (Float) b11.f14406b, (Float) b11.f14407c, f10, f10, d10);
        }
        if (!(this.f17992n == null || (b10 = this.f17990l.b()) == null)) {
            float d11 = this.f17990l.d();
            Float f17 = b10.f14412h;
            c<Float> cVar2 = this.f17992n;
            float f18 = b10.f14411g;
            if (f17 == null) {
                f12 = f18;
            } else {
                f12 = f17.floatValue();
            }
            f14 = cVar2.b(f18, f12, (Float) b10.f14406b, (Float) b10.f14407c, f10, f10, d11);
        }
        if (f11 == null) {
            this.f17988j.set(this.f17987i.x, 0.0f);
        } else {
            this.f17988j.set(f11.floatValue(), 0.0f);
        }
        if (f14 == null) {
            PointF pointF = this.f17988j;
            pointF.set(pointF.x, this.f17987i.y);
        } else {
            PointF pointF2 = this.f17988j;
            pointF2.set(pointF2.x, f14.floatValue());
        }
        return this.f17988j;
    }

    public void r(c<Float> cVar) {
        c<Float> cVar2 = this.f17991m;
        if (cVar2 != null) {
            cVar2.c((a<?, ?>) null);
        }
        this.f17991m = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    public void s(c<Float> cVar) {
        c<Float> cVar2 = this.f17992n;
        if (cVar2 != null) {
            cVar2.c((a<?, ?>) null);
        }
        this.f17992n = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}
