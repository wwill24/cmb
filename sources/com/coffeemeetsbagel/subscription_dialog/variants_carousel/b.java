package com.coffeemeetsbagel.subscription_dialog.variants_carousel;

import b6.t;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.subscription_dialog.variants_carousel.e;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private e.c f37083a;

        /* renamed from: b  reason: collision with root package name */
        private e.a f37084b;

        private a() {
        }

        public e.b a() {
            g.a(this.f37083a, e.c.class);
            g.a(this.f37084b, e.a.class);
            return new C0458b(this.f37083a, this.f37084b);
        }

        public a b(e.a aVar) {
            this.f37084b = (e.a) g.b(aVar);
            return this;
        }

        public a c(e.c cVar) {
            this.f37083a = (e.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.subscription_dialog.variants_carousel.b$b  reason: collision with other inner class name */
    private static final class C0458b implements e.b {

        /* renamed from: a  reason: collision with root package name */
        private final e.c f37085a;

        /* renamed from: b  reason: collision with root package name */
        private final e.a f37086b;

        /* renamed from: c  reason: collision with root package name */
        private final C0458b f37087c;

        private C0458b(e.c cVar, e.a aVar) {
            this.f37087c = this;
            this.f37085a = cVar;
            this.f37086b = aVar;
        }

        private VariantsCarouselInteractor c(VariantsCarouselInteractor variantsCarouselInteractor) {
            t.a(variantsCarouselInteractor, f.a(this.f37085a));
            i.b(variantsCarouselInteractor, (SubscriptionRepository) g.d(this.f37086b.m()));
            i.a(variantsCarouselInteractor, (n) g.d(this.f37086b.b()));
            return variantsCarouselInteractor;
        }

        /* renamed from: b */
        public void l1(VariantsCarouselInteractor variantsCarouselInteractor) {
            c(variantsCarouselInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
