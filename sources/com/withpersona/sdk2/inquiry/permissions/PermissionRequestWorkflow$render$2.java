package com.withpersona.sdk2.inquiry.permissions;

import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PermissionRequestWorkflow$render$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ h<PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b, Object>.a $context;
    final /* synthetic */ PermissionRequestWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PermissionRequestWorkflow$render$2(h<? super PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b, ? extends Object>.a aVar, PermissionRequestWorkflow permissionRequestWorkflow) {
        super(1);
        this.$context = aVar;
        this.this$0 = permissionRequestWorkflow;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.f32013a;
    }

    public final void invoke(final boolean z10) {
        this.$context.c().d(Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, new Function1<l<? super PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, ? extends PermissionRequestWorkflow.b>.c, Unit>() {
            public final void a(l<? super PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b>.c cVar) {
                j.g(cVar, "$this$action");
                if (z10) {
                    cVar.e(PermissionRequestWorkflow.PermissionRequestState.ShowRequestPermissionRationale.f27127a);
                } else {
                    cVar.e(PermissionRequestWorkflow.PermissionRequestState.RequestPermission.f27125a);
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }
}
