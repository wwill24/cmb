package com.withpersona.sdk2.inquiry.steps.ui.components;

import cj.b;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class ButtonsKt$buttonViewWithLoadingIndicator$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ b $button;
    final /* synthetic */ a $styles;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ButtonsKt$buttonViewWithLoadingIndicator$1$1(b bVar, a aVar) {
        super(0);
        this.$button = bVar;
        this.$styles = aVar;
    }

    public final void invoke() {
        ButtonsKt.e(this.$button, this.$styles);
    }
}
