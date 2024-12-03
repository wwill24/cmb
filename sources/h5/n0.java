package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import com.coffeemeetsbagel.likes_you.f;
import fj.d;
import fj.g;
import fk.a;

public final class n0 implements d<f> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15379a;

    public n0(a<CmbDatabase> aVar) {
        this.f15379a = aVar;
    }

    public static n0 a(a<CmbDatabase> aVar) {
        return new n0(aVar);
    }

    public static f c(CmbDatabase cmbDatabase) {
        return (f) g.e(d0.f15347a.j(cmbDatabase));
    }

    /* renamed from: b */
    public f get() {
        return c(this.f15379a.get());
    }
}
