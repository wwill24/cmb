package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.c;
import com.google.android.material.textfield.TextInputLayout;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.styling.TextInputLayoutStylingKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InputsKt$inputAddressView$1$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.InputAddress $component;
    final /* synthetic */ c $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputsKt$inputAddressView$1$3(UiComponent.InputAddress inputAddress, c cVar) {
        super(0);
        this.$component = inputAddress;
        this.$this_apply = cVar;
    }

    public final void invoke() {
        UiComponent.InputTextBasedComponentStyle G = this.$component.G();
        if (G != null) {
            TextInputLayout textInputLayout = this.$this_apply.f24837c;
            j.f(textInputLayout, "addressField");
            TextInputLayoutStylingKt.j(textInputLayout, G);
        }
    }
}
