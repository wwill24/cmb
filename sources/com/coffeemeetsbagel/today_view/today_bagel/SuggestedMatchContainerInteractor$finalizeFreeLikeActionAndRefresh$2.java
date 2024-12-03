package com.coffeemeetsbagel.today_view.today_bagel;

import com.coffeemeetsbagel.models.entities.SuggestedLimitsEntity;
import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;
import sj.a;

final class SuggestedMatchContainerInteractor$finalizeFreeLikeActionAndRefresh$2 extends Lambda implements Function1<Optional<SuggestedLimitsEntity>, b0<? extends Integer>> {
    final /* synthetic */ SuggestedMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedMatchContainerInteractor$finalizeFreeLikeActionAndRefresh$2(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor) {
        super(1);
        this.this$0 = suggestedMatchContainerInteractor;
    }

    /* renamed from: a */
    public final b0<? extends Integer> invoke(Optional<SuggestedLimitsEntity> optional) {
        Integer num;
        j.g(optional, "optionalLimit");
        if (!optional.d()) {
            return w.C(0);
        }
        SuggestedLimitsEntity c10 = optional.c();
        j.f(c10, "limitsEntity");
        Integer remainingLikes = c10.getRemainingLikes();
        Integer num2 = null;
        if (remainingLikes != null) {
            num = Integer.valueOf(remainingLikes.intValue() - 1);
        } else {
            num = null;
        }
        Integer remainingViews = c10.getRemainingViews();
        if (remainingViews != null) {
            num2 = Integer.valueOf(remainingViews.intValue() - 1);
        }
        return this.this$0.l3().Q(SuggestedLimitsEntity.copy$default(c10, 0, num, num2, (Integer) null, 9, (Object) null)).E(a.a());
    }
}
