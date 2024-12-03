package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import com.coffeemeetsbagel.likes_you.b;
import fj.d;
import fj.g;
import fk.a;

public final class m0 implements d<b> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15378a;

    public m0(a<CmbDatabase> aVar) {
        this.f15378a = aVar;
    }

    public static m0 a(a<CmbDatabase> aVar) {
        return new m0(aVar);
    }

    public static b c(CmbDatabase cmbDatabase) {
        return (b) g.e(d0.f15347a.i(cmbDatabase));
    }

    /* renamed from: b */
    public b get() {
        return c(this.f15378a.get());
    }
}
