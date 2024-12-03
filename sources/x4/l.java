package x4;

import fj.d;
import fj.g;
import fk.a;
import ma.h;

public final class l implements d<h> {

    /* renamed from: a  reason: collision with root package name */
    private final a<c7.d> f18551a;

    public l(a<c7.d> aVar) {
        this.f18551a = aVar;
    }

    public static l a(a<c7.d> aVar) {
        return new l(aVar);
    }

    public static h c(c7.d dVar) {
        return (h) g.e(b.f18542a.j(dVar));
    }

    /* renamed from: b */
    public h get() {
        return c(this.f18551a.get());
    }
}
