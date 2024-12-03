package com.coffeemeetsbagel.today_view.card.actioncards;

import com.coffeemeetsbagel.match.j;
import j5.x;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

final class ActionCardInteractor$purchaseBonusBagel$bonusBagelListener$1$2 extends Lambda implements Function2<x, Throwable, Unit> {
    final /* synthetic */ j.d $errorListener;
    final /* synthetic */ ActionCardInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActionCardInteractor$purchaseBonusBagel$bonusBagelListener$1$2(ActionCardInteractor actionCardInteractor, j.d dVar) {
        super(2);
        this.this$0 = actionCardInteractor;
        this.$errorListener = dVar;
    }

    public final void a(x xVar, Throwable th2) {
        if (xVar != null) {
            ActionCardInteractor actionCardInteractor = this.this$0;
            ((ActionCardPresenter) actionCardInteractor.f7875e).v();
            actionCardInteractor.y2().e();
        }
        if (th2 != null) {
            this.$errorListener.a(th2);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        a((x) obj, (Throwable) obj2);
        return Unit.f32013a;
    }
}
