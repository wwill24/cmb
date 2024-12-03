package com.coffeemeetsbagel.instant_like;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InstantLikeBottomSheetInteractor$purchaseOrSpendInstantLike$5 extends Lambda implements Function1<Bagel, Unit> {
    final /* synthetic */ int $beanPrice;
    final /* synthetic */ InstantLikePaymentType $paymentType;
    final /* synthetic */ InstantLikeBottomSheetInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstantLikeBottomSheetInteractor$purchaseOrSpendInstantLike$5(InstantLikeBottomSheetInteractor instantLikeBottomSheetInteractor, int i10, InstantLikePaymentType instantLikePaymentType) {
        super(1);
        this.this$0 = instantLikeBottomSheetInteractor;
        this.$beanPrice = i10;
        this.$paymentType = instantLikePaymentType;
    }

    public final void a(Bagel bagel) {
        boolean z10;
        String lastUpdated = bagel.getLastUpdated();
        if (lastUpdated == null || lastUpdated.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            String str = "bagel " + bagel.getId() + " missing last_updated";
            a.C0491a aVar = a.f40771d;
            String X1 = this.this$0.f13996w;
            j.f(X1, "tag");
            aVar.c(X1, str, new IllegalArgumentException(str));
        }
        this.this$0.s2();
        com.coffeemeetsbagel.store.alc.a n22 = this.this$0.n2();
        String a10 = PurchaseType.INSTANT_LIKE.a();
        j.f(a10, "INSTANT_LIKE.analyticsItemName");
        n22.b(a10, 1, this.$beanPrice);
        this.this$0.r2().c(this.this$0.f13987h, this.$paymentType);
        this.this$0.r2().g();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Bagel) obj);
        return Unit.f32013a;
    }
}
