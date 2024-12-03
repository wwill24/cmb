package com.coffeemeetsbagel.subscription_dialog.benefits_carousel;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class BenefitsCarouselInteractor$didBecomeActive$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ BenefitsCarouselInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BenefitsCarouselInteractor$didBecomeActive$2(BenefitsCarouselInteractor benefitsCarouselInteractor) {
        super(1);
        this.this$0 = benefitsCarouselInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String L1 = this.this$0.f37014l;
        j.f(th2, "it");
        aVar.c(L1, "Error loading benefits.", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
