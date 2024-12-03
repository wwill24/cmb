package com.withpersona.sdk2.inquiry.selfie;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.selfie.SelfieState;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SelfieWorkflow$renderShowPoseHint$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<SelfieWorkflow.b, SelfieState, SelfieWorkflow.c, Object>.a $context;
    final /* synthetic */ SelfieState.ShowPoseHint $renderState;
    final /* synthetic */ SelfieWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieWorkflow$renderShowPoseHint$1(h<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c, ? extends Object>.a aVar, SelfieWorkflow selfieWorkflow, SelfieState.ShowPoseHint showPoseHint) {
        super(0);
        this.$context = aVar;
        this.this$0 = selfieWorkflow;
        this.$renderState = showPoseHint;
    }

    public final void invoke() {
        f c10 = this.$context.c();
        SelfieWorkflow selfieWorkflow = this.this$0;
        final SelfieState.ShowPoseHint showPoseHint = this.$renderState;
        c10.d(Workflows__StatefulWorkflowKt.d(selfieWorkflow, (String) null, new Function1<l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c, Unit>() {
            public final void a(l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c cVar) {
                j.g(cVar, "$this$action");
                cVar.e(new SelfieState.Capture(showPoseHint.g(), showPoseHint.f(), (SelfieError) null, System.currentTimeMillis(), showPoseHint.a(), 4, (DefaultConstructorMarker) null));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }
}
