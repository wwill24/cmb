package com.withpersona.sdk2.inquiry.steps.ui.styling;

import com.google.android.material.textfield.TextInputLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class TextInputLayoutStylingKt$style$2$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ int $baseColor;
    final /* synthetic */ int $disabledColor;
    final /* synthetic */ int $focusedColor;
    final /* synthetic */ TextInputLayout $this_style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextInputLayoutStylingKt$style$2$1(TextInputLayout textInputLayout, int i10, int i11, int i12) {
        super(1);
        this.$this_style = textInputLayout;
        this.$baseColor = i10;
        this.$focusedColor = i11;
        this.$disabledColor = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.f32013a;
    }

    public final void invoke(boolean z10) {
        CharSequence error = this.$this_style.getError();
        boolean z11 = true;
        if (error == null || !t.a1(error)) {
            z11 = false;
        }
        if (!z11) {
            TextInputLayoutStylingKt.h(this.$this_style, z10, this.$baseColor, this.$focusedColor, this.$disabledColor);
        }
    }
}
