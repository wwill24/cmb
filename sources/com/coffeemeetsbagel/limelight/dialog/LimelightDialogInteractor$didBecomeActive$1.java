package com.coffeemeetsbagel.limelight.dialog;

import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class LimelightDialogInteractor$didBecomeActive$1 extends Lambda implements Function1<Pair<? extends Integer, ? extends Integer>, Unit> {
    final /* synthetic */ LimelightDialogInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LimelightDialogInteractor$didBecomeActive$1(LimelightDialogInteractor limelightDialogInteractor) {
        super(1);
        this.this$0 = limelightDialogInteractor;
    }

    public final void a(Pair<Integer, Integer> pair) {
        if (pair.a().intValue() > 0) {
            ((LimelightDialogPresenter) this.this$0.f7875e).u();
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.f32013a;
    }
}
