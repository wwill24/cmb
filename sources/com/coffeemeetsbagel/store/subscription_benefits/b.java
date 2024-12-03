package com.coffeemeetsbagel.store.subscription_benefits;

import android.app.Activity;
import b6.t;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellAnalytics;
import com.coffeemeetsbagel.store.subscription_benefits.e;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private e.c f36933a;

        /* renamed from: b  reason: collision with root package name */
        private e.a f36934b;

        private a() {
        }

        public e.b a() {
            g.a(this.f36933a, e.c.class);
            g.a(this.f36934b, e.a.class);
            return new C0454b(this.f36933a, this.f36934b);
        }

        public a b(e.a aVar) {
            this.f36934b = (e.a) g.b(aVar);
            return this;
        }

        public a c(e.c cVar) {
            this.f36933a = (e.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.store.subscription_benefits.b$b  reason: collision with other inner class name */
    private static final class C0454b implements e.b {

        /* renamed from: a  reason: collision with root package name */
        private final e.c f36935a;

        /* renamed from: b  reason: collision with root package name */
        private final e.a f36936b;

        /* renamed from: c  reason: collision with root package name */
        private final C0454b f36937c;

        private C0454b(e.c cVar, e.a aVar) {
            this.f36937c = this;
            this.f36935a = cVar;
            this.f36936b = aVar;
        }

        private g c(g gVar) {
            t.a(gVar, f.a(this.f36935a));
            h.a(gVar, (a7.a) g.d(this.f36936b.T()));
            h.b(gVar, (SubscriptionRepository) g.d(this.f36936b.Z()));
            h.c(gVar, (PremiumUpsellAnalytics) g.d(this.f36936b.c()));
            return gVar;
        }

        /* renamed from: b */
        public void l1(g gVar) {
            c(gVar);
        }

        public Activity i() {
            return (Activity) g.d(this.f36936b.i());
        }
    }

    public static a a() {
        return new a();
    }
}
