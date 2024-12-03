package com.coffemeetsbagel.hide_report.list;

import com.coffeemeetsbagel.models.Resource;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class HideReportReasonListInteractor$getResourcesFromDb$1 extends Lambda implements Function1<List<? extends Resource>, Unit> {
    final /* synthetic */ HideReportReasonListInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HideReportReasonListInteractor$getResourcesFromDb$1(HideReportReasonListInteractor hideReportReasonListInteractor) {
        super(1);
        this.this$0 = hideReportReasonListInteractor;
    }

    public final void a(List<Resource> list) {
        j.f(list, "resources");
        ((l) this.this$0.f7875e).n(list);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
