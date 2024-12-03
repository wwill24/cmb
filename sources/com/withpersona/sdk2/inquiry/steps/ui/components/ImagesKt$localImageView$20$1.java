package com.withpersona.sdk2.inquiry.steps.ui.components;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vi.e;

final class ImagesKt$localImageView$20$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ e $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImagesKt$localImageView$20$1(e eVar) {
        super(0);
        this.$this_apply = eVar;
    }

    public final void invoke() {
        ThemeableLottieAnimationView themeableLottieAnimationView = this.$this_apply.f33911b;
        j.f(themeableLottieAnimationView, "lottieView");
        ViewGroup.LayoutParams layoutParams = themeableLottieAnimationView.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams instanceof ConstraintLayout.b) {
                ((ConstraintLayout.b) layoutParams).V = 0.5f;
            }
            themeableLottieAnimationView.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
