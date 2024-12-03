package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import fk.a;
import u6.k;

public final class v0 implements d<k> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15393a;

    public v0(a<CmbDatabase> aVar) {
        this.f15393a = aVar;
    }

    public static v0 a(a<CmbDatabase> aVar) {
        return new v0(aVar);
    }

    public static k c(CmbDatabase cmbDatabase) {
        return (k) g.e(d0.f15347a.r(cmbDatabase));
    }

    /* renamed from: b */
    public k get() {
        return c(this.f15393a.get());
    }
}
