package com.coffeemeetsbagel.suggested_history.suggested_history_match_container;

import com.coffeemeetsbagel.models.Bagel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class SuggestedHistoryMatchContainerRouter$showConnectionDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Bagel $bagel;
    final /* synthetic */ d $parentListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedHistoryMatchContainerRouter$showConnectionDialog$1(d dVar, Bagel bagel) {
        super(0);
        this.$parentListener = dVar;
        this.$bagel = bagel;
    }

    public final void invoke() {
        this.$parentListener.b(this.$bagel);
    }
}
