package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.j;
import com.google.android.material.textfield.TextInputLayout;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.styling.TextInputLayoutStylingKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class InputsKt$inputPhoneNumberView$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.InputPhoneNumber $component;
    final /* synthetic */ j $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputsKt$inputPhoneNumberView$1$2(UiComponent.InputPhoneNumber inputPhoneNumber, j jVar) {
        super(0);
        this.$component = inputPhoneNumber;
        this.$this_apply = jVar;
    }

    public final void invoke() {
        UiComponent.InputTextBasedComponentStyle F = this.$component.F();
        if (F != null) {
            TextInputLayout textInputLayout = this.$this_apply.f24864b;
            kotlin.jvm.internal.j.f(textInputLayout, "inputLayout");
            TextInputLayoutStylingKt.j(textInputLayout, F);
        }
    }
}
