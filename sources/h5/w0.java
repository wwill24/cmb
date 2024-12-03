package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import fk.a;
import za.e;

public final class w0 implements d<e> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15395a;

    public w0(a<CmbDatabase> aVar) {
        this.f15395a = aVar;
    }

    public static w0 a(a<CmbDatabase> aVar) {
        return new w0(aVar);
    }

    public static e c(CmbDatabase cmbDatabase) {
        return (e) g.e(d0.f15347a.s(cmbDatabase));
    }

    /* renamed from: b */
    public e get() {
        return c(this.f15395a.get());
    }
}
