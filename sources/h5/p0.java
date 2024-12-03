package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import com.coffeemeetsbagel.likes_you.m;
import fj.d;
import fj.g;
import fk.a;

public final class p0 implements d<m> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15382a;

    public p0(a<CmbDatabase> aVar) {
        this.f15382a = aVar;
    }

    public static p0 a(a<CmbDatabase> aVar) {
        return new p0(aVar);
    }

    public static m c(CmbDatabase cmbDatabase) {
        return (m) g.e(d0.f15347a.l(cmbDatabase));
    }

    /* renamed from: b */
    public m get() {
        return c(this.f15382a.get());
    }
}
