package com.coffeemeetsbagel.shop.post_subscription_benefits;

import androidx.appcompat.app.c;
import b6.t;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.shop.post_subscription_benefits.d;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.c f36468a;

        /* renamed from: b  reason: collision with root package name */
        private d.a f36469b;

        private a() {
        }

        public d.b a() {
            g.a(this.f36468a, d.c.class);
            g.a(this.f36469b, d.a.class);
            return new C0448b(this.f36468a, this.f36469b);
        }

        public a b(d.a aVar) {
            this.f36469b = (d.a) g.b(aVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f36468a = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.shop.post_subscription_benefits.b$b  reason: collision with other inner class name */
    private static final class C0448b implements d.b {

        /* renamed from: a  reason: collision with root package name */
        private final d.c f36470a;

        /* renamed from: b  reason: collision with root package name */
        private final d.a f36471b;

        /* renamed from: c  reason: collision with root package name */
        private final C0448b f36472c;

        private C0448b(d.c cVar, d.a aVar) {
            this.f36472c = this;
            this.f36470a = cVar;
            this.f36471b = aVar;
        }

        private PostSubscriptionBenefitsCardInteractor c(PostSubscriptionBenefitsCardInteractor postSubscriptionBenefitsCardInteractor) {
            t.a(postSubscriptionBenefitsCardInteractor, e.a(this.f36470a));
            j.a(postSubscriptionBenefitsCardInteractor, (SubscriptionRepository) g.d(this.f36471b.m()));
            return postSubscriptionBenefitsCardInteractor;
        }

        /* renamed from: b */
        public void l1(PostSubscriptionBenefitsCardInteractor postSubscriptionBenefitsCardInteractor) {
            c(postSubscriptionBenefitsCardInteractor);
        }

        public c i() {
            return (c) g.d(this.f36471b.i());
        }
    }

    public static a a() {
        return new a();
    }
}
