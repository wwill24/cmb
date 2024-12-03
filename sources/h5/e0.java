package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import u6.a;

public final class e0 implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final fk.a<CmbDatabase> f15352a;

    public e0(fk.a<CmbDatabase> aVar) {
        this.f15352a = aVar;
    }

    public static a a(CmbDatabase cmbDatabase) {
        return (a) g.e(d0.f15347a.a(cmbDatabase));
    }

    public static e0 b(fk.a<CmbDatabase> aVar) {
        return new e0(aVar);
    }

    /* renamed from: c */
    public a get() {
        return a(this.f15352a.get());
    }
}
