package com.coffeemeetsbagel.today_view.today_bagel;

import com.coffeemeetsbagel.models.dto.MatchContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SuggestedMatchContainerInteractor$fetchAndRenderMatchContext$1 extends Lambda implements Function1<MatchContext, Unit> {
    final /* synthetic */ SuggestedMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedMatchContainerInteractor$fetchAndRenderMatchContext$1(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor) {
        super(1);
        this.this$0 = suggestedMatchContainerInteractor;
    }

    public final void a(MatchContext matchContext) {
        j.f(matchContext, "it");
        ((n0) this.this$0.B1()).L(matchContext);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((MatchContext) obj);
        return Unit.f32013a;
    }
}
