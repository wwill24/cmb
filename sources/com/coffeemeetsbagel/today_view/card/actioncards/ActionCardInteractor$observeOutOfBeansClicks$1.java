package com.coffeemeetsbagel.today_view.card.actioncards;

import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class ActionCardInteractor$observeOutOfBeansClicks$1 extends Lambda implements Function1<Unit, Unit> {
    final /* synthetic */ PurchaseType $purchaseType;
    final /* synthetic */ ActionCardInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActionCardInteractor$observeOutOfBeansClicks$1(ActionCardInteractor actionCardInteractor, PurchaseType purchaseType) {
        super(1);
        this.this$0 = actionCardInteractor;
        this.$purchaseType = purchaseType;
    }

    public final void a(Unit unit) {
        Price price = this.this$0.t2().getPrice(this.$purchaseType);
        if (price != null) {
            ((a0) this.this$0.B1()).x(this.$purchaseType, 1, price, price.getBeanCost(1));
            return;
        }
        a.C0491a aVar = a.f40771d;
        PurchaseType purchaseType = this.$purchaseType;
        aVar.f(new IllegalStateException(purchaseType + " price object null"));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Unit) obj);
        return Unit.f32013a;
    }
}
