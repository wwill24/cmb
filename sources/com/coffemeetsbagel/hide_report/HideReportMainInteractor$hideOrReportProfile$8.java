package com.coffemeetsbagel.hide_report;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class HideReportMainInteractor$hideOrReportProfile$8 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ String $reasonCategory;
    final /* synthetic */ HideReportMainInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HideReportMainInteractor$hideOrReportProfile$8(String str, HideReportMainInteractor hideReportMainInteractor) {
        super(1);
        this.$reasonCategory = str;
        this.this$0 = hideReportMainInteractor;
    }

    public final void a(Throwable th2) {
        if (j.b(this.$reasonCategory, "remove")) {
            this.this$0.c2(HideReportType.HIDE);
        } else {
            this.this$0.c2(HideReportType.REPORT);
        }
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
