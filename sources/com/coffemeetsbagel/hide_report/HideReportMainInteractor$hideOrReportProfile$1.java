package com.coffemeetsbagel.hide_report;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tj.b;

final class HideReportMainInteractor$hideOrReportProfile$1 extends Lambda implements Function1<b, Unit> {
    final /* synthetic */ HideReportMainInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HideReportMainInteractor$hideOrReportProfile$1(HideReportMainInteractor hideReportMainInteractor) {
        super(1);
        this.this$0 = hideReportMainInteractor;
    }

    public final void a(b bVar) {
        ((HideReportMainPresenter) this.this$0.f7875e).q();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((b) obj);
        return Unit.f32013a;
    }
}
