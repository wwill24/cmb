package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.g;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.styling.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class StacksKt$stack$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.HorizontalStackComponentStyle $styles;
    final /* synthetic */ g $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StacksKt$stack$1$1(g gVar, UiComponent.HorizontalStackComponentStyle horizontalStackComponentStyle) {
        super(0);
        this.$this_apply = gVar;
        this.$styles = horizontalStackComponentStyle;
    }

    public final void invoke() {
        ConstraintLayout b10 = this.$this_apply.getRoot();
        j.f(b10, "root");
        d.c(b10, this.$styles);
    }
}
