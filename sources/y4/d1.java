package y4;

import fj.d;
import fj.g;
import fk.a;
import y4.a1;
import z4.b;
import z4.c;

public final class d1 implements d<c> {

    /* renamed from: a  reason: collision with root package name */
    private final a1.b f18679a;

    /* renamed from: b  reason: collision with root package name */
    private final a<b> f18680b;

    public d1(a1.b bVar, a<b> aVar) {
        this.f18679a = bVar;
        this.f18680b = aVar;
    }

    public static c a(a1.b bVar, b bVar2) {
        return (c) g.e(bVar.c(bVar2));
    }

    public static d1 b(a1.b bVar, a<b> aVar) {
        return new d1(bVar, aVar);
    }

    /* renamed from: c */
    public c get() {
        return a(this.f18679a, this.f18680b.get());
    }
}
