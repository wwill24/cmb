package com.withpersona.sdk2.inquiry.selfie.view;

import android.view.View;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import si.c;

final class SelfieOverlayView$switchAnimation$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $onAnimationEnd;
    final /* synthetic */ c $this_switchAnimation;
    final /* synthetic */ SelfieOverlayView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieOverlayView$switchAnimation$1$1$1(SelfieOverlayView selfieOverlayView, c cVar, Function0<Unit> function0) {
        super(0);
        this.this$0 = selfieOverlayView;
        this.$this_switchAnimation = cVar;
        this.$onAnimationEnd = function0;
    }

    /* access modifiers changed from: private */
    public static final void c(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void invoke() {
        SelfieOverlayView selfieOverlayView = this.this$0;
        ThemeableLottieAnimationView themeableLottieAnimationView = this.$this_switchAnimation.f33831d;
        j.f(themeableLottieAnimationView, "hintAnimation");
        SelfieOverlayView.K(selfieOverlayView, themeableLottieAnimationView, 0, 1, (Object) null).withEndAction(new i(this.$onAnimationEnd));
        SelfieOverlayView selfieOverlayView2 = this.this$0;
        View view = this.$this_switchAnimation.f33833f;
        j.f(view, "hintOverlayView");
        SelfieOverlayView.K(selfieOverlayView2, view, 0, 1, (Object) null);
    }
}
