package y4;

import fj.d;
import fj.g;
import y4.a1;
import z4.a;
import z4.b;

public final class b1 implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final a1.b f18674a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<b> f18675b;

    public b1(a1.b bVar, fk.a<b> aVar) {
        this.f18674a = bVar;
        this.f18675b = aVar;
    }

    public static a a(a1.b bVar, b bVar2) {
        return (a) g.e(bVar.a(bVar2));
    }

    public static b1 b(a1.b bVar, fk.a<b> aVar) {
        return new b1(bVar, aVar);
    }

    /* renamed from: c */
    public a get() {
        return a(this.f18674a, this.f18675b.get());
    }
}
