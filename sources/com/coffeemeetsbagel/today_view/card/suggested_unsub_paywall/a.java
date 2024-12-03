package com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall;

import b6.t;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.b;
import fj.g;

public final class a {

    /* renamed from: com.coffeemeetsbagel.today_view.card.suggested_unsub_paywall.a$a  reason: collision with other inner class name */
    public static final class C0465a {

        /* renamed from: a  reason: collision with root package name */
        private b.c f37343a;

        /* renamed from: b  reason: collision with root package name */
        private b.a f37344b;

        private C0465a() {
        }

        public b.C0466b a() {
            g.a(this.f37343a, b.c.class);
            g.a(this.f37344b, b.a.class);
            return new b(this.f37343a, this.f37344b);
        }

        public C0465a b(b.a aVar) {
            this.f37344b = (b.a) g.b(aVar);
            return this;
        }

        public C0465a c(b.c cVar) {
            this.f37343a = (b.c) g.b(cVar);
            return this;
        }
    }

    private static final class b implements b.C0466b {

        /* renamed from: a  reason: collision with root package name */
        private final b.c f37345a;

        /* renamed from: b  reason: collision with root package name */
        private final b.a f37346b;

        /* renamed from: c  reason: collision with root package name */
        private final b f37347c;

        private b(b.c cVar, b.a aVar) {
            this.f37347c = this;
            this.f37345a = cVar;
            this.f37346b = aVar;
        }

        private SuggestedUnsubPaywallInteractor c(SuggestedUnsubPaywallInteractor suggestedUnsubPaywallInteractor) {
            t.a(suggestedUnsubPaywallInteractor, c.a(this.f37345a));
            return suggestedUnsubPaywallInteractor;
        }

        public ActivityMain a() {
            return (ActivityMain) g.d(this.f37346b.a());
        }

        /* renamed from: b */
        public void l1(SuggestedUnsubPaywallInteractor suggestedUnsubPaywallInteractor) {
            c(suggestedUnsubPaywallInteractor);
        }
    }

    public static C0465a a() {
        return new C0465a();
    }
}
