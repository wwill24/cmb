package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import fk.a;
import u6.q;

public final class f1 implements d<q> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15355a;

    public f1(a<CmbDatabase> aVar) {
        this.f15355a = aVar;
    }

    public static f1 a(a<CmbDatabase> aVar) {
        return new f1(aVar);
    }

    public static q c(CmbDatabase cmbDatabase) {
        return (q) g.e(d0.f15347a.B(cmbDatabase));
    }

    /* renamed from: b */
    public q get() {
        return c(this.f15355a.get());
    }
}
