package com.coffeemeetsbagel.new_user_experience.match_prefs;

import c6.a;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class MatchPrefsInteractor$observeSubscriptionResults$1 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ MatchPrefsInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchPrefsInteractor$observeSubscriptionResults$1(MatchPrefsInteractor matchPrefsInteractor) {
        super(1);
        this.this$0 = matchPrefsInteractor;
    }

    public final void a(a aVar) {
        if (aVar.b() != 435345) {
            a.C0491a aVar2 = fa.a.f40771d;
            String R1 = this.this$0.f35133g;
            int b10 = aVar.b();
            aVar2.a(R1, "Unhandled request code " + b10);
        } else if (aVar.c() == 242) {
            ((h0) this.this$0.B1()).r();
            this.this$0.e2().e("Upsell Error Dialog Shown", h0.i());
        } else if (aVar.c() == -1) {
            this.this$0.p2(false);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((c6.a) obj);
        return Unit.f32013a;
    }
}
