package com.withpersona.sdk2.inquiry.selfie;

import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class SelfieWorkflow$renderShowPoseHint$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<SelfieWorkflow.b, SelfieState, SelfieWorkflow.c, Object>.a $context;
    final /* synthetic */ SelfieWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieWorkflow$renderShowPoseHint$2(h<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c, ? extends Object>.a aVar, SelfieWorkflow selfieWorkflow) {
        super(0);
        this.$context = aVar;
        this.this$0 = selfieWorkflow;
    }

    public final void invoke() {
        this.$context.c().d(Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, AnonymousClass1.f27386a, 1, (Object) null));
    }
}
