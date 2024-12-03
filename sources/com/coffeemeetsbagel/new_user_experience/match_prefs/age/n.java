package com.coffeemeetsbagel.new_user_experience.match_prefs.age;

import b6.t;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.a;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;
import fj.g;

public final class n {

    private static final class a implements a.C0425a {

        /* renamed from: a  reason: collision with root package name */
        private final a.b f35194a;

        /* renamed from: b  reason: collision with root package name */
        private final a.c f35195b;

        /* renamed from: c  reason: collision with root package name */
        private final a f35196c;

        private a(a.b bVar, a.c cVar) {
            this.f35196c = this;
            this.f35194a = bVar;
            this.f35195b = cVar;
        }

        private AgeMatchPreferenceInteractor c(AgeMatchPreferenceInteractor ageMatchPreferenceInteractor) {
            t.a(ageMatchPreferenceInteractor, b.a(this.f35194a));
            h.a(ageMatchPreferenceInteractor, (k) g.d(this.f35195b.k()));
            h.b(ageMatchPreferenceInteractor, (l) g.d(this.f35195b.j()));
            h.d(ageMatchPreferenceInteractor, (LoadAgePreferenceUseCase) g.d(this.f35195b.b0()));
            h.e(ageMatchPreferenceInteractor, (SaveAgePreferenceUseCase) g.d(this.f35195b.X()));
            h.c(ageMatchPreferenceInteractor, (s9.a) g.d(this.f35195b.b()));
            return ageMatchPreferenceInteractor;
        }

        /* renamed from: b */
        public void l1(AgeMatchPreferenceInteractor ageMatchPreferenceInteractor) {
            c(ageMatchPreferenceInteractor);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private a.b f35197a;

        /* renamed from: b  reason: collision with root package name */
        private a.c f35198b;

        private b() {
        }

        public b a(a.b bVar) {
            this.f35197a = (a.b) g.b(bVar);
            return this;
        }

        public a.C0425a b() {
            g.a(this.f35197a, a.b.class);
            g.a(this.f35198b, a.c.class);
            return new a(this.f35197a, this.f35198b);
        }

        public b c(a.c cVar) {
            this.f35198b = (a.c) g.b(cVar);
            return this;
        }
    }

    public static b a() {
        return new b();
    }
}
