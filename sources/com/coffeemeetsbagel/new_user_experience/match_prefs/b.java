package com.coffeemeetsbagel.new_user_experience.match_prefs;

import b6.d;
import b6.t;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.match_prefs.GetMatchPreferencesUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.LoadAgePreferenceUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.SaveAgePreferenceUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.e;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.qna.GetUserMCQUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.qna.i;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import fj.c;
import fj.g;
import qj.q;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private e.b f35270a;

        /* renamed from: b  reason: collision with root package name */
        private e.c f35271b;

        private a() {
        }

        public e.a a() {
            g.a(this.f35270a, e.b.class);
            g.a(this.f35271b, e.c.class);
            return new C0427b(this.f35270a, this.f35271b);
        }

        public a b(e.b bVar) {
            this.f35270a = (e.b) g.b(bVar);
            return this;
        }

        public a c(e.c cVar) {
            this.f35271b = (e.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.match_prefs.b$b  reason: collision with other inner class name */
    private static final class C0427b implements e.a {

        /* renamed from: a  reason: collision with root package name */
        private final e.c f35272a;

        /* renamed from: b  reason: collision with root package name */
        private final C0427b f35273b;

        /* renamed from: c  reason: collision with root package name */
        private fk.a<MatchPrefsPresenter> f35274c;

        /* renamed from: d  reason: collision with root package name */
        private fk.a<g0> f35275d;

        /* renamed from: e  reason: collision with root package name */
        private fk.a<k> f35276e;

        /* renamed from: f  reason: collision with root package name */
        private fk.a<l> f35277f;

        /* renamed from: g  reason: collision with root package name */
        private fk.a<d<?, ?>> f35278g;

        /* renamed from: h  reason: collision with root package name */
        private fk.a<q<c6.a>> f35279h;

        /* renamed from: com.coffeemeetsbagel.new_user_experience.match_prefs.b$b$a */
        private static final class a implements fk.a<d<?, ?>> {

            /* renamed from: a  reason: collision with root package name */
            private final e.c f35280a;

            a(e.c cVar) {
                this.f35280a = cVar;
            }

            /* renamed from: a */
            public d<?, ?> get() {
                return (d) g.d(this.f35280a.a());
            }
        }

        private C0427b(e.b bVar, e.c cVar) {
            this.f35273b = this;
            this.f35272a = cVar;
            p(bVar, cVar);
        }

        private void p(e.b bVar, e.c cVar) {
            this.f35274c = c.a(i.a(bVar));
            fk.a<g0> a10 = c.a(j.a(bVar));
            this.f35275d = a10;
            this.f35276e = c.a(g.a(bVar, a10));
            this.f35277f = c.a(h.a(bVar, this.f35275d));
            a aVar = new a(cVar);
            this.f35278g = aVar;
            this.f35279h = c.a(f.b(bVar, aVar));
        }

        private MatchPrefsInteractor r(MatchPrefsInteractor matchPrefsInteractor) {
            t.a(matchPrefsInteractor, this.f35274c.get());
            y.e(matchPrefsInteractor, (na.b) g.d(this.f35272a.j()));
            y.i(matchPrefsInteractor, (ProfileManager) g.d(this.f35272a.d()));
            y.k(matchPrefsInteractor, (m1) g.d(this.f35272a.W()));
            y.l(matchPrefsInteractor, s());
            y.c(matchPrefsInteractor, (s9.a) g.d(this.f35272a.b()));
            y.f(matchPrefsInteractor, this.f35276e.get());
            y.g(matchPrefsInteractor, this.f35277f.get());
            y.b(matchPrefsInteractor, (l5.a) g.d(this.f35272a.n0()));
            y.h(matchPrefsInteractor, (GetUserMCQUseCase) g.d(this.f35272a.s0()));
            y.d(matchPrefsInteractor, (GetMatchPreferencesUseCase) g.d(this.f35272a.p0()));
            y.a(matchPrefsInteractor, this.f35279h.get());
            y.j(matchPrefsInteractor, (ma.g) g.d(this.f35272a.c0()));
            return matchPrefsInteractor;
        }

        private d s() {
            return new d((a7.a) g.d(this.f35272a.c()));
        }

        public UserRepository C() {
            return (UserRepository) g.d(this.f35272a.e());
        }

        public c9.a I() {
            return (c9.a) g.d(this.f35272a.I());
        }

        public SaveAgePreferenceUseCase X() {
            return (SaveAgePreferenceUseCase) g.d(this.f35272a.X());
        }

        public d<?, ?> a() {
            return (d) g.d(this.f35272a.a());
        }

        public q<c6.a> a0() {
            return this.f35279h.get();
        }

        public s9.a b() {
            return (s9.a) g.d(this.f35272a.b());
        }

        public LoadAgePreferenceUseCase b0() {
            return (LoadAgePreferenceUseCase) g.d(this.f35272a.b0());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f35272a.c());
        }

        public ma.g c0() {
            return (ma.g) g.d(this.f35272a.c0());
        }

        public ProfileManager d() {
            return (ProfileManager) g.d(this.f35272a.d());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f35272a.e());
        }

        public QuestionRepository e0() {
            return (QuestionRepository) g.d(this.f35272a.k());
        }

        public cb.a f() {
            return (cb.a) g.d(this.f35272a.f());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f35272a.g());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f35272a.h());
        }

        public SubscriptionRepository h0() {
            return (SubscriptionRepository) g.d(this.f35272a.h0());
        }

        public l j() {
            return this.f35277f.get();
        }

        public l5.a j0() {
            return (l5.a) g.d(this.f35272a.n0());
        }

        public k k() {
            return this.f35276e.get();
        }

        public SaveAnswerUseCase l() {
            return (SaveAnswerUseCase) g.d(this.f35272a.z());
        }

        public SubscriptionRepository m() {
            return (SubscriptionRepository) g.d(this.f35272a.h0());
        }

        public androidx.appcompat.app.c n() {
            return (androidx.appcompat.app.c) g.d(this.f35272a.n());
        }

        public i o() {
            return (i) g.d(this.f35272a.o());
        }

        /* renamed from: q */
        public void l1(MatchPrefsInteractor matchPrefsInteractor) {
            r(matchPrefsInteractor);
        }

        public SaveAnswerUseCase z() {
            return (SaveAnswerUseCase) g.d(this.f35272a.z());
        }
    }

    public static a a() {
        return new a();
    }
}
