package com.coffeemeetsbagel.subscription_dialog.variants_carousel;

import com.coffeemeetsbagel.utils.model.Optional;
import fa.a;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import vb.c;
import vb.d;

final class VariantsCarouselInteractor$didBecomeActive$1 extends Lambda implements Function1<Optional<c>, Unit> {
    final /* synthetic */ VariantsCarouselInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VariantsCarouselInteractor$didBecomeActive$1(VariantsCarouselInteractor variantsCarouselInteractor) {
        super(1);
        this.this$0 = variantsCarouselInteractor;
    }

    public final void a(Optional<c> optional) {
        if (optional.d()) {
            List<d> k10 = optional.c().k();
            this.this$0.P1(k10);
            this.this$0.M1().c(k10);
            return;
        }
        a.f40771d.c(this.this$0.O1(), "bundle not found", new IllegalStateException("bundle not found"));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Optional) obj);
        return Unit.f32013a;
    }
}
