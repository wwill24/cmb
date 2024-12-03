package x2;

import android.graphics.PointF;
import d3.a;
import java.util.List;
import u2.j;
import u2.k;

public class e implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<PointF>> f18509a;

    public e(List<a<PointF>> list) {
        this.f18509a = list;
    }

    public u2.a<PointF, PointF> a() {
        if (this.f18509a.get(0).i()) {
            return new k(this.f18509a);
        }
        return new j(this.f18509a);
    }

    public List<a<PointF>> b() {
        return this.f18509a;
    }

    public boolean isStatic() {
        return this.f18509a.size() == 1 && this.f18509a.get(0).i();
    }
}
