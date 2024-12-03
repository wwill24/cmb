package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.h;
import com.squareup.workflow1.ui.modal.AlertScreen;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GovernmentIdWorkflow$renderScreen$12 extends Lambda implements Function1<AlertScreen.a, Unit> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ GovernmentIdWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$12(h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar, GovernmentIdWorkflow governmentIdWorkflow) {
        super(1);
        this.$context = aVar;
        this.this$0 = governmentIdWorkflow;
    }

    public final void a(AlertScreen.a aVar) {
        j.g(aVar, "it");
        this.$context.c().d(Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, AnonymousClass1.f25638a, 1, (Object) null));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((AlertScreen.a) obj);
        return Unit.f32013a;
    }
}
