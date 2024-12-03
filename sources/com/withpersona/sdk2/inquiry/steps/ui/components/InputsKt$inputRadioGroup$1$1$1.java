package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.a;
import aj.k;
import android.content.res.ColorStateList;
import android.widget.TextView;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;

final class InputsKt$inputRadioGroup$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.InputRadioGroup $component;
    final /* synthetic */ a $this_apply;
    final /* synthetic */ k $this_apply$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputsKt$inputRadioGroup$1$1$1(UiComponent.InputRadioGroup inputRadioGroup, a aVar, k kVar) {
        super(0);
        this.$component = inputRadioGroup;
        this.$this_apply = aVar;
        this.$this_apply$1 = kVar;
    }

    public final void invoke() {
        TextBasedComponentStyle a10;
        TextBasedComponentStyle j10;
        UiComponent.InputRadioGroup.InputRadioGroupComponentStyle F = this.$component.F();
        if (!(F == null || (j10 = F.j()) == null)) {
            MaterialRadioButton b10 = this.$this_apply.getRoot();
            j.f(b10, "root");
            m.e(b10, j10);
        }
        UiComponent.InputRadioGroup.InputRadioGroupComponentStyle F2 = this.$component.F();
        if (!(F2 == null || (a10 = F2.a()) == null)) {
            TextView textView = this.$this_apply$1.f24867c;
            j.f(textView, "radioGroupError");
            m.e(textView, a10);
        }
        this.$this_apply.getRoot().setButtonTintList(ColorStateList.valueOf(androidx.core.graphics.a.l(this.$this_apply.getRoot().getCurrentTextColor(), Opcodes.FCMPG)));
    }
}
