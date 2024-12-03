package com.coffeemeetsbagel.subscription_dialog.dialog;

import b6.t;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.subscription_dialog.dialog.e;
import com.coffeemeetsbagel.subscription_dialog.variants_carousel.n;
import fj.c;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private e.c f37046a;

        /* renamed from: b  reason: collision with root package name */
        private e.a f37047b;

        private a() {
        }

        public e.b a() {
            g.a(this.f37046a, e.c.class);
            g.a(this.f37047b, e.a.class);
            return new C0457b(this.f37046a, this.f37047b);
        }

        public a b(e.a aVar) {
            this.f37047b = (e.a) g.b(aVar);
            return this;
        }

        public a c(e.c cVar) {
            this.f37046a = (e.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.subscription_dialog.dialog.b$b  reason: collision with other inner class name */
    private static final class C0457b implements e.b {

        /* renamed from: a  reason: collision with root package name */
        private final e.c f37048a;

        /* renamed from: b  reason: collision with root package name */
        private final e.a f37049b;

        /* renamed from: c  reason: collision with root package name */
        private final C0457b f37050c;

        /* renamed from: d  reason: collision with root package name */
        private fk.a<n> f37051d;

        private C0457b(e.c cVar, e.a aVar) {
            this.f37050c = this;
            this.f37048a = cVar;
            this.f37049b = aVar;
            d(cVar, aVar);
        }

        private void d(e.c cVar, e.a aVar) {
            this.f37051d = c.a(g.a(cVar));
        }

        private SubscriptionDialogInteractor g(SubscriptionDialogInteractor subscriptionDialogInteractor) {
            t.a(subscriptionDialogInteractor, f.a(this.f37048a));
            p.c(subscriptionDialogInteractor, (BuySubscriptionUseCase) g.d(this.f37049b.g()));
            p.f(subscriptionDialogInteractor, (SubscriptionRepository) g.d(this.f37049b.m()));
            p.a(subscriptionDialogInteractor, (androidx.appcompat.app.c) g.d(this.f37049b.n()));
            p.d(subscriptionDialogInteractor, (s9.a) g.d(this.f37049b.b()));
            p.g(subscriptionDialogInteractor, (UserRepository) g.d(this.f37049b.e()));
            p.h(subscriptionDialogInteractor, this.f37051d.get());
            p.b(subscriptionDialogInteractor, (a7.a) g.d(this.f37049b.c()));
            p.e(subscriptionDialogInteractor, (GetMyOwnProfileLocalUseCase) g.d(this.f37049b.h()));
            return subscriptionDialogInteractor;
        }

        public n b() {
            return this.f37051d.get();
        }

        public a7.a c() {
            return (a7.a) g.d(this.f37049b.c());
        }

        /* renamed from: e */
        public void l1(SubscriptionDialogInteractor subscriptionDialogInteractor) {
            g(subscriptionDialogInteractor);
        }

        public cb.a f() {
            return (cb.a) g.d(this.f37049b.f());
        }

        public SubscriptionRepository m() {
            return (SubscriptionRepository) g.d(this.f37049b.m());
        }

        public androidx.appcompat.app.c n() {
            return (androidx.appcompat.app.c) g.d(this.f37049b.n());
        }
    }

    public static a a() {
        return new a();
    }
}
