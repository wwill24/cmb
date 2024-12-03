package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fk.a;
import u6.g;

public final class r0 implements d<g> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15385a;

    public r0(a<CmbDatabase> aVar) {
        this.f15385a = aVar;
    }

    public static r0 a(a<CmbDatabase> aVar) {
        return new r0(aVar);
    }

    public static g c(CmbDatabase cmbDatabase) {
        return (g) fj.g.e(d0.f15347a.n(cmbDatabase));
    }

    /* renamed from: b */
    public g get() {
        return c(this.f15385a.get());
    }
}
