package com.coffeemeetsbagel.products.prompts.selection.presentation;

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
        private final d<?, ?> f35998a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n f35999b;

        public b(n nVar, d<?, ?> dVar) {
            j.g(dVar, "componentActivity");
            this.f35999b = nVar;
            this.f35998a = dVar;
        }

        public final d<?, ?> a() {
            return this.f35998a;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: C0 */
    public a z0(d<?, ?> dVar) {
        j.g(dVar, "componentActivity");
        a b10 = e.a().a(new b(this, dVar)).c(Bakery.j()).b();
        j.f(b10, "builder()\n              …\n                .build()");
        return b10;
    }
}
