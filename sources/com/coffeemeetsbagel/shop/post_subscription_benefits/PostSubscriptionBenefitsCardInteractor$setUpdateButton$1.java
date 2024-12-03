package com.coffeemeetsbagel.shop.post_subscription_benefits;

import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import vb.a;
import vb.c;

final class PostSubscriptionBenefitsCardInteractor$setUpdateButton$1 extends Lambda implements Function1<Optional<c>, Unit> {
    final /* synthetic */ a $activeSubscription;
    final /* synthetic */ PostSubscriptionBenefitsCardInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostSubscriptionBenefitsCardInteractor$setUpdateButton$1(a aVar, PostSubscriptionBenefitsCardInteractor postSubscriptionBenefitsCardInteractor) {
        super(1);
        this.$activeSubscription = aVar;
        this.this$0 = postSubscriptionBenefitsCardInteractor;
    }

    public final void a(Optional<c> optional) {
        if (optional.d()) {
            boolean z10 = true;
            if (optional.c().i() >= this.$activeSubscription.g() || !(!optional.c().k().isEmpty())) {
                z10 = false;
            }
            ((l) this.this$0.f7875e).n(z10, this.this$0);
            return;
        }
        fa.a.f40771d.c(this.this$0.Q1(), "no bundle found", new IllegalStateException("no bundle found"));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Optional) obj);
        return Unit.f32013a;
    }
}
