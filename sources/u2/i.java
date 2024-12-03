package u2;

import android.graphics.Path;
import android.graphics.PointF;
import c3.j;
import com.airbnb.lottie.h;
import d3.a;

public class i extends a<PointF> {

    /* renamed from: q  reason: collision with root package name */
    private Path f17976q;

    /* renamed from: r  reason: collision with root package name */
    private final a<PointF> f17977r;

    public i(h hVar, a<PointF> aVar) {
        super(hVar, (PointF) aVar.f14406b, (PointF) aVar.f14407c, aVar.f14408d, aVar.f14409e, aVar.f14410f, aVar.f14411g, aVar.f14412h);
        this.f17977r = aVar;
        j();
    }

    public void j() {
        boolean z10;
        T t10;
        T t11;
        T t12 = this.f14407c;
        if (t12 == null || (t11 = this.f14406b) == null || !((PointF) t11).equals(((PointF) t12).x, ((PointF) t12).y)) {
            z10 = false;
        } else {
            z10 = true;
        }
        T t13 = this.f14406b;
        if (t13 != null && (t10 = this.f14407c) != null && !z10) {
            a<PointF> aVar = this.f17977r;
            this.f17976q = j.d((PointF) t13, (PointF) t10, aVar.f14419o, aVar.f14420p);
        }
    }

    /* access modifiers changed from: package-private */
    public Path k() {
        return this.f17976q;
    }
}
