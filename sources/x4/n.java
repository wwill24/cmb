package x4;

import fj.d;
import fj.g;
import fk.a;

public final class n implements d<com.coffeemeetsbagel.stickers.d> {

    /* renamed from: a  reason: collision with root package name */
    private final a<c7.d> f18553a;

    public n(a<c7.d> aVar) {
        this.f18553a = aVar;
    }

    public static n a(a<c7.d> aVar) {
        return new n(aVar);
    }

    public static com.coffeemeetsbagel.stickers.d c(c7.d dVar) {
        return (com.coffeemeetsbagel.stickers.d) g.e(b.f18542a.l(dVar));
    }

    /* renamed from: b */
    public com.coffeemeetsbagel.stickers.d get() {
        return c(this.f18553a.get());
    }
}
