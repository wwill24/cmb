package com.coffeemeetsbagel.deactivate;

import b6.d;
import b6.f;
import b6.g;
import com.coffeemeetsbagel.bakery.Bakery;
import kotlin.jvm.internal.j;

public class q extends f<a> {

    public interface a extends g<q>, r {
        d<?, ?> a();
    }

    public final class b {

        /* renamed from: a  reason: collision with root package name */
        private final d<?, ?> f12029a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q f12030b;

        public b(q qVar, d<?, ?> dVar) {
            j.g(dVar, "componentActivity");
            this.f12030b = qVar;
            this.f12029a = dVar;
        }

        public final d<?, ?> a() {
            return this.f12029a;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: C0 */
    public a z0(d<?, ?> dVar) {
        j.g(dVar, "componentActivity");
        a a10 = e.a().c(new b(this, dVar)).b(Bakery.j()).a();
        j.f(a10, "builder()\n              …\n                .build()");
        return a10;
    }
}
