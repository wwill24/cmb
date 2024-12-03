package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import za.a;

public final class h0 implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final fk.a<CmbDatabase> f15357a;

    public h0(fk.a<CmbDatabase> aVar) {
        this.f15357a = aVar;
    }

    public static a a(CmbDatabase cmbDatabase) {
        return (a) g.e(d0.f15347a.d(cmbDatabase));
    }

    public static h0 b(fk.a<CmbDatabase> aVar) {
        return new h0(aVar);
    }

    /* renamed from: c */
    public a get() {
        return a(this.f15357a.get());
    }
}
