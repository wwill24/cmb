package com.coffeemeetsbagel.today_view.today_bagel;

import com.coffeemeetsbagel.models.entities.SuggestedLimitsEntity;
import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;
import sj.a;

final class SuggestedMatchContainerInteractor$handlePassAction$3 extends Lambda implements Function1<Optional<SuggestedLimitsEntity>, b0<? extends Integer>> {
    final /* synthetic */ SuggestedMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedMatchContainerInteractor$handlePassAction$3(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor) {
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
        Integer remainingViews = c10.getRemainingViews();
        if (remainingViews != null) {
            num = Integer.valueOf(remainingViews.intValue() - 1);
        } else {
            num = null;
        }
        return this.this$0.l3().Q(SuggestedLimitsEntity.copy$default(c10, 0, (Integer) null, num, (Integer) null, 11, (Object) null)).E(a.a());
    }
}
