package com.withpersona.sdk2.inquiry.ui;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SignatureBottomSheetController$show$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.ESignature $component;
    final /* synthetic */ SignatureBottomSheetController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignatureBottomSheetController$show$1(SignatureBottomSheetController signatureBottomSheetController, UiComponent.ESignature eSignature) {
        super(0);
        this.this$0 = signatureBottomSheetController;
        this.$component = eSignature;
    }

    public final void invoke() {
        BottomSheetBehavior k02 = BottomSheetBehavior.k0(this.this$0.l().f29609k);
        j.f(k02, "from(binding.signatureSheet)");
        k02.Q0(3);
        UiComponent.ESignatureComponentStyle F = this.$component.F();
        if (F != null) {
            this.this$0.j(F);
        }
    }
}
