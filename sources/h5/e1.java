package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import fk.a;
import x4.r;

public final class e1 implements d<r> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15353a;

    public e1(a<CmbDatabase> aVar) {
        this.f15353a = aVar;
    }

    public static e1 a(a<CmbDatabase> aVar) {
        return new e1(aVar);
    }

    public static r c(CmbDatabase cmbDatabase) {
        return (r) g.e(d0.f15347a.A(cmbDatabase));
    }

    /* renamed from: b */
    public r get() {
        return c(this.f15353a.get());
    }
}
