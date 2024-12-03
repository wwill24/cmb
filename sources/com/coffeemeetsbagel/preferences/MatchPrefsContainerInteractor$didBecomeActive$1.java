package com.coffeemeetsbagel.preferences;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MatchPrefsContainerInteractor$didBecomeActive$1 extends Lambda implements Function1<Map<String, ? extends String>, Unit> {
    final /* synthetic */ MatchPrefsContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchPrefsContainerInteractor$didBecomeActive$1(MatchPrefsContainerInteractor matchPrefsContainerInteractor) {
        super(1);
        this.this$0 = matchPrefsContainerInteractor;
    }

    public final void a(Map<String, String> map) {
        j.g(map, "trackingMap");
        ((MatchPrefsContainerRouter) this.this$0.B1()).l();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Map) obj);
        return Unit.f32013a;
    }
}
