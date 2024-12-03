package com.coffeemeetsbagel.discoverV2;

import com.coffeemeetsbagel.models.interfaces.GiveTakeBase;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class DiscoverViewModel$observeUpsellConditions$4 extends Lambda implements Function1<List<? extends GiveTakeBase>, Unit> {
    final /* synthetic */ DiscoverViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoverViewModel$observeUpsellConditions$4(DiscoverViewModel discoverViewModel) {
        super(1);
        this.this$0 = discoverViewModel;
    }

    public final void a(List<? extends GiveTakeBase> list) {
        this.this$0.B.o(this.this$0.e0());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
