package y4;

import com.coffeemeetsbagel.cmbbottomnav.state.NavStateManager;
import fj.d;
import fj.g;
import y4.a1;
import y5.a;

public final class f1 implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final a1.b f18684a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<NavStateManager> f18685b;

    public f1(a1.b bVar, fk.a<NavStateManager> aVar) {
        this.f18684a = bVar;
        this.f18685b = aVar;
    }

    public static a a(a1.b bVar, NavStateManager navStateManager) {
        return (a) g.e(bVar.e(navStateManager));
    }

    public static f1 b(a1.b bVar, fk.a<NavStateManager> aVar) {
        return new f1(bVar, aVar);
    }

    /* renamed from: c */
    public a get() {
        return a(this.f18684a, this.f18685b.get());
    }
}
