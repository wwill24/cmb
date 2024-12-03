package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import fk.a;

public final class j0 implements d<u6.d> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15363a;

    public j0(a<CmbDatabase> aVar) {
        this.f15363a = aVar;
    }

    public static u6.d a(CmbDatabase cmbDatabase) {
        return (u6.d) g.e(d0.f15347a.f(cmbDatabase));
    }

    public static j0 b(a<CmbDatabase> aVar) {
        return new j0(aVar);
    }

    /* renamed from: c */
    public u6.d get() {
        return a(this.f15363a.get());
    }
}
