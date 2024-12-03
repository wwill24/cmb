package fd;

import android.content.Context;
import fk.a;
import gd.b;

public final class h implements b<g> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f40806a;

    /* renamed from: b  reason: collision with root package name */
    private final a<od.a> f40807b;

    /* renamed from: c  reason: collision with root package name */
    private final a<od.a> f40808c;

    public h(a<Context> aVar, a<od.a> aVar2, a<od.a> aVar3) {
        this.f40806a = aVar;
        this.f40807b = aVar2;
        this.f40808c = aVar3;
    }

    public static h a(a<Context> aVar, a<od.a> aVar2, a<od.a> aVar3) {
        return new h(aVar, aVar2, aVar3);
    }

    public static g c(Context context, od.a aVar, od.a aVar2) {
        return new g(context, aVar, aVar2);
    }

    /* renamed from: b */
    public g get() {
        return c(this.f40806a.get(), this.f40807b.get(), this.f40808c.get());
    }
}
