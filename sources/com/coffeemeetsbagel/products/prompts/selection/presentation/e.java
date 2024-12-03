package com.coffeemeetsbagel.products.prompts.selection.presentation;

import b6.d;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.products.prompts.selection.presentation.n;
import com.coffeemeetsbagel.qna.j;
import fj.g;

public final class e {

    private static final class a implements n.a {

        /* renamed from: a  reason: collision with root package name */
        private final n.b f35981a;

        /* renamed from: b  reason: collision with root package name */
        private final o f35982b;

        /* renamed from: c  reason: collision with root package name */
        private final a f35983c;

        private a(n.b bVar, o oVar) {
            this.f35983c = this;
            this.f35981a = bVar;
            this.f35982b = oVar;
        }

        public UserRepository C() {
            return (UserRepository) g.d(this.f35982b.C());
        }

        public j R0() {
            return (j) g.d(this.f35982b.R0());
        }

        public a7.a S() {
            return (a7.a) g.d(this.f35982b.S());
        }

        public d<?, ?> a() {
            return p.a(this.f35981a);
        }

        /* renamed from: c */
        public void g0(n nVar) {
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private n.b f35984a;

        /* renamed from: b  reason: collision with root package name */
        private o f35985b;

        private b() {
        }

        public b a(n.b bVar) {
            this.f35984a = (n.b) g.b(bVar);
            return this;
        }

        public n.a b() {
            g.a(this.f35984a, n.b.class);
            g.a(this.f35985b, o.class);
            return new a(this.f35984a, this.f35985b);
        }

        public b c(o oVar) {
            this.f35985b = (o) g.b(oVar);
            return this;
        }
    }

    public static b a() {
        return new b();
    }
}
