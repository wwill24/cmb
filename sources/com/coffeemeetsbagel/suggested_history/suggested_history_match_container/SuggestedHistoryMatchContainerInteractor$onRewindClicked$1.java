package com.coffeemeetsbagel.suggested_history.suggested_history_match_container;

import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import vb.a;

final class SuggestedHistoryMatchContainerInteractor$onRewindClicked$1 extends Lambda implements Function1<Optional<a>, Unit> {
    final /* synthetic */ SuggestedHistoryMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedHistoryMatchContainerInteractor$onRewindClicked$1(SuggestedHistoryMatchContainerInteractor suggestedHistoryMatchContainerInteractor) {
        super(1);
        this.this$0 = suggestedHistoryMatchContainerInteractor;
    }

    public final void a(Optional<a> optional) {
        if (optional.d()) {
            boolean z10 = true;
            if (!this.this$0.p2().a("OnePaidLike.Enabled.Android") || this.this$0.f37173f.getPairAction() == 1) {
                z10 = false;
            }
            ((h0) this.this$0.f7875e).G(z10);
            return;
        }
        ((SuggestedHistoryMatchContainerRouter) this.this$0.B1()).o();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Optional) obj);
        return Unit.f32013a;
    }
}
