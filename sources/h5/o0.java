package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import com.coffeemeetsbagel.likes_you.h;
import fj.d;
import fj.g;
import fk.a;

public final class o0 implements d<h> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15381a;

    public o0(a<CmbDatabase> aVar) {
        this.f15381a = aVar;
    }

    public static o0 a(a<CmbDatabase> aVar) {
        return new o0(aVar);
    }

    public static h c(CmbDatabase cmbDatabase) {
        return (h) g.e(d0.f15347a.k(cmbDatabase));
    }

    /* renamed from: b */
    public h get() {
        return c(this.f15381a.get());
    }
}
