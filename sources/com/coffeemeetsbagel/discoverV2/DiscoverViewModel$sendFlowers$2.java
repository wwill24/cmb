package com.coffeemeetsbagel.discoverV2;

import android.os.Bundle;
import com.coffeemeetsbagel.store.k0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import v8.a;

final class DiscoverViewModel$sendFlowers$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ DiscoverViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoverViewModel$sendFlowers$2(DiscoverViewModel discoverViewModel) {
        super(1);
        this.this$0 = discoverViewModel;
    }

    public final void a(Boolean bool) {
        this.this$0.Y().f();
        this.this$0.Y().e(new Bundle(), (a) null);
        this.this$0.b0().refreshPricesFromApi((k0.a) null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Boolean) obj);
        return Unit.f32013a;
    }
}
