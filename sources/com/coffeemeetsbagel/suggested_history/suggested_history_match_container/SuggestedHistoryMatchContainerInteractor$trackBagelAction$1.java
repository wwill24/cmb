package com.coffeemeetsbagel.suggested_history.suggested_history_match_container;

import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import vb.a;

final class SuggestedHistoryMatchContainerInteractor$trackBagelAction$1 extends Lambda implements Function1<Optional<a>, Unit> {
    final /* synthetic */ String $bagelAction;
    final /* synthetic */ SuggestedHistoryMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedHistoryMatchContainerInteractor$trackBagelAction$1(SuggestedHistoryMatchContainerInteractor suggestedHistoryMatchContainerInteractor, String str) {
        super(1);
        this.this$0 = suggestedHistoryMatchContainerInteractor;
        this.$bagelAction = str;
    }

    public final void a(Optional<a> optional) {
        this.this$0.w2().a(optional.d(), this.this$0.f37173f, this.$bagelAction, "suggested_history");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Optional) obj);
        return Unit.f32013a;
    }
}
