package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class GovernmentIdWorkflow$renderScreen$positiveButtonClick$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ GovernmentIdWorkflow.a $renderProps;
    final /* synthetic */ GovernmentIdState $renderState;
    final /* synthetic */ IdConfig $selectedIdClass;
    final /* synthetic */ GovernmentIdWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$positiveButtonClick$1(IdConfig idConfig, GovernmentIdWorkflow.a aVar, GovernmentIdWorkflow governmentIdWorkflow, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar2, GovernmentIdState governmentIdState) {
        super(0);
        this.$selectedIdClass = idConfig;
        this.$renderProps = aVar;
        this.this$0 = governmentIdWorkflow;
        this.$context = aVar2;
        this.$renderState = governmentIdState;
    }

    public final void invoke() {
        GovernmentIdWorkflow.B(this.$renderProps, this.this$0, this.$context, this.$renderState, this.$selectedIdClass, false, Boolean.TRUE);
    }
}
