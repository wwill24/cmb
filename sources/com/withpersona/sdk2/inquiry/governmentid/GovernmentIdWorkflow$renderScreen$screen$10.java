package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class GovernmentIdWorkflow$renderScreen$screen$10 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ GovernmentIdWorkflow.a $renderProps;
    final /* synthetic */ GovernmentIdWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$screen$10(GovernmentIdWorkflow governmentIdWorkflow, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar, GovernmentIdWorkflow.a aVar2) {
        super(0);
        this.this$0 = governmentIdWorkflow;
        this.$context = aVar;
        this.$renderProps = aVar2;
    }

    public final void invoke() {
        GovernmentIdWorkflowUtilsKt.g(this.this$0.f25506a, this.$context, this.$renderProps);
    }
}
