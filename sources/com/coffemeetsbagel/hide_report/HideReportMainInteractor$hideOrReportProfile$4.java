package com.coffemeetsbagel.hide_report;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class HideReportMainInteractor$hideOrReportProfile$4 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ HideReportMainInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HideReportMainInteractor$hideOrReportProfile$4(HideReportMainInteractor hideReportMainInteractor) {
        super(1);
        this.this$0 = hideReportMainInteractor;
    }

    public final void a(Throwable th2) {
        HideReportMainInteractor hideReportMainInteractor = this.this$0;
        hideReportMainInteractor.c2(hideReportMainInteractor.f37649z);
        a.C0491a aVar = a.f40771d;
        String R1 = this.this$0.f37645t;
        j.f(th2, "it");
        aVar.c(R1, "", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
