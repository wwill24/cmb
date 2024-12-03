package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import fk.a;
import u6.h;

public final class s0 implements d<h> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15386a;

    public s0(a<CmbDatabase> aVar) {
        this.f15386a = aVar;
    }

    public static s0 a(a<CmbDatabase> aVar) {
        return new s0(aVar);
    }

    public static h c(CmbDatabase cmbDatabase) {
        return (h) g.e(d0.f15347a.o(cmbDatabase));
    }

    /* renamed from: b */
    public h get() {
        return c(this.f15386a.get());
    }
}
