package com.coffeemeetsbagel.deactivate;

import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.deactivate.g;
import com.coffeemeetsbagel.models.constants.Extra;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class DeactivateCompRouter$showPayItForward$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DeactivateCompRouter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeactivateCompRouter$showPayItForward$2(DeactivateCompRouter deactivateCompRouter) {
        super(0);
        this.this$0 = deactivateCompRouter;
    }

    public final void invoke() {
        this.this$0.r(q.m(new Pair(Extra.ON_HOLD_INDEFINITELY, Boolean.TRUE), new Pair(Extra.INPUT_REASON, ((g.a) this.this$0.e()).a().getString(R.string.hold_reason_met_someone_cmb))));
    }
}
