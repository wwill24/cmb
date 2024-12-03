package com.coffeemeetsbagel.store.premium_upsell;

import android.app.Activity;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.premium_upsell.n;
import fj.g;

public final class e {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private p f36888a;

        /* renamed from: b  reason: collision with root package name */
        private o f36889b;

        private a() {
        }

        public n.a a() {
            g.a(this.f36888a, p.class);
            g.a(this.f36889b, o.class);
            return new b(this.f36888a, this.f36889b);
        }

        public a b(o oVar) {
            this.f36889b = (o) g.b(oVar);
            return this;
        }

        public a c(p pVar) {
            this.f36888a = (p) g.b(pVar);
            return this;
        }
    }

    private static final class b implements n.a {

        /* renamed from: a  reason: collision with root package name */
        private final p f36890a;

        /* renamed from: b  reason: collision with root package name */
        private final o f36891b;

        /* renamed from: c  reason: collision with root package name */
        private final b f36892c;

        private b(p pVar, o oVar) {
            this.f36892c = this;
            this.f36890a = pVar;
            this.f36891b = oVar;
        }

        public UserRepository C() {
            return (UserRepository) g.d(this.f36891b.C());
        }

        public wb.e D0() {
            return (wb.e) g.d(this.f36891b.D0());
        }

        public a7.a T() {
            return (a7.a) g.d(this.f36891b.T());
        }

        public SubscriptionRepository Z() {
            return (SubscriptionRepository) g.d(this.f36891b.Z());
        }

        public c6.b a0() {
            return r.a(this.f36890a);
        }

        public s9.a b() {
            return (s9.a) g.d(this.f36891b.b());
        }

        /* renamed from: c */
        public void g0(n nVar) {
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f36891b.g());
        }

        public Activity i() {
            return q.a(this.f36890a);
        }
    }

    public static a a() {
        return new a();
    }
}
