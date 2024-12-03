package com.coffeemeetsbagel.shop.post_subscription_benefits;

import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import vb.a;
import vb.b;

final class PostSubscriptionBenefitsCardInteractor$didBecomeActive$2 extends Lambda implements Function1<Optional<a>, Unit> {
    final /* synthetic */ PostSubscriptionBenefitsCardInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostSubscriptionBenefitsCardInteractor$didBecomeActive$2(PostSubscriptionBenefitsCardInteractor postSubscriptionBenefitsCardInteractor) {
        super(1);
        this.this$0 = postSubscriptionBenefitsCardInteractor;
    }

    public final void a(Optional<a> optional) {
        a g10 = optional.g();
        if (g10 != null) {
            PostSubscriptionBenefitsCardInteractor postSubscriptionBenefitsCardInteractor = this.this$0;
            String d10 = g10.d();
            if (d10 != null) {
                ((l) postSubscriptionBenefitsCardInteractor.f7875e).m(d10, g10.a());
            }
            ((l) postSubscriptionBenefitsCardInteractor.f7875e).l();
            for (b k10 : g10.b()) {
                ((l) postSubscriptionBenefitsCardInteractor.f7875e).k(k10);
            }
            postSubscriptionBenefitsCardInteractor.R1(g10);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Optional) obj);
        return Unit.f32013a;
    }
}
