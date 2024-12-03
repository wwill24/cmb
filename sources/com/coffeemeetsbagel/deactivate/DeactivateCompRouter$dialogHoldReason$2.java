package com.coffeemeetsbagel.deactivate;

import com.coffeemeetsbagel.dialogs.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class DeactivateCompRouter$dialogHoldReason$2 extends Lambda implements Function0<r> {
    final /* synthetic */ DeactivateCompInteractor $interactor;
    final /* synthetic */ DeactivateCompRouter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeactivateCompRouter$dialogHoldReason$2(DeactivateCompInteractor deactivateCompInteractor, DeactivateCompRouter deactivateCompRouter) {
        super(0);
        this.$interactor = deactivateCompInteractor;
        this.this$0 = deactivateCompRouter;
    }

    /* renamed from: a */
    public final r invoke() {
        return new r(this.$interactor, this.this$0.f12005f);
    }
}
