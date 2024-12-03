package y4;

import com.coffeemeetsbagel.activities.main.ActivityMain;
import fj.d;
import fj.g;
import y4.a1;

public final class i1 implements d<ActivityMain> {

    /* renamed from: a  reason: collision with root package name */
    private final a1.b f18696a;

    public i1(a1.b bVar) {
        this.f18696a = bVar;
    }

    public static ActivityMain a(a1.b bVar) {
        return (ActivityMain) g.e(bVar.h());
    }

    public static i1 b(a1.b bVar) {
        return new i1(bVar);
    }

    /* renamed from: c */
    public ActivityMain get() {
        return a(this.f18696a);
    }
}
