package x4;

import fj.d;
import fj.g;
import fk.a;
import ma.i;

public final class m implements d<i> {

    /* renamed from: a  reason: collision with root package name */
    private final a<c7.d> f18552a;

    public m(a<c7.d> aVar) {
        this.f18552a = aVar;
    }

    public static m a(a<c7.d> aVar) {
        return new m(aVar);
    }

    public static i c(c7.d dVar) {
        return (i) g.e(b.f18542a.k(dVar));
    }

    /* renamed from: b */
    public i get() {
        return c(this.f18552a.get());
    }
}
