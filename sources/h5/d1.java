package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import fk.a;
import yb.c;

public final class d1 implements d<c> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15348a;

    public d1(a<CmbDatabase> aVar) {
        this.f15348a = aVar;
    }

    public static d1 a(a<CmbDatabase> aVar) {
        return new d1(aVar);
    }

    public static c c(CmbDatabase cmbDatabase) {
        return (c) g.e(d0.f15347a.z(cmbDatabase));
    }

    /* renamed from: b */
    public c get() {
        return c(this.f15348a.get());
    }
}
