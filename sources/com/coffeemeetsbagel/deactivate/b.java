package com.coffeemeetsbagel.deactivate;

import b6.d;
import b6.t;
import com.coffeemeetsbagel.deactivate.g;
import com.coffeemeetsbagel.deactivate.q;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import wb.c;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private g.b f12009a;

        /* renamed from: b  reason: collision with root package name */
        private q.a f12010b;

        private a() {
        }

        public g.a a() {
            fj.g.a(this.f12009a, g.b.class);
            fj.g.a(this.f12010b, q.a.class);
            return new C0130b(this.f12009a, this.f12010b);
        }

        public a b(g.b bVar) {
            this.f12009a = (g.b) fj.g.b(bVar);
            return this;
        }

        public a c(q.a aVar) {
            this.f12010b = (q.a) fj.g.b(aVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.deactivate.b$b  reason: collision with other inner class name */
    private static final class C0130b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        private final g.b f12011a;

        /* renamed from: b  reason: collision with root package name */
        private final q.a f12012b;

        /* renamed from: c  reason: collision with root package name */
        private final C0130b f12013c;

        private C0130b(g.b bVar, q.a aVar) {
            this.f12013c = this;
            this.f12011a = bVar;
            this.f12012b = aVar;
        }

        private DeactivateCompPresenter b() {
            return h.a(this.f12011a, (d) fj.g.d(this.f12012b.a()));
        }

        private DeactivateCompInteractor d(DeactivateCompInteractor deactivateCompInteractor) {
            t.a(deactivateCompInteractor, b());
            l.f(deactivateCompInteractor, (ProfileManager) fj.g.d(this.f12012b.s1()));
            l.a(deactivateCompInteractor, (a7.a) fj.g.d(this.f12012b.G1()));
            l.b(deactivateCompInteractor, (d7.g) fj.g.d(this.f12012b.l1()));
            l.g(deactivateCompInteractor, (bb.a) fj.g.d(this.f12012b.i()));
            l.c(deactivateCompInteractor, (FeatureFlagRepository) fj.g.d(this.f12012b.K0()));
            l.e(deactivateCompInteractor, (GetMyOwnProfileLocalUseCase) fj.g.d(this.f12012b.O1()));
            l.d(deactivateCompInteractor, (c) fj.g.d(this.f12012b.n1()));
            return deactivateCompInteractor;
        }

        public d<?, ?> a() {
            return (d) fj.g.d(this.f12012b.a());
        }

        /* renamed from: c */
        public void l1(DeactivateCompInteractor deactivateCompInteractor) {
            d(deactivateCompInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
