package com.withpersona.sdk2.inquiry.steps.ui.components;

import android.view.View;
import android.view.ViewGroup;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class ComplexWidgetsKt$spacer$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.Spacer $component;
    final /* synthetic */ View $it;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComplexWidgetsKt$spacer$1$1(View view, UiComponent.Spacer spacer) {
        super(0);
        this.$it = view;
        this.$component = spacer;
    }

    public final void invoke() {
        ViewGroup.LayoutParams layoutParams = this.$it.getLayoutParams();
        UiComponent.Spacer spacer = this.$component;
        View view = this.$it;
        layoutParams.height = j.c(spacer.D(), 1);
        view.setLayoutParams(layoutParams);
    }
}
