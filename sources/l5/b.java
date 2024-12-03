package l5;

import com.coffeemeetsbagel.domain.repository.m;
import fj.d;
import fk.a;

public final class b implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final a<m> f16040a;

    public b(a<m> aVar) {
        this.f16040a = aVar;
    }

    public static b a(a<m> aVar) {
        return new b(aVar);
    }

    public static a c(m mVar) {
        return new a(mVar);
    }

    /* renamed from: b */
    public a get() {
        return c(this.f16040a.get());
    }
}
