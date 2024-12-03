package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import fk.a;

public final class x0 implements d<za.d> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15399a;

    public x0(a<CmbDatabase> aVar) {
        this.f15399a = aVar;
    }

    public static x0 a(a<CmbDatabase> aVar) {
        return new x0(aVar);
    }

    public static za.d c(CmbDatabase cmbDatabase) {
        return (za.d) g.e(d0.f15347a.t(cmbDatabase));
    }

    /* renamed from: b */
    public za.d get() {
        return c(this.f15399a.get());
    }
}
