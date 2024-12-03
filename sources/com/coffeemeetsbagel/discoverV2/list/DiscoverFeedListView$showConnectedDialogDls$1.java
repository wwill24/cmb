package com.coffeemeetsbagel.discoverV2.list;

import com.coffeemeetsbagel.models.Bagel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class DiscoverFeedListView$showConnectedDialogDls$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Bagel $connectedBagel;
    final /* synthetic */ DiscoverFeedListView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoverFeedListView$showConnectedDialogDls$1(DiscoverFeedListView discoverFeedListView, Bagel bagel) {
        super(0);
        this.this$0 = discoverFeedListView;
        this.$connectedBagel = bagel;
    }

    public final void invoke() {
        this.this$0.f12322j.d(this.$connectedBagel);
    }
}
