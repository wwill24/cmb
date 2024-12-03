package com.withpersona.sdk2.inquiry.steps.ui.components;

import com.google.android.material.button.MaterialButton;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.a;
import com.withpersona.sdk2.inquiry.steps.ui.styling.ButtonStylingKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class ButtonsKt$buttonView$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MaterialButton $button;
    final /* synthetic */ a $styles;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ButtonsKt$buttonView$1$1(MaterialButton materialButton, a aVar) {
        super(0);
        this.$button = materialButton;
        this.$styles = aVar;
    }

    public final void invoke() {
        ButtonStylingKt.c(this.$button, this.$styles, false, false, 6, (Object) null);
    }
}
