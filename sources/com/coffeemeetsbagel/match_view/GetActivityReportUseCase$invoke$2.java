package com.coffeemeetsbagel.match_view;

import fa.a;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import rn.c;

final class GetActivityReportUseCase$invoke$2 extends Lambda implements Function1<c, Unit> {
    final /* synthetic */ String $profileId;
    final /* synthetic */ GetActivityReportUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetActivityReportUseCase$invoke$2(GetActivityReportUseCase getActivityReportUseCase, String str) {
        super(1);
        this.this$0 = getActivityReportUseCase;
        this.$profileId = str;
    }

    /* access modifiers changed from: private */
    public static final void d(String str, Map map) {
        j.g(str, "$profileId");
        a.C0491a aVar = a.f40771d;
        String simpleName = GetActivityReportUseCase.class.getSimpleName();
        j.f(simpleName, "GetActivityReportUseCase::class.java.simpleName");
        aVar.a(simpleName, "Fetch complete for " + str + ".");
    }

    public final void c(c cVar) {
        this.this$0.f34599c.b(p.e(this.$profileId), new i(this.$profileId));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        c((c) obj);
        return Unit.f32013a;
    }
}
