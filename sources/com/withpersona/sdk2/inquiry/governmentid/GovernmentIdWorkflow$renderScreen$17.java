package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.live_hint.Hint;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GovernmentIdWorkflow$renderScreen$17 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ GovernmentIdState $renderState;
    final /* synthetic */ GovernmentIdWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$17(h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar, GovernmentIdWorkflow governmentIdWorkflow, GovernmentIdState governmentIdState) {
        super(1);
        this.$context = aVar;
        this.this$0 = governmentIdWorkflow;
        this.$renderState = governmentIdState;
    }

    public final void a(final Throwable th2) {
        j.g(th2, "error");
        f c10 = this.$context.c();
        GovernmentIdWorkflow governmentIdWorkflow = this.this$0;
        final GovernmentIdState governmentIdState = this.$renderState;
        c10.d(Workflows__StatefulWorkflowKt.d(governmentIdWorkflow, (String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
            public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                GovernmentIdState.CountdownToCapture countdownToCapture;
                l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar2 = cVar;
                j.g(cVar2, "$this$action");
                Object c10 = cVar.c();
                if (c10 instanceof GovernmentIdState.CountdownToCapture) {
                    countdownToCapture = (GovernmentIdState.CountdownToCapture) c10;
                } else {
                    countdownToCapture = null;
                }
                if (countdownToCapture != null) {
                    cVar2.e(new GovernmentIdState.WaitForAutocapture(((GovernmentIdState.CountdownToCapture) governmentIdState).n(), governmentIdState.j(), ((GovernmentIdState.CountdownToCapture) governmentIdState).p(), GovernmentIdWorkflowUtilsKt.e((GovernmentIdWorkflow.a) cVar.b(), ((GovernmentIdState.CountdownToCapture) governmentIdState).n().a()), countdownToCapture.i(), countdownToCapture.h(), th2, GovernmentIdWorkflowUtilsKt.b(cVar2, false), false, false, (Hint) null, 1792, (DefaultConstructorMarker) null));
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
