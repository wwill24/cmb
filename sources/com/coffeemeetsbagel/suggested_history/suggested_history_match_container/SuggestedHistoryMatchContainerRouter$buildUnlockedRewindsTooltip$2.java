package com.coffeemeetsbagel.suggested_history.suggested_history_match_container;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SuggestedHistoryMatchContainerRouter$buildUnlockedRewindsTooltip$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ SuggestedHistoryMatchContainerRouter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedHistoryMatchContainerRouter$buildUnlockedRewindsTooltip$2(SuggestedHistoryMatchContainerRouter suggestedHistoryMatchContainerRouter) {
        super(1);
        this.this$0 = suggestedHistoryMatchContainerRouter;
    }

    public final void a(View view) {
        j.g(view, "it");
        this.this$0.u(true);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((View) obj);
        return Unit.f32013a;
    }
}
