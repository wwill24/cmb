package com.coffeemeetsbagel.activities.main;

import com.coffeemeetsbagel.activities.main.b;
import fj.g;
import n8.s;

public final class d {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private b.C0124b f10933a;

        private a() {
        }

        public b.a a() {
            g.a(this.f10933a, b.C0124b.class);
            return new b(this.f10933a);
        }

        public a b(b.C0124b bVar) {
            this.f10933a = (b.C0124b) g.b(bVar);
            return this;
        }
    }

    private static final class b implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private final b.C0124b f10934a;

        /* renamed from: b  reason: collision with root package name */
        private final b f10935b;

        private b(b.C0124b bVar) {
            this.f10935b = this;
            this.f10934a = bVar;
        }

        private b b(b bVar) {
            c.b(bVar, (s) g.d(this.f10934a.n()));
            c.a(bVar, (s9.a) g.d(this.f10934a.b()));
            return bVar;
        }

        public void a(b bVar) {
            b(bVar);
        }
    }

    public static a a() {
        return new a();
    }
}
