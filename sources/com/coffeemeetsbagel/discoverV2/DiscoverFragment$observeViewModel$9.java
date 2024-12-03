package com.coffeemeetsbagel.discoverV2;

import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.discoverV2.list.DiscoverFeedListView;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.interfaces.GiveTakeBase;
import k6.i;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DiscoverFragment$observeViewModel$9 extends Lambda implements Function1<Pair<? extends GiveTakeBase, ? extends Bagel>, Unit> {
    final /* synthetic */ DiscoverFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoverFragment$observeViewModel$9(DiscoverFragment discoverFragment) {
        super(1);
        this.this$0 = discoverFragment;
    }

    public final void a(Pair<? extends GiveTakeBase, ? extends Bagel> pair) {
        String str;
        if (pair != null) {
            GiveTakeBase giveTakeBase = (GiveTakeBase) pair.c();
            Bagel bagel = (Bagel) pair.d();
            DiscoverFeedListView discoverFeedListView = null;
            if (giveTakeBase.getProfile().isFemale()) {
                i F0 = this.this$0.f12182c;
                if (F0 == null) {
                    j.y("binding");
                    F0 = null;
                }
                str = F0.getRoot().getContext().getString(R.string.discover_like_congratulations_connected_with_female, new Object[]{giveTakeBase.getProfile().getUserFirstName()});
            } else {
                i F02 = this.this$0.f12182c;
                if (F02 == null) {
                    j.y("binding");
                    F02 = null;
                }
                str = F02.getRoot().getContext().getString(R.string.discover_like_congratulations_connected_with_male, new Object[]{giveTakeBase.getProfile().getUserFirstName()});
            }
            j.f(str, "if (risingGiveTake.profi… )\n\n                    }");
            DiscoverFeedListView J0 = this.this$0.f12198y;
            if (J0 == null) {
                j.y("discoverListView");
            } else {
                discoverFeedListView = J0;
            }
            j.d(bagel);
            discoverFeedListView.A(bagel, str);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.f32013a;
    }
}
