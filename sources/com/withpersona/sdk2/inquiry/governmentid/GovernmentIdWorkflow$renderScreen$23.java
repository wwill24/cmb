package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class GovernmentIdWorkflow$renderScreen$23 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ GovernmentIdWorkflow.a $renderProps;
    final /* synthetic */ GovernmentIdState $renderState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$23(GovernmentIdState governmentIdState, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar, GovernmentIdWorkflow.a aVar2) {
        super(0);
        this.$renderState = governmentIdState;
        this.$context = aVar;
        this.$renderProps = aVar2;
    }

    public final void invoke() {
        GovernmentIdState governmentIdState = this.$renderState;
        GovernmentIdWorkflowUtilsKt.i(governmentIdState, this.$context, this.$renderProps, ((GovernmentIdState.ReviewSelectedImage) governmentIdState).q(), ((GovernmentIdState.ReviewSelectedImage) this.$renderState).p(), false, (List) null, 0, 224, (Object) null);
    }
}
