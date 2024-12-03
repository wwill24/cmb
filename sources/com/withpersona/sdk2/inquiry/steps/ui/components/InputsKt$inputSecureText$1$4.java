package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.q;
import com.google.android.material.textfield.TextInputLayout;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.styling.TextInputLayoutStylingKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InputsKt$inputSecureText$1$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.InputMaskedText $component;
    final /* synthetic */ q $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputsKt$inputSecureText$1$4(UiComponent.InputMaskedText inputMaskedText, q qVar) {
        super(0);
        this.$component = inputMaskedText;
        this.$this_apply = qVar;
    }

    public final void invoke() {
        UiComponent.InputTextBasedComponentStyle F = this.$component.F();
        if (F != null) {
            TextInputLayout b10 = this.$this_apply.getRoot();
            j.f(b10, "root");
            TextInputLayoutStylingKt.j(b10, F);
        }
    }
}
