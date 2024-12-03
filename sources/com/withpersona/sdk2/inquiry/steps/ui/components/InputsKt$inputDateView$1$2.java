package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.e;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputMarginStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InputsKt$inputDateView$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.InputDate $component;
    final /* synthetic */ e $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputsKt$inputDateView$1$2(UiComponent.InputDate inputDate, e eVar) {
        super(0);
        this.$component = inputDate;
        this.$this_apply = eVar;
    }

    public final void invoke() {
        AttributeStyles$InputMarginStyle n10;
        StyleElements.DPMeasurementSet a10;
        StyleElements.DPSizeSet a11;
        UiComponent.InputDateComponentStyle D = this.$component.D();
        if (D != null && (n10 = D.n()) != null && (a10 = n10.a()) != null && (a11 = a10.a()) != null) {
            ConstraintLayout b10 = this.$this_apply.getRoot();
            j.f(b10, "root");
            cj.e.c(b10, a11);
        }
    }
}
