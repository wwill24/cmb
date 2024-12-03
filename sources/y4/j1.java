package y4;

import com.coffeemeetsbagel.cmbbottomnav.state.NavStateManager;
import fj.d;
import fj.g;
import y4.a1;

public final class j1 implements d<NavStateManager> {

    /* renamed from: a  reason: collision with root package name */
    private final a1.b f18699a;

    public j1(a1.b bVar) {
        this.f18699a = bVar;
    }

    public static j1 a(a1.b bVar) {
        return new j1(bVar);
    }

    public static NavStateManager c(a1.b bVar) {
        return (NavStateManager) g.e(bVar.i());
    }

    /* renamed from: b */
    public NavStateManager get() {
        return c(this.f18699a);
    }
}
