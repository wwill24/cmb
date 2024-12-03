package x4;

import fj.d;
import fj.g;
import fk.a;
import ma.k;

public final class p implements d<k> {

    /* renamed from: a  reason: collision with root package name */
    private final a<c7.d> f18555a;

    public p(a<c7.d> aVar) {
        this.f18555a = aVar;
    }

    public static p a(a<c7.d> aVar) {
        return new p(aVar);
    }

    public static k c(c7.d dVar) {
        return (k) g.e(b.f18542a.n(dVar));
    }

    /* renamed from: b */
    public k get() {
        return c(this.f18555a.get());
    }
}
