package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import fk.a;
import u6.o;

public final class b1 implements d<o> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15342a;

    public b1(a<CmbDatabase> aVar) {
        this.f15342a = aVar;
    }

    public static b1 a(a<CmbDatabase> aVar) {
        return new b1(aVar);
    }

    public static o c(CmbDatabase cmbDatabase) {
        return (o) g.e(d0.f15347a.x(cmbDatabase));
    }

    /* renamed from: b */
    public o get() {
        return c(this.f15342a.get());
    }
}
