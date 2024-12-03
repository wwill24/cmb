package bb;

import android.content.res.Resources;
import fj.d;
import fk.a;

public final class b implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Resources> f34034a;

    public b(a<Resources> aVar) {
        this.f34034a = aVar;
    }

    public static b a(a<Resources> aVar) {
        return new b(aVar);
    }

    public static a c(Resources resources) {
        return new a(resources);
    }

    /* renamed from: b */
    public a get() {
        return c(this.f34034a.get());
    }
}
