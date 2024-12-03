package xb;

import b6.t;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellAnalytics;
import fj.g;
import xb.e;

public final class c {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private e.c f42137a;

        /* renamed from: b  reason: collision with root package name */
        private e.a f42138b;

        private a() {
        }

        public e.b a() {
            g.a(this.f42137a, e.c.class);
            g.a(this.f42138b, e.a.class);
            return new b(this.f42137a, this.f42138b);
        }

        public a b(e.a aVar) {
            this.f42138b = (e.a) g.b(aVar);
            return this;
        }

        public a c(e.c cVar) {
            this.f42137a = (e.c) g.b(cVar);
            return this;
        }
    }

    private static final class b implements e.b {

        /* renamed from: a  reason: collision with root package name */
        private final e.c f42139a;

        /* renamed from: b  reason: collision with root package name */
        private final e.a f42140b;

        /* renamed from: c  reason: collision with root package name */
        private final b f42141c;

        private b(e.c cVar, e.a aVar) {
            this.f42141c = this;
            this.f42139a = cVar;
            this.f42140b = aVar;
        }

        private g c(g gVar) {
            t.a(gVar, f.a(this.f42139a));
            h.a(gVar, (SubscriptionRepository) g.d(this.f42140b.Z()));
            h.c(gVar, (UserRepository) g.d(this.f42140b.C()));
            h.b(gVar, (PremiumUpsellAnalytics) g.d(this.f42140b.S()));
            return gVar;
        }

        /* renamed from: b */
        public void l1(g gVar) {
            c(gVar);
        }
    }

    public static a a() {
        return new a();
    }
}
