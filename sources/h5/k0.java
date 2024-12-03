package h5;

import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.database.CmbDatabase;
import f6.x1;
import fj.d;
import fj.g;
import fk.a;

public final class k0 implements d<CmbDatabase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Bakery> f15365a;

    /* renamed from: b  reason: collision with root package name */
    private final a<x1> f15366b;

    public k0(a<Bakery> aVar, a<x1> aVar2) {
        this.f15365a = aVar;
        this.f15366b = aVar2;
    }

    public static CmbDatabase a(Bakery bakery, x1 x1Var) {
        return (CmbDatabase) g.e(d0.f15347a.g(bakery, x1Var));
    }

    public static k0 b(a<Bakery> aVar, a<x1> aVar2) {
        return new k0(aVar, aVar2);
    }

    /* renamed from: c */
    public CmbDatabase get() {
        return a(this.f15365a.get(), this.f15366b.get());
    }
}
