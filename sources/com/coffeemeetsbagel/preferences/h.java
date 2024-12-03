package com.coffeemeetsbagel.preferences;

import androidx.appcompat.app.c;
import b6.d;
import b6.f;
import b6.g;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.preferences.l;
import kotlin.jvm.internal.j;

public class h extends f<a> {

    public interface a extends g<h>, l.c {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final d<?, ?> f35802a;

        public b(d<?, ?> dVar) {
            j.g(dVar, "componentActivity");
            this.f35802a = dVar;
        }

        public final c a() {
            return this.f35802a;
        }

        public final d<?, ?> b() {
            return this.f35802a;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: C0 */
    public a z0(d<?, ?> dVar) {
        j.g(dVar, "componentActivity");
        a a10 = b.a().b(new b(dVar)).c(Bakery.j()).a();
        j.f(a10, "builder()\n            .f…t())\n            .build()");
        return a10;
    }
}
