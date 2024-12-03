package x2;

import android.graphics.PointF;
import java.util.List;
import u2.a;
import u2.n;

public class i implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final b f18510a;

    /* renamed from: b  reason: collision with root package name */
    private final b f18511b;

    public i(b bVar, b bVar2) {
        this.f18510a = bVar;
        this.f18511b = bVar2;
    }

    public a<PointF, PointF> a() {
        return new n(this.f18510a.a(), this.f18511b.a());
    }

    public List<d3.a<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    public boolean isStatic() {
        return this.f18510a.isStatic() && this.f18511b.isStatic();
    }
}
