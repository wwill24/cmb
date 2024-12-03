package com.coffeemeetsbagel.subscription_dialog.variants_carousel;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class VariantsCarouselInteractor$didBecomeActive$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ VariantsCarouselInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VariantsCarouselInteractor$didBecomeActive$2(VariantsCarouselInteractor variantsCarouselInteractor) {
        super(1);
        this.this$0 = variantsCarouselInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String O1 = this.this$0.O1();
        j.f(th2, "throwable");
        aVar.c(O1, "Failed to load carousel.", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
