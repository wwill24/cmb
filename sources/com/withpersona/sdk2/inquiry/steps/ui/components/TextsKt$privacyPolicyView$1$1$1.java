package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.p;
import android.widget.TextView;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class TextsKt$privacyPolicyView$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.PrivacyPolicy $component;
    final /* synthetic */ p $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextsKt$privacyPolicyView$1$1$1(UiComponent.PrivacyPolicy privacyPolicy, p pVar) {
        super(0);
        this.$component = privacyPolicy;
        this.$this_apply = pVar;
    }

    public final void invoke() {
        TextBasedComponentStyle D = this.$component.D();
        if (D != null) {
            TextView textView = this.$this_apply.f24879b;
            j.f(textView, "textView");
            m.e(textView, D);
        }
    }
}
