package db;

import com.coffeemeetsbagel.database.CmbDatabase;
import eb.a;
import fj.d;
import fj.g;

public final class b implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final fk.a<CmbDatabase> f40588a;

    public b(fk.a<CmbDatabase> aVar) {
        this.f40588a = aVar;
    }

    public static b a(fk.a<CmbDatabase> aVar) {
        return new b(aVar);
    }

    public static a c(CmbDatabase cmbDatabase) {
        return (a) g.e(a.f40587a.a(cmbDatabase));
    }

    /* renamed from: b */
    public a get() {
        return c(this.f40588a.get());
    }
}
