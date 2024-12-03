package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import fk.a;
import u6.f;

public final class q0 implements d<f> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15383a;

    public q0(a<CmbDatabase> aVar) {
        this.f15383a = aVar;
    }

    public static q0 a(a<CmbDatabase> aVar) {
        return new q0(aVar);
    }

    public static f c(CmbDatabase cmbDatabase) {
        return (f) g.e(d0.f15347a.m(cmbDatabase));
    }

    /* renamed from: b */
    public f get() {
        return c(this.f15383a.get());
    }
}
