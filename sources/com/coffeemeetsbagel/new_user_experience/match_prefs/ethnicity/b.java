package com.coffeemeetsbagel.new_user_experience.match_prefs.ethnicity;

import b6.t;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.match_prefs.ethnicity.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f35339a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f35340b;

        private a() {
        }

        public d.a a() {
            g.a(this.f35339a, d.b.class);
            g.a(this.f35340b, d.c.class);
            return new C0429b(this.f35339a, this.f35340b);
        }

        public a b(d.b bVar) {
            this.f35339a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f35340b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.match_prefs.ethnicity.b$b  reason: collision with other inner class name */
    private static final class C0429b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f35341a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f35342b;

        /* renamed from: c  reason: collision with root package name */
        private final C0429b f35343c;

        private C0429b(d.b bVar, d.c cVar) {
            this.f35343c = this;
            this.f35341a = bVar;
            this.f35342b = cVar;
        }

        private EthnicityMatchPreferenceInteractor c(EthnicityMatchPreferenceInteractor ethnicityMatchPreferenceInteractor) {
            t.a(ethnicityMatchPreferenceInteractor, e.a(this.f35341a));
            j.d(ethnicityMatchPreferenceInteractor, (ProfileManager) g.d(this.f35342b.d()));
            j.a(ethnicityMatchPreferenceInteractor, (k) g.d(this.f35342b.k()));
            j.b(ethnicityMatchPreferenceInteractor, (l) g.d(this.f35342b.j()));
            j.e(ethnicityMatchPreferenceInteractor, d());
            j.c(ethnicityMatchPreferenceInteractor, (c9.a) g.d(this.f35342b.I()));
            return ethnicityMatchPreferenceInteractor;
        }

        private com.coffeemeetsbagel.new_user_experience.match_prefs.d d() {
            return new com.coffeemeetsbagel.new_user_experience.match_prefs.d((a7.a) g.d(this.f35342b.c()));
        }

        /* renamed from: b */
        public void l1(EthnicityMatchPreferenceInteractor ethnicityMatchPreferenceInteractor) {
            c(ethnicityMatchPreferenceInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
