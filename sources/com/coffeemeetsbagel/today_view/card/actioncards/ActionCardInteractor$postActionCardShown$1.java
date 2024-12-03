package com.coffeemeetsbagel.today_view.card.actioncards;

import com.coffeemeetsbagel.models.responses.ResponseActionCards;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

final class ActionCardInteractor$postActionCardShown$1 extends Lambda implements Function2<ResponseActionCards, Throwable, Unit> {
    final /* synthetic */ ActionCardInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActionCardInteractor$postActionCardShown$1(ActionCardInteractor actionCardInteractor) {
        super(2);
        this.this$0 = actionCardInteractor;
    }

    public final void a(ResponseActionCards responseActionCards, Throwable th2) {
        if (responseActionCards.isSuccessful()) {
            a.f40771d.a(this.this$0.H, "post action card shown request success.");
        }
        if (th2 != null) {
            a.f40771d.c(this.this$0.H, "post action card shown request error", th2);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        a((ResponseActionCards) obj, (Throwable) obj2);
        return Unit.f32013a;
    }
}
