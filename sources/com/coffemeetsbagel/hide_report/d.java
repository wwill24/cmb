package com.coffemeetsbagel.hide_report;

import b6.t;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.domain.repository.a0;
import com.coffeemeetsbagel.match.j;
import com.coffemeetsbagel.hide_report.i;
import fj.g;

public final class d {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private i.b f37668a;

        /* renamed from: b  reason: collision with root package name */
        private h f37669b;

        private a() {
        }

        public i.a a() {
            g.a(this.f37668a, i.b.class);
            g.a(this.f37669b, h.class);
            return new b(this.f37668a, this.f37669b);
        }

        public a b(h hVar) {
            this.f37669b = (h) g.b(hVar);
            return this;
        }

        public a c(i.b bVar) {
            this.f37668a = (i.b) g.b(bVar);
            return this;
        }
    }

    private static final class b implements i.a {

        /* renamed from: a  reason: collision with root package name */
        private final i.b f37670a;

        /* renamed from: b  reason: collision with root package name */
        private final h f37671b;

        /* renamed from: c  reason: collision with root package name */
        private final b f37672c;

        private b(i.b bVar, h hVar) {
            this.f37672c = this;
            this.f37670a = bVar;
            this.f37671b = hVar;
        }

        private a e() {
            return j.a(this.f37670a, (ProfileRepository) g.d(this.f37671b.A()));
        }

        private HideReportMainInteractor g(HideReportMainInteractor hideReportMainInteractor) {
            t.a(hideReportMainInteractor, k.a(this.f37670a));
            u.e(hideReportMainInteractor, h());
            u.b(hideReportMainInteractor, (j) g.d(this.f37671b.l()));
            u.c(hideReportMainInteractor, e());
            u.d(hideReportMainInteractor, (a0) g.d(this.f37671b.L()));
            u.a(hideReportMainInteractor, (a7.a) g.d(this.f37671b.c()));
            return hideReportMainInteractor;
        }

        private b0 h() {
            return l.a(this.f37670a, (ProfileRepository) g.d(this.f37671b.A()));
        }

        public ProfileRepository A() {
            return (ProfileRepository) g.d(this.f37671b.A());
        }

        public c9.a I() {
            return (c9.a) g.d(this.f37671b.I());
        }

        public a0 L() {
            return (a0) g.d(this.f37671b.L());
        }

        public b6.d<?, ?> a() {
            return (b6.d) g.d(this.f37671b.a());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f37671b.c());
        }

        /* renamed from: f */
        public void l1(HideReportMainInteractor hideReportMainInteractor) {
            g(hideReportMainInteractor);
        }

        public j l() {
            return (j) g.d(this.f37671b.l());
        }

        public c9.d p() {
            return (c9.d) g.d(this.f37671b.p());
        }
    }

    public static a a() {
        return new a();
    }
}
