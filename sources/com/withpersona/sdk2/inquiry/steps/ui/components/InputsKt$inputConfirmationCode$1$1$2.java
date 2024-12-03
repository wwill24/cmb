package com.withpersona.sdk2.inquiry.steps.ui.components;

import android.widget.EditText;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class InputsKt$inputConfirmationCode$1$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ EditText $previousEditTextOrNull;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputsKt$inputConfirmationCode$1$1$2(EditText editText) {
        super(0);
        this.$previousEditTextOrNull = editText;
    }

    public final void invoke() {
        this.$previousEditTextOrNull.requestFocus();
    }
}
