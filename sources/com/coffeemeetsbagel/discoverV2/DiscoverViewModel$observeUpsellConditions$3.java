package com.coffeemeetsbagel.discoverV2;

import com.coffeemeetsbagel.discoverV2.DiscoverViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class DiscoverViewModel$observeUpsellConditions$3 extends Lambda implements Function1<DiscoverViewModel.FilterStateViewState, Unit> {
    final /* synthetic */ DiscoverViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoverViewModel$observeUpsellConditions$3(DiscoverViewModel discoverViewModel) {
        super(1);
        this.this$0 = discoverViewModel;
    }

    public final void a(DiscoverViewModel.FilterStateViewState filterStateViewState) {
        this.this$0.B.o(this.this$0.e0());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((DiscoverViewModel.FilterStateViewState) obj);
        return Unit.f32013a;
    }
}
