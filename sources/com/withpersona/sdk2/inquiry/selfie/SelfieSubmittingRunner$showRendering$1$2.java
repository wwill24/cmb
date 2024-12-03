package com.withpersona.sdk2.inquiry.selfie;

import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class SelfieSubmittingRunner$showRendering$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SelfieWorkflow.Screen.b $rendering;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieSubmittingRunner$showRendering$1$2(SelfieWorkflow.Screen.b bVar) {
        super(0);
        this.$rendering = bVar;
    }

    public final void invoke() {
        this.$rendering.b().invoke();
    }
}
