package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;

final class GovernmentIdWorkflow$renderScreen$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ GovernmentIdWorkflow.a $renderProps;
    final /* synthetic */ GovernmentIdState $renderState;
    final /* synthetic */ GovernmentIdWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$2(GovernmentIdWorkflow.a aVar, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar2, GovernmentIdWorkflow governmentIdWorkflow, GovernmentIdState governmentIdState) {
        super(0);
        this.$renderProps = aVar;
        this.$context = aVar2;
        this.this$0 = governmentIdWorkflow;
        this.$renderState = governmentIdState;
    }

    public final void invoke() {
        if (this.$renderProps.e().size() == 1) {
            GovernmentIdWorkflowUtilsKt.f(this.$context);
            return;
        }
        f c10 = this.$context.c();
        GovernmentIdWorkflow governmentIdWorkflow = this.this$0;
        final GovernmentIdState governmentIdState = this.$renderState;
        c10.d(Workflows__StatefulWorkflowKt.d(governmentIdWorkflow, (String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
            public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                j.g(cVar, "$this$action");
                cVar.e(GovernmentIdState.ShowInstructions.m((GovernmentIdState.ShowInstructions) governmentIdState, (IdPart) null, (List) null, (List) null, (GovernmentIdState) null, 0, (IdConfig) null, false, (String) null, Opcodes.IF_ICMPEQ, (Object) null));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }
}
