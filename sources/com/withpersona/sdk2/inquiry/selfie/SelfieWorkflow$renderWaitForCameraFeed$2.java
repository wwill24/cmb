package com.withpersona.sdk2.inquiry.selfie;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorkflow;
import com.withpersona.sdk2.inquiry.permissions.PermissionResult;
import com.withpersona.sdk2.inquiry.selfie.SelfieState;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SelfieWorkflow$renderWaitForCameraFeed$2 extends Lambda implements Function1<PermissionRequestWorkflow.b, l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>> {
    final /* synthetic */ SelfieWorkflow.b $renderProps;
    final /* synthetic */ SelfieState.WaitForCameraFeed $renderState;
    final /* synthetic */ SelfieWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieWorkflow$renderWaitForCameraFeed$2(SelfieWorkflow selfieWorkflow, SelfieState.WaitForCameraFeed waitForCameraFeed, SelfieWorkflow.b bVar) {
        super(1);
        this.this$0 = selfieWorkflow;
        this.$renderState = waitForCameraFeed;
        this.$renderProps = bVar;
    }

    /* renamed from: a */
    public final l<SelfieWorkflow.b, SelfieState, SelfieWorkflow.c> invoke(final PermissionRequestWorkflow.b bVar) {
        j.g(bVar, "it");
        SelfieWorkflow selfieWorkflow = this.this$0;
        final SelfieState.WaitForCameraFeed waitForCameraFeed = this.$renderState;
        final SelfieWorkflow.b bVar2 = this.$renderProps;
        return Workflows__StatefulWorkflowKt.d(selfieWorkflow, (String) null, new Function1<l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c, Unit>() {
            public final void a(l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c cVar) {
                j.g(cVar, "$this$action");
                if (bVar.a().a() == PermissionResult.PermissionGranted) {
                    cVar.e(SelfieState.WaitForCameraFeed.i(waitForCameraFeed, false, true, 1, (Object) null));
                } else if (!bVar2.q()) {
                    cVar.e(new SelfieState.ShowInstructions());
                } else if (bVar2.a()) {
                    cVar.d(SelfieWorkflow.c.a.f27369a);
                } else {
                    cVar.d(new SelfieWorkflow.c.C0329c(new InternalErrorInfo.PermissionErrorInfo("User rejected camera permissions for the selfie flow.")));
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null);
    }
}
