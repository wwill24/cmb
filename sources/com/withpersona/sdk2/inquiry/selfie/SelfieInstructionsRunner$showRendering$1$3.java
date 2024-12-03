package com.withpersona.sdk2.inquiry.selfie;

import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class SelfieInstructionsRunner$showRendering$1$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SelfieWorkflow.Screen.a $rendering;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieInstructionsRunner$showRendering$1$3(SelfieWorkflow.Screen.a aVar) {
        super(0);
        this.$rendering = aVar;
    }

    public final void invoke() {
        this.$rendering.e().invoke();
    }
}
