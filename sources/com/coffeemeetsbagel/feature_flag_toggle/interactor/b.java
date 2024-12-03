package com.coffeemeetsbagel.feature_flag_toggle.interactor;

import b6.d;
import b6.t;
import com.coffeemeetsbagel.experiment.r;
import com.coffeemeetsbagel.feature_flag_toggle.b;
import com.coffeemeetsbagel.feature_flag_toggle.interactor.f;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private f.b f13468a;

        /* renamed from: b  reason: collision with root package name */
        private b.a f13469b;

        private a() {
        }

        public f.a a() {
            g.a(this.f13468a, f.b.class);
            g.a(this.f13469b, b.a.class);
            return new C0145b(this.f13468a, this.f13469b);
        }

        public a b(f.b bVar) {
            this.f13468a = (f.b) g.b(bVar);
            return this;
        }

        public a c(b.a aVar) {
            this.f13469b = (b.a) g.b(aVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.feature_flag_toggle.interactor.b$b  reason: collision with other inner class name */
    private static final class C0145b implements f.a {

        /* renamed from: a  reason: collision with root package name */
        private final f.b f13470a;

        /* renamed from: b  reason: collision with root package name */
        private final b.a f13471b;

        /* renamed from: c  reason: collision with root package name */
        private final C0145b f13472c;

        private C0145b(f.b bVar, b.a aVar) {
            this.f13472c = this;
            this.f13470a = bVar;
            this.f13471b = aVar;
        }

        private o b() {
            return g.a(this.f13470a, (d) g.d(this.f13471b.a()), (r) g.d(this.f13471b.b()));
        }

        private l d(l lVar) {
            t.a(lVar, b());
            m.a(lVar, (r) g.d(this.f13471b.b()));
            return lVar;
        }

        /* renamed from: c */
        public void l1(l lVar) {
            d(lVar);
        }
    }

    public static a a() {
        return new a();
    }
}
