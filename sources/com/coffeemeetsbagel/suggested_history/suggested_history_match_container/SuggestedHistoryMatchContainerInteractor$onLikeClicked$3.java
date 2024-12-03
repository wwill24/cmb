package com.coffeemeetsbagel.suggested_history.suggested_history_match_container;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SuggestedHistoryMatchContainerInteractor$onLikeClicked$3 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ SuggestedHistoryMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedHistoryMatchContainerInteractor$onLikeClicked$3(SuggestedHistoryMatchContainerInteractor suggestedHistoryMatchContainerInteractor) {
        super(1);
        this.this$0 = suggestedHistoryMatchContainerInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String Z1 = this.this$0.f37175h;
        j.f(th2, "it");
        aVar.c(Z1, "", th2);
        this.this$0.f37174g.onError();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
