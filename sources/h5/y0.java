package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import fk.a;
import u6.l;

public final class y0 implements d<l> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15400a;

    public y0(a<CmbDatabase> aVar) {
        this.f15400a = aVar;
    }

    public static y0 a(a<CmbDatabase> aVar) {
        return new y0(aVar);
    }

    public static l c(CmbDatabase cmbDatabase) {
        return (l) g.e(d0.f15347a.u(cmbDatabase));
    }

    /* renamed from: b */
    public l get() {
        return c(this.f15400a.get());
    }
}
