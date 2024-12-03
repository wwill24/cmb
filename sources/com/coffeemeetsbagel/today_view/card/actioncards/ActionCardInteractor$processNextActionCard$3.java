package com.coffeemeetsbagel.today_view.card.actioncards;

import com.coffeemeetsbagel.models.dto.ActionCard;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ActionCardInteractor$processNextActionCard$3 extends Lambda implements Function1<ActionCard, Unit> {
    final /* synthetic */ ActionCardInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActionCardInteractor$processNextActionCard$3(ActionCardInteractor actionCardInteractor) {
        super(1);
        this.this$0 = actionCardInteractor;
    }

    public final void a(ActionCard actionCard) {
        ActionCardInteractor actionCardInteractor = this.this$0;
        j.f(actionCard, "it");
        actionCardInteractor.G = actionCard;
        this.this$0.D2(actionCard);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((ActionCard) obj);
        return Unit.f32013a;
    }
}
