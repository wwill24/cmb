package com.coffeemeetsbagel.today_view.today_bagel;

import com.coffeemeetsbagel.models.Bagel;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class SuggestedMatchContainerInteractor$markBagelAsSeenV2$1 extends Lambda implements Function1<Bagel, Unit> {
    final /* synthetic */ SuggestedMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedMatchContainerInteractor$markBagelAsSeenV2$1(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor) {
        super(1);
        this.this$0 = suggestedMatchContainerInteractor;
    }

    public final void a(Bagel bagel) {
        this.this$0.P.accept(Boolean.TRUE);
        a.f40771d.a("SuggestedMatchContainerInteractor", "successfully mark bagel as 'checked'");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Bagel) obj);
        return Unit.f32013a;
    }
}
