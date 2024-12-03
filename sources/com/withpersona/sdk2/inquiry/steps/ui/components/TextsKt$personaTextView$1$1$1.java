package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.s;
import android.widget.TextView;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class TextsKt$personaTextView$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.Text $component;
    final /* synthetic */ s $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextsKt$personaTextView$1$1$1(UiComponent.Text text, s sVar) {
        super(0);
        this.$component = text;
        this.$this_apply = sVar;
    }

    public final void invoke() {
        TextBasedComponentStyle D = this.$component.D();
        if (D != null) {
            TextView textView = this.$this_apply.f24889b;
            j.f(textView, "textView");
            m.e(textView, D);
        }
    }
}
