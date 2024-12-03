package com.coffeemeetsbagel.today_view.card.actioncards;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ActionCardInteractor$handleSuccess$3 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ ActionCardInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActionCardInteractor$handleSuccess$3(ActionCardInteractor actionCardInteractor) {
        super(1);
        this.this$0 = actionCardInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        j.f(th2, "it");
        aVar.c("ActionCardInteractor", "couldn't show Like Pass Flow due to visibility issue", th2);
        ((a0) this.this$0.B1()).u();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
