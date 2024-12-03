package c9;

import fj.d;
import fk.a;
import u6.l;

public final class b implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final a<l> f7995a;

    public b(a<l> aVar) {
        this.f7995a = aVar;
    }

    public static b a(a<l> aVar) {
        return new b(aVar);
    }

    public static a c(l lVar) {
        return new a(lVar);
    }

    /* renamed from: b */
    public a get() {
        return c(this.f7995a.get());
    }
}
