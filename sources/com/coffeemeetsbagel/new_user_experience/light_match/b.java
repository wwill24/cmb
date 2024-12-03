package com.coffeemeetsbagel.new_user_experience.light_match;

import b6.t;
import com.coffeemeetsbagel.new_user_experience.light_match.d;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f35113a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f35114b;

        private a() {
        }

        public d.a a() {
            g.a(this.f35113a, d.b.class);
            g.a(this.f35114b, d.c.class);
            return new C0423b(this.f35113a, this.f35114b);
        }

        public a b(d.b bVar) {
            this.f35113a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f35114b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.light_match.b$b  reason: collision with other inner class name */
    private static final class C0423b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f35115a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f35116b;

        /* renamed from: c  reason: collision with root package name */
        private final C0423b f35117c;

        private C0423b(d.b bVar, d.c cVar) {
            this.f35117c = this;
            this.f35115a = bVar;
            this.f35116b = cVar;
        }

        private f c(f fVar) {
            t.a(fVar, e.a(this.f35115a));
            g.a(fVar, (na.b) g.d(this.f35116b.j()));
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
