package com.skydoves.balloon;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class Balloon$dismiss$dismissWindow$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Balloon this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Balloon$dismiss$dismissWindow$1(Balloon balloon) {
        super(0);
        this.this$0 = balloon;
    }

    public final void invoke() {
        this.this$0.f22674g = false;
        this.this$0.R().dismiss();
        this.this$0.a0().dismiss();
        this.this$0.V().removeCallbacks(this.this$0.O());
    }
}
