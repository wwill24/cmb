package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.c;
import android.widget.TextView;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InputsKt$inputAddressView$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.InputAddress $component;
    final /* synthetic */ c $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputsKt$inputAddressView$1$2(UiComponent.InputAddress inputAddress, c cVar) {
        super(0);
        this.$component = inputAddress;
        this.$this_apply = cVar;
    }

    public final void invoke() {
        UiComponent.InputTextBasedComponentStyle G = this.$component.G();
        if (G != null) {
            TextView textView = this.$this_apply.f24839e;
            j.f(textView, "addressLabel");
            m.e(textView, G.M());
        }
    }
}
