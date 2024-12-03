package com.withpersona.sdk2.inquiry.selfie.view;

import com.withpersona.sdk2.inquiry.selfie.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class SelfieOverlayView$setState$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $onAnimationEnd;
    final /* synthetic */ SelfieOverlayView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieOverlayView$setState$1$2(SelfieOverlayView selfieOverlayView, Function0<Unit> function0) {
        super(0);
        this.this$0 = selfieOverlayView;
        this.$onAnimationEnd = function0;
    }

    public final void invoke() {
        SelfieOverlayView selfieOverlayView = this.this$0;
        selfieOverlayView.X(selfieOverlayView.F, k.pi2_selfie_capture_success, this.$onAnimationEnd);
    }
}
