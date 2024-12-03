package com.coffeemeetsbagel.today_view.today_bagel;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.alc.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SuggestedMatchContainerInteractor$purchaseFlowers$5 extends Lambda implements Function1<Bagel, Unit> {
    final /* synthetic */ int $expectedTotalPrice;
    final /* synthetic */ SuggestedMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedMatchContainerInteractor$purchaseFlowers$5(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor, int i10) {
        super(1);
        this.this$0 = suggestedMatchContainerInteractor;
        this.$expectedTotalPrice = i10;
    }

    public final void a(Bagel bagel) {
        a O2 = this.this$0.O2();
        String a10 = PurchaseType.PAID_LIKE.a();
        j.f(a10, "PAID_LIKE.analyticsItemName");
        O2.b(a10, 1, this.$expectedTotalPrice);
        this.this$0.l4("paidlike");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Bagel) obj);
        return Unit.f32013a;
    }
}
