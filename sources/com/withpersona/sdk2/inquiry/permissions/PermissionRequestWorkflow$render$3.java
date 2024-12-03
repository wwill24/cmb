package com.withpersona.sdk2.inquiry.permissions;

import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class PermissionRequestWorkflow$render$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b, Object>.a $context;
    final /* synthetic */ PermissionRequestWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PermissionRequestWorkflow$render$3(h<? super PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b, ? extends Object>.a aVar, PermissionRequestWorkflow permissionRequestWorkflow) {
        super(0);
        this.$context = aVar;
        this.this$0 = permissionRequestWorkflow;
    }

    public final void invoke() {
        this.$context.c().d(Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, AnonymousClass1.f27137a, 1, (Object) null));
    }
}
