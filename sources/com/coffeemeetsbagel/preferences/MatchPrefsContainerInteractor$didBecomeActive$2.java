package com.coffeemeetsbagel.preferences;

import j5.x;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MatchPrefsContainerInteractor$didBecomeActive$2 extends Lambda implements Function1<x, Unit> {
    final /* synthetic */ MatchPrefsContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchPrefsContainerInteractor$didBecomeActive$2(MatchPrefsContainerInteractor matchPrefsContainerInteractor) {
        super(1);
        this.this$0 = matchPrefsContainerInteractor;
    }

    public final void a(x xVar) {
        j.g(xVar, "it");
        ((MatchPrefsContainerRouter) this.this$0.B1()).l();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((x) obj);
        return Unit.f32013a;
    }
}
