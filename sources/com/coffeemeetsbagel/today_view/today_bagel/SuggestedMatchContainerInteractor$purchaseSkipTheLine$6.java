package com.coffeemeetsbagel.today_view.today_bagel;

import com.coffeemeetsbagel.R;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SuggestedMatchContainerInteractor$purchaseSkipTheLine$6 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ int $expectedTotalPrice;
    final /* synthetic */ int $numOfItemsToPurchase;
    final /* synthetic */ SuggestedMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedMatchContainerInteractor$purchaseSkipTheLine$6(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor, int i10, int i11) {
        super(1);
        this.this$0 = suggestedMatchContainerInteractor;
        this.$numOfItemsToPurchase = i10;
        this.$expectedTotalPrice = i11;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        j.f(th2, "it");
        aVar.c("SuggestedMatchContainerInteractor", "Failed to purchase woo", th2);
        this.this$0.W2().logSpendingVirtualCurrency((long) this.$numOfItemsToPurchase, "woo failure", (long) this.$expectedTotalPrice);
        this.this$0.T2().z1(R.string.skip_the_line_error);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
