package com.coffeemeetsbagel.suggested_history.suggested_history_match_container;

import android.os.Bundle;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.store.k0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import v8.a;

final class SuggestedHistoryMatchContainerInteractor$purchaseFlowers$2 extends Lambda implements Function1<Bagel, Unit> {
    final /* synthetic */ SuggestedHistoryMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedHistoryMatchContainerInteractor$purchaseFlowers$2(SuggestedHistoryMatchContainerInteractor suggestedHistoryMatchContainerInteractor) {
        super(1);
        this.this$0 = suggestedHistoryMatchContainerInteractor;
    }

    public final void a(Bagel bagel) {
        this.this$0.s2().e(new Bundle(), (a) null);
        this.this$0.u2().refreshPricesFromApi((k0.a) null);
        this.this$0.n2().u(bagel);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Bagel) obj);
        return Unit.f32013a;
    }
}
