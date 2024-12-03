package com.withpersona.sdk2.inquiry.selfie;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.selfie.Selfie;
import com.withpersona.sdk2.inquiry.selfie.SelfieState;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SelfieWorkflow$renderCapture$mode$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ h<SelfieWorkflow.b, SelfieState, SelfieWorkflow.c, Object>.a $context;
    final /* synthetic */ Selfie.Direction $direction;
    final /* synthetic */ SelfieWorkflow.b $renderProps;
    final /* synthetic */ SelfieState.Capture $renderState;
    final /* synthetic */ SelfieWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieWorkflow$renderCapture$mode$1(Selfie.Direction direction, h<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c, ? extends Object>.a aVar, SelfieWorkflow selfieWorkflow, SelfieState.Capture capture, SelfieWorkflow.b bVar) {
        super(1);
        this.$direction = direction;
        this.$context = aVar;
        this.this$0 = selfieWorkflow;
        this.$renderState = capture;
        this.$renderProps = bVar;
    }

    public final void a(String str) {
        j.g(str, "absolutePath");
        final Selfie.SelfieImage selfieImage = new Selfie.SelfieImage(str, Selfie.CaptureMethod.MANUAL, this.$direction);
        f c10 = this.$context.c();
        final SelfieWorkflow selfieWorkflow = this.this$0;
        final SelfieState.Capture capture = this.$renderState;
        final SelfieWorkflow.b bVar = this.$renderProps;
        c10.d(Workflows__StatefulWorkflowKt.d(selfieWorkflow, (String) null, new Function1<l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c, Unit>() {
            public final void a(l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c cVar) {
                j.g(cVar, "$this$action");
                cVar.e(selfieWorkflow.k(capture, bVar, selfieImage));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return Unit.f32013a;
    }
}
