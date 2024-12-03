package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.k;
import android.widget.LinearLayout;
import cj.e;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InputsKt$inputRadioGroup$1$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.InputRadioGroup $component;
    final /* synthetic */ k $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputsKt$inputRadioGroup$1$4(UiComponent.InputRadioGroup inputRadioGroup, k kVar) {
        super(0);
        this.$component = inputRadioGroup;
        this.$this_apply = kVar;
    }

    public final void invoke() {
        StyleElements.DPSizeSet i10;
        UiComponent.InputRadioGroup.InputRadioGroupComponentStyle F = this.$component.F();
        if (F != null && (i10 = F.i()) != null) {
            LinearLayout b10 = this.$this_apply.getRoot();
            j.f(b10, "root");
            e.c(b10, i10);
        }
    }
}
