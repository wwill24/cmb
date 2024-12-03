package com.coffeemeetsbagel.today_view.card.actioncards;

import com.coffeemeetsbagel.models.dto.ActionCard;
import com.coffeemeetsbagel.store.domain.BenefitKeys;
import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vb.a;

final class GetFirstEligibleActionCardUseCase$getPaywallInventoryEligibility$1 extends Lambda implements Function1<Optional<a>, Pair<? extends ActionCard, ? extends Boolean>> {
    final /* synthetic */ ActionCard $actionCard;
    final /* synthetic */ GetFirstEligibleActionCardUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetFirstEligibleActionCardUseCase$getPaywallInventoryEligibility$1(GetFirstEligibleActionCardUseCase getFirstEligibleActionCardUseCase, ActionCard actionCard) {
        super(1);
        this.this$0 = getFirstEligibleActionCardUseCase;
        this.$actionCard = actionCard;
    }

    /* renamed from: a */
    public final Pair<ActionCard, Boolean> invoke(Optional<a> optional) {
        j.g(optional, "it");
        if (this.this$0.f37272f.n("SUGGEST_UNLIMITED_NO_INVENTORY_2", false) || !optional.d() || !optional.c().h(BenefitKeys.UNLIMITED_SUGGESTED_VIEWS)) {
            return new Pair<>(this.$actionCard, Boolean.FALSE);
        }
        return new Pair<>(this.$actionCard, Boolean.TRUE);
    }
}
