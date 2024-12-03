package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import fk.a;
import u6.n;

public final class a1 implements d<n> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15338a;

    public a1(a<CmbDatabase> aVar) {
        this.f15338a = aVar;
    }

    public static a1 a(a<CmbDatabase> aVar) {
        return new a1(aVar);
    }

    public static n c(CmbDatabase cmbDatabase) {
        return (n) g.e(d0.f15347a.w(cmbDatabase));
    }

    /* renamed from: b */
    public n get() {
        return c(this.f15338a.get());
    }
}
