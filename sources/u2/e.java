package u2;

import d3.a;
import java.util.List;
import y2.d;

public class e extends g<d> {

    /* renamed from: i  reason: collision with root package name */
    private final d f17972i;

    public e(List<a<d>> list) {
        super(list);
        int i10 = 0;
        d dVar = (d) list.get(0).f14406b;
        i10 = dVar != null ? dVar.e() : i10;
        this.f17972i = new d(new float[i10], new int[i10]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public d i(a<d> aVar, float f10) {
        this.f17972i.f((d) aVar.f14406b, (d) aVar.f14407c, f10);
        return this.f17972i;
    }
}
