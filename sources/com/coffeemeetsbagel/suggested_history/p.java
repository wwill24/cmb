package com.coffeemeetsbagel.suggested_history;

import androidx.appcompat.app.c;
import b6.d;
import b6.f;
import b6.g;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.suggested_history.k;
import kotlin.jvm.internal.j;

public class p extends f<a> {

    public interface a extends g<p>, k.a {
        d<?, ?> a();
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final d<?, ?> f37135a;

        public b(d<?, ?> dVar) {
            j.g(dVar, "componentActivity");
            this.f37135a = dVar;
        }

        public final c6.b a() {
            c6.b F0 = this.f37135a.F0();
            j.f(F0, "componentActivity.activityResultStream()");
            return F0;
        }

        public final c b() {
            return this.f37135a;
        }

        public final d<?, ?> c() {
            return this.f37135a;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: C0 */
    public a z0(d<?, ?> dVar) {
        j.g(dVar, "componentActivity");
        a a10 = e.a().c(new b(dVar)).b(Bakery.j()).a();
        j.f(a10, "builder()\n              …\n                .build()");
        return a10;
    }
}
