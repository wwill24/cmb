package com.coffeemeetsbagel.new_user_experience;

import b6.d;
import b6.f;
import b6.g;
import com.coffeemeetsbagel.bakery.Bakery;
import kotlin.jvm.internal.j;

public class n extends f<a> {

    public interface a extends g<n>, o {
        d<?, ?> a();
    }

    public final class b {

        /* renamed from: a  reason: collision with root package name */
        private final d<?, ?> f35487a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n f35488b;

        public b(n nVar, d<?, ?> dVar) {
            j.g(dVar, "componentActivity");
            this.f35488b = nVar;
            this.f35487a = dVar;
        }

        public final d<?, ?> a() {
            return this.f35487a;
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
