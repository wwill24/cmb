package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.IdPart;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GovernmentIdWorkflow$renderScreen$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ GovernmentIdState $renderState;
    final /* synthetic */ GovernmentIdWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$5(h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar, GovernmentIdWorkflow governmentIdWorkflow, GovernmentIdState governmentIdState) {
        super(0);
        this.$context = aVar;
        this.this$0 = governmentIdWorkflow;
        this.$renderState = governmentIdState;
    }

    public final void invoke() {
        f c10 = this.$context.c();
        final GovernmentIdWorkflow governmentIdWorkflow = this.this$0;
        final GovernmentIdState governmentIdState = this.$renderState;
        c10.d(Workflows__StatefulWorkflowKt.d(governmentIdWorkflow, (String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
            public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                j.g(cVar, "$this$action");
                governmentIdWorkflow.f25510e.d();
                cVar.e(GovernmentIdState.ChooseCaptureMethod.m((GovernmentIdState.ChooseCaptureMethod) governmentIdState, (IdPart.SideIdPart) null, (List) null, (List) null, 0, (IdConfig) null, true, (GovernmentIdState) null, (String) null, 223, (Object) null));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }
}
