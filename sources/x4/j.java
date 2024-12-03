package x4;

import fj.d;
import fj.g;
import fk.a;
import ma.f;

public final class j implements d<f> {

    /* renamed from: a  reason: collision with root package name */
    private final a<c7.d> f18549a;

    public j(a<c7.d> aVar) {
        this.f18549a = aVar;
    }

    public static j a(a<c7.d> aVar) {
        return new j(aVar);
    }

    public static f c(c7.d dVar) {
        return (f) g.e(b.f18542a.h(dVar));
    }

    /* renamed from: b */
    public f get() {
        return c(this.f18549a.get());
    }
}
