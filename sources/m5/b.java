package m5;

import fj.d;
import fk.a;
import u6.h;

public final class b implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final a<f7.a> f16337a;

    /* renamed from: b  reason: collision with root package name */
    private final a<h> f16338b;

    public b(a<f7.a> aVar, a<h> aVar2) {
        this.f16337a = aVar;
        this.f16338b = aVar2;
    }

    public static b a(a<f7.a> aVar, a<h> aVar2) {
        return new b(aVar, aVar2);
    }

    public static a c(f7.a aVar, h hVar) {
        return new a(aVar, hVar);
    }

    /* renamed from: b */
    public a get() {
        return c(this.f16337a.get(), this.f16338b.get());
    }
}
