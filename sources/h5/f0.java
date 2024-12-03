package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import fk.a;
import u6.b;

public final class f0 implements d<b> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15354a;

    public f0(a<CmbDatabase> aVar) {
        this.f15354a = aVar;
    }

    public static b a(CmbDatabase cmbDatabase) {
        return (b) g.e(d0.f15347a.b(cmbDatabase));
    }

    public static f0 b(a<CmbDatabase> aVar) {
        return new f0(aVar);
    }

    /* renamed from: c */
    public b get() {
        return a(this.f15354a.get());
    }
}
