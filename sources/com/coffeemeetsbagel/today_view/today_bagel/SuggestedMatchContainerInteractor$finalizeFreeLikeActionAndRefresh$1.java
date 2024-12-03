package com.coffeemeetsbagel.today_view.today_bagel;

import com.coffeemeetsbagel.models.entities.SuggestedLimitsEntity;
import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;
import vb.a;

final class SuggestedMatchContainerInteractor$finalizeFreeLikeActionAndRefresh$1 extends Lambda implements Function1<Optional<a>, b0<? extends Optional<SuggestedLimitsEntity>>> {
    final /* synthetic */ SuggestedMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedMatchContainerInteractor$finalizeFreeLikeActionAndRefresh$1(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor) {
        super(1);
        this.this$0 = suggestedMatchContainerInteractor;
    }

    /* renamed from: a */
    public final b0<? extends Optional<SuggestedLimitsEntity>> invoke(Optional<a> optional) {
        j.g(optional, "optionalSubscription");
        if (!optional.d()) {
            return this.this$0.l3().x().L();
        }
        return w.C(Optional.a());
    }
}
