package com.coffeemeetsbagel.shop.subscription_comparison;

import androidx.appcompat.app.c;
import b6.t;
import com.coffeemeetsbagel.shop.subscription_comparison.e;
import com.coffeemeetsbagel.store.GetSubscriptionBundlesUseCase;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private e.c f36618a;

        /* renamed from: b  reason: collision with root package name */
        private e.a f36619b;

        private a() {
        }

        public e.b a() {
            g.a(this.f36618a, e.c.class);
            g.a(this.f36619b, e.a.class);
            return new C0450b(this.f36618a, this.f36619b);
        }

        public a b(e.a aVar) {
            this.f36619b = (e.a) g.b(aVar);
            return this;
        }

        public a c(e.c cVar) {
            this.f36618a = (e.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.shop.subscription_comparison.b$b  reason: collision with other inner class name */
    private static final class C0450b implements e.b {

        /* renamed from: a  reason: collision with root package name */
        private final e.c f36620a;

        /* renamed from: b  reason: collision with root package name */
        private final e.a f36621b;

        /* renamed from: c  reason: collision with root package name */
        private final C0450b f36622c;

        private C0450b(e.c cVar, e.a aVar) {
            this.f36622c = this;
            this.f36620a = cVar;
            this.f36621b = aVar;
        }

        private SubscriptionComparisonInteractor c(SubscriptionComparisonInteractor subscriptionComparisonInteractor) {
            t.a(subscriptionComparisonInteractor, f.a(this.f36620a));
            h.a(subscriptionComparisonInteractor, (GetSubscriptionBundlesUseCase) g.d(this.f36621b.k()));
            return subscriptionComparisonInteractor;
        }

        /* renamed from: b */
        public void l1(SubscriptionComparisonInteractor subscriptionComparisonInteractor) {
            c(subscriptionComparisonInteractor);
        }

        public c i() {
            return (c) g.d(this.f36621b.i());
        }
    }

    public static a a() {
        return new a();
    }
}
