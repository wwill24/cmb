package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.n;
import com.google.android.material.textfield.TextInputLayout;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.styling.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ComplexWidgetsKt$inputSelectView$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.InputSelect $component;
    final /* synthetic */ n $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComplexWidgetsKt$inputSelectView$1$2(UiComponent.InputSelect inputSelect, n nVar) {
        super(0);
        this.$component = inputSelect;
        this.$this_apply = nVar;
    }

    public final void invoke() {
        UiComponent.InputSelectComponentStyle b10 = this.$component.b();
        if (b10 != null) {
            TextInputLayout textInputLayout = this.$this_apply.f24875b;
            j.f(textInputLayout, "listSelector");
            c.b(textInputLayout, b10);
        }
    }
}
