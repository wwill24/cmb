package x4;

import com.coffeemeetsbagel.match.u;
import fj.d;
import fj.g;
import fk.a;

public final class e implements d<u> {

    /* renamed from: a  reason: collision with root package name */
    private final a<c7.d> f18545a;

    public e(a<c7.d> aVar) {
        this.f18545a = aVar;
    }

    public static u a(c7.d dVar) {
        return (u) g.e(b.f18542a.c(dVar));
    }

    public static e b(a<c7.d> aVar) {
        return new e(aVar);
    }

    /* renamed from: c */
    public u get() {
        return a(this.f18545a.get());
    }
}
