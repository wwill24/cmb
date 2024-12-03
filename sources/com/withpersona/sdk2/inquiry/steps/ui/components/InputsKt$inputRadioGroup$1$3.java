package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.k;
import android.widget.TextView;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InputsKt$inputRadioGroup$1$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.InputRadioGroup $component;
    final /* synthetic */ k $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputsKt$inputRadioGroup$1$3(UiComponent.InputRadioGroup inputRadioGroup, k kVar) {
        super(0);
        this.$component = inputRadioGroup;
        this.$this_apply = kVar;
    }

    public final void invoke() {
        TextBasedComponentStyle j10;
        UiComponent.InputRadioGroup.InputRadioGroupComponentStyle F = this.$component.F();
        if (F != null && (j10 = F.j()) != null) {
            TextView textView = this.$this_apply.f24868d;
            j.f(textView, "radioGroupLabel");
            m.e(textView, j10);
        }
    }
}
