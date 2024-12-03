package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import com.coffeemeetsbagel.database.daos.h;
import fj.d;
import fj.g;
import fk.a;

public final class g0 implements d<h> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15356a;

    public g0(a<CmbDatabase> aVar) {
        this.f15356a = aVar;
    }

    public static h a(CmbDatabase cmbDatabase) {
        return (h) g.e(d0.f15347a.c(cmbDatabase));
    }

    public static g0 b(a<CmbDatabase> aVar) {
        return new g0(aVar);
    }

    /* renamed from: c */
    public h get() {
        return a(this.f15356a.get());
    }
}
