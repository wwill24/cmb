package a5;

import a5.c;
import ca.g;
import ca.h;
import com.coffeemeetsbagel.activities.main.active_fragment.ActiveFragment;
import j5.x;
import qj.q;
import ra.a;

public class b extends a<g, x> {

    /* renamed from: a  reason: collision with root package name */
    private final c.a f150a;

    public b(c.a aVar) {
        this.f150a = aVar;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Boolean g(ActiveFragment activeFragment) throws Exception {
        return Boolean.valueOf(activeFragment == ActiveFragment.TODAY);
    }

    /* access modifiers changed from: protected */
    public String b() {
        return getClass().getCanonicalName();
    }

    /* access modifiers changed from: protected */
    public q<Boolean> c() {
        return this.f150a.V().b().W(new a());
    }

    /* access modifiers changed from: protected */
    public Boolean d() {
        return Boolean.TRUE;
    }

    /* renamed from: f */
    public g a(x xVar) {
        return new h(this.f150a);
    }
}
