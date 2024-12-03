package com.coffemeetsbagel.hide_report.list;

import b6.t;
import c9.d;
import com.coffemeetsbagel.hide_report.h;
import com.coffemeetsbagel.hide_report.list.f;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private f.b f37686a;

        /* renamed from: b  reason: collision with root package name */
        private h f37687b;

        private a() {
        }

        public f.a a() {
            g.a(this.f37686a, f.b.class);
            g.a(this.f37687b, h.class);
            return new C0475b(this.f37686a, this.f37687b);
        }

        public a b(h hVar) {
            this.f37687b = (h) g.b(hVar);
            return this;
        }

        public a c(f.b bVar) {
            this.f37686a = (f.b) g.b(bVar);
            return this;
        }
    }

    /* renamed from: com.coffemeetsbagel.hide_report.list.b$b  reason: collision with other inner class name */
    private static final class C0475b implements f.a {

        /* renamed from: a  reason: collision with root package name */
        private final f.b f37688a;

        /* renamed from: b  reason: collision with root package name */
        private final h f37689b;

        /* renamed from: c  reason: collision with root package name */
        private final C0475b f37690c;

        private C0475b(f.b bVar, h hVar) {
            this.f37690c = this;
            this.f37688a = bVar;
            this.f37689b = hVar;
        }

        private HideReportReasonListInteractor c(HideReportReasonListInteractor hideReportReasonListInteractor) {
            t.a(hideReportReasonListInteractor, g.a(this.f37688a));
            j.b(hideReportReasonListInteractor, (d) g.d(this.f37689b.p()));
            j.a(hideReportReasonListInteractor, (c9.a) g.d(this.f37689b.I()));
            return hideReportReasonListInteractor;
        }

        /* renamed from: b */
        public void l1(HideReportReasonListInteractor hideReportReasonListInteractor) {
            c(hideReportReasonListInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
