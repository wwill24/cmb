package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.h;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InputsKt$inputCheckboxView$1$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.InputCheckbox $component;
    final /* synthetic */ h $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputsKt$inputCheckboxView$1$3(UiComponent.InputCheckbox inputCheckbox, h hVar) {
        super(0);
        this.$component = inputCheckbox;
        this.$this_apply = hVar;
    }

    public final void invoke() {
        UiComponent.InputCheckbox.InputCheckboxComponentStyle F = this.$component.F();
        if (F != null) {
            MaterialCheckBox materialCheckBox = this.$this_apply.f24860b;
            j.f(materialCheckBox, "checkbox");
            m.e(materialCheckBox, F.g());
        }
    }
}
