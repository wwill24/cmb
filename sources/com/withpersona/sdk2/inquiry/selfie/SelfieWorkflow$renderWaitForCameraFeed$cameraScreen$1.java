package com.withpersona.sdk2.inquiry.selfie;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.selfie.Selfie;
import com.withpersona.sdk2.inquiry.selfie.SelfieState;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import com.withpersona.sdk2.inquiry.selfie.v;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SelfieWorkflow$renderWaitForCameraFeed$cameraScreen$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<SelfieWorkflow.b, SelfieState, SelfieWorkflow.c, Object>.a $context;
    final /* synthetic */ SelfieWorkflow.b $renderProps;
    final /* synthetic */ SelfieWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieWorkflow$renderWaitForCameraFeed$cameraScreen$1(h<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c, ? extends Object>.a aVar, SelfieWorkflow selfieWorkflow, SelfieWorkflow.b bVar) {
        super(0);
        this.$context = aVar;
        this.this$0 = selfieWorkflow;
        this.$renderProps = bVar;
    }

    public final void invoke() {
        f c10 = this.$context.c();
        SelfieWorkflow selfieWorkflow = this.this$0;
        final SelfieWorkflow.b bVar = this.$renderProps;
        c10.d(Workflows__StatefulWorkflowKt.d(selfieWorkflow, (String) null, new Function1<l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c, Unit>() {
            public final void a(l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c cVar) {
                List e10;
                j.g(cVar, "$this$action");
                v o10 = bVar.o();
                if (j.b(o10, v.b.f27436a)) {
                    e10 = q.m(Selfie.Direction.CENTER, Selfie.Direction.LEFT, Selfie.Direction.RIGHT);
                } else if (j.b(o10, v.a.f27435a)) {
                    e10 = p.e(Selfie.Direction.CENTER);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                cVar.e(new SelfieState.StartCapture(false, (SelfieError) null, e10, System.currentTimeMillis(), false, 19, (DefaultConstructorMarker) null));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }
}
