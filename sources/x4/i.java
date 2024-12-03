package x4;

import fj.d;
import fj.g;
import fk.a;
import ma.e;

public final class i implements d<e> {

    /* renamed from: a  reason: collision with root package name */
    private final a<c7.d> f18548a;

    public i(a<c7.d> aVar) {
        this.f18548a = aVar;
    }

    public static i a(a<c7.d> aVar) {
        return new i(aVar);
    }

    public static e c(c7.d dVar) {
        return (e) g.e(b.f18542a.g(dVar));
    }

    /* renamed from: b */
    public e get() {
        return c(this.f18548a.get());
    }
}
