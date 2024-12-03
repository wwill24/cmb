package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.live_hint.Hint;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GovernmentIdWorkflow$renderScreen$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ GovernmentIdWorkflow.a $renderProps;
    final /* synthetic */ GovernmentIdState $renderState;
    final /* synthetic */ GovernmentIdWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$4(h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar, GovernmentIdWorkflow governmentIdWorkflow, GovernmentIdState governmentIdState, GovernmentIdWorkflow.a aVar2) {
        super(0);
        this.$context = aVar;
        this.this$0 = governmentIdWorkflow;
        this.$renderState = governmentIdState;
        this.$renderProps = aVar2;
    }

    public final void invoke() {
        f c10 = this.$context.c();
        GovernmentIdWorkflow governmentIdWorkflow = this.this$0;
        final GovernmentIdState governmentIdState = this.$renderState;
        final GovernmentIdWorkflow.a aVar = this.$renderProps;
        c10.d(Workflows__StatefulWorkflowKt.d(governmentIdWorkflow, (String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
            public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                GovernmentIdState.ChooseCaptureMethod chooseCaptureMethod;
                l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar2 = cVar;
                j.g(cVar2, "$this$action");
                Object c10 = cVar.c();
                if (c10 instanceof GovernmentIdState.ChooseCaptureMethod) {
                    chooseCaptureMethod = (GovernmentIdState.ChooseCaptureMethod) c10;
                } else {
                    chooseCaptureMethod = null;
                }
                if (chooseCaptureMethod != null) {
                    cVar2.e(new GovernmentIdState.WaitForAutocapture(((GovernmentIdState.ChooseCaptureMethod) governmentIdState).o(), governmentIdState.j(), ((GovernmentIdState.ChooseCaptureMethod) governmentIdState).p(), GovernmentIdWorkflowUtilsKt.e(aVar, ((GovernmentIdState.ChooseCaptureMethod) governmentIdState).o().a()), chooseCaptureMethod.i(), chooseCaptureMethod.h(), (Throwable) null, GovernmentIdWorkflowUtilsKt.c(cVar2, false, 1, (Object) null), false, false, (Hint) null, 1856, (DefaultConstructorMarker) null));
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }
}
