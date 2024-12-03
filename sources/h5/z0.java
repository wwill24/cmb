package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import fk.a;
import u6.m;

public final class z0 implements d<m> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15402a;

    public z0(a<CmbDatabase> aVar) {
        this.f15402a = aVar;
    }

    public static z0 a(a<CmbDatabase> aVar) {
        return new z0(aVar);
    }

    public static m c(CmbDatabase cmbDatabase) {
        return (m) g.e(d0.f15347a.v(cmbDatabase));
    }

    /* renamed from: b */
    public m get() {
        return c(this.f15402a.get());
    }
}
