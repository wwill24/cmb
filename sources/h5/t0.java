package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import fk.a;
import u6.i;

public final class t0 implements d<i> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15388a;

    public t0(a<CmbDatabase> aVar) {
        this.f15388a = aVar;
    }

    public static t0 a(a<CmbDatabase> aVar) {
        return new t0(aVar);
    }

    public static i c(CmbDatabase cmbDatabase) {
        return (i) g.e(d0.f15347a.p(cmbDatabase));
    }

    /* renamed from: b */
    public i get() {
        return c(this.f15388a.get());
    }
}
