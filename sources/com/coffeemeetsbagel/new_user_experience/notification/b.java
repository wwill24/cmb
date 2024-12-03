package com.coffeemeetsbagel.new_user_experience.notification;

import b6.t;
import com.coffeemeetsbagel.new_user_experience.notification.d;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f35538a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f35539b;

        private a() {
        }

        public d.a a() {
            g.a(this.f35538a, d.b.class);
            g.a(this.f35539b, d.c.class);
            return new C0435b(this.f35538a, this.f35539b);
        }

        public a b(d.b bVar) {
            this.f35538a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f35539b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.notification.b$b  reason: collision with other inner class name */
    private static final class C0435b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f35540a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f35541b;

        /* renamed from: c  reason: collision with root package name */
        private final C0435b f35542c;

        private C0435b(d.b bVar, d.c cVar) {
            this.f35542c = this;
            this.f35540a = bVar;
            this.f35541b = cVar;
        }

        private f c(f fVar) {
            t.a(fVar, e.a(this.f35540a));
            g.b(fVar, (na.b) g.d(this.f35541b.j()));
            g.a(fVar, (a7.a) g.d(this.f35541b.T()));
            return fVar;
        }

        public b6.d<?, ?> a() {
            return (b6.d) g.d(this.f35541b.a());
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
