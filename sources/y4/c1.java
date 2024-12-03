package y4;

import fj.d;
import fj.g;
import y4.a1;
import z4.b;

public final class c1 implements d<b> {

    /* renamed from: a  reason: collision with root package name */
    private final a1.b f18677a;

    public c1(a1.b bVar) {
        this.f18677a = bVar;
    }

    public static b a(a1.b bVar) {
        return (b) g.e(bVar.b());
    }

    public static c1 b(a1.b bVar) {
        return new c1(bVar);
    }

    /* renamed from: c */
    public b get() {
        return a(this.f18677a);
    }
}
