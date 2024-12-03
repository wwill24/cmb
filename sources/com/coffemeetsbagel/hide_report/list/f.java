package com.coffemeetsbagel.hide_report.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import b6.c;
import b6.j;
import com.coffemeetsbagel.hide_report.HideReportType;
import com.coffemeetsbagel.hide_report.h;

public final class f extends c<m, h> {

    public interface a extends j<HideReportReasonListInteractor> {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final rc.c f37701a;

        /* renamed from: b  reason: collision with root package name */
        private final n f37702b;

        /* renamed from: c  reason: collision with root package name */
        private final HideReportType f37703c;

        public b(rc.c cVar, n nVar, HideReportType hideReportType) {
            kotlin.jvm.internal.j.g(cVar, "binding");
            kotlin.jvm.internal.j.g(nVar, "userInteractionListener");
            kotlin.jvm.internal.j.g(hideReportType, "type");
            this.f37701a = cVar;
            this.f37702b = nVar;
            this.f37703c = hideReportType;
        }

        public final l a() {
            return new l(this.f37701a, this.f37702b, this.f37703c);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(h hVar) {
        super(hVar);
        kotlin.jvm.internal.j.g(hVar, "dependency");
    }

    public final m b(ViewGroup viewGroup, HideReportType hideReportType, boolean z10, com.coffemeetsbagel.hide_report.b bVar) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        kotlin.jvm.internal.j.g(hideReportType, "type");
        kotlin.jvm.internal.j.g(bVar, "listListener");
        HideReportReasonListInteractor hideReportReasonListInteractor = new HideReportReasonListInteractor(hideReportType, z10, bVar);
        rc.c c10 = rc.c.c(LayoutInflater.from(((h) a()).a()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        a a10 = b.a().c(new b(c10, hideReportReasonListInteractor, hideReportType)).b((h) a()).a();
        ConstraintLayout b10 = c10.getRoot();
        kotlin.jvm.internal.j.f(b10, "binding.root");
        kotlin.jvm.internal.j.f(a10, "component");
        return new m(b10, a10, hideReportReasonListInteractor);
    }
}
