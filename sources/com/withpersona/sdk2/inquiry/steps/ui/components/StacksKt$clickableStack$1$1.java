package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.d;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class StacksKt$clickableStack$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.ClickableStackComponentStyle $styles;
    final /* synthetic */ d $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StacksKt$clickableStack$1$1(d dVar, UiComponent.ClickableStackComponentStyle clickableStackComponentStyle) {
        super(0);
        this.$this_apply = dVar;
        this.$styles = clickableStackComponentStyle;
    }

    public final void invoke() {
        ConstraintLayout b10 = this.$this_apply.getRoot();
        j.f(b10, "root");
        com.withpersona.sdk2.inquiry.steps.ui.styling.d.b(b10, this.$styles);
    }
}
