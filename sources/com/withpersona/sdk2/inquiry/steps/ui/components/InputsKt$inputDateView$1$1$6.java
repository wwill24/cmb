package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.e;
import com.google.android.material.textfield.TextInputLayout;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.styling.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InputsKt$inputDateView$1$1$6 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.InputDate $component;
    final /* synthetic */ e $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputsKt$inputDateView$1$1$6(UiComponent.InputDate inputDate, e eVar) {
        super(0);
        this.$component = inputDate;
        this.$this_apply = eVar;
    }

    public final void invoke() {
        UiComponent.InputSelectComponentStyle i10;
        UiComponent.InputDateComponentStyle D = this.$component.D();
        if (D != null && (i10 = D.i()) != null) {
            TextInputLayout textInputLayout = this.$this_apply.f24851e;
            j.f(textInputLayout, "month");
            c.b(textInputLayout, i10);
        }
    }
}
