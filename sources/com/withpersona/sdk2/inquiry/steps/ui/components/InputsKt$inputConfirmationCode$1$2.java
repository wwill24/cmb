package com.withpersona.sdk2.inquiry.steps.ui.components;

import com.google.android.material.textfield.TextInputLayout;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.styling.TextInputLayoutStylingKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class InputsKt$inputConfirmationCode$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.InputConfirmationCode $component;
    final /* synthetic */ TextInputLayout $inputLayout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputsKt$inputConfirmationCode$1$2(UiComponent.InputConfirmationCode inputConfirmationCode, TextInputLayout textInputLayout) {
        super(0);
        this.$component = inputConfirmationCode;
        this.$inputLayout = textInputLayout;
    }

    public final void invoke() {
        UiComponent.InputTextBasedComponentStyle F = this.$component.F();
        if (F != null) {
            TextInputLayoutStylingKt.j(this.$inputLayout, F);
        }
    }
}
