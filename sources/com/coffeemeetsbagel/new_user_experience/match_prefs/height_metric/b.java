package com.coffeemeetsbagel.new_user_experience.match_prefs.height_metric;

import b6.t;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.match_prefs.height_metric.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f35429a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f35430b;

        private a() {
        }

        public d.a a() {
            g.a(this.f35429a, d.b.class);
            g.a(this.f35430b, d.c.class);
            return new C0432b(this.f35429a, this.f35430b);
        }

        public a b(d.b bVar) {
            this.f35429a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f35430b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.match_prefs.height_metric.b$b  reason: collision with other inner class name */
    private static final class C0432b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f35431a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f35432b;

        /* renamed from: c  reason: collision with root package name */
        private final C0432b f35433c;

        private C0432b(d.b bVar, d.c cVar) {
            this.f35433c = this;
            this.f35431a = bVar;
            this.f35432b = cVar;
        }

        private HeightMatchPreferencesMetricInteractor c(HeightMatchPreferencesMetricInteractor heightMatchPreferencesMetricInteractor) {
            t.a(heightMatchPreferencesMetricInteractor, e.a(this.f35431a));
            j.d(heightMatchPreferencesMetricInteractor, (ProfileManager) g.d(this.f35432b.d()));
            j.a(heightMatchPreferencesMetricInteractor, (k) g.d(this.f35432b.k()));
            j.b(heightMatchPreferencesMetricInteractor, (l) g.d(this.f35432b.j()));
            j.e(heightMatchPreferencesMetricInteractor, (SaveAnswerUseCase) g.d(this.f35432b.l()));
            j.c(heightMatchPreferencesMetricInteractor, (s9.a) g.d(this.f35432b.b()));
            return heightMatchPreferencesMetricInteractor;
        }

        public b6.d<?, ?> a() {
            return (b6.d) g.d(this.f35432b.a());
        }

        /* renamed from: b */
        public void l1(HeightMatchPreferencesMetricInteractor heightMatchPreferencesMetricInteractor) {
            c(heightMatchPreferencesMetricInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
