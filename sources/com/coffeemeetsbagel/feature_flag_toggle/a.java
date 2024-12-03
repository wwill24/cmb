package com.coffeemeetsbagel.feature_flag_toggle;

import b6.d;
import com.coffeemeetsbagel.experiment.r;
import com.coffeemeetsbagel.feature_flag_toggle.b;
import fj.g;
import q9.c;

public final class a {

    /* renamed from: com.coffeemeetsbagel.feature_flag_toggle.a$a  reason: collision with other inner class name */
    public static final class C0143a {

        /* renamed from: a  reason: collision with root package name */
        private b.C0144b f13460a;

        /* renamed from: b  reason: collision with root package name */
        private c f13461b;

        private C0143a() {
        }

        public b.a a() {
            g.a(this.f13460a, b.C0144b.class);
            g.a(this.f13461b, c.class);
            return new b(this.f13460a, this.f13461b);
        }

        public C0143a b(c cVar) {
            this.f13461b = (c) g.b(cVar);
            return this;
        }

        public C0143a c(b.C0144b bVar) {
            this.f13460a = (b.C0144b) g.b(bVar);
            return this;
        }
    }

    private static final class b implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private final b.C0144b f13462a;

        /* renamed from: b  reason: collision with root package name */
        private final c f13463b;

        /* renamed from: c  reason: collision with root package name */
        private final b f13464c;

        private b(b.C0144b bVar, c cVar) {
            this.f13464c = this;
            this.f13462a = bVar;
            this.f13463b = cVar;
        }

        public d a() {
            return c.a(this.f13462a);
        }

        public r b() {
            return (r) g.d(this.f13463b.b());
        }

        /* renamed from: c */
        public void g0(b bVar) {
        }
    }

    public static C0143a a() {
        return new C0143a();
    }
}
