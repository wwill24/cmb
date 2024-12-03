package com.coffeemeetsbagel.today_view.today_bagel;

import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.alc.a;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SuggestedMatchContainerInteractor$purchaseSkipTheLine$5 extends Lambda implements Function1<Bagel, Unit> {
    final /* synthetic */ int $expectedTotalPrice;
    final /* synthetic */ int $numOfItemsToPurchase;
    final /* synthetic */ SuggestedMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedMatchContainerInteractor$purchaseSkipTheLine$5(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor, int i10, int i11) {
        super(1);
        this.this$0 = suggestedMatchContainerInteractor;
        this.$numOfItemsToPurchase = i10;
        this.$expectedTotalPrice = i11;
    }

    public final void a(Bagel bagel) {
        this.this$0.W2().logSpendingVirtualCurrency((long) this.$numOfItemsToPurchase, "woo success", (long) this.$expectedTotalPrice);
        this.this$0.T2().z1(R.string.skip_the_line_success);
        HashMap hashMap = new HashMap();
        hashMap.put("user_action_timestamp", String.valueOf(System.currentTimeMillis()));
        a e32 = this.this$0.e3();
        String a10 = PurchaseType.WOO.a();
        j.f(a10, "WOO.analyticsItemName");
        e32.b(a10, this.$numOfItemsToPurchase, this.$expectedTotalPrice);
        this.this$0.P2().trackEvent("bagel_liked_action", hashMap);
        int totalWoos = this.this$0.f37389f.getTotalWoos() + this.$numOfItemsToPurchase;
        this.this$0.f37389f.setTotalWoos(totalWoos);
        ((n0) this.this$0.B1()).P(totalWoos);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Bagel) obj);
        return Unit.f32013a;
    }
}
