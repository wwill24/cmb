package com.withpersona.sdk2.inquiry.governmentid.video_capture;

import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s0;

@d(c = "com.withpersona.sdk2.inquiry.governmentid.video_capture.VideoCaptureRenderer$renderFinalizeVideo$1", f = "VideoCaptureRenderer.kt", l = {34}, m = "invokeSuspend")
final class VideoCaptureRenderer$renderFinalizeVideo$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ GovernmentIdState.FinalizeVideo $renderState;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoCaptureRenderer$renderFinalizeVideo$1(GovernmentIdState.FinalizeVideo finalizeVideo, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar, c<? super VideoCaptureRenderer$renderFinalizeVideo$1> cVar) {
        super(2, cVar);
        this.$renderState = finalizeVideo;
        this.$context = aVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new VideoCaptureRenderer$renderFinalizeVideo$1(this.$renderState, this.$context, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((VideoCaptureRenderer$renderFinalizeVideo$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            long p10 = this.$renderState.p();
            this.label = 1;
            if (s0.a(p10, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$context.c().d(Workflows__WorkflowActionKt.c((String) null, AnonymousClass1.f26017a, 1, (Object) null));
        return Unit.f32013a;
    }
}
