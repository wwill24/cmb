package com.withpersona.sdk2.inquiry.selfie;

import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class SelfieWorkflow$renderCountdownToCapture$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<SelfieWorkflow.b, SelfieState, SelfieWorkflow.c, Object>.a $context;
    final /* synthetic */ SelfieWorkflow.b $renderProps;
    final /* synthetic */ SelfieWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieWorkflow$renderCountdownToCapture$4(SelfieWorkflow selfieWorkflow, h<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c, ? extends Object>.a aVar, SelfieWorkflow.b bVar) {
        super(0);
        this.this$0 = selfieWorkflow;
        this.$context = aVar;
        this.$renderProps = bVar;
    }

    public final void invoke() {
        SelfieWorkflowUtilsKt.b(this.this$0.f27275a, this.$context, this.$renderProps);
    }
}
