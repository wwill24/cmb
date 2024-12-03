package u9;

import b6.d;
import b6.f;
import b6.g;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffemeetsbagel.hide_report.h;
import kotlin.jvm.internal.j;

public class e extends f<a> {

    public interface a extends g<e>, h {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final d<?, ?> f18028a;

        public b(d<?, ?> dVar) {
            j.g(dVar, "componentActivity");
            this.f18028a = dVar;
        }

        public final d<?, ?> a() {
            return this.f18028a;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: C0 */
    public a z0(d<?, ?> dVar) {
        j.g(dVar, "componentActivity");
        a a10 = b.a().c(new b(dVar)).b(Bakery.j()).a();
        j.f(a10, "builder()\n            .h…t())\n            .build()");
        return a10;
    }
}
