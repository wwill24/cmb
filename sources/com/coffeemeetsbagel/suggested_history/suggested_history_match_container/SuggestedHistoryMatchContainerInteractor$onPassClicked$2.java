package com.coffeemeetsbagel.suggested_history.suggested_history_match_container;

import com.coffeemeetsbagel.models.Bagel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SuggestedHistoryMatchContainerInteractor$onPassClicked$2 extends Lambda implements Function1<Bagel, Unit> {
    final /* synthetic */ SuggestedHistoryMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedHistoryMatchContainerInteractor$onPassClicked$2(SuggestedHistoryMatchContainerInteractor suggestedHistoryMatchContainerInteractor) {
        super(1);
        this.this$0 = suggestedHistoryMatchContainerInteractor;
    }

    public final void a(Bagel bagel) {
        d X1 = this.this$0.f37174g;
        String profileId = this.this$0.f37173f.getProfileId();
        j.f(profileId, "bagel.profileId");
        X1.a(profileId);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Bagel) obj);
        return Unit.f32013a;
    }
}
