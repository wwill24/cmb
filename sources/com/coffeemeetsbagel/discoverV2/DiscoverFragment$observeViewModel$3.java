package com.coffeemeetsbagel.discoverV2;

import com.coffeemeetsbagel.discoverV2.filters.DiscoverFeedFiltersView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DiscoverFragment$observeViewModel$3 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ DiscoverFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoverFragment$observeViewModel$3(DiscoverFragment discoverFragment) {
        super(1);
        this.this$0 = discoverFragment;
    }

    public final void a(Integer num) {
        DiscoverFeedFiltersView discoverFeedFiltersView = null;
        if (this.this$0.h1().a("OnePaidLike.Enabled.Android")) {
            DiscoverFeedFiltersView I0 = this.this$0.C;
            if (I0 == null) {
                j.y("discoverFeedFiltersView");
            } else {
                discoverFeedFiltersView = I0;
            }
            j.f(num, "freeFlowers");
            discoverFeedFiltersView.F(num.intValue());
            return;
        }
        DiscoverFeedFiltersView I02 = this.this$0.C;
        if (I02 == null) {
            j.y("discoverFeedFiltersView");
        } else {
            discoverFeedFiltersView = I02;
        }
        discoverFeedFiltersView.C();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Integer) obj);
        return Unit.f32013a;
    }
}
