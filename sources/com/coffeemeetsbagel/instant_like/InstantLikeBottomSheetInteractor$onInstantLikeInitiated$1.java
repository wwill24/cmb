package com.coffeemeetsbagel.instant_like;

import com.coffeemeetsbagel.feature.purchase.AutoPurchase;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InstantLikeBottomSheetInteractor$onInstantLikeInitiated$1 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ String $matchId;
    final /* synthetic */ Price $price;
    final /* synthetic */ InstantLikeBottomSheetInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstantLikeBottomSheetInteractor$onInstantLikeInitiated$1(Price price, InstantLikeBottomSheetInteractor instantLikeBottomSheetInteractor, String str) {
        super(1);
        this.$price = price;
        this.this$0 = instantLikeBottomSheetInteractor;
        this.$matchId = str;
    }

    public final void a(Long l10) {
        boolean z10;
        j.f(l10, "beanBalance");
        if (l10.longValue() >= ((long) this.$price.getBeans())) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.this$0.w2(this.$matchId, this.$price.getBeans(), InstantLikePaymentType.BEANS);
            return;
        }
        InstantLikeBottomSheetInteractor instantLikeBottomSheetInteractor = this.this$0;
        PurchaseType purchaseType = PurchaseType.INSTANT_LIKE;
        Price price = this.$price;
        instantLikeBottomSheetInteractor.f13999z = new AutoPurchase(purchaseType, 1, price, price.getBeans(), this.$matchId);
        ((InstantLikeBottomSheetRouter) this.this$0.B1()).t(this.$price);
        this.this$0.r2().f();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Long) obj);
        return Unit.f32013a;
    }
}
