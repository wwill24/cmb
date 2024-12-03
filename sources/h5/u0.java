package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import fk.a;
import u6.j;

public final class u0 implements d<j> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15392a;

    public u0(a<CmbDatabase> aVar) {
        this.f15392a = aVar;
    }

    public static u0 a(a<CmbDatabase> aVar) {
        return new u0(aVar);
    }

    public static j c(CmbDatabase cmbDatabase) {
        return (j) g.e(d0.f15347a.q(cmbDatabase));
    }

    /* renamed from: b */
    public j get() {
        return c(this.f15392a.get());
    }
}
