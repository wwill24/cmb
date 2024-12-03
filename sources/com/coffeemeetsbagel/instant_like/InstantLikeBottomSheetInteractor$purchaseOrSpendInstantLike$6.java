package com.coffeemeetsbagel.instant_like;

import com.coffeemeetsbagel.store.alc.PurchaseType;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InstantLikeBottomSheetInteractor$purchaseOrSpendInstantLike$6 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ int $beanPrice;
    final /* synthetic */ InstantLikePaymentType $paymentType;
    final /* synthetic */ InstantLikeBottomSheetInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstantLikeBottomSheetInteractor$purchaseOrSpendInstantLike$6(InstantLikeBottomSheetInteractor instantLikeBottomSheetInteractor, int i10, InstantLikePaymentType instantLikePaymentType) {
        super(1);
        this.this$0 = instantLikeBottomSheetInteractor;
        this.$beanPrice = i10;
        this.$paymentType = instantLikePaymentType;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String X1 = this.this$0.f13996w;
        j.f(X1, "tag");
        j.f(th2, "it");
        aVar.c(X1, "failed to purchase Instant Like", th2);
        ((InstantLikeBottomSheetRouter) this.this$0.B1()).o();
        ((InstantLikeBottomSheetRouter) this.this$0.B1()).v();
        this.this$0.f13985f.a();
        com.coffeemeetsbagel.store.alc.a n22 = this.this$0.n2();
        String a10 = PurchaseType.INSTANT_LIKE.a();
        j.f(a10, "INSTANT_LIKE.analyticsItemName");
        n22.a(a10, 1, this.$beanPrice);
        this.this$0.r2().d(this.this$0.f13987h, this.$paymentType);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
