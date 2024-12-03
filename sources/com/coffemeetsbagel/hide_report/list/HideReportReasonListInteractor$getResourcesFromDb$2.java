package com.coffemeetsbagel.hide_report.list;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class HideReportReasonListInteractor$getResourcesFromDb$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ HideReportReasonListInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HideReportReasonListInteractor$getResourcesFromDb$2(HideReportReasonListInteractor hideReportReasonListInteractor) {
        super(1);
        this.this$0 = hideReportReasonListInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String K1 = this.this$0.f37684m;
        j.f(th2, "throwable");
        aVar.c(K1, "Unable to fetch resources", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
