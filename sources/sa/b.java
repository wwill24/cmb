package sa;

import fj.d;
import fk.a;
import n8.s;

public final class b implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final a<s> f41913a;

    public b(a<s> aVar) {
        this.f41913a = aVar;
    }

    public static b a(a<s> aVar) {
        return new b(aVar);
    }

    public static a c(s sVar) {
        return new a(sVar);
    }

    /* renamed from: b */
    public a get() {
        return c(this.f41913a.get());
    }
}
