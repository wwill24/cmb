package f6;

import fj.d;
import fj.g;
import t7.a;

public final class c2 implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final fk.a<f2> f14784a;

    public c2(fk.a<f2> aVar) {
        this.f14784a = aVar;
    }

    public static c2 a(fk.a<f2> aVar) {
        return new c2(aVar);
    }

    public static a b(f2 f2Var) {
        return (a) g.e(b2.f14780a.a(f2Var));
    }

    /* renamed from: c */
    public a get() {
        return b(this.f14784a.get());
    }
}
