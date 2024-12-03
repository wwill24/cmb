package com.coffeemeetsbagel.match_view;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MatchViewInteractor$didBecomeActive$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ MatchViewInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchViewInteractor$didBecomeActive$2(MatchViewInteractor matchViewInteractor) {
        super(1);
        this.this$0 = matchViewInteractor;
    }

    public final void a(Throwable th2) {
        j.f(th2, "throwable");
        a.f40771d.c("MatchViewInteractor", "Unable to display: " + this.this$0.f34625k, th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
