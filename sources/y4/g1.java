package y4;

import com.coffeemeetsbagel.cmbbottomnav.state.NavStateManager;
import fj.d;
import fj.g;
import fk.a;
import y4.a1;
import y5.b;

public final class g1 implements d<b> {

    /* renamed from: a  reason: collision with root package name */
    private final a1.b f18690a;

    /* renamed from: b  reason: collision with root package name */
    private final a<NavStateManager> f18691b;

    public g1(a1.b bVar, a<NavStateManager> aVar) {
        this.f18690a = bVar;
        this.f18691b = aVar;
    }

    public static b a(a1.b bVar, NavStateManager navStateManager) {
        return (b) g.e(bVar.f(navStateManager));
    }

    public static g1 b(a1.b bVar, a<NavStateManager> aVar) {
        return new g1(bVar, aVar);
    }

    /* renamed from: c */
    public b get() {
        return a(this.f18690a, this.f18691b.get());
    }
}
