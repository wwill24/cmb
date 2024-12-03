package com.coffeemeetsbagel.suggested_history.suggested_history_list;

import ja.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SuggestedHistoryListInteractor$renderUpsellBanner$1 extends Lambda implements Function1<b, Unit> {
    final /* synthetic */ SuggestedHistoryListInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedHistoryListInteractor$renderUpsellBanner$1(SuggestedHistoryListInteractor suggestedHistoryListInteractor) {
        super(1);
        this.this$0 = suggestedHistoryListInteractor;
    }

    public final void a(b bVar) {
        SuggestedHistoryListInteractor suggestedHistoryListInteractor = this.this$0;
        j.f(bVar, "userOptional");
        suggestedHistoryListInteractor.b2(bVar);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((b) obj);
        return Unit.f32013a;
    }
}
