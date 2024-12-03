package com.coffeemeetsbagel.preferences;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MatchPrefsContainerInteractor$didBecomeActive$3 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ MatchPrefsContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchPrefsContainerInteractor$didBecomeActive$3(MatchPrefsContainerInteractor matchPrefsContainerInteractor) {
        super(1);
        this.this$0 = matchPrefsContainerInteractor;
    }

    public final void a(String str) {
        j.g(str, "message");
        ((MatchPrefsContainerRouter) this.this$0.B1()).o(str);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return Unit.f32013a;
    }
}
