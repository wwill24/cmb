package com.coffeemeetsbagel.suggested_history.suggested_history_list;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SuggestedHistoryListInteractor$renderUpsellBanner$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ SuggestedHistoryListInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedHistoryListInteractor$renderUpsellBanner$2(SuggestedHistoryListInteractor suggestedHistoryListInteractor) {
        super(1);
        this.this$0 = suggestedHistoryListInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String M1 = this.this$0.f37143n;
        j.f(M1, "tag");
        j.f(th2, "it");
        aVar.c(M1, "problem getting user", th2);
        ((SuggestedHistoryListRouter) this.this$0.B1()).o();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
