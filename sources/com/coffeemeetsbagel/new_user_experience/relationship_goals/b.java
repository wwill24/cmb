package com.coffeemeetsbagel.new_user_experience.relationship_goals;

import b6.t;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.relationship_goals.d;
import fj.g;
import hb.c;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.c f35615a;

        /* renamed from: b  reason: collision with root package name */
        private d.a f35616b;

        private a() {
        }

        public d.b a() {
            g.a(this.f35615a, d.c.class);
            g.a(this.f35616b, d.a.class);
            return new C0438b(this.f35615a, this.f35616b);
        }

        public a b(d.a aVar) {
            this.f35616b = (d.a) g.b(aVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f35615a = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.relationship_goals.b$b  reason: collision with other inner class name */
    private static final class C0438b implements d.b {

        /* renamed from: a  reason: collision with root package name */
        private final d.c f35617a;

        /* renamed from: b  reason: collision with root package name */
        private final d.a f35618b;

        /* renamed from: c  reason: collision with root package name */
        private final C0438b f35619c;

        private C0438b(d.c cVar, d.a aVar) {
            this.f35619c = this;
            this.f35617a = cVar;
            this.f35618b = aVar;
        }

        private f c(f fVar) {
            t.a(fVar, e.a(this.f35617a));
            g.c(fVar, (na.b) g.d(this.f35618b.j()));
            g.d(fVar, (ProfileManager) g.d(this.f35618b.V()));
            g.a(fVar, (a7.a) g.d(this.f35618b.c()));
            g.e(fVar, (c) g.d(this.f35618b.y0()));
            g.b(fVar, (s9.a) g.d(this.f35618b.b()));
            return fVar;
        }

        public b6.d<?, ?> a() {
            return (b6.d) g.d(this.f35618b.a());
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
