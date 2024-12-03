package com.coffeemeetsbagel.subscription_dialog.benefits_carousel;

import com.coffeemeetsbagel.utils.model.Optional;
import fa.a;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import vb.b;
import vb.c;

final class BenefitsCarouselInteractor$didBecomeActive$1 extends Lambda implements Function1<Optional<c>, Unit> {
    final /* synthetic */ BenefitsCarouselInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BenefitsCarouselInteractor$didBecomeActive$1(BenefitsCarouselInteractor benefitsCarouselInteractor) {
        super(1);
        this.this$0 = benefitsCarouselInteractor;
    }

    public final void a(Optional<c> optional) {
        if (optional.d()) {
            List<b> a10 = optional.c().a();
            if (a10.isEmpty()) {
                ((g) this.this$0.f7875e).m(this.this$0.f37009f);
                this.this$0.Q1().d("Subscription - Default benefits displayed");
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(a10, 10)), 16));
            for (T next : a10) {
                linkedHashMap.put(((b) next).e(), next);
            }
            ((g) this.this$0.f7875e).l(linkedHashMap, this.this$0.f37009f);
            return;
        }
        a.f40771d.c(this.this$0.f37014l, "No bundle found", new IllegalStateException("No bundle found"));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Optional) obj);
        return Unit.f32013a;
    }
}
