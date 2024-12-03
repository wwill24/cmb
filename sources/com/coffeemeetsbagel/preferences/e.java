package com.coffeemeetsbagel.preferences;

import b6.d;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.match_prefs.GetMatchPreferencesUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.LoadAgePreferenceUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.SaveAgePreferenceUseCase;
import com.coffeemeetsbagel.preferences.h;
import com.coffeemeetsbagel.preferences.l;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.qna.GetUserMCQUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.qna.i;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import fj.c;
import fj.g;

public final class e {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private l.b f35795a;

        /* renamed from: b  reason: collision with root package name */
        private h.a f35796b;

        private a() {
        }

        public l.a a() {
            if (this.f35795a == null) {
                this.f35795a = new l.b();
            }
            g.a(this.f35796b, h.a.class);
            return new b(this.f35795a, this.f35796b);
        }

        public a b(h.a aVar) {
            this.f35796b = (h.a) g.b(aVar);
            return this;
        }
    }

    private static final class b implements l.a {

        /* renamed from: a  reason: collision with root package name */
        private final h.a f35797a;

        /* renamed from: b  reason: collision with root package name */
        private final b f35798b;

        /* renamed from: c  reason: collision with root package name */
        private fk.a<k> f35799c;

        /* renamed from: d  reason: collision with root package name */
        private fk.a<g> f35800d;

        /* renamed from: e  reason: collision with root package name */
        private fk.a<na.b> f35801e;

        private b(l.b bVar, h.a aVar) {
            this.f35798b = this;
            this.f35797a = aVar;
            l(bVar, aVar);
        }

        private void l(l.b bVar, h.a aVar) {
            fk.a<k> a10 = c.a(o.a(bVar));
            this.f35799c = a10;
            this.f35800d = c.a(m.a(bVar, a10));
            this.f35801e = c.a(n.a(bVar, this.f35799c));
        }

        private MatchPrefsContainerInteractor p(MatchPrefsContainerInteractor matchPrefsContainerInteractor) {
            r.a(matchPrefsContainerInteractor, this.f35800d.get());
            return matchPrefsContainerInteractor;
        }

        public c9.a I() {
            return (c9.a) g.d(this.f35797a.I());
        }

        public m1 W() {
            return (m1) g.d(this.f35797a.W());
        }

        public SaveAgePreferenceUseCase X() {
            return (SaveAgePreferenceUseCase) g.d(this.f35797a.X());
        }

        public d<?, ?> a() {
            return (d) g.d(this.f35797a.a());
        }

        public s9.a b() {
            return (s9.a) g.d(this.f35797a.b());
        }

        public LoadAgePreferenceUseCase b0() {
            return (LoadAgePreferenceUseCase) g.d(this.f35797a.b0());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f35797a.c());
        }

        public ma.g c0() {
            return (ma.g) g.d(this.f35797a.c0());
        }

        public ProfileManager d() {
            return (ProfileManager) g.d(this.f35797a.d());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f35797a.e());
        }

        public cb.a f() {
            return (cb.a) g.d(this.f35797a.f());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f35797a.g());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f35797a.h());
        }

        public SubscriptionRepository h0() {
            return (SubscriptionRepository) g.d(this.f35797a.h0());
        }

        public na.b j() {
            return this.f35801e.get();
        }

        public QuestionRepository k() {
            return (QuestionRepository) g.d(this.f35797a.e0());
        }

        /* renamed from: m */
        public void l1(MatchPrefsContainerInteractor matchPrefsContainerInteractor) {
            p(matchPrefsContainerInteractor);
        }

        public androidx.appcompat.app.c n() {
            return (androidx.appcompat.app.c) g.d(this.f35797a.n());
        }

        public l5.a n0() {
            return (l5.a) g.d(this.f35797a.n0());
        }

        public i o() {
            return new i((QuestionRepository) g.d(this.f35797a.e0()));
        }

        public GetMatchPreferencesUseCase p0() {
            return (GetMatchPreferencesUseCase) g.d(this.f35797a.p0());
        }

        public GetUserMCQUseCase s0() {
            return (GetUserMCQUseCase) g.d(this.f35797a.s0());
        }

        public SaveAnswerUseCase z() {
            return (SaveAnswerUseCase) g.d(this.f35797a.z());
        }
    }

    public static a a() {
        return new a();
    }
}
