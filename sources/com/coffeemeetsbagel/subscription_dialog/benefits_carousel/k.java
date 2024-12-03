package com.coffeemeetsbagel.subscription_dialog.benefits_carousel;

import b6.t;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.subscription_dialog.benefits_carousel.a;
import fj.g;

public final class k {

    private static final class a implements a.C0456a {

        /* renamed from: a  reason: collision with root package name */
        private final a.b f37024a;

        /* renamed from: b  reason: collision with root package name */
        private final a.c f37025b;

        /* renamed from: c  reason: collision with root package name */
        private final a f37026c;

        private a(a.b bVar, a.c cVar) {
            this.f37026c = this;
            this.f37024a = bVar;
            this.f37025b = cVar;
        }

        private BenefitsCarouselInteractor c(BenefitsCarouselInteractor benefitsCarouselInteractor) {
            t.a(benefitsCarouselInteractor, b.a(this.f37024a));
            f.a(benefitsCarouselInteractor, (a7.a) g.d(this.f37025b.c()));
            f.c(benefitsCarouselInteractor, (SubscriptionRepository) g.d(this.f37025b.m()));
            f.b(benefitsCarouselInteractor, (cb.a) g.d(this.f37025b.f()));
            return benefitsCarouselInteractor;
        }

        /* renamed from: b */
        public void l1(BenefitsCarouselInteractor benefitsCarouselInteractor) {
            c(benefitsCarouselInteractor);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private a.b f37027a;

        /* renamed from: b  reason: collision with root package name */
        private a.c f37028b;

        private b() {
        }

        public b a(a.b bVar) {
            this.f37027a = (a.b) g.b(bVar);
            return this;
        }

        public a.C0456a b() {
            g.a(this.f37027a, a.b.class);
            g.a(this.f37028b, a.c.class);
            return new a(this.f37027a, this.f37028b);
        }

        public b c(a.c cVar) {
            this.f37028b = (a.c) g.b(cVar);
            return this;
        }
    }

    public static b a() {
        return new b();
    }
}
