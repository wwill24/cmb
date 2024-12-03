package com.coffeemeetsbagel.products.prompts.editor.presentation;

import b6.d;
import b6.f;
import b6.g;
import com.coffeemeetsbagel.bakery.Bakery;
import kotlin.jvm.internal.j;

public class l extends f<a> {

    public interface a extends g<l>, m {
        d<?, ?> a();
    }

    public final class b {

        /* renamed from: a  reason: collision with root package name */
        private final d<?, ?> f35945a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l f35946b;

        public b(l lVar, d<?, ?> dVar) {
            j.g(dVar, "componentActivity");
            this.f35946b = lVar;
            this.f35945a = dVar;
        }

        public final d<?, ?> a() {
            return this.f35945a;
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
