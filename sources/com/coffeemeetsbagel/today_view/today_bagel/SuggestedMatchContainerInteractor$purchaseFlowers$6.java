package com.coffeemeetsbagel.today_view.today_bagel;

import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.alc.a;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SuggestedMatchContainerInteractor$purchaseFlowers$6 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ int $expectedTotalPrice;
    final /* synthetic */ SuggestedMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedMatchContainerInteractor$purchaseFlowers$6(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor, int i10) {
        super(1);
        this.this$0 = suggestedMatchContainerInteractor;
        this.$expectedTotalPrice = i10;
    }

    public final void a(Throwable th2) {
        a O2 = this.this$0.O2();
        String a10 = PurchaseType.PAID_LIKE.a();
        j.f(a10, "PAID_LIKE.analyticsItemName");
        O2.a(a10, 1, this.$expectedTotalPrice);
        this.this$0.T2().z1(R.string.send_flowers_error_message);
        a.C0491a aVar = fa.a.f40771d;
        j.f(th2, "it");
        aVar.c("SuggestedMatchContainerInteractor", "Failed to purchase flower", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
