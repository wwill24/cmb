package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import fk.a;
import u6.p;

public final class c1 implements d<p> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15345a;

    public c1(a<CmbDatabase> aVar) {
        this.f15345a = aVar;
    }

    public static c1 a(a<CmbDatabase> aVar) {
        return new c1(aVar);
    }

    public static p c(CmbDatabase cmbDatabase) {
        return (p) g.e(d0.f15347a.y(cmbDatabase));
    }

    /* renamed from: b */
    public p get() {
        return c(this.f15345a.get());
    }
}
