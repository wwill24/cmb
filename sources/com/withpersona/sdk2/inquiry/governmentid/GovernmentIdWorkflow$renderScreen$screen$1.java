package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.j;

/* synthetic */ class GovernmentIdWorkflow$renderScreen$screen$1 extends AdaptedFunctionReference implements Function1<IdConfig, Unit> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ GovernmentIdWorkflow.a $renderProps;
    final /* synthetic */ GovernmentIdState $renderState;
    final /* synthetic */ GovernmentIdWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$screen$1(GovernmentIdWorkflow.a aVar, GovernmentIdWorkflow governmentIdWorkflow, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar2, GovernmentIdState governmentIdState) {
        super(1, j.a.class, "selectIdClass", "renderScreen$selectIdClass(Lcom/withpersona/sdk2/inquiry/governmentid/GovernmentIdWorkflow$Input;Lcom/withpersona/sdk2/inquiry/governmentid/GovernmentIdWorkflow;Lcom/squareup/workflow1/StatefulWorkflow$RenderContext;Lcom/withpersona/sdk2/inquiry/governmentid/GovernmentIdState;Lcom/withpersona/sdk2/inquiry/governmentid/IdConfig;ZLjava/lang/Boolean;)V", 0);
        this.$renderProps = aVar;
        this.this$0 = governmentIdWorkflow;
        this.$context = aVar2;
        this.$renderState = governmentIdState;
    }

    public final void a(IdConfig idConfig) {
        j.g(idConfig, "p0");
        GovernmentIdWorkflow.C(this.$renderProps, this.this$0, this.$context, this.$renderState, idConfig, false, (Boolean) null, 96, (Object) null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((IdConfig) obj);
        return Unit.f32013a;
    }
}
