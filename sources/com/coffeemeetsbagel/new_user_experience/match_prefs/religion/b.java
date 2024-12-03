package com.coffeemeetsbagel.new_user_experience.match_prefs.religion;

import b6.t;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;
import com.coffeemeetsbagel.new_user_experience.match_prefs.religion.d;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.c f35466a;

        /* renamed from: b  reason: collision with root package name */
        private d.a f35467b;

        private a() {
        }

        public d.b a() {
            g.a(this.f35466a, d.c.class);
            g.a(this.f35467b, d.a.class);
            return new C0433b(this.f35466a, this.f35467b);
        }

        public a b(d.a aVar) {
            this.f35467b = (d.a) g.b(aVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f35466a = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.match_prefs.religion.b$b  reason: collision with other inner class name */
    private static final class C0433b implements d.b {

        /* renamed from: a  reason: collision with root package name */
        private final d.c f35468a;

        /* renamed from: b  reason: collision with root package name */
        private final d.a f35469b;

        /* renamed from: c  reason: collision with root package name */
        private final C0433b f35470c;

        private C0433b(d.c cVar, d.a aVar) {
            this.f35470c = this;
            this.f35468a = cVar;
            this.f35469b = aVar;
        }

        private ReligionMatchPreferenceInteractor c(ReligionMatchPreferenceInteractor religionMatchPreferenceInteractor) {
            t.a(religionMatchPreferenceInteractor, e.a(this.f35468a));
            j.d(religionMatchPreferenceInteractor, (ProfileManager) g.d(this.f35469b.d()));
            j.a(religionMatchPreferenceInteractor, (k) g.d(this.f35469b.k()));
            j.b(religionMatchPreferenceInteractor, (l) g.d(this.f35469b.j()));
            j.e(religionMatchPreferenceInteractor, d());
            j.c(religionMatchPreferenceInteractor, (c9.a) g.d(this.f35469b.I()));
            return religionMatchPreferenceInteractor;
        }

        private com.coffeemeetsbagel.new_user_experience.match_prefs.d d() {
            return new com.coffeemeetsbagel.new_user_experience.match_prefs.d((a7.a) g.d(this.f35469b.c()));
        }

        /* renamed from: b */
        public void l1(ReligionMatchPreferenceInteractor religionMatchPreferenceInteractor) {
            c(religionMatchPreferenceInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
