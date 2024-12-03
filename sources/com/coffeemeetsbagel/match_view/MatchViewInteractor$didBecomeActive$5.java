package com.coffeemeetsbagel.match_view;

import c6.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class MatchViewInteractor$didBecomeActive$5 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ MatchViewInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchViewInteractor$didBecomeActive$5(MatchViewInteractor matchViewInteractor) {
        super(1);
        this.this$0 = matchViewInteractor;
    }

    public final void a(a aVar) {
        if (aVar.b() == 435345 && aVar.c() == 242) {
            ((u0) this.this$0.B1()).o();
            this.this$0.x2().d("Upsell Error Dialog Shown");
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((a) obj);
        return Unit.f32013a;
    }
}
