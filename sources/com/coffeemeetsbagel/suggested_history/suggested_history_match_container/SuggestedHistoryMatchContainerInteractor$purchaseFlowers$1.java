package com.coffeemeetsbagel.suggested_history.suggested_history_match_container;

import com.coffeemeetsbagel.models.Bagel;
import fa.a;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class SuggestedHistoryMatchContainerInteractor$purchaseFlowers$1 extends Lambda implements Function1<Bagel, b0<? extends Bagel>> {
    final /* synthetic */ SuggestedHistoryMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedHistoryMatchContainerInteractor$purchaseFlowers$1(SuggestedHistoryMatchContainerInteractor suggestedHistoryMatchContainerInteractor) {
        super(1);
        this.this$0 = suggestedHistoryMatchContainerInteractor;
    }

    /* renamed from: a */
    public final b0<? extends Bagel> invoke(Bagel bagel) {
        boolean z10;
        j.g(bagel, "networkUpdatedBagel");
        String lastUpdated = bagel.getLastUpdated();
        if (lastUpdated == null || lastUpdated.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            String str = "bagel " + bagel.getId() + " missing last_updated";
            a.f40771d.c("SuggestedMatchContainerInteractor", str, new IllegalArgumentException(str));
        }
        return this.this$0.v2().e(bagel);
    }
}
