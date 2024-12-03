package com.coffeemeetsbagel.feature_flag_toggle;

import b6.d;
import b6.f;
import b6.g;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.experiment.r;

public class b extends f<a> {

    public interface a extends g<b> {
        d a();

        r b();
    }

    /* renamed from: com.coffeemeetsbagel.feature_flag_toggle.b$b  reason: collision with other inner class name */
    static class C0144b {

        /* renamed from: a  reason: collision with root package name */
        private d f13465a;

        C0144b(d dVar) {
            this.f13465a = dVar;
        }

        /* access modifiers changed from: package-private */
        public d a() {
            return this.f13465a;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: C0 */
    public a z0(d dVar) {
        return a.a().c(new C0144b(dVar)).b(Bakery.j()).a();
    }
}
