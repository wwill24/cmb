package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.i;
import com.google.android.material.textfield.TextInputLayout;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.styling.TextInputLayoutStylingKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InputsKt$inputNumberView$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.InputNumber $component;
    final /* synthetic */ i $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputsKt$inputNumberView$1$2(UiComponent.InputNumber inputNumber, i iVar) {
        super(0);
        this.$component = inputNumber;
        this.$this_apply = iVar;
    }

    public final void invoke() {
        UiComponent.InputTextBasedComponentStyle F = this.$component.F();
        if (F != null) {
            TextInputLayout textInputLayout = this.$this_apply.f24862b;
            j.f(textInputLayout, "inputLayout");
            TextInputLayoutStylingKt.j(textInputLayout, F);
        }
    }
}
