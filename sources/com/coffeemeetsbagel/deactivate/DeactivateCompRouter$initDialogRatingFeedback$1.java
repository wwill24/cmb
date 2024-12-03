package com.coffeemeetsbagel.deactivate;

import j5.x;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class DeactivateCompRouter$initDialogRatingFeedback$1 extends Lambda implements Function1<x, Unit> {
    final /* synthetic */ DeactivateCompRouter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeactivateCompRouter$initDialogRatingFeedback$1(DeactivateCompRouter deactivateCompRouter) {
        super(1);
        this.this$0 = deactivateCompRouter;
    }

    public final void a(x xVar) {
        ((DeactivateCompInteractor) this.this$0.f()).f2();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((x) obj);
        return Unit.f32013a;
    }
}
