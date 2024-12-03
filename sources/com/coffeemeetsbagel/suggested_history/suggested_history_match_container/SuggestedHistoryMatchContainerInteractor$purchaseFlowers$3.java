package com.coffeemeetsbagel.suggested_history.suggested_history_match_container;

import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.alc.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SuggestedHistoryMatchContainerInteractor$purchaseFlowers$3 extends Lambda implements Function1<Bagel, Unit> {
    final /* synthetic */ int $expectedTotalPrice;
    final /* synthetic */ SuggestedHistoryMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedHistoryMatchContainerInteractor$purchaseFlowers$3(SuggestedHistoryMatchContainerInteractor suggestedHistoryMatchContainerInteractor, int i10) {
        super(1);
        this.this$0 = suggestedHistoryMatchContainerInteractor;
        this.$expectedTotalPrice = i10;
    }

    public final void a(Bagel bagel) {
        a l22 = this.this$0.l2();
        String a10 = PurchaseType.PAID_LIKE.a();
        j.f(a10, "PAID_LIKE.analyticsItemName");
        l22.b(a10, 1, this.$expectedTotalPrice);
        d X1 = this.this$0.f37174g;
        String profileId = bagel.getProfileId();
        j.f(profileId, "it.profileId");
        X1.c(profileId);
        this.this$0.P2("paidlike");
        ((h0) this.this$0.f7875e).P(R.string.send_flowers_success_message);
        ((SuggestedHistoryMatchContainerRouter) this.this$0.B1()).t();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Bagel) obj);
        return Unit.f32013a;
    }
}
