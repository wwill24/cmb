package x4;

import fj.d;
import fj.g;
import fk.a;
import ma.j;

public final class o implements d<j> {

    /* renamed from: a  reason: collision with root package name */
    private final a<c7.d> f18554a;

    public o(a<c7.d> aVar) {
        this.f18554a = aVar;
    }

    public static o a(a<c7.d> aVar) {
        return new o(aVar);
    }

    public static j c(c7.d dVar) {
        return (j) g.e(b.f18542a.m(dVar));
    }

    /* renamed from: b */
    public j get() {
        return c(this.f18554a.get());
    }
}
