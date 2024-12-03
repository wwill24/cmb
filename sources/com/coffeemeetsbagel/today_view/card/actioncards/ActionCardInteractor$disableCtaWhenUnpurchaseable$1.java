package com.coffeemeetsbagel.today_view.card.actioncards;

import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.dto.ActionCard;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import fa.a;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class ActionCardInteractor$disableCtaWhenUnpurchaseable$1 extends Lambda implements Function1<Map<String, Price>, Unit> {
    final /* synthetic */ ActionCard $actionCard;
    final /* synthetic */ PurchaseType $purchaseType;
    final /* synthetic */ ActionCardInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActionCardInteractor$disableCtaWhenUnpurchaseable$1(PurchaseType purchaseType, ActionCardInteractor actionCardInteractor, ActionCard actionCard) {
        super(1);
        this.$purchaseType = purchaseType;
        this.this$0 = actionCardInteractor;
        this.$actionCard = actionCard;
    }

    public final void a(Map<String, Price> map) {
        Unit unit;
        Price price = map.get(this.$purchaseType.d());
        if (price != null) {
            this.this$0.Y2(this.$actionCard, price);
            unit = Unit.f32013a;
        } else {
            unit = null;
        }
        if (unit == null) {
            ActionCardInteractor actionCardInteractor = this.this$0;
            ((ActionCardPresenter) actionCardInteractor.f7875e).o();
            a.f40771d.a(actionCardInteractor.H, "Updated price not available, disabling CTA.");
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Map) obj);
        return Unit.f32013a;
    }
}
