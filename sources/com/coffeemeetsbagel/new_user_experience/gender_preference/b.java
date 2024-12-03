package com.coffeemeetsbagel.new_user_experience.gender_preference;

import b6.t;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.gender_preference.d;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f35060a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f35061b;

        private a() {
        }

        public d.a a() {
            g.a(this.f35060a, d.b.class);
            g.a(this.f35061b, d.c.class);
            return new C0421b(this.f35060a, this.f35061b);
        }

        public a b(d.b bVar) {
            this.f35060a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f35061b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.gender_preference.b$b  reason: collision with other inner class name */
    private static final class C0421b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f35062a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f35063b;

        /* renamed from: c  reason: collision with root package name */
        private final C0421b f35064c;

        private C0421b(d.b bVar, d.c cVar) {
            this.f35064c = this;
            this.f35062a = bVar;
            this.f35063b = cVar;
        }

        private f c(f fVar) {
            t.a(fVar, e.a(this.f35062a));
            g.b(fVar, (ProfileManager) g.d(this.f35063b.m()));
            g.a(fVar, (na.b) g.d(this.f35063b.j()));
            return fVar;
        }

        /* renamed from: b */
        public void l1(f fVar) {
            c(fVar);
        }
    }

    public static a a() {
        return new a();
    }
}
