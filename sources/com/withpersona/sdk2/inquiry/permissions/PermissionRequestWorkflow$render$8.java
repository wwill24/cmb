package com.withpersona.sdk2.inquiry.permissions;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PermissionRequestWorkflow$render$8 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b, Object>.a $context;
    final /* synthetic */ PermissionRequestWorkflow.c $renderProps;
    final /* synthetic */ PermissionRequestWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PermissionRequestWorkflow$render$8(h<? super PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b, ? extends Object>.a aVar, PermissionRequestWorkflow permissionRequestWorkflow, PermissionRequestWorkflow.c cVar) {
        super(0);
        this.$context = aVar;
        this.this$0 = permissionRequestWorkflow;
        this.$renderProps = cVar;
    }

    public final void invoke() {
        f c10 = this.$context.c();
        final PermissionRequestWorkflow permissionRequestWorkflow = this.this$0;
        final PermissionRequestWorkflow.c cVar = this.$renderProps;
        c10.d(Workflows__StatefulWorkflowKt.d(permissionRequestWorkflow, (String) null, new Function1<l<? super PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, ? extends PermissionRequestWorkflow.b>.c, Unit>() {
            public final void a(l<? super PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b>.c cVar) {
                j.g(cVar, "$this$action");
                permissionRequestWorkflow.k(cVar, new PermissionState(cVar.b(), PermissionResult.PermissionRejected));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }
}
