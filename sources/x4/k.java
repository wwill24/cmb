package x4;

import fj.d;
import fk.a;
import ma.g;

public final class k implements d<g> {

    /* renamed from: a  reason: collision with root package name */
    private final a<c7.d> f18550a;

    public k(a<c7.d> aVar) {
        this.f18550a = aVar;
    }

    public static k a(a<c7.d> aVar) {
        return new k(aVar);
    }

    public static g c(c7.d dVar) {
        return (g) fj.g.e(b.f18542a.i(dVar));
    }

    /* renamed from: b */
    public g get() {
        return c(this.f18550a.get());
    }
}
