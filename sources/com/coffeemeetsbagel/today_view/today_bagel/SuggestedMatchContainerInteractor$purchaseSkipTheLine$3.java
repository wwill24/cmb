package com.coffeemeetsbagel.today_view.today_bagel;

import android.os.Bundle;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.store.k0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import v8.a;

final class SuggestedMatchContainerInteractor$purchaseSkipTheLine$3 extends Lambda implements Function1<Bagel, Unit> {
    final /* synthetic */ SuggestedMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedMatchContainerInteractor$purchaseSkipTheLine$3(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor) {
        super(1);
        this.this$0 = suggestedMatchContainerInteractor;
    }

    public final void a(Bagel bagel) {
        this.this$0.Q2().u(bagel);
        this.this$0.d3().e(new Bundle(), (a) null);
        this.this$0.g3().refreshPricesFromApi((k0.a) null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Bagel) obj);
        return Unit.f32013a;
    }
}
