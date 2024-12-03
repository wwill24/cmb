package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import fk.a;
import u6.e;

public final class l0 implements d<e> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15372a;

    public l0(a<CmbDatabase> aVar) {
        this.f15372a = aVar;
    }

    public static e a(CmbDatabase cmbDatabase) {
        return (e) g.e(d0.f15347a.h(cmbDatabase));
    }

    public static l0 b(a<CmbDatabase> aVar) {
        return new l0(aVar);
    }

    /* renamed from: c */
    public e get() {
        return a(this.f15372a.get());
    }
}
